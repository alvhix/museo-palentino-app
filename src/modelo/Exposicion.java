/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Victor
 */
import java.util.ArrayList;
import java.util.List;

public class Exposicion {

    // ####################### - Atributos - #######################
    private String nombre;
    private int id;
    private int duracion;
    private int tiempoRecorrido;
    private String rutaImagen;
    private List<Obra> obras;

    // ####################### - Constructores - #######################
    // Constructor para crear exposicion
    public Exposicion() {
        this.obras = new ArrayList();
    }

    // Constructor necesario para cargar exposicion
    public Exposicion(int id, String nombre, int duracion, int tiempoRecorrido, String rutaImagen, List obras) {
        this.nombre = nombre;
        this.id = id;
        this.duracion = duracion;
        this.tiempoRecorrido = tiempoRecorrido;
        this.rutaImagen = rutaImagen;
        this.obras = obras;
    }

    // ####################### - Getters - #######################
    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempoRecorrido() {
        return tiempoRecorrido;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public List<Obra> getObras() {
        return obras;
    }

    // ####################### - Métodos - #######################
    public void agregarObra(Obra o) {
        obras.add(o);
    }

    public void borrarObra(Obra o) {
        obras.remove(o);
    }

    public int numeroObrasDisponibles() {
        return 0;
    }
}
