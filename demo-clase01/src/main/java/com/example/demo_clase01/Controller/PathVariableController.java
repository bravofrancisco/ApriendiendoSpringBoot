package com.example.demo_clase01.Controller;
import com.example.demo_clase01.UserModel.DTO.ParamDto;
import com.example.demo_clase01.UserModel.ModelUser;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message,@RequestParam Integer code) {
        ParamDto params = new ParamDto();
        params.setMessage(message);
        params.setCode(code);
    return params;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Integer id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public ModelUser create(@RequestBody ModelUser user){
        //hacer algo con el usuario sabe en la bbdd
        return user;
    }
}

