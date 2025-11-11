package es.uv.eu.euroconversor.controller;


import es.uv.eu.euroconversor.model.EuroConversorModel;
import es.uv.eu.euroconversor.view.DisplayPanel;
import es.uv.eu.euroconversor.view.EuroConversorView;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * @author EU (2016)
 */
public class EuroConversorController {
    private EuroConversorModel model;
    private EuroConversorView view;
    private String boton = "DolarEuro";

    public EuroConversorController(EuroConversorModel model, EuroConversorView view){
        this.model = model;
        this.view = view;

        view.addWindowListener(new EuroConversorControllerWindowListener());
        view.setActionListener(new EuroConversorControllerActionListener());
    }

    class EuroConversorControllerWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("EuroConversorController: Cerrar ventana.");
            System.exit(0);
        }
    }

    class EuroConversorControllerActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            String command = ae.getActionCommand();
            String dispNum = "";
            String rate = "";

            switch(command){
                case "LIMPIAR":
                    System.out.println("EuroConversorController: Boton 'CLEAN'.");
                    view.setToZero();
                    model.reset();
                    break;
                case "Exit":
                    System.out.println("EuroConversorController: Boton menu 'Salir'.");
                    System.exit(0);
                    break;
                case "ChangeRate":
                    System.out.println("EuroConversorController: Boton 'Change Rate'.");
                    rate = JOptionPane.showInputDialog(null, "Enter new exchange rate:");
                    model.setExchangeRate(Float.parseFloat(rate));
                    view.setRateText(rate);
                    break;
                case "Botones":
                    System.out.println("EuroConversorController: Botones 'Calculadora'.");
                    String digit = ((JButton) ae.getSource()).getText();
                    dispNum = model.addDigit(digit);
                    view.setDisplayText(dispNum);
                    break;
                case "DolarEuro":
                    System.out.println("EuroConversorController: Boton 'Dolar-Euro'.");
                    view.setToZero();
                    model.reset();
                    boton = "DolarEuro";
                    break;
                case "EuroDolar":
                    System.out.println("EuroConversorController: Boton 'Euro-Dolar'.");
                    view.setToZero();
                    model.reset();
                    boton = "EuroDolar";
                    break;
                case "Convertir":
                    System.out.println("EuroConversorController: Boton 'CONVERT'.");
                    rate = model.getExchangeRate();
                    if(boton.equals("DolarEuro")){
                        dispNum = String.valueOf(Double.parseDouble(view.getDisplayText()) * (Double.parseDouble(rate)));
                    } else{
                        dispNum = String.valueOf(Double.parseDouble(view.getDisplayText()) / (Double.parseDouble(rate)));
                    }
                    view.setDisplayText(dispNum);
                    break;
                default:
                    System.out.println("EuroConversorController: Comando'" + command + "' no reconocido.");
                    break;
            }
        }
    }
}