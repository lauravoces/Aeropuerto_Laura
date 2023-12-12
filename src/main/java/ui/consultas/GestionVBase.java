/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.consultas;

import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.Municipio;
import dto.VueloBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static utils.Archivos.PATH_VUELOSBASE;
import static utils.CSV.CrearCSV.writeVueloBaseCSV;
import utils.Validaciones;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logica.Logica;
import ui.panelAyudaVB;
import static utils.CSV.BorrarLineasCSV.borrarLineaCSV;
import utils.CSV.LectorCSV;
import static utils.CSV.ModificarCSV.modificarLineaCSV;

/**
 *
 * @author laura
 */
public class GestionVBase extends javax.swing.JFrame {
private panelAyudaVB ayudaFrame = new panelAyudaVB();
    private HashMap<String, VueloBase> vueloBaseHashMap = new HashMap<>();
    private Logica logicaNegocio = new Logica();

    /**
     * Creates new form GestionVBase
     */

    public GestionVBase() {
        initComponents();
                // PARA EL F1
              // Configurar el KeyListener para detectar la tecla F1
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No necesitas implementar esto para la tecla F1
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    // Mostrar el JPanel en una nueva ventana al presionar F1
                    mostrarPanelEnVentana(ayudaFrame, "Ayuda");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No necesitas implementar esto para la tecla F1
            }
        });
         // Hacer que el JFrame sea enfocable para que pueda recibir eventos de teclado
        setFocusable(true);

        
        llenarHorasComboBox();
        llenarMinutosComboBox();
        llenarAerea();
        llenarComp();
        llenarComp2();
        jLabel9.setVisible(false);
        
        // DocumentListener para txtDiasOpera
        addTextFieldValidation(txtDiasOpera, this::validarDiasOpera);
        
        // DocumentListener para txtPlazas
        addTextFieldValidation(txtPlazas, this::validarNumPlazas);
        
      

    }
//RESTRICCIONES
    private void addTextFieldValidation(JTextField textField, Runnable validationMethod) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validationMethod.run();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validationMethod.run();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validationMethod.run();
            }
        });
    }

    private void cbxCodMunicipioActionPerformed(java.awt.event.ActionEvent evt) {
        
        String selectedCodigo = (String) cbxCodMunicipio.getSelectedItem();

       
        Municipio selectedMunicipio = Logica.getMunicipioByCodigo(selectedCodigo);

       
        txtCodMunicipio.setText(selectedMunicipio.getNombreMunicipio());
    }
    
  
    
    private void validarNumPlazas(){
      String entero = txtPlazas.getText();
      if(!Validaciones.esEntero(entero)){
           jLabel9.setVisible(true);
            jLabel9.setText("Error, solo numero entero");
      }else {
            jLabel9.setText("");
      }
    }
    
    private void validarDiasOpera() {
        String dias = txtDiasOpera.getText();
        if (!Validaciones.esDiaOperativoValido(dias)) {
            jLabel9.setVisible(true);
            jLabel9.setText("Solo vale LMXJVSD");
        } else {

            // Limpiar el mensaje de error si la validación es exitosa
            jLabel9.setText("");
        }
    }


