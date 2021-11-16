package com.hrgstudios.kpiskill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity{

    TextView viewEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Dias", Dias.class)
                .add("Climov", Climov.class)
                .add("Planejamento", Planejamento.class)
                .add("Itens", Itens.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        viewEmail = findViewById(R.id.viewEmail);

        FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

        //String email = usuarioLogado.getEmail().replaceAll("\\p{Punct}", "");

        String getUID = usuarioLogado.getUid();
        viewEmail.setText(getUID);

        List<String> diasdasemana = new ArrayList<>();
        diasdasemana.add("Segunda");


    }
}