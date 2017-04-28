/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Datos_Basico_AsigE {
   private int id_Asignar_Habitacion;
private int id_Estudiante;
private int id_Habitacion;
private java.sql.Date fecha_Asignacion ;
private java.sql.Date fecha_Final_Asignacion ;

    public int getId_Asignar_Habitacion() {
        return id_Asignar_Habitacion;
    }

    public void setId_Asignar_Habitacion(int id_Asignar_Habitacion) {
        this.id_Asignar_Habitacion = id_Asignar_Habitacion;
    }

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public int getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(int id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    public Date getFecha_Asignacion() {
        return fecha_Asignacion;
    }

    public void setFecha_Asignacion(Date fecha_Asignacion) {
        this.fecha_Asignacion = fecha_Asignacion;
    }

    public Date getFecha_Final_Asignacion() {
        return fecha_Final_Asignacion;
    }

    public void setFecha_Final_Asignacion(Date fecha_Final_Asignacion) {
        this.fecha_Final_Asignacion = fecha_Final_Asignacion;
    }
    
}
