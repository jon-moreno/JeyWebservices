package com.jey.pending;

import javax.jws.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.jey.connection.PendingDBOracleConnection;

@WebService
public class PendingWS {
	
	Connection conn;

	@WebMethod
	public void createCustomer() {
		conn = PendingDBOracleConnection.getOracleConnection();
        try {
        	//TODO Replace below with DB stored proc
            String sql = "call DELETE_GAME_STATE(?)";            	
            CallableStatement myCallable = conn.prepareCall(sql);	
            //myCallable.setInt(1, gid);
            
            myCallable.executeUpdate();
            
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
		
	}
	
	@WebMethod
	public void getCustomer() {
	}
	
	@WebMethod
	public void deleteCustomer() {
	}
}
