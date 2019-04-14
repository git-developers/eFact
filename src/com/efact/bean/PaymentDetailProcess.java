package com.efact.bean;

import java.io.Serializable;

import com.efact.util.StringUtil;
import com.efact.util.Util;

public class PaymentDetailProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	private int gridIndex;
	private String gridIgv;
	private String tableRow;
	private String gridTotal;
	private String gridAfecto;
	private String tableColumn;
	private String gridRecaudo;
	private String gridConcepto;
	private String gridNoAfecto;
	
	public static final String SEPARATOR_COLUMN = "|";
	public static final String SEPARATOR_ROW = "#";
	
	public int getGridIndex() {
		return gridIndex;
	}
	public void setGridIndex(int gridIndex) {
		this.gridIndex = gridIndex;
	}
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
	public String getTableColumn() {
		
		this.tableColumn = StringUtil.implode(new String[] {
				Util.intToStr(gridIndex),
				gridRecaudo,
			    gridConcepto,
			    gridNoAfecto,
			    gridAfecto,
			    gridIgv,
			    gridTotal
			}, SEPARATOR_COLUMN).substring(1);
		
		return tableColumn;
	}
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}
	public String getTableRow() {
		
		StringBuilder sb = new StringBuilder();
        sb.append(this.tableColumn).append(SEPARATOR_ROW);
		
        this.tableRow = sb.toString();
		
		return tableRow;
	}
	public void setTableRow(String tableRow) {
		this.tableRow = tableRow;
	}
	
	
}
