package com.example.thanhfoododer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    thucdonAdapter thucdonadapter;

    ThucDon thucDon1,thucDon2,thucDon3,thucDon4,thucDon5,thucDon6,thucDon7;
    List<ThucDon> thucDons;


    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
//        args.putSerializable("ThucDonPut",ThucDon);

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);

        recyclerView = view.findViewById(R.id.rvList);
        thucDons = new ArrayList<>();

        thucDon1 =new ThucDon("Pizza",100);
        thucDon2 =new ThucDon("Hamburger",50);
        thucDon3 =new ThucDon("Candy",10);
        thucDon4 =new ThucDon("Chưng Cake",80);
        thucDon5 =new ThucDon("Coca cola",45);
        thucDon6 =new ThucDon("Pessi",45);
        thucDon7 =new ThucDon("xxx",100);

        thucDons.add(thucDon1);
        thucDons.add(thucDon2);
        thucDons.add(thucDon3);
        thucDons.add(thucDon4);
        thucDons.add(thucDon5);
        thucDons.add(thucDon6);
        thucDons.add(thucDon7);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false);

        thucdonadapter = new thucdonAdapter(thucDons);
        recyclerView.setAdapter(thucdonadapter);
        recyclerView.setLayoutManager(layoutManager);

        thucdonadapter.setiOnClickThucDon(new IOnClickThucDon() {
            @Override
            public void onClickName(String name) {
                Toast.makeText(getContext(),name , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onclickPrice(double price) {
                Toast.makeText(getContext(), (int) price,Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
