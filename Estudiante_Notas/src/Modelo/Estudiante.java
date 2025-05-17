/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Estudiante{
    private String nombre;
    private String cedula;
    private String sexo;
    private String curso;
    private String carrera;

    public Estudiante(String nombre, String cedula, String sexo, String curso, String carrera) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sexo = sexo;
        this.curso = curso;
        this.carrera = carrera;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCarrera() {
        return carrera;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", cedula=" + cedula + ", sexo=" + sexo + ", curso=" + curso + ", carrera=" + carrera + '}';
    }
   
}
