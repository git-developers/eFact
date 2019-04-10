package com.efact.bean;

import java.io.Serializable;

public class PaymentRecaudo implements Serializable {

	private static final long serialVersionUID = 1L;
    private int idRecaudo;
    private String descripcion;
    
	public int getIdRecaudo() {
		return idRecaudo;
	}
	public void setIdRecaudo(int idRecaudo) {
		this.idRecaudo = idRecaudo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
}
