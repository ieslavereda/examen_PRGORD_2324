package es.ieslavereda.examen_prgord_2324.model;

import java.util.Comparator;

public class Bandeja implements Comparable<Bandeja>{

    public static final Comparator<Bandeja> SORT_POSITION =
            Comparator.comparingInt(o -> o.posicion);
    private Bola bola;
    private int posicion;

    public Bandeja(Bola bola, int posicion) {
        this.bola = bola;
        this.posicion = posicion;
    }

    @Override
    public int compareTo(Bandeja o) {
        return bola.getNumero()-o.getBola().getNumero();
    }

    public Bola getBola() {
        return bola;
    }

    public int getPosicion() {
        return posicion;
    }
}
