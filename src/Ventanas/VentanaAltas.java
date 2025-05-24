package Ventanas;

import Controlador.VehiculoDAO;
import Modelo.ResultSetTableModel;
import Modelo.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.StreamSupport;

import static java.util.Date.*;

public class VentanaAltas extends JInternalFrame implements ActionListener {

    JButton btnAgregar, btnRestablecerAltas, btnCancelarAltas;
    JTextField cajaNumVehiculoAltas, cajaModeloAltas, cajaPesoAltas, cajaPrecioListaAltas;
    JSpinner numCilindrosAltas, capacidadAltas;
    JComboBox<Integer> cbNumPuertasAltas, cbDiaAltas, cbAñoAltas;
    JComboBox<String> cbPaisFabAltas, cbMesAltas, cbColorAltas;
    JTable tablaVehiculosAltas;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;
    JButton btnInicio, btnRegistrosAltas;


    VehiculoDAO vehiculoDAO = VehiculoDAO.getInstancia();
    public VentanaAltas() {
        super("ALTAS", true, true, false, true); // Título y propiedades del InternalFrame
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panelAltas = new JPanel();
        panelAltas.setLayout(null);
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
        agregarAInternal(txtIdVehiculoAltas,10,80,120,20);

        cajaNumVehiculoAltas = new JTextField();
        agregarAInternal(cajaNumVehiculoAltas,135, 83,150,25);

        JLabel txtModeloAltas = new JLabel("Modelo:");
        agregarAInternal(txtModeloAltas,10,110,120,20);

        cajaModeloAltas = new JTextField();
        agregarAInternal(cajaModeloAltas,135,113,150,25);

        JLabel txtPaisFabAltas = new JLabel("Pais de Fabricacion");
        agregarAInternal(txtPaisFabAltas,10,150,120,20);

        String[] paisesFabricantesAltas = {
                "Elige un pais..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        cbPaisFabAltas = new JComboBox<>(paisesFabricantesAltas);
        cbPaisFabAltas.setEditable(false);
        agregarAInternal(cbPaisFabAltas,135,148,120,25);

        JLabel txtFechaFabAltas = new JLabel("Fecha de Fabricación:");
        agregarAInternal(txtFechaFabAltas, 10, 180, 150, 20);


        cbDiaAltas = new JComboBox<>();
        for (int d = 0; d <= 31; d++) cbDiaAltas.addItem(d);
        agregarAInternal(cbDiaAltas, 160, 180, 50, 25);

        String[] mesesAltas = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        cbMesAltas = new JComboBox<>(mesesAltas);
        agregarAInternal(cbMesAltas, 215, 180, 100, 25);


        cbAñoAltas = new JComboBox<>();
        for (int a = 1900; a <= 2025; a++) {
            cbAñoAltas.addItem(a);
        }
        agregarAInternal(cbAñoAltas, 320, 180, 80, 25);


        JLabel txtPrecioListaAltas = new JLabel("Precio de Lista:");
        agregarAInternal(txtPrecioListaAltas, 10, 210, 120, 20);

        cajaPrecioListaAltas = new JTextField();
        agregarAInternal(cajaPrecioListaAltas, 135, 213, 150, 25);


        JLabel txtCilindrosAltas = new JLabel("Cilindros:");
        agregarAInternal(txtCilindrosAltas, 10, 240, 120, 20);


        String cilindrosAltas[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilAltas = new SpinnerListModel(cilindrosAltas);
        numCilindrosAltas = new JSpinner(modeloCilAltas);
        agregarAInternal(numCilindrosAltas, 135, 243, 50, 25);


        JLabel txtCapacidadAltas = new JLabel("Capacidad de Personas:");
        agregarAInternal(txtCapacidadAltas, 10, 370, 140, 20);

        String capacidadesAltas[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCap = new SpinnerListModel(capacidadesAltas);
        capacidadAltas = new JSpinner(modeloCap);
        agregarAInternal(capacidadAltas, 160, 370, 50, 25);


        JLabel txtPuertasAltas = new JLabel("Número de Puertas:");
        agregarAInternal(txtPuertasAltas, 10, 270, 120, 20);

        cbNumPuertasAltas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(cbNumPuertasAltas, 160, 273, 50, 25);

        JLabel txtPesoAltas = new JLabel("Peso:");
        agregarAInternal(txtPesoAltas,10,330,80,20);

        cajaPesoAltas = new JTextField();
        agregarAInternal(cajaPesoAltas,135,333,150,25);

        JLabel txtColorAltas = new JLabel("Color:");
        agregarAInternal(txtColorAltas, 10, 300, 120, 20);

        String[] coloresAutoAltas = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        cbColorAltas = new JComboBox<>(coloresAutoAltas);
        agregarAInternal(cbColorAltas, 135, 303, 120, 25);


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
        agregarAInternal(scrollTablaAltas,10, 410, 640, 150);


        btnAgregar = new JButton("Agregar");
        agregarAInternal(btnAgregar,490, 100,110,30);
        btnAgregar.addActionListener(this);

        btnRestablecerAltas = new JButton("Restablecer");
        agregarAInternal(btnRestablecerAltas,490, 170,110,30);

        btnCancelarAltas = new JButton("Cancelar");
        agregarAInternal(btnCancelarAltas,490,240,110,30);






        add(panelAltas);
        add(panelDerechoAltas);
    }

    public void agregarComponentePanel(JPanel panel, JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        panel.add(componente);
    }

    public void agregarAInternal(JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        this.add(componente);
    }

    public void actualizarTabla(JTable tabla){
        final String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/BD_Autos_Amistosos";
        final String CONSULTA = "SELECT * FROM vehiculos";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);
            tabla.setModel(modelo);

            // Aquí pones el renderer para la columna de fecha
            int columnaFecha = 3; // Cambia 3 por el índice real de la columna fecha en tu tabla
            tabla.getColumnModel().getColumn(columnaFecha).setCellRenderer(new DefaultTableCellRenderer() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                @Override
                public void setValue(Object value) {
                    if (value instanceof java.sql.Date) {
                        LocalDate localDate = ((java.sql.Date) value).toLocalDate();
                        setText(localDate.format(formatter));
                    } else {
                        super.setValue(value);
                    }
                }
            });

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public int obtenerNumeroMes(String nombreMes) {
        if (nombreMes.equalsIgnoreCase("Enero")) {
            return 1;
        } else if (nombreMes.equalsIgnoreCase("Febrero")) {
            return 2;
        } else if (nombreMes.equalsIgnoreCase("Marzo")) {
            return 3;
        } else if (nombreMes.equalsIgnoreCase("Abril")) {
            return 4;
        } else if (nombreMes.equalsIgnoreCase("Mayo")) {
            return 5;
        } else if (nombreMes.equalsIgnoreCase("Junio")) {
            return 6;
        } else if (nombreMes.equalsIgnoreCase("Julio")) {
            return 7;
        } else if (nombreMes.equalsIgnoreCase("Agosto")) {
            return 8;
        } else if (nombreMes.equalsIgnoreCase("Septiembre")) {
            return 9;
        } else if (nombreMes.equalsIgnoreCase("Octubre")) {
            return 10;
        } else if (nombreMes.equalsIgnoreCase("Noviembre")) {
            return 11;
        } else if (nombreMes.equalsIgnoreCase("Diciembre")) {
            return 12;
        } else {
            return -1; // Valor inválido
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if (componente == btnAgregar){

            String dia = cbDiaAltas.getSelectedItem().toString();
            String mes = cbMesAltas.getSelectedItem().toString();
            String año = cbAñoAltas.getSelectedItem().toString();

            int numMes = obtenerNumeroMes(mes);

            LocalDate fecha = LocalDate.of(Integer.parseInt(año), numMes, Integer.parseInt(dia));
            Date fechaSQL = java.sql.Date.valueOf(fecha);


            Vehiculo v = new Vehiculo(
                    cajaNumVehiculoAltas.getText(),
                    cajaModeloAltas.getText(),
                    cbPaisFabAltas.getSelectedItem().toString(),
                    fechaSQL,
                    cajaPrecioListaAltas.getText(),
                    numCilindrosAltas.getValue().toString(),
                    Byte.parseByte(cbNumPuertasAltas.getSelectedItem().toString()),
                    cbColorAltas.getSelectedItem().toString(),
                    cajaPesoAltas.getText(),
                    capacidadAltas.getValue().toString());


            if (vehiculoDAO.agregarVehiculo(v)){
                JOptionPane.showMessageDialog(this,"Registro Agregado CORRECTAMENTE");
                System.out.println("Registro Agregado CORRECTAMENTE");
                System.out.println("ejecutando");


                actualizarTabla(tablaVehiculosAltas);

            } else{
                JOptionPane.showMessageDialog(this,"Error en la insercion");
                System.out.println("ERROR en la insercion");
            }
        }
    }
}
