package com.franciscob.demo_springboot_relaciones.Repository;


import com.franciscob.demo_springboot_relaciones.entities.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
}
