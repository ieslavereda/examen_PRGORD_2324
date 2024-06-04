package es.ieslavereda.examen_prgord_2324.model;

public class Bola{
    private int numero;
    private int color;

    public Bola(int numero, int color) {
        this.numero = numero;
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bola bola = (Bola) o;
        return numero == bola.numero;
    }

    @Override
    public int hashCode() {
        return numero;
    }
}
