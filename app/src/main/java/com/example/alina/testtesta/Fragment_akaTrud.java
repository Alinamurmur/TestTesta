package com.example.alina.testtesta;


import android.app.Activity;
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

public class Fragment_akaTrud extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;

    static interface ListListener{
        void itemClicked(int id);
    }
    private ListListener listListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trud,container,false);
        String[] names = { "Наш главный праздник", "Хорошее сочетание", "Гордость первого цеха", "Вместе создавать будущее", "Человек дела", "Игра, которую любят", "Ритм спартакиады"};
        listView = view.findViewById(R.id.trudlist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

       // TextView textView = view.findViewById(R.id.list_item);
       // String name = (String) textView.getText();
        if (listListener != null) {
            listListener.itemClicked(i);}

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listListener = (ListListener)activity;
    }
}
