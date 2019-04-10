package com.efact.bean;

import java.io.Serializable;
import java.util.List;

public class PaymentHeader implements Serializable {

	private static final long serialVersionUID = 1L;
    private List<PaymentTipoDoi> listPaymentTipoDoi;
    private List<PaymentTipoComprobante> listPaymentTipoComprobante;
    private List<PaymentTipoMoneda> listPaymentTipoMoneda;
    private List<PaymentRecaudo> listPaymentRecaudo;
    private List<PaymentConcepto> listPaymentConcepto;
    
	public List<PaymentTipoDoi> getListPaymentTipoDoi() {
		return listPaymentTipoDoi;
	}
	public void setListPaymentTipoDoi(List<PaymentTipoDoi> listPaymentTipoDoi) {
		this.listPaymentTipoDoi = listPaymentTipoDoi;
	}
	public List<PaymentTipoComprobante> getListPaymentTipoComprobante() {
		return listPaymentTipoComprobante;
	}
	public void setListPaymentTipoComprobante(List<PaymentTipoComprobante> listPaymentTipoComprobante) {
		this.listPaymentTipoComprobante = listPaymentTipoComprobante;
	}
	public List<PaymentTipoMoneda> getListPaymentTipoMoneda() {
		return listPaymentTipoMoneda;
	}
	public void setListPaymentTipoMoneda(List<PaymentTipoMoneda> listPaymentTipoMoneda) {
		this.listPaymentTipoMoneda = listPaymentTipoMoneda;
	}
	public List<PaymentRecaudo> getListPaymentRecaudo() {
		return listPaymentRecaudo;
	}
	public void setListPaymentRecaudo(List<PaymentRecaudo> listPaymentRecaudo) {
		this.listPaymentRecaudo = listPaymentRecaudo;
	}
	public List<PaymentConcepto> getListPaymentConcepto() {
		return listPaymentConcepto;
	}
	public void setListPaymentConcepto(List<PaymentConcepto> listPaymentConcepto) {
		this.listPaymentConcepto = listPaymentConcepto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
