package Ventanas;

import ConexionBD.ConexionBD;
import Controlador.VehiculoDAO;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VentanaBajas extends JInternalFrame implements ActionListener, KeyListener {

    JButton  btnEliminar, btnRestablecerBajas, btnCancelarBajas, btnBuscarBajas, btnInicio, btnRegistrosBajas;
    JTextField cajaNumVehiculoBajas, cajaModeloBajas, cajaPrecioListaBajas;
    JSpinner numCilindrosBajas, capacidadBajas;
    JComboBox<Integer> cbNumPuertasBajas, cbDiaBajas, cbAñoBajas;
    JComboBox<String> cbPaisFabBajas, cbMesBajas, cbColorBajas, cbPesoBajas;
    JScrollPane scrollTablaBajas;
    JTable tablaVehiculosBajas;

    ImageIcon logoIcon, inicioIcon, personalIcon, encargadoIcon, telefonoIcon, correoIcon, autoIcon, configIcon, registrosIcon;
    JLabel labelLogo, iconoPersonal, textoPersonal, iconoEncargado, textoEncargado, iconoTelefono, textoTelefono, iconoCorreo, textoCorreo, iconoAuto, textoAuto, iconoConfig, textoConfig, txtEstadoReg;


    ConexionBD conexionBD = ConexionBD.getInstancia();
    VehiculoDAO vehiculoDAO = VehiculoDAO.getInstancia();
    public VentanaBajas(){

        super("BAJAS", true, true, false, true);
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panelBajas = new JPanel();
        panelBajas.setLayout(null);
        panelBajas.setBackground(new Color(192,57,43));
        panelBajas.setBounds(0, 0, 770, 60);

        JPanel panelDerechoBajas = new JPanel();
        panelDerechoBajas.setBackground(new Color(60, 63, 65));
        panelDerechoBajas.setBounds(770, 0, 160, 700);
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
        btnInicio.addActionListener(this);


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
        btnRegistrosBajas.addActionListener(this);

        txtEstadoReg = new JLabel("Registros...");
        txtEstadoReg.setForeground(Color.WHITE);
        txtEstadoReg.setFont(new Font("Arial", Font.PLAIN, 12));
        agregarComponentePanel(panelDerechoBajas,txtEstadoReg, 15,550,145,25);

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

        String[] pesos = {
                "Elije peso..", "800 kg", "900 kg", "1000 kg",
                "1100 kg", "1200 kg", "1300 kg",
                "1400 kg", "1500 kg", "1600 kg",
                "1700 kg", "1800 kg", "1900 kg",
                "2000 kg", "2200 kg", "2400 kg",
                "2600 kg", "2800 kg", "3000 kg"
        };
        cbPesoBajas = new JComboBox<>(pesos);
        agregarAInternal(cbPesoBajas,135,333,120,25);

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

        scrollTablaBajas = new JScrollPane(tablaVehiculosBajas);
        scrollTablaBajas.setVisible(false);
        agregarAInternal(scrollTablaBajas,10, 410, 750, 150);

        btnBuscarBajas = new JButton("Buscar");
        btnBuscarBajas.setIcon(new ImageIcon(new ImageIcon("./img/search.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnBuscarBajas,320,68,140,30);
        btnBuscarBajas.addActionListener(this);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setIcon(new ImageIcon(new ImageIcon("./img/delete.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnEliminar,490, 120,140,30);
        btnEliminar.addActionListener(this);

        btnRestablecerBajas = new JButton("Restablecer");
        btnRestablecerBajas.setIcon(new ImageIcon(new ImageIcon("./img/rest.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnRestablecerBajas,490, 190,140,30);
        btnRestablecerBajas.addActionListener(this);

        btnCancelarBajas = new JButton("Cancelar");
        btnCancelarBajas.setIcon(new ImageIcon(new ImageIcon("./img/cancelar.png").getImage().getScaledInstance(32, 20, java.awt.Image.SCALE_SMOOTH)));
        agregarAInternal(btnCancelarBajas,490,260,140,30);
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
        cbPesoBajas.setEnabled(false);
        capacidadBajas.setEnabled(false);

        this.getContentPane().setBackground(new Color(40,44,52));
        vehiculoDAO.actualizarTabla(tablaVehiculosBajas);

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



    public void obtenerDatosVehiculo() {
        vehiculoDAO.actualizarTabla(tablaVehiculosBajas);
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
                    cbPesoBajas.setSelectedItem(rs.getString("Peso"));
                    capacidadBajas.setValue(rs.getString("Cap_Personas"));


            } else {

                JOptionPane.showMessageDialog(null, "No se encontró un vehículo con ese número.");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del vehiculo.");
        }
    }

    public void refrescarTabla(){
        vehiculoDAO.actualizarTabla(tablaVehiculosBajas);
    }

    public void limpiarVentana() {

        cajaNumVehiculoBajas.setText("");
        cajaModeloBajas.setText("");
        cbPesoBajas.setSelectedIndex(0);
        cajaPrecioListaBajas.setText("");
        numCilindrosBajas.setValue("0");
        capacidadBajas.setValue("0");
        cbNumPuertasBajas.setSelectedIndex(0);
        cbDiaBajas.setSelectedIndex(0);
        cbAñoBajas.setSelectedIndex(0);
        cbPaisFabBajas.setSelectedIndex(0);
        cbMesBajas.setSelectedIndex(0);
        cbColorBajas.setSelectedIndex(0);

    }

        @Override
    public void actionPerformed(ActionEvent e) {
        
        Object componente = e.getSource();
        
        if (componente == btnBuscarBajas){

            if (cajaNumVehiculoBajas.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"Campo vacio, verifica el campo 'Numero Vehiculo'");
            }
            try {
                obtenerDatosVehiculo();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this,"Campo vacio, verifica los datos");
            }


        } else if (componente == btnEliminar) {

            if (vehiculoDAO.eliminarVehiculo(cajaNumVehiculoBajas.getText())){

                vehiculoDAO.actualizarTabla(tablaVehiculosBajas);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            }else {
                JOptionPane.showMessageDialog(this, "ERROR al eliminar el registro");
            }

        } else if (componente == btnRestablecerBajas) {

            if (cajaNumVehiculoBajas.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay datos para borrar");
            }
            limpiarVentana();
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
        } else if (componente == btnRegistrosBajas) {
            refrescarTabla();
            boolean visible = scrollTablaBajas.isVisible();
            scrollTablaBajas.setVisible(!visible);


            txtEstadoReg.setText(visible ? "↑ Mostrar Registros ↑" : "↑ Ocultar Registros ↑");


            scrollTablaBajas.getParent().revalidate();
            scrollTablaBajas.getParent().repaint();
        } else if (componente == btnInicio) {
            refrescarTabla();
            limpiarVentana();
            this.setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        int valorCaracter = (int) c;

        Object componente = e.getSource();

        if (componente == cajaNumVehiculoBajas) {

            if (valorCaracter == KeyEvent.VK_BACK_SPACE || valorCaracter == KeyEvent.VK_DELETE){
                return;
            }
            if (valorCaracter < 48 || valorCaracter > 57){
                e.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Solo debes ingresar Numeros!");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
