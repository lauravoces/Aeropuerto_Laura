/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.consultas;

import dto.VueloBase;
import dto.VueloDiario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logica.Logica;
import ui.panelAyudaVD;
import static utils.Archivos.PATH_VUELODIARIO;
import static utils.CSV.BorrarLineasCSV.borrarLineaCSV;
import static utils.CSV.CrearCSV.writeVueloDiarioCSV;
import static utils.CSV.ModificarCSV.modificarLineaCSV;
import utils.Validaciones;

/**
 *
 * @author laura
 */
public class GestionVDiario extends javax.swing.JFrame {

    private HashMap<String, VueloDiario> vueloDiarioHashMap = new HashMap<>();
    private HashMap<String, VueloBase> vueloBaseHashMap = new HashMap<>();
    private panelAyudaVD ayudaFrame = new panelAyudaVD();

    /**
     * Creates new form GestionVDiario
     */
    public GestionVDiario() {
        initComponents();
        llenarHorasComboBox();
        llenarMinutosComboBox();
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

        //otras cosas
        llenarVueloBase();

        // DocumentListener para fechas
        addTextFieldValidation(txtFechaVueloDiario, this::validarFecha);
        addTextFieldValidation(txtPlazasOcupadas, this::validarPlazas);
        addTextFieldValidation(txtPrecioVuelo, this::validarPlazas);//Total, es otro entero

    }

    //RESTRICCIONES
    private void validarPlazas() {
        String entero = txtPlazasOcupadas.getText();
        if (!Validaciones.esEntero(entero)) {
            jLabel9.setVisible(true);
            jLabel9.setText("Error, solo numero entero");
        } else {
            jLabel9.setText("");
        }
    }

    private void validarFecha() {
        String fecha = txtFechaVueloDiario.getText();
        if (!Validaciones.esFechaValida(fecha)) {
            jLabel9.setVisible(true);
            jLabel9.setText("Fecha: yyyy-MM-dd");
        } else {

            // Limpiar el mensaje de error si la validación es exitosa
            jLabel9.setText("");
        }
    }

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

