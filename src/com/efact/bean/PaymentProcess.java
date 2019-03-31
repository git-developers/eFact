package com.efact.bean;

import java.io.Serializable;
import java.util.List;

public class PaymentProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	private String queryContrato;
	private int queryTipoDoi;
	private String queryNumeroDoi;
	private String queryTitular;
	private String queryDireccion;
	private int queryComprobante;
	private int querySerieComprobante;
	private int queryFechaEmision;
	private int queryFechaVencimiento;
	private int queryTotal;
	private String queryTotalTexto;
	private String queryTipoMoneda;
	private String queryDescripcionMoneda;
	private String appUser;
	private List<PaymentDetailProcess> paymentDetailProcess;

	private String numeroComprobante;
	private int exito;
	private String mensaje;
	
	public String getQueryContrato() {
		return queryContrato;
	}
	public void setQueryContrato(String queryContrato) {
		this.queryContrato = queryContrato;
	}
	public int getQueryTipoDoi() {
		return queryTipoDoi;
	}
	public void setQueryTipoDoi(int queryTipoDoi) {
		this.queryTipoDoi = queryTipoDoi;
	}
	public String getQueryNumeroDoi() {
		return queryNumeroDoi;
	}
	public void setQueryNumeroDoi(String queryNumeroDoi) {
		this.queryNumeroDoi = queryNumeroDoi;
	}
	public String getQueryTitular() {
		return queryTitular;
	}
	public void setQueryTitular(String queryTitular) {
		this.queryTitular = queryTitular;
	}
	public String getQueryDireccion() {
		return queryDireccion;
	}
	public void setQueryDireccion(String queryDireccion) {
		this.queryDireccion = queryDireccion;
	}
	public int getQueryComprobante() {
		return queryComprobante;
	}
	public void setQueryComprobante(int queryComprobante) {
		this.queryComprobante = queryComprobante;
	}
	public int getQuerySerieComprobante() {
		return querySerieComprobante;
	}
	public void setQuerySerieComprobante(int querySerieComprobante) {
		this.querySerieComprobante = querySerieComprobante;
	}
	public int getQueryFechaEmision() {
		return queryFechaEmision;
	}
	public void setQueryFechaEmision(int queryFechaEmision) {
		this.queryFechaEmision = queryFechaEmision;
	}
	public int getQueryFechaVencimiento() {
		return queryFechaVencimiento;
	}
	public void setQueryFechaVencimiento(int queryFechaVencimiento) {
		this.queryFechaVencimiento = queryFechaVencimiento;
	}
	public int getQueryTotal() {
		return queryTotal;
	}
	public void setQueryTotal(int queryTotal) {
		this.queryTotal = queryTotal;
	}
	public String getQueryTotalTexto() {
		return queryTotalTexto;
	}
	public void setQueryTotalTexto(String queryTotalTexto) {
		this.queryTotalTexto = queryTotalTexto;
	}
	public String getQueryTipoMoneda() {
		return queryTipoMoneda;
	}
	public void setQueryTipoMoneda(String queryTipoMoneda) {
		this.queryTipoMoneda = queryTipoMoneda;
	}
	public String getQueryDescripcionMoneda() {
		return queryDescripcionMoneda;
	}
	public void setQueryDescripcionMoneda(String queryDescripcionMoneda) {
		this.queryDescripcionMoneda = queryDescripcionMoneda;
	}
	public String getAppUser() {
		return appUser;
	}
	public void setAppUser(String appUser) {
		this.appUser = appUser;
	}
	public List<PaymentDetailProcess> getPaymentDetailProcess() {
		return paymentDetailProcess;
	}
	public void setPaymentDetailProcess(List<PaymentDetailProcess> paymentDetailProcess) {
		this.paymentDetailProcess = paymentDetailProcess;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public int getExito() {
		return exito;
	}
	public void setExito(int exito) {
		this.exito = exito;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
