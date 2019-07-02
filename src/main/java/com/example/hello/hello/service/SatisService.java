package com.example.hello.hello.service;


import com.example.hello.hello.model.Satis;
import com.example.hello.hello.model.Urunler;
import com.example.hello.hello.repositories.SatisRepository;
import com.example.hello.hello.repositories.UrunlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatisService{
    @Autowired
    SatisRepository satisRepository;

    public Satis save(Satis satis){
        return satisRepository.save(satis);
    }

    public List<Satis> findAll(){
        return satisRepository.findAll();
    }

}
