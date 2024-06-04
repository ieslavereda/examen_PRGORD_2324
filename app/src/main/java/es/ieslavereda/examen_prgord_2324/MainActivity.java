package es.ieslavereda.examen_prgord_2324;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.ieslavereda.examen_prgord_2324.model.Bandeja;
import es.ieslavereda.examen_prgord_2324.model.Bola;
import es.ieslavereda.examen_prgord_2324.model.BomboBingo;
import es.ieslavereda.examen_prgord_2324.model.Carton;
import es.ieslavereda.examen_prgord_2324.model.Jugador;
import es.ieslavereda.examen_prgord_2324.model.JugadorBingo;

public class MainActivity extends AppCompatActivity {

    private List<Bandeja> bandejaBolas;
    private List<JugadorBingo> jugadores;
    private BomboBingo bomboBingo;
    private List<Bola> bolasDelBombo;
    private Integer posicion;

    private boolean hayBolas;
    TextView bolaSacada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bolaSacada = findViewById(R.id.bolaSacada);
        RecyclerView recycler = findViewById(R.id.recycler);
        TextView jugador1 = findViewById(R.id.jugador1);
        TextView jugador2 = findViewById(R.id.jugador2);
        TextView jugador3 = findViewById(R.id.jugador3);
        TextView jugador4 = findViewById(R.id.jugador4);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        bandejaBolas = new ArrayList<>();
        posicion=0;
        jugadores = new ArrayList<>();
        Carton carton1 = findViewById(R.id.carton1);
        jugadores.add(new JugadorBingo("Joaquín","Alonso",10,new ArrayList<>(List.of(carton1))));
        Carton carton2 = findViewById(R.id.carton2);
        jugadores.add(new JugadorBingo("Javier","García",10,new ArrayList<>(List.of(carton2))));
        Carton carton3 = findViewById(R.id.carton3);
        jugadores.add(new JugadorBingo("José Miguel","Fajardo",10,new ArrayList<>(List.of(carton3))));
        Carton carton4 = findViewById(R.id.carton4);
        jugadores.add(new JugadorBingo("Xavier","Rosillo",10,new ArrayList<>(List.of(carton4))));

        jugador1.setText(jugadores.get(0).getNombre() + " " + jugadores.get(0).getApellidos());
        jugador2.setText(jugadores.get(1).getNombre() + " " + jugadores.get(1).getApellidos());
        jugador3.setText(jugadores.get(2).getNombre() + " " + jugadores.get(2).getApellidos());
        jugador4.setText(jugadores.get(3).getNombre() + " " + jugadores.get(3).getApellidos());


        bomboBingo = new BomboBingo();
        bolasDelBombo = bomboBingo.girarBombo();
        hayBolas=true;

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, bandejaBolas);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        bolaSacada.setOnClickListener(v -> {
            if(!hayBolas)
                Toast.makeText(this,"NO HAY MÁS BOLAS EN EL BOMBO",Toast.LENGTH_LONG).show();
            else {
                if (bolasDelBombo.size()==0) {
                    bolasDelBombo = bomboBingo.girarBombo();
                    if (bolasDelBombo==null)
                        hayBolas = false;
                }
                if(hayBolas){
                    Bola bola = bolasDelBombo.remove(0);
                    bolaSacada.setText(String.valueOf(bola.getNumero()));
                    bolaSacada.setBackground(getDrawable(bola.getColor()));
                    bandejaBolas.add(new Bandeja(bola,++posicion));
                    adapter.notifyItemInserted(bandejaBolas.size()-1);
                    checkPlayer(bola.getNumero());
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.sortTime){
                    bandejaBolas.sort(Bandeja.SORT_POSITION);
                } else {
                    Collections.sort(bandejaBolas);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void checkPlayer(int numero){
        for(JugadorBingo jugador:jugadores){
            for (Carton carton:jugador.getCartones()){
                if(carton.check(numero)){
                    bolaSacada.setVisibility(View.INVISIBLE);
                    Toast.makeText(this,"GANADOR: " + jugador.getNombre()+ " "+jugador.getApellidos(),Toast.LENGTH_LONG).show();
                };
            }
        }
    }

}