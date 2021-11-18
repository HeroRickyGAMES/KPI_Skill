package com.hrgstudios.kpiskill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    EditText AddClienteEdText;
    String  nomes[];
    RecyclerView recycleView;
    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("funcionarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        AddClienteEdText = findViewById(R.id.AddClienteEdText);

        recycleView = findViewById(R.id.recycleView);

        nomes = getResources().getStringArray(R.array.Nomes);

        Adaptor adaptor = new Adaptor(this, nomes);

        recycleView.setAdapter(adaptor);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void Add(View view) {


    }
}