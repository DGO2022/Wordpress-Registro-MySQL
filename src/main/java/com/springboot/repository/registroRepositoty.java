package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Registro;

public interface registroRepositoty extends JpaRepository<Registro, Long> {

}
