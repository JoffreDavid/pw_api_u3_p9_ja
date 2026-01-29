package uce.edu.web.api.matricula.aplication;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.matricula.domain.Hijo;
import uce.edu.web.api.matricula.infraestructure.HijoRepository;
import uce.edu.web.api.matricula.representation.HijoRepresentation;

@ApplicationScoped
public class HijoService {


    @Inject
    private HijoRepository hijoRepesRepository;

    public List<HijoRepresentation> buscarPorIdEstudiante(Integer idEstudiante){
        List<HijoRepresentation> list = new ArrayList();
        for(Hijo h:this.hijoRepesRepository.buscarPorIdEstudiante(idEstudiante)){
            list.add(this.mapperToHijo(h));
        }
        
        return list;
    }

    private HijoRepresentation mapperToHijo(Hijo hijo){
        HijoRepresentation hr = new HijoRepresentation();
        hr.setId(hijo.getId());
        hr.setApellido(hijo.getApellido());
        hr.setNombre(hijo.getNombre());
         return hr;
    }

   
}
