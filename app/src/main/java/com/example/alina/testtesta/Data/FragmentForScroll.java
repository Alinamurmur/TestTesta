package com.example.alina.testtesta.Data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alina.testtesta.R;

/**
 * Created by Alina on 18.07.2017.
 */

public class FragmentForScroll extends Fragment {

    TextView title,text;
    ImageView imageView;
    String stringtitle,stringtext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_scroll,container,false);

        title = view.findViewById(R.id.title);
        text = view.findViewById(R.id.text);
        imageView =view.findViewById(R.id.image);

        title.setText(stringtitle);
        text.setText(stringtext);

        return view;
    }


    public FragmentForScroll(TextView title, TextView text, ImageView imageView) {
        this.title = title;
        this.text = text;
        this.imageView = imageView;
    }
}
