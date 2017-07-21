package com.example.alina.testtesta;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alina.testtesta.TEst.FirstFragment;

public class Test extends AppCompatActivity implements Fragment_akaTrud.ListListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Fragment_akaTrud fr = new Fragment_akaTrud();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame, fr);
        ft.commit();
    }

    @Override
    public void itemClicked(int i) {
        FirstFragment fragment = new FirstFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragment.getSelected(i);
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
