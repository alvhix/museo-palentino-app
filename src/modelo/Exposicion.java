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
 * @author Victor
 */
public class Exposicion {

    // ####################### - Atributos - #######################
    private int id;
    private int tiempoRecorrido;
    private String nombre;
    private String rutaImagen;
    private List<Obra> obras;

    // ####################### - Constructores - #######################
    // Constructor para nueva exposicion
    public Exposicion(String nombre, int tiempoRecorrido, String rutaImagen) {
        this.nombre = nombre;
        this.tiempoRecorrido = tiempoRecorrido;
        this.rutaImagen = rutaImagen;
        this.obras = new ArrayList<>();
    }

    // Constructor necesario para cargar exposicion
    public Exposicion(int id, String nombre, int tiempoRecorrido, String rutaImagen, List<Obra> obras) {
        this.nombre = nombre;
        this.id = id;
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

    public int getTiempoRecorrido() {
        return tiempoRecorrido;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public List<Obra> getObras() {
        return obras;
    }

    // ####################### - Setters - #######################
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTiempoRecorrido(int tiempoRecorrido) {
        this.tiempoRecorrido = tiempoRecorrido;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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
