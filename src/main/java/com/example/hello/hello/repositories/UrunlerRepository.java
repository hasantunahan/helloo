package com.example.hello.hello.repositories;

import com.example.hello.hello.model.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrunlerRepository extends JpaRepository<Urunler,Long> {
    Urunler findByUrunadedi(int adet);
    List<Urunler> findByUrunadi(String name);

}