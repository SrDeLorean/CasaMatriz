package CasaMatriz;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author SrDeLorean
 */
public class Precios implements Serializable{
    private int  id;
    private int idSucursal;
    private int idPrecio;
    private double b93;
    private double b95;
    private double b97;
    private double disel;
    private double kerosene;
    private Date fecha;
    

    public Precios(int id,int idSucursal,int idPrecio,double b93, double b95, double b97, double disel, double kerosene,Date fecha) {
        this.id = id;
        this.idSucursal = idSucursal;
        this.idPrecio = idPrecio;
        this.b93 = b93;
        this.b95 = b95;
        this.b97 = b97;
        this.disel = disel;
        this.kerosene = kerosene;
        this.fecha = fecha;
    }


    public double getB93() {
        return b93;
    }

    public double getB95() {
        return b95;
    }

    public double getB97() {
        return b97;
    }
    
    public double getDisel() {
        return disel;
    }

    public double getKerosene() {
        return kerosene;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(int idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
