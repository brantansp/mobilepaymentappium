package mBankingUtility;

import java.lang.invoke.MethodHandles;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//
public class dbTransactionlog {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@//10.144.24.45:1527/ormpypre";
	private static final String DB_USER = "UNBI_P2TEST";
	private static final String DB_PASSWORD = "unbi_p2test321#";
	private static Connection dbConnection = null;
	private static Statement statement = null;
	private static String transactionID="735418241323";
	private static String result[]= new String [10];//= "";
	private static ResultSet resultSet;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	//check2
	public static void main(String[] argv) {
		try {
			fetchRecord(transactionID);
		} catch (SQLException e) {
			log.info(e.getMessage());
		}
	}

	public static String [] fetchRecord( String transactionID) throws SQLException {

		String selectTableSQL = "select txnauthid, txndatetime, txntype ,  txnstatus , Error_Type, Errorcode, Error_Msg, Responsecode, Response_Description from Transactionlog WHERE TXNAUTHID ='"+transactionID+"'";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			
			resultSet = statement.executeQuery(selectTableSQL);
			//ResultSetMetaData rsmd = resultSet.getMetaData();
			resultSet.next();
			/*
			 result[20] = resultSet.getString("txnauthid") +"|"+
					 resultSet.getString("txntype") +"|"+
	                       resultSet.getString("txnstatus") +"|"+
	                       resultSet.getString("Error_Type")+"|"+
			  resultSet.getString("Errorcode")+"|"+
			  resultSet.getString("Responsecode")+"|"+
			  resultSet.getString("Response_Description")+"|"+
			  resultSet.getString("Errorcode");
			*/
			result[0] = resultSet.getString("txnauthid") ;
			result[1] = resultSet.getString("txndatetime") ;
			result[2] = resultSet.getString("txntype") ;
			result[3] = resultSet.getString("txnstatus");
			result[4] = resultSet.getString("Error_Type");
			result[5] = resultSet.getString("Errorcode");
			result[6] = resultSet.getString("Error_Msg");
			result[7] = resultSet.getString("Responsecode");
			result[8] = resultSet.getString("Response_Description");
			
		}catch (SQLException e) {
			log.info(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return result;
	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			log.info(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			log.info(e.getMessage());
		}
		return dbConnection;
	}

	 public void clear() {
	 		if (resultSet != null) {
	 			try {
	 				resultSet.close();
	 			} catch (final SQLException e) {
	 				e.printStackTrace();
	 			}
	 			resultSet = null;
	 		}
	 		if (statement != null) {
	 			try {
	 				statement.close();
	 			} catch (final SQLException e) {
	 				e.printStackTrace();
	 			}
	 			statement = null;
	 		}
	 	} 	

}










