package es.ieslavereda.examen_prgord_2324.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bombo {
    private Set<Bola> bolas;

    public Bombo(){
        bolas=new LinkedHashSet<>();
    }

    public Set<Bola> getBolas() {
        return bolas;
    }

    public void setBolas(Set<Bola> bolas) {
        this.bolas = bolas;
    }

}
