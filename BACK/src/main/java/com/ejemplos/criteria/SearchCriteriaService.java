package  com.ejemplos.criteria;

import com.ejemplos.DTO.MedicoDTO;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class SearchCriteriaService {
	
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");


    public <T> List<SearchCriteria> buildSearchCriteria(ObjectDTO<?> dto) {
        List<SearchCriteria> criteriaList = new ArrayList<>();

        if (dto instanceof MedicoDTO) {
            MedicoDTO medicoDTO = (MedicoDTO) dto;
            if (medicoDTO.getNombre() != null) {
                criteriaList.add(new SearchCriteria("nombre", ":", medicoDTO.getNombre()));
            }
            if (medicoDTO.getApellidos() != null) {
                criteriaList.add(new SearchCriteria("apellidos", ":", medicoDTO.getApellidos()));
            }
            if (medicoDTO.getJornadaInicio() != null) {
                    criteriaList.add(new SearchCriteria("jornadaInicio", ">=", medicoDTO.getJornadaInicio()));
        
            }
        
        	if (medicoDTO.getJornadaFinal()!= null) {
            criteriaList.add(new SearchCriteria("jornadaFinal", "<=", medicoDTO.getJornadaFinal()));
        }
        	
        	
//        	if (medicoDTO.getJornadaInicio() != null && medicoDTO.getJornadaFinal() != null) {
//                criteriaList.add(new SearchCriteria("jornadaInicio", "<", medicoDTO.getJornadaFinal()));
//                criteriaList.add(new SearchCriteria("jornadaFinal", ">", medicoDTO.getJornadaInicio()));
//
//            }
        	
//        	if (medicoDTO.getJornadaInicio() != null && medicoDTO.getJornadaFinal() != null) {
//                criteriaList.add(new SearchCriteria("jornadaFinal", "<", medicoDTO.getJornadaInicio()));
//            }
        	
        }


        return criteriaList;
    }
}
