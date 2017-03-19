package com.myxlab.shida_minie.msmpu3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class NotifyFragment extends Fragment {

    public NotifyFragment() {
        // Required empty public constructor
    }

    RecyclerView rvNoti;
    RecyclerView.Adapter notiadapter;
    RecyclerView.LayoutManager notiLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context context = getActivity();

        FragmentManager fragmentManager = getFragmentManager();

        View view = inflater.inflate(R.layout.fragment_notify, container, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        rvNoti = (RecyclerView) view.findViewById(R.id.rv_noti);
        notiLayout = new LinearLayoutManager(getActivity().getApplicationContext());
        rvNoti.setLayoutManager(notiLayout);

        NotiData notiData[]={
                new NotiData(R.drawable.ic_money1,"Dana Penyelidikan Top Down","Sedang Iklan"),
                new NotiData(R.drawable.ic_keputusan,"Permohonan Projek","permohonan projek telah dikemaskini")};

        notiadapter= new NotiAdapter(notiData,getActivity());
        rvNoti.setAdapter(notiadapter);

        return view;
    }


}
