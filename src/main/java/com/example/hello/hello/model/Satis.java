package com.example.hello.hello.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "satis")
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long satisid;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Musteri musteri;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Urunler urunler;

    private Date satistarihi;

    String tip;

    private float fiyat;

    private int adetler;

    private float toplamfiyat;



    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public long getSatisid() {
        return satisid;
    }

    public void setSatisid(long satisid) {
        this.satisid = satisid;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Urunler getUrunler() {
        return urunler;
    }

    public void setUrunler(Urunler urunler) {
        this.urunler = urunler;
    }

    public float getToplamfiyat() {
        return toplamfiyat;
    }

    public void setToplamfiyat(float toplamfiyat) {
        this.toplamfiyat = toplamfiyat;
    }

    public int getAdetler() {
        return adetler;
    }

    public void setAdetler(int adetler) {
        this.adetler = adetler;
    }



    public Date getSatistarihi() {
        return satistarihi;
    }

    public void setSatistarihi(Date satistarihi) {
        this.satistarihi = satistarihi;
    }
}
