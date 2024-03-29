package com.hrgstudios.kpiskill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Programado por HeroRicky Games

public class MainActivity extends AppCompatActivity {

    EditText textNome, textCPF, textIdade, textSenha, textEmail;
    Button btn_Cadastro;

    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("funcionarios");

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

        //ID do Botão
        btn_Cadastro = findViewById(R.id.btn_Cadastro);

        //Ouvinte do botão de cadastro
        btn_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Strings
            String nome = textNome.getText().toString();
            String CPF = textCPF.getText().toString();
            String idade = textIdade.getText().toString();
            String email = textEmail.getText().toString();
            String senha = textSenha.getText().toString();

            if(nome.isEmpty() || CPF.isEmpty() || idade.isEmpty() || email.isEmpty() || senha.isEmpty()){

                Snackbar snackbar = Snackbar.make(v, "Preencha todos os campos!", Snackbar.LENGTH_LONG);
                snackbar.show();

            }else{
                CadastroFuncionario(v);
            }

            }
        });

    }

    public void CadastroFuncionario(View v){

        String email = textEmail.getText().toString();
        String senha = textSenha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    SalvarDadosdoFuncionario();

                    FirebaseAuth.getInstance().getUid();

                    Snackbar snackbar = Snackbar.make(v, "Cadastro Realizado com sucesso!", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }else{
                    String erro;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no minimo 6 caracteres!";
                    }catch(FirebaseAuthUserCollisionException e) {
                        erro = "Essa conta já existe!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "Verifique se seu email está digitado corretamente!";

                    }catch(Exception e){
                        erro = "Erro ao cadastrar usuário!";
                    }

                    //Snackbar com erros
                    Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }
        public void SalvarDadosdoFuncionario(){

        String documentos = "Documentos";
        String nome = textNome.getText().toString();
        String idade = textIdade.getText().toString();
        String CPF = textCPF.getText().toString();
        String email = textEmail.getText().toString();
        String dias = "dias";
        String Segunda = "SegundaFeira";
        String Terça = "TerçaFeira";
        String Quarta = "QuartaFeira";
        String Quinta = "QuintaFeira";
        String Sexta = "SextaFeira";
        String Sabado = "Sabado";
        String Domingo = "Domingo";

        //String getUID = textEmail.getText().toString().replaceAll("\\p{Punct}", "");

            FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

            String getUID = usuarioLogado.getUid();

            //Documentos
            referencia.child(getUID).child("documentos").setValue(documentos);

            referencia.child(getUID).child("documentos").child("nome").setValue(nome);
            referencia.child(getUID).child("documentos").child("Data de admissao").setValue(idade);
            referencia.child(getUID).child("documentos").child("CPF").setValue(CPF);
            referencia.child(getUID).child("documentos").child("E-mail").setValue(email);

            //Dias
            referencia.child(getUID).child("dias").setValue(dias);

            //Dias da semana
            referencia.child(getUID).child("dias").child("SegundaFeira").setValue(Segunda);
            referencia.child(getUID).child("dias").child("TercaFeira").setValue(Terça);
            referencia.child(getUID).child("dias").child("QuartaFeira").setValue(Quarta);
            referencia.child(getUID).child("dias").child("QuintaFeira").setValue(Quinta);
            referencia.child(getUID).child("dias").child("SextaFeira").setValue(Sexta);
            referencia.child(getUID).child("dias").child("Sabado").setValue(Sabado);
            referencia.child(getUID).child("dias").child("Domingo").setValue(Domingo);

        }
        public void btnnovatela(View view){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

        if(usuarioLogado != null){

            AbrirTelaInicial();

        }

    }
    public void AbrirTelaInicial(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}