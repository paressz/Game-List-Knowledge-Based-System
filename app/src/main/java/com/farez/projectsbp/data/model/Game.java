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
        list.add(new GameBuilder()
                .setNama("League of Legends")
                .setCpu("Intel Core i3-530 / AMD A6-3650")
                .setRam(4)
                .setHdd(16)
                .setVga("any")
                .setDeskripsi("LOL")
                .setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("Counter Strike 2")
                .setCpu("Intel Core i5-750")
                .setRam(8)
                .setHdd(85)
                .setVga("any, need 1gb or more vram")
                .setDeskripsi("For over two decades, Counter-Strike has offered an elite competitive experience, " +
                        "one shaped by millions of players from across the globe. And now the next chapter in the CS " +
                        "story is about to begin. This is Counter-Strike 2.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/730/header.jpg?t=1696359298")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("The Sims™ 4")
                .setCpu("Intel Core i3-3220 / AMD Ryzen 3 1200")
                .setRam(4)
                .setHdd(26)
                .setVga("any,need at least 128mb of vram")
                .setDeskripsi("Play with life and discover the possibilities. Unleash your imagination and create a world of Sims that’s wholly unique. Explore and customize every detail from Sims to homes–and much more.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/1222670/header.jpg")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("Apex Legends™")
                .setCpu("Intel Core i3 6300 / AMD FX 4350")
                .setRam(6)
                .setHdd(56)
                .setVga("AMD Radeon™ HD 7730, NVIDIA GeForce® GT 640")
                .setDeskripsi("Apex Legends is the award-winning, free-to-play Hero Shooter from Respawn Entertainment." +
                        " Master an ever-growing roster of legendary characters with powerful abilities, and " +
                        "experience strategic squad play and innovative gameplay in the next evolution of Hero Shooter" +
                        " and Battle Royale.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/1172470/header.jpg")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("Team Fortress 2")
                .setCpu("Intel Core i3 or AMD")
                .setRam(1)
                .setHdd(15)
                .setVga("any, need at least 512gb of vram")
                .setDeskripsi("Nine distinct classes provide a broad range of tactical abilities and personalities. " +
                        "Constantly updated with new game modes, maps, equipment and, most importantly, hats!")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/440/header.jpg")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("PUBG: BATTLEGROUNDS")
                .setCpu("Intel Core i5-4430 / AMD FX-6300")
                .setRam(8)
                .setHdd(40)
                .setVga("NVIDIA GeForce GTX 960 2GB / AMD Radeon R7 370 2GB")
                .setDeskripsi("Play PUBG: BATTLEGROUNDS for free.\n" +
                        "Land on strategic locations, loot weapons and supplies, and survive to become the last team " +
                        "standing across various, diverse Battlegrounds.\n" +
                        "Squad up and join the Battlegrounds for the original Battle Royale experience that only " +
                        "PUBG: BATTLEGROUNDS can offer.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/578080/header.jpg")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("War Thunder")
                .setCpu("Intel Core i5 or Ryzen 5 3600")
                .setRam(4)
                .setHdd(95)
                .setVga("Nvidia GeForce 1060, Radeon RX 570")
                .setDeskripsi("War Thunder is the most comprehensive free-to-play, cross-platform, MMO military game " +
                        "dedicated to aviation, armoured vehicles, and naval craft, from the early 20th century to the" +
                        " most advanced modern combat units. Join now and take part in major battles on land, in the " +
                        "air, and at sea.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/236390/header.jpg")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("World of Warships")
                .setCpu("Intel® Core™ i3-3210 @ 3.2GHz, AMD Athlon™ II X2 245 @ 2.9 GHz")
                .setRam(6)
                .setHdd(61)
                .setVga("NVIDIA® GeForce® GT 640, AMD Radeon™ R7 240, Intel® HD 4000")
                .setDeskripsi("Immerse yourself in thrilling naval battles and assemble an armada of over 600 ships from the first half of the 20th century — from stealthy destroyers to gigantic battleships. Change the look of your ship, choose upgrades to suit your play style, and go into battle with other players!")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/552990/header.jpg")
                .setIsGameDewasa(false).createGame());
        list.add(new GameBuilder()
                .setNama("GTA V")
                .setCpu("Intel Core 2 Quad CPU Q6600 / AMD Phenom 9850")
                .setRam(4)
                .setHdd(72)
                .setVga("NVIDIA 9800 GT 1GB / AMD HD 4870 1GB")
                .setDeskripsi("Grand Theft Auto V for PC offers players the option to explore the award-winning world of Los " +
                        "Santos and Blaine County in resolutions of up to 4k and beyond, as well as the chance to experience the " +
                        "game running at 60 frames per second.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/271590/header.jpg")
                .setIsGameDewasa(true).createGame());
        list.add(
                new GameBuilder()
                .setNama("DARK SOULS™: REMASTERED")
                .setCpu("Intel Core i5-2300 2.8 GHz / AMD FX-6300, 3.5 GHz")
                .setRam(6)
                .setHdd(8)
                .setVga(" GeForce GTX 460, 1 GB / Radeon HD 6870, 1 GB")
                .setDeskripsi("Then, there was fire. Re-experience the critically acclaimed, genre-defining game that " +
                        "started it all. Beautifully remastered, return to Lordran in stunning high-definition detail " +
                        "running at 60fps.")
                .setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/570940/header.jpg")
                .setIsGameDewasa(false)
                .createGame());
        return list;
    }
}
