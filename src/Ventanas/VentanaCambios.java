package Ventanas;

import ConexionBD.ConexionBD;
import Controlador.VehiculoDAO;
import Modelo.ResultSetTableModel;
import Modelo.Vehiculo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VentanaCambios extends JInternalFrame implements ActionListener {

    JButton btnBuscarCambios, btnRestablecerCambios, btnGuardarCambios, btnCancelarCambios, btnRegistrosCambios, btnInicio;
    JTextField  cajaNumVehiculoCambios, cajaModeloCambios, cajaPrecioListaCambios;
    JSpinner numCilindrosCambios, capacidadCambios;
    JComboBox<Integer> cbNumPuertasCambios, cbDiaCambios, cbAñoCambios;
    JComboBox<String> cbPaisFabCambios, cbMesCambios, cbColorCambios, cbPesoCambios;
    JScrollPane scrollTablaCambios;
    JTable  tablaVehiculosCambios;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig, txtEstadoReg;


    ConexionBD conexionBD = ConexionBD.getInstancia();
    VehiculoDAO vehiculoDAO = VehiculoDAO.getInstancia();
    public VentanaCambios(){

        super("CAMBIOS", true, true, false, true);
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panelCambios = new JPanel();
        panelCambios.setLayout(null);
        panelCambios.setBackground(new Color(220,118,51));
        panelCambios.setBounds(0, 0, 770, 60);

        JPanel panelDerechoCambios = new JPanel();
        panelDerechoCambios.setBackground(new Color(60, 63, 65));
        panelDerechoCambios.setBounds(770, 0, 160, 700);
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
        btnInicio.addActionListener(this);


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
        btnRegistrosCambios.addActionListener(this);

        txtEstadoReg = new JLabel("Registros...");
        txtEstadoReg.setForeground(Color.WHITE);
        txtEstadoReg.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoCambios,txtEstadoReg, 15,550,145,25);

        JLabel txtCambios = new JLabel("CAMBIOS VEHICULOS");
        txtCambios.setFont(new Font("Roboto", Font.BOLD, 15));
        txtCambios.setForeground(Color.WHITE);
        agregarComponentePanel(panelCambios, txtCambios,10, 25, 180, 20);

        JLabel txtIdVehiculoCambios = new JLabel("Numero Vehiculo:");
        agregarAInternal(txtIdVehiculoCambios,10,70,120,20);

        cajaNumVehiculoCambios = new JTextField();
        agregarAInternal(cajaNumVehiculoCambios,135, 68,100,30);

        JSeparator separadorCambios = new JSeparator();
        separadorCambios.setForeground(Color.GRAY);
        agregarAInternal(separadorCambios, 10, 105, 640, 2);

        JLabel txtModeloCambios = new JLabel("Modelo:");
        agregarAInternal(txtModeloCambios,10,113,120,20);

        cajaModeloCambios = new JTextField();
        agregarAInternal(cajaModeloCambios,135,113,100,25);

        JLabel txtPaisFabCambios = new JLabel("Pais de Fabricacion");
        agregarAInternal(txtPaisFabCambios,10,150,120,20);

        String[] paisesFabricantesCambios = {
                "Elige un pais..", "Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        cbPaisFabCambios = new JComboBox<>(paisesFabricantesCambios);
        cbPaisFabCambios.setEditable(false);
        agregarAInternal(cbPaisFabCambios,135,148,120,25);

        JLabel txtFechaFabCambios = new JLabel("Fecha de Fabricación:");
        agregarAInternal(txtFechaFabCambios, 10, 180, 150, 20);

        String[] mesesCambios = {
                "Elije un mes..", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        cbDiaCambios = new JComboBox<>();
        for (int d = 0; d <= 31; d++) cbDiaCambios.addItem(d);
        agregarAInternal(cbDiaCambios, 160, 180, 50, 25);

        cbMesCambios = new JComboBox<>(mesesCambios);
        agregarAInternal(cbMesCambios, 215, 180, 100, 25);

        cbAñoCambios = new JComboBox<>();
        cbAñoCambios.addItem(0);
        for (int a = 1900; a <= 2025; a++) {
            cbAñoCambios.addItem(a);
        }
        agregarAInternal(cbAñoCambios, 320, 180, 80, 25);

        cbMesCambios.addActionListener(e -> actualizarDias());
        cbAñoCambios.addActionListener(e -> actualizarDias());

        JLabel txtPrecioListaCambios = new JLabel("Precio de Lista:");
        agregarAInternal(txtPrecioListaCambios, 10, 210, 120, 20);

        cajaPrecioListaCambios = new JTextField();
        agregarAInternal(cajaPrecioListaCambios, 135, 213, 150, 25);

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

        cbNumPuertasCambios = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(cbNumPuertasCambios, 160, 273, 50, 25);

        JLabel txtPesoCambios = new JLabel("Peso:");
        agregarAInternal(txtPesoCambios,10,330,80,20);

        String[] pesos = {
                "Elije peso..", "800 kg", "900 kg", "1000 kg",
                "1100 kg", "1200 kg", "1300 kg",
                "1400 kg", "1500 kg", "1600 kg",
                "1700 kg", "1800 kg", "1900 kg",
                "2000 kg", "2200 kg", "2400 kg",
                "2600 kg", "2800 kg", "3000 kg"
        };
        cbPesoCambios = new JComboBox<>(pesos);
        agregarAInternal(cbPesoCambios,135,333,150,25);

        JLabel txtColorCambios = new JLabel("Color:");
        agregarAInternal(txtColorCambios, 10, 300, 120, 20);

        String[] coloresAutoCambios = {
                "Elige color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        cbColorCambios = new JComboBox<>(coloresAutoCambios);
        agregarAInternal(cbColorCambios, 135, 303, 120, 25);

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

        scrollTablaCambios = new JScrollPane(tablaVehiculosCambios);
        scrollTablaCambios.setVisible(false);
        agregarAInternal(scrollTablaCambios,10, 410, 750, 150);

        btnBuscarCambios = new JButton("Buscar");
        btnBuscarCambios.setIcon(new ImageIcon(new ImageIcon("./img/search.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnBuscarCambios, 320,68,140,30);
        btnBuscarCambios.addActionListener(this);

        btnRestablecerCambios = new JButton("Restablecer");
        btnRestablecerCambios.setIcon(new ImageIcon(new ImageIcon("./img/rest.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnRestablecerCambios, 490, 170,170,30);
        btnRestablecerCambios.addActionListener(this);

        btnGuardarCambios = new JButton("Guardar Cambios");
        btnGuardarCambios.setIcon(new ImageIcon(new ImageIcon("./img/save.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnGuardarCambios, 490,240,170,30);
        btnGuardarCambios.addActionListener(this);

        btnCancelarCambios = new JButton("Cancelar");
        btnCancelarCambios.setIcon(new ImageIcon(new ImageIcon("./img/cancelar.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnCancelarCambios, 490,310,170,30);
        btnCancelarCambios.addActionListener(this);



        cajaModeloCambios.setEnabled(false);
        cbPaisFabCambios.setEnabled(false);
        cbDiaCambios.setEnabled(false);
        cbMesCambios.setEnabled(false);
        cbAñoCambios.setEnabled(false);
        cajaPrecioListaCambios.setEnabled(false);
        numCilindrosCambios.setEnabled(false);
        cbNumPuertasCambios.setEnabled(false);
        cbColorCambios.setEnabled(false);
        cbPesoCambios.setEnabled(false);
        capacidadCambios.setEnabled(false);


        this.getContentPane().setBackground(new Color(40,44,52));
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



    public void limpiarVentana() {

        cajaNumVehiculoCambios.setText("");
        cajaModeloCambios.setText("");
        cbPesoCambios.setSelectedIndex(0);
        cajaPrecioListaCambios.setText("");
        numCilindrosCambios.setValue("0");
        capacidadCambios.setValue("0");
        cbNumPuertasCambios.setSelectedIndex(0);
        cbDiaCambios.setSelectedIndex(0);
        cbAñoCambios.setSelectedIndex(0);
        cbPaisFabCambios.setSelectedIndex(0);
        cbMesCambios.setSelectedIndex(0);
        cbColorCambios.setSelectedIndex(0);

    }

    public void habilitarCamposEdicion(boolean habilitar) {
        cajaModeloCambios.setEnabled(habilitar);
        cbPaisFabCambios.setEnabled(habilitar);
        cbDiaCambios.setEnabled(habilitar);
        cbMesCambios.setEnabled(habilitar);
        cbAñoCambios.setEnabled(habilitar);
        cajaPrecioListaCambios.setEnabled(habilitar);
        numCilindrosCambios.setEnabled(habilitar);
        cbNumPuertasCambios.setEnabled(habilitar);
        cbColorCambios.setEnabled(habilitar);
        cbPesoCambios.setEnabled(habilitar);
        capacidadCambios.setEnabled(habilitar);
    }

    public void obtenerDatosVehiculo() {

        String sql = "SELECT * FROM Vehiculos WHERE Num_Vehiculo = ?";

        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql, cajaNumVehiculoCambios.getText());

        try {
            if (rs != null && rs.next()) {
                cajaModeloCambios.setText(rs.getString("Modelo"));
                cbPaisFabCambios.setSelectedItem(rs.getString("Pais_Fab"));


                Date fechaSql = rs.getDate("Fecha_Fab");
                if (fechaSql != null) {
                    LocalDate localDate = ((java.sql.Date) fechaSql).toLocalDate();
                    cbAñoCambios.setSelectedItem(localDate.getYear());
                    cbMesCambios.setSelectedIndex(localDate.getMonthValue());
                    cbDiaCambios.setSelectedItem(localDate.getDayOfMonth());

                }
                cajaPrecioListaCambios.setText(rs.getString("Precio_Lista"));
                numCilindrosCambios.setValue(rs.getString("Num_Cilindros"));
                cbNumPuertasCambios.setSelectedItem(rs.getInt("Num_Puertas"));
                cbColorCambios.setSelectedItem(rs.getString("Color"));
                cbPesoCambios.setSelectedItem(rs.getString("Peso"));
                capacidadCambios.setValue(rs.getString("Cap_Personas"));


                habilitarCamposEdicion(true);

            } else {

                JOptionPane.showMessageDialog(null, "No se encontró un vehículo con ese número.");
                habilitarCamposEdicion(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del vehiculo.");
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
            return -1;
        }
    }

    public void refrescarTabla(){
        vehiculoDAO.actualizarTabla(tablaVehiculosCambios);
    }

    public void actualizarDias() {
        int mes = cbMesCambios.getSelectedIndex();
        Object añoObj = cbAñoCambios.getSelectedItem();

        if (mes <= 0 || !(añoObj instanceof Integer)) {
            return;
        }

        int año = (int) añoObj;


        YearMonth yearMonth = YearMonth.of(año, mes);
        int diasEnMes = yearMonth.lengthOfMonth();

        cbDiaCambios.removeAllItems();
        for (int d = 1; d <= diasEnMes; d++) {
            cbDiaCambios.addItem(d);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente  = e.getSource();

        if (componente == btnBuscarCambios){

            if (cajaNumVehiculoCambios.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"Campo vacio, verifica campo 'Numero Vehiculo'");
            } else {

                obtenerDatosVehiculo();
            }





        } else if (componente == btnGuardarCambios) {

            try {
                if (cajaNumVehiculoCambios.getText().length() > 10){
                    JOptionPane.showMessageDialog(this,"Excediste el maximo valor del campo 'Numero Vehiculo', verifica los datos");
                    return;
                }
                if (cajaNumVehiculoCambios.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this,"Asegurate de llenar TODOS los campos correctamente!");
                    return;
                }
                if (cajaModeloCambios.getText().length() > 15){
                    JOptionPane.showMessageDialog(this,"Excediste el maximo valor del campo 'Modelo', verifica los datos");
                    return;
                }
                if (cajaModeloCambios.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this,"Asegurate de llenar el campo modelo");
                    return;
                }

                double precio = Double.parseDouble(cajaPrecioListaCambios.getText());
                if (precio < 0 || precio >= 1000000000) {
                    JOptionPane.showMessageDialog(this, "El precio debe menor a 1,000,000,000.");
                    return;
                }

                int cilindros = Integer.parseInt(numCilindrosCambios.getValue().toString());
                if (cilindros == 0){
                    JOptionPane.showMessageDialog(this, "El número de cilindros debe ser mayor que cero.");
                    return;
                }

                byte puertas =  Byte.parseByte(cbNumPuertasCambios.getSelectedItem().toString());
                if (puertas == 0){
                    JOptionPane.showMessageDialog(this, "Selecciona una cantidad válida de puertas.");
                    return;
                }

                if (cbPaisFabCambios.getSelectedItem().toString().equals("Elige un pais..")){
                    JOptionPane.showMessageDialog(this, "Selecciona un país válido.");
                    return;
                }

                if (cbPesoCambios.getSelectedItem().toString().equals("Elije peso..")){
                    JOptionPane.showMessageDialog(this, "Selecciona un peso del Vehiculo válido.");
                    return;
                }

                if (cbColorCambios.getSelectedItem().toString().equals("Elige color..")){
                    JOptionPane.showMessageDialog(this, "Selecciona un color válido.");
                    return;
                }

                int capacidad = Integer.parseInt(capacidadCambios.getValue().toString());
                if (capacidad == 0){
                    JOptionPane.showMessageDialog(this, "Selecciona una capacidad de personas valida.");
                    return;
                }

                String dia = cbDiaCambios.getSelectedItem().toString();
                String mes = cbMesCambios.getSelectedItem().toString();
                String año = cbAñoCambios.getSelectedItem().toString();

                int numMes = obtenerNumeroMes(mes);

                LocalDate fecha = LocalDate.of(Integer.parseInt(año), numMes, Integer.parseInt(dia));
                Date fechaSQL = java.sql.Date.valueOf(fecha);


                Vehiculo v = new Vehiculo(
                        cajaNumVehiculoCambios.getText(),
                        cajaModeloCambios.getText(),
                        cbPaisFabCambios.getSelectedItem().toString(),
                        fechaSQL,
                        cajaPrecioListaCambios.getText(),
                        numCilindrosCambios.getValue().toString(),
                        Byte.parseByte(cbNumPuertasCambios.getSelectedItem().toString()),
                        cbColorCambios.getSelectedItem().toString(),
                        cbPesoCambios.getSelectedItem().toString(),
                        capacidadCambios.getValue().toString());



                if (vehiculoDAO.editarVehiculo(v)){

                    JOptionPane.showMessageDialog(this,"Registro Editado CORRECTAMENTE");
                    vehiculoDAO.actualizarTabla(tablaVehiculosCambios);

                } else {
                    JOptionPane.showMessageDialog(this,"ERROR, al editar registro");
                }
            } catch (DateTimeException e1){
                JOptionPane.showMessageDialog(this,"Seleccionaste un valor equivocado en alguno de los campos de la FECHA, Verifica los datos");
            } catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(this,"Asegurate de llenar TODOS los campos correctamente!");
            }



        } else if (componente == btnRestablecerCambios) {
            habilitarCamposEdicion(false);
            if (cajaNumVehiculoCambios.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay datos para borrar");
            }
            limpiarVentana();
        } else if (componente == btnCancelarCambios) {

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
        } else if (componente == btnRegistrosCambios) {
            refrescarTabla();
            boolean visible = scrollTablaCambios.isVisible();
            scrollTablaCambios.setVisible(!visible);


            txtEstadoReg.setText(visible ? "↑ Mostrar Registros ↑" : "↑ Ocultar Registros ↑");


            scrollTablaCambios.getParent().revalidate();
            scrollTablaCambios.getParent().repaint();

        } else if (componente == btnInicio) {
            refrescarTabla();
            limpiarVentana();
            this.setVisible(false);
        }
    }
}
