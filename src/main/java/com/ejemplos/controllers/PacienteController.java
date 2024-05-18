package com.ejemplos.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

//
import com.ejemplos.DTO.MedicoDTO;
import com.ejemplos.DTO.MedicoNewDTO;
import com.ejemplos.DTO.PacienteDTO;
import com.ejemplos.models.dao.IMedicoDao;
import com.ejemplos.models.dao.IPacienteDao;
import com.ejemplos.models.entity.Medico;
import com.ejemplos.models.exceptions.AlreadyExistsException;
import com.ejemplos.models.exceptions.BadInputException;
import com.ejemplos.models.exceptions.NotFoundException;
import com.ejemplos.models.service.IMedicoService;
import com.ejemplos.models.service.IPacienteService;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IPacienteDao pacienteRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(PacienteController.class);


//	@ApiOperation(value = "Obtener los datos de un vehículo", notes = "Obtener los datos de de un vehículo", response = DatosVehDTO.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request"),
//			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
//			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/perfil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PacienteDTO> datosPerfil(@PathVariable("id") Long id) {
		LOGGER.info("Init MedicoController: perfil");
		PacienteDTO pacienteDTO=new PacienteDTO();
		try {
			pacienteDTO = this.pacienteService.perfil(id);
		} catch (BadInputException e) {
			LOGGER.error("Exception: BadInput");
			return new ResponseEntity<>(pacienteDTO,HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			LOGGER.error("Exception: NotFound");
			pacienteDTO.setValidaciones("Paciente con id "+id+" no encontrado");
			return new ResponseEntity<>(pacienteDTO, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End MedicoController: perfil");
		return new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
	}
	
	
	
//	@GetMapping(value = "/pacientesMedico", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<PacienteDTO>> getPacientesPorMedico(String userAuthentication) {
//		LOGGER.info("Init MedicoController: verMedicosActivos");
//		addFilterMedico(userAuthentication);
//
//		List<PacienteDTO> pacientesDTO= this.pacienteService.pacientesMedico();
//		if(pacientesDTO.isEmpty())
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		
//		LOGGER.info("End MedicoController: medicosActivos");
//		return new ResponseEntity<>(pacientesDTO, HttpStatus.OK);
//	}
	
	//Que muestre solo los pacientes del médico logueado.
//	private void addFilterMedico(Principal principal,String userAuthentication) {
//		Medico medico = this.medicoService.findByUser(principal.getName());
//		
//		if (user.getTipusUsuari().equals(TipusUsuari.ADJ)) {
//			datosVehFilterDTO.setIdEmpresa(user.getEmpresa().getIdEmpresa());
//		} 
//	}
	
	
	

}
