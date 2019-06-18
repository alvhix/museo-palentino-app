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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Exposicion;
import modelo.Guia;
import modelo.Obra;

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
    
    // #################### CAMBIAR DE CONTRASEÑA ########################
    
    public boolean cambiarContraseña(String contraseñaAntigua, String contraseñaNueva, String dniUsuario){
        boolean cambiada;
        
        try{
            cambiada = DAOMuseo.instanciar().cambiarContraseña(contraseñaAntigua, contraseñaNueva, dniUsuario);
        }
        catch(SQLException e){
            cambiada = false;
            System.out.println(e.getSQLState());
            e.getStackTrace();
        }
        return cambiada;
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

    public long comprobarTarjeta(int idCliente) {
        long tarjeta;
        try {
            tarjeta = DAOMuseo.instanciar().obtenerTarjetaCliente(idCliente);
        } catch (SQLException ex) {
            tarjeta = 0;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
        return tarjeta;
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
    public boolean comprobarSiExisteExposicion(String nombre) {
        boolean comprobarUsuario;

        try {
            comprobarUsuario = DAOMuseo.instanciar().existeUsuario(nombre);
        } catch (SQLException ex) {
            comprobarUsuario = false;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return comprobarUsuario;
    }

    public void nuevaExposicion(Exposicion e) {
        try {
            DAOMuseo.instanciar().nuevaExposicion(e);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    public void eliminarExposicion(int id) {
        try {
            DAOMuseo.instanciar().eliminarExposicion(id);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

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

    public Exposicion cargarExposicion(String nombre) {
        Exposicion exposicion;

        try {
            exposicion = DAOMuseo.instanciar().cargarExposicion(nombre);
        } catch (SQLException ex) {
            exposicion = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return exposicion;
    }

    // ############################# OBRA #############################
    public boolean comprobarSiExisteObra(String titulo, String autor, String anno, String tipo) {
        boolean comprobarUsuario;

        try {
            comprobarUsuario = DAOMuseo.instanciar().existeObra(titulo, autor, anno, tipo);
        } catch (SQLException ex) {
            comprobarUsuario = false;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return comprobarUsuario;
    }

    public void nuevaObra(Obra o) {
        try {
            DAOMuseo.instanciar().nuevaObra(o);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    public void eliminarObra(int id) {
        try {
            DAOMuseo.instanciar().eliminarObra(id);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }
    }

    public Obra cargarObra(int idObra) {
        Obra obra;

        try {
            obra = DAOMuseo.instanciar().cargarObra(idObra);
        } catch (SQLException ex) {
            obra = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return obra;
    }

    public Obra cargarObra(String titulo, String autor) {
        Obra obra;

        try {
            obra = DAOMuseo.instanciar().cargarObra(titulo, autor);
        } catch (SQLException ex) {
            obra = null;
            System.out.println(ex.getSQLState());
            ex.getStackTrace();
        }

        return obra;
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

    public String[][] tablaEntradas(List<Entrada> entradas) {
        String[][] array = new String[entradas.size()][4];
        String esGuiada;

        if (!entradas.isEmpty()) {
            for (int i = 0; i < entradas.size(); i++) {
                Entrada e = entradas.get(i);
                array[i][0] = String.valueOf(new java.sql.Date(e.getFecha().getTime()));
                array[i][1] = e.getHora();

                if (e.getEsGuiada()) {
                    esGuiada = "Si";

                } else {
                    esGuiada = "No";
                }

                array[i][2] = esGuiada;
                array[i][3] = String.format("%.2f €", e.getPrecio());
            }
        }

        return array;
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
