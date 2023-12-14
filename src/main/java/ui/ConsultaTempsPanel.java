package ui;

import api.AEMET_API;
import dto.Aeropuerto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.*;
import logica.Logica;
import utils.Temperaturas;

/**
 * Panel para consultar temperaturas con componentes Swing.
 * Este panel tiene un JComboBox para seleccionar el aeropuerto, un botón para consultar las temperaturas,
 * y muestra el código del aeropuerto, el municipio y el resultado en JLabels.
 * Por algun motivo incierto ahora no me deja usarlo como componente... pero en su momento me dejó.
 * Y no he cambiado nada. Por eso está ahí en Info y no me da fallos en tiempo de ejecución.
 * Lo único que hice fue cambiarlo a un combobox y ahora no me quiere funcionar, pero la clase Info es testigo de que en su momento
 * Lo agregé a paleta y lo añadí....
 */

public class ConsultaTempsPanel extends JPanel implements Serializable{

    private static AEMET_API aemetApi = new AEMET_API();
    private JComboBox<String> cbxAeropuerto;
    private JLabel lblCodA;
    private JLabel lblMuni;
    private JLabel resultadoLabel;

    /**
     * Constructor del panel.
     */
      public ConsultaTempsPanel() {
        initComponents();
    }
    private void initComponents() {
        setLayout(new GridLayout(5, 2));

        cbxAeropuerto = new JComboBox<>();
        lblCodA = new JLabel("*");
        lblMuni = new JLabel("*");
        resultadoLabel = new JLabel();

        JButton consultarButton = new JButton("Consultar Temperaturas");

        llenarComp(); 

        consultarButton.addActionListener(e -> {
            String selectedNombre = (String) cbxAeropuerto.getSelectedItem();
            String aeropuertoCodigo = Logica.getCodigoAeropuerto(selectedNombre);
            String municipioCodigo = Logica.getMuniAeropuerto(selectedNombre);

            try {
                Temperaturas temperaturas = consultarTemperaturas(aeropuertoCodigo, municipioCodigo);
                if (temperaturas != null) {
                    resultadoLabel.setText("<html>Temperatura Mínima: " + temperaturas.getMinTemp() +
                            "<br>Temperatura Máxima: " + temperaturas.getMaxTemp() + "</html>");
                } else {
                    resultadoLabel.setText("Error al consultar las temperaturas.");
                }
            } catch (Exception ex) {
                handleException(ex);
                resultadoLabel.setText("Error al consultar las temperaturas.");
            }
        });

        add(new JLabel("Seleccionar Aeropuerto:"));
        add(cbxAeropuerto);
        add(new JLabel("Código Aeropuerto:"));
        add(lblCodA);
        add(new JLabel("Municipio:"));
        add(lblMuni);
        add(consultarButton);
        add(new JLabel());
        add(new JLabel());
        add(resultadoLabel);
    }

    /**
     * Método para llenar el JComboBox con los aeropuertos.
     */
    private void llenarComp() {
        List<Aeropuerto> compA = Logica.getAllAeropuertos();
        cbxAeropuerto.removeAllItems();

        for (Aeropuerto a : compA) {
            cbxAeropuerto.addItem(a.getNombre());
        }

        cbxAeropuerto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedNombre = (String) cbxAeropuerto.getSelectedItem();
                String codigoIATA = Logica.getCodigoAeropuerto(selectedNombre);
                String municipioCodigo = Logica.getMuniAeropuerto(selectedNombre);

                lblCodA.setText(codigoIATA);
                lblMuni.setText(municipioCodigo);
            }
        });
    }

    /**
     * Método para consultar las temperaturas.
     *
     * @param aeropuertoCodigo Código del aeropuerto.
     * @param municipioCodigo Código del municipio.
     * @return Objeto Temperaturas con las temperaturas consultadas.
     */
    private Temperaturas consultarTemperaturas(String aeropuertoCodigo, String municipioCodigo) {
        try {
            return aemetApi.getTemperaturas(aeropuertoCodigo, municipioCodigo);
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Maneja las excepciones imprimiendo el stack trace en la consola.
     *
     * @param e Excepción.
     */
    private void handleException(Exception e) {
        System.out.println("Error occurred:");
        e.printStackTrace();
    }

    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Consulta de Temperaturas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ConsultaTempsPanel consultaTempsPanel = new ConsultaTempsPanel();
            frame.getContentPane().add(consultaTempsPanel);

            frame.setSize(400, 250);
            frame.setVisible(true);
        });
    }
}
