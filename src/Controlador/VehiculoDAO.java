package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Vehiculo;

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
}
