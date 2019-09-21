package com.example.user.myapplication;

public class Mahasiswa {

    private long id;
    private String nama_mhs;
    private String nim;
    private String jurusan;

    public Mahasiswa(){

    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getNama_mhs(){
        return nama_mhs;
    }

    public void setNama_mhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

    public String getNim(){
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan(){
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString(){
        return "Mahasiswa "+ nama_mhs +" "+ nim +" "+ jurusan;
    }
}
