package com.example.alina.testtesta.TEst;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alina.testtesta.R;
import com.rd.PageIndicatorView;

// Fragment where is ViewPager

public class FirstFragment extends Fragment {
    String nameText;
    int id =0 ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,
                container, false);

        ViewPager pager = view.findViewById(R.id.viewpager);
        pager.setAdapter(buildAdapter());
        pager.setCurrentItem(id);

        PageIndicatorView pageIndicatorView = view.findViewById(R.id.indicator);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setSelection(id);
        return view;
    }
   private PagerAdapter buildAdapter() {
        return(new SampleAdapter(getActivity(), getChildFragmentManager()));
    }

    public void getSelected(int id){
        this.id = id;
    }

}




