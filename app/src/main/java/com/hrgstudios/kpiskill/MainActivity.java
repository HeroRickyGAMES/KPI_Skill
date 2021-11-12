package com.hrgstudios.kpiskill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textNome, textCPF, textIdade, textSenha, textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Atribuir os ids com a interface gráfica do aplicativo
        textNome = findViewById(R.id.textNome);
        textCPF = findViewById(R.id.textCPF);
        textIdade = findViewById(R.id.textIdade);
        textEmail = findViewById(R.id.textEmail);
        textSenha = findViewById(R.id.textSenha);
    }
}