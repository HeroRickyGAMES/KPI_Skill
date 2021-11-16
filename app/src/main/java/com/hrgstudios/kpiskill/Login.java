package com.hrgstudios.kpiskill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//Programado por HeroRicky Games

public class Login extends AppCompatActivity {

    EditText textEmailS, textSenhaS;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmailS = findViewById(R.id.textEmailS);
        textSenhaS = findViewById(R.id.textSenhaS);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String email = textEmailS.getText().toString();
            String senha = textSenhaS.getText().toString();

                if( email.isEmpty() || senha.isEmpty() ){
                    Snackbar snackbar = Snackbar.make(v, "Preencha todos os campos!",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else{
                    autenticarfuncionario(v);
                }

            }
        });
      }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

        if(usuarioLogado != null){
            //AbrirTelaInicial();
        }
    }
        public void autenticarfuncionario(View view){

            String email = textEmailS.getText().toString();
            String senha = textSenhaS.getText().toString();

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AbrirTelaInicial();
                            }
                        }, 3000);
                    }else{
                        String erro;
                        try {
                            throw task.getException();
                        }catch (Exception e){
                            erro = "Erro ao logar!";
                            Snackbar snackbar = Snackbar.make(view, erro,Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                }
            });
        }

        public void AbrirTelaInicial(){

            Intent intent = new Intent(this, home.class);
            startActivity(intent);

        }
}
