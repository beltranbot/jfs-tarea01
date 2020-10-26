package com.mitocode.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;

import com.mitocode.dto.DetalleVentaDTO;
import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;

	@Transactional	
	@PostMapping
	public ResponseEntity<Venta> registrar(@Valid @RequestBody Venta venta) throws Exception {
		Venta obj = service.registrarTransaccional(venta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@Transactional	
	@PostMapping("/dto")
	public ResponseEntity<Venta> registrar(@Valid @RequestBody DetalleVentaDTO dto) throws Exception {
		Venta obj = service.registrarTransaccional(dto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}

}
