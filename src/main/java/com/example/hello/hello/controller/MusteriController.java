package com.example.hello.hello.controller;

import com.example.hello.hello.model.Musteri;
import com.example.hello.hello.model.Urunler;
import com.example.hello.hello.service.MusteriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MusteriController {
    @Autowired
    MusteriService musteriService;

    @RequestMapping(value = "/musteri",method = RequestMethod.GET)
    public ModelAndView yeniMusteri(ModelMap model) {
        Musteri musteri=new Musteri();
        model.addAttribute("musterilist",musteri);
        List<Musteri> liste=musteriService.findAll();
        return new ModelAndView("musteri","list",liste);
    }

    @RequestMapping(value = "/musterikaydet",method = RequestMethod.POST)
    public String musteriKaydet(@Valid Musteri musteri, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "musteri";
        }
        musteriService.save(musteri);
        return "redirect:/musteri";
    }

    @RequestMapping(value="/editmusteri/{id}",method = RequestMethod.GET)
    public String editMusteri (@PathVariable long id, ModelMap model){
        Musteri musteri=musteriService.findOne(id);
        model.addAttribute("musterilist",musteri);
        return "editmusteri";
    }

    @RequestMapping(value = "/editMusteriKaydet",method = RequestMethod.POST)
    public ModelAndView editsaveMusteri(@ModelAttribute("musterilist")Musteri p){
        Musteri musteri=musteriService.findOne(p.getId());
        musteri.setAd(p.getAd());
        musteri.setAdres(p.getAdres());
        musteri.setTelno(p.getTelno());
        musteri.setVergino(p.getVergino());
        musteriService.save(musteri);
        return new ModelAndView("redirect:/musteri");
    }

    @RequestMapping(value = "/deleteMusteri/{id}",method = RequestMethod.GET)
    public ModelAndView deletemusteri(@PathVariable long id){
        Musteri musteri=musteriService.findOne(id);
        musteriService.delete(musteri);
        return new ModelAndView("redirect:/musteri");
    }

}
