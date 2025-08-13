package com.example.demo_inyeccionDependencia.Services;

import com.example.demo_inyeccionDependencia.Models.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    Product findById(Long id);
}
