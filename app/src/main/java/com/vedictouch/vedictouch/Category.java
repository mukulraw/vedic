package com.vedictouch.vedictouch;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Category extends AppCompatActivity {

    ImageButton back;
    RelativeLayout single , natal , corporate , beauty , couple , offer;

    CoordinatorLayout categoryLayout;

    BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        back = (ImageButton)findViewById(R.id.back);

        categoryLayout = (CoordinatorLayout)findViewById(R.id.category_layout);

        single = (RelativeLayout)findViewById(R.id.single);
        natal = (RelativeLayout)findViewById(R.id.natal);
        corporate = (RelativeLayout)findViewById(R.id.chair);
        beauty = (RelativeLayout)findViewById(R.id.beauty);
        couple = (RelativeLayout)findViewById(R.id.couple);
        offer = (RelativeLayout)findViewById(R.id.offer);



        View bottom = findViewById(R.id.book);

        bottomSheetBehavior = BottomSheetBehavior.from(bottom);


        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        natal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        corporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        couple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }


    @Override
    protected void onStop() {
        super.onStop();

        overridePendingTransition(0 , R.anim.slide_down);

    }
}
