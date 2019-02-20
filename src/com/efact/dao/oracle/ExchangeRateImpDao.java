package com.efact.dao.oracle;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import com.efact.bean.*;
import com.efact.dao.interfaces.*;
import com.efact.util.Util;
//import com.efact.util.Util;
import com.efact.dao.factory.OracleDaoFactory;
import oracle.jdbc.OracleTypes;

public class ExchangeRateImpDao extends OracleDaoFactory implements ExchangeRateDao  {
	

	@Override
	public List<ExchangeRate> listExchangeRate() throws Exception {		
				
		List<ExchangeRate> list = new ArrayList<>();

        try{
        	
            String sql = "{ call FIN_PKG_TIPOCAMBIO.P_LISTA_TIPOCAMBIO(?) }"; 
            
            Connection connection = OracleDaoFactory.getMainConnection();
			CallableStatement st = connection.prepareCall(sql);  
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            
            ResultSet rs = (ResultSet) st.getObject(1);
            
            while (rs.next()){
            	
            	ExchangeRate obj = new ExchangeRate();            	
            	
                obj.setId(rs.getInt("TCD_ID"));
                obj.setMoneda(rs.getString("MONEDA"));
                obj.setFecha(rs.getString("TCD_FECHA"));
                obj.setCompra(rs.getString("TCD_COMPRA"));
                obj.setVenta(rs.getString("TCD_VENTA"));                
                obj.setFecCreacion(rs.getString("TCD_FCREACION"));
                obj.setUserCreacion(rs.getString("TCD_UCREACION"));
                
                list.add(obj);
            }
        
        } catch (Exception e){
            System.out.println("listExchangeRate :: Exception :::: " + e.getMessage());
        } finally {
            this.closeConnection();
        }
        
        return list;
	}
    
	@Override
	public ExchangeRate process(ExchangeRate object) throws Exception {
		
		ExchangeRate objectOut = new ExchangeRate();

        try{
    		
            String sql = "{ call FIN_PKG_TIPOCAMBIO.P_REGISTRA_TIPOCAMBIO(?, ?, ?, ?, ?, ?) } "; 
                        
            Connection connection = OracleDaoFactory.getMainConnection();
			CallableStatement st = connection.prepareCall(sql);
						
			st.setFloat(1,  Float.parseFloat(object.getCompra()));
			st.setFloat(2, Float.parseFloat(object.getVenta()));			            
            st.setString(3, object.getUserCreacion());     
            
            st.setString(4, object.getFecha());
            
            
            st.registerOutParameter(5, OracleTypes.VARCHAR);
            st.registerOutParameter(6, OracleTypes.FLOAT);

            st.execute();

            objectOut.setResultado(st.getString(5));            
            objectOut.setStatus(Util.floatToBool(st.getFloat(6)));

            st.close();
            
        } catch (Exception e){
        	System.out.print("TIPO CAMBIO :: process -- Exception ::::: " + e.getMessage());
        } finally {
            this.closeConnection();
        }
      
        return objectOut;
	}


    
}
