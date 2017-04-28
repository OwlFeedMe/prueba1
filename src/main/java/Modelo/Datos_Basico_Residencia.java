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
public class Datos_Basico_Residencia {
    
    private int id_Residencia;
private String propietario;
private String direccion;
private java.sql.Date fecha_Inicio_Contrato;
private java.sql.Date fecha_Final_Contrato;
private int numero_Habitacion;

    public int getId_Residencia() {
        return id_Residencia;
    }

    public void setId_Residencia(int id_Residencia) {
        this.id_Residencia = id_Residencia;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_Inicio_Contrato() {
        return fecha_Inicio_Contrato;
    }

    public void setFecha_Inicio_Contrato(Date fecha_Inicio_Contrato) {
        this.fecha_Inicio_Contrato = fecha_Inicio_Contrato;
    }

    public Date getFecha_Final_Contrato() {
        return fecha_Final_Contrato;
    }

    public void setFecha_Final_Contrato(Date fecha_Final_Contrato) {
        this.fecha_Final_Contrato = fecha_Final_Contrato;
    }

    public int getNumero_Habitacion() {
        return numero_Habitacion;
    }

    public void setNumero_Habitacion(int numero_Habitacion) {
        this.numero_Habitacion = numero_Habitacion;
    }
}
