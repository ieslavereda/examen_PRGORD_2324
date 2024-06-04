package es.ieslavereda.examen_prgord_2324.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

    public List<Bola> girarBombo(){
        List<Bola> retorno = new ArrayList<>();
        List listaBolas = getBolas().stream().collect(Collectors.toList());
        Collections.shuffle(listaBolas);

        if(listaBolas.size()<5)
            return null;

        for (int i = 0; i < 5; i++) {
               retorno.add((Bola) listaBolas.remove(0));
        }

        setBolas(new HashSet<>(listaBolas));
        return retorno;
    }

}
