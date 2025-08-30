package com.seccion12.demo_webapiRestfull.Repository;

import com.seccion12.demo_webapiRestfull.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducto  extends JpaRepository<Producto, Long> {
}
