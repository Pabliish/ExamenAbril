/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author dam1
 */
public class Fecha  implements Serializable{

    private int dia;
    private int mes;
    private int anho;
    Calendar calendario = new GregorianCalendar();

    Fecha(int dia, int mes, int anyo) {
        if (this.esFechaCorrecta(dia, mes, anyo)) {
            this.dia = dia;
            this.mes = mes;
            this.anho = anyo;
        } else {
            this.dia = calendario.get(GregorianCalendar.DATE);
            this.mes = calendario.get(GregorianCalendar.MONTH);
            this.anho = calendario.get(GregorianCalendar.YEAR);
        }
    }

    private boolean esBisiesto(int anyo) {
        boolean vRotorno = false;
        if ((anyo % 4 == 0) || (anyo % 100 == 0) && (anyo % 400 == 0)) {
            vRotorno = true;
        }
        return vRotorno;
    }

    private boolean esFechaCorrecta(int dia, int mes, int anyo) {
        boolean correcto = true;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia < 0 || dia > 31) {
                    correcto = false;
                }
                break;
            case 2:
                if (this.esBisiesto(anyo)) {
                    if (dia < 0 || dia > 29) {
                        correcto = false;
                    } else if (dia < 0 || dia > 28) {
                        correcto = false;
                    }
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia < 0 || dia > 30) {
                    correcto = false;
                }
                break;
        }
        return correcto;
    }
    @Override
    public String toString(){
        return String.format("%02d/%02d/%d", dia, mes, anho);
    }
    
    public static Fecha stringToFecha(String s){
        String[] d = s.split("/");
        return new Fecha(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
    }
}
