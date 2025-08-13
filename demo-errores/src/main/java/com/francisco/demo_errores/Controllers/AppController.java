package com.francisco.demo_errores.Controllers;

import com.francisco.demo_errores.Models.domain.User;
import com.francisco.demo_errores.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public String index(){
        int value = Integer.parseInt("10");
        System.out.println("value = " + value);
        return  "ok 200";
    }
    @GetMapping("/show/{id}")
    public Optional<User> show(@PathVariable(name = "id") Long id){
        Optional<User> user   = userServices.findById(id);
        System.out.println(user.getClass());
        return  user;

    }
}
