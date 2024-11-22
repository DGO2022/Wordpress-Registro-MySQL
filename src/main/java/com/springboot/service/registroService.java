package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Registro;
import com.springboot.repository.registroRepositoty;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class registroService {

	@Autowired
	registroRepositoty regisRepository;
	
	public List<Registro> listar(){
		return regisRepository.findAll();
	}

	public Optional<Registro> getOne(long id) {
		return regisRepository.findById(id);
	}
	
	public void save(Registro registro) {
		regisRepository.save(registro);
	}
	public Optional<Registro> findById(Long id) {
	    return regisRepository.findById(id);
	}

	public void delete(long id) {
		regisRepository.deleteById(id);
	}
	
	public boolean existsById(long id) {
		return regisRepository.existsById(id);
	}
        
}
