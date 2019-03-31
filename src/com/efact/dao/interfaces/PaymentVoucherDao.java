package com.efact.dao.interfaces;

import java.util.List;
import com.efact.bean.*;

public interface PaymentVoucherDao {

	public List<PaymentHeader> findAll() throws Exception;
	public PaymentHeader findOneById(String id) throws Exception;
	public PaymentHeader getHeader() throws Exception;
	public PaymentProcess insert(PaymentProcess paymentProcess, PaymentDetailProcess paymentDetailProcess) throws Exception;
	
}
