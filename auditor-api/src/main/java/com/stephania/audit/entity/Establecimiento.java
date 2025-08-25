package com.stephania.audit.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Establecimiento {
    @ManyToOne
    private Comerciante comerciante;

    private BigDecimal ingresos;
    private Integer empleados;
	public Comerciante getComerciante() {
		return comerciante;
	}
	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}
	public BigDecimal getIngresos() {
		return ingresos;
	}
	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}
	public Integer getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Integer empleados) {
		this.empleados = empleados;
	}
    
    
}