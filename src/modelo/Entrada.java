package modelo;

import java.util.Date;

/**
 *
 * @author Álvaro
 */
public class Entrada {

    // Atributos ------------------------------------
    private boolean esGuiada;
    private int numEntrada;
    private int idCliente;
    private int numGuia;
    private float precio;
    private float suplementoGuia;
    private Date fecha;
    private String hora;

    // Constructores -----------------------------------
    public Entrada(int numEntrada, Date fecha, String hora, boolean esGuiada, float precio, int idCliente, int numGuia) {
        this.numEntrada = numEntrada;
        this.fecha = fecha;
        this.hora = hora;
        this.esGuiada = esGuiada;
        this.precio = precio;
        this.idCliente = idCliente;
        this.numGuia = numGuia;
    }

    public Entrada(Date fecha, boolean esGuiada) {
        this.fecha = fecha;
        this.esGuiada = esGuiada;
    }

    public Entrada() {

    }

    // Getters -----------------------------------
    public int getNumEntrada() {
        return numEntrada;
    }

    public float getPrecio() {
        return precio;
    }

    public float getSuplementoGuia() {
        return suplementoGuia;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public boolean getEsGuiada() {
        return esGuiada;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumGuia() {
        return numGuia;
    }

    // Setters -----------------------------------
    public void setNumEntrada(int numEntrada) {
        this.numEntrada = numEntrada;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setSuplementoGuia(float suplementoGuia) {
        this.suplementoGuia = suplementoGuia;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEsGuiada(boolean esGuiada) {
        this.esGuiada = esGuiada;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNumGuia(int numGuia) {
        this.numGuia = numGuia;
    }

}
