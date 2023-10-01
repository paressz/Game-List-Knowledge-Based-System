package com.farez.projectsbp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game implements Serializable {
    @ColumnInfo(name = "nama")
    String nama;
    @ColumnInfo(name = "cpu")
    String cpu;
    @ColumnInfo(name = "ram")
    int ram;
    @ColumnInfo(name = "hdd")
    int hdd;
    @ColumnInfo(name = "vga")
    String vga;
    @ColumnInfo(name = "deskripsi")
    String deskripsi;
    @ColumnInfo(name = "imageUrl")
    String imageUrl;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "isGameDewasa")
    boolean isGameDewasa;


    public Game(String nama, String cpu, int ram, int hdd, String vga, String deskripsi, String imageUrl, boolean isGameDewasa) {
        this.nama = nama;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.vga = vga;
        this.deskripsi = deskripsi;
        this.imageUrl = imageUrl;
        this.isGameDewasa = isGameDewasa;
    }

    //GETTER AND SETTER BUAT SEMUA PROPERTI KECUALI ID

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isGameDewasa() {
        return isGameDewasa;
    }

    public void setGameDewasa(boolean gameDewasa) {
        isGameDewasa = gameDewasa;
    }

    public static List<Game> sampleGameList() {
        List<Game> list = new ArrayList<Game>();
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(4).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(2).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/730/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(2).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/236390/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(8).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/1172470/header.jpg").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(2).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/578080/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(2).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(16).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(2).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/552990/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(2).setHdd(16).setVga("any").setDeskripsi("LOL").setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png").setIsGameDewasa(true).createGame());
        list.add(
                new GameBuilder()
                .setNama("League of Legends")
                .setCpu("Intel Core i3-530 / AMD A6-3650")
                .setRam(2)
                .setHdd(16)
                .setVga("RTX 69420")
                .setDeskripsi("LOL adalah lol")
                .setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png")
                .setIsGameDewasa(true)
                .createGame());
        return list;
    }
}
