package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Registro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
    private String nombres;
    private String apellidos;
    private String dni;
    private String edad;
    private String correo;
    
    
	public Long getId_registro() {
		return id_registro;
	}
	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	public Registro(String nombres, String apellidos, String dni, String edad, String correo) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.correo = correo;
	}
	public Registro() {
	}
	
    
	
	
    
    
	
}
