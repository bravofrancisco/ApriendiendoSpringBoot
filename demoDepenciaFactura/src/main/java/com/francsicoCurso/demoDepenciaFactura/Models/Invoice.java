package com.francsicoCurso.demoDepenciaFactura.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
@JsonIgnoreProperties({
        "targetSource",
        "advisors"
})
@JsonPropertyOrder({"cliente", "descripcion", "items"})
public class Invoice {

    @Value("${invoice.description}")
    private String descripcion;

    @Autowired
//    @Qualifier("default")
    private List<Item> items;

    @Autowired
    private Cliente cliente;

    public Invoice() {
    }

    @PostConstruct
    public void init(){
        System.out.println("creando el componente de la factura");
        cliente.setName(cliente.getName().concat(" ").concat(cliente.getName()).concat("pepe"));
        descripcion = descripcion.concat("del cliente").concat(cliente.getName()).concat("").concat(cliente.getLastname());
    }

    public void destroy(){
        System.out.println("destruyendo el component de la factura");
    }

    public Invoice(String descripcion, List<Item> items, Cliente cliente) {
        this.descripcion = descripcion;
        this.items = items;
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public int getTotal() {
        int total = 0;
        for (Item item : items) {
            total += item.getImporte();  // Asumiendo que Item tiene método getImporte()
        }
        return total;
    }
}
