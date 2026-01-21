package uce.edu.web.api.matricula.infraestructure;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import uce.edu.web.api.matricula.domain.Materia;

@ApplicationScoped
public class MateriaRepository implements PanacheRepository<Materia> {
    
    @Inject
    EntityManager em;


    
    public List<Materia> buscarPorSemestre(Integer noSem) {
        String sql = "SELECT * FROM Materia WHERE semestre = :sem";
        
        return em.createNativeQuery(sql, Materia.class)
                 .setParameter("sem", noSem)
                 .getResultList();
    }

    
    public List<Materia> buscarPorSemestreYCuposNative(Integer noSem, Integer cuposMinimos) {
        
        String sql = "SELECT * FROM Materia WHERE semestre = :sem AND cupos > :cupos";
        
        return em.createNativeQuery(sql, Materia.class)
                 .setParameter("sem", noSem)
                 .setParameter("cupos", cuposMinimos)
                 .getResultList();
    }
    
}
