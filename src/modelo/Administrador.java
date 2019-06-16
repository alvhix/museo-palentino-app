/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guillermo y Victor
 */
public class Administrador extends Empleado {

    // ####################### - ATRIBUTOS - #######################
    private List<Empleado> empleados;
    private List<Exposicion> exposiciones;

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
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Exposicion> getExposiciones() {
        return exposiciones;
    }
    
    // ####################### - MÉTODOS - #######################
    public void agregarExposicion(Exposicion e) {
        exposiciones.add(e);
    }

    public void borrarExposicion(Exposicion e) {
        exposiciones.remove(e);
    }

    public void annadirEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void eliminarEmpleado(Empleado e) {
        empleados.remove(e);
    }
}
