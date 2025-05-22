package Vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.NumberFormat;

public class VentanaPrincipal extends JFrame implements ActionListener{

    JDesktopPane desktopPane;
    JMenu menuVehiculos;
    JMenuItem itemAltas, itemBajas, itemCambios, itemConsultas;
    JButton btnToolAgregar, btnToolEliminar, btnToolCambiar, btnToolConsultar, btnAgregar, btnRestablecerAltas, btnCancelarAltas, btnEliminar, btnRestablecerBajas, btnCancelarBajas, btnBuscarBajas, btnBuscarCambios, btnRestablecerCambios, btnGuardarCambios, btnCancelarCambios;
    JInternalFrame IF_Altas, IF_Bajas, IF_Cambios, IF_Consultas;


    JTextField idVehiculoAltas, modeloAltas, pesoAltas, idVehiculoBajas, modeloBajas, pesoBajas, idVehiculoCambios, modeloCambios, pesoCambios;
    JFormattedTextField precioListaAltas, precioListaBajas, precioListaCambios;
    JSpinner numCilindrosAltas, capacidadAltas, numCilindrosBajas, capacidadBajas, numCilindrosCambios, capacidadCambios;
    JComboBox<Integer> numPuertasAltas, fechaFabAltas, diaAltas, añoAltas, numPuertasBajas, diaBajas, añoBajas, numPuertasCambios, diaCambios, añoCambios;
    JComboBox<String> paisFabAltas, mesAltas, colorAltas, paisFabBajas, mesBajas, colorBajas, paisFabCambios, mesCambios, colorCambios;
    JTable tablaVehiculosAltas, tablaVehiculosBajas, tablaVehiculosCambios;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;

    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;

    JButton btnInicio, btnRegistrosAltas, btnRegistrosBajas, btnRegistrosCambios, btnRegistrosConsultas;

