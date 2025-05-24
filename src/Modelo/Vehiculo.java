package Modelo;

import java.util.Date;

public class Vehiculo {

    private String numVehiculo;
    private String modelo;
    private String paisFab;
    private Date fechaFab;
    private String precioLista;
    private String numCilindros;
    private byte numPuertas;
    private String color;
    private String peso;
    private String capacidadPersonas;

    public Vehiculo(String numVehiculo, String modelo, String paisFab, Date fechaFab, String precioLista, String numCilindros, byte numPuertas, String color, String peso, String capacidadPersonas){
        this.numVehiculo = numVehiculo;
        this.modelo = modelo;
        this.paisFab = paisFab;
        this.fechaFab = fechaFab;
        this.precioLista = precioLista;
        this.numCilindros = numCilindros;
        this.numPuertas = numPuertas;
        this.color = color;
        this.peso = peso;
        this.capacidadPersonas = capacidadPersonas;
    }

    public String getNumVehiculo() {
        return numVehiculo;
    }

    public void setNumVehiculo(String numVehiculo) {
        this.numVehiculo = numVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPaisFab() {
        return paisFab;
    }

    public void setPaisFab(String paisFab) {
        this.paisFab = paisFab;
    }

    public Date getFechaFab() {
        return fechaFab;
    }

    public void setFechaFab(Date fechaFab) {
        this.fechaFab = fechaFab;
    }

    public String getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(String precioLista) {
        this.precioLista = precioLista;
    }

    public String getNumCilindros() {
        return numCilindros;
    }

    public void setNumCilindros(String numCilindros) {
        this.numCilindros = numCilindros;
    }

    public byte getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(byte numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(String capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "numVehiculo='" + numVehiculo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", paisFab='" + paisFab + '\'' +
                ", fechaFab='" + fechaFab + '\'' +
                ", precioLista='" + precioLista + '\'' +
                ", numCilindros=" + numCilindros +
                ", numPuertas=" + numPuertas +
                ", color='" + color + '\'' +
                ", peso='" + peso + '\'' +
                ", capacidadPersonas=" + capacidadPersonas +
                '}';
    }
}
