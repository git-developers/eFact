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
	public PaymentHeader getHeader() throws Exception {	
		
		PaymentHeader objectOut = new PaymentHeader();

        try{
    		
            String sql = "{ call FIN_PKG_COMPROBANTEMANUAL.USP_LISTAR_CABECERA(?, ?, ?, ?, ?, ?, ?) } "; 
            
            Connection connection = OracleDaoFactory.getMainConnection();
			CallableStatement st = connection.prepareCall(sql);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.registerOutParameter(2, OracleTypes.CURSOR);
            st.registerOutParameter(3, OracleTypes.CURSOR);
            st.registerOutParameter(4, OracleTypes.CURSOR);
            st.registerOutParameter(5, OracleTypes.CURSOR);
            st.registerOutParameter(6, OracleTypes.NUMBER);
            st.registerOutParameter(7, OracleTypes.VARCHAR);
            st.execute();
        	
            
            /**
             * Cursor: Tipo Doi
             */
            ResultSet rsTipoDoi = (ResultSet) st.getObject(1);
            List<PaymentTipoDoi> listTipoDoi = new ArrayList<PaymentTipoDoi>();
            while (rsTipoDoi.next()) {
            	PaymentTipoDoi o = new PaymentTipoDoi();
            	o.setIdTipoDoi(rsTipoDoi.getInt("ID_TIPO_DOI"));
            	o.setNombreCorto(rsTipoDoi.getString("NOMBRE_CORTO"));    		    
            	o.setFlagTipo(rsTipoDoi.getInt("FLAG_TIPO"));
            	o.setLongitud(rsTipoDoi.getInt("LONGITUD"));
                o.setFlagLongitud(rsTipoDoi.getInt("FLAG_LONGITUD"));    		    
                o.setIdEquivalencia(rsTipoDoi.getInt("ID_EQUIVALENCIA"));
                listTipoDoi.add(o);
            }
            objectOut.setListPaymentTipoDoi(listTipoDoi);


            /**
             * Cursor: Tipo Comprobante
             */
            ResultSet rsTipoComprobante = (ResultSet) st.getObject(2);
            List<PaymentTipoComprobante> listTipoComprobante = new ArrayList<PaymentTipoComprobante>();
            while (rsTipoComprobante.next()) {
            	PaymentTipoComprobante o = new PaymentTipoComprobante();
            	o.setCscTipo(rsTipoComprobante.getInt("CSC_TIPO"));
            	o.setCscTipoNombre(rsTipoComprobante.getString("CSC_TIPO_NOMBRE"));
                listTipoComprobante.add(o);
            }
            objectOut.setListPaymentTipoComprobante(listTipoComprobante);
            
            
            /**
             * Cursor: Tipo Moneda
             */
            ResultSet rsTipoMoneda = (ResultSet) st.getObject(3);
            List<PaymentTipoMoneda> listTipoMoneda = new ArrayList<PaymentTipoMoneda>();
            while (rsTipoMoneda.next()) {
            	PaymentTipoMoneda o = new PaymentTipoMoneda();
            	o.setIdMoneda(rsTipoMoneda.getInt("ID_MONEDA"));
            	o.setDescripcion(rsTipoMoneda.getString("DESCRIPCION"));    		    
            	o.setNombreCorto(rsTipoMoneda.getString("NOMBRE_CORTO"));  
            	listTipoMoneda.add(o);
            }                
            objectOut.setListPaymentTipoMoneda(listTipoMoneda);    
            
            /**
             * Close
             */
            rsTipoDoi.close();
            rsTipoComprobante.close();
            rsTipoMoneda.close();
//            rsRecaudo.close();
//            rsConcepto.close();
//            
//            rsTipoComprobante.close();
            st.close();
            
        } catch (Exception e){
        	e.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return objectOut;
	}
}
