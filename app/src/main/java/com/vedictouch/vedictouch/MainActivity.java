package com.vedictouch.vedictouch;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {


    Button book;
    ViewPager pager;
    CircleIndicator indicator;
    PageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book = (Button)findViewById(R.id.book);
        pager = (ViewPager)findViewById(R.id.pager);
        indicator = (CircleIndicator)findViewById(R.id.indicator);

        pager.setPageMargin(20);
        pager.setClipToPadding(false);
        pager.setPadding(60, 0, 60, 0);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Menu fragment = new Menu();
        ft.replace(R.id.layout_to_replace, fragment);
        //ft.addToBackStack(null);
        //ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();


        adapter = new PageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("asd" , "asdasdasd");

                Intent intent = new Intent(MainActivity.this , Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up , R.anim.hold);

            }
        });

    }

    public class PageAdapter extends FragmentStatePagerAdapter
    {

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Pages();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


    public static class Pages extends Fragment
    {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.pager_item , container , false);



            return view;
        }
    }


}