/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Guillermo y Victor
 */
public class Administrador extends Trabajador {

    // ####################### - ATRIBUTOS - #######################
    private final List<Guia> empleados;
    private final List<Exposicion> exposiciones;
    private List<Entrada> entradas;

    // ####################### - CONSTRUCTORES - #######################
    public Administrador(String nombre, String dni, int telefono, long nSS) {
        super(nombre, dni, telefono, nSS);
        empleados = new ArrayList<>();
        exposiciones = new ArrayList<>();
    }

    // Constructor necesario para cargar un administrador desde la Base de Datos
    public Administrador(String nombre, String dni, int telefono, long nSS, int id, List<Guia> empleados, List<Exposicion> exposiciones) {
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
    public void annadirEmpleado(Guia guia) {
        empleados.add(guia);
    }

    public void eliminarEmpleado(Guia guia) {
        empleados.remove(guia);
    }

    public String[][] plantillaAString() {

        String[][] datos = null;

        if (!getEmpleados().isEmpty()) {

            datos = new String[getEmpleados().size()][4];
            Guia guia;

            for (int i = 0; i < getEmpleados().size(); i++) {

                guia = getEmpleados().get(i);

                datos[i][0] = String.valueOf(guia.getNGuia());
                datos[i][1] = guia.getNombre();
                datos[i][2] = guia.getDNI();
                datos[i][3] = String.valueOf(guia.getTelefono());

            }
        }

        return datos;
    }

    public void cargarTodasEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void ordenarNombre() {
        entradas.sort(new ComparatorNombre());
    }

    public void ordenarDni() {
        entradas.sort(new ComparatorDni());
    }

    public void ordenarFechaTransaccion() {
        entradas.sort(new ComparatorFecha());
    }

    public String[][] tabla_todasEntradas() {
        String[][] array = new String[entradas.size()][7];
        String esGuiada;
        // Formateadores de fecha
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        if (!entradas.isEmpty()) {
            for (int i = 0; i < entradas.size(); i++) {
                Entrada entrada = entradas.get(i);
                array[i][0] = entrada.getNombreCliente();
                array[i][1] = entrada.getDniCliente();
                array[i][2] = date.format(entrada.getFecha());
                array[i][3] = entrada.getHora();
                if (entrada.getEsGuiada()) {
                    esGuiada = "Si";
                } else {
                    esGuiada = "No";
                }
                array[i][4] = esGuiada;
                array[i][5] = dateTime.format(entrada.getFechaTransaccion());
                array[i][6] = String.format("%.2f €", entrada.getPrecio());
            }
        }

        return array;
    }

}

class ComparatorNombre implements Comparator<Entrada> {

    @Override
    public int compare(Entrada entrada1, Entrada entrada2) {
        int resultado = entrada1.getNombreCliente().compareToIgnoreCase(entrada2.getNombreCliente());
        if (resultado == 0) {
            resultado = entrada1.getDniCliente().compareToIgnoreCase(entrada2.getDniCliente());
        }
        return resultado;
    }

}

class ComparatorDni implements Comparator<Entrada> {

    @Override
    public int compare(Entrada entrada1, Entrada entrada2) {
        int resultado = entrada1.getDniCliente().compareToIgnoreCase(entrada2.getDniCliente());
        if (resultado == 0) {
            resultado = entrada1.getNombreCliente().compareToIgnoreCase(entrada2.getNombreCliente());
        }
        return resultado;
    }

}

class ComparatorFecha implements Comparator<Entrada> {

    @Override
    public int compare(Entrada entrada1, Entrada entrada2) {
        return entrada2.getFechaTransaccion().compareTo(entrada1.getFechaTransaccion());
    }

}