//FINDERESTRICCIONES
private void llenarComp(){
    List<Aeropuerto> compA = Logica.getAllAeropuertos();
     
        cbxCodMunicipio.removeAllItems();
         
        for (Aeropuerto a : compA) {
              cbxCodMunicipio.addItem(a.getNombre());
        
        }
         
        cbxCodMunicipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String selectedNombre = (String) cbxCodMunicipio.getSelectedItem();

                
                String nombreAeropuerto = selectedNombre;
                String codigoIATA = Logica.getCodigoAeropuerto(selectedNombre);
                String municipioCodigo = Logica.getMuniAeropuerto(selectedNombre);

               
                txtIATA.setText(codigoIATA);
                txtNombreA.setText(nombreAeropuerto);
                txtCodMunicipio.setText(municipioCodigo);
            }
        });
}
private void llenarComp2(){
    List<Aeropuerto> compA = Logica.getAllAeropuertos();
     
        cbxOrigen.removeAllItems();
        
        for (Aeropuerto a : compA) {
              cbxOrigen.addItem(a.getNombre());
        
        }
        
        cbxOrigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String selectedNombre = (String) cbxOrigen.getSelectedItem();
                String codigoIATA = Logica.getCodigoAeropuerto(selectedNombre);
               

                
                lblCodOrigen.setText(codigoIATA);
                
            }
        });
}
private void llenarAerea(){
    List<CompanyaAerea> compA = Logica.getAllCompanyas();
  
        cbxAE.removeAllItems();
         
        for (CompanyaAerea a : compA) {
              cbxAE.addItem(a.getNombre());
        
        }
         
        cbxAE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nom = (String) cbxAE.getSelectedItem();
               
                String codComp = Logica.getCodigoCA(nom);
                lblAE.setText(codComp);
                
            }
        });
}
   

    private void llenarHorasComboBox() {
        cbxHOSh.addItem("00");
        for (int i = 1; i < 24; i++) {
            cbxHOSh.addItem(String.format("%02d", i));
        }

        cbxHOLh.addItem("00");
        for (int i = 1; i < 24; i++) {
            cbxHOLh.addItem(String.format("%02d", i));
        }
    }

    private void llenarMinutosComboBox() {
        for (int i = 0; i < 60; i++) {
            cbxHOSm.addItem(String.format("%02d", i));
            cbxHOLm.addItem(String.format("%02d", i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigoVueloBase = new javax.swing.JTextField();
        txtPlazas = new javax.swing.JTextField();
        cbxHOSh = new javax.swing.JComboBox<>();
        cbxHOSm = new javax.swing.JComboBox<>();
        cbxHOLh = new javax.swing.JComboBox<>();
        cbxHOLm = new javax.swing.JComboBox<>();
        lblHOS = new javax.swing.JLabel();
        lblHOL = new javax.swing.JLabel();
        txtDiasOpera = new javax.swing.JTextField();
        btnGuardarVB = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxCodMunicipio = new javax.swing.JComboBox<>();
        txtIATA = new javax.swing.JLabel();
        txtNombreA = new javax.swing.JLabel();
        txtCodMunicipio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblCodOrigen = new javax.swing.JLabel();
        cbxOrigen = new javax.swing.JComboBox<>();
        lblAE = new javax.swing.JLabel();
        cbxAE = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtCodigoVueloBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVueloBaseActionPerformed(evt);
            }
        });

        cbxHOSh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHOShActionPerformed(evt);
            }
        });

        cbxHOSm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHOSmActionPerformed(evt);
            }
        });

        cbxHOLh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHOLhActionPerformed(evt);
            }
        });

        cbxHOLm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHOLmActionPerformed(evt);
            }
        });

        lblHOS.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblHOS.setText("00:00");

        lblHOL.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblHOL.setText("00:00");

        btnGuardarVB.setText("Guardar");
        btnGuardarVB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVBActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Días que opera:");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Hora oficial llegada:");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Hora oficial salida:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Número de plazas:");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Aeropuerto destino:");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Aeropuerto origen:");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gestión de las Vuelo Base");
        jLabel8.setToolTipText("");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setText("Ayuda");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("jLabel9");

        cbxCodMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtIATA.setText("IATA");

        txtNombreA.setText("Nombre");

        txtCodMunicipio.setText("*");

        jLabel10.setText("*Codigo+cuatro cifras");

        jLabel11.setText("*Vale solo con el IATA");

        jLabel12.setText("*numero entero");

        jLabel13.setText("*Dias de la semana(L-D)");

        lblCodOrigen.setText("IATA");

        cbxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAE.setText("Compañia");

        cbxAE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbxHOLh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxHOSh, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxHOSm, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxHOLm, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(87, 87, 87)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblHOL, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblHOS, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(82, 82, 82)
                                        .addComponent(btnModificar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(btnGuardarVB))
                            .addComponent(txtDiasOpera)
                            .addComponent(txtPlazas)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIATA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodOrigen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(txtCodMunicipio, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE))
                                    .addComponent(cbxOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxAE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoVueloBase, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(111, 111, 111)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCodMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(0, 96, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoVueloBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(lblAE)
                    .addComponent(cbxAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(lblCodOrigen)
                    .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIATA)
                    .addComponent(txtNombreA)
                    .addComponent(txtCodMunicipio)
                    .addComponent(cbxCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxHOSh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxHOSm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHOS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbxHOLh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxHOLm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHOL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiasOpera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarVB)
                    .addComponent(btnModificar)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(80, 80, 80)
                .addComponent(jLabel9)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxHOShActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHOShActionPerformed
        actualizarLabel(lblHOS, cbxHOSh, cbxHOSm);
    }//GEN-LAST:event_cbxHOShActionPerformed

    private void cbxHOSmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHOSmActionPerformed
        actualizarLabel(lblHOS, cbxHOSh, cbxHOSm);
    }//GEN-LAST:event_cbxHOSmActionPerformed

    private void cbxHOLhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHOLhActionPerformed
        actualizarLabel(lblHOL, cbxHOLh, cbxHOLm);
    }//GEN-LAST:event_cbxHOLhActionPerformed

    private void cbxHOLmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHOLmActionPerformed
        actualizarLabel(lblHOL, cbxHOLh, cbxHOLm);
    }//GEN-LAST:event_cbxHOLmActionPerformed

    private HashMap<String, VueloBase> obtenerHashMapActual() {
        // Devolver el HashMap almacenado en tu formulario
        return vueloBaseHashMap;
    }


    private void btnGuardarVBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVBActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "Estas Seguro?", "Comprobacion", JOptionPane.YES_NO_OPTION);
        if(resultado==JOptionPane.YES_OPTION){
        VueloBase vueloBase = new VueloBase();

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm"); //Logger.getLogger(GestionVuelosDiarios.class.getName()).log(Level.SEVERE, null, ex);
       
        String horaSH = cbxHOSh.getSelectedItem().toString();
        String minutoSH = cbxHOSm.getSelectedItem().toString();
        String horaLH = cbxHOLh.getSelectedItem().toString();
        String minutoLH = cbxHOLm.getSelectedItem().toString();
       
        String horaSR = horaSH + ":" + minutoSH;
        String horaLR = horaLH + ":" + minutoLH;
        LocalTime horaSRFormateada = LocalTime.parse(horaSR, formatoHora);
        LocalTime horaLRFormateada = LocalTime.parse(horaLR, formatoHora);
        vueloBase.setCodigoVuelo(lblAE.getText()+txtCodigoVueloBase.getText());
       
        vueloBase.setcodigoAeropuertoOrigen(lblCodOrigen.getText());
        String nombreA= txtNombreA.getText().replaceAll("\\s", ""); //lo guardo sin espacios, deberia haber hecho esto tambien al guardar las companias para ser honesta
        vueloBase.setAeropuertoDestino(txtIATA.getText() + nombreA + txtCodMunicipio.getText());
        vueloBase.setNumPlazas(Integer.parseInt(txtPlazas.getText()));
        
        vueloBase.setDiasOpera(txtDiasOpera.getText());
        vueloBase.setHoraOficialSalida(horaSRFormateada);
        vueloBase.setHoraOficialLlegada(horaLRFormateada);
        
        
        // Obtener el HashMap actual de CompanyaAerea
        HashMap<String, VueloBase> vueloBaseI = obtenerHashMapActual();
        // Agregar la nueva instancia al HashMap
        vueloBaseI.put(vueloBase.getCodigoVuelo(), vueloBase);
        // Llamar al método para escribir en el archivo CSV
        writeVueloBaseCSV(PATH_VUELOSBASE, vueloBaseI);
        System.out.println(vueloBase.getCodigoVuelo() + " " + vueloBase.getNumPlazas() + " " + vueloBase.getDiasOpera());
        btnGuardarVB.setEnabled(false);
        jLabel9.setVisible(true);

            jLabel9.setText("Uno a la vez");
        }
        else if(resultado==JOptionPane.NO_OPTION){
             jLabel9.setText("No se ha guardado el vuelo");
        }
    }//GEN-LAST:event_btnGuardarVBActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String codigoABorrar = lblCodOrigen.getText(); // Reemplaza con el código de la compañía que deseas borrar
        borrarLineaCSV(PATH_VUELOSBASE, codigoABorrar);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
