/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * @author Victor
 */
public class Persona {

    private final String nombre;
    private final String dni;
    private final int telefono;

    Persona(String nombre, String dni, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }
}
