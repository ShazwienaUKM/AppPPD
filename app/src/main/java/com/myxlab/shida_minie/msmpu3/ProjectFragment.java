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
 * Created by User on 12/20/2016.
 */
public class ProjectFragment extends Fragment {
    View myView;
    RecyclerView rv_project;
    RecyclerView.Adapter project_adapter;
    List<ProjectData>projectDataList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.project_layout,container,false);

        //step2 : initialize
        rv_project = (RecyclerView) myView.findViewById(R.id.rv_project);
        projectDataList = new ArrayList<>();

        getData();

       /* String a = "Aktif";
        String t = "Tidak Aktif";

        ProjectData senaraiProject[] = {new ProjectData("Mobile Sensing Technology for Augmented Reality and Medical Application",a),
                new ProjectData("UKM MOBILE APP",a),
                new ProjectData("Serious Games for Cognitive Rehabilitation System",a),
                new ProjectData("Kajian tindakan bagi meningkatkan keupayaan guru pra-sekolah dalam pengajaran Bahasa Inggeris menggunakan kaedah multimodal berasaskan teknologi mudah alih realiti luasan",t),
                new ProjectData("Pembangunan Sistem Pengurusan Kurikulum Siswazah yang Komprehensif dan Sistematik",t)};*/


        rv_project.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        // getActivity().getApplicationContext() --> method untuk dapatkan context.

/*        project_adapter = new ProjectAdapter(getActivity(),senaraiProject);
        rv_project .setAdapter(project_adapter);*/

        //((NavActivity) getActivity()).setActionBarTitle("Senarai Projek");

        return myView;
    }

    private void getData() {

        final ProgressDialog loading = ProgressDialog.show(getContext(),"Loading data", "Please wait ...",false,true);
        String url ="http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/projek";

        Log.e("ProjectFragment","getData");

        //create a json object request

        JsonObjectRequest  jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray resultsArray = response.getJSONArray("projek");
                    parseData(resultsArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("ProjekFragment", response.toString());
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
            ProjectData project = new ProjectData();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                String idprojek = json.getString("Id");
                String dataName =json.getString("Nama Projek");
                String dataStatus =json.getString("Status");

                project.setId_projek(idprojek);
                project.setNama(dataName);
                project.setStatus(dataStatus);

                Log.e("KeputusanFragment Response(" + array.length() + ")", dataName +" - "+ dataStatus );
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            projectDataList.add(project);
        }

        project_adapter = new ProjectAdapter(getActivity(),projectDataList);
        rv_project.setAdapter(project_adapter);
    }

}
