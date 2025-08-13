package com.francisco.demo_jpa.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    @Column(name = "lenguaje_programacion")
    private String lenguajeProgramacion;

    @Embedded
    private Audit audit = new Audit();
    public Person() {
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(Long id, String name, String lastname, String lenguajeProgramacion) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.lenguajeProgramacion = lenguajeProgramacion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", lenguajeProgramacion='" + lenguajeProgramacion + '\'' +
                ", createdAt=" + audit.getCreatedAt() +
                ", updatedAt=" +audit.getUpdatedAt() +
                '}';
    }
}