package com.example.demo_inyeccionDependencia.Repository;

import com.example.demo_inyeccionDependencia.Models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product>findAll();
    Product findById(Long id);
}
