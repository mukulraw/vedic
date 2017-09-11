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
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
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
    TabLayout tabs;
    ViewPager pager;

    BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        progress = (ProgressBar)findViewById(R.id.progress);

        back = (ImageButton)findViewById(R.id.back);
        tabs = (TabLayout)findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.pager);

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

                loadMassages("2");
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        natal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadMassages("3");
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        corporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadMassages("4");
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadMassages("5");
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        couple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadMassages("6");
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


    public void loadMassages(String id)
    {

        progress.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://technobrix.in")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        allAPIs cr = retrofit.create(allAPIs.class);

        Call<massageBean> call = cr.getMassages(id);

        call.enqueue(new Callback<massageBean>() {
            @Override
            public void onResponse(Call<massageBean> call, Response<massageBean> response) {

                for (int i = 0 ; i < response.body().getMassageApi().size() ; i++ )
                {
                    tabs.addTab(tabs.newTab().setText(response.body().getMassageApi().get(i).getTitle()));
                }

                PageAdapter adapter = new PageAdapter(getSupportFragmentManager() , response.body().getMassageApi());
                pager.setAdapter(adapter);

                tabs.setupWithViewPager(pager);


                for (int i = 0 ; i < response.body().getMassageApi().size() ; i++ )
                {
                    tabs.getTabAt(i).setText(response.body().getMassageApi().get(i).getTitle());
                }

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<massageBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });

    }


    public class PageAdapter extends FragmentStatePagerAdapter
    {
        List<MassageApus> list = new ArrayList<>();


        public PageAdapter(FragmentManager fm , List<MassageApus> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {

            Pages page = new Pages();
            Bundle b = new Bundle();
            b.putString("url" , list.get(position).getImage());
            b.putString("name" , list.get(position).getTitle());
            page.setArguments(b);

            return page;
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }


    public static class Pages extends Fragment
    {
        String url , name;
        ImageView image;
        TextView title;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.massage_model , container , false);

            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView)view.findViewById(R.id.title);

            url = getArguments().getString("url");
            name = getArguments().getString("name");

            title.setText(name);

            //ImageLoader loader = ImageLoader.getInstance();

            Glide
                    .with(getActivity()) // replace with 'this' if it's in activity
                    .load(url)
                    .asGif()
                    // show error drawable if the image is not a gif
                    .into(image);





            return view;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.hold , R.anim.slide_down);

    }


}
