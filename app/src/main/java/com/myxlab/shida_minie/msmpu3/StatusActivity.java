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

import static com.myxlab.shida_minie.msmpu3.ProjectAdapter.ID_PROJEK;

public class StatusActivity extends AppCompatActivity {

    /*RecyclerView rv_status;
    RecyclerView.LayoutManager statusLayout;
    RecyclerView.Adapter status_adapter;
    List<StatusData>statusDataList;*/

    TextView text_kodP,tv_kodP,text_namaDana,tv_namaDana,text_tajuk,tv_tajuk,text_peranan,tv_peranan,text_ketuaP,tv_ketuaP,text_tmula,tv_tmula,text_ttamat,tv_ttamat,text_status,tv_status;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

     /*   rv_status= (RecyclerView) findViewById(R.id.rv_status);
        statusLayout = new LinearLayoutManager(this);
        rv_status.setLayoutManager(statusLayout);
        statusDataList = new ArrayList<>();*/

        text_kodP = (TextView) findViewById(R.id.text_kodP);
        tv_kodP = (TextView) findViewById(R.id.tv_kodP);
        text_namaDana = (TextView) findViewById(R.id.text_namaDana);
        tv_namaDana = (TextView) findViewById(R.id.tv_namaDana);
        text_tajuk = (TextView) findViewById(R.id.text_tajuk);
        tv_tajuk = (TextView) findViewById(R.id.tv_tajuk);
        text_peranan = (TextView) findViewById(R.id.text_peranan);
        tv_peranan = (TextView) findViewById(R.id.tv_peranan);
        text_ketuaP = (TextView) findViewById(R.id.text_ketuaP);
        tv_ketuaP = (TextView) findViewById(R.id.tv_ketuaP);
        text_tmula = (TextView) findViewById(R.id.text_tmula);
        tv_tmula = (TextView) findViewById(R.id.tv_tmula);
        text_ttamat = (TextView) findViewById(R.id.text_ttamat);
        tv_ttamat = (TextView) findViewById(R.id.tv_ttamat);
        text_status = (TextView) findViewById(R.id.text_statusP);
        tv_status = (TextView) findViewById(R.id.tv_statusP);

        Intent i = getIntent();
        String idprojek = i.getStringExtra(ID_PROJEK);
        //Toast.makeText(this, idprojek, Toast.LENGTH_SHORT).show();
        getData(idprojek);

       // StatusData statusData[]={new StatusData("Kod Projek :","AP-2013-011"),new StatusData("Nama Dana :","Projek Arus Perdana"),new StatusData("Tajuk :","Mobile Sensing Technology for Augmented Reality and Medical Application"),new StatusData("Peranan :","Ketua Projek"),new StatusData("Ketua Projek :","K009683 HASLINA BINTI ARSHAD"),new StatusData("Tarikh Mula :","01/11/2013"),new StatusData("Tarikh Tamat :","30/04/2017"),new StatusData("Status Projek :","Aktif")};

        /*status_adapter = new  StatusAdapter(statusData,StatusActivity.this);
        rv_status.setAdapter(status_adapter);*/
    }

    private void getData(String idProjek) {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/projek" + "/" + idProjek;

        Log.e("StatusActivity","getData");

        //create a json object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject = response.getJSONObject("projek");

                    String kodProjek =jsonObject.getString("Id Projek");
                    String namaDana =jsonObject.getString("Id Dana");
                    String tajuk =jsonObject.getString("Nama Projek");
                    String peranan =jsonObject.getString("Id Penyelidik");
                    String ketuaProjek =jsonObject.getString("Ketua Projek");
                    String tarikhmula =jsonObject.getString("Tarikh Mula");
                    String tarikhtamat =jsonObject.getString("Tarikh Tamat");
                    String statusProjek =jsonObject.getString("Status");


                    text_kodP.setText("Kod Projek");
                    tv_kodP.setText(kodProjek);
                    text_namaDana.setText("Nama Dana");
                    tv_namaDana.setText(namaDana);
                    text_tajuk.setText("Tajuk");
                    tv_tajuk.setText(tajuk);
                    text_peranan.setText("Peranan");
                    tv_peranan.setText(peranan);
                    text_ketuaP.setText("Ketua Projek");
                    tv_ketuaP.setText(ketuaProjek);
                    text_tmula.setText("Tarikh Mula");
                    tv_tmula.setText(tarikhmula);
                    text_ttamat.setText("Tarikh Tamat");
                    tv_ttamat.setText(tarikhtamat);
                    text_status.setText("Status");
                    tv_status.setText(statusProjek);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("StatusActivity", response.toString());
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

    /*private void parseData(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            StatusData status = new StatusData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String kodProjek =json.getString("Id Projek");
                String namaDana =json.getString("Id Dana");
                String tajuk =json.getString("Nama Projek");
                String peranan =json.getString("Id Penyelidik");
                String ketuaProjek =json.getString("Ketua Projek");
                String tarikhmula =json.getString("Tarikh Mula");
                String tarikhtamat =json.getString("Tarikh Tamat");
                String statusProjek =json.getString("Status");


                status.setText_kodP("Kod Projek");
                status.setTv_kodP(kodProjek);
                status.setText_namaDana("Nama Dana");
                status.setTv_namaDana(namaDana);
                status.setText_tajuk("Tajuk");
                status.setTv_tajuk(tajuk);
                status.setText_peranan("Peranan");
                status.setTv_peranan(peranan);
                status.setText_ketuaP("Ketua Projek");
                status.setTv_ketuaP(ketuaProjek);
                status.setText_tmula("Tarikh Mula");
                status.setTv_tmula(tarikhmula);
                status.setText_ttamat("Tarikh Tamat");
                status.setTv_ttamat(tarikhtamat);
                status.setText_status("Status");
                status.setTv_status(statusProjek);

                //Log.e("iklanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            statusDataList.add(status);
        }

        status_adapter = new  StatusAdapter(statusDataList,StatusActivity.this);
        rv_status.setAdapter(status_adapter);

    }
*/

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Log.e("status","back");
        onBackPressed();
        return null;
//        return super.getSupportParentActivityIntent();
    }
}
