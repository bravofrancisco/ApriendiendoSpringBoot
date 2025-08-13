package com.example.demo_inyeccionDependencia.Controllers;

import com.example.demo_inyeccionDependencia.Models.Product;
import com.example.demo_inyeccionDependencia.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list(){
        return  productService.findAll();
    }
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return  productService.findById(id);
    }
}
