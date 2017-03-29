package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 1/13/2017.
 */
public class ProjectData {

    String nama,status,id_projek;

    public ProjectData() {
    }

    public ProjectData(String question, String answer,String id_projek) {
        this.nama = question;
        this.status = answer;
        this.id_projek = id_projek;
    }

    public String getId_projek() {
        return id_projek;
    }

    public void setId_projek(String id_projek) {
        this.id_projek = id_projek;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
