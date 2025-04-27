package com.example.daw_trabajo_josuetito.models;

import java.time.LocalDate;

public class Trabajador {
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
 //   private LocalDate fechaNacimiento;
    private int edad;
    private String ciudad;
    private String direccion;
    private String codigoPostal;
    private String correo;
    private String telefono;

    public Trabajador (){
    }

    public Trabajador(int id, String nombre, String primerApellido, String segundoApellido, String sexo, int edad, String ciudad, String direccion, String codigoPostal, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.edad = edad;
        //this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Trabajador(int id, String nombre, String primerApellido, String sexo, String ciudad, int edad, String direccion, String codigoPostal, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.edad = edad;
        //this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Trabajador(String nombre, String primerApellido, String sexo, int edad, String ciudad, String direccion, String codigoPostal, String correo, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.sexo = sexo;
        this.edad = edad;
       // this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Trabajador(String nombre, String primerApellido, String segundoApellido, String sexo, int edad, String ciudad, String direccion, String codigoPostal, String correo, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.edad = edad;
        //this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /* Getter Setter Fecha nacimiento
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

     */

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
