package com.myxlab.shida_minie.msmpu3;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * Created by User on 1/3/2017.
 */
public class IklanFragment extends android.support.v4.app.Fragment {

    View myView;
    RecyclerView rv_Iklan;
    RecyclerView.Adapter iklan_adapter;
    List<IklanData>iklanDataList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.iklan_layout,container,false);

        //step2 : initialize
        rv_Iklan = (RecyclerView) myView.findViewById(R.id.rv_iklan);
        iklanDataList = new ArrayList<>();
        rv_Iklan.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        getData();

      /*  String s= "Sedang Iklan";
        String t= "Telah Tamat";

        IklanData senaraiDana[] = {new IklanData("Dana Penyelidikan Top Down",s),
                new IklanData("Geran Galakan Penyelidikan Muda",s),
                new IklanData("Projek Arus Perdana",t),
                new IklanData("Dana Impak Perdana",t),
                new IklanData("Projek Tindakan/Strategi",t),
                new IklanData("Geran Universiti Penyelidikan",t)};*/



        // getActivity().getApplicationContext() --> method untuk dapatkan context.

/*        iklan_adapter = new iklanAdapter(getActivity(),senaraiDana);
        rv_Iklan .setAdapter(iklan_adapter);*/

      //  ((NavActivity) getActivity()).setActionBarTitle("Senarai Iklan");

        return myView;
    }

    private void getData(){
        // url - http://pokesnipers.com/api/v1/pokemon.json
        final ProgressDialog loading = ProgressDialog.show(getContext(), "Loading Data", "Please Wait...", false, true);
        String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/dana/";

        Log.e("IklanFragment","getData");

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
                Log.e("IklanFragment", response.toString());
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
            IklanData iklan = new IklanData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String dataName =json.getString("Nama Geran");
                String dataStatus =json.getString("Status");

                iklan.setNama(dataName);
                iklan.setStatus(dataStatus);

                Log.e("iklanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            iklanDataList.add(iklan);
        }

        iklan_adapter = new iklanAdapter(getActivity(),iklanDataList);
        rv_Iklan.setAdapter(iklan_adapter);

    }
}
