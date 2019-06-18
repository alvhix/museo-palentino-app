/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ConexionBD;
import dao.DAOMuseo;
import java.sql.SQLException;
import java.util.List;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Exposicion;
import modelo.Guia;

/**
 *
 * @author Todos
 */
public class SistemaMuseo {

    // Constructor ---------------------------------------------
    public SistemaMuseo() throws SQLException {
        ConexionBD.crearConexion();
    }

    // ############################# INICIO DE SESIÓN #############################
    public String obtenerRol(String dni) {
        String rol;

        try {
            // Devuelve el rol que coincida con el dni recibido por parametro
            rol = DAOMuseo.instanciar().obtenerRol(dni);
        } catch (SQLException ex) {
            rol = "";
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
        return rol;
    }

    public boolean comprobarUsuariosRegistrados(String dni) {
        boolean comprobarUsuario;

        try {
            // Comprobar si ya existe un usuario (cliente o empleado) con el mismo dni que la persona que se quiere registrar
            comprobarUsuario = DAOMuseo.instanciar().existeUsuario(dni);
        } catch (SQLException ex) {
            comprobarUsuario = false;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return comprobarUsuario;
    }

    public boolean comprobarCredenciales(String dni, String password) {
        boolean comprobarCredenciales;

        try {
            // Comprobar las credenciales de un usuario que quiere iniciar sesión
            comprobarCredenciales = DAOMuseo.instanciar().comprobarCredenciales(dni, password);
        } catch (SQLException ex) {
            comprobarCredenciales = false;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return comprobarCredenciales;
    }

    // ############################# CLIENTE #############################
    public void nuevoCliente(Cliente c, String password) {
        try {
            // Registra un nuevo cliente en la Base de Datos
            DAOMuseo.instanciar().nuevoCliente(c, password);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    public Cliente cargarCliente(String dniCliente) {
        Cliente cliente;

        try {
            cliente = DAOMuseo.instanciar().cargarCliente(dniCliente);
        } catch (SQLException ex) {
            cliente = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return cliente;
    }

    // ############################# ADMINISTRADOR #############################
    public Administrador cargarAdministrador(String dniAdmin) {
        Administrador admin;

        try {
            admin = DAOMuseo.instanciar().cargarAdministrador(dniAdmin);
        } catch (SQLException ex) {
            admin = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return admin;
    }

    // ############################# GUÍA #############################
    public void nuevoGuia(Guia g, String password) {
        try {
            //Registra un nuevo guía en la base de datos
            DAOMuseo.instanciar().nuevoGuia(g, password);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    public Guia cargarGuia(String dniGuia) {
        Guia guia;

        try {
            guia = DAOMuseo.instanciar().cargarGuia(dniGuia);
        } catch (SQLException ex) {
            guia = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return guia;
    }

    public void despedirGuia(Guia g) {

        try {

            DAOMuseo.instanciar().despedirGuia(g);

        } catch (SQLException e) {

            System.out.println(e.getSQLState());
            e.getStackTrace();
            System.out.println("Error al borrar");
        }

    }

    // ############################# EXPOSICIÓN #############################
    public Exposicion cargarExposicion(int idExpo) {
        Exposicion exposicion;

        try {
            exposicion = DAOMuseo.instanciar().cargarExposicion(idExpo);
        } catch (SQLException ex) {
            exposicion = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return exposicion;
    }

    // ############################# ENTRADA #############################
    // Reserva la entrada
    public void reservarEntrada(Entrada e, Cliente c) {
        try {
            // Divido el flujo dependiendo de si la entrada es normal o guiada
            if (!e.getEsGuiada()) {
                c.addEntrada(e);
                DAOMuseo.instanciar().reservarEntradaNormal(e, c);
            } else if (e.getEsGuiada()) {
                c.addEntrada(e);
                DAOMuseo.instanciar().reservarEntradaGuiada(e, c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    public List cargarEntradasCliente(int id) {
        List entradasCliente;

        try {
            entradasCliente = DAOMuseo.instanciar().cargarEntradasCliente(id);
        } catch (SQLException ex) {
            entradasCliente = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return entradasCliente;
    }
    
    // Devuelve la tabla de entradas reservadas asociadas a un guía
    public List cargarEntradasGuia(int numGuia) {
        List entradasGuia;

        try {
            entradasGuia = DAOMuseo.instanciar().cargarEntradasGuia(numGuia);
        } catch (SQLException ex) {
            entradasGuia = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return entradasGuia;
    }

    // Cambia el precio general de la entrada
    public void cambiarPrecioEntrada(float precioEntrada) {
        try {
            DAOMuseo.instanciar().cambiarPrecioEntrada(precioEntrada);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    // Cambia el precio del suplemento por el guía
    public void cambiarPrecioSuplemento(float precioSuplemento) {
        try {
            DAOMuseo.instanciar().cambiarPrecioSuplemento(precioSuplemento);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    // Devuelve el precio actual de la entrada
    public float devolverPrecioEntrada() {
        float precioEntrada;

        try {
            precioEntrada = DAOMuseo.instanciar().devolverPrecioEntrada();
        } catch (SQLException ex) {
            precioEntrada = 0;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return precioEntrada;
    }

    // Devuelve el precio actual del suplemento
    public float devolverPrecioSuplemento() {
        float precioSuplemento;

        try {
            precioSuplemento = DAOMuseo.instanciar().devolverPrecioSuplemento();
        } catch (SQLException ex) {
            precioSuplemento = 0;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return precioSuplemento;
    }
}
