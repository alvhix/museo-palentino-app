/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenno;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Administrador;
import modelo.Obra;

/**
 *
 * @author Victor
 */
public class ExposicionTableModel extends AbstractTableModel {

    private List<Obra> obras;
    private String[] columns = {"ID", "Titulo", "Autor", "Estilo", "Año", "Tipo", "Ruta de imagen"};
    
    public ExposicionTableModel(Administrador a){
        
    }

    public void annadirObra(Obra o) {
        obras.add(o);
        fireTableDataChanged();
    }

    public void eliminarObra(int rowIndex) {
        obras.remove(rowIndex);
        fireTableDataChanged();
    }

    public Obra obtenerObra(int rowIndex) {
        return obras.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return obras.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Obra o = obras.get(rowIndex);

        switch (colIndex) {
            // Devuelve el id. 
            case 0:
                return o.getID();
            // Devuelve el titulo. 
            case 1:
                return o.getTitulo();
            // Devuelve el autor.
            case 2:
                return o.getAutor();
            // Devuelve el estilo.
            case 3:
                return o.getEstilo();
            // Devuelve el año.
            case 4:
                return o.getAnno();
            // Devuelve el tipo. 
            case 5:
                return o.getTipo();
            // Devuelve la ruta.
            case 6:
                return o.getRutaImagen();
            // Devuelve la Obra
            default:
                return o;
        }
    }

    @Override
    public void setValueAt(Object dato, int rowIndex, int colIndex) {
        // Obtenemos la obra de la fila indicada 
        Obra o = obras.get(rowIndex);
        switch (colIndex) {
            case 1:
                o.setTitulo((String) dato);
                break;
            case 2:
                o.setAutor((String) dato);
                break;
            case 3:
                o.setEstilo((String) dato);
                break;
            case 4:
                o.setAnno((String) dato);
                break;
            case 5:
                o.setTipo((String) dato);
                break;
            case 6:
                o.setRutaImagen((String) dato);
                break;
        }
    }

    @Override
    public String getColumnName(int colIndex) {
        return columns[colIndex];
    }
}
