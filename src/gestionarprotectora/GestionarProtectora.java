/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionarprotectora;

/**
 *
 * @author dam1
 */
public class GestionarProtectora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Protectora miProtectora = Protectora.leerBinario();

        if (miProtectora == null) {
            miProtectora = new Protectora();
        }
        int opM;
        String nombreFichero;
        do {
            opM = menu();
            switch (opM) {
                case 1:
                    miProtectora.listarAnimales();

                    break;
                case 2:
                    System.out.println("Cual es el ID de su animal?");
                    int id2 = Entrada.entero();
                    if (miProtectora.buscarAnimal(id2) != null && miProtectora.buscarAnimal(id2) instanceof Perro) {
                        Perro p = (Perro) miProtectora.buscarAnimal(id2);
                        p.verFichaDetallada();
                    } else if (miProtectora.buscarAnimal(id2) != null && miProtectora.buscarAnimal(id2) instanceof Gato) {
                        Gato g = (Gato) miProtectora.buscarAnimal(id2);
                        
                    } else {
                        System.out.println("Ese animal no esta registrado");
                    }
                    break;

                case 3:
                    miProtectora.altaNuevoAnimal();
                    break;
                case 4:
                    System.out.println("Escriba el nombre del fichero: ");
                    nombreFichero = Entrada.cadena();
                    miProtectora.cargarFicheroTxt(nombreFichero);
                    break;
            }

        } while (true);
        //Protectora.guardarBinario(miProtectora);
    }

    public static int menu() {
        int opMenu;
        System.out.println("***** Gestion Protectora Mundo Animal ******");
        System.out.println("    1. Listar animales");
        System.out.println("    2. Ver fichas detalladas de animal");
        System.out.println("    3. Dar de alta nuevo animal ");
        System.out.println("    4. Cargar lote de animales desde archivos");
        System.out.println("    5. Annadir revision medica a un animal");
        System.out.println("    6. Tramitar adopcion");
        System.out.println("    7. Exportar historial de un animal a txt ");
        System.out.println("    8. Historial de adopciones");
        System.out.println("    0. Salir del menu");

        opMenu = Entrada.entero("Introduce una opcion");

        return opMenu;

    }

}
