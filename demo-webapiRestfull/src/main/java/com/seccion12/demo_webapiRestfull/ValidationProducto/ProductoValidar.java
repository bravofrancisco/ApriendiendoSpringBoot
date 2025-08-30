package com.seccion12.demo_webapiRestfull.ValidationProducto;

import com.seccion12.demo_webapiRestfull.Models.Producto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductoValidar implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Producto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Producto  pr =  (Producto)  target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.producto.nombre");
    }
}
