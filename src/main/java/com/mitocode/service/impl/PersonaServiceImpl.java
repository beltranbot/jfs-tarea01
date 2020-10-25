package com.mitocode.service.impl;

import com.mitocode.model.Persona;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPersonaRepo;
import com.mitocode.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

	@Autowired
	private IPersonaRepo repo;

	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		return repo;
	}

}
