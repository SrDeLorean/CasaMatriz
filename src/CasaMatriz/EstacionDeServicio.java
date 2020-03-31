/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasaMatriz;

/**
 *
 * @author SrDeLorean
 */
public class EstacionDeServicio {
    
    private int id;
    private String nombre;
    private String direccion;


    public EstacionDeServicio(int id,String nombre, String direccion ) {
        this.id = id;
        this.nombre=nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    
    
    
}
