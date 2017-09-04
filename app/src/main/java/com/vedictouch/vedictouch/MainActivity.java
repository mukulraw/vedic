package com.vedictouch.vedictouch;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    Button book;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book = (Button)findViewById(R.id.book);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Menu fragment = new Menu();
        ft.replace(R.id.layout_to_replace, fragment);
        //ft.addToBackStack(null);
        //ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("asd" , "asdasdasd");

                Intent intent = new Intent(MainActivity.this , Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up , 0);

            }
        });



    }
}