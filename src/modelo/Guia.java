/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

/**
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

    public void cargarEntradasGuia(List<Entrada> entradasGuiadas) {
        this.entradasGuiadas = entradasGuiadas;
    }

    public void ordenarFechaReserva() {
        entradasGuiadas.sort(new ComparatorFechaReserva());
    }

    public void ordenarFechaTransaccion() {
        entradasGuiadas.sort(new ComparatorFechaTransaccion());
    }

    public String[][] tabla_EntradasGuia() {
        String[][] array = new String[entradasGuiadas.size()][5];
        // Formateadores de fecha
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        if (!entradasGuiadas.isEmpty()) {
            for (int i = 0; i < entradasGuiadas.size(); i++) {
                Entrada e = entradasGuiadas.get(i);
                array[i][0] = e.getDniCliente();
                array[i][1] = sdf1.format(e.getFecha());
                array[i][2] = e.getHora();
                array[i][3] = sdf2.format(e.getFechaTransaccion());
                array[i][4] = String.format("%.2f €", e.getPrecio());
            }
        }

        return array;
    }

}

class ComparatorFechaReserva implements Comparator<Entrada> {

    @Override
    public int compare(Entrada e1, Entrada e2) {
        int resultado = e2.getFecha().compareTo(e1.getFecha());
        if (resultado == 0) {
            resultado = e1.getHora().compareToIgnoreCase(e2.getHora());
        }
        return resultado;
    }

}

class ComparatorFechaTransaccion implements Comparator<Entrada> {

    @Override
    public int compare(Entrada e1, Entrada e2) {
        return e2.getFechaTransaccion().compareTo(e1.getFechaTransaccion());
    }

}
