package com.example.hello.hello.service;


import com.example.hello.hello.model.Urunler;

import java.util.List;

public interface UrunlerService {


    Urunler findByUrunadedi(int adet);
   List<Urunler> findByUrunadi(String name);


}

