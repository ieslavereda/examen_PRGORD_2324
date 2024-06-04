package es.ieslavereda.examen_prgord_2324.model;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


import es.ieslavereda.examen_prgord_2324.R;

public class Carton extends LinearLayout {
    private Map<Integer, Boolean> numeroEnCartones;
    private Map<Integer,TextView> views;

    public Carton(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        inicialize(context);
    }

    public Carton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        inicialize(context);
    }

    public Carton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
        inicialize(context);
    }

    public Carton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOrientation(LinearLayout.HORIZONTAL);
        inicialize(context);
    }

    private void inicialize(Context context) {
        numeroEnCartones = new TreeMap<>();
        views = new HashMap<>();

        while (numeroEnCartones.size() < 10) {
            numeroEnCartones.put((int) (Math.random() * 90) + 1, false);
        }

        int i=0;
        for (Integer numero : numeroEnCartones.keySet()) {
            TextView textView = new TextView(context);
            textView.setText("|"+numero);
            textView.setGravity(TEXT_ALIGNMENT_CENTER);
            textView.setBackground((++i%2==0)?context.getDrawable(R.color.blue):context.getDrawable(R.color.yellow));
            textView.setTextSize(10);
            views.put(numero,textView);
            addView(textView);
        }
    }

    public boolean check(int numero){
        if(numeroEnCartones.keySet().contains(numero)){
            numeroEnCartones.put(numero,true);
            views.get(numero).setBackground(getContext().getDrawable(R.color.orange));
            return checkWin();
        }
        return false;
    }

    private boolean checkWin(){

        Optional<Boolean> trobat = numeroEnCartones.values().stream().filter(b -> !b).findFirst();
        if(trobat.isPresent())
            return false;
        return true;
    }


}