if(!Logica.tieneVuelosDiariosAsociados(txtCodigoVueloBase.getText())){
    

        try {

            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String horaSR = lblHOS.getText();
            String horaLR = lblHOL.getText();
            Date horaSRFormateada = formatoHora.parse(horaSR);
            Date horaLRFormateada = formatoHora.parse(horaLR);
            Time timehoraSR = new Time(horaSRFormateada.getTime());
            Time timehoraLR = new Time(horaLRFormateada.getTime());
            String nuevocod = txtCodigoVueloBase.getText();//codigo a modificar
            String nuevoAeO = lblCodOrigen.getText();
            String nuevoAeD = txtIATA.getText();
            String nuevasPlazas = txtPlazas.getText();
            String nuevosDias = txtDiasOpera.getText();

            // Construir la línea actualizada para el CSV
            String linea = String.format("%s;%s;%s;%s;%s;%s;%s;\n",
                    nuevocod, nuevoAeO,
                    nuevoAeD, nuevasPlazas, timehoraSR,
                    timehoraLR, nuevosDias);

            // Llamar al método para modificar la línea en el archivo CSV
            modificarLineaCSV(PATH_VUELOSBASE, nuevocod, linea);
            System.out.println(linea);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(GestionVuelosDiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
     btnModificar.setEnabled(false);
     btnModificar.setText("VD existente");
}
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtCodigoVueloBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVueloBaseActionPerformed


    }//GEN-LAST:event_txtCodigoVueloBaseActionPerformed
private void mostrarPanelEnVentana(JPanel panel, String titulo) {
        // Crear una nueva ventana (JFrame) para representar el JPanel
        JFrame ventanaPanel = new JFrame(titulo);

        // Configurar la ventana
        ventanaPanel.setSize(500, 300); // Ajusta el tamaño según tus necesidades
        ventanaPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Agregar el JPanel a la ventana
        ventanaPanel.add(panel);

        // Hacer visible la ventana
        ventanaPanel.setVisible(true);
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mostrarPanelEnVentana(ayudaFrame, "Ayuda");
    }//GEN-LAST:event_jButton4ActionPerformed
    private void actualizarLabel(javax.swing.JLabel label, javax.swing.JComboBox<String> cbxHoras, javax.swing.JComboBox<String> cbxMinutos) {
        String horas = cbxHoras.getSelectedItem() != null ? cbxHoras.getSelectedItem().toString() : "00";
        String minutos = cbxMinutos.getSelectedItem() != null ? cbxMinutos.getSelectedItem().toString() : "00";
        label.setText(horas + ":" + minutos);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionVBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionVBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionVBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionVBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionVBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarVB;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxAE;
    private javax.swing.JComboBox<String> cbxCodMunicipio;
    private javax.swing.JComboBox<String> cbxHOLh;
    private javax.swing.JComboBox<String> cbxHOLm;
    private javax.swing.JComboBox<String> cbxHOSh;
    private javax.swing.JComboBox<String> cbxHOSm;
    private javax.swing.JComboBox<String> cbxOrigen;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAE;
    private javax.swing.JLabel lblCodOrigen;
    private javax.swing.JLabel lblHOL;
    private javax.swing.JLabel lblHOS;
    private javax.swing.JLabel txtCodMunicipio;
    private javax.swing.JTextField txtCodigoVueloBase;
    private javax.swing.JTextField txtDiasOpera;
    private javax.swing.JLabel txtIATA;
    private javax.swing.JLabel txtNombreA;
    private javax.swing.JTextField txtPlazas;
    // End of variables declaration//GEN-END:variables
}
