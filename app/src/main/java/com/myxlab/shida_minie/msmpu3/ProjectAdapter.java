package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 12/15/2016.
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {


    public static final String ID_PROJEK = "ID_PROJEK";
    public Context contextProject;
    List<ProjectData>projectDataList;

    String v = "";
    String a = "Aktif";
    String t = "Tidak Aktif";

    public ProjectAdapter(Context context, List<ProjectData>projectDataList) {
        this.contextProject = context;
        this.projectDataList = projectDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_project, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ProjectData projectData = projectDataList.get(position);

        holder.tv_project.setText(projectData.getNama());
        holder.tv_statusProject.setText(projectData.getStatus());

        v = holder.tv_statusProject.getText().toString();
        Log.i("tv_statusProject :",v);

        if (v.equals(a))
        {
            holder.tv_statusProject.setTextColor(Color.parseColor("#218905"));

        }else if (v.equals(t))
        {
            holder.tv_statusProject.setTextColor(Color.parseColor("#DA1322"));
        }
    }

    @Override
    public int getItemCount() {
        return projectDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_project,tv_statusProject,tv_idprojek;

        public ViewHolder(View projectView) {
            super(projectView);

            tv_project = (TextView) projectView.findViewById(R.id.project_title);
            tv_statusProject = (TextView) projectView.findViewById(R.id.status_project_title);
            tv_idprojek = (TextView) projectView.findViewById(R.id.id_projek);

            projectView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent i = new Intent(contextProject,StatusActivity.class);
                    i.putExtra(ID_PROJEK,projectDataList.get(position).getId_projek());
                    view.getContext().startActivity(i);
                }
            });

        }
    }
}
