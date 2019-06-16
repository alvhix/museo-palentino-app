/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor y Guillermo
 */
public class Plantilla {
    //Atributos -----------------------------------------------------
    private List<Empleado> plantilla;
    
    //Constructores ---------------------------------------------------------
    // Constructor para crear plantilla
    public Plantilla(){
        plantilla = new ArrayList();
    }
    
    //Constructor para cargar plantilla
    public Plantilla(ArrayList p){
        plantilla = p;
    }
    // Getter ----------------------------------------------------------------
    public List getPlantilla(){
        return plantilla;
    }
    // Métodos ----------------------------------------------------------------
    public void annadirEmpleado(Empleado e) {
        plantilla.add(e);
    }

    public void eliminarEmpleado(Empleado e) {
        plantilla.remove(e);
    }
    
    public String[][] verPlantilla(){        
        String[][] datos = null;
        
        if(!plantilla.isEmpty()){
            datos = new String[plantilla.size()][5];
            
            for(int i=0; i<plantilla.size(); i++){
                Guia g = (Guia) plantilla.get(i);
                
                datos[i][0] = String.valueOf(g.getNGuia());
                datos[i][1] = g.getNombre();
                datos[i][2] = g.getDNI();
                datos[i][3] = String.valueOf(g.getTelefono());
                datos[i][4] = String.valueOf(g.getNSS());  
            }
        }
        
        return datos;
    }
    
}
