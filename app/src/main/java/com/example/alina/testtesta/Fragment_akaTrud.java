package com.example.alina.testtesta;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alina.testtesta.Data.DataClass;

import java.util.ArrayList;
import java.util.List;

public class Fragment_akaTrud extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    //List<DataClass> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trud,container,false);
        String[] names = { "Наш главный праздник", "Хорошее сочетание", "Гордость первого цеха", "Вместе создавать будущее", "Человек дела", "Игра, которую любят", "Ритм спартакиады"};
        listView = (ListView) view.findViewById(R.id.trudlist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

      //  list = new ArrayList<DataClass>();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(),TabbedActi.class);
        TextView textView = (TextView) view.findViewById(R.id.list_item);
        intent.putExtra("Name",textView.getText());
        startActivity(intent);
    }


}
