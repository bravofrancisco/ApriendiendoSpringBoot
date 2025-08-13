package com.franciscob.demo_interceptor.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/foo")
    public Map<String, String>foo(){
        return Collections.singletonMap("message","handler");
    }

    @GetMapping("/bar")
    public Map<String, String>bar(){
        return Collections.singletonMap("message","handler");
    }

    @GetMapping("/baz")
    public Map<String, String>fobaz(){
        return Collections.singletonMap("message","handler");
    }
}
