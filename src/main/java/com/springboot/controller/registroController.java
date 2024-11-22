package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.registroDto;
import com.springboot.entity.Mensaje;
import com.springboot.entity.Registro;
import com.springboot.service.registroService;


@RestController
@RequestMapping("/registro")
public class registroController {

	
	@Autowired
	private registroService regisService;

	@GetMapping("/listar")
	public ResponseEntity<List<Registro>> listar() {
		List<Registro> listarRegistros = regisService.listar();
		return new ResponseEntity<List<Registro>>(listarRegistros, HttpStatus.OK);
	}
	

	@DeleteMapping("/borrar/{id_registro}")
	public ResponseEntity<?> delete(@PathVariable("id_registro") long id_registro) {
		if (!regisService.existsById(id_registro)) {
			return new ResponseEntity(new Mensaje("Registro a eliminar no existe"), HttpStatus.BAD_REQUEST);
		} else {
			regisService.delete(id_registro);
			return new ResponseEntity(new Mensaje("Registro eliminada"), HttpStatus.OK);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody registroDto regisDto) {
		Registro registro = new Registro(regisDto.getNombres(),
										regisDto.getApellidos(),
										regisDto.getDni(),
										regisDto.getEdad(),
										regisDto.getCorreo());
		regisService.save(registro);
		return new ResponseEntity<>(new Mensaje("Registro insertada"), HttpStatus.OK);
	}

	@PutMapping("/update/{id_registro}")
	public ResponseEntity<?> update(@PathVariable("id_registro") Long id_registro, @RequestBody registroDto regisDto) {
		if (!regisService.existsById(id_registro)) {
			return new ResponseEntity(new Mensaje("No existen datos con este código"), HttpStatus.NOT_FOUND);
		}
		Registro registri = regisService.getOne(id_registro).get();
		registri.setNombres(regisDto.getNombres());
		registri.setApellidos(regisDto.getApellidos());
		registri.setDni(regisDto.getDni());
		registri.setEdad(regisDto.getEdad());
		registri.setCorreo(regisDto.getCorreo());

		regisService.save(registri);
		return new ResponseEntity(new Mensaje("Producto Actualizado"), HttpStatus.OK);
	}

}
