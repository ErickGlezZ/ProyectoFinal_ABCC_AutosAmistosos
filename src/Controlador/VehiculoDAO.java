package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Vehiculo;

public class VehiculoDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    //================ALTAS==================
    public boolean agregarVehiculo(Vehiculo vehiculo){
        String sql = "INSERT INTO vehiculo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return conexionBD.ejecutarInstruccionLMD(sql,vehiculo.getNumVehiculo(),
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
}
