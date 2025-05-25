package Ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaConsultas extends JInternalFrame {

    JButton btnRegistrosConsultas, btnInicio, btnBuscarConsultas, btnRestablecerConsultas, btnCancelarConsultas, btnPrimerReg, btnAnteriorReg, btnSiguienteReg, btnUltimoReg;
    JTextField cajaModeloConsultas, cajaPesoConsultas, cajaFechaFabConsultas, cajaPrecioListaConsultas, cajaIndice;
    JSpinner numCilindrosConsultas, capacidadConsultas;
    JComboBox<Integer> cbNumPuertasConsultas, cbDiaConsultas, cbAñoConsultas;
    JComboBox<String> cbPaisFabConsultas, cbMesConsultas, cbColorConsultas;
    JTable  tablaVehiculosConsultas;
    ButtonGroup rbGroup;
    JRadioButton rbTodos, rbModelo, rbPaisFab, rbFechaFab, rbPrecioLista, rbCilindros, rbNumPuertas, rbColor, rbPeso, rbCapacidad;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;

    public VentanaConsultas(){

        super("CONSULTAS", true, true, false, true);
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panelConsultas = new JPanel();
        panelConsultas.setLayout(null);
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
        separador4.setForeground(new Color(150, 150, 150));
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


        //JLabel txtCriterio = new JLabel("Selecciona criterio de busqueda:");
        //agregarAInternal(IF_Consultas,txtCriterio,10,80,200,25);

        rbTodos = new JRadioButton("TODOS.");
        agregarAInternal(rbTodos, 10,100,80,20);

        rbModelo = new JRadioButton("MODELO:");
        agregarAInternal(rbModelo,100,100,80,20);

        cajaModeloConsultas = new JTextField();
        agregarAInternal(cajaModeloConsultas,270,100,120,25);

        rbPaisFab = new JRadioButton("PAIS FABRICACION:");
        agregarAInternal(rbPaisFab,100,130,140,20);

        String[] paisesFabricantesConsultas = {
                "Elige un pais..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };
        cbPaisFabConsultas = new JComboBox<>(paisesFabricantesConsultas);
        agregarAInternal(cbPaisFabConsultas,270,130,120,25);

        rbFechaFab = new JRadioButton("FECHA FABRICACION:");
        agregarAInternal(rbFechaFab,100,160,150,20);

        cajaFechaFabConsultas = new JTextField();
        agregarAInternal(cajaFechaFabConsultas,270,160,120,25);

        rbPrecioLista = new JRadioButton("PRECIO LISTA:");
        agregarAInternal(rbPrecioLista,100,190,120,20);

        cajaPrecioListaConsultas = new JTextField();
        agregarAInternal(cajaPrecioListaConsultas,270,190,120,25);

        rbCilindros = new JRadioButton("CILINDROS:");
        agregarAInternal(rbCilindros,100,220,100,20);

        String cilindrosConsultas[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilConsultas = new SpinnerListModel(cilindrosConsultas);
        numCilindrosConsultas = new JSpinner(modeloCilConsultas);
        agregarAInternal(numCilindrosConsultas,270,220,50,25);

        rbNumPuertas = new JRadioButton("NUMERO PUERTAS:");
        agregarAInternal(rbNumPuertas,100,250,140,20);

        cbNumPuertasConsultas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(cbNumPuertasConsultas,270,250,50,25);

        rbColor = new JRadioButton("COLOR:");
        agregarAInternal(rbColor,100,280,100,20);

        String[] coloresAutoConsultas = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };
        cbColorConsultas = new JComboBox<>(coloresAutoConsultas);
        agregarAInternal(cbColorConsultas,270,280,120,25);

        rbPeso = new JRadioButton("PESO:");
        agregarAInternal(rbPeso,100,310,80,20);

        cajaPesoConsultas = new JTextField();
        agregarAInternal(cajaPesoConsultas,270,310,120,25);

        rbCapacidad = new JRadioButton("CAPACIDAD PERSONAS:");
        agregarAInternal(rbCapacidad,100,340,170,20);

        String capacidadesConsultas[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCapConsultas = new SpinnerListModel(capacidadesConsultas);
        capacidadConsultas = new JSpinner(modeloCapConsultas);
        agregarAInternal(capacidadConsultas,270,340,50,25);

        rbGroup = new ButtonGroup();
        rbGroup.add(rbTodos);
        rbGroup.add(rbModelo);
        rbGroup.add(rbPaisFab);
        rbGroup.add(rbFechaFab);
        rbGroup.add(rbPrecioLista);
        rbGroup.add(rbCilindros);
        rbGroup.add(rbNumPuertas);
        rbGroup.add(rbColor);
        rbGroup.add(rbPeso);
        rbGroup.add(rbCapacidad);

        String[] columnasConsultas = {"Num_Vehiculo", "Modelo", "País", "Fecha Fab", "Precio", "Cilindros", "Capacidad", "Puertas", "Color"};
        String[][] datosConsultas = {
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        };
        tablaVehiculosConsultas = new JTable(datosConsultas, columnasConsultas);
        tablaVehiculosConsultas.setRowHeight(20);
        tablaVehiculosConsultas.setPreferredScrollableViewportSize(new Dimension(660, 150));

        JScrollPane scrollTablaConsultas = new JScrollPane(tablaVehiculosConsultas);
        agregarAInternal(scrollTablaConsultas,10, 410, 640, 150);

        btnBuscarConsultas = new JButton("Buscar");
        agregarAInternal(btnBuscarConsultas,490, 100,110,30);

        btnRestablecerConsultas = new JButton("Restablecer");
        agregarAInternal(btnRestablecerConsultas,490, 170,110,30);

        btnCancelarConsultas = new JButton("Cancelar");
        agregarAInternal(btnCancelarConsultas,490,240,110,30);

        //Barra Busqueda
        btnPrimerReg = new JButton();
        btnPrimerReg.setIcon(new ImageIcon(new ImageIcon("./img/doble_flecha_izq.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnPrimerReg,240,68,30,25);


        btnAnteriorReg = new JButton();
        btnAnteriorReg.setIcon(new ImageIcon(new ImageIcon("./img/flecha_izq.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnAnteriorReg,280,68,30,25);


        cajaIndice = new JTextField("0");
        cajaIndice.setFont(new Font("Arial", Font.BOLD, 18));
        agregarAInternal(cajaIndice,320,68,40,25);


        btnSiguienteReg = new JButton();
        btnSiguienteReg.setIcon(new ImageIcon(new ImageIcon("./img/flecha_der.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnSiguienteReg,370,68,30,25);


        btnUltimoReg = new JButton();
        btnUltimoReg.setIcon(new ImageIcon(new ImageIcon("./img/doble_flecha_der.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnUltimoReg,410,68,30,25);

        add(panelConsultas);
        add(panelDerechoConsultas);
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
