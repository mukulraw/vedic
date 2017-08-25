package com.vedictouch.vedictouch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    RelativeLayout relative;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relative = (RelativeLayout)findViewById(R.id.relative);
        book = (Button)findViewById(R.id.book);
        relative.setClipToOutline(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Menu fragment = new Menu();
        ft.replace(R.id.layout_to_replace, fragment);
        //ft.addToBackStack(null);
        //ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();





    }
}