package com.myxlab.shida_minie.msmpu3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class PermohonanActivity extends AppCompatActivity {

    RecyclerView rv_permohonan;
    RecyclerView.LayoutManager permohonanLayout;
    RecyclerView.Adapter permohonan_adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permohonan);

        rv_permohonan = (RecyclerView) findViewById(R.id.rv_permohonan);

        PermohonanData permohonanData[] = {new PermohonanData("ID Borang :","P14256"),new PermohonanData("Nama Dana :","Geran Universiti Penyelidikan"),new PermohonanData("Tajuk :","A Multimodal Adaptive Interface Design for Wearables to Support Tourism Augmented Reality"),new PermohonanData("Jangka Masa (Bulan) :","24"),new PermohonanData("Status Mohon :","\tTindakan Urusetia(untuk kelulusan)")};

        permohonanLayout = new LinearLayoutManager(this);
        rv_permohonan.setLayoutManager(permohonanLayout);

        permohonan_adapter = new PermohonanAdapter(permohonanData,PermohonanActivity.this);
        rv_permohonan.setAdapter(permohonan_adapter);
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Log.e("perincian permohonan","back");
        onBackPressed();
        return null;
    }
}
