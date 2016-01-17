package br.com.ibiraweb.iqualitywebws;

import java.sql.Connection;



public class DataSource {
   	
	
    public DataSource() {
    	
    }

    public String[][] SelectProcedure(String callsintax,Connection conn) throws InvalidInputException{
		return new DBUtil().getResultProcedure(callsintax,conn);
	}
    
	public String[][] Select(String table,String colunas,String condition,String orderby,Connection conn) throws InvalidInputException{
		return new DBUtil().getResult(table, colunas, condition,orderby,conn);
	}
	
	public boolean Delete(String table,String  condition,Connection conn) throws InvalidInputException{
		return new DBUtil().getResultDelete(table, condition,conn);
	}
	
	public boolean Update(String table,String  set,String condition,Connection conn) throws InvalidInputException{
		return new DBUtil().getUpdate(table, set,condition,conn);
	}
	
	public boolean Insere(String table,String  colunas,String colunasValores,String condition,Connection conn,boolean noValue) throws InvalidInputException{
		return new DBUtil().getInsere(table, colunas,colunasValores,condition,conn,noValue);
	}
	 
	
	
}
