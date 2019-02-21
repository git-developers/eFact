package com.efact.dao.oracle;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import com.efact.bean.*;
import com.efact.dao.interfaces.*;
import com.efact.dao.factory.OracleDaoFactory;
import oracle.jdbc.OracleTypes;

public class PaymentVoucherImpDao extends OracleDaoFactory implements PaymentVoucherDao  {

	@Override
	public List<PaymentHeader> findAll() throws Exception {
		return null;
	}

	@Override
	public PaymentHeader findOneById(String id) throws Exception {
		return null;
	}

	@Override
	public PaymentHeader findOneById() throws Exception {
		return null;
	}


}
