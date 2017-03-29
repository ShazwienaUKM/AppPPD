package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 1/13/2016.
 */
public class IklanData {

    String nama,status,id_dana;

    public IklanData() {
    }

    public IklanData(String question, String answer,String id_dana) {
        this.nama = question;
        this.status = answer;
        this.id_dana = id_dana;
    }

    public String getId_dana() {
        return id_dana;
    }

    public void setId_dana(String id_dana) {
        this.id_dana = id_dana;
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
