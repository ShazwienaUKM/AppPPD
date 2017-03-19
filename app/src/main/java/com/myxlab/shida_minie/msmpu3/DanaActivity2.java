package com.myxlab.shida_minie.msmpu3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DanaActivity2 extends AppCompatActivity {
    RecyclerView rv_Dana;
    RecyclerView.LayoutManager danaLayout;
    RecyclerView.Adapter danaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dana2);

        rv_Dana = (RecyclerView) findViewById(R.id.rvDana);
        danaLayout = new LinearLayoutManager(this);
        rv_Dana.setLayoutManager(danaLayout);


        DanaData danaData[] = {new DanaData("Jenis Dana :","Dana Penyelidikan Top Down"),new DanaData("Status Iklan :","Sedang Iklan"),new DanaData("Garis Panduan :","http://"),new DanaData("Tarikh Buka :","01/01/2016"),new DanaData("Tarikh Tutup :","31/12/16"),new DanaData("Urusetia :","AZRIZAL BIN MOHAMED ZIN"),new DanaData("No. Telefon :","4064")};



        danaAdapter = new DanaAdapter(danaData,DanaActivity2.this);
        rv_Dana.setAdapter(danaAdapter);


    }

    @Nullable
    @Override
    //method untuk balik ke fragment sebelumnya
    public Intent getSupportParentActivityIntent() {
        Log.e("perincian dana","back");
        onBackPressed();
        return null;
    }
}
