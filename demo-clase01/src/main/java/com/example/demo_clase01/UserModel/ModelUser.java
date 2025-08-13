package com.example.demo_clase01.UserModel;

public class ModelUser {
    private String nombre;
    private String apellido;
    private String email;

    public ModelUser() {
    }

    public ModelUser(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public ModelUser(String nombre, String apellido, String email) {
        this(nombre, apellido);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
