package es.ieslavereda.examen_prgord_2324;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.examen_prgord_2324.model.Bola;
import es.ieslavereda.examen_prgord_2324.model.BomboBingo;
import es.ieslavereda.examen_prgord_2324.model.Carton;
import es.ieslavereda.examen_prgord_2324.model.JugadorBingo;

public class MainActivity extends AppCompatActivity {

    private List<JugadorBingo> jugadores;
    private BomboBingo bomboBingo;
    private Bola bolaBombo;
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
        RadioButton sortPosition = findViewById(R.id.sortPosition);
        RadioButton sortColor = findViewById(R.id.sortColor);
        RadioButton sortNumber = findViewById(R.id.sortNumber);


        jugadores = new ArrayList<>();
        Carton carton1 = findViewById(R.id.carton1);
        jugadores.add(new JugadorBingo("Joaquín", "Alonso", 10, new ArrayList<>(List.of(carton1))));
        Carton carton2 = findViewById(R.id.carton2);
        jugadores.add(new JugadorBingo("Javier", "García", 10, new ArrayList<>(List.of(carton2))));
        Carton carton3 = findViewById(R.id.carton3);
        jugadores.add(new JugadorBingo("José Miguel", "Fajardo", 10, new ArrayList<>(List.of(carton3))));
        Carton carton4 = findViewById(R.id.carton4);
        jugadores.add(new JugadorBingo("Xavier", "Rosillo", 10, new ArrayList<>(List.of(carton4))));

        jugador1.setText(jugadores.get(0).getNombre() + " " + jugadores.get(0).getApellidos());
        jugador2.setText(jugadores.get(1).getNombre() + " " + jugadores.get(1).getApellidos());
        jugador3.setText(jugadores.get(2).getNombre() + " " + jugadores.get(2).getApellidos());
        jugador4.setText(jugadores.get(3).getNombre() + " " + jugadores.get(3).getApellidos());


        bomboBingo = new BomboBingo();

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        bolaSacada.setOnClickListener(v -> {
            bolaBombo = bomboBingo.sacarBola();
            if (bolaBombo == null)
                Toast.makeText(this, "NO HAY MÁS BOLAS EN EL BOMBO", Toast.LENGTH_LONG).show();
            else {
                bolaSacada.setText(String.valueOf(bolaBombo.getNumero()));
                bolaSacada.setBackground(getDrawable(bolaBombo.getColor()));
                adapter.add(bolaBombo);
                checkPlayer(bolaBombo.getNumero());
            }
        });

        sortPosition.setOnClickListener(v -> adapter.sortPosition());
        sortNumber.setOnClickListener(v -> adapter.sortNumber());
        sortColor.setOnClickListener(v -> adapter.sortColor());

    }

    private void checkPlayer(int numero) {
        for (JugadorBingo jugador : jugadores) {
            for (Carton carton : jugador.getCartones()) {
                if (carton.check(numero)) {
                    bolaSacada.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "GANADOR: " + jugador.getNombre() + " " + jugador.getApellidos(), Toast.LENGTH_LONG).show();
                }
                ;
            }
        }
    }

}