/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenno;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Exposicion;

/**
 *
 * @author Victor
 */
public class ExposicionesTableModel extends AbstractTableModel {

    private List<Exposicion> exposiciones;
    private String[] columns = {"ID", "Nombre", "Disponible hasta", "Tiempo del recorrido", "Ruta de imagen"};

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
            // Devuelve el id. 
            case 0:
                return e.getID();
            // Devuelve el titulo. 
            case 1:
                return e.getNombre();
            // Devuelve el autor.
            case 2:
                return e.getDuracion();
            // Devuelve el estilo.
            case 3:
                return e.getTiempoRecorrido();
            // Devuelve el año.
            case 4:
                return e.getRutaImagen();
            // Devuelve la Exposicion
            default:
                return e;
        }
    }

    @Override
    public void setValueAt(Object dato, int rowIndex, int colIndex) {
        // Obtenemos la obra de la fila indicada 
        Exposicion e = exposiciones.get(rowIndex);
        switch (colIndex) {
            case 1:
                e.setNombre((String) dato);
                break;
            case 2:
                e.setDuracion((Date) dato);
                break;
            case 3:
                e.setTiempoRecorrido((Integer) dato);
                break;
            case 4:
                e.setRutaImagen((String) dato);
                break;
        }
    }

    @Override
    public String getColumnName(int colIndex) {
        return columns[colIndex];
    }
}
