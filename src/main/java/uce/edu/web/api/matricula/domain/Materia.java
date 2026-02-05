package uce.edu.web.api.matricula.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Materia")
@SequenceGenerator(name="materia_sec", sequenceName="materia_secuencia", allocationSize=1)
public class Materia extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="materia_sec")
    private Integer id;
    private String nombre;
    private String paralelo;
    private Integer semestre;
    private Integer cupos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }


}
