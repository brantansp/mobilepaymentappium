package mBankingUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//
public class WriteToCSVFile {
	public static String Transaction ;
	public static String txndatetime;
	public static String dbResult ;
	public static String Txnauthid ;
	public static String Txntype ;
	public static String Txnstatus ;
	public static String Error_Type ;
	public static String Errorcode ;
	public static String Error_Msg ;
	public static String Responsecode ;
	public static String Response_Description ;
	public static String [] result ;
	
    public static void main(String[]args) throws IOException{}
    
    public static void reportGeneration(String transaction, String dbResult[]) throws FileNotFoundException
    {
    	Transaction = transaction;
    	result = dbResult;
    	File dir = new File(".\\reports");
    	if (!dir.exists())
    	{
    		dir.mkdirs();
    	}
    	String savestr = "Result.csv"; 
    	File file = new File(dir, savestr);
    	PrintWriter pw ;//new PrintWriter(file);
    	StringBuilder sb = new StringBuilder();
    	if(file.exists() )
    	{
    		pw = new PrintWriter(new FileOutputStream(file, true));
    	} else {
   //txnauthid, txndatetime, txntype ,  txnstatus , Error_Type, Errorcode, Error_Msg, Responsecode, Response_Description
    		pw = new PrintWriter(file);
            sb.append("Transaction");
            sb.append(',');
            sb.append("Status");
            sb.append(',');
            sb.append("Txnauthid");
            sb.append(',');
            sb.append("TxnDateTime");
            sb.append(',');
            sb.append("Txntype");
            sb.append(',');
            sb.append("Txnstatus");
            sb.append(',');
            sb.append("Error_Type");
            sb.append(',');
            sb.append("Errorcode");
            sb.append(',');
            sb.append("Error_Msg");
            sb.append(',');
            sb.append("Responsecode");
            sb.append(',');
            sb.append("Response_Description");
            sb.append('\n');
    	}
        sb.append(Transaction); //transaction
        sb.append(',');
        if (result[3].equals("C"))
        {
            sb.append("PASS");  //transaction status
        }else
        {
            sb.append("FAIL");  //transaction status
        }
        sb.append(',');
        sb.append(result[0]); //txnauthid
        sb.append(',');
        sb.append(result[1]); //txndatetime
        sb.append(',');
        sb.append(result[2]); //txntype
        sb.append(',');
        sb.append(result[3]); //txnstatus
        sb.append(',');
        sb.append(result[4]); //Error_Type
        sb.append(',');
        sb.append(result[5]); //Errorcode
        sb.append(',');
        sb.append(result[6]); //Error_Msg
        sb.append(',');
        sb.append(result[7]); //Responsecode
        sb.append(',');
        sb.append(result[8]); //Response_Description
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
    }

    public static void reportGeneration(String dbResult[]) throws FileNotFoundException
    {
    	result = dbResult;
    	File dir = new File(".\\reports");
    	if (!dir.exists())
    	{
    		dir.mkdirs();
    	}
    	String savestr = "Result.csv"; 
    	File file = new File(dir, savestr);
    	PrintWriter pw ;//new PrintWriter(file);
    	StringBuilder sb = new StringBuilder();
    	if(file.exists() )
    	{
    		pw = new PrintWriter(new FileOutputStream(file, true));
    	} else {
   //txnauthid, txndatetime, txntype ,  txnstatus , Error_Type, Errorcode, Error_Msg, Responsecode, Response_Description
    		pw = new PrintWriter(file);
            sb.append("Txntype");
            sb.append(',');
            sb.append("Status");
            sb.append(',');
            sb.append("Txnauthid");
            sb.append(',');
            sb.append("TxnDateTime");
            sb.append(',');

            sb.append("Txnstatus");
            sb.append(',');
            sb.append("Error_Type");
            sb.append(',');
            sb.append("Errorcode");
            sb.append(',');
            sb.append("Error_Msg");
            sb.append(',');
            sb.append("Responsecode");
            sb.append(',');
            sb.append("Response_Description");
            sb.append('\n');
    	}
        sb.append(result[2]); //txntype
        sb.append(',');
        if (result[3].equals("C"))
        {
            sb.append("PASS");  //transaction status
        }else
        {
            sb.append("FAIL");  //transaction status
        }
        sb.append(',');
        sb.append(result[0]); //txnauthid
        sb.append(',');
        sb.append(result[1]); //txndatetime
        sb.append(',');

        sb.append(result[3]); //txnstatus
        sb.append(',');
        sb.append(result[4]); //Error_Type
        sb.append(',');
        sb.append(result[5]); //Errorcode
        sb.append(',');
        sb.append(result[6]); //Error_Msg
        sb.append(',');
        sb.append(result[7]); //Responsecode
        sb.append(',');
        sb.append(result[8]); //Response_Description
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
    }

}
