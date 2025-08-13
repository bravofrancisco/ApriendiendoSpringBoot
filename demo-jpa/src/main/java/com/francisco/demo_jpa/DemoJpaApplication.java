package com.francisco.demo_jpa;

import com.francisco.demo_jpa.DTOP.PersonDTO;
import com.francisco.demo_jpa.Repository.RepositoryPerson;
import com.francisco.demo_jpa.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	@Autowired
	private RepositoryPerson repositoryPerson;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception{
		//list();
		//findOne();
		// create();
		//update();
		//delete();
		//delete2();
//		personalizeNombre(5L);
//		obtenerPersonDataFullList();
//		obtenerFullListById(1L);
//		personalizedQueries();
//		querisDistinct();
//		querisCount();
//		ConcatUpperLowerCase();
//		ConcarLower();
//		ConcatUpper();
//		listBetween();
//		listBetween2();
//		findByNameBetween2();
//		subquery();
//		whereIn();
//		create();
		update();
	}
	@Transactional(readOnly = true)
	public void list(){
		//		List<Person> person = (List<Person>) repositoryPerson.findAll();

		//consulta personalizada
//		List<Person> person = (List<Person>) repositoryPerson.findByLenguajeProgramacion("Java");

		List<Person> person = (List<Person>) repositoryPerson.BuscarLenguajeProgramacion("Java", "Juan");
		person.forEach(person1 -> {
			System.out.println("person1 = " + person1);
		});

		List<Object[]> getPersonsValues = repositoryPerson.obtenerPersonData();

		for (Object[] fila : getPersonsValues) {
			String name = (String) fila[0];
			String lenguaje = (String) fila[1];
			System.out.println("Nombre: " + name + ", Lenguaje: " + lenguaje);
		}
	}
	@Transactional(readOnly = true)
	public void findOne(){
//		Optional<Person> persona = repositoryPerson.findOne(2L);
//		Optional<Person> persona = repositoryPerson.findNamee("Juan");
		Optional<Person> persona = repositoryPerson.findLikeName("fia");
		if (persona.isPresent()) {
			System.out.println("persona.get() = " + persona.get());
		}else{
			System.out.println("No se encontro la persona");
		}
	}
	//transaccion de lectura
	@Transactional(readOnly = true)
	public void create(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese nombre: ");
		String name = scanner.next();

		System.out.print("Ingrese apellido: ");
		String lastname = scanner.next();

		System.out.print("Ingrese lenguaje de programación: ");
		String lenguajeProgramacion = scanner.next();

		scanner.close();

		Person person = new Person(null, name, lastname, lenguajeProgramacion);
		Person newPerson = repositoryPerson.save(person);

		System.out.println("Persona guardada: " + newPerson);

		// Buscar e imprimir usando el ID generado
		Optional<Person> encontrada = repositoryPerson.findById(newPerson.getId());
		encontrada.ifPresent(p -> System.out.println("Persona encontrada por ID: " + p));
	}

	@Transactional
	public void update(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona a editar:");
		Long id = sc.nextLong();

		Optional<Person> ps = repositoryPerson.findById(id);

		ps.ifPresent(person -> {
			System.out.println("Ingrese el nuevo lenguaje de programación:");
			//lo que queremos cambiar
			String lenguajeProgramacion = sc.next();
			person.setLenguajeProgramacion(lenguajeProgramacion);

			repositoryPerson.save(person); // guarda los cambios
			System.out.println("Persona actualizada: " + person);
		});

		if (ps.isEmpty()) {
			System.out.println("No se encontró ninguna persona con el ID " + id);
		}

		sc.close(); // cerrar scanner
	}

	@Transactional
	public void delete(){
		repositoryPerson.findAll().forEach(System.out::println);
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el id para eliminar");
		Long id = sc.nextLong();
		if (repositoryPerson.existsById(id) ) {
			repositoryPerson.deleteById(id);
			System.out.println("Persona eliminada");
		}else{
			System.out.println("No se encontro ninguna persona con el id" + id);
		}
		sc.close();
	}

	@Transactional
	public void delete2(){
		Scanner sc = new Scanner(System.in);

		try {
			// Mostrar todas las personas antes de eliminar
			System.out.println("📋 Lista de personas antes de eliminar:");
			repositoryPerson.findAll().forEach(System.out::println);

			System.out.print("Ingrese el ID a eliminar: ");
			if (!sc.hasNextLong()) {
				System.out.println("❌ Entrada inválida. Debe ingresar un número.");
				return;
			}

			Long id = sc.nextLong();

			Optional<Person> deletePersona = repositoryPerson.findById(id);

			if (deletePersona.isPresent()) {
				repositoryPerson.delete(deletePersona.get());
				System.out.println("✅ Persona eliminada: " + deletePersona.get());
			} else {
				System.out.println("⚠️ No se encontró ninguna persona con el ID " + id);
			}

			// Mostrar todas las personas después de eliminar
			System.out.println("\n📋 Lista de personas después de eliminar:");
			repositoryPerson.findAll().forEach(System.out::println);

		} catch (Exception e) {
			System.out.println("❌ Error durante la operación: " + e.getMessage());
		} finally {
			sc.close(); // siempre cerrar el scanner
		}
	}

	@Transactional(readOnly = true)
	public void personalizeNombre(Long id) {
		Optional<String> name = repositoryPerson.getNameById(id);

		if (name.isPresent()) {
			System.out.println("✅ Nombre encontrado: " + name.get());
		} else {
			System.out.println("⚠️ No se encontró una persona con el ID: " + id);
		}
	}
	public void personalizeNombreFromInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("🔎 Ingrese el ID de la persona: ");

		if (!sc.hasNextLong()) {
			System.out.println("❌ Entrada inválida. Debe ingresar un número.");
			return;
		}

		Long id = sc.nextLong();
		personalizeNombre(id);
		sc.close();
	}

	@Transactional(readOnly = true)
	public Object[] obtenerFullListById(Long id){
	return repositoryPerson.obtenerPersonDataFullById(id);
	}

	@Transactional(readOnly = true)
	public void obtenerPersonDataFullList(){
		repositoryPerson.obtenerPersonDataFullList();
	}

	@Transactional(readOnly = true)
	public void personalizedQueries(){
		System.out.println("==========consulta solo el nombre por el id =======");
		List<Object[]> persona = repositoryPerson.findMixPersonDataList();
		persona.forEach(registro->{
			System.out.println("Porgramacion" + registro[1] + " person=" + registro[0]);
		});

		System.out.println("consulta que puebla una consulta personalizada");
		List<Person> persons = repositoryPerson.findAllPersonalizadaPerson();
		persons.forEach(person1s -> System.out.println("person1 = " + person1s));


		System.out.println("consulta que pobla y que vuelve objrto dto personalidad");
		List<PersonDTO> personDTO = repositoryPerson.PersonDTO();
		personDTO.forEach(System.out::println);
	}
	@Transactional(readOnly = true)
	public void querisDistinct(){
		System.out.println("Consultas con nombres de personas");
		List<String>names = repositoryPerson.findallNames();
		names.forEach(System.out::println);
	}
	@Transactional(readOnly = true)
	public void querisCount(){
		System.out.println("Cantidad total de registro");
		Long total = repositoryPerson.findCount();
		System.out.println("total de lenguaje = " + total);
	}

	@Transactional(readOnly = true)
	public void ConcatUpperLowerCase(){
		System.out.println("consulta nombre");
		List<String> name = repositoryPerson.getFullConcat();
		name.forEach(System.out::println);
	}
	@Transactional(readOnly = true)
	public void ConcatUpper(){
		System.out.println("la consulta de nombre con UPPER");
		List<String> listaUpper = repositoryPerson.getFullConcatUpperCase();
		listaUpper.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void ConcarLower(){
		System.out.println("la consulta de nombre en Lower case");
		List<String>listLower = repositoryPerson.getFullConcatLower();
		listLower.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void listBetween(){
		System.out.println("conssulta por rango");
		List<Person> person = repositoryPerson.findAllBetween();
		person.forEach(System.out::println);
	}

//	@Transactional(readOnly = true)
//	public void listBetween2(){
//		System.out.println("consulta automatiza");
//		List<Person> person2 = repositoryPerson.findByIdBetween(2L,3L);
//		person2.forEach(System.out::println);
//	}
//
//	@Transactional(readOnly = true)
//	public void findByNameBetween2(){
//		System.out.println("consulta automatiza");
//		List<Person> person2 = repositoryPerson.findByIdBetween("S","J");
//		person2.forEach(System.out::println);
//	}
	@Transactional(readOnly = true)
	public void subquery(){
		System.out.println("consulta  por su nombre mas corto");
		List<Object[]>registers = repositoryPerson.getShortName();
		registers.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void whereIn(){
		System.out.println("utilzando where NOT in");
		List<Person> persons = repositoryPerson.getPersonsByIds(Arrays.asList(1L,2L,4L,5L));
		persons.forEach(System.out::println);
	}
}
