package Ventanas;

import ConexionBD.ConexionBD;
import Controlador.VehiculoDAO;
import Modelo.ResultSetTableModel;
import Modelo.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

public class VentanaConsultas extends JInternalFrame implements ActionListener {

    JButton btnRegistrosConsultas, btnInicio, btnBuscarConsultas, btnRestablecerConsultas, btnCancelarConsultas, btnPrimerReg, btnAnteriorReg, btnSiguienteReg, btnUltimoReg;
    JTextField cajaModeloConsultas, cajaFechaFabConsultas, cajaPrecioListaConsultas, cajaIndice;
    JSpinner numCilindrosConsultas, capacidadConsultas;
    JComboBox<Integer> cbNumPuertasConsultas;
    JComboBox<String> cbPaisFabConsultas, cbColorConsultas, cbPesoConsultas;
    JTable  tablaVehiculosConsultas;
    ButtonGroup rbGroup;
    JRadioButton rbTodos, rbModelo, rbPaisFab, rbFechaFab, rbPrecioLista, rbCilindros, rbNumPuertas, rbColor, rbPeso, rbCapacidad;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;


    VehiculoDAO vehiculoDAO = VehiculoDAO.getInstancia();
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
        btnInicio.addActionListener(this);

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
        btnRegistrosConsultas.addActionListener(this);


        JLabel txtConsultas = new JLabel("CONSULTAR VEHICULOS");
        txtConsultas.setFont(new Font("Roboto", Font.BOLD, 15));
        txtConsultas.setForeground(Color.WHITE);
        agregarComponentePanel(panelConsultas,txtConsultas,10, 25, 200, 20);


        //JLabel txtCriterio = new JLabel("Selecciona criterio de busqueda:");
        //agregarAInternal(IF_Consultas,txtCriterio,10,80,200,25);

        rbTodos = new JRadioButton("TODOS.");
        agregarAInternal(rbTodos, 10,100,80,20);
        rbTodos.addActionListener(this);
        rbTodos.setSelected(true);

        rbModelo = new JRadioButton("MODELO:");
        agregarAInternal(rbModelo,100,100,80,20);
        rbModelo.addActionListener(this);

        cajaModeloConsultas = new JTextField();
        agregarAInternal(cajaModeloConsultas,270,100,120,25);
        cajaModeloConsultas.setEnabled(false);

        rbPaisFab = new JRadioButton("PAIS FABRICACION:");
        agregarAInternal(rbPaisFab,100,130,140,20);
        rbPaisFab.addActionListener(this);

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
        cbPaisFabConsultas.addActionListener(this);
        cbPaisFabConsultas.setEnabled(false);

        rbFechaFab = new JRadioButton("FECHA FABRICACION:");
        agregarAInternal(rbFechaFab,100,160,150,20);
        rbFechaFab.addActionListener(this);

        cajaFechaFabConsultas = new JTextField();
        agregarAInternal(cajaFechaFabConsultas,270,160,120,25);
        cajaFechaFabConsultas.setEnabled(false);

        rbPrecioLista = new JRadioButton("PRECIO LISTA:");
        agregarAInternal(rbPrecioLista,100,190,120,20);
        rbPrecioLista.addActionListener(this);

        cajaPrecioListaConsultas = new JTextField();
        agregarAInternal(cajaPrecioListaConsultas,270,190,120,25);
        cajaPrecioListaConsultas.setEnabled(false);

        rbCilindros = new JRadioButton("CILINDROS:");
        agregarAInternal(rbCilindros,100,220,100,20);
        rbCilindros.addActionListener(this);

        String cilindrosConsultas[] = {"0", "3", "4", "5", "6", "8", "10", "12", "16"};
        SpinnerListModel modeloCilConsultas = new SpinnerListModel(cilindrosConsultas);
        numCilindrosConsultas = new JSpinner(modeloCilConsultas);
        agregarAInternal(numCilindrosConsultas,270,220,50,25);
        numCilindrosConsultas.setEnabled(false);

