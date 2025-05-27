package Controlador;

import ConexionBD.ConexionBD;
import Modelo.ResultSetTableModel;
import Modelo.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VehiculoDAO {

    private static VehiculoDAO instancia;

    // Instancia única de conexión
    private ConexionBD conexionBD;

    // Constructor privado
    private VehiculoDAO() {
        conexionBD = ConexionBD.getInstancia();
    }

    // Método público para obtener la instancia única
    public static VehiculoDAO getInstancia() {
        if (instancia == null) {
            instancia = new VehiculoDAO();
        }
        return instancia;
    }


    public void actualizarTabla(JTable tabla){
        final String CONTROLADOR_JDBC = conexionBD.getDriver();
        final String URL = conexionBD.getURL();
        final String CONSULTA = "SELECT * FROM vehiculos";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);
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

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //================ALTAS==================
    public boolean agregarVehiculo(Vehiculo vehiculo){
        String sql = "INSERT INTO Vehiculos (Num_Vehiculo, Modelo, Pais_Fab, Fecha_Fab, Precio_Lista, Num_Cilindros, Num_Puertas, Color, Peso, Cap_Personas) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return conexionBD.ejecutarInstruccionLMD(sql,
                vehiculo.getNumVehiculo(),
                vehiculo.getModelo(),
                vehiculo.getPaisFab(),
                vehiculo.getFechaFab(),
                vehiculo.getPrecioLista(),
                vehiculo.getNumCilindros(),
                vehiculo.getNumPuertas(),
                vehiculo.getColor(),
                vehiculo.getPeso(),
                vehiculo.getCapacidadPersonas());
    }

    //===================BAJAS=====================
    public boolean eliminarVehiculo(String numVehiculo){
        String sql = "DELETE FROM Vehiculos WHERE Num_Vehiculo = ?";
        return  conexionBD.ejecutarInstruccionLMD(sql,numVehiculo);

    }

    //==================CAMBIOS=====================
    public boolean editarVehiculo(Vehiculo vehiculo){
        String sql = "UPDATE Vehiculos SET Modelo = ?, Pais_Fab = ?, Fecha_Fab = ?, Precio_Lista = ?, Num_Cilindros = ?, Num_Puertas = ?, Color = ?, Peso = ?, Cap_Personas = ? WHERE Num_Vehiculo = ?";

        return conexionBD.ejecutarInstruccionLMD(sql,

                vehiculo.getModelo(),
                vehiculo.getPaisFab(),
                vehiculo.getFechaFab(),
                vehiculo.getPrecioLista(),
                vehiculo.getNumCilindros(),
                vehiculo.getNumPuertas(),
                vehiculo.getColor(),
                vehiculo.getPeso(),
                vehiculo.getCapacidadPersonas(),
                vehiculo.getNumVehiculo());
    }

    //================CONSULTAS=====================

    public ResultSetTableModel obtenerVehiculosFiltrados(String campo, Object valor) {
        String consulta = "SELECT * FROM Vehiculos WHERE " + campo + " = ?";
        try {

            return new ResultSetTableModel(
                    conexionBD.getDriver(),
                    conexionBD.getURL(),
                    consulta,
                    valor
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al obtener vehiculos filtrados", e);
        }
    }

    public ResultSetTableModel obtenerVehiculos() {
        String consulta = "SELECT * FROM Vehiculos";
        try {
            return new ResultSetTableModel(
                    conexionBD.getDriver(),
                    conexionBD.getURL(),
                    consulta
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al obtener vehiculos", e);
        }
    }


}
