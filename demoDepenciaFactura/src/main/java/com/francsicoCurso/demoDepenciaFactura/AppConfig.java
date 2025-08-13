package com.francsicoCurso.demoDepenciaFactura;

import com.francsicoCurso.demoDepenciaFactura.Models.Item;
import com.francsicoCurso.demoDepenciaFactura.Models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean
    List<Item> itemsInvoce(){
        Product p1 = new Product("camara",2000);
        Product p2 = new Product("bimetallic", 12000);
        return Arrays.asList(new Item(p1,2), new Item(p2,4));
    }

    @Bean
    @Primary
    List<Item> itemsOficina(){
        Product p1 = new Product("Monitor asus",2000);
        Product p2 = new Product("notebook ryzen", 12000);
        return Arrays.asList(new Item(p1,2), new Item(p2,4));
    }
}
