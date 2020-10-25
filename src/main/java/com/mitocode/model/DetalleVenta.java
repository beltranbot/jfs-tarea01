package com.mitocode.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleVenta;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_venta_venta"))
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_venta_producto"))
	private Producto producto;
	
	@Positive(message = "{detalleVenta.cantidad.positive}")
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@JsonIgnore
	@Column(name = "precio_unidad", nullable = false)
	private Double precioUnidad;

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(Double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