    private void llenarVueloBase() {
        List<VueloBase> compA = Logica.getAllVuelosBase();

        cbxVBcod.removeAllItems();

        for (VueloBase a : compA) {
            cbxVBcod.addItem(a.getCodigoVuelo());

        }

        cbxVBcod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedNombre = (String) cbxVBcod.getSelectedItem();

                lblVBcod.setText(selectedNombre);

            }
        });
    }

    private void llenarHorasComboBox() {
        cbxHorasSR.addItem("00");
        for (int i = 1; i < 24; i++) {
            cbxHorasSR.addItem(String.format("%02d", i));
        }

        cbxHorasLR.addItem("00");
        for (int i = 1; i < 24; i++) {
            cbxHorasLR.addItem(String.format("%02d", i));
        }
    }

    private void llenarMinutosComboBox() {
        for (int i = 0; i < 60; i++) {
            cbxMinutosSR.addItem(String.format("%02d", i));
            cbxMinutosLR.addItem(String.format("%02d", i));
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

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioVuelo = new javax.swing.JTextField();
        btnGuardarVD2 = new javax.swing.JButton();
        txtPlazasOcupadas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxHorasLR = new javax.swing.JComboBox<>();
        cbxMinutosLR = new javax.swing.JComboBox<>();
        lblHoraLR = new javax.swing.JLabel();
        lblHoraSR = new javax.swing.JLabel();
        cbxMinutosSR = new javax.swing.JComboBox<>();
        cbxHorasSR = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaVueloDiario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bntAyuda = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblVBcod = new javax.swing.JLabel();
        cbxVBcod = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gestión de Vuelos Diarios");
        jLabel8.setToolTipText("");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardarVD2.setText("Guardar");
        btnGuardarVD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVD2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Precio del vuelo:");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Número de plazas ocupadas:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Hora llegada real:");

        cbxHorasLR.setToolTipText("");
        cbxHorasLR.setName(""); // NOI18N
        cbxHorasLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHorasLRActionPerformed(evt);
            }
        });

        cbxMinutosLR.setToolTipText("");
        cbxMinutosLR.setName(""); // NOI18N
        cbxMinutosLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMinutosLRActionPerformed(evt);
            }
        });

        lblHoraLR.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblHoraLR.setText("00:00");

        lblHoraSR.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblHoraSR.setText("00:00");

        cbxMinutosSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMinutosSRActionPerformed(evt);
            }
        });

        cbxHorasSR.setToolTipText("");
        cbxHorasSR.setName(""); // NOI18N
        cbxHorasSR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHorasSRItemStateChanged(evt);
            }
        });
        cbxHorasSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHorasSRActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Hora salida real:");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Fecha de vuelo:");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Código:");

        bntAyuda.setText("Ayuda");
        bntAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAyudaActionPerformed(evt);
            }
        });

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel7.setText("*El mismo que VB");

        lblVBcod.setText("jLabel9");

        cbxVBcod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarVD2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFechaVueloDiario)
                                .addComponent(txtPlazasOcupadas)
                                .addComponent(txtPrecioVuelo)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbxHorasLR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbxMinutosLR, 0, 1, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbxHorasSR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbxMinutosSR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(59, 59, 59)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblHoraSR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblHoraLR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblVBcod)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxVBcod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntAyuda)
                            .addComponent(jButton6))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bntAyuda))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(lblVBcod)
                    .addComponent(cbxVBcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaVueloDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxHorasSR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMinutosSR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraSR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxHorasLR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMinutosLR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraLR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlazasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarVD2)
                            .addComponent(jButton6)
                            .addComponent(btnModificar)
                            .addComponent(btnBorrar))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private HashMap<String, VueloDiario> obtenerHashMapActual() {
        // Devolver el HashMap almacenado en tu formulario
        return vueloDiarioHashMap;
    }
    private void btnGuardarVD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVD2ActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "Estas Seguro?", "Comprobacion", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
        VueloDiario vueloDiario = new VueloDiario();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm"); //Logger.getLogger(GestionVuelosDiarios.class.getName()).log(Level.SEVERE, null, ex);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String horaSR = lblHoraSR.getText();
        String horaLR = lblHoraLR.getText();
        LocalDate fechaVuelo = LocalDate.parse(txtFechaVueloDiario.getText(), dateFormat);
        LocalTime horaSRFormateada = LocalTime.parse(horaSR, formatoHora);
        LocalTime horaLRFormateada = LocalTime.parse(horaLR, formatoHora);
        vueloDiario.setCodigoVueloBase(lblVBcod.getText());
        vueloDiario.setNumPlazasOcupadas(Integer.parseInt(txtPlazasOcupadas.getText()));
        vueloDiario.setPrecioVuelo(Float.parseFloat(txtPrecioVuelo.getText()));
        vueloDiario.setFechaVuelo(fechaVuelo);
        vueloDiario.setHoraSalidaReal(horaSRFormateada);
        vueloDiario.setHoraLlegadaReal(horaLRFormateada);
        //HashMap actual de VueloDiario
        HashMap<String, VueloDiario> vueloDiarioMap = obtenerHashMapActual();
        //Instancia al HashMap
        vueloDiarioMap.put(vueloDiario.getCodigoVueloBase(), vueloDiario);
        //Escritura de csv
        writeVueloDiarioCSV(PATH_VUELODIARIO, vueloDiarioMap);
        System.out.println(vueloDiario.getCodigoVueloBase() + " " + vueloDiario.getPrecioVuelo() + " ");
        btnGuardarVD2.setEnabled(false);
        
        } else if (resultado == JOptionPane.NO_OPTION) {
            jLabel9.setText("No se ha guardado el vuelo diario");
        }   

    }//GEN-LAST:event_btnGuardarVD2ActionPerformed

    private void cbxHorasLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHorasLRActionPerformed
        actualizarLabel(lblHoraLR, cbxHorasLR, cbxMinutosLR);
    }//GEN-LAST:event_cbxHorasLRActionPerformed

    private void cbxMinutosLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMinutosLRActionPerformed
        actualizarLabel(lblHoraLR, cbxHorasLR, cbxMinutosLR);
    }//GEN-LAST:event_cbxMinutosLRActionPerformed

    private void cbxMinutosSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMinutosSRActionPerformed
        actualizarLabel(lblHoraSR, cbxHorasSR, cbxMinutosSR);
    }//GEN-LAST:event_cbxMinutosSRActionPerformed

    private void cbxHorasSRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHorasSRItemStateChanged


    }//GEN-LAST:event_cbxHorasSRItemStateChanged

    private void cbxHorasSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHorasSRActionPerformed
        actualizarLabel(lblHoraSR, cbxHorasSR, cbxMinutosSR);
    }//GEN-LAST:event_cbxHorasSRActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        mostrarPanelEnVentana(ayudaFrame, "Ayuda");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cerrar el formulario actual
        dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void bntAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAyudaActionPerformed

        mostrarPanelEnVentana(ayudaFrame, "Ayuda");

    }//GEN-LAST:event_bntAyudaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Cerrar el formulario actual
        dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        String codigoABorrar = lblVBcod.getText(); // Reemplaza con el código de la compañía que deseas borrar
        borrarLineaCSV(PATH_VUELODIARIO, codigoABorrar);        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm"); //Logger.getLogger(GestionVuelosDiarios.class.getName()).log(Level.SEVERE, null, ex);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String horaSR = lblHoraSR.getText();
        String horaLR = lblHoraLR.getText();

        LocalDate fechaVuelo = LocalDate.parse(txtFechaVueloDiario.getText(), dateFormat);
        LocalTime horaSRFormateada = LocalTime.parse(horaSR, formatoHora);
        LocalTime horaLRFormateada = LocalTime.parse(horaLR, formatoHora);
        String codVuelo = lblVBcod.getText();
        String numPlazasOcupadas = txtPlazasOcupadas.getText();
        String precioVuelo = txtPrecioVuelo.getText();

        /*vueloDiario.getCodigoVueloBase(), fechaStr,
                        vueloDiario.getNumPlazasOcupadas(), vueloDiario.getPrecioVuelo(),
                        horaSalidaStr, horaLlegadaStr,*/
        // Construir la línea actualizada para el CSV
        String linea = String.format("%s;%s;%d;%.1f;%s;%s%s\n",
                codVuelo, fechaVuelo,
                numPlazasOcupadas, precioVuelo, horaSRFormateada,
                horaLRFormateada);

        // Llamar al método para modificar la línea en el archivo CSV
        modificarLineaCSV(PATH_VUELODIARIO, codVuelo, linea);
        System.out.println(linea);
    }//GEN-LAST:event_btnModificarActionPerformed
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
            java.util.logging.Logger.getLogger(GestionVDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionVDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionVDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionVDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionVDiario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAyuda;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardarVD2;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxHorasLR;
    private javax.swing.JComboBox<String> cbxHorasSR;
    private javax.swing.JComboBox<String> cbxMinutosLR;
    private javax.swing.JComboBox<String> cbxMinutosSR;
    private javax.swing.JComboBox<String> cbxVBcod;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblHoraLR;
    private javax.swing.JLabel lblHoraSR;
    private javax.swing.JLabel lblVBcod;
    private javax.swing.JTextField txtFechaVueloDiario;
    private javax.swing.JTextField txtPlazasOcupadas;
    private javax.swing.JTextField txtPrecioVuelo;
    // End of variables declaration//GEN-END:variables
}
