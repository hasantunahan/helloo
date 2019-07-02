package com.example.hello.hello.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    private String username;
    private String parola;
    private String isim;
    private String soyisim;
    private String mail;

    @ManyToMany
    @Getter @Setter private Set<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String username, String parola, String isim, String soyisim, String mail) {
        this.username = username;
        this.parola = parola;
        this.isim = isim;
        this.soyisim = soyisim;
        this.mail = mail;
    }

    public User(String username, String parola, String isim, String soyisim, String mail, Set<Role> roles) {
        this.username = username;
        this.parola = parola;
        this.isim = isim;
        this.soyisim = soyisim;
        this.mail = mail;
        this.roles = roles;
    }

}