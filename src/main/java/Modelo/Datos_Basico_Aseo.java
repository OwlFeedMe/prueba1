/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class Datos_Basico_Aseo {

    private int id;
    private int id_re;
    private String compania_Aseo;
    private Date FI ;
    private Date FF;
    private int pre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_re() {
        return id_re;
    }

    public void setId_re(int id_re) {
        this.id_re = id_re;
    }

    public String getCompania_Aseo() {
        return compania_Aseo;
    }

    public void setCompania_Aseo(String compania_Aseo) {
        this.compania_Aseo = compania_Aseo;
    }

    public Date getFI() {
        return FI;
    }

    public void setFI(Date FI) {
        this.FI = FI;
    }

    public Date getFF() {
        return FF;
    }

    public void setFF(Date FF) {
        this.FF = FF;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }
}
