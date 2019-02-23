package com.efact.bean;

import java.io.Serializable;

public class PaymentTipoDoi implements Serializable {

	private static final long serialVersionUID = 1L;
    private int idTipoDoi;
    private String nombreCorto;
    private int flagTipo;
    private int longitud;
    private int flagLongitud;
    private int idEquivalencia;
    
	public int getIdTipoDoi() {
		return idTipoDoi;
	}
	public void setIdTipoDoi(int idTipoDoi) {
		this.idTipoDoi = idTipoDoi;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public int getFlagTipo() {
		return flagTipo;
	}
	public void setFlagTipo(int flagTipo) {
		this.flagTipo = flagTipo;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public int getFlagLongitud() {
		return flagLongitud;
	}
	public void setFlagLongitud(int flagLongitud) {
		this.flagLongitud = flagLongitud;
	}
	public int getIdEquivalencia() {
		return idEquivalencia;
	}
	public void setIdEquivalencia(int idEquivalencia) {
		this.idEquivalencia = idEquivalencia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
