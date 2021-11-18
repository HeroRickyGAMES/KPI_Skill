package com.hrgstudios.kpiskill;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.MyViewHolder> {

    String data1[];
    Context context;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("funcionarios");

    public Adaptor(Context ct,String nomes[]){
            context = ct;
            data1 = nomes;
        iniciardb();
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

        referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

                String user = usuarioLogado.getUid();

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child(user).child("dias").child("SegundaFeira").child("0").getValue().toString();

                holder.texto1.setText(name);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //holder.texto1.setText(data1 [position]);
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

    public void iniciardb(){

    }

}
