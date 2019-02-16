package com.efact.bean;

import java.io.Serializable;
import java.util.List;

public class VoucherTrData implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String programa;
    private int grupo;
    private int cupo;
    private String contrato;
    private String asociado;
    private String cuota;   
        
    private String banco;
    private String cuentaBancaria;
    private int fecDeposito;
    private String moneda;
    private float monto;
    private float saldo;
            
    private List<VoucherTrDataDetail> listVoucherTrDataDetail;

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getAsociado() {
		return asociado;
	}

	public void setAsociado(String asociado) {
		this.asociado = asociado;
	}

	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public int getFecDeposito() {
		return fecDeposito;
	}

	public void setFecDeposito(int fecDeposito) {
		this.fecDeposito = fecDeposito;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<VoucherTrDataDetail> getListVoucherTrDataDetail() {
		return listVoucherTrDataDetail;
	}

	public void setListVoucherTrDataDetail(List<VoucherTrDataDetail> listVoucherTrDataDetail) {
		this.listVoucherTrDataDetail = listVoucherTrDataDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    

}
