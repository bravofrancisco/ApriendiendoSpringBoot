package com.franciscob.demo_springboot_relaciones;
import com.franciscob.demo_springboot_relaciones.Repository.ClienteRepository;
import com.franciscob.demo_springboot_relaciones.Repository.FacturaRepository;
import com.franciscob.demo_springboot_relaciones.entities.Cliente;
import com.franciscob.demo_springboot_relaciones.entities.Direccion;
import com.franciscob.demo_springboot_relaciones.entities.Factura;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoSpringbootRelacionesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootRelacionesApplication.class, args);
	}

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public void run(String... args) {
//		crearRelaciones();
//		BuscarCliente();
//        oneToMany();
        oneToManyFindById();
	}
    @Transactional
    public void oneToMany(){
        Cliente cliente = new Cliente("fran","mora");
        Direccion direccion1 = new Direccion("mario",490);
        Direccion direccion2 = new Direccion("ampliacion",4990);

        // Asocia las direcciones al cliente
        cliente.getDirecciones().add(direccion1);
        direccion1.setCliente(cliente);

        cliente.getDirecciones().add(direccion2);
        direccion2.setCliente(cliente);

        // AHORA agregue el código para crear y asociar una factura
        Factura factura = new Factura("Factura para Fran Mora", 2500L);
        factura.setCliente(cliente);

        // Guarda el cliente (esto también guardará las direcciones por el cascade)
        clienteRepository.save(cliente);

        // Guarda la factura, que ahora tiene una referencia al cliente
        facturaRepository.save(factura);

        System.out.println(cliente);
    }

    @Transactional
    public void oneToManyFindById(){
        Optional<Cliente> optionalCliente = clienteRepository.findById(1L);

        // Usar ifPresent, que es el método correcto y actual
        optionalCliente.ifPresent(client -> {
            Direccion direccion1 = new Direccion("el vergel", 123);
            Direccion direccion2 = new Direccion("Vasco de Gama", 1223);

            // Opción 1: Agregar a la lista existente
            // Es la forma más segura si el cliente ya tiene direcciones
            client.getDirecciones().add(direccion1);
            direccion1.setCliente(client);

            client.getDirecciones().add(direccion2);
            direccion2.setCliente(client);

            // No es necesario llamar a save() si el cliente ya es una entidad "manejada"
            // dentro de la transacción, pero es una buena práctica para ser explícito.
            clienteRepository.save(client);

            System.out.println("Cliente actualizado: " + client);
        });
    }

    @Transactional
	private void crearRelaciones() {
//		Cliente cliente = new Cliente("Jhon", "Bravo");
//		clienteRepository.save(cliente);
		List<Cliente>cliente = List.of(
				new Cliente("papa","bravo"),
				new Cliente("mama","becerra"),
				new Cliente("hijo","bravo becerra"),
				new Cliente("marcela","calcumil"),
                new Cliente("Carla","Calcumil")
		);
		clienteRepository.saveAll(cliente);
//
//		Factura factura = new Factura("Compras de oficinas", 2000L);
//		factura.setCliente(cliente.get(0));
//
//		Factura facturaGuardada = facturaRepository.save(factura);
//		System.out.println("Factura guardada: " + facturaGuardada);

		for (Cliente cliente1 : cliente){
			Factura factura = new Factura("Factura para"+ cliente1.getNombre(),1500L);
			factura.setCliente(cliente1);
			facturaRepository.save(factura);
		}
	}
    @Transactional
	public void BuscarCliente(){
		Optional<Cliente> optionalCliente = clienteRepository.findById(2L);
		if (optionalCliente.isPresent()){
			Cliente client = optionalCliente.orElseThrow();

				Factura factura = new Factura("Factura para"+ client.getNombre(),1500L);
				factura.setCliente(client);
				facturaRepository.save(factura);
			System.out.println("*******************");
				System.out.println("factura encontrada y el nombre es = " + client.getNombre());
			System.out.println("*******************");
		}else {
			System.out.println("CLiente no encontrado");
		}
	}
}
