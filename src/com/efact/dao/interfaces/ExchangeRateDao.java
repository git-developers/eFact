package com.efact.dao.interfaces;

import java.util.List;
import com.efact.bean.*;

public interface ExchangeRateDao {
	
	public List<ExchangeRate> listExchangeRate() throws Exception;
	
	public ExchangeRate process(ExchangeRate object) throws Exception;

	
	//public List<ExchangeRate> search(ExchangeRate object) throws Exception;	
	//public List<NoteCreditType> listNoteCreditType() throws Exception;	
	

}

