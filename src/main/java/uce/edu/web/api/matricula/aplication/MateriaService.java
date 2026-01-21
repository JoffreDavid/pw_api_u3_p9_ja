package uce.edu.web.api.matricula.aplication;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.domain.Materia;
import uce.edu.web.api.matricula.infraestructure.MateriaRepository;

@ApplicationScoped
public class MateriaService {
    
   @Inject
   private MateriaRepository materiaRep;


   public List<Materia> listarTodos(){
    return this.materiaRep.listAll();
   }

   public Materia consultarPorId(Integer id){
    return this.materiaRep.findById(id.longValue());
   }

   @Transactional
   public void crear(Materia materia){
    this.materiaRep.persist(materia);
   }

   @Transactional
   public void actualizar(Integer id, Materia mat){
      Materia materia = this.consultarPorId(id);
      materia.setCupos(mat.getCupos());
      materia.setNombre(mat.getNombre());
      materia.setSemestre(mat.getSemestre());
      materia.setParalelo(mat.getParalelo());
   }


   @Transactional
   public void actualizarParcial(Integer id, Materia mat){
      Materia materia = this.consultarPorId(id);
      if(mat.getCupos() != null){
         materia.setCupos(mat.getCupos());
      }
      if(mat.getNombre() != null){
         materia.setNombre(mat.getNombre());
      }
      if(mat.getParalelo()!= null){
         materia.setParalelo(mat.getParalelo());
      }
      if(mat.getSemestre() != null){
         materia.setSemestre(mat.getSemestre());
      }
   }

   @Transactional 
   public void eliminar(Integer id){
      this.materiaRep.deleteById(id.longValue());
   }

   public List<Materia> listarPorSemestre(Integer noSem) {
        return this.materiaRep.buscarPorSemestre(noSem);
    }

    public List<Materia> listarPorSemestreYCupos(Integer noSem, Integer noCupos) {
        return this.materiaRep.buscarPorSemestreYCuposNative(noSem, noCupos);
    }
}
