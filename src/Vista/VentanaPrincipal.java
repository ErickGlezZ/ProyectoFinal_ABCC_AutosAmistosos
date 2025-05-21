package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class VentanaPrincipal extends JFrame implements ActionListener{

    JDesktopPane desktopPane;
    JMenu menuVehiculos;
    JMenuItem itemAltas, itemBajas, itemCambios, itemConsultas;
    JButton btnToolAgregar, btnToolEliminar, btnToolCambiar, btnToolConsultar, btnAgregar, btnRestablecerAltas, btnCancelarAltas;
    JInternalFrame IF_Altas, IF_Bajas, IF_Cambios, IF_Consultas;


    JTextField idVehiculoAltas, modeloAltas, pesoAltas;
    JFormattedTextField precioListaAltas;
    JSpinner numCilindrosAltas, capacidadAltas;
    JComboBox<Integer> numPuertasAltas, fechaFabAltas, diaAltas, añoAltas;
    JComboBox<String> paisFabAltas, mesAltas, colorAltas;
    JTable tablaVehiculosAltas;


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
        IF_Altas = new JInternalFrame("ALTAS", true, true, false, true);
        IF_Altas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Altas.setLayout(null);

        JPanel panelAltas = new JPanel(null);
        panelAltas.setBackground(Color.GREEN);
        panelAltas.setBounds(0, 0, 700, 60);

        JLabel txtAltas = new JLabel("ALTAS VEHICULOS");
        txtAltas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtAltas.setForeground(Color.WHITE);
        agregarComponentePanel(panelAltas, txtAltas, 10, 25, 150, 20);

        JLabel txtIdVehiculoAltas = new JLabel("Numero Vehiculo:");
        agregarAInternal(IF_Altas,txtIdVehiculoAltas,10,80,120,20);

        idVehiculoAltas = new JTextField();
        agregarAInternal(IF_Altas,idVehiculoAltas,135, 83,100,25);

        JLabel txtModelo = new JLabel("Modelo:");
        agregarAInternal(IF_Altas,txtModelo,10,110,120,20);

        modeloAltas = new JTextField();
        agregarAInternal(IF_Altas,modeloAltas,135,113,100,25);

        JLabel txtPaisFab = new JLabel("Pais de Fabricacion");
        agregarAInternal(IF_Altas,txtPaisFab,10,150,120,20);

        String[] paisesFabricantes = {
                "Elige una opc..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        paisFabAltas = new JComboBox<>(paisesFabricantes);
        paisFabAltas.setEditable(false);
        agregarAInternal(IF_Altas,paisFabAltas,135,148,120,25);

        JLabel txtFechaFab = new JLabel("Fecha de Fabricación:");
        agregarAInternal(IF_Altas, txtFechaFab, 10, 180, 150, 20);


        diaAltas = new JComboBox<>();
        for (int d = 0; d <= 31; d++) diaAltas.addItem(d);
        agregarAInternal(IF_Altas, diaAltas, 160, 180, 50, 25);


        mesAltas = new JComboBox<>(new String[]{
                "Elije", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        agregarAInternal(IF_Altas, mesAltas, 215, 180, 100, 25);


        añoAltas = new JComboBox<>();
        for (int a = 1900; a <= 2025; a++) {
            añoAltas.addItem(a);
        }
        agregarAInternal(IF_Altas, añoAltas, 320, 180, 80, 25);

        // Precio de Lista
        JLabel txtPrecioLista = new JLabel("Precio de Lista:");
        agregarAInternal(IF_Altas, txtPrecioLista, 10, 210, 120, 20);

        precioListaAltas = new JFormattedTextField(NumberFormat.getNumberInstance());
        agregarAInternal(IF_Altas, precioListaAltas, 135, 213, 100, 25);


        JLabel txtCilindros = new JLabel("Cilindros:");
        agregarAInternal(IF_Altas, txtCilindros, 10, 240, 120, 20);


        String cilindros[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCil = new SpinnerListModel(cilindros);
        numCilindrosAltas = new JSpinner(modeloCil);
        agregarAInternal(IF_Altas, numCilindrosAltas, 135, 243, 50, 25);


        JLabel txtCapacidad = new JLabel("Capacidad:");
        agregarAInternal(IF_Altas, txtCapacidad, 255, 243, 120, 20);

        String capacidades[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCap = new SpinnerListModel(capacidades);
        capacidadAltas = new JSpinner(modeloCap);
        agregarAInternal(IF_Altas, capacidadAltas, 350, 243, 50, 25);


        JLabel txtPuertas = new JLabel("Núm. Puertas:");
        agregarAInternal(IF_Altas, txtPuertas, 10, 270, 120, 20);

        numPuertasAltas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(IF_Altas, numPuertasAltas, 135, 273, 60, 25);

        JLabel txtPeso = new JLabel("Peso:");
        agregarAInternal(IF_Altas,txtPeso,255,273,80,20);

        pesoAltas = new JTextField();
        agregarAInternal(IF_Altas,pesoAltas,301,273,100,25);

        JLabel txtColor = new JLabel("Color:");
        agregarAInternal(IF_Altas, txtColor, 10, 300, 120, 20);

        String[] coloresAuto = {
                "Elige", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        colorAltas = new JComboBox<>(coloresAuto);
        agregarAInternal(IF_Altas, colorAltas, 135, 303, 120, 25);


        String[] columnas = {"Num_Vehiculo", "Modelo", "País", "Fecha Fab", "Precio", "Cilindros", "Capacidad", "Puertas", "Color"};
        String[][] datos = {
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        }; // vacía inicialmente
        tablaVehiculosAltas = new JTable(datos, columnas);
        tablaVehiculosAltas.setRowHeight(20);
        tablaVehiculosAltas.setPreferredScrollableViewportSize(new Dimension(660, 150));

        JScrollPane scrollTabla = new JScrollPane(tablaVehiculosAltas);
        scrollTabla.setBounds(10, 340, 675, 150);
        IF_Altas.add(scrollTabla);

        btnAgregar = new JButton("Agregar");
        agregarAInternal(IF_Altas,btnAgregar,490, 100,110,30);

        btnRestablecerAltas = new JButton("Restablecer");
        agregarAInternal(IF_Altas,btnRestablecerAltas,490, 170,110,30);

        btnCancelarAltas = new JButton("Cancelar");
        agregarAInternal(IF_Altas,btnCancelarAltas,490,240,110,30);

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
        agregarComponentePanel(panelBajas, txtBajas,10, 25, 150, 20);

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
        agregarComponentePanel(panelCambios,txtCambios,10, 25, 200, 20);

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
        agregarComponentePanel(panelConsultas,txtConsultas,10, 25, 200, 20);

        IF_Consultas.add(panelConsultas);
        IF_Consultas.setSize(700, 500);
        IF_Consultas.setLocation(50, 50);
        desktopPane.add(IF_Consultas);

        setVisible(true);
    }

    public void agregarComponentePanel(JPanel panel, JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        panel.add(componente);
    }

    public void agregarAInternal(JInternalFrame frame, JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        frame.add(componente);
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
