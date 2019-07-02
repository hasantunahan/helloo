package com.example.hello.hello.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "urunler")
public class Urunler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String urunadi;
    private float urunfiyati;
    private int urunadedi;
    private String urunkategori;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public float getUrunfiyati() {
        return urunfiyati;
    }

    public void setUrunfiyati(float urunfiyati) {
        this.urunfiyati = urunfiyati;
    }

    public int getUrunadedi() {
        return urunadedi;
    }

    public void setUrunadedi(int urunadedi) {
        this.urunadedi = urunadedi;
    }

    public String getUrunkategori() {
        return urunkategori;
    }

    public void setUrunkategori(String urunkategori) {
        this.urunkategori = urunkategori;
    }

   /* @OneToMany
    @JoinColumn(name = "satisid")
    private Set<Satis> satisurunu;
*/
}