        rbNumPuertas = new JRadioButton("NUMERO PUERTAS:");
        agregarAInternal(rbNumPuertas,100,250,140,20);
        rbNumPuertas.addActionListener(this);

        cbNumPuertasConsultas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(cbNumPuertasConsultas,270,250,50,25);
        cbNumPuertasConsultas.addActionListener(this);
        cbNumPuertasConsultas.setEnabled(false);

        rbColor = new JRadioButton("COLOR:");
        agregarAInternal(rbColor,100,280,100,20);
        rbColor.addActionListener(this);

        String[] coloresAutoConsultas = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };
        cbColorConsultas = new JComboBox<>(coloresAutoConsultas);
        agregarAInternal(cbColorConsultas,270,280,120,25);
        cbColorConsultas.addActionListener(this);
        cbColorConsultas.setEnabled(false);

        rbPeso = new JRadioButton("PESO:");
        agregarAInternal(rbPeso,100,310,80,20);
        rbPeso.addActionListener(this);

        String[] pesos = {
                "Elije peso..", "800 kg", "900 kg", "1000 kg",
                "1100 kg", "1200 kg", "1300 kg",
                "1400 kg", "1500 kg", "1600 kg",
                "1700 kg", "1800 kg", "1900 kg",
                "2000 kg", "2200 kg", "2400 kg",
                "2600 kg", "2800 kg", "3000 kg"
        };
        cbPesoConsultas = new JComboBox<>(pesos);
        agregarAInternal(cbPesoConsultas,270,310,120,25);
        cbPesoConsultas.setEnabled(false);

        rbCapacidad = new JRadioButton("CAPACIDAD PERSONAS:");
        agregarAInternal(rbCapacidad,100,340,170,20);
        rbCapacidad.addActionListener(this);

        String capacidadesConsultas[] = {"0", "2", "4", "5", "7", "8", "12", "15"};
        SpinnerListModel modeloCapConsultas = new SpinnerListModel(capacidadesConsultas);
        capacidadConsultas = new JSpinner(modeloCapConsultas);
        agregarAInternal(capacidadConsultas,270,340,50,25);
        capacidadConsultas.setEnabled(false);

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
        btnBuscarConsultas.addActionListener(this);

        btnRestablecerConsultas = new JButton("Restablecer");
        agregarAInternal(btnRestablecerConsultas,490, 170,110,30);
        btnRestablecerConsultas.addActionListener(this);

        btnCancelarConsultas = new JButton("Cancelar");
        agregarAInternal(btnCancelarConsultas,490,240,110,30);
        btnCancelarConsultas.addActionListener(this);

        //Barra Busqueda
        btnPrimerReg = new JButton();
        btnPrimerReg.setIcon(new ImageIcon(new ImageIcon("./img/doble_flecha_izq.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnPrimerReg,240,68,30,25);
        btnPrimerReg.addActionListener(this);


        btnAnteriorReg = new JButton();
        btnAnteriorReg.setIcon(new ImageIcon(new ImageIcon("./img/flecha_izq.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnAnteriorReg,280,68,30,25);
        btnAnteriorReg.addActionListener(this);


        cajaIndice = new JTextField("0");
        cajaIndice.setFont(new Font("Arial", Font.BOLD, 18));
        agregarAInternal(cajaIndice,320,68,40,25);
        cajaIndice.setEnabled(false);


        btnSiguienteReg = new JButton();
        btnSiguienteReg.setIcon(new ImageIcon(new ImageIcon("./img/flecha_der.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnSiguienteReg,370,68,30,25);
        btnSiguienteReg.addActionListener(this);


        btnUltimoReg = new JButton();
        btnUltimoReg.setIcon(new ImageIcon(new ImageIcon("./img/doble_flecha_der.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        agregarAInternal(btnUltimoReg,410,68,30,25);
        btnUltimoReg.addActionListener(this);


        listaVehiculos = añadirVehiculos();
        actualizarEstadoBotones();
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

    public void limpiarVentana() {

        cajaModeloConsultas.setText("");
        cbPesoConsultas.setSelectedIndex(0);
        cajaPrecioListaConsultas.setText("");
        numCilindrosConsultas.setValue("0");
        capacidadConsultas.setValue("0");
        cbNumPuertasConsultas.setSelectedIndex(0);
        cbPaisFabConsultas.setSelectedIndex(0);
        cbColorConsultas.setSelectedIndex(0);
        cajaFechaFabConsultas.setText("");
        cajaIndice.setText("0");
        rbGroup.clearSelection();
        posActual = -1;


    }




    public void refrescarTabla(){
        vehiculoDAO.actualizarTabla(tablaVehiculosConsultas);
    }





    public void actualizarTablaFiltro(JTable tabla){
        ResultSetTableModel modelo;

        try {
            if (rbModelo.isSelected()){
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Modelo", cajaModeloConsultas.getText());
            } else if (rbPaisFab.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Pais_Fab", cbPaisFabConsultas.getSelectedItem().toString());
            } else if (rbFechaFab.isSelected()) {

                if (cajaFechaFabConsultas.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Ingresa una fecha en el campo");
                    return;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate localDate = LocalDate.parse(cajaFechaFabConsultas.getText(), formatter);
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

                    modelo = vehiculoDAO.obtenerVehiculosFiltrados("Fecha_Fab", fechaSQL);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "La fecha ingresada no tiene el formato correcto (dd/MM/yyyy).");
                    return;
                }

            } else if (rbPrecioLista.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Precio_Lista", cajaPrecioListaConsultas.getText());
            } else if (rbCilindros.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Num_Cilindros", numCilindrosConsultas.getValue().toString());
            } else if (rbNumPuertas.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Num_Puertas", cbNumPuertasConsultas.getSelectedItem().toString());
            } else if (rbColor.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Color", cbColorConsultas.getSelectedItem().toString());
            } else if (rbPeso.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Peso", cbPesoConsultas.getSelectedItem().toString());
            } else if (rbCapacidad.isSelected()) {
                modelo = vehiculoDAO.obtenerVehiculosFiltrados("Cap_Personas", capacidadConsultas.getValue().toString());
            } else {
                modelo = vehiculoDAO.obtenerVehiculos();
            }
            tabla.setModel(modelo);

            int columnaFecha = 3;
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

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar vehiculos: " + e.getMessage());
            e.printStackTrace();
        }

    }

    ArrayList<Vehiculo> listaVehiculos =  new ArrayList<>();
    int posActual = -1;

    public ArrayList<Vehiculo> añadirVehiculos() {
        listaVehiculos.clear();

        String sql = "SELECT * FROM Vehiculos";
        ResultSet rs = null;

        try {
            rs = ConexionBD.getInstancia().ejecutarConsultaSQL(sql);

            if (rs != null && rs.next()) {
                do {
                    String nv = rs.getString(1);
                    String mc = rs.getString(2);
                    String pf = rs.getString(3);
                    Date fechaSql = rs.getDate("Fecha_Fab");
                    String pl = rs.getString(5);
                    String nc = rs.getString(6);
                    Byte np = rs.getByte(7);
                    String cc = rs.getString(8);
                    String pc = rs.getString(9);
                    String cap = rs.getString(10);

                    Vehiculo v = new Vehiculo(nv, mc, pf, fechaSql, pl, nc, np, cc, pc, cap);
                    listaVehiculos.add(v);
                } while (rs.next());

            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron registros de Vehiculo");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los alumnos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaVehiculos;
    }

    public void mostrarRegistros(int indice) {
        if (indice >= 0 && indice < listaVehiculos.size()) {
            Vehiculo reg = listaVehiculos.get(indice);



            cajaModeloConsultas.setText(reg.getModelo());
            cbPaisFabConsultas.setSelectedItem(reg.getPaisFab());

            java.util.Date fecha = reg.getFechaFab();
            if (fecha != null) {
                java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
                LocalDate localDate = fechaSql.toLocalDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                cajaFechaFabConsultas.setText(localDate.format(formatter));
            } else {
                cajaFechaFabConsultas.setText("");
            }


            cajaPrecioListaConsultas.setText(reg.getPrecioLista());
            numCilindrosConsultas.setValue(reg.getNumCilindros());
            cbNumPuertasConsultas.setSelectedItem((int) reg.getNumPuertas());
            cbColorConsultas.setSelectedItem(reg.getColor());
            cbPesoConsultas.setSelectedItem(reg.getPaisFab());
            capacidadConsultas.setValue(reg.getCapacidadPersonas());

            cajaIndice.setText(String.valueOf(indice + 1));
            posActual = indice;

            actualizarEstadoBotones();
        }
    }









    public void actualizarEstadoBotones() {

        if (posActual != 0 || listaVehiculos.isEmpty()){
            btnPrimerReg.setEnabled(true);
        }else {
            btnPrimerReg.setEnabled(false);
        }
        //btnPrimerReg.setEnabled(posActual > 0 || listaVehiculos.isEmpty());
        btnAnteriorReg.setEnabled(posActual > 0);
        btnSiguienteReg.setEnabled(posActual < listaVehiculos.size() - 1);
        btnUltimoReg.setEnabled(posActual < listaVehiculos.size() - 1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if (componente == btnBuscarConsultas){
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == btnRestablecerConsultas) {
            if (cajaIndice.getText().equals("0")){
                JOptionPane.showMessageDialog(this,"No hay datos para borrar");
            }
            cajaIndice.setText("0");
            posActual = -1;
            actualizarEstadoBotones();
            limpiarVentana();
            
        } else if (componente == btnCancelarConsultas) {

            Object[] opciones = {"Sí", "No"};
            int confirm = JOptionPane.showOptionDialog(
                    this,"¿Seguro que quieres salir de esta ventana?","Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]
            );

            if (confirm == JOptionPane.YES_OPTION) {
                //this.dispose();
                this.setVisible(false);
            }
            
        } else if (componente == rbTodos) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);

            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbModelo) {
            cajaModeloConsultas.setEnabled(true);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbPaisFab) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(true);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbFechaFab) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(true);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbPrecioLista) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(true);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbCilindros) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(true);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbNumPuertas) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(true);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbColor) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(true);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbPeso) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(true);
            capacidadConsultas.setEnabled(false);
            actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == rbCapacidad) {
            cajaModeloConsultas.setEnabled(false);
            cbPaisFabConsultas.setEnabled(false);
            cajaFechaFabConsultas.setEnabled(false);
            cajaPrecioListaConsultas.setEnabled(false);
            numCilindrosConsultas.setEnabled(false);
            cbNumPuertasConsultas.setEnabled(false);
            cbColorConsultas.setEnabled(false);
            cbPesoConsultas.setEnabled(false);
            capacidadConsultas.setEnabled(true);
             actualizarTablaFiltro(tablaVehiculosConsultas);

        } else if (componente == btnPrimerReg) {

            if (!listaVehiculos.isEmpty()) {
                mostrarRegistros(0);

            }
        } else if (componente == btnAnteriorReg) {

            if (posActual > 0) {
                mostrarRegistros(posActual - 1);
            }
        } else if (componente == btnSiguienteReg) {

            if (posActual < listaVehiculos.size() - 1) {
                mostrarRegistros(posActual + 1);
            }
        } else if (componente == btnUltimoReg) {

            if (!listaVehiculos.isEmpty()) {
                mostrarRegistros(listaVehiculos.size() - 1);
            }

        } else if (componente == btnInicio) {
            refrescarTabla();
            limpiarVentana();
            this.setVisible(false);
        }
        listaVehiculos = añadirVehiculos();
    }
}
