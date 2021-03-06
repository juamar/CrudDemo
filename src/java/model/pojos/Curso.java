package model.pojos;
// Generated Jan 25, 2018 10:10:13 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Curso generated by hbm2java
 */
public class Curso  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Set alumnos = new HashSet(0);

    public Curso() {
    }

	
    public Curso(int id) {
        this.id = id;
    }
    public Curso(int id, String nombre, Set alumnos) {
       this.id = id;
       this.nombre = nombre;
       this.alumnos = alumnos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set alumnos) {
        this.alumnos = alumnos;
    }




}


