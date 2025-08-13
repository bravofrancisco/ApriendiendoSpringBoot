package com.example.demo_inyeccionDependencia.Repository;

import com.example.demo_inyeccionDependencia.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Primary
@Repository
public class ProductRepositoryFoo extends ProductRepository {

    @Override
    public List<Product> findAll(){
        return Collections.singletonList(new Product(1L,"Monitor Ausus",600L));
    }
    @Override
    public Product findById(Long id){
        return new Product(id, "Monitor",500L);
    }

}
