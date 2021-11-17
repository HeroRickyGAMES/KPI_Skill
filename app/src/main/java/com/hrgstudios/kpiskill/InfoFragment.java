package com.hrgstudios.kpiskill;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    TextView ProfileName, ProfileEmail, ProfileCPF, ProfileContratation;

    FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();
    String user = usuarioLogado.getUid();

    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("funcionarios").child(user);

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        ProfileName = view.findViewById(R.id.ProfileName);
        ProfileEmail = view.findViewById(R.id.ProfileEmail);
        ProfileCPF = view.findViewById(R.id.ProfileCPF);
        ProfileContratation = view.findViewById(R.id.ProfileContratation);


        String Nome = referencia.child("documentos").child("nome").toString().replaceAll("\\p{Punct}", "")
                .replaceAll("https", "").replaceAll(user, "").
                        replaceAll("kpiskilldefaultrtdbfirebaseiocomfuncionariosdocumentos", "");

        ProfileName.setText(Nome);


        return view;
    }
}