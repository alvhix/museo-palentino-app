/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Modelo.Exposicion;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Victor
 */
public class ExposicionesTableModel extends AbstractTableModel {

    private final List<Exposicion> exposiciones;
    private final String[] columns = {"ID", "Nombre", "Tiempo del recorrido", "Ruta de imagen"};

    public ExposicionesTableModel(List<Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }

    public void annadirExposicion(Exposicion e) {
        exposiciones.add(e);
        fireTableDataChanged();
    }

    public void eliminarExposicion(int rowIndex) {
        exposiciones.remove(rowIndex);
        fireTableDataChanged();
    }

    public Exposicion obtenerExposicion(int rowIndex) {
        return exposiciones.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return exposiciones.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Exposicion e = exposiciones.get(rowIndex);

        switch (colIndex) {
            // Devuelve el id de la exposicion. 
            case 0:
                return e.getID();
            // Devuelve el nombre de la exposicion. 
            case 1:
                return e.getNombre();
            // Devuelve el tiempo del recorrido.
            case 2:
                return e.getTiempoRecorrido();
            // Devuelve la ruta de la imagen.
            case 3:
                return e.getRutaImagen();
            // Devuelve la Exposicion
            default:
                return e;
        }
    }

    @Override
    public String getColumnName(int colIndex) {
        return columns[colIndex];
    }
}
