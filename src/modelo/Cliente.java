/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Álvaro y Victor
 */
public class Cliente extends Persona {

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

    public void addEntrada(Entrada e){
        entradas.add(e);
    }

    public void cargarEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }
    
    public String[][] tablaEntradas() {
        String[][] array = new String[entradas.size()][4];
        String esGuiada;
        // Formateadores de fecha
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        if (!entradas.isEmpty()) {
            for (int i = 0; i < entradas.size(); i++) {
                Entrada e = entradas.get(i);
                array[i][0] = sdf1.format(e.getFecha());
                array[i][1] = e.getHora();

                if (e.getEsGuiada()) {
                    esGuiada = "Si";

                } else {
                    esGuiada = "No";
                }

                array[i][2] = esGuiada;
                array[i][3] = String.format("%.2f €", e.getPrecio());
            }
        }

        return array;
    }
}
