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
public class Perro extends Animal implements Serializable, IInteractuable{

    private String raza;
    private boolean entrenado;

    public Perro( int id, String nombre, int edad, Fecha fechaEntrada, String raza, boolean entrenado) {
        super(id, nombre, edad, fechaEntrada);
        this.raza = raza;
        this.entrenado = entrenado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isEntrenado() {
        return entrenado;
    }

    public void setEntrenado(boolean entrenado) {
        this.entrenado = entrenado;
    }

    
    @Override
    public double calcularTasaAdopcion() {
        double precio = 50;
        if (isEntrenado()) {
            precio += 40;
        } else {
            precio += 60;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Perro: " + "ID: " + super.getId() +
                " Nombre: " + super.getNombre() + 
                " Edad: " + super.getEdad() + 
                "Fecha de Entrada: " + super.getFechaEntrada() 
                + " Raza: " + raza + " Entrenado: " + entrenado ;
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau Guau");
    }
    

    @Override
    public void jugar() {
        System.out.println(getNombre() + " Juega con la pelota");
    }

}
