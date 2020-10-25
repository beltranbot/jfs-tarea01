package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaService {

	Persona registrar(Persona p);

	Persona modificar(Persona p);

	List<Persona> listar();

	Persona listarPorId(Integer id);

	void eliminar(Integer id);
}