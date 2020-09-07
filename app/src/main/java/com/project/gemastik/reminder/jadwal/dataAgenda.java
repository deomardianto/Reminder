package com.project.gemastik.reminder.jadwal;

public class dataAgenda {
    String judul, waktu, timeStamp;

    public dataAgenda(){

    }

    public dataAgenda(String judul, String waktu, String timeStamp){
        this.judul = judul;
        this.waktu = waktu;
        this.timeStamp = timeStamp;
    }

    public String getJudul(){return judul;}
    public void setJudul(){this.judul = judul;}

    public  String getWaktu(){return waktu;}
    public  void setWaktu(){this.waktu = waktu;}

    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
