package com.myxlab.shida_minie.msmpu3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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

import static com.myxlab.shida_minie.msmpu3.iklanAdapter.KEY_NAME;

public class DanaActivity2 extends AppCompatActivity {

    RecyclerView rv_Dana;
    RecyclerView.LayoutManager danaLayout;
    RecyclerView.Adapter danaAdapter;
    List<DanaData>danaDataList;

    public static final String KEY_SNAME = "KEY_SNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dana2);

        rv_Dana = (RecyclerView) findViewById(R.id.rvDana);
        danaLayout = new LinearLayoutManager(this);
        rv_Dana.setLayoutManager(danaLayout);
        danaDataList = new ArrayList<>();

        getData();

        Intent intent = getIntent();
        String name = intent.getStringExtra(iklanAdapter.KEY_NAME);
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();

       // DanaData danaData[] = {new DanaData("Jenis Dana :","Dana Penyelidikan Top Down"),new DanaData("Status Iklan :","Sedang Iklan"),new DanaData("Garis Panduan :","http://"),new DanaData("Tarikh Buka :","01/01/2016"),new DanaData("Tarikh Tutup :","31/12/16"),new DanaData("Urusetia :","AZRIZAL BIN MOHAMED ZIN"),new DanaData("No. Telefon :","4064")};

        /*danaAdapter = new DanaAdapter(danaData,DanaActivity2.this);
        rv_Dana.setAdapter(danaAdapter);*/

        //int position = rv_Dana.getChildAdapterPosition(context);
       /* if(KEY_NAME == KEY_SNAME)
        {
            getData();
        }*/

    }

    private void getData() {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/dana";

       /* String link = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/dana/";

        String url = link + KEY_NAME;*/

        Log.e("DanaActivity2","getData");

        //create a json object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray resultsArray = response.getJSONArray("geran");
                    parseData(resultsArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("DanaActivity2", response.toString());
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
            DanaData dana = new DanaData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String dataName =json.getString("Nama Geran");
                String dataStatus =json.getString("Status");
                //String panduan =json.getString("Garis Panduan");
                String tarikhBuka =json.getString("Tarikh Buka");
                String tarikhTutup =json.getString("Tarikh Tutup");
                //String urusetia =json.getString("Nama Urusetia");
                //String fon =json.getString("No. Tel");


                    dana.setText_dana("Nama Geran");
                    dana.setTv_dana(dataName);
                    dana.setText_status("Status");
                    dana.setTv_status(dataStatus);
                    dana.setText_panduan("Garis Panduan");
                    //dana.setTv_panduan(panduan);
                    dana.setText_tbuka("Tarikh Buka");
                    dana.setTv_tbuka(tarikhBuka);
                    dana.setText_ttutup("Tarikh Tutup");
                    dana.setTv_ttutup(tarikhTutup);
                    dana.setText_urusetia("Nama Urusetia");
                    //dana.setTv_urusetia(urusetia);
                    dana.setText_fon("No. Tel");
                    //dana.setTv_fon(fon);


                //Log.e("iklanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            danaDataList.add(dana);
        }

        danaAdapter = new DanaAdapter(danaDataList,this);
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
