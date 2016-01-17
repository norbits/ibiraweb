/*
 * DBUtil.java
 *
 * Created on July 5, 2002, 2:27 PM
 */

package br.com.ibiraweb.iqualitywebws;


import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;



public class DBUtil {
    public DBUtil() {
    	
    }
    

    
    public String[][] getResultProcedure(String callsintax,Connection conn) throws InvalidInputException {
        
    	CallableStatement  cs = null;
        String[][] result = null;
        StringBuffer sql = new StringBuffer();
        ResultSet rs = null;
        //Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        //conn = DriverManager.getConnection(_dbUrl);
		try {
            //conn = dbConnector.getConnection("java:comp/env/jdbc/ex");
            
            
            sql.append(callsintax);
            
            
            System.out.println("Executa PROCEDURE ---------------------");
  		  	System.out.println(sql.toString());
  		  	cs = conn.prepareCall("{ call "+callsintax+"}");
  		  // CallableStatement cs = conn.prepareCall("{? = call proc (?,?,?,?,?,?,?)}");

  		  	
//  		    // register input parameters
//  		    cs.setString(2, "");
//  		    cs.setString(3, "");
//  		    cs.setString(4, "123");
//  		    // regsiter ouput parameters
//  		    cs.registerOutParameter(5, java.sql.Types.CHAR);
//  		    cs.registerOutParameter(6, java.sql.Types.CHAR);
//  		    cs.registerOutParameter(7, java.sql.Types.CHAR);
  		  
  			cs.registerOutParameter(1, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(2, java.sql.Types.CHAR);
  	        cs.registerOutParameter(3, java.sql.Types.CHAR);
  	        cs.registerOutParameter(4, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(5, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(6, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(7, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(8, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(9, java.sql.Types.CHAR);
  	        cs.registerOutParameter(10, java.sql.Types.CHAR		);
  	      	cs.registerOutParameter(11, java.sql.Types.CHAR);
  			cs.registerOutParameter(12, java.sql.Types.TIMESTAMP);
  			cs.registerOutParameter(13, java.sql.Types.CHAR);
  			cs.registerOutParameter(14, java.sql.Types.CHAR);
  			cs.registerOutParameter(15, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(16, java.sql.Types.CHAR);
  	        cs.registerOutParameter(17, java.sql.Types.CHAR);
  	        cs.registerOutParameter(18, java.sql.Types.CHAR);
  	        cs.registerOutParameter(19, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(20, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(21, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(22, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(23, java.sql.Types.CHAR);
  	        cs.registerOutParameter(24, java.sql.Types.CHAR);
  	        cs.registerOutParameter(25, java.sql.Types.INTEGER);
  	        cs.registerOutParameter(26, java.sql.Types.CHAR);
  	        cs.registerOutParameter(27, java.sql.Types.CHAR);
  		  	
            
           // stmt.setFetchSize(3);
            rs = cs.executeQuery();
            
            
            
            System.out.println("OK ---------------------");
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int colunmCount =  rsmd.getColumnCount();
            rs.last();
             
            int rowCount = rs.getRow();
            rs.beforeFirst();
            result = new String[rowCount+1][colunmCount];
            int j = 0;
            
            while(rs.next()) {
                j++;
                for(int i = 0; colunmCount > i; i++) {
                    String columnName = rsmd.getColumnName(i+1);
                    String value = null;
                    int columnType = rsmd.getColumnType(i+1);
                    if(j == 1) result[0][i] = columnName;
		                    if(Types.VARCHAR == columnType || -1 == columnType) { // All unknow type change to String
		                        String v = rs.getString(columnName);
		                        value = v;
		                    } else if(Types.INTEGER == columnType) {
		                        int v = rs.getInt(columnName);
		                        value = String.valueOf(v);
		                    } else if(Types.DATE == columnType) {
		                        Date v = rs.getDate(columnName);
		                        value = String.valueOf(v);
		                    } else if(Types.TIMESTAMP == columnType) {
		                        Timestamp v = rs.getTimestamp(columnName);
		                        value = String.valueOf(v);
		                    } else if(Types.DECIMAL == columnType) {
		                    	BigDecimal v = rs.getBigDecimal(columnName);
		                        value = String.valueOf(v);   
		                    } else if(Types.BIGINT == columnType) {
		                    	BigDecimal v = rs.getBigDecimal(columnName);
		                        value = String.valueOf(v);
		                        
		                    }else if(Types.VARBINARY == columnType) {
		                    	try {
		                    		BigDecimal v = rs.getBigDecimal(columnName);
		                    		value = String.valueOf(v);	
								} catch (Exception e) {
									value = rs.getString(columnName);
								}
		                    }
		                    if(value == null)
		                        value = "";
		                    result[j][i] = value;
                }
            }
         
        } catch (SQLException e1) {
			throw new InvalidInputException("PROBLEMAS AO EXECUTAR O PROCEDURE = "+sql+" |=> "+e1.getMessage(),new FaultBean(),e1);
		}finally {
			   try {
				
					cs.close();
				
				
			} catch (SQLException e) {
				throw new InvalidInputException("ERRO AO FECHAR Statement |= "+e.getMessage(),new FaultBean(),e);
			}      
        }
        
        return result;
        
    }
    
    public String[][] getResult(String tableName, String colunas,String condition,String orderby,Connection conn) throws InvalidInputException {
        
        Statement stmt = null;
        String[][] result = null;
        StringBuffer sql = new StringBuffer();
        ResultSet rs = null;
        //Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        //conn = DriverManager.getConnection(_dbUrl);
		try {
            //conn = dbConnector.getConnection("java:comp/env/jdbc/ex");
            
            
            sql.append("SELECT "+colunas+" FROM ");
            sql.append(tableName);
            
	        sql.append(condition);
            sql.append(orderby);
            
            System.out.println("Executa SQL ---------------------");
  		  	System.out.println(sql.toString());
            stmt = conn.createStatement();
            
           // stmt.setFetchSize(3);
            rs = stmt.executeQuery(sql.toString());
            System.out.println("OK ---------------------");
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int colunmCount =  rsmd.getColumnCount();
            rs.last();
             
            int rowCount = rs.getRow();
            rs.beforeFirst();
            result = new String[rowCount+1][colunmCount];
            int j = 0;
            
            while(rs.next()) {
                j++;
                for(int i = 0; colunmCount > i; i++) {
                    String columnName = rsmd.getColumnName(i+1);
                    String value = null;
                    int columnType = rsmd.getColumnType(i+1);
                    if(j == 1) result[0][i] = columnName;
		                    if(Types.VARCHAR == columnType || -1 == columnType) { // All unknow type change to String
		                        String v = rs.getString(columnName);
		                        value = v;
		                    } else if(Types.INTEGER == columnType) {
		                        int v = rs.getInt(columnName);
		                        value = String.valueOf(v);
		                    } else if(Types.DATE == columnType) {
		                        Date v = rs.getDate(columnName);
		                        value = String.valueOf(v);
		                    } else if(Types.TIMESTAMP == columnType) {
		                        Timestamp v = rs.getTimestamp(columnName);
		                        value = String.valueOf(v);
		                    } else if(Types.DECIMAL == columnType) {
		                    	BigDecimal v = rs.getBigDecimal(columnName);
		                        value = String.valueOf(v);   
		                    } else if(Types.BIGINT == columnType) {
		                    	BigDecimal v = rs.getBigDecimal(columnName);
		                        value = String.valueOf(v);
		                        
		                    }else if(Types.VARBINARY == columnType) {
		                    	try {
		                    		BigDecimal v = rs.getBigDecimal(columnName);
		                    		value = String.valueOf(v);	
								} catch (Exception e) {
									value = rs.getString(columnName);
								}
		                    }
		                    if(value == null)
		                        value = "";
		                    result[j][i] = value;
                }
            }
         
        } catch (SQLException e1) {
			throw new InvalidInputException("PROBLEMAS AO EXECUTAR O SQL = "+sql+" |=> "+e1.getMessage(),new FaultBean(),e1);
		}finally {
			   try {
				
					stmt.close();
				
				
			} catch (SQLException e) {
				throw new InvalidInputException("ERRO AO FECHAR Statement |= "+e.getMessage(),new FaultBean(),e);
			}      
        }
        
        return result;
        
    }
    
    public boolean getResultDelete(String tabela, String condition,Connection conn ) throws InvalidInputException{
    	PreparedStatement stmt = null;
    	String sql = "";
    	boolean result = false;
    	try {
    		  sql = " delete from "+tabela
    		  		+ " where "+condition;
    		  
    		  System.out.println("Executa SQL ---------------------");
    		  System.out.println(sql.toString());
    		  stmt = conn.prepareStatement(sql);
    		  
    		  stmt.execute();
    		  System.out.println("OK ---------------------");
    		  stmt.close();
    		  result = true;
    		  }catch (SQLException e1) {
    			  if (e1.getSQLState().startsWith("23")) {
    				  throw new InvalidInputException("HA REGISTROS FILHOS. DELEÇÃO NÃO PERMITIDA! | sql = "+sql+" => "+e1.getMessage(),new FaultBean(),e1);
                }   
    		  }catch (Exception e){
    			throw new InvalidInputException("Problemas ao Deletar sql = "+sql+" |=> "+e.getMessage(),new FaultBean(),e);
    		}finally {
 			   try {
 					stmt.close();
 				} catch (SQLException e) {
 					throw new InvalidInputException("ERRO AO FECHAR Statement |= "+e.getMessage(),new FaultBean(),e);
 				}
    		}
    	return result;
    }  
    
    public boolean getUpdate(String tabela, String set,String condition,Connection conn ) throws InvalidInputException{
    	PreparedStatement stmt = null;
    	StringBuffer sql = new StringBuffer();
    	boolean result = false;
    	try {
    		  sql.append(" update ")
    		  	 .append(tabela)
    		  	 .append(" set ")
    		  	 .append(set);
    		  
  	          sql.append(condition);
    		  
    		  System.out.println("Executa SQL ---------------------");
    		  System.out.println(sql.toString());
    		  stmt = conn.prepareStatement(sql.toString());
    		  
    		  stmt.executeUpdate();
    		  System.out.println("OK ------------------------------");
    		  stmt.close();
    		  result = true;
    		  }catch (Exception e){
    			throw new InvalidInputException("Problemas ao realizar Update sql = "+sql+" |=> "+e.getMessage(),new FaultBean(),e);
    		}finally {
  			   try {
  					stmt.close();
  				} catch (SQLException e) {
  					throw new InvalidInputException("ERRO AO FECHAR Statement |= "+e.getMessage(),new FaultBean(),e);
  				}
     		}
    	return result;
    }  
    
    
    public boolean getInsere(String tabela, String colunas, String colunasValores, String condition,Connection conn,boolean noValues ) throws InvalidInputException{
    	PreparedStatement stmt = null;
    	StringBuffer sql = new StringBuffer();
    	boolean result = false;
    	try {
    		  sql.append(" insert into ")
    		  	 .append(tabela)
    		  	 .append(colunas) ;
    		  	 if (noValues){
    		  		 sql.append(" values ");
    		  	 }
    		  	 sql.append(colunasValores);
    		  
  	             sql.append(condition);
    		  
    		  System.out.println("Executa SQL ---------------------");
    		  System.out.println(sql.toString());
    		  stmt = conn.prepareStatement(sql.toString());
    		  
    		  stmt.executeUpdate();
    		  System.out.println("OK ------------------------------");
    		  stmt.close();
    		  result = true;
    		  }catch (Exception e){
    			throw new InvalidInputException("Problemas ao realizar Insert sql = "+sql+" |=> "+e.getMessage(),new FaultBean(),e);
    		}finally {
  			   try {
  					stmt.close();
  				} catch (SQLException e) {
  					throw new InvalidInputException("ERRO AO FECHAR Statement |= "+e.getMessage(),new FaultBean(),e);
  				}
     		}
    	return result;
    }  
    
    

}
