/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Protectora implements Serializable {

    ArrayList<Animal> listaAnimales = new ArrayList<>();
    ArrayList<Adopcion> listaAdopciones = new ArrayList<>();

    public void cargarFicheroTxt(String nombreFichero) {
        try {
            File fichero = new File(nombreFichero);
            Scanner scFichero = new Scanner(fichero);
            Animal nuevoAnimal = null;
            while (scFichero.hasNextLine()) {
                String linea = scFichero.nextLine();
                String[] partes = linea.split(",");
                switch (partes[0]) {
                    case "Perro":
                        nuevoAnimal = new Perro(
                                Integer.parseInt(partes[1]),
                                partes[2],
                                Integer.parseInt(partes[3]),
                                Fecha.stringToFecha(partes[4]),
                                partes[5],
                                Boolean.parseBoolean(partes[6])
                        );
                        if (nuevoAnimal != null) {
                            listaAnimales.add(nuevoAnimal);
                        }
                        break;
                    case "Gato":
                        nuevoAnimal = new Gato(
                                Integer.parseInt(partes[1]),
                                partes[2],
                                Integer.parseInt(partes[3]),
                                Fecha.stringToFecha(partes[4]),
                                partes[5],
                                Boolean.parseBoolean(partes[6])
                        );
                        if (nuevoAnimal != null) {
                            listaAnimales.add(nuevoAnimal);
                        }
                        break;
                }
            }
            scFichero.close();
            System.out.println("Fichero Animales cargado " + nombreFichero);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: El fichero no se ha podido cargar " + nombreFichero);
        }
    }

    public void altaNuevoAnimal() {
        int id = 101;
        if (listaAnimales.isEmpty()) {
            id = 101;
        } else {
            id = listaAnimales.getLast().getId() + 1;
        }
        boolean ok = false;
        do {
            System.out.println("Este animal es Gato (1) o Perro (2)? ");
            int pog = Entrada.entero();
            switch (pog) {
                case 1:
                    System.out.println("Escriba el nombre");
                    String nombre = Entrada.cadena();
                    System.out.println("Escriba la edad");
                    int edad = Entrada.entero();
                    System.out.println("Escriba la fecha de entrada en este formato dd/mm/aaaa");
                    String fechaEntradaString = Entrada.cadena();
                    Fecha fechaEntrada = Fecha.stringToFecha(fechaEntradaString);
                    System.out.println("Que pelaje tiene?");
                    String pelaje = Entrada.cadena();
                    System.out.println("Es agresivo?");
                    boolean esAgresivo = Entrada.booleano();
                    Gato g = new Gato(id, nombre, edad, fechaEntrada, pelaje, esAgresivo);
                    listaAnimales.add(g);
                    ok = true;

                    break;
                case 2:
                    System.out.println("Escriba el nombre");
                    nombre = Entrada.cadena();
                    System.out.println("Escriba la edad");
                    edad = Entrada.entero();
                    System.out.println("Escriba la fecha de entrada en este formato dd/mm/aaaa");
                    fechaEntradaString = Entrada.cadena();
                    fechaEntrada = Fecha.stringToFecha(fechaEntradaString);
                    System.out.println("Que raza es?");
                    pelaje = Entrada.cadena();
                    System.out.println("Esta entrenado?");
                    esAgresivo = Entrada.booleano();
                    Perro p = new Perro(id, nombre, edad, fechaEntrada, pelaje, esAgresivo);
                    ok = true;
                    listaAnimales.add(p);
            }

        } while (!ok);
    }

    public void listarAnimales() {
        System.out.println("--- Lista de animales del centro ---");

        System.out.printf(
                "%-5s %-15s %-10s %-10s %-10s %-15s\n",
                "ID", "Nombre", "Edad", "Fecha", "Tasa", "Sonido\n"
        );
        System.out.println("----------------------------------------------------------------------");
        for (Animal a : listaAnimales) {
            if (a instanceof Perro) {
                System.out.printf(
                        "%-5s %-15s %5d %-15s %-10s ",
                        "[" + a.getId() + "]",
                        a.getNombre(),
                        a.getEdad(),
                        a.getFechaEntrada(),
                        a.calcularTasaAdopcion()
                );

                ((Perro) a).emitirSonido();
            }
            if (a instanceof Gato) {
                System.out.printf(
                        "%-5s %-15s %5d %-15s %-10s ",
                        "[" + a.getId() + "]",
                        a.getNombre(),
                        a.getEdad(),
                        a.getFechaEntrada(),
                        a.calcularTasaAdopcion()
                );

                ((Gato) a).emitirSonido();

            }

        }
    }

    public Animal buscarAnimal(int id) {
        boolean enc = false;
        Animal buscado = null;
//        System.out.println("--- Ficha detallada ---");
        for (int i = 0; i < listaAnimales.size() && !enc; i++) {
            if (listaAnimales.get(i).getId() == id) {
                enc = true;
                buscado = listaAnimales.get(i);
//                if (buscado instanceof Gato) {
//                    System.out.println("ID: " + buscado.getId() + "\tNombre: " + buscado.getNombre() + "\tEdad: " + buscado.getEdad());
//                    System.out.println("Fecha de entrada: " + buscado.getFechaEntrada() + "\tPelaje: " + ((Gato) buscado).getPelaje() + "\tAgresivo: " + ((Gato) buscado).isEsAgresivo());
//
//                } else if (buscado instanceof Perro) {
//                    System.out.println("ID: " + buscado.getId() + "\tNombre: " + buscado.getNombre() + "\tEdad: " + buscado.getEdad());
//                    System.out.println("Fecha de entrada: " + buscado.getFechaEntrada() + "\tRaza: " + ((Perro) buscado).getRaza() + "\tAgresivo: " + ((Perro) buscado).isEntrenado());
//
//                }

            }

        }
        if (!enc) {
            System.out.println("ERROR: no se ha encontrado el bicho");
        }
        return buscado;
    }

    public static Protectora leerBinario() {
        Protectora objProtectora = null;

        try {
            FileInputStream fichero = new FileInputStream("protectora.dat");
            ObjectInputStream entrada = new ObjectInputStream(fichero);

            objProtectora = (Protectora) entrada.readObject();

            fichero.close();
            entrada.close();

            System.out.println("Fichero leido ");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: No se ha leido el fichero protectora.dat");
        }
        return objProtectora;

    }

    public static void guardarBinario(Protectora objProtectora) {

        try {

            FileOutputStream fichero = new FileOutputStream("protectora.dat");
            ObjectOutputStream salida = new ObjectOutputStream(fichero);

            salida.writeObject(objProtectora);

            fichero.close();
            salida.close();

            System.out.println("Fichero protectora.dat guardado perfectamente");

        } catch (IOException e) {
            System.out.println("ERROR: No se ha podido guardar el fichero protectora.dat");
        }
    }

}
