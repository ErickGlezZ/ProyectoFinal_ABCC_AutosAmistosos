package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private static ConexionBD instanciaConexion;
    private Connection conexion;

    private final String URL = "jdbc:mysql://localhost:3306/BD_Autos_Amistosos";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "itsj";

    // Constructor privado
    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión establecida con éxito");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver JDBC");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión a MySQL");
        }
    }

    // Método para obtener la instancia única
    public static ConexionBD getInstancia() {
        if (instanciaConexion == null) {
            instanciaConexion = new ConexionBD();
        }
        return instanciaConexion;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    // Método para ejecutar instrucciones LMD (INSERT, UPDATE, DELETE) con PreparedStatement
    public boolean ejecutarInstruccionLMD(String sql, Object... datos) {
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            for (int i = 0; i < datos.length; i++) {
                pstmt.setObject(i + 1, datos[i]);
            }
            return pstmt.executeUpdate() >= 1;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la instrucción LMD");
            e.printStackTrace();
            return false;
        }
    }

    // Método para ejecutar consultas SELECT con PreparedStatement
    public ResultSet ejecutarConsultaSQL(String sql, Object... datos) {
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            for (int i = 0; i < datos.length; i++) {
                pstmt.setObject(i + 1, datos[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL");
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        ConexionBD conexion = ConexionBD.getInstancia();
    }
}

