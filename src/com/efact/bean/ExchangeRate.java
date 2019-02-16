package com.efact.bean;

import java.io.Serializable;

//import com.efact.util.Util;

public class ExchangeRate implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String fecha;
	private String moneda;
	private String compra;
	private String venta;
	private String fecCreacion;
	private String userCreacion;			
    private String resultado;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getCompra() {
		return compra;
	}
	public void setCompra(String compra) {
		this.compra = compra;
	}
	public String getVenta() {
		return venta;
	}
	public void setVenta(String venta) {
		this.venta = venta;
	}
	public String getFecCreacion() {
		return fecCreacion;
	}
	public void setFecCreacion(String fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	public String getUserCreacion() {
		return userCreacion;
	}
	public void setUserCreacion(String userCreacion) {
		this.userCreacion = userCreacion;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
    
}
