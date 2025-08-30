package com.seccion12.demo_webapiRestfull.Controller;

import com.seccion12.demo_webapiRestfull.Models.Producto;
import com.seccion12.demo_webapiRestfull.Service.ServiceProducto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ControllerProducto {

    @Autowired
    private ServiceProducto serviceProducto;

    @GetMapping
    public List<Producto>list(){
        return  serviceProducto.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        return serviceProducto.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> guardarProducto(@Valid @RequestBody Producto crearProducto, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result); // método que devuelve los errores
        }
        Producto productoNuevo = serviceProducto.save(crearProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }




    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto actualizarProducto,BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()){
            return validation(result);
        }
        return serviceProducto.actualizarProducto(id, actualizarProducto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Producto> productoEliminado = serviceProducto.deleteById(id);
        if (productoEliminado.isPresent()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
    private ResponseEntity<Map<String, String>> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}

