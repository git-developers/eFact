package com.efact.bean;

import java.io.Serializable;


public class PaymentDetail implements Serializable {

	private static final long serialVersionUID = 1L;
    private String titular;
    private String direccion;
    private int tipoComprobante;
    private int serie;
    private String serieNombre;
    private int moneda;
    private String fechaEmision;
    private String fechaVencimiento;
    
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(int tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public String getSerieNombre() {
		return serieNombre;
	}
	public void setSerieNombre(String serieNombre) {
		this.serieNombre = serieNombre;
	}
	public int getMoneda() {
		return moneda;
	}
	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
