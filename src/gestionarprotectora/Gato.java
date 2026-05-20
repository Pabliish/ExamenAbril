/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

/**
 *
 * @author dam1
 */
public class Gato extends Animal {

    private String pelaje;
    private boolean esAgresivo;

    public Gato(String pelaje, boolean esAgresivo, int id, String nombre, int edad, Fecha fechaEntrada) {
        super(id, nombre, edad, fechaEntrada);
        this.pelaje = pelaje;
        this.esAgresivo = esAgresivo;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public boolean isEsAgresivo() {
        return esAgresivo;
    }

    public void setEsAgresivo(boolean esAgresivo) {
        this.esAgresivo = esAgresivo;
    }

    @Override
    public String toString() {
        return "Gato: " + "ID: " + super.getId() + " Nombre: " + super.getNombre() + " Edad: " + super.getEdad() + " Fecha de Entrada: " + super.getFechaEntrada() + "pelaje=" + pelaje + ", esAgresivo=" + esAgresivo + '}';
    }

    @Override
    public double calcularTasaAdopcion() {
        double precio = 50;
        if (isEsAgresivo()) {
            precio += 15;
        } else {
            precio += 30;
        }
        return precio;
    }
}
