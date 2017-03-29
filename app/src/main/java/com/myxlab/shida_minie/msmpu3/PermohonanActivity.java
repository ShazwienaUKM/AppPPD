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

import static com.myxlab.shida_minie.msmpu3.keputusanAdapter.ID_KEPUTUSAN;

public class PermohonanActivity extends AppCompatActivity {


    TextView text_idPermohonan,tv_idPermohonan,text_namaDana,tv_namaDana,text_tajuk,tv_tajuk,text_jangkaMasa,tv_jangkaMasa,text_status,tv_status;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permohonan);

        text_idPermohonan = (TextView) findViewById(R.id.text_idPermohonan);
        tv_idPermohonan = (TextView) findViewById(R.id.tv_idPermohonan);
        text_namaDana = (TextView) findViewById(R.id.text_namaDana);
        tv_namaDana= (TextView) findViewById(R.id.tv_namaDana);
        text_tajuk = (TextView) findViewById(R.id.text_tajuk);
        tv_tajuk = (TextView) findViewById(R.id.tv_tajuk);
        text_jangkaMasa = (TextView) findViewById(R.id.text_jangkaMasa);
        tv_jangkaMasa = (TextView) findViewById(R.id.tv_jangkaMasa);
        text_status = (TextView) findViewById(R.id.text_statusPermohonan);
        tv_status = (TextView) findViewById(R.id.tv_statusPermohonan);

        Intent i = getIntent();
        String idKeputusan = i.getStringExtra(ID_KEPUTUSAN);
        //Toast.makeText(this, idKeputusan, Toast.LENGTH_SHORT).show();
        getData(idKeputusan);

        //PermohonanData permohonanData[] = {new PermohonanData("ID Borang :","P14256"),new PermohonanData("Nama Dana :","Geran Universiti Penyelidikan"),new PermohonanData("Tajuk :","A Multimodal Adaptive Interface Design for Wearables to Support Tourism Augmented Reality"),new PermohonanData("Jangka Masa (Bulan) :","24"),new PermohonanData("Status Mohon :","\tTindakan Urusetia(untuk kelulusan)")};



      /*  permohonan_adapter = new PermohonanAdapter(permohonanData,PermohonanActivity.this);
        rv_permohonan.setAdapter(permohonan_adapter);*/
    }

    private void getData(String idKeputusan) {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/permohonan" + "/" + idKeputusan;

        Log.e("PermohonanActivity","getData");

        //create a json object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject= response.getJSONObject("permohonan");

                    String idBorang =jsonObject.getString("Id Borang");
                    String namaDana =jsonObject.getString("Id Dana");
                    String tajuk =jsonObject.getString("Tajuk");
                    String jangkaMasa =jsonObject.getString("Jangka Masa");
                    String statusPermohonan =jsonObject.getString("Status");

                    text_idPermohonan.setText("Id Borang");
                    tv_idPermohonan.setText(idBorang);
                    text_namaDana.setText("Nama Dana");
                    tv_namaDana.setText(namaDana);
                    text_tajuk.setText("Tajuk");
                    tv_tajuk.setText(tajuk);
                    text_jangkaMasa.setText("Jangka Masa");
                    tv_jangkaMasa.setText(jangkaMasa);
                    text_status.setText("Status");
                    tv_status.setText(statusPermohonan);

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

   /* private void parseData(JSONArray array) {
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

                Log.e("iklanFragment Response(" + array.length() + ")", idBorang +" - "+ tajuk );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            permohonanDataList.add(permohonan);
        }

        permohonan_adapter = new PermohonanAdapter(permohonanDataList,this);
        rv_permohonan.setAdapter(permohonan_adapter);

    }*/

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Log.e("perincian permohonan","back");
        onBackPressed();
        return null;
    }
}
