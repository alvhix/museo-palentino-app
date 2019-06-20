/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Collections;
import java.util.Comparator;
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
    
    public void ordenarFechaReserva() {
        Collections.sort(entradasGuiadas, new ComparatorFechaReserva());
    }
    
    public void ordenarFechaTransaccion() {
        Collections.sort(entradasGuiadas, new ComparatorFechaTransaccion());
    }
    
    public String[][] tabla_EntradasGuia() {
        String[][] array = new String[entradasGuiadas.size()][5];
        
        if (!entradasGuiadas.isEmpty()) {
            for (int i = 0; i < entradasGuiadas.size(); i++) {
                Entrada e = entradasGuiadas.get(i);
                array[i][0] = e.getDniCliente();
                array[i][1] = String.valueOf(new java.sql.Date(e.getFecha().getTime()));
                array[i][2] = e.getHora();
                array[i][3] = e.getFechaTransaccion();
                array[i][4] = String.format("%.2f €", e.getPrecio());
            }
        }
        
        return array;
    }
    
}

class ComparatorFechaReserva implements Comparator<Entrada> {
    
    @Override
    public int compare(Entrada e1, Entrada e2) {
        int resultado = e1.getFecha().compareTo(e2.getFecha());
        if (resultado == 0) {
            resultado = e1.getHora().compareToIgnoreCase(e2.getHora());
        }
        return resultado;
    }
    
}

class ComparatorFechaTransaccion implements Comparator<Entrada> {
    
    @Override
    public int compare(Entrada e1, Entrada e2) {
        int resultado = e1.getFechaTransaccion().compareToIgnoreCase(e2.getFechaTransaccion());
        if (resultado == 0) {
            resultado = e1.getHora().compareToIgnoreCase(e2.getHora());
        }
        return resultado;
    }
    
}
