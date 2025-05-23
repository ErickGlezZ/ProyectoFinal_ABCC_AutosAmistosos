package Vista;

import Ventanas.VentanaAltas;
import Ventanas.VentanaBajas;
import Ventanas.VentanaCambios;
import Ventanas.VentanaConsultas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;


public class VentanaPrincipal extends JFrame implements ActionListener {

    JDesktopPane desktopPane;
    JMenu menuVehiculos;
    JMenuItem itemAltas, itemBajas, itemCambios, itemConsultas;
    JButton btnToolAgregar, btnToolEliminar, btnToolCambiar, btnToolConsultar;

    VentanaAltas IF_Altas = new VentanaAltas();
    VentanaBajas IF_Bajas = new VentanaBajas();
    VentanaCambios IF_Cambios = new VentanaCambios();
    VentanaConsultas IF_Consultas = new VentanaConsultas();

    public VentanaPrincipal(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema Distribuidor de Autos Amistosos");
        setSize(835, 700);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(0, 150, 163));
        add(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        menuVehiculos = new JMenu("Vehiculos");

        itemAltas = new JMenuItem("Agregar");
        itemBajas = new JMenuItem("Eliminar");
        itemCambios = new JMenuItem("Modificar");
        itemConsultas = new JMenuItem("Consultar");

        itemAltas.addActionListener(this);
        itemBajas.addActionListener(this);
        itemCambios.addActionListener(this);
        itemConsultas.addActionListener(this);

        menuVehiculos.add(itemAltas);
        menuVehiculos.add(itemBajas);
        menuVehiculos.add(itemCambios);
        menuVehiculos.add(itemConsultas);

        menuBar.add(menuVehiculos);
        setJMenuBar(menuBar);

        JToolBar toolBar = new JToolBar("Herramientas");
        btnToolAgregar = new JButton("Agregar");
        btnToolEliminar = new JButton("Eliminar");
        btnToolCambiar = new JButton("Modificar");
        btnToolConsultar = new JButton("Consultar");

        btnToolAgregar.addActionListener(this);
        btnToolEliminar.addActionListener(this);
        btnToolCambiar.addActionListener(this);
        btnToolConsultar.addActionListener(this);

        toolBar.add(btnToolAgregar);
        toolBar.add(btnToolEliminar);
        toolBar.add(btnToolCambiar);
        toolBar.add(btnToolConsultar);

        getContentPane().add(toolBar, BorderLayout.NORTH);
        getContentPane().add(desktopPane, BorderLayout.CENTER);


        try {
            IF_Altas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        desktopPane.add(IF_Altas);
        IF_Altas.toFront();

        try {
            IF_Bajas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        desktopPane.add(IF_Bajas);
        IF_Bajas.toFront();

        try {
            IF_Cambios.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        desktopPane.add(IF_Cambios);
        IF_Cambios.toFront();

        try {
            IF_Consultas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        desktopPane.add(IF_Consultas);
        IF_Consultas.toFront();




        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();


        IF_Altas.setVisible(false);
        IF_Bajas.setVisible(false);
        IF_Cambios.setVisible(false);
        IF_Consultas.setVisible(false);


        if (componente == itemAltas || componente == btnToolAgregar) {
            if (!IF_Altas.isVisible()) {
                IF_Altas.setVisible(true);
                IF_Altas.toFront();
            }
        } else if (componente == itemBajas || componente == btnToolEliminar){
            if (!IF_Bajas.isVisible()) {
                IF_Bajas.setVisible(true);
                IF_Bajas.toFront();
            }
        } else if (componente == itemCambios || componente == btnToolCambiar){
            if (!IF_Cambios.isVisible()) {
                IF_Cambios.setVisible(true);
                IF_Cambios.toFront();
            }
        } else if (componente == itemConsultas || componente == btnToolConsultar){
            if (!IF_Consultas.isVisible()) {
                IF_Consultas.setVisible(true);
                IF_Consultas.toFront();
            }
        }



    }
}
