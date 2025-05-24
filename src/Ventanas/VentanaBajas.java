package Ventanas;

import ConexionBD.ConexionBD;
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

public class VentanaBajas extends JInternalFrame implements ActionListener {

    JButton  btnEliminar, btnRestablecerBajas, btnCancelarBajas, btnBuscarBajas, btnInicio, btnRegistrosBajas;
    JTextField cajaNumVehiculoBajas, cajaModeloBajas, cajaPesoBajas, cajaPrecioListaBajas;
    JSpinner numCilindrosBajas, capacidadBajas;
    JComboBox<Integer> cbNumPuertasBajas, cbDiaBajas, cbAñoBajas;
    JComboBox<String> cbPaisFabBajas, cbMesBajas, cbColorBajas;
    JTable tablaVehiculosBajas;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig;


    ConexionBD conexionBD = ConexionBD.getInstancia();
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

        cajaNumVehiculoBajas = new JTextField();
        agregarAInternal(cajaNumVehiculoBajas,135, 68,100,30);

        JSeparator separadorBajas = new JSeparator();
        separadorBajas.setForeground(Color.GRAY);
        agregarAInternal(separadorBajas, 10, 105, 640, 2);

        JLabel txtModeloBajas = new JLabel("Modelo:");
        agregarAInternal(txtModeloBajas,10,113,120,20);

        cajaModeloBajas = new JTextField();
        agregarAInternal(cajaModeloBajas,135,113,100,25);

        JLabel txtPaisFabBajas = new JLabel("Pais de Fabricacion");
        agregarAInternal(txtPaisFabBajas,10,150,120,20);

        String[] paisesFabricantesBajas = {
                "Elige pais..","Alemania", "Argentina", "Australia", "Austria", "Bélgica",
                "Brasil", "Canadá", "China", "Corea del Sur", "Chequia",
                "Eslovaquia", "España", "Estados Unidos", "Francia", "Finlandia",
                "Hungría", "India", "Indonesia", "Irán", "Italia",
                "Japón", "Malasia", "México", "Países Bajos", "Polonia",
                "Portugal", "Reino Unido", "Rusia", "Rumania", "Serbia",
                "Sudáfrica", "Suecia", "Suiza", "Tailandia", "Taiwán",
                "Túnez", "Turquía", "Ucrania", "Uzbekistán", "Vietnam"
        };

        cbPaisFabBajas = new JComboBox<>(paisesFabricantesBajas);
        cbPaisFabBajas.setEditable(false);
        agregarAInternal(cbPaisFabBajas,135,148,120,25);

        JLabel txtFechaFabBajas = new JLabel("Fecha de Fabricación:");
        agregarAInternal(txtFechaFabBajas, 10, 180, 150, 20);


        cbDiaBajas = new JComboBox<>();
        for (int d = 0; d <= 31; d++) cbDiaBajas.addItem(d);
        agregarAInternal(cbDiaBajas, 160, 180, 50, 25);


