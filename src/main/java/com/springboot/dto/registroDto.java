package com.springboot.dto;


public class registroDto {

	private String nombres;
    private String apellidos;
    private String dni;
    private String edad;
    private String correo;
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
	
	public registroDto(String nombres, String apellidos, String dni, String edad, String correo) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.correo = correo;
	}
	public registroDto() {
	}
    
    
}
