/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Guillermo y Victor
 */
public class Administrador extends Trabajador {

    // ####################### - ATRIBUTOS - #######################
    private List<Guia> empleados;
    private List<Exposicion> exposiciones;
    private List<Entrada> entradas;

    // ####################### - CONSTRUCTORES - #######################
    public Administrador(String nombre, String dni, int telefono, long nSS) {
        super(nombre, dni, telefono, nSS);
        empleados = new ArrayList();
        exposiciones = new ArrayList();
    }

    // Constructor necesario para cargar un administrador desde la Base de Datos
    public Administrador(String nombre, String dni, int telefono, long nSS, int id, List empleados, List exposiciones) {
        super(nombre, dni, telefono, nSS, id);
        this.empleados = empleados;
        this.exposiciones = exposiciones;
    }

    // ####################### - GETTERS - #######################
    public List<Guia> getEmpleados() {
        return empleados;
    }

    public List<Exposicion> getExposiciones() {
        return exposiciones;
    }

    // ####################### - MÉTODOS - #######################
    public void annadirEmpleado(Guia e) {
        empleados.add(e);
    }

    public void eliminarEmpleado(Guia e) {
        empleados.remove(e);
    }

    public String[][] plantillaAString() {

        String[][] datos = null;

        if (!getEmpleados().isEmpty()) {

            datos = new String[getEmpleados().size()][4];
            Guia g;

            for (int i = 0; i < getEmpleados().size(); i++) {

                g = getEmpleados().get(i);

                datos[i][0] = String.valueOf(g.getNGuia());
                datos[i][1] = g.getNombre();
                datos[i][2] = g.getDNI();
                datos[i][3] = String.valueOf(g.getTelefono());

            }
        }

        return datos;
    }

    public void cargarTodasEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void ordenarNombre() {
        Collections.sort(entradas, new ComparatorNombre());
    }

    public void ordenarDni() {
        Collections.sort(entradas, new ComparatorDni());
    }

    public void ordenarFechaTransaccion() {
        Collections.sort(entradas, new ComparatorFecha());
    }

    public String[][] tabla_todasEntradas() {
        String[][] array = new String[entradas.size()][7];
        String esGuiada;

        if (!entradas.isEmpty()) {
            for (int i = 0; i < entradas.size(); i++) {
                Entrada e = entradas.get(i);
                array[i][0] = e.getNombreCliente();
                array[i][1] = e.getDniCliente();
                array[i][2] = String.valueOf(new java.sql.Date(e.getFecha().getTime()));
                array[i][3] = e.getHora();
                if (e.getEsGuiada()) {
                    esGuiada = "Si";

                } else {
                    esGuiada = "No";
                }
                array[i][4] = esGuiada;
                array[i][5] = e.getFechaTransaccion();
                array[i][6] = String.format("%.2f €", e.getPrecio());
            }
        }

        return array;
    }

}

class ComparatorNombre implements Comparator<Entrada> {

    @Override
    public int compare(Entrada e1, Entrada e2) {
        int resultado = e1.getNombreCliente().compareToIgnoreCase(e2.getNombreCliente());
        if (resultado == 0) {
            resultado = e1.getDniCliente().compareToIgnoreCase(e2.getDniCliente());
        }
        return resultado;
    }

}

class ComparatorDni implements Comparator<Entrada> {

    @Override
    public int compare(Entrada e1, Entrada e2) {
        int resultado = e1.getDniCliente().compareToIgnoreCase(e2.getDniCliente());
        if (resultado == 0) {
            resultado = e1.getNombreCliente().compareToIgnoreCase(e2.getNombreCliente());
        }
        return resultado;
    }

}

class ComparatorFecha implements Comparator<Entrada> {

    @Override
    public int compare(Entrada e1, Entrada e2) {
        return e2.getFechaTransaccion().compareToIgnoreCase(e1.getFechaTransaccion());
    }

}