    public VentanaPrincipal() {

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



        // IF Altas
        IF_Altas = new JInternalFrame("ALTAS", true, true, false, true);
        IF_Altas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Altas.setLayout(null);

        JPanel panelAltas = new JPanel(null);
        panelAltas.setBackground(Color.GREEN);
        panelAltas.setBounds(0, 0, 650, 60);

        JPanel panelDerechoAltas = new JPanel();
        panelDerechoAltas.setBackground(new Color(60, 63, 65));
        panelDerechoAltas.setBounds(650, 0, 160, 700);
        panelDerechoAltas.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        panelDerechoAltas.setLayout(null);


        logoIcon = new ImageIcon("img/logo.png");
        Image logoRedimensionado = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        labelLogo = new JLabel(new ImageIcon(logoRedimensionado));
        agregarComponentePanel(panelDerechoAltas, labelLogo, -20, 10, 200, 200); // Ajuste en X para centrar visualmente


        inicioIcon = new ImageIcon("img/inicio.png");
        btnInicio = new JButton("Inicio", new ImageIcon(inicioIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
        btnInicio.setBackground(new Color(70, 130, 180));
        btnInicio.setForeground(Color.WHITE);
        btnInicio.setFocusPainted(false);
        agregarComponentePanel(panelDerechoAltas, btnInicio, 15, 220, 130, 30);


        personalIcon = new ImageIcon("img/personal.png");
        iconoPersonal = new JLabel(new ImageIcon(personalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoAltas, iconoPersonal, 15, 260, 25, 25);

        textoPersonal = new JLabel("Personal");
        textoPersonal.setForeground(Color.WHITE);
        textoPersonal.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoAltas, textoPersonal, 50, 260, 100, 25);


        encargadoIcon = new ImageIcon("img/encargado.png");
        iconoEncargado = new JLabel(new ImageIcon(encargadoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoAltas, iconoEncargado, 15, 300, 25, 25);

        textoEncargado = new JLabel("Encargado");
        textoEncargado.setForeground(Color.WHITE);
        textoEncargado.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoAltas, textoEncargado, 50, 300, 100, 25);


        telefonoIcon = new ImageIcon("img/telefono.png");
        iconoTelefono = new JLabel(new ImageIcon(telefonoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoAltas, iconoTelefono, 15, 340, 25, 25);

        textoTelefono = new JLabel("55-1234-5678");
        textoTelefono.setForeground(Color.WHITE);
        textoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoAltas, textoTelefono, 50, 340, 100, 25);


        correoIcon = new ImageIcon("img/correo.png");
        iconoCorreo = new JLabel(new ImageIcon(correoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoAltas, iconoCorreo, 15, 380, 25, 25);

        textoCorreo = new JLabel("autos@gmail.com");
        textoCorreo.setForeground(Color.WHITE);
        textoCorreo.setFont(new Font("Arial", Font.PLAIN, 10));
        agregarComponentePanel(panelDerechoAltas, textoCorreo, 50, 380, 100, 25);


        autoIcon = new ImageIcon("img/autos.png");
        iconoAuto = new JLabel(new ImageIcon(autoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoAltas, iconoAuto, 15, 420, 25, 25);

        textoAuto = new JLabel("Autos");
        textoAuto.setForeground(Color.WHITE);
        textoAuto.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoAltas, textoAuto, 50, 420, 100, 25);


        configIcon = new ImageIcon("img/config.png");
        iconoConfig = new JLabel(new ImageIcon(configIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoAltas, iconoConfig, 15, 460, 25, 25);

        textoConfig = new JLabel("Configuración");
        textoConfig.setForeground(Color.WHITE);
        textoConfig.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoAltas, textoConfig, 50, 460, 100, 25);


        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setForeground(new Color(150, 150, 150));
        agregarComponentePanel(panelDerechoAltas, separador, 10, 500, 140, 2);


        registrosIcon = new ImageIcon("img/registros.png");
        btnRegistrosAltas = new JButton("Registros", new ImageIcon(registrosIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnRegistrosAltas.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegistrosAltas.setBackground(new Color(70, 130, 180));
        btnRegistrosAltas.setForeground(Color.WHITE);
        btnRegistrosAltas.setFocusPainted(false);
        agregarComponentePanel(panelDerechoAltas, btnRegistrosAltas, 15, 520, 130, 30);



        JLabel txtAltas = new JLabel("ALTAS VEHICULOS");
        txtAltas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtAltas.setForeground(Color.WHITE);
        agregarComponentePanel(panelAltas, txtAltas, 10, 25, 150, 20);

        JLabel txtIdVehiculoAltas = new JLabel("Numero Vehiculo:");
        agregarAInternal(IF_Altas,txtIdVehiculoAltas,10,80,120,20);

        idVehiculoAltas = new JTextField();
        agregarAInternal(IF_Altas,idVehiculoAltas,135, 83,150,25);

        JLabel txtModeloAltas = new JLabel("Modelo:");
        agregarAInternal(IF_Altas,txtModeloAltas,10,110,120,20);

        modeloAltas = new JTextField();
        agregarAInternal(IF_Altas,modeloAltas,135,113,150,25);

        JLabel txtPaisFabAltas = new JLabel("Pais de Fabricacion");
        agregarAInternal(IF_Altas,txtPaisFabAltas,10,150,120,20);

        String[] paisesFabricantesAltas = {
                "Elige una opc..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        paisFabAltas = new JComboBox<>(paisesFabricantesAltas);
        paisFabAltas.setEditable(false);
        agregarAInternal(IF_Altas,paisFabAltas,135,148,120,25);

        JLabel txtFechaFabAltas = new JLabel("Fecha de Fabricación:");
        agregarAInternal(IF_Altas, txtFechaFabAltas, 10, 180, 150, 20);


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


        JLabel txtPrecioListaAltas = new JLabel("Precio de Lista:");
        agregarAInternal(IF_Altas, txtPrecioListaAltas, 10, 210, 120, 20);

        precioListaAltas = new JFormattedTextField(NumberFormat.getNumberInstance());
        agregarAInternal(IF_Altas, precioListaAltas, 135, 213, 150, 25);


        JLabel txtCilindrosAltas = new JLabel("Cilindros:");
        agregarAInternal(IF_Altas, txtCilindrosAltas, 10, 240, 120, 20);


        String cilindrosAltas[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilAltas = new SpinnerListModel(cilindrosAltas);
        numCilindrosAltas = new JSpinner(modeloCilAltas);
        agregarAInternal(IF_Altas, numCilindrosAltas, 135, 243, 50, 25);


        JLabel txtCapacidadAltas = new JLabel("Capacidad de Personas:");
        agregarAInternal(IF_Altas, txtCapacidadAltas, 10, 370, 140, 20);

        String capacidadesAltas[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCap = new SpinnerListModel(capacidadesAltas);
        capacidadAltas = new JSpinner(modeloCap);
        agregarAInternal(IF_Altas, capacidadAltas, 160, 370, 50, 25);


        JLabel txtPuertasAltas = new JLabel("Número de Puertas:");
        agregarAInternal(IF_Altas, txtPuertasAltas, 10, 270, 120, 20);

        numPuertasAltas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(IF_Altas, numPuertasAltas, 160, 273, 50, 25);

        JLabel txtPesoAltas = new JLabel("Peso:");
        agregarAInternal(IF_Altas,txtPesoAltas,10,330,80,20);

        pesoAltas = new JTextField();
        agregarAInternal(IF_Altas,pesoAltas,135,333,150,25);

        JLabel txtColorAltas = new JLabel("Color:");
        agregarAInternal(IF_Altas, txtColorAltas, 10, 300, 120, 20);

        String[] coloresAutoAltas = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        colorAltas = new JComboBox<>(coloresAutoAltas);
        agregarAInternal(IF_Altas, colorAltas, 135, 303, 120, 25);


        String[] columnasAltas = {"Num_Vehiculo", "Modelo", "País", "Fecha Fab", "Precio", "Cilindros", "Capacidad", "Puertas", "Color"};
        String[][] datosAltas = {
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        };
        tablaVehiculosAltas = new JTable(datosAltas, columnasAltas);
        tablaVehiculosAltas.setRowHeight(20);
        tablaVehiculosAltas.setPreferredScrollableViewportSize(new Dimension(660, 150));

        JScrollPane scrollTablaAltas = new JScrollPane(tablaVehiculosAltas);
        agregarAInternal(IF_Altas,scrollTablaAltas,10, 410, 640, 150);


        btnAgregar = new JButton("Agregar");
        agregarAInternal(IF_Altas,btnAgregar,490, 100,110,30);

        btnRestablecerAltas = new JButton("Restablecer");
        agregarAInternal(IF_Altas,btnRestablecerAltas,490, 170,110,30);

        btnCancelarAltas = new JButton("Cancelar");
        agregarAInternal(IF_Altas,btnCancelarAltas,490,240,110,30);

        //IF_Altas.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        IF_Altas.add(panelAltas);
        IF_Altas.add(panelDerechoAltas);
        desktopPane.add(IF_Altas);
        IF_Altas.setLocation(0, 0);
        try {
            IF_Altas.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }



        // IF Bajas
        IF_Bajas = new JInternalFrame("BAJAS", true, true, false, true);
        IF_Bajas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Bajas.setLayout(null);

        JPanel panelBajas = new JPanel(null);
        panelBajas.setBackground(Color.RED);
        panelBajas.setBounds(0, 0, 650, 60);

        JPanel panelDerechoBajas = new JPanel();
        panelDerechoBajas.setBackground(new Color(60, 63, 65));
        panelDerechoBajas.setBounds(650, 0, 160, 700);
        panelDerechoBajas.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        panelDerechoBajas.setLayout(null);


        logoIcon = new ImageIcon("img/logo.png");
        Image logoRedimensionado2 = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        labelLogo = new JLabel(new ImageIcon(logoRedimensionado2));
        agregarComponentePanel(panelDerechoBajas, labelLogo, -20, 10, 200, 200); // Ajuste en X para centrar visualmente


        inicioIcon = new ImageIcon("img/inicio.png");
        btnInicio = new JButton("Inicio", new ImageIcon(inicioIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
        btnInicio.setBackground(new Color(70, 130, 180));
        btnInicio.setForeground(Color.WHITE);
        btnInicio.setFocusPainted(false);
        agregarComponentePanel(panelDerechoBajas, btnInicio, 15, 220, 130, 30);


        personalIcon = new ImageIcon("img/personal.png");
        iconoPersonal = new JLabel(new ImageIcon(personalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoBajas, iconoPersonal, 15, 260, 25, 25);

        textoPersonal = new JLabel("Personal");
        textoPersonal.setForeground(Color.WHITE);
        textoPersonal.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoBajas, textoPersonal, 50, 260, 100, 25);


        encargadoIcon = new ImageIcon("img/encargado.png");
        iconoEncargado = new JLabel(new ImageIcon(encargadoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoBajas, iconoEncargado, 15, 300, 25, 25);

        textoEncargado = new JLabel("Encargado");
        textoEncargado.setForeground(Color.WHITE);
        textoEncargado.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoBajas, textoEncargado, 50, 300, 100, 25);


        telefonoIcon = new ImageIcon("img/telefono.png");
        iconoTelefono = new JLabel(new ImageIcon(telefonoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoBajas, iconoTelefono, 15, 340, 25, 25);

        textoTelefono = new JLabel("55-1234-5678");
        textoTelefono.setForeground(Color.WHITE);
        textoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoBajas, textoTelefono, 50, 340, 100, 25);


        correoIcon = new ImageIcon("img/correo.png");
        iconoCorreo = new JLabel(new ImageIcon(correoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoBajas, iconoCorreo, 15, 380, 25, 25);

        textoCorreo = new JLabel("autos@gmail.com");
        textoCorreo.setForeground(Color.WHITE);
        textoCorreo.setFont(new Font("Arial", Font.PLAIN, 10));
        agregarComponentePanel(panelDerechoBajas, textoCorreo, 50, 380, 100, 25);


        autoIcon = new ImageIcon("img/autos.png");
        iconoAuto = new JLabel(new ImageIcon(autoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoBajas, iconoAuto, 15, 420, 25, 25);

        textoAuto = new JLabel("Autos");
        textoAuto.setForeground(Color.WHITE);
        textoAuto.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoBajas, textoAuto, 50, 420, 100, 25);


        configIcon = new ImageIcon("img/config.png");
        iconoConfig = new JLabel(new ImageIcon(configIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoBajas, iconoConfig, 15, 460, 25, 25);

        textoConfig = new JLabel("Configuración");
        textoConfig.setForeground(Color.WHITE);
        textoConfig.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoBajas, textoConfig, 50, 460, 100, 25);


        JSeparator separador2 = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setForeground(new Color(150, 150, 150));
        agregarComponentePanel(panelDerechoBajas, separador2, 10, 500, 140, 2);


        registrosIcon = new ImageIcon("img/registros.png");
        btnRegistrosBajas = new JButton("Registros", new ImageIcon(registrosIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnRegistrosBajas.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegistrosBajas.setBackground(new Color(70, 130, 180));
        btnRegistrosBajas.setForeground(Color.WHITE);
        btnRegistrosBajas.setFocusPainted(false);
        agregarComponentePanel(panelDerechoBajas, btnRegistrosBajas, 15, 520, 130, 30);

        JLabel txtBajas = new JLabel("BAJAS VEHICULOS");
        txtBajas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtBajas.setForeground(Color.WHITE);
        agregarComponentePanel(panelBajas, txtBajas,10, 25, 150, 20);


        JLabel txtIdVehiculoBajas = new JLabel("Numero Vehiculo:");
        agregarAInternal(IF_Bajas,txtIdVehiculoBajas,10,70,120,20);

        idVehiculoBajas = new JTextField();
        agregarAInternal(IF_Bajas,idVehiculoBajas,135, 68,100,30);

        JSeparator separadorBajas = new JSeparator();
        separadorBajas.setForeground(Color.GRAY);
        agregarAInternal(IF_Bajas, separadorBajas, 10, 105, 640, 2);

        JLabel txtModeloBajas = new JLabel("Modelo:");
        agregarAInternal(IF_Bajas,txtModeloBajas,10,113,120,20);

        modeloBajas = new JTextField();
        agregarAInternal(IF_Bajas,modeloBajas,135,113,100,25);

        JLabel txtPaisFabBajas = new JLabel("Pais de Fabricacion");
        agregarAInternal(IF_Bajas,txtPaisFabBajas,10,150,120,20);

        String[] paisesFabricantesBajas = {
                "Elige una opc..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        paisFabBajas = new JComboBox<>(paisesFabricantesBajas);
        paisFabBajas.setEditable(false);
        agregarAInternal(IF_Bajas,paisFabBajas,135,148,120,25);

        JLabel txtFechaFabBajas = new JLabel("Fecha de Fabricación:");
        agregarAInternal(IF_Bajas, txtFechaFabBajas, 10, 180, 150, 20);


        diaBajas = new JComboBox<>();
        for (int d = 0; d <= 31; d++) diaBajas.addItem(d);
        agregarAInternal(IF_Bajas, diaBajas, 160, 180, 50, 25);


        mesBajas = new JComboBox<>(new String[]{
                "Elije", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        agregarAInternal(IF_Bajas, mesBajas, 215, 180, 100, 25);


        añoBajas = new JComboBox<>();
        for (int a = 1900; a <= 2025; a++) {
            añoBajas.addItem(a);
        }
        agregarAInternal(IF_Bajas, añoBajas, 320, 180, 80, 25);


        JLabel txtPrecioListaBajas = new JLabel("Precio de Lista:");
        agregarAInternal(IF_Bajas, txtPrecioListaBajas, 10, 210, 120, 20);

        precioListaBajas = new JFormattedTextField(NumberFormat.getNumberInstance());
        agregarAInternal(IF_Bajas, precioListaBajas, 135, 213, 150, 25);


        JLabel txtCilindrosBajas = new JLabel("Cilindros:");
        agregarAInternal(IF_Bajas, txtCilindrosBajas, 10, 240, 120, 20);


        String cilindrosBajas[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilBajas = new SpinnerListModel(cilindrosBajas);
        numCilindrosBajas = new JSpinner(modeloCilBajas);
        agregarAInternal(IF_Bajas, numCilindrosBajas, 135, 243, 50, 25);


        JLabel txtCapacidadBajas = new JLabel("Capacidad de Personas:");
        agregarAInternal(IF_Bajas, txtCapacidadBajas, 10, 370, 140, 20);

        String capacidadesBajas[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCapBajas = new SpinnerListModel(capacidadesBajas);
        capacidadBajas = new JSpinner(modeloCapBajas);
        agregarAInternal(IF_Bajas, capacidadBajas, 160, 370, 50, 25);


        JLabel txtPuertasBajas = new JLabel("Número de Puertas:");
        agregarAInternal(IF_Bajas, txtPuertasBajas, 10, 270, 120, 20);

        numPuertasBajas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(IF_Bajas, numPuertasBajas, 160, 273, 50, 25);

        JLabel txtPesoBajas = new JLabel("Peso:");
        agregarAInternal(IF_Bajas,txtPesoBajas,10,330,80,20);

        pesoBajas = new JTextField();
        agregarAInternal(IF_Bajas,pesoBajas,135,333,150,25);

        JLabel txtColorBajas = new JLabel("Color:");
        agregarAInternal(IF_Bajas, txtColorBajas, 10, 300, 120, 20);

        String[] coloresAutoBajas = {
                "Elige Color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        colorBajas = new JComboBox<>(coloresAutoBajas);
        agregarAInternal(IF_Bajas, colorBajas, 135, 303, 120, 25);


        String[] columnasBajas = {"Num_Vehiculo", "Modelo", "País", "Fecha Fab", "Precio", "Cilindros", "Capacidad", "Puertas", "Color"};
        String[][] datosBajas = {
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        };
        tablaVehiculosBajas = new JTable(datosBajas, columnasBajas);
        tablaVehiculosBajas.setRowHeight(20);
        tablaVehiculosBajas.setPreferredScrollableViewportSize(new Dimension(660, 150));

        JScrollPane scrollTablaBajas = new JScrollPane(tablaVehiculosBajas);
        agregarAInternal(IF_Bajas,scrollTablaBajas,10, 410, 640, 150);

        btnBuscarBajas = new JButton("Buscar");
        agregarAInternal(IF_Bajas,btnBuscarBajas,320,68,110,30);

        btnEliminar = new JButton("Eliminar");
        agregarAInternal(IF_Bajas,btnEliminar,490, 120,110,30);

        btnRestablecerBajas = new JButton("Restablecer");
        agregarAInternal(IF_Bajas,btnRestablecerBajas,490, 190,110,30);

        btnCancelarBajas = new JButton("Cancelar");
        agregarAInternal(IF_Bajas,btnCancelarBajas,490,260,110,30);

        IF_Bajas.add(panelBajas);
        IF_Bajas.add(panelDerechoBajas);
        desktopPane.add(IF_Bajas);
        IF_Bajas.setLocation(0, 0);
        try {
            IF_Bajas.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }




        // IF Cambios
        IF_Cambios = new JInternalFrame("CAMBIOS", true, true, false, true);
        IF_Cambios.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Cambios.setLayout(null);

        JPanel panelCambios = new JPanel(null);
        panelCambios.setBackground(Color.YELLOW);
        panelCambios.setBounds(0, 0, 650, 60);

        JPanel panelDerechoCambios = new JPanel();
        panelDerechoCambios.setBackground(new Color(60, 63, 65));
        panelDerechoCambios.setBounds(650, 0, 160, 700);
        panelDerechoCambios.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        panelDerechoCambios.setLayout(null);


        logoIcon = new ImageIcon("img/logo.png");
        Image logoRedimensionado3 = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        labelLogo = new JLabel(new ImageIcon(logoRedimensionado3));
        agregarComponentePanel(panelDerechoCambios, labelLogo, -20, 10, 200, 200);


        inicioIcon = new ImageIcon("img/inicio.png");
        btnInicio = new JButton("Inicio", new ImageIcon(inicioIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
        btnInicio.setBackground(new Color(70, 130, 180));
        btnInicio.setForeground(Color.WHITE);
        btnInicio.setFocusPainted(false);
        agregarComponentePanel(panelDerechoCambios, btnInicio, 15, 220, 130, 30);


        personalIcon = new ImageIcon("img/personal.png");
        iconoPersonal = new JLabel(new ImageIcon(personalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoCambios, iconoPersonal, 15, 260, 25, 25);

        textoPersonal = new JLabel("Personal");
        textoPersonal.setForeground(Color.WHITE);
        textoPersonal.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoCambios, textoPersonal, 50, 260, 100, 25);


        encargadoIcon = new ImageIcon("img/encargado.png");
        iconoEncargado = new JLabel(new ImageIcon(encargadoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoCambios, iconoEncargado, 15, 300, 25, 25);

        textoEncargado = new JLabel("Encargado");
        textoEncargado.setForeground(Color.WHITE);
        textoEncargado.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoCambios, textoEncargado, 50, 300, 100, 25);


        telefonoIcon = new ImageIcon("img/telefono.png");
        iconoTelefono = new JLabel(new ImageIcon(telefonoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoCambios, iconoTelefono, 15, 340, 25, 25);

        textoTelefono = new JLabel("55-1234-5678");
        textoTelefono.setForeground(Color.WHITE);
        textoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoCambios, textoTelefono, 50, 340, 100, 25);


        correoIcon = new ImageIcon("img/correo.png");
        iconoCorreo = new JLabel(new ImageIcon(correoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoCambios, iconoCorreo, 15, 380, 25, 25);

        textoCorreo = new JLabel("autos@gmail.com");
        textoCorreo.setForeground(Color.WHITE);
        textoCorreo.setFont(new Font("Arial", Font.PLAIN, 10));
        agregarComponentePanel(panelDerechoCambios, textoCorreo, 50, 380, 100, 25);


        autoIcon = new ImageIcon("img/autos.png");
        iconoAuto = new JLabel(new ImageIcon(autoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoCambios, iconoAuto, 15, 420, 25, 25);

        textoAuto = new JLabel("Autos");
        textoAuto.setForeground(Color.WHITE);
        textoAuto.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoCambios, textoAuto, 50, 420, 100, 25);


        configIcon = new ImageIcon("img/config.png");
        iconoConfig = new JLabel(new ImageIcon(configIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoCambios, iconoConfig, 15, 460, 25, 25);

        textoConfig = new JLabel("Configuración");
        textoConfig.setForeground(Color.WHITE);
        textoConfig.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoCambios, textoConfig, 50, 460, 100, 25);


        JSeparator separador3 = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setForeground(new Color(150, 150, 150));
        agregarComponentePanel(panelDerechoCambios, separador3, 10, 500, 140, 2);


        registrosIcon = new ImageIcon("img/registros.png");
        btnRegistrosCambios = new JButton("Registros", new ImageIcon(registrosIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnRegistrosCambios.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegistrosCambios.setBackground(new Color(70, 130, 180));
        btnRegistrosCambios.setForeground(Color.WHITE);
        btnRegistrosCambios.setFocusPainted(false);
        agregarComponentePanel(panelDerechoCambios, btnRegistrosCambios, 15, 520, 130, 30);

        JLabel txtCambios = new JLabel("CAMBIOS VEHICULOS");
        txtCambios.setFont(new Font("Roboto", Font.BOLD, 15));
        txtCambios.setForeground(Color.WHITE);
        agregarComponentePanel(panelCambios, txtCambios,10, 25, 180, 20);

        JLabel txtIdVehiculoCambios = new JLabel("Numero Vehiculo:");
        agregarAInternal(IF_Cambios,txtIdVehiculoCambios,10,70,120,20);

        idVehiculoCambios = new JTextField();
        agregarAInternal(IF_Cambios,idVehiculoCambios,135, 68,100,30);

        JSeparator separadorCambios = new JSeparator();
        separadorCambios.setForeground(Color.GRAY);
        agregarAInternal(IF_Cambios, separadorCambios, 10, 105, 640, 2);

        JLabel txtModeloCambios = new JLabel("Modelo:");
        agregarAInternal(IF_Cambios,txtModeloCambios,10,113,120,20);

        modeloCambios = new JTextField();
        agregarAInternal(IF_Cambios,modeloCambios,135,113,100,25);

        JLabel txtPaisFabCambios = new JLabel("Pais de Fabricacion");
        agregarAInternal(IF_Cambios,txtPaisFabCambios,10,150,120,20);

        String[] paisesFabricantesCambios = {
                "Elige una opc..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        paisFabCambios = new JComboBox<>(paisesFabricantesCambios);
        paisFabCambios.setEditable(false);
        agregarAInternal(IF_Cambios,paisFabCambios,135,148,120,25);

        JLabel txtFechaFabCambios = new JLabel("Fecha de Fabricación:");
        agregarAInternal(IF_Cambios, txtFechaFabCambios, 10, 180, 150, 20);

        diaCambios = new JComboBox<>();
        for (int d = 0; d <= 31; d++) diaCambios.addItem(d);
        agregarAInternal(IF_Cambios, diaCambios, 160, 180, 50, 25);

        mesCambios = new JComboBox<>(new String[]{
                "Elije", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        agregarAInternal(IF_Cambios, mesCambios, 215, 180, 100, 25);

        añoCambios = new JComboBox<>();
        for (int a = 1900; a <= 2025; a++) {
            añoCambios.addItem(a);
        }
        agregarAInternal(IF_Cambios, añoCambios, 320, 180, 80, 25);

        JLabel txtPrecioListaCambios = new JLabel("Precio de Lista:");
        agregarAInternal(IF_Cambios, txtPrecioListaCambios, 10, 210, 120, 20);

        precioListaCambios = new JFormattedTextField(NumberFormat.getNumberInstance());
        agregarAInternal(IF_Cambios, precioListaCambios, 135, 213, 150, 25);

        JLabel txtCilindrosCambios = new JLabel("Cilindros:");
        agregarAInternal(IF_Cambios, txtCilindrosCambios, 10, 240, 120, 20);

        String cilindrosCambios[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilCambios = new SpinnerListModel(cilindrosCambios);
        numCilindrosCambios = new JSpinner(modeloCilCambios);
        agregarAInternal(IF_Cambios, numCilindrosCambios, 135, 243, 50, 25);

        JLabel txtCapacidadCambios = new JLabel("Capacidad de Personas:");
        agregarAInternal(IF_Cambios, txtCapacidadCambios, 10, 370, 140, 20);

        String capacidadesCambios[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCapCambios = new SpinnerListModel(capacidadesCambios);
        capacidadCambios = new JSpinner(modeloCapCambios);
        agregarAInternal(IF_Cambios, capacidadCambios, 160, 370, 50, 25);

        JLabel txtPuertasCambios = new JLabel("Número de Puertas:");
        agregarAInternal(IF_Cambios, txtPuertasCambios, 10, 270, 120, 20);

        numPuertasCambios = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(IF_Cambios, numPuertasCambios, 160, 273, 50, 25);

        JLabel txtPesoCambios = new JLabel("Peso:");
        agregarAInternal(IF_Cambios,txtPesoCambios,10,330,80,20);

        pesoCambios = new JTextField();
        agregarAInternal(IF_Cambios,pesoCambios,135,333,150,25);

        JLabel txtColorCambios = new JLabel("Color:");
        agregarAInternal(IF_Cambios, txtColorCambios, 10, 300, 120, 20);

        String[] coloresAutoCambios = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        colorCambios = new JComboBox<>(coloresAutoCambios);
        agregarAInternal(IF_Cambios, colorCambios, 135, 303, 120, 25);

        String[] columnasCambios = {"Num_Vehiculo", "Modelo", "País", "Fecha Fab", "Precio", "Cilindros", "Capacidad", "Puertas", "Color"};
        String[][] datosCambios = {
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        };
        tablaVehiculosCambios = new JTable(datosCambios, columnasCambios);
        tablaVehiculosCambios.setRowHeight(20);
        tablaVehiculosCambios.setPreferredScrollableViewportSize(new Dimension(660, 150));

        JScrollPane scrollTablaCambios = new JScrollPane(tablaVehiculosCambios);
        agregarAInternal(IF_Cambios,scrollTablaCambios,10, 410, 640, 150);

        btnBuscarCambios = new JButton("Buscar");
        agregarAInternal(IF_Cambios, btnBuscarCambios, 320,68,110,30);

        btnRestablecerCambios = new JButton("Restablecer");
        agregarAInternal(IF_Cambios, btnRestablecerCambios, 490, 170,150,30);

        btnGuardarCambios = new JButton("Guardar Cambios");
        agregarAInternal(IF_Cambios, btnGuardarCambios, 490,240,150,30);

        btnCancelarCambios = new JButton("Cancelar");
        agregarAInternal(IF_Cambios, btnCancelarCambios, 490,310,150,30);

        IF_Cambios.add(panelCambios);
        IF_Cambios.add(panelDerechoCambios);
        desktopPane.add(IF_Cambios);
        IF_Cambios.setLocation(0, 0);
        try {
            IF_Cambios.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }


        // IF Consultas
        IF_Consultas = new JInternalFrame("CONSULTAS", true, true, true, true);
        IF_Consultas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        IF_Consultas.setLayout(null);

        JPanel panelConsultas = new JPanel(null);
        panelConsultas.setBackground(Color.BLUE);
        panelConsultas.setBounds(0, 0, 650, 60);


        JPanel panelDerechoConsultas = new JPanel();
        panelDerechoConsultas.setBackground(new Color(60, 63, 65));
        panelDerechoConsultas.setBounds(650, 0, 160, 700);
        panelDerechoConsultas.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        panelDerechoConsultas.setLayout(null);

        logoIcon = new ImageIcon("img/logo.png");
        Image logoRedimensionado4 = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        labelLogo = new JLabel(new ImageIcon(logoRedimensionado4));
        agregarComponentePanel(panelDerechoConsultas, labelLogo, -20, 10, 200, 200);

        inicioIcon = new ImageIcon("img/inicio.png");
        btnInicio = new JButton("Inicio", new ImageIcon(inicioIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
        btnInicio.setBackground(new Color(70, 130, 180));
        btnInicio.setForeground(Color.WHITE);
        btnInicio.setFocusPainted(false);
        agregarComponentePanel(panelDerechoConsultas, btnInicio, 15, 220, 130, 30);

        personalIcon = new ImageIcon("img/personal.png");
        iconoPersonal = new JLabel(new ImageIcon(personalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoConsultas, iconoPersonal, 15, 260, 25, 25);

        textoPersonal = new JLabel("Personal");
        textoPersonal.setForeground(Color.WHITE);
        textoPersonal.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoConsultas, textoPersonal, 50, 260, 100, 25);

        encargadoIcon = new ImageIcon("img/encargado.png");
        iconoEncargado = new JLabel(new ImageIcon(encargadoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoConsultas, iconoEncargado, 15, 300, 25, 25);

        textoEncargado = new JLabel("Encargado");
        textoEncargado.setForeground(Color.WHITE);
        textoEncargado.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoConsultas, textoEncargado, 50, 300, 100, 25);

        telefonoIcon = new ImageIcon("img/telefono.png");
        iconoTelefono = new JLabel(new ImageIcon(telefonoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoConsultas, iconoTelefono, 15, 340, 25, 25);

        textoTelefono = new JLabel("55-1234-5678");
        textoTelefono.setForeground(Color.WHITE);
        textoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoConsultas, textoTelefono, 50, 340, 100, 25);

        correoIcon = new ImageIcon("img/correo.png");
        iconoCorreo = new JLabel(new ImageIcon(correoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoConsultas, iconoCorreo, 15, 380, 25, 25);

        textoCorreo = new JLabel("autos@gmail.com");
        textoCorreo.setForeground(Color.WHITE);
        textoCorreo.setFont(new Font("Arial", Font.PLAIN, 10));
        agregarComponentePanel(panelDerechoConsultas, textoCorreo, 50, 380, 100, 25);

        autoIcon = new ImageIcon("img/autos.png");
        iconoAuto = new JLabel(new ImageIcon(autoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoConsultas, iconoAuto, 15, 420, 25, 25);

        textoAuto = new JLabel("Autos");
        textoAuto.setForeground(Color.WHITE);
        textoAuto.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoConsultas, textoAuto, 50, 420, 100, 25);

        configIcon = new ImageIcon("img/config.png");
        iconoConfig = new JLabel(new ImageIcon(configIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregarComponentePanel(panelDerechoConsultas, iconoConfig, 15, 460, 25, 25);

        textoConfig = new JLabel("Configuración");
        textoConfig.setForeground(Color.WHITE);
        textoConfig.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoConsultas, textoConfig, 50, 460, 100, 25);

        JSeparator separador4 = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setForeground(new Color(150, 150, 150));
        agregarComponentePanel(panelDerechoConsultas, separador4, 10, 500, 140, 2);

        registrosIcon = new ImageIcon("img/registros.png");
        btnRegistrosConsultas = new JButton("Registros", new ImageIcon(registrosIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnRegistrosConsultas.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegistrosConsultas.setBackground(new Color(70, 130, 180));
        btnRegistrosConsultas.setForeground(Color.WHITE);
        btnRegistrosConsultas.setFocusPainted(false);
        agregarComponentePanel(panelDerechoConsultas, btnRegistrosConsultas, 15, 520, 130, 30);



        JLabel txtConsultas = new JLabel("CONSULTAR VEHICULOS");
        txtConsultas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtConsultas.setForeground(Color.WHITE);
        agregarComponentePanel(panelConsultas,txtConsultas,10, 25, 200, 20);

        IF_Consultas.add(panelConsultas);
        IF_Consultas.add(panelDerechoConsultas);
        desktopPane.add(IF_Consultas);
        IF_Consultas.setLocation(0, 0);
        try {
            IF_Consultas.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

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
