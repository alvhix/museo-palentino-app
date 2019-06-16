/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Victor, Mario y Alberto
 */
public class Obra {

    private int id;
    private String titulo;
    private String estilo;
    private String autor;
    private String tipo;
    private String anno;
    private String rutaImagen;

    public Obra(int id) {

    }
    // Constructor necesario para cargar obra
    public Obra(int id, String titulo, String autor, String estilo, String anno, String tipo, String rutaImagen) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estilo = estilo;
        this.anno = anno;
        this.tipo = tipo;
        this.rutaImagen = rutaImagen;
    }

    public int getID() {
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
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
