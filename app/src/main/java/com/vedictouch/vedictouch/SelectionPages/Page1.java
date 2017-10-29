package com.vedictouch.vedictouch.SelectionPages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vedictouch.vedictouch.R;
import com.vedictouch.vedictouch.allAPIs;
import com.vedictouch.vedictouch.massagePOJO.MassageApus;
import com.vedictouch.vedictouch.massagePOJO.massageBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by mukul on 29/10/17.
 */

public class Page1 extends Fragment {

    TabLayout tabs;
    ViewPager pager;
    ProgressBar progress;
    String id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selection_page_1 , container , false);

        id = getArguments().getString("id");

        tabs = (TabLayout)view.findViewById(R.id.tabs);
        pager = (ViewPager)view.findViewById(R.id.pager);


        loadMassages(id);


        return view;
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

                PageAdapter adapter = new PageAdapter(getChildFragmentManager() , response.body().getMassageApi());
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


}
