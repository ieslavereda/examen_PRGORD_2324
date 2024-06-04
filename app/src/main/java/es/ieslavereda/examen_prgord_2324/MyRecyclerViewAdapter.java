package es.ieslavereda.examen_prgord_2324;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.examen_prgord_2324.model.Bandeja;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Bandeja> bolas;

    public MyRecyclerViewAdapter(@NonNull Context context, List<Bandeja> bolas) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.bolas=bolas;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.numeroBolaSacadaRV.setText(String.valueOf(bolas.get(position).getPosicion()));
        holder.bolaSacadaRV.setBackground(context.getDrawable(bolas.get(position).getBola().getColor()));
        holder.bolaSacadaRV.setText(String.valueOf(bolas.get(position).getBola().getNumero()));
    }

    @Override
    public int getItemCount() {
        return bolas.size();
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

