/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.consultas;

import dto.Municipio;
import dto.VueloBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static utils.Archivos.PATH_VUELOSBASE;
import static utils.CSV.CrearCSV.writeVueloBaseCSV;
import utils.Validaciones;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logica.Logica;
import static utils.CSV.BorrarLineasCSV.borrarLineaCSV;
import static utils.CSV.ModificarCSV.modificarLineaCSV;

/**
 *
 * @author laura
 */
public class GestionVBase extends javax.swing.JFrame {

    private HashMap<String, VueloBase> vueloBaseHashMap = new HashMap<>();
    private Logica logicaNegocio = new Logica();

    /**
     * Creates new form GestionVBase
     */

    public GestionVBase() {
        initComponents();
        llenarHorasComboBox();
        llenarMinutosComboBox();
        llenarMunicipiosComboBox();
        jLabel9.setVisible(false);

        // DocumentListener para txtCodigoVueloBase
        addTextFieldValidation(txtCodigoVueloBase, this::validarCodigoCompania);

        // DocumentListener para txtDiasOpera
        addTextFieldValidation(txtDiasOpera, this::validarDiasOpera);

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
        // Get the selected municipality code from the combo box
        String selectedCodigo = (String) cbxCodMunicipio.getSelectedItem();

        // Find the corresponding Municipio object
        Municipio selectedMunicipio = Logica.getMunicipioByCodigo(selectedCodigo);

        // Update txtCodMunicipio with the municipality name
        txtCodMunicipio.setText(selectedMunicipio.getNombreMunicipio());
    }

    private void validarDiasOpera() {
        String dias = txtDiasOpera.getText();
        if (!Validaciones.sonDiasOperativosValidos(dias)) {
            jLabel9.setVisible(true);
            jLabel9.setText("Solo vale LMXJVSD");
        } else {

            // Limpiar el mensaje de error si la validación es exitosa
            jLabel9.setText("");
        }
    }

    private void validarCodigoCompania() {
        String codigoCompania = txtCodigoVueloBase.getText();

        if (!Validaciones.esCodigoCompaniaValido(codigoCompania)) {
            // Mostrar un mensaje de error o cambiar el color del texto, etc.
            // Ejemplo de mensaje de error:
            jLabel9.setVisible(true);

            jLabel9.setText("Código de compañía no válido. 2 Caracteres, /n"
                    + "el primero en mayúscula y el segundo en mayúscula o número.");

        } else {
            // Limpiar el mensaje de error si la validación es exitosa
            jLabel9.setText("");
        }
    }
//FINDERESTRICCIONES

    private void llenarMunicipiosComboBox() {
        // Assuming that getAllMunicipios() returns a List<Municipio>
        List<Municipio> municipios = Logica.getAllMunicipios();

        // Clear the existing items in the combo box
        cbxCodMunicipio.removeAllItems();

        // Populate the combo box with municipality names
        for (Municipio municipio : municipios) {
            cbxCodMunicipio.addItem(municipio.getNombreMunicipio());
        }

        // Add a listener to the combo box to update txtCodMunicipio when an item is selected
        cbxCodMunicipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item (municipality name)
                String selectedNombre = (String) cbxCodMunicipio.getSelectedItem();

                // Use Logica method to get the corresponding municipality code
                String municipioCodigo = Logica.getCodigoByNombre(selectedNombre);

                // Set the municipality code in txtCodMunicipio text field
                txtCodMunicipio.setText(municipioCodigo);
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
        txtAeropuertoOrigen = new javax.swing.JTextField();
        txtIATA = new javax.swing.JTextField();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombredelAeropuerto = new javax.swing.JTextField();
        txtCodMunicipio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel11.setText("IATA: ");

        jLabel12.setText("Nombre");

        txtNombredelAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombredelAeropuertoActionPerformed(evt);
            }
        });

        txtCodMunicipio.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel8)
                                .addGap(115, 115, 115)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDiasOpera, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPlazas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoVueloBase, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAeropuertoOrigen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIATA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombredelAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCodMunicipio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 130, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardarVB))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxHOLh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxHOSh, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxHOSm, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxHOLm, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHOL, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHOS, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(73, 73, 73))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoVueloBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAeropuertoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtNombredelAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodMunicipio)
                    .addComponent(cbxCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
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
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarVB)
                    .addComponent(btnModificar)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(42, 42, 42)
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
        VueloBase vueloBase = new VueloBase();

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm"); //Logger.getLogger(GestionVuelosDiarios.class.getName()).log(Level.SEVERE, null, ex);
        // Get selected hours and minutes from combo boxes
        String horaSH = cbxHOSh.getSelectedItem().toString();
        String minutoSH = cbxHOSm.getSelectedItem().toString();
        String horaLH = cbxHOLh.getSelectedItem().toString();
        String minutoLH = cbxHOLm.getSelectedItem().toString();
        // Concatenate hours and minutes to form the time strings
        String horaSR = horaSH + ":" + minutoSH;
        String horaLR = horaLH + ":" + minutoLH;
        LocalTime horaSRFormateada = LocalTime.parse(horaSR, formatoHora);
        LocalTime horaLRFormateada = LocalTime.parse(horaLR, formatoHora);
        vueloBase.setCodigoVuelo(txtCodigoVueloBase.getText());
        vueloBase.setcodigoAeropuertoOrigen(txtAeropuertoOrigen.getText());

        vueloBase.setAeropuertoDestino(txtIATA.getText() + txtNombredelAeropuerto.getText() + txtCodMunicipio.getText());
        vueloBase.setNumPlazas(Integer.parseInt(txtPlazas.getText()));
        // Validate if the provided days of operation are correct
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
    }//GEN-LAST:event_btnGuardarVBActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String codigoABorrar = txtCodigoVueloBase.getText(); // Reemplaza con el código de la compañía que deseas borrar
        borrarLineaCSV(PATH_VUELOSBASE, codigoABorrar);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

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
            String nuevoAeO = txtAeropuertoOrigen.getText();
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
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtCodigoVueloBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVueloBaseActionPerformed


    }//GEN-LAST:event_txtCodigoVueloBaseActionPerformed

    private void txtNombredelAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombredelAeropuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombredelAeropuertoActionPerformed
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
    private javax.swing.JComboBox<String> cbxCodMunicipio;
    private javax.swing.JComboBox<String> cbxHOLh;
    private javax.swing.JComboBox<String> cbxHOLm;
    private javax.swing.JComboBox<String> cbxHOSh;
    private javax.swing.JComboBox<String> cbxHOSm;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblHOL;
    private javax.swing.JLabel lblHOS;
    private javax.swing.JTextField txtAeropuertoOrigen;
    private javax.swing.JLabel txtCodMunicipio;
    private javax.swing.JTextField txtCodigoVueloBase;
    private javax.swing.JTextField txtDiasOpera;
    private javax.swing.JTextField txtIATA;
    private javax.swing.JTextField txtNombredelAeropuerto;
    private javax.swing.JTextField txtPlazas;
    // End of variables declaration//GEN-END:variables
}
