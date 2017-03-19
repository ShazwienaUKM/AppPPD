package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 12/19/2016.
 */
public class keputusanData {

    String nama,status;

    public keputusanData() {
    }

    public keputusanData(String question, String answer) {
        this.nama = question;
        this.status = answer;
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
