package com.seccion12.demo_webapiRestfull.Service;

import com.seccion12.demo_webapiRestfull.Models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceProducto {

    List<Producto> findAll();
    Optional<Producto>findById(Long id);
    Producto save(Producto producto);
    Optional<Producto> deleteById(Long id);
    Optional<Producto> actualizarProducto(Long id, Producto producto);
}
