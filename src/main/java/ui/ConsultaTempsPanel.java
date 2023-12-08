/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author laura
 */
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

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aeropuertoCodigo = aeropuertoTextField.getText();
                String municipioCodigo = municipioTextField.getText();

                try {
                    Temperaturas temperaturas = consultarTemperaturas(aeropuertoCodigo, municipioCodigo);
                    resultadoLabel.setText("<html>Temperatura Mínima: " + temperaturas.getMinTemp() +
                            "<br>Temperatura Máxima: " + temperaturas.getMaxTemp() + "</html>");
                } catch (Exception ex) {
                    resultadoLabel.setText("Error al consultar las temperaturas.");
                    ex.printStackTrace();
                }
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
            e.printStackTrace();
            return null;
        }
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
