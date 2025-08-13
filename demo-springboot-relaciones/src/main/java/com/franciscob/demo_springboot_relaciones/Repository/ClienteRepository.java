package com.franciscob.demo_springboot_relaciones.Repository;


import com.franciscob.demo_springboot_relaciones.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
