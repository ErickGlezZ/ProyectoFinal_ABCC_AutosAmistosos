package Modelo;

public class Vehiculo {

    private String numVehiculo;
    private String modelo;
    private String paisFab;
    private String fechaFab;
    private String precioLista;
    private byte numCilindros;
    private byte numPuertas;
    private String color;
    private String peso;
    private byte capacidadPersonas;

    public Vehiculo(String numVehiculo, String modelo, String paisFab, String fechaFab, String precioLista, byte numCilindros, byte numPuertas, String color, String peso, byte capacidadPersonas){
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

    public String getFechaFab() {
        return fechaFab;
    }

    public void setFechaFab(String fechaFab) {
        this.fechaFab = fechaFab;
    }

    public String getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(String precioLista) {
        this.precioLista = precioLista;
    }

    public byte getNumCilindros() {
        return numCilindros;
    }

    public void setNumCilindros(byte numCilindros) {
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

    public byte getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(byte capacidadPersonas) {
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
