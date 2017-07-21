package com.example.alina.testtesta;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alina.testtesta.Data.DataClass;
import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.rd.PageIndicatorView;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import com.viewpagerindicator.CirclePageIndicator;

import static android.app.PendingIntent.getActivity;

public class TabbedActi extends AppCompatActivity {

    Toolbar toolbar;

    static Context context;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

      //  name = getIntent().getStringExtra("Name");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("За доблестный труд");
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        //indicator.setViewPager(mViewPager);

       // PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
      //  pageIndicatorView.setViewPager(mViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
//       TitlePageIndicator titleIndicator = (TitlePageIndicator)findViewById(R.id.pageIndicatorView);
      //  titleIndicator.setViewPager(mViewPager);
      //  titleIndicator.setViewPager(mViewPager);
context = getApplicationContext();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
       // TextView title,text;
        //mageView imageView;
        //static int fr =1;
       // String tex = "R.string.text";
        String titl,url,textt;


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber,
                                                      String string, String text, String img) {
            PlaceholderFragment fragment = new PlaceholderFragment();
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {



        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
           // return PlaceholderFragment.newInstance(position + 1);
            ArrayList<DataClass> list = getData();

            return  PlaceholderFragment.newInstance(position,list.get(position).getName(),
                    list.get(position).getText(),list.get(position).getImg());
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }
    }


    private static ArrayList<DataClass> getData() {


        ArrayList results = new ArrayList<DataClass>();
        String[] names = { "Наш главный праздник", "Хорошее сочетание",
                "Гордость первого цеха", "Вместе создавать будущее", "Человек дела",
                "Игра, которую любят", "Ритм спартакиады"};

        String[]text = {context.getResources().getString(R.string.text1),
                context.getResources().getString(R.string.text2),context.getResources().getString(R.string.text3),
                context.getResources().getString(R.string.text4),context.getResources().getString(R.string.text5),
                context.getResources().getString(R.string.text6),context.getResources().getString(R.string.text7)};

        String [] imgs = {"https://pp.userapi.com/c543100/v543100923/295e7/RUsboeu4U6c.jpg",
                "https://pp.userapi.com/c543100/v543100923/295f0/yOY3KAVYFSA.jpg",
                "https://pp.userapi.com/c543100/v543100923/295f9/sInYh6gw8k0.jpg",
                "https://pp.userapi.com/c543100/v543100923/29602/SzSxjqRsJbk.jpg",
                "https://pp.userapi.com/c543100/v543100923/2960b/sUfsno_YfuY.jpg",
                "https://pp.userapi.com/c543100/v543100923/29614/gSBrs3H_jqo.jpg",
                "https://pp.userapi.com/c543100/v543100923/2961d/LljwLHB6NIM.jpg"};

        for (int index = 0; index < 7; index++) {
            DataClass data = new DataClass(names[index],text[index],imgs[index]);
            results.add(index,data);
        }
        return results;
    }
}
