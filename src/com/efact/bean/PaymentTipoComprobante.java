package com.efact.bean;

import java.io.Serializable;

public class PaymentTipoComprobante implements Serializable {

	private static final long serialVersionUID = 1L;
    private int cscTipo;
    private String cscTipoNombre;
    
	public int getCscTipo() {
		return cscTipo;
	}
	public void setCscTipo(int cscTipo) {
		this.cscTipo = cscTipo;
	}
	public String getCscTipoNombre() {
		return cscTipoNombre;
	}
	public void setCscTipoNombre(String cscTipoNombre) {
		this.cscTipoNombre = cscTipoNombre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
