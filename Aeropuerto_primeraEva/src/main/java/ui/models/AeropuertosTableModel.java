/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.models;

import dto.Aeropuerto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laura
 */
public class AeropuertosTableModel extends AbstractTableModel {
    private List<Aeropuerto> listAero;
    
    private String[] columnas={
        "Código","Nombre","Municipio"
    };

    /**
     *
     * @param listAero
     */
    public AeropuertosTableModel (List<Aeropuerto>listAero ){
        this.listAero=listAero;
    }
            
    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return listAero.size();
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0:
               return listAero.get(rowIndex).getCodigoIATA();
           case 1:
               return listAero.get(rowIndex).getNombre();
           case 2:
                return listAero.get(rowIndex).getCodigoMunicipio();
          
                       
        }
        return null;
    
    }

    /**
     *
     * @param column
     * @return
     */
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    
} 