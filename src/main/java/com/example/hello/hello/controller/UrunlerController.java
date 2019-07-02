package com.example.hello.hello.controller;

import com.example.hello.hello.model.Urunler;
import com.example.hello.hello.service.UrunlerService;
import com.example.hello.hello.service.UrunlerServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UrunlerController {

    @Autowired
    UrunlerServiceimpl urunlerService;

    @RequestMapping(value = "/urunler", method = RequestMethod.GET)
    public ModelAndView yeniUrun(ModelMap model) {
        Urunler urunler = new Urunler();
        List<Urunler> liste = (List<Urunler>) urunlerService.findAll();
        //    System.out.println("HASO"+name);
        model.addAttribute("urunlist", urunler);
        return new ModelAndView("urunler", "list", liste);
    }


    @RequestMapping(value = "/urunlerara", method = RequestMethod.GET)
    public ModelAndView yeniAra(ModelMap model, @RequestParam("urunadi") String name) {
        Urunler urunler = new Urunler();
        List<Urunler> liste = urunlerService.findByUrunadi(name);
        System.out.println("listemiz" + liste);
        System.out.println("HASO" + name);
        model.addAttribute("urunlist", urunler);
        return new ModelAndView("urunler", "list", liste);
    }


    @RequestMapping(value = "/urunkaydet", method = RequestMethod.POST)
    public String urunKaydet(@Valid Urunler urunler, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "urunler";
        }
        urunlerService.save(urunler);
        return "redirect:/urunler";
    }

    @RequestMapping(value = "/editurunler/{id}")
    public String edit(@PathVariable long id, ModelMap model) {
        Urunler urunler = urunlerService.findOne(id);
        model.addAttribute("urunlist", urunler);
        return "editurunler";
    }

    @RequestMapping(value = "/editurunKaydet", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("urunlist") Urunler p) {
        Urunler urunler = urunlerService.findOne(p.getId());
        urunler.setUrunadi(p.getUrunadi());
        urunler.setUrunadedi(p.getUrunadedi());
        urunler.setUrunfiyati(p.getUrunfiyati());
        urunler.setUrunkategori(p.getUrunkategori());
        urunlerService.save(urunler);
        return new ModelAndView("redirect:/urunler");
    }

    @RequestMapping(value = "/deleteUrun/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUrun(@PathVariable long id) {
        Urunler urunler = urunlerService.findOne(id);
        urunlerService.delete(urunler);
        return new ModelAndView("redirect:/urunler");
    }

    @ModelAttribute("kategoriler")
    public List<String> kategoriler() {
        List<String> liste = new ArrayList<String>();
        liste.add("Bilgisayar");
        liste.add("Telefon");
        liste.add("İcecek");
        return liste;
    }

}













