package com.farez.projectsbp.data.model;

import java.io.Serializable;

public class Game implements Serializable {
    public String nama, cpu, ram, hdd, vga, deskripsi, imageUrl;

    public Game(String nama, String cpu, String ram, String hdd, String vga, String deskripsi, String imageUrl) {
        this.nama = nama;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.vga = vga;
        this.deskripsi = deskripsi;
        this.imageUrl = imageUrl;
    }
}
