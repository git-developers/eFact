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
	public PaymentProcess insert(PaymentProcess paymentProcess, PaymentDetailProcess paymentDetailProcess) throws Exception {
		
		PaymentProcess objectOut = new PaymentProcess();

        try{
    		
            String sql = "{ call FIN_PKG_COMPROBANTEMANUAL.USP_EMITIR_COMPROBANTEMANUAL(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) } "; 
            
            Connection connection = OracleDaoFactory.getMainConnection();
			CallableStatement st = connection.prepareCall(sql);
			st.setString(1, paymentProcess.getQueryContrato());
            st.setInt(2, paymentProcess.getQueryTipoDoi());
            st.setString(3, paymentProcess.getQueryNumeroDoi());
            st.setString(4, paymentProcess.getQueryTitular());
            st.setString(5, paymentProcess.getQueryDireccion());
            st.setInt(6, paymentProcess.getQueryComprobante());
            st.setInt(7, paymentProcess.getQuerySerieComprobante());
            st.setInt(8, paymentProcess.getQueryFechaEmision());
            st.setInt(9, paymentProcess.getQueryFechaVencimiento());
            st.setInt(10, paymentProcess.getQueryTotal());
            st.setString(11, paymentProcess.getQueryTotalTexto());
            st.setString(12, paymentProcess.getQueryTipoMoneda());
            st.setString(13, paymentProcess.getQueryDescripcionMoneda());
            st.setString(14, paymentDetailProcess.getDetail());
            st.setString(15, "EZANABRIA");
            st.execute();
        	
            ResultSet rs = (ResultSet) st.getObject(4);
            
            while (rs.next()){
            	objectOut.setNumeroComprobante(rs.getString("P_NUMERO_COMPROBANTE"));
            	objectOut.setExito(rs.getInt("P_EXITO"));
            	objectOut.setMensaje(rs.getString("P_MENSAJE"));
            }
            
            rs.close();
            st.close();
            
        } catch (Exception e){
        	e.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return objectOut;
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
             * Cursor: Recaudo
             */
            ResultSet rsRecaudo = (ResultSet) st.getObject(4);
            List<PaymentRecaudo> listRecaudo = new ArrayList<PaymentRecaudo>();
            while (rsRecaudo.next()) {
            	PaymentRecaudo o = new PaymentRecaudo();
            	o.setIdRecaudo(rsRecaudo.getInt("ID_RECAUDO"));
            	o.setDescripcion(rsRecaudo.getString("DESCRIPCION"));
            	listRecaudo.add(o);
            }                
            objectOut.setListPaymentRecaudo(listRecaudo);  
            
            
            /**
             * Cursor: Concepto
             */
            ResultSet rsConcepto = (ResultSet) st.getObject(5);
            List<PaymentConcepto> listConcepto = new ArrayList<PaymentConcepto>();
            while (rsConcepto.next()) {
            	PaymentConcepto o = new PaymentConcepto();
            	o.setIdRecaudo(rsConcepto.getInt("ID_RECAUDO"));
            	o.setIdConcepto(rsConcepto.getInt("ID_CONCEPTO"));
            	o.setDescripcion(rsConcepto.getString("DESCRIPCION"));
            	listConcepto.add(o);
            }                
            objectOut.setListPaymentConcepto(listConcepto);  
            
            /**
             * Close
             */
            rsTipoDoi.close();
            rsRecaudo.close();
            rsTipoComprobante.close();
            rsTipoMoneda.close();
            rsConcepto.close();

            st.close();
            
        } catch (Exception e){
        	e.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return objectOut;
	}
}
