/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.Serializable;

/**
 *
 * @author dam1
 */
public class Adopcion implements Serializable{
    private Fecha fechaSolicitud;
    private String nombreAdoptante;
    private Animal adoptado;

    public Adopcion(Fecha fechaSolicitud, String nombreAdoptante, Animal adoptado) {
        this.fechaSolicitud = fechaSolicitud;
        this.nombreAdoptante = nombreAdoptante;
        this.adoptado = adoptado;
    }

    public Animal getAdoptado() {
        return adoptado;
    }

    public void setAdoptado(Animal adoptado) {
        this.adoptado = adoptado;
    }

    public Fecha getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Fecha fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    public void setNombreAdoptante(String nombreAdoptante) {
        this.nombreAdoptante = nombreAdoptante;
    }    
    
}
