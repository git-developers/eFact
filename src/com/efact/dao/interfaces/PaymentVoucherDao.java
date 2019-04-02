package com.efact.dao.interfaces;

import java.util.List;
import com.efact.bean.*;

public interface PaymentVoucherDao {

	public PaymentHeader getHeader() throws Exception;
	public PaymentBody search(PaymentForm paymentProcess) throws Exception;
	public PaymentForm process(PaymentForm paymentProcess, PaymentDetailProcess paymentDetailProcess) throws Exception;

}
