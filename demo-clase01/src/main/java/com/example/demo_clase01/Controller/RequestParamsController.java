package com.example.demo_clase01.Controller;

import com.example.demo_clase01.UserModel.DTO.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal ") String message){
        ParamDto parm = new ParamDto();
        parm.setMessage(message);
        return parm;
    }
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam(required = false, defaultValue = "Hola que tal ") String message, @RequestParam Integer code){
        ParamDto bar = new ParamDto();
        bar.setMessage(message);
        bar.setCode(code);
        return bar;
    }
    @GetMapping("/request")
    public ParamDto request2(HttpServletRequest request) {
        ParamDto dto = new ParamDto();
        String codeParam = request.getParameter("code");

        try {
            dto.setCode(Integer.parseInt(codeParam));
        } catch (NumberFormatException e) {
            dto.setCode(0); // o -1 o cualquier valor por defecto
            dto.setMessage("Error: 'code' debe ser un número entero.");
            return dto;
        }

        dto.setMessage(request.getParameter("message"));
        return dto;
    }

}
