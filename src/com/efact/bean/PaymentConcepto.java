package com.efact.bean;

import java.io.Serializable;

public class PaymentConcepto implements Serializable {

	private static final long serialVersionUID = 1L;
    private int idRecaudo;
    private int idConcepto;
    private String descripcion;
    
	public int getIdRecaudo() {
		return idRecaudo;
	}
	public void setIdRecaudo(int idRecaudo) {
		this.idRecaudo = idRecaudo;
	}
	public int getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(int idConcepto) {
		this.idConcepto = idConcepto;
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
