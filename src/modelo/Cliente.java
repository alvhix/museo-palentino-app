/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Álvaro y Victor
 */
public class Cliente extends Persona {

    private long tarjeta;
    private int id;
    private List<Entrada> entradas;

    // Constructor para crear cliente
    public Cliente(String nombre, String dni, int telefono) {
        super(nombre, dni, telefono);
    }

    // Constructor necesario para cargar cliente
    public Cliente(String nombre, String dni, int telefono, int id) {
        super(nombre, dni, telefono);
        this.id = id;
    }

    // Getter
    public int getIdCliente() {
        return id;
    }

    public long getTarjeta() {
        return tarjeta;
    }

    public void obtenerEntradas(List e) {
        entradas = e;
    }
    
    public void addEntrada(Entrada e){
        entradas.add(e);
    }

    public void cargarEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }
}
