/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author dam1
 */
public abstract class Animal implements Serializable {

    private int id;
    private String nombre;
    private int edad;
    private Fecha fechaEntrada;
    private ArrayList<Revision> historialMedico = new ArrayList<>();

    public Animal(int id, String nombre, int edad, Fecha fechaEntrada) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaEntrada = fechaEntrada;
    }

    public void verHistorialMedico() {
        if (historialMedico.isEmpty()) {
            System.out.println("No hay revisiones para mostrar");
        } else {
            for (Revision r : historialMedico) {
                System.out.println(r);
            }
        }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Fecha getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Fecha fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public boolean equals(Object _obj) {
        if (this == _obj) {
            return true;
        }

        if (_obj == null || getClass() != _obj.getClass()) {
            return false;
        }

        Animal otro = (Animal) _obj;

        return Objects.equals(this.id, otro.id);
    }

    public abstract double calcularTasaAdopcion();

}
