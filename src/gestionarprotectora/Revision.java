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
public class Revision implements Serializable{
    private Fecha fecha;
    private String diagnostico;

    public Revision(Fecha fecha, String diagnostico) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        
        return String.format(
                "%-20s %-20s\n",
                fecha, diagnostico
        );
        
        
    }
    
    
}
