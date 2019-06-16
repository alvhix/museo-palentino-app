/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Álvaro y Victor
 */
public class Guia extends Trabajador {

    private int nGuia;

    // Constructor
    public Guia(String nombre, String dni, int telefono, long nSS) {
        super(nombre, dni, telefono, nSS);
    }

    // Constructor necesario para cargar un guia desde la Base de Datos
    public Guia(String nombre, String dni, int telefono, long nSS, int id, int nGuia) {
        super(nombre, dni, telefono, nSS, id);
        this.nGuia = nGuia;
    }

    public int getNGuia() {
        return nGuia;
    }
    
}
