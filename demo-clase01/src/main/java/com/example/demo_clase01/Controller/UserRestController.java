package com.example.demo_clase01.Controller;
import com.example.demo_clase01.UserModel.DTO.ModelDTO;
import com.example.demo_clase01.UserModel.ModelUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
//    @GetMapping("/details2")
//    public Map<String, Object> detail() {
//        ModelUser user = new ModelUser("Andres", "Guzman");
//        Map<String, Object> body = new HashMap<>();
//
//        body.put("title", "Hola Mundo Spring Boot");
//        body.put("user",user);
//
//        return body;
//    }
    @GetMapping("/details2")
    public ModelDTO details2 (){
        ModelUser user = new ModelUser("Francisco","Bravo");

        ModelDTO userDTO = new ModelDTO();
        userDTO.setTitle("Hola Mundo Spring Boot");
        userDTO.setUser(user);
        return userDTO;
    }
    @GetMapping("/list")
    public List<ModelUser>list(){
        ModelUser user = new ModelUser("Francisco","Becerra");
        ModelUser user2 = new ModelUser("Juana","Becerra");
        ModelUser user3 = new ModelUser("Manuek","Bravo");
//        List<ModelUser> users = new ArrayList<>();
//        users.add(user);
//        users.add(user2);
//        users.add(user3);

        return Arrays.asList(user,user2,user3);
    }
}
