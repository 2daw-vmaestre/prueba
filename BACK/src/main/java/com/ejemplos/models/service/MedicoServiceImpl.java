package com.ejemplos.models.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.DTO.MedicoDTO;
import com.ejemplos.DTO.MedicoDTOConverter;
import com.ejemplos.DTO.MedicoFilterDTO;
import com.ejemplos.criteria.GenericService;
import com.ejemplos.criteria.GenericSpecification;
import com.ejemplos.criteria.SearchCriteria;
import com.ejemplos.criteria.SearchCriteriaService;
import com.ejemplos.models.dao.IMedicoAuditoriaDao;
import com.ejemplos.models.dao.IMedicoDao;
import com.ejemplos.models.entity.Medico;
import com.ejemplos.models.exceptions.AlreadyExistsException;
import com.ejemplos.models.exceptions.BadInputException;
import com.ejemplos.models.exceptions.IncorrectPasswordException;
import com.ejemplos.models.exceptions.NotFoundException;

@Service
public class MedicoServiceImpl extends GenericService<Medico> implements IMedicoService {

	@Autowired
	private IMedicoDao medicoRepository;

	@Autowired
	private IMedicoAuditoriaDao medicoAuditRepository;

	@Autowired
	private MedicoDTOConverter convertirDTO;

	@Autowired
	private GenericService<Medico> genericService;

	@Autowired
	private SearchCriteriaService searchCriteriaService;

	public MedicoDTO altaMedico(MedicoDTO medicoDTO) throws NoSuchAlgorithmException {

		validarDatos(medicoDTO);

		String pass = hashPassword(medicoDTO.getPass());
		medicoDTO.setPass(pass);

		Medico medicoBBDD = convertirDTO.convertirAMedico(medicoDTO);
		medicoBBDD.setActivo(true);
		medicoRepository.save(medicoBBDD);
		MedicoDTO medico = convertirDTO.convertirAMedicoDTO(medicoBBDD);
		return medico;

	}
	
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] hashedBytes = digest.digest(password.getBytes());
		return String.format("%040x", new BigInteger(1, hashedBytes));
	}
	

	public void validarDatos(MedicoDTO medicoDTO) {
		if (medicoDTO == null || medicoDTO.getNombre() == null || medicoDTO.getApellidos() == null
				|| medicoDTO.getJornadaInicio() == null || medicoDTO.getPass() == null
				|| medicoDTO.getJornadaFinal() == null || medicoDTO.getNumeroIdentificacion() == null) {

			throw new BadInputException("Datos no informados");
		}

		if (existeNumIdentificacion(medicoDTO.getNumeroIdentificacion())) {
			throw new AlreadyExistsException("Ya existe un médico registrado con ese número de identificación");
		}
	}

	public boolean existeNumIdentificacion(String numIdentificacion) {
		Optional<Medico> medico = medicoRepository.findByNumeroIdentificacionAndActivo(numIdentificacion, true);
		return medico.isPresent();
	}

	

	public List<MedicoDTO> medicosSinAuditoriasPendientes() {

//		List<MedicoDTO> medicosSinAuditorias = this.medicoAuditRepository.findByMedicoIdAndFechaAuditoriaAndActiva(true);
//		if (medicosSinAuditorias.size() > 0) {
//
//			return medicosSinAuditorias;
//		}

		return Collections.emptyList();
	}

	public MedicoDTO bajaMedico(Optional<Medico> medico) {
		medico.get().setActivo(false);
		this.medicoRepository.save(medico.get());
		MedicoDTO medicoDTO = convertirDTO.convertirAMedicoDTO(medico.get());
		return medicoDTO;
	}

	@Override
	public MedicoDTO perfil(Long id) {
		Optional<Medico> medico = this.medicoRepository.findById(id);
		if (id == null) {
			throw new BadInputException("Introduce un id");
		} else if (!medico.isPresent()) {
			throw new NotFoundException("Médico con id " + id + " no encontrado.");
		}

		MedicoDTO medicoDTO = this.convertirDTO.convertirAMedicoDTO(medico.get());

		return medicoDTO;
	}

	@Override
	public MedicoDTO updatePerfil(MedicoDTO medicoDTO) throws NoSuchAlgorithmException {
		if (medicoDTO == null || medicoDTO.getJornadaFinal() == null || medicoDTO.getJornadaInicio() == null) {
			throw new BadInputException("Datos no informados");
		}

		Medico medicoBBDD = this.medicoRepository.findById(medicoDTO.getId()).orElseThrow(
				() -> new NotFoundException("No se ha encontrado un médico con el id: " + medicoDTO.getId()));

		medicoBBDD.setJornadaFinal(medicoDTO.getJornadaFinal());
		medicoBBDD.setJornadaInicio(medicoDTO.getJornadaInicio());

		this.medicoRepository.save(medicoBBDD);
		MedicoDTO medicoActualizadoDTO = this.convertirDTO.convertirAMedicoDTO(medicoBBDD);

		return medicoActualizadoDTO;

	}

	public void actualizarPassword(Long id, MedicoDTO medicoDTO) {
		Optional<Medico> medico = medicoRepository.findById(id); // No será necesario cuando esté la autenticación
		if (medico.isPresent()) {
			try {
				if (StringUtils.isNotBlank(medicoDTO.getPass())) {
					/* Compruebo que la contraseña que introduce el usuario es la misma que está
					 * guardada en la base de datos*/
					if (verifyPassword(medicoDTO.getPass(), medico.get().getPass())) {
						/* Cambio de contraseña */
						if (StringUtils.isNotBlank(medicoDTO.getNuevaPass())) {
							String nuevaPassEncriptada = hashPassword(medicoDTO.getNuevaPass());
							medico.get().setPass(nuevaPassEncriptada);
							medicoRepository.save(medico.get());
						}
					} else {
							throw new IncorrectPasswordException("Contraseña incorrecta");
					}
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		} else {
			throw new NotFoundException("Médico con id " + id + " no encontrado.");
		}
	}

	/* Comprueba si la contraseña introducida por el usuario coincide con la
	 * guardada en la bbdd*/
	public static boolean verifyPassword(String inputPassword, String storedHashedPassword)
			throws NoSuchAlgorithmException {
		String inputHashedPassword = hashPassword(inputPassword);
		return inputHashedPassword.equals(storedHashedPassword);
	}



	/* Devuelve lista de médicos según filtros */
	@Override
	public List<Medico> medicosActivosFilter(MedicoDTO medicoDTO) {
		List<SearchCriteria> criteriaList = searchCriteriaService.buildSearchCriteria(medicoDTO);
		criteriaList.add(new SearchCriteria("activo", ":", true));
		return genericService.buscarMedicos(new GenericSpecification<Medico>(criteriaList));
	}

	

}
