package com.myxlab.shida_minie.msmpu3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class StatusActivity extends AppCompatActivity {

    RecyclerView rv_status;
    RecyclerView.LayoutManager statusLayout;
    RecyclerView.Adapter status_adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        rv_status= (RecyclerView) findViewById(R.id.rv_status);

        StatusData statusData[]={new StatusData("Kod Projek :","AP-2013-011"),new StatusData("Nama Dana :","Projek Arus Perdana"),new StatusData("Tajuk :","Mobile Sensing Technology for Augmented Reality and Medical Application"),new StatusData("Peranan :","Ketua Projek"),new StatusData("Ketua Projek :","K009683 HASLINA BINTI ARSHAD"),new StatusData("Tarikh Mula :","01/11/2013"),new StatusData("Tarikh Tamat :","30/04/2017"),new StatusData("Status Projek :","Aktif")};

        statusLayout = new LinearLayoutManager(this);
        rv_status.setLayoutManager(statusLayout);

        status_adapter = new  StatusAdapter(statusData,StatusActivity.this);
        rv_status.setAdapter(status_adapter);
    }


    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Log.e("status","back");
        onBackPressed();
        return null;
//        return super.getSupportParentActivityIntent();
    }
}
