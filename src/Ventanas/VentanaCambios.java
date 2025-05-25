package Ventanas;

import ConexionBD.ConexionBD;
import Controlador.VehiculoDAO;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VentanaCambios extends JInternalFrame implements ActionListener {

    JButton btnBuscarCambios, btnRestablecerCambios, btnGuardarCambios, btnCancelarCambios, btnRegistrosCambios, btnInicio;
    JTextField  cajaNumVehiculoCambios, cajaModeloCambios, cajaPesoCambios, cajaPrecioListaCambios;
    JSpinner numCilindrosCambios, capacidadCambios;
    JComboBox<Integer> cbNumPuertasCambios, cbDiaCambios, cbAñoCambios;
    JComboBox<String> cbPaisFabCambios, cbMesCambios, cbColorCambios;
    JTable  tablaVehiculosCambios;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;


    ConexionBD conexionBD = ConexionBD.getInstancia();
    VehiculoDAO vehiculoDAO = VehiculoDAO.getInstancia();
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

        cajaPesoCambios = new JTextField();
        agregarAInternal(cajaPesoCambios,135,333,150,25);

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



        cajaModeloCambios.setEnabled(false);
        cbPaisFabCambios.setEnabled(false);
        cbDiaCambios.setEnabled(false);
        cbMesCambios.setEnabled(false);
        cbAñoCambios.setEnabled(false);
        cajaPrecioListaCambios.setEnabled(false);
        numCilindrosCambios.setEnabled(false);
        cbNumPuertasCambios.setEnabled(false);
        cbColorCambios.setEnabled(false);
        cajaPesoCambios.setEnabled(false);
        capacidadCambios.setEnabled(false);



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


    public void restablecerComponentes(JComponent ... componentes ) {

        for (JComponent  c : componentes){
            //System.out.println(c);
            if(c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
            else if(c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            }
            else if(c instanceof JPasswordField) {
                ((JPasswordField) c).setText("");
            }
            else if(c instanceof JSpinner) {
                ((JSpinner) c).setValue("0");
            }
            else if(c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(true);
            }
            else if(c instanceof JCheckBox) {
                ((JCheckBox) c).setSelected(false);
            }
        }

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
                cajaPesoCambios.setText(rs.getString("Peso"));
                capacidadCambios.setValue(rs.getString("Cap_Personas"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del vehiculo.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente  = e.getSource();

        if (componente == btnBuscarCambios){

            try{
                cajaModeloCambios.setEnabled(true);
                cbPaisFabCambios.setEnabled(true);
                cbDiaCambios.setEnabled(true);
                cbMesCambios.setEnabled(true);
                cbAñoCambios.setEnabled(true);
                cajaPrecioListaCambios.setEnabled(true);
                numCilindrosCambios.setEnabled(true);
                cbNumPuertasCambios.setEnabled(true);
                cbColorCambios.setEnabled(true);
                cajaPesoCambios.setEnabled(true);
                capacidadCambios.setEnabled(true);

                obtenerDatosVehiculo();

            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this,"Campo vacio, verifica los datos");
            }
        } else if (componente == btnGuardarCambios) {


        } else if (componente == btnRestablecerCambios) {

            if (cajaNumVehiculoCambios.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay datos para borrar");
            }
        }
    }
}
