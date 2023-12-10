package ui;

import api.AEMET_API;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Temperaturas;

public class ConsultaTempsPanel extends JPanel {

    private static AEMET_API aemetApi = new AEMET_API();

    public ConsultaTempsPanel() {
        setLayout(new GridLayout(4, 2));

        JTextField aeropuertoTextField = new JTextField(10);
        JTextField municipioTextField = new JTextField(10);
        JButton consultarButton = new JButton("Consultar Temperaturas");
        JLabel resultadoLabel = new JLabel();

        consultarButton.addActionListener(e -> {
            String aeropuertoCodigo = aeropuertoTextField.getText();
            String municipioCodigo = municipioTextField.getText();

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

        add(new JLabel("Código Aeropuerto:"));
        add(aeropuertoTextField);
        add(new JLabel("Código Municipio:"));
        add(municipioTextField);
        add(consultarButton);
        add(new JLabel());
        add(new JLabel());
        add(resultadoLabel);
    }

    private Temperaturas consultarTemperaturas(String aeropuertoCodigo, String municipioCodigo) {
        try {
            return aemetApi.getTemperaturas(aeropuertoCodigo, municipioCodigo);
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    private void handleException(Exception e) {
        System.out.println("Error occurred:");
        e.printStackTrace();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Consulta de Temperaturas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ConsultaTempsPanel consultaTempsPanel = new ConsultaTempsPanel();
            frame.getContentPane().add(consultaTempsPanel);

            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
