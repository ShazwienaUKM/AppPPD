package com.myxlab.shida_minie.msmpu3;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
 * Created by User on 1/4/2016.
 */
public class KeputusanFragment extends Fragment {
    View myView;
    RecyclerView rv_Keputusan;
    RecyclerView.Adapter keputusan_adapter;
    List<keputusanData>keputusanDataList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.keputusan_layout,container,false);

        //step2 : initialize
        rv_Keputusan = (RecyclerView) myView.findViewById(R.id.rv_keputusan);
        keputusanDataList = new ArrayList<>();

        getData();

       /* String x = "Tindakan Urusetia";
        String y = "Tidak Lulus";
        String z = "Lulus";

        keputusanData senaraiKeputusan[]={
                new keputusanData("A Multimodal Adaptive Interface Design for Wearables to Support Tourism Augmented Reality",x),
                new keputusanData("A Hybrid Approach on Reconstruction of Three-Dimensional (3D) Microwave Imaging",x),
                new keputusanData("Reconstruction of Microwave Imaging using Hybrid Approach",y)};*/


        rv_Keputusan.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        // getActivity().getApplicationContext() --> method untuk dapatkan context.



        //((NavActivity) getActivity()).setActionBarTitle("Senarai Permohonan");

        return myView;
    }

    private void getData() {

        final ProgressDialog loading = ProgressDialog.show(getContext(), "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/permohonan";

        Log.e("KeputusanFragment","getData");

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
                Log.e("KeputusanFragment", response.toString());
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
            keputusanData keputusan = new keputusanData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String dataName =json.getString("Tajuk");
                String dataStatus =json.getString("Status");

                keputusan.setNama(dataName);
                keputusan.setStatus(dataStatus);

                Log.e("KeputusanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            keputusanDataList.add(keputusan);
        }

        keputusan_adapter = new keputusanAdapter(getActivity(),keputusanDataList);
        rv_Keputusan.setAdapter(keputusan_adapter);

    }


}
