package com.efact.bean;

import java.io.Serializable;
import java.util.List;

public class PaymentBody implements Serializable {

	private static final long serialVersionUID = 1L;
    private List<PaymentDetail> listPaymentDetail;
    private List<PaymentCuota> listPaymentCuota;
    
	public List<PaymentDetail> getListPaymentDetail() {
		return listPaymentDetail;
	}
	public void setListPaymentDetail(List<PaymentDetail> listPaymentDetail) {
		this.listPaymentDetail = listPaymentDetail;
	}
	public List<PaymentCuota> getListPaymentCuota() {
		return listPaymentCuota;
	}
	public void setListPaymentCuota(List<PaymentCuota> listPaymentCuota) {
		this.listPaymentCuota = listPaymentCuota;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
