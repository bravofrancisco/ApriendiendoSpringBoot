package com.example.demo_inyeccionDependencia.Services;

import com.example.demo_inyeccionDependencia.Models.Product;
import com.example.demo_inyeccionDependencia.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements  IProductService{

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(p -> {
                    Product cloned = p.clone(); // Clone the product
                    cloned.setPrice((long) (cloned.getPrice() * 1.25)); // Modify the price
                    return cloned;
                })
                .collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
