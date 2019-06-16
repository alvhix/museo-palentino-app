/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Guillermo
 */
public abstract class Empleado extends Persona {

    //Atributos -----------------------------------------------------
    private int id;
    private long nSS;

    //Constructor ----------------------------------------------------------
    public Empleado(String nombre, String dni, int telefono, long nSS) {
        super(nombre, dni, telefono);
        this.nSS = nSS;
    }

    public Empleado(String nombre, String dni, int telefono, long nSS, int id) {
        super(nombre, dni, telefono);
        this.nSS = nSS;
        this.id = id;
    }
    
    //Getters ------------------------------------------------------
    public long getNSS() {
        return nSS;
    }

    public int getID() {
        return id;
    }
}
