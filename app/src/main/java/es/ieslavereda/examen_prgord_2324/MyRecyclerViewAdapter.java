package es.ieslavereda.examen_prgord_2324;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.ieslavereda.examen_prgord_2324.model.Bola;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Bola> bolas;
    private List<Bola> aux;

    public MyRecyclerViewAdapter(@NonNull Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.bolas=new ArrayList<>();
        this.aux=new ArrayList<>();
    }

    public void add(Bola bola){
        bolas.add(bola);
        aux.add(bola);
        notifyItemInserted(bolas.size()-1);
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.numeroBolaSacadaRV.setText(String.valueOf(position+1));
        holder.bolaSacadaRV.setBackground(context.getDrawable(aux.get(position).getColor()));
        holder.bolaSacadaRV.setText(String.valueOf(aux.get(position).getNumero()));
    }

    @Override
    public int getItemCount() {
        return bolas.size();
    }

    public void sortPosition(){
        aux.clear();
        aux.addAll(bolas);
        notifyDataSetChanged();
    }

    public void sortColor(){
        Collections.sort(aux);
        notifyDataSetChanged();
    }

    public void sortNumber(){
        aux.sort(Bola.SORT_NUMBER);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView numeroBolaSacadaRV;
        private TextView bolaSacadaRV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bolaSacadaRV = itemView.findViewById(R.id.bolaSacadaRV);
            numeroBolaSacadaRV = itemView.findViewById(R.id.numeroBolaSacadaRV);
        }
    }
}

