package com.hrgstudios.kpiskill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptor extends RecyclerView.Adapter<Adaptor.MyViewHolder> {

    String data1[];
    Context context;

    public Adaptor(Context ct,String nomes[]){
            context = ct;
            data1 = nomes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.texto1.setText(data1 [position]);
    }

    @Override
    public int getItemCount() {

        return data1.length;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView texto1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            texto1 = itemView.findViewById(R.id.textHolder);

        }
    }
}
