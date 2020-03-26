package com.example.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int poster;
    private String judul;
    private String desc;
    private String tanggal;
    private String cast;

    public Movie() {

    }

    public String getCast() { return cast; }

    public void setCast(String cast) { this.cast = cast; }

    public String getTanggal() { return tanggal; }

    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Movie(Parcel in){
        judul = in.readString();
        poster = in.readInt();
        desc = in.readString();
        tanggal = in.readString();
        cast = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeInt(poster);
        dest.writeString(desc);
        dest.writeString(tanggal);
        dest.writeString(cast);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
