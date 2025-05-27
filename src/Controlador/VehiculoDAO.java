package Controlador;

import ConexionBD.ConexionBD;
import Modelo.ResultSetTableModel;
import Modelo.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.ResultSet;
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


    public void actualizarTabla(JTable tabla) {

        JOptionPane loading = new JOptionPane("Consultando datos...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = loading.createDialog("Espere");
        dialog.setModal(false);
        dialog.setVisible(true);


        new Thread(() -> {
            final String CONTROLADOR_JDBC = conexionBD.getDriver();
            final String URL = conexionBD.getURL();
            final String CONSULTA = "SELECT * FROM vehiculos";

            try {

                Thread.sleep(2000); // 2 segundos

                ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);

                SwingUtilities.invokeLater(() -> {
                    tabla.setModel(modelo);
                    dialog.dispose(); // Oculta mensaje cuando termine

                    if (modelo.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros con ese valor.");
                        return;
                    }

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
                });

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                dialog.dispose();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                dialog.dispose();
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null, "Error al consultar la base de datos.")
                );
            }
        }).start();
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

    public boolean existeVehiculo(String numVehiculo) {
        String sql = "SELECT Num_Vehiculo FROM Vehiculos WHERE Num_Vehiculo = ?";
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql, numVehiculo);
        try {
            return rs != null && rs.next(); // Ya existe
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
