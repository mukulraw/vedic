package com.vedictouch.vedictouch;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.vedictouch.vedictouch.SelectionPages.Page1;
import com.vedictouch.vedictouch.massagePOJO.MassageApus;
import com.vedictouch.vedictouch.massagePOJO.massageBean;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Category extends AppCompatActivity {

    ImageButton back;
    RelativeLayout single , natal , corporate , beauty , couple , offer;

    CoordinatorLayout categoryLayout;
    ProgressBar progress;


    int selectedNumber = 0;


    BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        progress = (ProgressBar)findViewById(R.id.progress);

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




                if (selectedNumber == 2)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else
                {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Page1 frag = new Page1();
                    Bundle b = new Bundle();
                    b.putString("id" , String.valueOf("2"));
                    frag.setArguments(b);
                    ft.replace(R.id.replace , frag);
                    ft.commit();


                }

                selectedNumber = 2;

            }
        });

        natal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedNumber == 3)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else
                {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Page1 frag = new Page1();
                    Bundle b = new Bundle();
                    b.putString("id" , String.valueOf("3"));
                    frag.setArguments(b);
                    ft.replace(R.id.replace , frag);
                    ft.commit();


                }


                selectedNumber = 3;
            }
        });

        corporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (selectedNumber == 4)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else
                {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Page1 frag = new Page1();
                    Bundle b = new Bundle();
                    b.putString("id" , String.valueOf("4"));
                    frag.setArguments(b);
                    ft.replace(R.id.replace , frag);
                    ft.commit();


                }
                selectedNumber = 4;
            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (selectedNumber == 5)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else
                {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Page1 frag = new Page1();
                    Bundle b = new Bundle();
                    b.putString("id" , String.valueOf("5"));
                    frag.setArguments(b);
                    ft.replace(R.id.replace , frag);
                    ft.commit();


                }
                selectedNumber = 5;
            }
        });

        couple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (selectedNumber == 6)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else
                {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Page1 frag = new Page1();
                    Bundle b = new Bundle();
                    b.putString("id" , String.valueOf("6"));
                    frag.setArguments(b);
                    ft.replace(R.id.replace , frag);
                    ft.commit();


                }
                selectedNumber = 6;
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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.hold , R.anim.slide_down);

    }


}
