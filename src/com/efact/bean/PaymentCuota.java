package com.efact.bean;

import java.io.Serializable;

public class PaymentCuota implements Serializable {

	private static final long serialVersionUID = 1L;
    private String campo;
    private String recId;
    private String conId;
    private String recTipo;
    private String recNCuota;
    private String cieFCierreMes;
    private String descripcion;
    
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getConId() {
		return conId;
	}
	public void setConId(String conId) {
		this.conId = conId;
	}
	public String getRecTipo() {
		return recTipo;
	}
	public void setRecTipo(String recTipo) {
		this.recTipo = recTipo;
	}
	public String getRecNCuota() {
		return recNCuota;
	}
	public void setRecNCuota(String recNCuota) {
		this.recNCuota = recNCuota;
	}
	public String getCieFCierreMes() {
		return cieFCierreMes;
	}
	public void setCieFCierreMes(String cieFCierreMes) {
		this.cieFCierreMes = cieFCierreMes;
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
