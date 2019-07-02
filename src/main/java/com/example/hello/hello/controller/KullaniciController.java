package com.example.hello.hello.controller;

import com.example.hello.hello.model.User;
import com.example.hello.hello.service.SecurityService;
import com.example.hello.hello.service.UserService;
import com.example.hello.hello.service.UserServiceImpl;
import com.example.hello.hello.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class KullaniciController {

    @Autowired
    private UserService kullaniciService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    UserValidator kullaniciValidator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/kayitol")
    public String kayitol(Model model){
        model.addAttribute("kullaniciForm", new User());

        return "kayitol";
    }

    @PostMapping("/kayitol")
    public String kayitol(@ModelAttribute("kullaniciForm") User kullaniciForm, BindingResult bindingResult,Model model){
        kullaniciValidator.validate(kullaniciForm,bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("error","Lütfen verileri istenildiği gibi giriniz.");
            return "kayitol";
        }

        kullaniciService.save(kullaniciForm);
        securityService.autoLogin(kullaniciForm.getUsername(),kullaniciForm.getParola());

        System.out.println(kullaniciForm.getUsername());
        return "redirect:/giris";

    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if(error != null){
            model.addAttribute("error", "Kullanıcı Adı veya Parola Yanlış.");
        }
        if(logout != null){
            model.addAttribute("message", "Başarıyla Çıkış Yaptın.");
        }

        return "giris";
    }


    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/kullanici")
     public ModelAndView getAll(){
        List<User>  liste=userService.findAll();
        return new ModelAndView("kullanici","list",liste);
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id){
        User user=userService.findOne(id);
        userService.Delete(user);
        return  new ModelAndView("redirect:/kullanici");
    }

    @RequestMapping(value = "/editUser/{id}",method = RequestMethod.GET)
    public String edit (@PathVariable long id, ModelMap model){
        User user=userService.findOne(id);
        model.addAttribute("kullaniciForm",user);
        return "editUser";
    }

    @RequestMapping(value = "/editSave",method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("kullaniciForm") User p){
        User user=userService.findOne(p.getId());
        user.setUsername(p.getUsername());
        user.setIsim(p.getIsim());
        user.setSoyisim(p.getSoyisim());
        user.setMail(p.getMail());
        userService.save(user);
        return new ModelAndView("redirect:/kullanici");
    }
}
