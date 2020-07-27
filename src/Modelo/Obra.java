/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * @author Victor, Mario y Alberto
 */
public class Obra {

    private int id;
    private final int idExposicion;
    private final String titulo;
    private final String estilo;
    private final String autor;
    private final String tipo;
    private final String anno;
    private final String rutaImagen;

    // Constructor para nueva obra
    public Obra(String titulo, String autor, String estilo, String anno, String tipo, String rutaImagen, int idExposicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.estilo = estilo;
        this.anno = anno;
        this.tipo = tipo;
        this.rutaImagen = rutaImagen;
        this.idExposicion = idExposicion;
    }

    // Constructor necesario para cargar obra
    public Obra(int id, String titulo, String autor, String estilo, String anno, String tipo, String rutaImagen, int idExposicion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estilo = estilo;
        this.anno = anno;
        this.tipo = tipo;
        this.rutaImagen = rutaImagen;
        this.idExposicion = idExposicion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAnno() {
        return anno;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public int getIdExposicion() {
        return idExposicion;
    }
}
