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

public class LaporanProjActivity extends AppCompatActivity {

    RecyclerView rv_laporanProj;
    RecyclerView.Adapter laporanProj_adapter;
    RecyclerView.LayoutManager laporanProj_layout;
    List<LaporanprojData>laporanprojDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_proj);

        rv_laporanProj = (RecyclerView) findViewById(R.id.rv_laporanproj);
        laporanProj_layout = new LinearLayoutManager(this);
        rv_laporanProj.setLayoutManager(laporanProj_layout);
        laporanprojDataList = new ArrayList<>();

        getData();

        //LaporanprojData laporanprojData[]={new LaporanprojData("Kod Projek :","TD-2016-003"),new LaporanprojData("Nama Dana :","Dana Penyelidikan TopDown"),new LaporanprojData("Tajuk :","UKM MOBILE APP"),new LaporanprojData("Tarikh Mula","01/05/2016"),new LaporanprojData("Tarikh Tamat :","31/10/2017"),new LaporanprojData("Status Projek :","Aktif"),new LaporanprojData("Laporan Kemajuan 1 :\n(01/05/2016 - 30/06/2016)", "Telah Diterima (Selesai)"),new LaporanprojData("Tempoh Penghantaran 1 :","01/07/2016 - 31/07/2016"),new LaporanprojData("Laporan Kemajuan 2 :\n(01/07/2016 - 31/12/2016)", "Belum Dihantar"),new LaporanprojData("Tempoh Penghantaran 2 :","01/01/2017 - 31/01/2017"),new LaporanprojData("Laporan Kemajuan 3 :\n(01/01/2017 - 30/06/2017)", "Belum Dihantar"),new LaporanprojData("Tempoh Penghantaran 3 :","01/07/2017 - 31/07/2017"),new LaporanprojData("Laporan Kemajuan Akhir :\n(01/05/2016 - 31/10/2017)", "Belum Dihantar"),new LaporanprojData("Tempoh Penghantaran Akhir :","01/11/2017 - 29/01/2018")};

       /* laporanProj_adapter =new LaporanProjAdapter(laporanprojData,LaporanProjActivity.this);
        rv_laporanProj.setAdapter(laporanProj_adapter);*/


    }

    private void getData() {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/laporan";

        Log.e("LaporanProjActivity","getData");

        //create a json object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray resultsArray = response.getJSONArray("laporan");
                    parseData(resultsArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("LaporanProjActivity", response.toString());
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
            LaporanprojData laporanProj = new LaporanprojData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String kodP =json.getString("Id Projek");
                String namaDana =json.getString("Id Dana");
                //String tajuk =json.getString("Id Projek");
                //String tarikhmulaprojek =json.getString("tarikhmulaprojek");
                //String Tarikhtamatprojek =json.getString("Tarikhtamatprojek");
                //String statusProjek =json.getString("Tarikhtamatprojek");
                String tmulalaporan1 =json.getString("Tarikh Mula Laporan");
                String takhirlaporan1 =json.getString("Tarikh Akhir Laporan");
                String tmulahantar1 =json.getString("Tarikh Mula Penghantar Laporan");
                String takhirhantar1 =json.getString("Tarikh Akhir Penghantar Laporan");
                String statuslaporan1 =json.getString("Status");
                /* String tmulalaporan2 =json.getString("Tarikh Mula Laporan");
                String takhirlaporan2 =json.getString("Tarikh Akhir Laporan");
                String tmulahantar2 =json.getString("Tarikh Mula Penghantar Laporan");
                String takhirhantar2 =json.getString("Tarikh Akhir Penghantar Laporan");
                String statuslaporan2 =json.getString("Status");
                String tmulalaporan3 =json.getString("Tarikh Mula Laporan");
                String takhirlaporan3 =json.getString("Tarikh Akhir Laporan");
                String tmulahantar3 =json.getString("Tarikh Mula Penghantar Laporan");
                String takhirhantar3 =json.getString("Tarikh Akhir Penghantar Laporan");
                String statuslaporan3 =json.getString("Status");*/


                laporanProj.setText_kodP("Kod Projek");
                laporanProj.setTv_kodP(kodP);
                laporanProj.setText_namaDana("Nama Dana");
                laporanProj.setTv_namaDana(namaDana);
                laporanProj.setText_tajuk("Tajuk");
                //laporanProj.setTv_tajuk(tajuk);
                laporanProj.setText_tmula("Tarikh Mula Projek");
                //laporanProj.setTv_tmula(tarikhmulaprojek);
                laporanProj.setText_ttamat("Tarikh Tamat Projek");
                //laporanProj.setTv_ttamat(Tarikhtamatprojek);
                laporanProj.setText_statusP("Status Projek");
                //laporanProj.setTv_statusP(statusProjek);
                //x de tajuk, tarikh mula projek,tarikh tamat projek dan status projek
                laporanProj.setText_tempohlaporan1("Tempoh Laporan 1");
                laporanProj.setTv_tempohlaporan1(tmulalaporan1 + " - " + takhirlaporan1 );
                laporanProj.setText_tpenghantaran1("Tempoh Penghantaran laporan kemajuan 1");
                laporanProj.setTv_tpenghantaran1(tmulahantar1 + " - " + takhirhantar1 );
                laporanProj.setText_statuslaporan1("Status Laporan Kemajuan 1");
                laporanProj.setTv_statuslaporan1(statuslaporan1);
                laporanProj.setText_tempohlaporan2("Tempoh Laporan kemajuan 2");
                //laporanProj.setTv_tempohlaporan2(tmulalaporan2 + " - " + takhirlaporan2 );
                laporanProj.setText_tpenghantaran2("Tempoh Penghantaran laporan kemajuan 2");
               // laporanProj.setTv_tpenghantaran2(tmulahantar2 + "-" + takhirhantar2 );
                laporanProj.setText_statuslaporan2("Status Laporan Kemajuan 2");
                //laporanProj.setTv_statuslaporan2(statuslaporan2);
                laporanProj.setText_tempohlaporan3("Tempoh Laporan kemajuan 3");
                //laporanProj.setTv_tempohlaporan3(tmulalaporan3 + " - " + takhirlaporan3 );
                laporanProj.setText_tpenghantaran3("Tempoh Penghantaran laporan kemajuan 3");
                // laporanProj.setTv_tpenghantaran3(tmulahantar3 + "-" + takhirhantar3 );
                laporanProj.setText_statuslaporan3("Status Laporan Kemajuan 3");
                //laporanProj.setTv_statuslaporan3(statuslaporan3);

                //Log.e("iklanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            laporanprojDataList.add(laporanProj);
        }

        laporanProj_adapter = new LaporanProjAdapter(laporanprojDataList,this);
        rv_laporanProj.setAdapter(laporanProj_adapter);

    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Log.e("Laporan Projek","back");
        onBackPressed();
        return null;
    }
}
