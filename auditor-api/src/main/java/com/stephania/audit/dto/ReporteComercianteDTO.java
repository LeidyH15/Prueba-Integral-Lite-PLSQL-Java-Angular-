package com.stephania.audit.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReporteComercianteDTO {
    private String nombre;
    private String municipio;
    private String telefono;
    private String correo;
    private LocalDateTime fechaRegistro;
    private Boolean estado;
    private int cantidadEstablecimientos;
    private BigDecimal totalIngresos;
    private int cantidadEmpleados;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public int getCantidadEstablecimientos() {
		return cantidadEstablecimientos;
	}
	public void setCantidadEstablecimientos(int cantidadEstablecimientos) {
		this.cantidadEstablecimientos = cantidadEstablecimientos;
	}
	public BigDecimal getTotalIngresos() {
		return totalIngresos;
	}
	public void setTotalIngresos(BigDecimal totalIngresos) {
		this.totalIngresos = totalIngresos;
	}
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}
	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
    
    
}