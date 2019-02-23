package com.efact.bean;

import java.io.Serializable;

public class PaymentTipoMoneda implements Serializable {

	private static final long serialVersionUID = 1L;
    private int idMoneda;
    private String descripcion;
    private String nombreCorto;
    
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    


}
