/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import javax.swing.*;

/**
 * @author Álvaro
 */
public class FechaException extends Exception {

    public FechaException() {
        JOptionPane.showMessageDialog(null, "No ha elegido una fecha de reserva", "Error al reservar", JOptionPane.ERROR_MESSAGE);
    }

}
