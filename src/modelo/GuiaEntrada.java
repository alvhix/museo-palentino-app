/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Álvaro
 */
public class GuiaEntrada {

    private int numEntrada, numIdentificacion;

    public GuiaEntrada(int numEntrada, int numIdentificacion) {
        this.numEntrada = numEntrada;
        this.numIdentificacion = numIdentificacion;
    }

    // *********** Getter ***********
    public int getNumEntrada() {
        return numEntrada;
    }

    public int getNumIdentificacion() {
        return numIdentificacion;
    }

    // *********** Setter ***********
    public void setNumEntrada(int numEntrada) {
        this.numEntrada = numEntrada;
    }

    public void setNumIdentificacion(int numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

}
