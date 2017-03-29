package com.myxlab.shida_minie.msmpu3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
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


    TextView text_dana,tv_dana,text_status,tv_status,text_panduan,tv_panduan,text_tbuka,tv_tbuka,text_ttutup,tv_ttutup,text_urusetia,tv_urusetia,text_fon,tv_fon;
    public static final String KEY_SNAME = "KEY_SNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dana2);


        text_dana = (TextView) findViewById(R.id.text_Dana);
        tv_dana = (TextView) findViewById(R.id.tv_dana);
        text_status = (TextView) findViewById(R.id.text_statusIklan);
        tv_status = (TextView) findViewById(R.id.tv_statusIklan);
        text_panduan = (TextView) findViewById(R.id.text_panduan);
        tv_panduan = (TextView) findViewById(R.id.tv_panduan);
        text_tbuka = (TextView) findViewById(R.id.text_tbuka);
        tv_tbuka = (TextView) findViewById(R.id.tv_tbuka);
        text_ttutup = (TextView) findViewById(R.id.text_ttutup);
        tv_ttutup = (TextView) findViewById(R.id.tv_ttutup);
        text_urusetia = (TextView) findViewById(R.id.text_urusetia);
        tv_urusetia = (TextView) findViewById(R.id.tv_urusetia);
        text_fon = (TextView) findViewById(R.id.text_fon);
        tv_fon = (TextView) findViewById(R.id.tv_fon);


        Intent intent = getIntent();
        String key = intent.getStringExtra(iklanAdapter.KEY_NAME);
        //Toast.makeText(this, ""+key, Toast.LENGTH_SHORT).show();

        getData(key);

       // DanaData danaData[] = {new DanaData("Jenis Dana :","Dana Penyelidikan Top Down"),new DanaData("Status Iklan :","Sedang Iklan"),new DanaData("Garis Panduan :","http://"),new DanaData("Tarikh Buka :","01/01/2016"),new DanaData("Tarikh Tutup :","31/12/16"),new DanaData("Urusetia :","AZRIZAL BIN MOHAMED ZIN"),new DanaData("No. Telefon :","4064")};

    }

    private void getData(String key) {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please Wait...", false, true);
        //String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/dana";

        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/dana" + "/" + key;

        //String url = link + KEY_NAME;

        Log.e("DanaActivity2","getData");

        //create a json object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject resultsObj = response.getJSONObject("geran");
                   // String nama_geran= resultsObj.getString("Nama Geran");
                    String dataName =resultsObj.getString("Nama Geran");
                    String dataStatus =resultsObj.getString("Status");
                    //String panduan =resultsObj.getString("Garis Panduan");
                    String tarikhBuka =resultsObj.getString("Tarikh Buka");
                    String tarikhTutup =resultsObj.getString("Tarikh Tutup");
                    //String urusetia =resultsObj.getString("Nama Urusetia");
                    //String fon =resultsObj.getString("No. Tel");

                    Log.e("Nama Geran", dataName);

                   // tv2.setText(dataName);
                    text_dana.setText("Nama Geran");
                    tv_dana.setText(dataName);
                    text_status.setText("Status");
                    tv_status.setText(dataStatus);
                    text_panduan.setText("Garis Panduan");
                    //tv_panduan.setText(panduan);
                    text_tbuka.setText("Tarikh Buka");
                    tv_tbuka.setText(tarikhBuka);
                    text_ttutup.setText("Tarikh Tutup");
                    tv_ttutup.setText(tarikhTutup);
                    text_urusetia.setText("Nama Urusetia");
                    //tv_urusetia(urusetia);
                    text_fon.setText("No. Tel");
                    //tv_fon.setText(fon);

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

   /* private void parseData(JSONArray array) {
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

    }*/

    @Nullable
    @Override
    //method untuk balik ke fragment sebelumnya
    public Intent getSupportParentActivityIntent() {
        Log.e("perincian dana","back");
        onBackPressed();
        return null;
    }
}
