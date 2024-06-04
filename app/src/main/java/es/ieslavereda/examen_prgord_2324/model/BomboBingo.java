package es.ieslavereda.examen_prgord_2324.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import es.ieslavereda.examen_prgord_2324.R;

public class BomboBingo extends Bombo{

    public BomboBingo() {
        Set<Bola> bolas = new HashSet<>();
        for (int i = 1; i <= 90; i++) {
            bolas.add(new Bola(i,((i%2==0)?R.color.green:R.color.red)));
        }
        setBolas(bolas);
    }

    public Bola sacarBola(){
        List<Bola> listaBolas = getBolas().stream().collect(Collectors.toList());
        if(getBolas().size()%5==0)
            Collections.shuffle(listaBolas);
        Bola bola = listaBolas.remove(0);
        setBolas(new LinkedHashSet<>(listaBolas));

        return bola;
    }

}
