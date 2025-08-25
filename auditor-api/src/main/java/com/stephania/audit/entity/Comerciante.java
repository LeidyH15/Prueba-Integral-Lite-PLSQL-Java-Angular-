package com.stephania.audit.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "comerciantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comerciante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "documento", nullable = false, unique = true, length = 20)
	private String documento;

	@Column(name = "correo", nullable = false, length = 100)
	private String correo;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "municipio", nullable = false, length = 50)
	private String municipio;

	@Column(name = "estado", nullable = false)
	private Boolean estado;

	@Column(name = "fecha_registro", updatable = false)
	private java.time.LocalDateTime fechaRegistro;

	@Column(name = "usuario_actualizacion")
	private String usuarioActualizacion;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;
	
	@OneToMany(mappedBy = "comerciante")
    private List<Establecimiento> establecimientos;

	@PreUpdate
	public void preUpdate() {
		this.fechaActualizacion = LocalDateTime.now();
	}

	@PrePersist
	public void prePersist() {
		this.fechaRegistro = java.time.LocalDateTime.now();
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public java.time.LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.time.LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public List<Establecimiento> getEstablecimientos() {
		return establecimientos;
	}

	public void setEstablecimientos(List<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}
	

}