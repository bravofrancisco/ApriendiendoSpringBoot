package com.example.demo_clase01.Controller;
import com.example.demo_clase01.UserModel.ModelUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/details")
    public String detail(Model model) {
        ModelUser user = new ModelUser("Francisco","bravo");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("User",user);

        return "details";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("title","listado de usuarios");
        return  "list";
    }

    @ModelAttribute("users")
    public List<ModelUser>listadousuarios(){
        return Arrays.asList(
                new ModelUser("francisco","bravo", "francisco@gmail.com"),
                new ModelUser("manuel","bravo","manuel@gmail.com"),
                new ModelUser("juana", "becerra","juana@gmail.com"));
    }
}
