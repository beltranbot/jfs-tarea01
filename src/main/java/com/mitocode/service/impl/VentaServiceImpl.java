package com.mitocode.service.impl;

import com.mitocode.dto.DetalleVentaDTO;
import com.mitocode.model.DetalleVenta;
import com.mitocode.model.Producto;
import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IProductoRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

	@Autowired
	private IVentaRepo repo;
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return repo;
	}

	@Override
	public Venta registrarTransaccional(Venta venta) throws Exception {
		venta.setImporte(calcularImporte(venta));

		repo.save(venta);

		return venta;
	}
	
	private Double calcularImporte(Venta venta) throws Exception {
		double importe = 0;
		
		for (DetalleVenta detalle : venta.getDetalleVenta()) {
			detalle.setVenta(venta);
			Optional<Producto> producto = productoRepo.findById(detalle.getProducto().getIdProducto());
			double precioUnidad = producto.get().getPrecioUnidad();
			double subtotal = precioUnidad * detalle.getCantidad();
			detalle.setPrecioUnidad(precioUnidad);
			importe += subtotal;
		}
		return importe;
	}

	@Override
	public Venta registrarTransaccional(DetalleVentaDTO dto) throws Exception {
		dto.getVenta().setImporte(calcularImporte(dto.getVenta()));

		repo.save(dto.getVenta());

		return dto.getVenta();
	}

}
