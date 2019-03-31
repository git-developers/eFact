package com.efact.bean;

import java.io.Serializable;

import com.efact.util.StringUtil;

public class PaymentDetailProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	private String gridRecaudo;
	private String gridConcepto;
	private String gridNoAfecto;
	private String gridAfecto;
	private String gridIgv;
	private String gridTotal;
	private String detail;
	
	public static final String SEPARATOR = "|";
	
	public String getGridRecaudo() {
		return gridRecaudo;
	}
	public void setGridRecaudo(String gridRecaudo) {
		this.gridRecaudo = gridRecaudo;
	}
	public String getGridConcepto() {
		return gridConcepto;
	}
	public void setGridConcepto(String gridConcepto) {
		this.gridConcepto = gridConcepto;
	}
	public String getGridNoAfecto() {
		return gridNoAfecto;
	}
	public void setGridNoAfecto(String gridNoAfecto) {
		this.gridNoAfecto = gridNoAfecto;
	}
	public String getGridAfecto() {
		return gridAfecto;
	}
	public void setGridAfecto(String gridAfecto) {
		this.gridAfecto = gridAfecto;
	}
	public String getGridIgv() {
		return gridIgv;
	}
	public void setGridIgv(String gridIgv) {
		this.gridIgv = gridIgv;
	}
	public String getGridTotal() {
		return gridTotal;
	}
	public void setGridTotal(String gridTotal) {
		this.gridTotal = gridTotal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDetail() {

		String detailConcat = StringUtil.implode(new String[] {
			gridRecaudo,
			gridConcepto,
			gridNoAfecto,
			gridAfecto,
			gridTotal
		}, SEPARATOR);
		
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
