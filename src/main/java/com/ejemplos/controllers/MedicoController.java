package com.ejemplos.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//
import com.ejemplos.DTO.MedicoDTO;
import com.ejemplos.models.dao.IMedicoDao;
import com.ejemplos.models.entity.Medico;
import com.ejemplos.models.exceptions.AlreadyExistsException;
import com.ejemplos.models.exceptions.BadInputException;
import com.ejemplos.models.exceptions.NotFoundException;
import com.ejemplos.models.service.IMedicoService;
import com.ejemplos.models.service.MedicoServiceImpl;

@RestController
//@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoServiceImpl medicoServiceImpl;

	@Autowired
	private IMedicoService medicoService;

	@Autowired
	private IMedicoDao medicoRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicoController.class);

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedicoDTO> guardarMedico(@RequestBody MedicoDTO medicoNewDTO) {
		MedicoDTO medicoDTO = new MedicoDTO();
		LOGGER.info("Init MedicoController: save");
		try {
			medicoDTO = this.medicoService.altaMedico(medicoNewDTO);
		} catch (BadInputException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			medicoDTO.setValidaciones(e.getMessage());
			return new ResponseEntity<>(medicoDTO, HttpStatus.BAD_REQUEST);
		} catch (AlreadyExistsException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			medicoDTO.setValidaciones(e.getMessage());
			return new ResponseEntity<>(medicoDTO, HttpStatus.BAD_REQUEST);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			medicoDTO.setValidaciones("Error al encriptar la contraseña");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End MedicoController: save");
		return new ResponseEntity<>(medicoDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/sinAuditorias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MedicoDTO>> medicosSinAuditoriasPendientes() {
		List<MedicoDTO> medicosSinAuditorias;
//		try {
		medicosSinAuditorias = this.medicoService.medicosSinAuditoriasPendientes();
//		} catch (BadInputException e) {
//			//LOGGER.error(e.getLocalizedMessage(), e);
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		} catch (AlreadyExistsException e) {
//			//LOGGER.error(e.getLocalizedMessage(), e);
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		} catch (Exception e) {
//			//LOGGER.error(e.getLocalizedMessage(), e);
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		return new ResponseEntity<>(medicosSinAuditorias, HttpStatus.OK);
	}

	@PutMapping(value = "/baja/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedicoDTO> darBajaMedico(@PathVariable("id") Long id) {
		LOGGER.info("Init MedicoController: baja");
		Optional<Medico> medico = this.medicoRepository.findById(id);
		MedicoDTO medicoDTO = new MedicoDTO();
		if (!medico.isPresent()) {
			LOGGER.info("Médico no encontrado");
			medicoDTO.setValidaciones("Médico no encontrado");
			return new ResponseEntity<>(medicoDTO, HttpStatus.NOT_FOUND);

		}

		medicoDTO = this.medicoService.bajaMedico(medico);
		LOGGER.info("End MedicoController: baja");
		return new ResponseEntity<>(medicoDTO, HttpStatus.OK);

	}

	@GetMapping(value = "/perfil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedicoDTO> datosPerfil(@PathVariable("id") Long id) {
		LOGGER.info("Init MedicoController: perfil");
		MedicoDTO medicoDTO = new MedicoDTO();
		try {
			medicoDTO = this.medicoService.perfil(id);
		} catch (NotFoundException e) {
			LOGGER.error("Exception: NotFound");
			medicoDTO.setValidaciones(e.getMessage());
			return new ResponseEntity<>(medicoDTO, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End MedicoController: perfil");
		return new ResponseEntity<>(medicoDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedicoDTO> update(@RequestBody(required = true) MedicoDTO medicoDTO) {
		LOGGER.info("Init MedicoController: update");

		MedicoDTO medicoActualizado;
		try {
			medicoActualizado = this.medicoService.updatePerfil(medicoDTO);
		} catch (BadInputException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (AlreadyExistsException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (NotFoundException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End MedicoController: update");
		return new ResponseEntity<>(medicoActualizado, HttpStatus.OK);

	}

	// Búsqueda por filtros de médicos activos
	@PostMapping("/search")
	public ResponseEntity<List<Medico>> getMedicosActivosByFilter(@RequestBody MedicoDTO medicoDTO) {
		List<Medico> medicos=new ArrayList<>();
		
		try {
			medicos = medicoServiceImpl.medicosActivosFilter(medicoDTO);
			

		} catch (BadInputException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(medicos, HttpStatus.OK);

	}

	@PutMapping("actualizarPass/{id}")
	public ResponseEntity<String> actualizarPassword(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
		
		try {
			medicoService.actualizarPassword(id, medicoDTO);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
