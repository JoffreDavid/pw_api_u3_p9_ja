package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.matricula.aplication.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/materias")
public class MateriaResourse {
    
    @Inject
    private MateriaService materiaService;


    @GET
    @Path("")
    public List<Materia> listarTodos(){
        List<Materia> test = this.materiaService.listarTodos();
        System.out.println(test);
        return test;
    }

    @GET
    @Path("/{id}")
    public Materia consultarPorId(@PathParam("id") Integer iden){
        return this.materiaService.consultarPorId(iden);
    }

    @POST
    @Path("")
    public void guardar(Materia materia){
        this.materiaService.crear(materia);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, Materia mat){
       this.materiaService.actualizar(id, mat);
    }
    
    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@PathParam("id") Integer id, Materia mat){
        this.materiaService.actualizarParcial(id, mat);
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id){
        this.materiaService.eliminar(id);
    }

    @GET
    @Path("/{noSem}")
    public List<Materia> getPorSemestre(@PathParam("noSem") Integer noSem) {
        return this.materiaService.listarPorSemestre(noSem);
    }

    @GET
    @Path("/{semestre}/{cupos}")
    public List<Materia> getPorSemestreConCupos(
        @PathParam("semestre") Integer noSem, 
        @PathParam("cupos") Integer noCupos 
    ) {
        
        return this.materiaService.listarPorSemestreYCupos(noSem, noCupos);
    }
}
