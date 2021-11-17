package com.hrgstudios.kpiskill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends AppCompatActivity {

    TextView Cliente01;
    EditText AddClienteEdText;
    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("funcionarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        AddClienteEdText = findViewById(R.id.AddClienteEdText);
        Cliente01 = findViewById(R.id.Cliente01);

    }

    public void Add(View view){

        //String[] Pessoas = {"Ricky", "Leandro"};

        FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

        String getUID = usuarioLogado.getUid();

        String cliente1 = AddClienteEdText.getText().toString();

        String Cliente1 = "Cliente";
        int n = 1;

        referencia.child(getUID).child("dias").child("SegundaFeira").child(Cliente1 + 1).setValue(cliente1);

        if(n == 1){
            System.out.println("O valor foi adicionado...");

            String Cliente2 = "Cliente";

            referencia.child(getUID).child("dias").child("SegundaFeira").child(Cliente2 + n + n).setValue(Cliente2);

        }

        System.out.println(getUID + cliente1);
        Cliente01.setText(cliente1);
    }
}