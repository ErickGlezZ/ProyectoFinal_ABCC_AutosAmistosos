package VentanaLogin;

import Vista.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField cajaUsuario;
    JPasswordField cajaContraseña;
    JButton btnLogin;

    public Login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pantalla Login");
        setSize(550, 550);
        setLocationRelativeTo(null);


        JPanel panelFondo = new JPanel() {
            ImageIcon fondo = new ImageIcon("img/fondoVentana.png");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(null);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(0, 0, 0, 150));
        agregarComponente(panelFondo, panelTitulo,0,0,500,60);

        JLabel txtTitulo = new JLabel("Distribuidor Autos Amistosos!", JLabel.CENTER);
        txtTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        txtTitulo.setForeground(Color.ORANGE);
        panelTitulo.add(txtTitulo, BorderLayout.CENTER);


        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(null);
        panelContenedor.setBackground(new Color(0, 0, 0, 150));
        agregarComponente(panelFondo,panelContenedor,100, 100, 300, 220);


        JLabel txtUsuario = new JLabel("Usuario:");
        txtUsuario.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtUsuario.setForeground(Color.WHITE);
        agregarComponente(panelContenedor,txtUsuario,30, 20, 100, 30);

        cajaUsuario = new JTextField();
        agregarComponente(panelContenedor,cajaUsuario,30, 55, 240, 30);


        JLabel txtContraseña = new JLabel("Contraseña:");
        txtContraseña.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtContraseña.setForeground(Color.WHITE);
        agregarComponente(panelContenedor,txtContraseña,30, 95, 130, 30);

        cajaContraseña = new JPasswordField();
        agregarComponente(panelContenedor,cajaContraseña,30, 130, 240, 30);


        btnLogin = new JButton("Ingresar");
        agregarComponente(panelContenedor,btnLogin,90, 175, 120, 30);
        btnLogin.addActionListener(this);


        setContentPane(panelFondo);
        setVisible(true);
    }

    public void agregarComponente(JPanel panel, JComponent componente, int x, int y, int w, int h) {
        componente.setBounds(x, y, w, h);
        panel.add(componente);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Login();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();
        if (componente == btnLogin){
            String usuario = cajaUsuario.getText();
            String password = new String(cajaContraseña.getPassword());

            if (usuario.equals("No al dejavu") && password.equals("autos12345")){
                JOptionPane.showMessageDialog(this,"¡Bienvenido!");

                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new VentanaPrincipal(Login.this);
                    }
                });
                cajaUsuario.setText("");
                cajaContraseña.setText("");
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos DEJAVU!!");
            }
        }

    }
}

