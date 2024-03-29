package com.hrgstudios.kpiskill;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Programado por HeroRicky Games

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dias#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dias extends Fragment{

    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("funcionarios");

    TextView Dia1, Dia2, Dia3, Dia4, Dia5;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Dias() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dias.
     */
    // TODO: Rename and change types and number of parameters
    public static Dias newInstance(String param1, String param2) {
        Dias fragment = new Dias();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dias, container, false);

        //View By ID
        Dia1 = view.findViewById(R.id.diaS);
        Dia2 = view.findViewById(R.id.DiaT);
        Dia3 = view.findViewById(R.id.DiaQUA);
        Dia4 = view.findViewById(R.id.DiaQUI);
        Dia5 = view.findViewById(R.id.DiaSex);

        FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

        String user = usuarioLogado.getUid();

        //Tratamento da String da segunda feira
        String Seg = referencia.child(user).child("dias").child("Segunda-Feira").toString().replaceAll("\\p{Punct}", "")
                .replaceAll("https", "").replaceAll(user, "").
                        replaceAll("kpiskilldefaultrtdbfirebaseiocomfuncionariosdias", "");

        //Tratamento da String da Terça
        String Ter = referencia.child(user).child("dias").child("Terça-Feira").toString().replaceAll("\\p{Punct}", "")
                .replaceAll("https", "").replaceAll(user, "").
                        replaceAll("kpiskilldefaultrtdbfirebaseiocomfuncionariosdias", "").replaceAll("C3A7", "ç");

        String Qua = referencia.child(user).child("dias").child("Quarta-Feira").toString().replaceAll("\\p{Punct}", "")
                .replaceAll("https", "").replaceAll(user, "").
                        replaceAll("kpiskilldefaultrtdbfirebaseiocomfuncionariosdias", "");

        String Qui = referencia.child(user).child("dias").child("Quinta-Feira").toString().replaceAll("\\p{Punct}", "")
                .replaceAll("https", "").replaceAll(user, "").
                        replaceAll("kpiskilldefaultrtdbfirebaseiocomfuncionariosdias", "");

        String Sex = referencia.child(user).child("dias").child("Sexta-Feira").toString().replaceAll("\\p{Punct}", "")
                .replaceAll("https", "").replaceAll(user, "").
                        replaceAll("kpiskilldefaultrtdbfirebaseiocomfuncionariosdias", "");


        //Backend para o FrontEnd
        Dia1.setText(Seg);
        Dia2.setText(Ter);
        Dia3.setText(Qua);
        Dia4.setText(Qui);
        Dia5.setText(Sex);
        Dia5.setText(Sex);


        Dia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SegundaActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void SegAc(View view){



    }
}