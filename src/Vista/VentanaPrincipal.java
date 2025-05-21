package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener{

    JDesktopPane desktopPane;
    JMenu menuVehiculos;
    JMenuItem itemAltas, itemBajas, itemCambios, itemConsultas;
    JButton btnToolAgregar, btnToolEliminar, btnToolCambiar, btnToolConsultar;
    JInternalFrame IF_Altas, IF_Bajas, IF_Cambios, IF_Consultas;


    public VentanaPrincipal() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema Distribuidor de Autos Amistosos");
        setSize(800, 700);
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



        // IF Altas
        IF_Altas = new JInternalFrame("ALTAS", true, true, true, true);
        IF_Altas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Altas.setLayout(null);

        JPanel panelAltas = new JPanel(null);
        panelAltas.setBackground(Color.GREEN);
        panelAltas.setBounds(0, 0, 700, 60);

        JLabel txtAltas = new JLabel("ALTAS VEHICULOS");
        txtAltas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtAltas.setForeground(Color.WHITE);
        agregarComponente(panelAltas, txtAltas, 10, 25, 150, 20);

        IF_Altas.add(panelAltas);
        IF_Altas.setSize(700, 500);
        IF_Altas.setLocation(50, 50);
        desktopPane.add(IF_Altas);



        // IF Bajas
        IF_Bajas = new JInternalFrame("BAJAS", true, true, true, true);
        IF_Bajas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Bajas.setLayout(null);

        JPanel panelBajas = new JPanel(null);
        panelBajas.setBackground(Color.RED);
        panelBajas.setBounds(0, 0, 700, 60);

        JLabel txtBajas = new JLabel("BAJAS VEHICULOS");
        txtBajas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtBajas.setForeground(Color.WHITE);
        agregarComponente(panelBajas, txtBajas,10, 25, 150, 20);

        IF_Bajas.add(panelBajas);
        IF_Bajas.setSize(700, 500);
        IF_Bajas.setLocation(50, 50);
        desktopPane.add(IF_Bajas);




        // IF Cambios
        IF_Cambios = new JInternalFrame("MODIFICAR", true, true, true, true);
        IF_Cambios.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Cambios.setLayout(null);

        JPanel panelCambios = new JPanel(null);
        panelCambios.setBackground(Color.ORANGE);
        panelCambios.setBounds(0, 0, 700, 60);

        JLabel txtCambios = new JLabel("MODIFICAR VEHICULOS");
        txtCambios.setFont(new Font("Roboto", Font.BOLD, 15));
        txtCambios.setForeground(Color.WHITE);
        agregarComponente(panelCambios,txtCambios,10, 25, 200, 20);

        IF_Cambios.add(panelCambios);
        IF_Cambios.setSize(700, 500);
        IF_Cambios.setLocation(50, 50);
        desktopPane.add(IF_Cambios);

        // IF Consultas
        IF_Consultas = new JInternalFrame("CONSULTAS", true, true, true, true);
        IF_Consultas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Consultas.setLayout(null);

        JPanel panelConsultas = new JPanel(null);
        panelConsultas.setBackground(Color.BLUE);
        panelConsultas.setBounds(0, 0, 700, 60);

        JLabel txtConsultas = new JLabel("CONSULTAR VEHICULOS");
        txtConsultas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtConsultas.setForeground(Color.WHITE);
        agregarComponente(panelConsultas,txtConsultas,10, 25, 200, 20);

        IF_Consultas.add(panelConsultas);
        IF_Consultas.setSize(700, 500);
        IF_Consultas.setLocation(50, 50);
        desktopPane.add(IF_Consultas);

        setVisible(true);
    }

    public void agregarComponente(JPanel panel, JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        panel.add(componente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        IF_Altas.setVisible(false);
        IF_Bajas.setVisible(false);
        IF_Cambios.setVisible(false);
        IF_Consultas.setVisible(false);

        if (componente == itemAltas || componente == btnToolAgregar){
            IF_Altas.setVisible(true);
        } else if (componente == itemBajas || componente == btnToolEliminar){
            IF_Bajas.setVisible(true);
        } else if (componente == itemCambios || componente == btnToolCambiar){
            IF_Cambios.setVisible(true);
        } else if (componente == itemConsultas || componente == btnToolConsultar){
            IF_Consultas.setVisible(true);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}
