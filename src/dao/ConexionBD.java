package dao;

import excepciones.ConexionBDException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    // Atributos -----------------------------------------------
    private Connection cntn;
    private Statement stmt;

    /*
    Se crea una instancia estática de la clase para que haya
    una única conexión a la base de datos
     */
    private static ConexionBD instancia = null;

    // Constructor --------------------------------------------------
    private ConexionBD() throws ConexionBDException {
        try {
            String host = "jdbc:mysql://remotemysql.com/";
            String database = "2CygLOTEPa";
            String parameters = "?autoReconnect=true&useSSL=false";
            String user = "2CygLOTEPa";
            String pass = "lsVAMMqj7E";

            cntn = DriverManager.getConnection(host + database + parameters, user, pass);
            stmt = cntn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            throw new ConexionBDException();
        }
    }

    public static void crearConexion() throws ConexionBDException {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
    }

    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.stmt.close();
                instancia.cntn.close();
                instancia = null;
            } catch (SQLException ex) {
                System.out.println(ex.getSQLState());
                ex.getStackTrace();
            }
        }
    }

    // Métodos --------------------------------------------------------------
    public Connection getConnection() {
        return cntn;
    }

    static ConexionBD instancia() {
        return instancia;
    }

    public Statement getStatement() {
        return stmt;
    }

}
