package com.francisco.demo_jpa.Repository;

import com.francisco.demo_jpa.DTOP.PersonDTO;
import com.francisco.demo_jpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryPerson  extends CrudRepository<Person, Long> {

    @Query("select p.name from Person p where p.id = ?1")
    Optional<String> getNameById(Long id);


    //Buscar por ID
    @Query("select p from Person p where p.id =?1")
    Optional<Person> findOne(Long id);

    //Buscar por el nombre
    @Query("select p from Person p where p.name =?1 ")
    Optional<Person> findNamee(String name);

    //Buscar por el nombre por cualquier letra
    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findLikeName(String name);

    //lista personalizada
    List<Person> findByLenguajeProgramacion(String lenguajeProgramacion);

    @Query("select p from Person p where p.lenguajeProgramacion=?1 and p.name=?2")
    List<Person> BuscarLenguajeProgramacion(String lenguajeProgramacion, String name);

    @Query("SELECT p.name, p.lenguajeProgramacion FROM Person p")
    List<Object[]> obtenerPersonData();


    @Query("select p.id, p.name, p.lenguajeProgramacion from Person p")
    List<Object[]> obtenerPersonDataFullList();

    @Query("select p.id, p.name, p.lenguajeProgramacion from Person p where p.id=?1")
    Object[] obtenerPersonDataFullById(Long id);

    @Query("SELECT p, p.lenguajeProgramacion from Person p")
    List<Object[]>findMixPersonDataList();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllPersonalizadaPerson();

    //usando DTO
    @Query("select new  com.francisco.demo_jpa.DTOP.PersonDTO(p.name, p.lastname) from Person p")
    List<PersonDTO> PersonDTO();

    //Listar todos los nombres
    @Query("SELECT distinct(p.name) from Person p")
    List<String> findallNames();

    //contar cantidad total

    @Query("SELECT count(*) from Person p")
    Long findCount();

    @Query("select CONCAT(p.name, ' ', p.lastname)from Person p ")
    List<String> getFullConcat();

    @Query("SELECT UPPER(p.name || ' ' || p.lastname) FROM Person p")
    List<String> getFullConcatUpperCase();

    @Query("SELECT LOWER(p.name || ' ' || p.lastname) FROM Person p")
    List<String> getFullConcatLower();

    //beetween
    @Query("select p  from Person p where p.id between 2 and 4")
    List<Person> findAllBetween();

//    List<Person>findByIdBetween(Long id1,Long id2);
//
//    List<Person> findByIdBetween(String s, String j);

    @Query("select p.name, LENGTH(p.name) from Person p where LENGTH(p.name) = (select min(LENGTH(p.name)) from Person p)")
    public List<Object []>getShortName();

    @Query("select p from Person p where p.id in ?1")
    public List<Person> getPersonsByIds(List<Long> ids);
}
