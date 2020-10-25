package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;
import com.mitocode.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo repo;

	public Persona registrar(Persona persona) {
		return repo.save(persona);
	}

	public Persona modificar(Persona persona) {
		return repo.save(persona);
	}

	public List<Persona> listar() {
		return repo.findAll();
	}

	public Persona listarPorId(Integer id) {
		Optional<Persona> op = repo.findById(id);
		return op.isPresent() ? op.get() : null;
	}

	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
}
