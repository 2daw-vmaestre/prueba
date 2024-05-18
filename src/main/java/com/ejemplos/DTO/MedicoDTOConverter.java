package com.ejemplos.DTO;



import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

import com.ejemplos.models.entity.Medico;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class MedicoDTOConverter  {
	
	private final ModelMapper modelMapper;
		

	public MedicoDTO convertirAMedicoDTO(Medico medico) {
		return modelMapper.map(medico, MedicoDTO.class);
		
	}
	
	
	public Medico convertirAMedico(MedicoDTO medicoDTO) {
		return modelMapper.map(medicoDTO, Medico.class);
		
	}

}
