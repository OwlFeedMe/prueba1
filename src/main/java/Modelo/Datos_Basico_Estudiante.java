/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Modelo;

/**
 *
 * @author user
 */
public class Datos_Basico_Estudiante {

    private int id_Estudiante;
    private int id_Asignar_Habitacion;
    private String nombre;

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public int getId_Asignar_Habitacion() {
        return id_Asignar_Habitacion;
    }

    public void setId_Asignar_Habitacion(int id_Asignar_Habitacion) {
        this.id_Asignar_Habitacion = id_Asignar_Habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    private int edad;
    private int telefono;
    private String carrera;
    private String universidad;
}
