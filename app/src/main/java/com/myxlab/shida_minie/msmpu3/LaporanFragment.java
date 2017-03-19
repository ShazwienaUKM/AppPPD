package com.myxlab.shida_minie.msmpu3;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by User on 1/5/2017.
 */
public class LaporanFragment extends Fragment {
    View myView;
    RecyclerView rv_Laporan;
    RecyclerView.Adapter laporan_adapter;
    List<LaporanData> laporanDataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.laporan_layout,container,false);

        //step2 : initialize
        rv_Laporan = (RecyclerView) myView.findViewById(R.id.rv_laporan);

        laporanDataList = new ArrayList<>();

        getData();

        String s = "Selesai";
        String b = "Belum Selesai";

        LaporanData senaraiLaporan[]={new LaporanData("UKM MOBILE APP",b),
                new LaporanData("Mobile Sensing Technology for Augmented Reality and Medical Application",b),
                new LaporanData("Development of Mobile Sensing Technology for Medical Application",s)};


        rv_Laporan.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        // getActivity().getApplicationContext() --> method untuk dapatkan context.
        
        /*laporan_adapter = new laporanAdapter(getActivity(),senaraiLaporan);
        rv_Laporan .setAdapter(laporan_adapter);*/

        //((NavActivity) getActivity()).setActionBarTitle("Senarai Laporan Projek");

        return myView;
    }

    private void getData() {

        final ProgressDialog loading = ProgressDialog.show(getContext(),"Loading data", "Please wait ...",false,true);
        String url ="http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/laporan";

        Log.e("LaporanFragment","getData");

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
                Log.e("LaporanFragment", response.toString());
                loading.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.toString());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
    }

    private void parseData(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            LaporanData laporan = new LaporanData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String dataName =json.getString("Id Projek");
                String dataStatus =json.getString("Status");

                laporan.setNama(dataName);
                laporan.setStatus(dataStatus);

                Log.e("LaporanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            laporanDataList.add(laporan);
        }

        laporan_adapter = new laporanAdapter(getActivity(),laporanDataList);
        rv_Laporan.setAdapter(laporan_adapter);
    }


}
