package com.efact.action;

import com.efact.dao.factory.DaoFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.efact.dao.interfaces.*;
import com.efact.util.Dates;
/*import com.efact.util.Const;
import com.efact.util.Dates;*/
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.efact.bean.*;

public class ExchangeRateAction extends ActionSupportBase implements ServletRequestAware, ServletResponseAware  {

	private static final long serialVersionUID = 1L;
	private DaoFactory dao;
	private Gson gson;
	private ExchangeRate exchangeRate;
	private List<ExchangeRate> listExchangeRate;	
	private String currentDate, dateOneYearAgo;
	
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	
    public ExchangeRateAction() {
		dao = DaoFactory.getDAOFactory(DaoFactory.ORACLE);		
		gson = new GsonBuilder().setPrettyPrinting().create();
		currentDate = Dates.getCurrentDate();
		dateOneYearAgo = Dates.getDateOneYearAgo();
			
    }
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String index() throws Exception {
		
		ExchangeRateDao erDao = dao.getExchangeRateDao();
        
		//VoucherDao voucherDao = dao.getVoucherDao();		
        //listVoucherDropdown = voucherDao.listVoucherDropdown(Const.MODULE_NOTE_CREDIT);
		
		//setListExchangeRate(erDao.listExchangeRate());
		
		listExchangeRate = erDao.listExchangeRate();
								
        
		return SUCCESS;
	}

	/*
	public String search() throws Exception {
		
        String fields = request.getParameter("fields");
        ExchangeRate erObj = gson.fromJson(serializeToJSON(fields), ExchangeRate.class);
        
        
        ExchangeRateDao erDao = dao.getExchangeRateDao();
       // exchangeRate = erDao.search(erObj);  
        
        
        //listNoteCreditType = ncDao.listNoteCreditType();
		currentDate = Dates.getCurrentDate();
        
		return SUCCESS;
	}
*/
	
	public String process() throws Exception {

			
        String fields = request.getParameter("fields");
        ExchangeRate erObj = gson.fromJson(fields, ExchangeRate.class);
		
        ExchangeRateDao erDao = dao.getExchangeRateDao();        
        exchangeRate = erDao.process(erObj);
        
        
		return SUCCESS;
	}

	


	public ExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}



	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
		
	public String getDateOneYearAgo() {
		return dateOneYearAgo;
	}

	public void setDateOneYearAgo(String dateOneYearAgo) {
		this.dateOneYearAgo = dateOneYearAgo;
	}
	
	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ExchangeRate> getListExchangeRate() {
		return listExchangeRate;
	}

	/*
	public void setListExchangeRate(List<ExchangeRate> listExchangeRate) {
		this.listExchangeRate = listExchangeRate;
	}
*/

}
