package com.farez.projectsbp.data.model;

public class GameBuilder {
    private String nama;
    private String cpu;
    private String ram;
    private String hdd;
    private String vga;
    private String deskripsi;
    private String imageUrl;
    private boolean isGameDewasa;

    public GameBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public GameBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public GameBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public GameBuilder setHdd(String hdd) {
        this.hdd = hdd;
        return this;
    }

    public GameBuilder setVga(String vga) {
        this.vga = vga;
        return this;
    }

    public GameBuilder setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    public GameBuilder setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public GameBuilder setIsGameDewasa(boolean isGameDewasa) {
        this.isGameDewasa = isGameDewasa;
        return this;
    }

    public Game createGame() {
        return new Game(nama, cpu, ram, hdd, vga, deskripsi, imageUrl, isGameDewasa);
    }
}