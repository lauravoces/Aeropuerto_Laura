/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.models;

import dto.VueloBase;
import dto.VueloDiario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laura
 */
public class VueloBaseTableModel extends AbstractTableModel{
 private List<VueloBase> listVBB;
 /*     // Construir la línea actualizada para el CSV
            String linea = String.format("%s;%s;%s;%s;%s;%s;%s;\n",
                    nuevocod, nuevoAeO,
                    nuevoAeD, nuevasPlazas, timehoraSR,
                    timehoraLR, nuevosDias);

            // Llamar al método para modificar la línea en el arc*/
 
   private String[] columnas={
        "Código VB","Ae Origen","Ae Destino", "Plazas", "Hora Salida", "Hora Llegada", "Dias que opera"
    };

    /**
     *
     * @param listVBB
     */
    public VueloBaseTableModel (List<VueloBase>listVBB ){
        this.listVBB=listVBB;
    }
            
    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return listVBB.size();
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
               return listVBB.get(rowIndex).getCodigoVuelo();
           case 1:
               return listVBB.get(rowIndex).getAeropuertoOrigen();
           case 2:
                return listVBB.get(rowIndex).getAeropuertoDestino();
           case 3:
               return listVBB.get(rowIndex).getNumPlazas();
           case 4:
               return listVBB.get(rowIndex).getHoraOficialSalida();
           case 5:
               return listVBB.get(rowIndex).getHoraOficialLlegada();
           case 6:
               return listVBB.get(rowIndex).getDiasOpera();
           
          
                       
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