        String[] mesesBajas = {
                "Elige mes..","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        cbMesBajas = new JComboBox<>(mesesBajas);
        agregarAInternal(cbMesBajas, 215, 180, 100, 25);


        cbAñoBajas = new JComboBox<>();
        cbAñoBajas.addItem(0);
        for (int a = 1900; a <= 2025; a++) {
            cbAñoBajas.addItem(a);
        }
        agregarAInternal(cbAñoBajas, 320, 180, 80, 25);


        JLabel txtPrecioListaBajas = new JLabel("Precio de Lista:");
        agregarAInternal(txtPrecioListaBajas, 10, 210, 120, 20);

        cajaPrecioListaBajas = new JTextField();
        agregarAInternal(cajaPrecioListaBajas, 135, 213, 150, 25);


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

        cbNumPuertasBajas = new JComboBox<>(new Integer[]{0, 2, 3, 4, 5});
        agregarAInternal(cbNumPuertasBajas, 160, 273, 50, 25);

        JLabel txtPesoBajas = new JLabel("Peso:");
        agregarAInternal(txtPesoBajas,10,330,80,20);

        cajaPesoBajas = new JTextField();
        agregarAInternal(cajaPesoBajas,135,333,150,25);

        JLabel txtColorBajas = new JLabel("Color:");
        agregarAInternal(txtColorBajas, 10, 300, 120, 20);

        String[] coloresAutoBajas = {
                "Elije color..", "Negro", "Blanco", "Gris", "Plateado", "Rojo", "Azul",
                "Verde", "Amarillo", "Naranja", "Café", "Dorado", "Beige",
                "Vino", "Azul Marino", "Gris Oxford"
        };

        cbColorBajas = new JComboBox<>(coloresAutoBajas);
        agregarAInternal(cbColorBajas, 135, 303, 120, 25);


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
        btnBuscarBajas.addActionListener(this);

        btnEliminar = new JButton("Eliminar");
        agregarAInternal(btnEliminar,490, 120,110,30);
        btnEliminar.addActionListener(this);

        btnRestablecerBajas = new JButton("Restablecer");
        agregarAInternal(btnRestablecerBajas,490, 190,110,30);
        btnRestablecerBajas.addActionListener(this);

        btnCancelarBajas = new JButton("Cancelar");
        agregarAInternal(btnCancelarBajas,490,260,110,30);
        btnCancelarBajas.addActionListener(this);

        cajaModeloBajas.setEnabled(false);
        cbPaisFabBajas.setEnabled(false);
        cbDiaBajas.setEnabled(false);
        cbMesBajas.setEnabled(false);
        cbAñoBajas.setEnabled(false);
        cajaPrecioListaBajas.setEnabled(false);
        numCilindrosBajas.setEnabled(false);
        cbNumPuertasBajas.setEnabled(false);
        cbColorBajas.setEnabled(false);
        cajaPesoBajas.setEnabled(false);
        capacidadBajas.setEnabled(false);


        actualizarTabla(tablaVehiculosBajas);
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

        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql, cajaNumVehiculoBajas.getText());

        try {
            if (rs != null && rs.next()) {
                cajaModeloBajas.setText(rs.getString("Modelo"));
                cbPaisFabBajas.setSelectedItem(rs.getString("Pais_Fab"));


                Date fechaSql = rs.getDate("Fecha_Fab");
                if (fechaSql != null) {
                    LocalDate localDate = ((java.sql.Date) fechaSql).toLocalDate();
                    cbAñoBajas.setSelectedItem(localDate.getYear());
                    cbMesBajas.setSelectedIndex(localDate.getMonthValue());
                    cbDiaBajas.setSelectedItem(localDate.getDayOfMonth());

                }
                    cajaPrecioListaBajas.setText(rs.getString("Precio_Lista"));
                    numCilindrosBajas.setValue(rs.getString("Num_Cilindros"));
                    cbNumPuertasBajas.setSelectedItem(rs.getInt("Num_Puertas"));
                    cbColorBajas.setSelectedItem(rs.getString("Color"));
                    cajaPesoBajas.setText(rs.getString("Peso"));
                    capacidadBajas.setValue(rs.getString("Cap_Personas"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del vehiculo.");
        }
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        
        Object componente = e.getSource();
        
        if (componente == btnBuscarBajas){
            obtenerDatosVehiculo();

        } else if (componente == btnEliminar) {
            
        } else if (componente == btnRestablecerBajas) {
            restablecerComponentes(cajaNumVehiculoBajas,cajaModeloBajas,cbPaisFabBajas,cbDiaBajas,cbMesBajas,cbAñoBajas,cajaPrecioListaBajas,numCilindrosBajas,cbNumPuertasBajas,cbColorBajas,cajaPesoBajas,capacidadBajas);

        } else if (componente == btnCancelarBajas) {
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
        }
        }
}
