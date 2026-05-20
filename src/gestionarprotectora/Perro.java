/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

/**
 *
 * @author dam1
 */
public class Perro extends Animal {

    private String raza;
    private boolean entrenado;

    public Perro(String raza, boolean entrenado, int id, String nombre, int edad, Fecha fechaEntrada) {
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
        return "Perro: " + "ID: " + super.getId() + " Nombre: " + super.getNombre() + " Edad: " + super.getEdad() + "Fecha de Entrada: " + super.getFechaEntrada() + " Raza: " + raza + " Entrenado: " + entrenado;
    }

}
