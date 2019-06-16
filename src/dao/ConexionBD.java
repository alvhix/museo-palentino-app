package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionBD {

    // Atributos -----------------------------------------------
    Connection cnnt;
    Statement sttm;

    /*
    Se crea una instancia estática de la clase para que haya
    una única conexión a la base de datos
     */
    static ConexionBD instancia = null;

    // Constructor --------------------------------------------------
    private ConexionBD() {
        try {
            String host = "jdbc:mysql://remotemysql.com/";
            String database = "2CygLOTEPa";
            String parameters = "?autoReconnect=true&useSSL=false";
            String user = "2CygLOTEPa";
            String pass = "lsVAMMqj7E";
            
            cnnt = DriverManager.getConnection(host + database + parameters, user, pass);
            sttm = cnnt.createStatement();
        } catch (SQLException e) {
            System.out.println("Error de conexión con la Base de Datos.");
        }
    }

    // Métodos --------------------------------------------------------------
    public Connection getConnection() {
        return cnnt;
    }

    public Statement getStatement() {
        return sttm;
    }

    public static void crearConexion() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
    }

    public static ConexionBD instancia() {
        return instancia;
    }

    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.sttm.close();
                instancia.cnnt.close();
                instancia = null;
            } catch (SQLException e) {
            }
        }
    }

}
