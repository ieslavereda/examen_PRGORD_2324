package es.ieslavereda.examen_prgord_2324.model;

import java.util.List;

public class JugadorBingo extends Jugador{

    private List<Carton> cartones;

    public JugadorBingo(String nombre, String apellidos, double saldo, List<Carton> cartones) {
        super(nombre, apellidos, saldo);
        this.cartones = cartones;
    }

    public List<Carton> getCartones() {
        return cartones;
    }
}
