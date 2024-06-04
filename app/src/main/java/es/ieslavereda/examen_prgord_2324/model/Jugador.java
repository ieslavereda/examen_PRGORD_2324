package es.ieslavereda.examen_prgord_2324.model;

public class Jugador {
    private String nombre;
    private String apellidos;
    private double saldo;

    public Jugador(String nombre, String apellidos, double saldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getSaldo() {
        return saldo;
    }
}
