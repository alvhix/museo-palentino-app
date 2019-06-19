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
public class Guia extends Trabajador {

    private int nGuia;
    private List<Entrada> entradasGuiadas;

    // Constructor ----------------------------------
    public Guia(String nombre, String dni, int telefono, long nSS) {
        super(nombre, dni, telefono, nSS);
    }

    // Constructor para contratar guias
    public Guia(String nombre, String dni, int telefono, long nSS, int nGuia) {
        super(nombre, dni, telefono, nSS);
        this.nGuia = nGuia;
    }

    // Constructor necesario para cargar un guia desde la Base de Datos ----------
    public Guia(String nombre, String dni, int telefono, long nSS, int id, int nGuia) {
        super(nombre, dni, telefono, nSS, id);
        this.nGuia = nGuia;
    }

    // Getters ---------------------------------------
    public int getNGuia() {
        return nGuia;
    }

    public void cargarEntradasGuia(List entradasGuiadas) {
        this.entradasGuiadas = entradasGuiadas;
    }

    public String[][] tabla_EntradasGuia() {
        String[][] array = new String[entradasGuiadas.size()][5];

        if (!entradasGuiadas.isEmpty()) {
            for (int i = 0; i < entradasGuiadas.size(); i++) {
                Entrada e = entradasGuiadas.get(i);
                array[i][0] = String.valueOf(e.getNumEntrada());
                array[i][1] = String.valueOf(e.getFecha());
                array[i][2] = e.getHora();
                array[i][3] = String.valueOf(e.getFechaTransaccion());
                array[i][4] = String.format("%.2f €", e.getPrecio());
            }
        }

        return array;
    }

}
