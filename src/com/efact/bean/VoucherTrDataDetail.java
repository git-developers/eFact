package com.efact.bean;

import java.io.Serializable;

public class VoucherTrDataDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String recaudo;
    private String montoProgramado;
    private String montoPagado;
    
	public String getRecaudo() {
		return recaudo;
	}
	public void setRecaudo(String recaudo) {
		this.recaudo = recaudo;
	}
	public String getMontoProgramado() {
		return montoProgramado;
	}
	public void setMontoProgramado(String montoProgramado) {
		this.montoProgramado = montoProgramado;
	}
	public String getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(String montoPagado) {
		this.montoPagado = montoPagado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
