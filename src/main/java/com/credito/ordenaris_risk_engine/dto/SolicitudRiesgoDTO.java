package com.credito.ordenaris_risk_engine.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class SolicitudRiesgoDTO {
	@NotNull(message = "empresaId es obligatorio")
	private String empresaId;
	@NotNull(message = "montoSolicitado es obligatorio")
    @DecimalMin(value = "0.01", inclusive = true, message = "montoSolicitado debe ser mayor a 0")
    private BigDecimal montoSolicitado;
	@NotNull(message = "productoFinanciero es obligatorio")
    private ProductoFinanciero productoFinanciero;
	@NotNull(message = "fechaSolicitud es obligatoria")
    private LocalDate fechaSolicitud;
    
	public SolicitudRiesgoDTO() {
	}

	public SolicitudRiesgoDTO(String empresaId, BigDecimal montoSolicitado, ProductoFinanciero productoFinanciero,
			LocalDate fechaSolicitud) {
		super();
		this.empresaId = empresaId;
		this.montoSolicitado = montoSolicitado;
		this.productoFinanciero = productoFinanciero;
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(String empresaId) {
		this.empresaId = empresaId;
	}

	public BigDecimal getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(BigDecimal montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public ProductoFinanciero getProductoFinanciero() {
		return productoFinanciero;
	}

	public void setProductoFinanciero(ProductoFinanciero productoFinanciero) {
		this.productoFinanciero = productoFinanciero;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
}
