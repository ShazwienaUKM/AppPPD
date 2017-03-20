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

public class PermohonanActivity extends AppCompatActivity {

    RecyclerView rv_permohonan;
    RecyclerView.LayoutManager permohonanLayout;
    RecyclerView.Adapter permohonan_adapter;
    List<PermohonanData>permohonanDataList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permohonan);

        rv_permohonan = (RecyclerView) findViewById(R.id.rv_permohonan);

        permohonanDataList = new ArrayList<>();

        getData();

        //PermohonanData permohonanData[] = {new PermohonanData("ID Borang :","P14256"),new PermohonanData("Nama Dana :","Geran Universiti Penyelidikan"),new PermohonanData("Tajuk :","A Multimodal Adaptive Interface Design for Wearables to Support Tourism Augmented Reality"),new PermohonanData("Jangka Masa (Bulan) :","24"),new PermohonanData("Status Mohon :","\tTindakan Urusetia(untuk kelulusan)")};

        permohonanLayout = new LinearLayoutManager(this);
        rv_permohonan.setLayoutManager(permohonanLayout);

      /*  permohonan_adapter = new PermohonanAdapter(permohonanData,PermohonanActivity.this);
        rv_permohonan.setAdapter(permohonan_adapter);*/
    }

    private void getData() {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/permohonan";

        Log.e("PermohonanActivity","getData");

        //create a json object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray resultsArray = response.getJSONArray("permohonan");
                    parseData(resultsArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("PermohonanActivity", response.toString());
                loading.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.toString());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }

    private void parseData(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            PermohonanData permohonan = new PermohonanData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String idBorang =json.getString("Id Borang");
                String namaDana =json.getString("Id Dana");
                String tajuk =json.getString("Tajuk");
                String jangkaMasa =json.getString("Jangka Masa");
                String statusPermohonan =json.getString("Status");

                permohonan.setText_idPermohonan("Id Borang");
                permohonan.setTv_idPermohonan(idBorang);
                permohonan.setText_namaDana("Nama Dana");
                permohonan.setTv_namaDana(namaDana);
                permohonan.setText_tajuk("Tajuk");
                permohonan.setTv_tajuk(tajuk);
                permohonan.setText_jangkaMasa("Jangka Masa");
                permohonan.setTv_jangkaMasa(jangkaMasa);
                permohonan.setText_status("Status");
                permohonan.setTv_status(statusPermohonan);

                //Log.e("iklanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            permohonanDataList.add(permohonan);
        }

        permohonan_adapter = new PermohonanAdapter(permohonanDataList,this);
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
