package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 12/19/2016.
 */
public class keputusanData {

    String nama,status,id_keputusan;

    public keputusanData() {
    }

    public keputusanData(String question, String answer,String id_keputusan) {
        this.nama = question;
        this.status = answer;
        this.id_keputusan = id_keputusan;
    }

    public String getId_keputusan() {
        return id_keputusan;
    }

    public void setId_keputusan(String id_keputusan) {
        this.id_keputusan = id_keputusan;
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
