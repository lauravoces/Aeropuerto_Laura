/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.tablemode;
import logica.Logica;
import dto.Aeropuerto;
import dto.VueloDiario;
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
    public AeropuertosTableModel (List<Aeropuerto>listAero ){
        this.listAero=listAero;
    }
            
    @Override
    public int getRowCount() {
        return listAero.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

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

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    
} 