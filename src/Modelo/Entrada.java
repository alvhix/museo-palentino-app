package Modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Álvaro
 */
public class Entrada {
    private boolean esGuiada;
    private int numEntrada;
    private int idCliente;
    private float precio;
    private float suplementoGuia;
    private Date fecha;
    private String nombreCliente, dniCliente;
    private String hora;
    private Timestamp fechaTransaccion;

    public Entrada() {
    }

    // Constructor reserva de entradas (Cliente)
    public Entrada(int numEntrada, Date fecha, String hora, boolean esGuiada, float precio, int idCliente) {
        this.numEntrada = numEntrada;
        this.fecha = fecha;
        this.hora = hora;
        this.esGuiada = esGuiada;
        this.precio = precio;
        this.idCliente = idCliente;
    }

    // Constructor carga de entradas asociadas a un guía (Guía)
    public Entrada(String dniCliente, Date fecha, String hora, Timestamp fechaTransaccion, float precio) {
        this.dniCliente = dniCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaTransaccion = fechaTransaccion;
        this.precio = precio;
    }

    // Constructor que carga todas las entradas (Administrador)
    public Entrada(String nombreCliente, String dniCliente, Date fecha, String hora, boolean esGuiada, Timestamp fechaTransaccion, float precio) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.esGuiada = esGuiada;
        this.fechaTransaccion = fechaTransaccion;
        this.precio = precio;
    }

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

    public Timestamp getFechaTransaccion() {
        return fechaTransaccion;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

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

    public void setFechaTransaccion(Timestamp fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
