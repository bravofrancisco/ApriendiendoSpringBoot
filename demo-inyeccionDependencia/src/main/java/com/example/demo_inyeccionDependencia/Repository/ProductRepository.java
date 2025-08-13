package com.example.demo_inyeccionDependencia.Repository;

import com.example.demo_inyeccionDependencia.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository  implements  IProductRepository{

    private final List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "memoria ram", 4000L),
                new Product(2L, "CPU", 99990L),
                new Product(3L, "teclado ryzen", 180000L),
                new Product(4L, "mouse ryzen", 180000L)
        );
    }
@Override
    public List<Product> findAll() {
        return data;
    }
    @Override
    public Product findById(Long id){
        return (Product) data.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow();
    }
}
