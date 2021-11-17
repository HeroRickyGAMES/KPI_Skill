package com.hrgstudios.kpiskill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    TextView Cliente01;
    EditText AddClienteEdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        AddClienteEdText = findViewById(R.id.AddClienteEdText);
        Cliente01 = findViewById(R.id.Cliente01);

    }

    public void Add(View view){
        String cliente1 = AddClienteEdText.getText().toString();

        Cliente01.setText(cliente1);
    }
}