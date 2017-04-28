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
public class Datos_Basico_Habitacion {
   private int id_Habitacion;
private int  id_Residencia;
private int  numero_Camas;
private int  valor_Habitacion;

    public int getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(int id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    public int getId_Residencia() {
        return id_Residencia;
    }

    public void setId_Residencia(int id_Residencia) {
        this.id_Residencia = id_Residencia;
    }

    public int getNumero_Camas() {
        return numero_Camas;
    }

    public void setNumero_Camas(int numero_Camas) {
        this.numero_Camas = numero_Camas;
    }

    public int getValor_Habitacion() {
        return valor_Habitacion;
    }

    public void setValor_Habitacion(int valor_Habitacion) {
        this.valor_Habitacion = valor_Habitacion;
    }
}
