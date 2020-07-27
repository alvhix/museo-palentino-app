package Excepciones;

import javax.swing.*;

public class ConexionBDException extends Exception {

    public ConexionBDException() {
        final int SALIR = 0;
        JOptionPane.showMessageDialog(null, "No ha sido posible establecer conexión con el servidor remoto, comprueba tu conexión a internet", "Error de conexión al servidor", JOptionPane.ERROR_MESSAGE);
        // Al no ser posible la conexión con la BD, el programa no se iniciará
        System.exit(SALIR);
    }
}
