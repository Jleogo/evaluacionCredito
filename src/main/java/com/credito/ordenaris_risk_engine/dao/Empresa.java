package com.credito.ordenaris_risk_engine.dao;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nombre;
	 private int aniosOperacion;
	 private double ingresosAnuales;
	 private double deudaTotal;
	 private int empleados;
	 private String sector;
	 private double activos;
	 
	 public Empresa() {
	}
	 public Empresa(Long id, String nombre, int aniosOperacion, double ingresosAnuales, double deudaTotal, int empleados,
			String sector) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.aniosOperacion = aniosOperacion;
		this.ingresosAnuales = ingresosAnuales;
		this.deudaTotal = deudaTotal;
		this.empleados = empleados;
		this.sector = sector;
	 }
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }
	 public int getAniosOperacion() {
		 return aniosOperacion;
	 }
	 public void setAniosOperacion(int aniosOperacion) {
		 this.aniosOperacion = aniosOperacion;
	 }
	 public double getIngresosAnuales() {
		 return ingresosAnuales;
	 }
	 public void setIngresosAnuales(double ingresosAnuales) {
		 this.ingresosAnuales = ingresosAnuales;
	 }
	 public double getDeudaTotal() {
		 return deudaTotal;
	 }
	 public void setDeudaTotal(double deudaTotal) {
		 this.deudaTotal = deudaTotal;
	 }
	 public int getEmpleados() {
		 return empleados;
	 }
	 public void setEmpleados(int empleados) {
		 this.empleados = empleados;
	 }
	 public String getSector() {
		 return sector;
	 }
	 public void setSector(String sector) {
		 this.sector = sector;
	 }
	 public double getActivos() {
		 return activos;
	 }
	 public void setActivos(double activos) {
		 this.activos = activos;
	 }
}
