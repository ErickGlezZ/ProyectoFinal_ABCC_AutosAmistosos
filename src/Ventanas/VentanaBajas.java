package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class VentanaBajas extends JInternalFrame {

    JButton  btnEliminar, btnRestablecerBajas, btnCancelarBajas, btnBuscarBajas, btnInicio, btnRegistrosBajas;
    JTextField idVehiculoBajas, modeloBajas, pesoBajas;
    JFormattedTextField precioListaBajas;
    JSpinner numCilindrosBajas, capacidadBajas;
    JComboBox<Integer> numPuertasBajas, diaBajas, añoBajas;
    JComboBox<String> paisFabBajas, mesBajas, colorBajas;
    JTable tablaVehiculosBajas;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;



    public VentanaBajas(){

        super("BAJAS", true, true, false, true);
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panelBajas = new JPanel();
        panelBajas.setLayout(null);
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
        separador2.setForeground(new Color(150, 150, 150));
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
        agregarAInternal(txtIdVehiculoBajas,10,70,120,20);

        idVehiculoBajas = new JTextField();
        agregarAInternal(idVehiculoBajas,135, 68,100,30);

        JSeparator separadorBajas = new JSeparator();
        separadorBajas.setForeground(Color.GRAY);
        agregarAInternal(separadorBajas, 10, 105, 640, 2);

        JLabel txtModeloBajas = new JLabel("Modelo:");
        agregarAInternal(txtModeloBajas,10,113,120,20);

        modeloBajas = new JTextField();
        agregarAInternal(modeloBajas,135,113,100,25);

        JLabel txtPaisFabBajas = new JLabel("Pais de Fabricacion");
        agregarAInternal(txtPaisFabBajas,10,150,120,20);

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
        agregarAInternal(paisFabBajas,135,148,120,25);

        JLabel txtFechaFabBajas = new JLabel("Fecha de Fabricación:");
        agregarAInternal(txtFechaFabBajas, 10, 180, 150, 20);


        diaBajas = new JComboBox<>();
        for (int d = 0; d <= 31; d++) diaBajas.addItem(d);
        agregarAInternal(diaBajas, 160, 180, 50, 25);


        mesBajas = new JComboBox<>(new String[]{
                "Elije", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        agregarAInternal(mesBajas, 215, 180, 100, 25);


        añoBajas = new JComboBox<>();
        for (int a = 1900; a <= 2025; a++) {
            añoBajas.addItem(a);
        }
        agregarAInternal(añoBajas, 320, 180, 80, 25);


        JLabel txtPrecioListaBajas = new JLabel("Precio de Lista:");
        agregarAInternal(txtPrecioListaBajas, 10, 210, 120, 20);

        precioListaBajas = new JFormattedTextField(NumberFormat.getNumberInstance());
        agregarAInternal(precioListaBajas, 135, 213, 150, 25);


        JLabel txtCilindrosBajas = new JLabel("Cilindros:");
        agregarAInternal( txtCilindrosBajas, 10, 240, 120, 20);


        String cilindrosBajas[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilBajas = new SpinnerListModel(cilindrosBajas);
        numCilindrosBajas = new JSpinner(modeloCilBajas);
        agregarAInternal(numCilindrosBajas, 135, 243, 50, 25);


        JLabel txtCapacidadBajas = new JLabel("Capacidad de Personas:");
        agregarAInternal(txtCapacidadBajas, 10, 370, 140, 20);

        String capacidadesBajas[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCapBajas = new SpinnerListModel(capacidadesBajas);
        capacidadBajas = new JSpinner(modeloCapBajas);
        agregarAInternal(capacidadBajas, 160, 370, 50, 25);


        JLabel txtPuertasBajas = new JLabel("Número de Puertas:");
        agregarAInternal(txtPuertasBajas, 10, 270, 120, 20);

        numPuertasBajas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(numPuertasBajas, 160, 273, 50, 25);

        JLabel txtPesoBajas = new JLabel("Peso:");
        agregarAInternal(txtPesoBajas,10,330,80,20);

        pesoBajas = new JTextField();
        agregarAInternal(pesoBajas,135,333,150,25);

        JLabel txtColorBajas = new JLabel("Color:");
        agregarAInternal(txtColorBajas, 10, 300, 120, 20);

        String[] coloresAutoBajas = {
                "Elige Color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        colorBajas = new JComboBox<>(coloresAutoBajas);
        agregarAInternal(colorBajas, 135, 303, 120, 25);


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
        agregarAInternal(scrollTablaBajas,10, 410, 640, 150);

        btnBuscarBajas = new JButton("Buscar");
        agregarAInternal(btnBuscarBajas,320,68,110,30);

        btnEliminar = new JButton("Eliminar");
        agregarAInternal(btnEliminar,490, 120,110,30);

        btnRestablecerBajas = new JButton("Restablecer");
        agregarAInternal(btnRestablecerBajas,490, 190,110,30);

        btnCancelarBajas = new JButton("Cancelar");
        agregarAInternal(btnCancelarBajas,490,260,110,30);






        add(panelBajas);
        add(panelDerechoBajas);
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
