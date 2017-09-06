package com.vedictouch.vedictouch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Menu extends Fragment {

    TextView name , credit , account , business , location , gift , membership , experience , invite , team;

    TextView create , login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu , container , false);

        login = (TextView)view.findViewById(R.id.login);
        create = (TextView)view.findViewById(R.id.create);

        name = (TextView)view.findViewById(R.id.name);
        credit = (TextView)view.findViewById(R.id.credit);
        account = (TextView)view.findViewById(R.id.account);
        business = (TextView)view.findViewById(R.id.business);
        location = (TextView)view.findViewById(R.id.location);
        gift = (TextView)view.findViewById(R.id.gift);
        membership = (TextView)view.findViewById(R.id.membership);
        experience = (TextView)view.findViewById(R.id.experience);
        invite = (TextView)view.findViewById(R.id.invite);
        team = (TextView)view.findViewById(R.id.team);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((MainActivity)getContext()).getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left , R.anim.enter_from_left, R.anim.exit_to_right);
                Login fragment = new Login();
                ft.replace(R.id.layout_to_replace, fragment);
                ft.addToBackStack(null);
                //ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                ft.commit();


            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((MainActivity)getContext()).getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left , R.anim.enter_from_left, R.anim.exit_to_right);
                SignUp fragment = new SignUp();
                ft.replace(R.id.layout_to_replace, fragment);
                ft.addToBackStack(null);
                //ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                ft.commit();


            }
        });



        return view;
    }
}
