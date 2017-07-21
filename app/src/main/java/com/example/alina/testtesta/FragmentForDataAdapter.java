package com.example.alina.testtesta;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alina.testtesta.Data.DataClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FragmentForDataAdapter extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    String titl,url,textt;
    Context context;


    public FragmentForDataAdapter() {}


    public static FragmentForDataAdapter newInstance(int sectionNumber,
                                                             String string, String text, String img) {
        FragmentForDataAdapter fragment = new FragmentForDataAdapter();
        Bundle args = new Bundle();
        String title ="";
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putString("someTitle",string);
        args.putString("text",text);
        args.putString("img",img);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titl = getArguments().getString("someTitle");
        textt = getArguments().getString("text");
        url = getArguments().getString("img");
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        TextView texView =  rootView.findViewById(R.id.sometext);
        ImageView imageView =  rootView.findViewById(R.id.someimg);
        textView.setText(titl);
        texView.setText(textt);
        Picasso.with(getActivity()).load(url).into(imageView);

        return rootView;
    }
}

