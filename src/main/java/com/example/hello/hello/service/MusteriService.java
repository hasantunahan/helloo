package com.example.hello.hello.service;

import com.example.hello.hello.model.Musteri;
import com.example.hello.hello.repositories.MusteriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusteriService {

    @Autowired
    MusteriRepository musteriRepositor;

    public Musteri save(Musteri musteri){
        return musteriRepositor.save(musteri);
    }

    public List<Musteri> findAll(){
        return musteriRepositor.findAll();
    }

    public Musteri findOne(long id){
        return musteriRepositor.getOne(id);
    }

    public void delete(Musteri musteri){
        musteriRepositor.delete(musteri);
    }

}
