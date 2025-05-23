package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class VentanaCambios extends JInternalFrame {

    JButton btnBuscarCambios, btnRestablecerCambios, btnGuardarCambios, btnCancelarCambios, btnRegistrosCambios, btnInicio;
    JTextField  idVehiculoCambios, modeloCambios, pesoCambios;
    JFormattedTextField precioListaCambios;
    JSpinner numCilindrosCambios, capacidadCambios;
    JComboBox<Integer> numPuertasCambios, diaCambios, añoCambios;
    JComboBox<String> paisFabCambios, mesCambios, colorCambios;
    JTable  tablaVehiculosCambios;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;

    public VentanaCambios(){

        super("CAMBIOS", true, true, false, true);
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panelCambios = new JPanel();
        panelCambios.setLayout(null);
        panelCambios.setBackground(Color.ORANGE);
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
        separador3.setForeground(new Color(150, 150, 150));
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
        agregarAInternal(txtIdVehiculoCambios,10,70,120,20);

        idVehiculoCambios = new JTextField();
        agregarAInternal(idVehiculoCambios,135, 68,100,30);

        JSeparator separadorCambios = new JSeparator();
        separadorCambios.setForeground(Color.GRAY);
        agregarAInternal(separadorCambios, 10, 105, 640, 2);

        JLabel txtModeloCambios = new JLabel("Modelo:");
        agregarAInternal(txtModeloCambios,10,113,120,20);

        modeloCambios = new JTextField();
        agregarAInternal(modeloCambios,135,113,100,25);

        JLabel txtPaisFabCambios = new JLabel("Pais de Fabricacion");
        agregarAInternal(txtPaisFabCambios,10,150,120,20);

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
        agregarAInternal(paisFabCambios,135,148,120,25);

        JLabel txtFechaFabCambios = new JLabel("Fecha de Fabricación:");
        agregarAInternal(txtFechaFabCambios, 10, 180, 150, 20);

        diaCambios = new JComboBox<>();
        for (int d = 0; d <= 31; d++) diaCambios.addItem(d);
        agregarAInternal(diaCambios, 160, 180, 50, 25);

        mesCambios = new JComboBox<>(new String[]{
                "Elije", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        agregarAInternal(mesCambios, 215, 180, 100, 25);

        añoCambios = new JComboBox<>();
        for (int a = 1900; a <= 2025; a++) {
            añoCambios.addItem(a);
        }
        agregarAInternal(añoCambios, 320, 180, 80, 25);

        JLabel txtPrecioListaCambios = new JLabel("Precio de Lista:");
        agregarAInternal(txtPrecioListaCambios, 10, 210, 120, 20);

        precioListaCambios = new JFormattedTextField(NumberFormat.getNumberInstance());
        agregarAInternal(precioListaCambios, 135, 213, 150, 25);

        JLabel txtCilindrosCambios = new JLabel("Cilindros:");
        agregarAInternal(txtCilindrosCambios, 10, 240, 120, 20);

        String cilindrosCambios[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilCambios = new SpinnerListModel(cilindrosCambios);
        numCilindrosCambios = new JSpinner(modeloCilCambios);
        agregarAInternal(numCilindrosCambios, 135, 243, 50, 25);

        JLabel txtCapacidadCambios = new JLabel("Capacidad de Personas:");
        agregarAInternal(txtCapacidadCambios, 10, 370, 140, 20);

        String capacidadesCambios[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCapCambios = new SpinnerListModel(capacidadesCambios);
        capacidadCambios = new JSpinner(modeloCapCambios);
        agregarAInternal(capacidadCambios, 160, 370, 50, 25);

        JLabel txtPuertasCambios = new JLabel("Número de Puertas:");
        agregarAInternal(txtPuertasCambios, 10, 270, 120, 20);

        numPuertasCambios = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(numPuertasCambios, 160, 273, 50, 25);

        JLabel txtPesoCambios = new JLabel("Peso:");
        agregarAInternal(txtPesoCambios,10,330,80,20);

        pesoCambios = new JTextField();
        agregarAInternal(pesoCambios,135,333,150,25);

        JLabel txtColorCambios = new JLabel("Color:");
        agregarAInternal(txtColorCambios, 10, 300, 120, 20);

        String[] coloresAutoCambios = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        colorCambios = new JComboBox<>(coloresAutoCambios);
        agregarAInternal(colorCambios, 135, 303, 120, 25);

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
        agregarAInternal(scrollTablaCambios,10, 410, 640, 150);

        btnBuscarCambios = new JButton("Buscar");
        agregarAInternal(btnBuscarCambios, 320,68,110,30);

        btnRestablecerCambios = new JButton("Restablecer");
        agregarAInternal(btnRestablecerCambios, 490, 170,150,30);

        btnGuardarCambios = new JButton("Guardar Cambios");
        agregarAInternal(btnGuardarCambios, 490,240,150,30);

        btnCancelarCambios = new JButton("Cancelar");
        agregarAInternal(btnCancelarCambios, 490,310,150,30);



        add(panelCambios);
        add(panelDerechoCambios);
    }

    public void agregarComponentePanel(JPanel panel, JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        panel.add(componente);
    }

    public void agregarAInternal(JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        this.add(componente);
    }

}
