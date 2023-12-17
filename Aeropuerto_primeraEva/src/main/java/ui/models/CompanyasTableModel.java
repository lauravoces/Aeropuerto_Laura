/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.models;

import dto.CompanyaAerea;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laura
 */
public class CompanyasTableModel extends AbstractTableModel  {

        private List<CompanyaAerea> listCmp;
        
        /*  String nuevaLinea = String.format("%s;%s;%s;%s;%s;%s;%s",
                nuevoPrefijo, codigoAModificar, nuevoNombre, nuevaDireccion,
                nuevoMunicipio, nuevoNumInfoPasajero, nuevoNumInfoAeropuerto);*/
    
    private String[] columnas={
        "Prefijo","Código","Nombre", "Dirección", "Municipio", "Telf. ATC", "Telf. Aeropuerto"
    };

    /**
     *
     * @param listCmp
     */
    public CompanyasTableModel (List<CompanyaAerea>listCmp ){
        this.listCmp=listCmp;
    }
            
    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return listCmp.size();
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
               return listCmp.get(rowIndex).getPrefijo();
           case 1:
               return listCmp.get(rowIndex).getCodigo();
           case 2:
                return listCmp.get(rowIndex).getNombre();
           case 3:
               return listCmp.get(rowIndex).getDireccion();
           case 4:
               return listCmp.get(rowIndex).getMunicipio();
           case 5:
               return listCmp.get(rowIndex).getNumInfoPasajero();
           case 6:
               return listCmp.get(rowIndex).getNumInfoAeropuerto();
          
                       
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
