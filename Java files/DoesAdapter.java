package com.example.todos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.todos.R;
import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyDoes> mydoes;

    public DoesAdapter(Context c,ArrayList<MyDoes> tmp){
        context = c;
        mydoes = tmp;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.titledoes.setText(mydoes.get(i).getTitledoes());
        holder.descdoes.setText(mydoes.get(i).getDescdoes());
        holder.datedoes.setText(mydoes.get(i).getDatedoes());

        final String getTitleDoes = mydoes.get(i).getTitledoes();
        final String getDescDoes = mydoes.get(i).getDescdoes();
        final String getDateDoes = mydoes.get(i).getDatedoes();
        final String getKeyDoes = mydoes.get(i).getKeydoes();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context,EditTaskDesk.class);
                aa.putExtra("titledoes", getTitleDoes);
                aa.putExtra("descdoes", getDescDoes);
                aa.putExtra("datedoes", getDateDoes);
                aa.putExtra("keydoes", getKeyDoes);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mydoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titledoes,datedoes,descdoes,keydoes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView)itemView.findViewById( R.id.titledoes);
            descdoes = (TextView)itemView.findViewById( R.id.descdoes);
            datedoes = (TextView)itemView.findViewById( R.id.datedoes);
            //keydoes = (TextView)itemView.findViewById( R.id.datedoes);
        }
    }
}

