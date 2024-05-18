package com.ejemplos.models.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import com.ejemplos.DTO.MedicoDTO;
import com.ejemplos.models.entity.Medico;

public interface IMedicoService {

	MedicoDTO altaMedico(MedicoDTO medicoDTO) throws NoSuchAlgorithmException;

	List<MedicoDTO> medicosSinAuditoriasPendientes();

	MedicoDTO bajaMedico(Optional<Medico> medico);

	MedicoDTO perfil(Long id);

	MedicoDTO updatePerfil(MedicoDTO medicoDTO) throws NoSuchAlgorithmException;

	public List<Medico> medicosActivosFilter(MedicoDTO medicoDTO);

	void actualizarPassword(Long id, MedicoDTO medicoDTO);
}
