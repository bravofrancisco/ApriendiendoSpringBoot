package com.seccion12.demo_webapiRestfull.Service;
import com.seccion12.demo_webapiRestfull.Models.Producto;
import com.seccion12.demo_webapiRestfull.Repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProductoImpl implements  ServiceProducto {

    @Autowired
    private RepositoryProducto repositoryProducto;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return repositoryProducto.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(Long id) {
        return repositoryProducto.findById(id);
    }
    @Transactional
    @Override
    public Producto save(Producto producto) {
        return repositoryProducto.save(producto);
    }
    @Transactional
    @Override
    public Optional<Producto> deleteById(Long id) {
        Optional<Producto> producto = repositoryProducto.findById(id);
        producto.ifPresent(repositoryProducto::delete);
        return producto;
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return repositoryProducto.findById(id).map(productoExistente -> {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setDescripcion(producto.getDescripcion());
            // Agrega aquí otros campos si los hay
            return repositoryProducto.save(productoExistente);
        });
    }
}
