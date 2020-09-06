package com.project.gemastik.reminder.literasi;

import android.os.Parcel;
import android.os.Parcelable;

public class ArtikelItem implements Parcelable {

    private int posterEbook;
    private String namaEbook;
    private String pengarang;
    private String kategori;
    private String jmlHal;
    private String titleEbook;
    private String deskEbook;

    protected ArtikelItem(Parcel in) {
        posterEbook = in.readInt();
        namaEbook = in.readString();
        pengarang = in.readString();
        kategori = in.readString();
        jmlHal = in.readString();
        titleEbook = in.readString();
        deskEbook = in.readString();
    }

    public static final Creator<ArtikelItem> CREATOR = new Creator<ArtikelItem>() {
        @Override
        public ArtikelItem createFromParcel(Parcel in) {
            return new ArtikelItem(in);
        }

        @Override
        public ArtikelItem[] newArray(int size) {
            return new ArtikelItem[size];
        }
    };

    public int getPosterEbook() {
        return posterEbook;
    }

    public void setPosterEbook(int posterEbook) {
        this.posterEbook = posterEbook;
    }

    public String getNamaEbook() {
        return namaEbook;
    }

    public void setNamaEbook(String namaEbook) {
        this.namaEbook = namaEbook;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJmlHal() {
        return jmlHal;
    }

    public void setJmlHal(String jmlHal) {
        this.jmlHal = jmlHal;
    }

    public String getDeskEbook() {
        return deskEbook;
    }

    public void setDeskEbook(String deskEbook) {
        this.deskEbook = deskEbook;
    }

    public ArtikelItem(int posterEbook, String namaEbook, String pengarang, String kategori, String jmlHal, String deskEbook) {
        this.posterEbook = posterEbook;
        this.namaEbook = namaEbook;
        this.pengarang = pengarang;
        this.kategori = kategori;
        this.jmlHal = jmlHal;
        this.deskEbook = deskEbook;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(posterEbook);
        parcel.writeString(namaEbook);
        parcel.writeString(pengarang);
        parcel.writeString(kategori);
        parcel.writeString(jmlHal);
        parcel.writeString(titleEbook);
        parcel.writeString(deskEbook);
    }
}
