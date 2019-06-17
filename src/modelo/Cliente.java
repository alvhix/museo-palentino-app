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
    public Cliente(String nombre, String dni, int telefono, int id, List entradas) {
        super(nombre, dni, telefono);
        this.id = id;
        this.entradas = entradas;
    }
    
    // Getter
    public int getIdCliente() {
        return id;
    }

    public long getTarjeta() {
        return tarjeta;
    }
    
    public void obtenerEntradas(List e){
        entradas = e;
    }
    
    public String[][] consultarEntradas() {
        String[][] array = new String[entradas.size()][5];
        String guiada;
        String guia;

        if (!entradas.isEmpty()) {
            for (int i = 0; i < entradas.size(); i++) {
                Entrada e = entradas.get(i);
                array[i][0] = String.valueOf(e.getFecha());
                array[i][1] = e.getHora();

                if (e.getEsGuiada()) {
                    guiada = "Si";
                    guia = String.valueOf(e.getNumGuia());
                } else {
                    guiada = "No";
                    guia = " -";
                }

                array[i][2] = guiada;
                array[i][3] = guia;
                array[i][4] = String.format("%.2f €",e.getPrecio());
            }
        }

        return array;
    }
}
