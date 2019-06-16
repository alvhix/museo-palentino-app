/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenno;

import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import modelo.Exposicion;
import modelo.Obra;

/**
 *
 * @author Victor
 */
public class ExposicionTableModel extends AbstractTableModel {

    private List<Obra> obras;

    public ExposicionTableModel(Exposicion e) {
        this.obras = e.getObras();
    }
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int j) {
        // Obtenemos la obra de la fila indicada 
        Obra o = obras.get(i);
        switch (j) {
            // Nos piden el id. 
            case 0:
                return (Integer) o.getID();
            // Nos pasan el titulo. 
            case 1:
                return o.getTitulo();
            // Nos pasan el autor.
            case 2:
                return o.getAutor();
            // Nos pasan el estilo.
            case 3:
                return o.getEstilo();
            // Nos pasan el año.
            case 4:
                return o.getAnno();
            // Nos pasan el tipo. 
            case 5:
                return o.getTipo();
            // Nos pasan la ruta.
            case 6:
                return o.getRutaImagen();
        }
        return null;
    }

    @Override
    public void setValueAt(Object dato, int i, int j) {
        // Obtenemos la obra de la fila indicada 
        Obra o = obras.get(i);
        switch (j) {
            // Nos pasan el titulo. 
            case 1:
                o.setTitulo((String) dato);
                break;
            // Nos pasan el autor.
            case 2:
                o.setAutor((String) dato);
                break;
            // Nos pasan el estilo.
            case 3:
                o.setEstilo((String) dato);
                break;
            // Nos pasan el año.
            case 4:
                o.setAnno((String) dato);
                break;
            // Nos pasan el tipo. 
            case 5:
                o.setTipo((String) dato);
                break;
            // Nos pasan la ruta.
            case 6:
                o.setRutaImagen((String) dato);
                break;
        }
        TableModelEvent evento = new TableModelEvent(this, i, i, j);
        
        for (int k = 0; i < obras.size(); i++) {
            ((TableModelListener) obras.get(i)).tableChanged(evento);
        }
    }
    
    
    
}
