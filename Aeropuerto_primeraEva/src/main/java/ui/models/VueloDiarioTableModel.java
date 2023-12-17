/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.models;

import dto.VueloDiario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laura
 */
public class VueloDiarioTableModel extends AbstractTableModel{
 private List<VueloDiario> listVD;
 
   private String[] columnas={
        "Código VB","Fecha","Plazas", "Precio", "Hora Salida", "Hora Llegada"
    };

    /**
     *
     * @param listVD
     */
    public VueloDiarioTableModel (List<VueloDiario>listVD ){
        this.listVD=listVD;
    }
            
    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return listVD.size();
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
               return listVD.get(rowIndex).getCodigoVueloBase();
           case 1:
               return listVD.get(rowIndex).getFechaVuelo();
           case 2:
                return listVD.get(rowIndex).getNumPlazasOcupadas();
           case 3:
               return listVD.get(rowIndex).getPrecioVuelo();
           case 4:
               return listVD.get(rowIndex).getHoraSalidaReal();
           case 5:
               return listVD.get(rowIndex).getHoraLlegadaReal();
           
          
                       
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
