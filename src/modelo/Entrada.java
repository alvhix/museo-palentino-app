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
    private float precio;
    private float suplementoGuia;
    private Date fecha;
    private String hora;
    private String fechaTransaccion;

    // Constructores -----------------------------------
    public Entrada(int numEntrada, Date fecha, String hora, boolean esGuiada, float precio, int idCliente) {
        this.numEntrada = numEntrada;
        this.fecha = fecha;
        this.hora = hora;
        this.esGuiada = esGuiada;
        this.precio = precio;
        this.idCliente = idCliente;
    }

    public Entrada(int numEntrada, Date fecha, String hora, String fechaTransaccion) {
        this.numEntrada = numEntrada;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaTransaccion = fechaTransaccion;
    }

    public Entrada() {

    }

    // Getters -----------------------------------
    public boolean getEsGuiada() {
        return esGuiada;
    }

    public int getNumEntrada() {
        return numEntrada;
    }

    public int getIdCliente() {
        return idCliente;
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

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    // Setters -----------------------------------
    public void setEsGuiada(boolean esGuiada) {
        this.esGuiada = esGuiada;
    }

    public void setNumEntrada(int numEntrada) {
        this.numEntrada = numEntrada;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

}
