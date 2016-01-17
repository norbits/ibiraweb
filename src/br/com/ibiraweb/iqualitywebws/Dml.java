package br.com.ibiraweb.iqualitywebws;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ibiraweb.mock.Mock;
import br.com.ibiraweb.util.ReflectionUtils;

public class Dml {
	private DataSource ds;

	private static final transient Logger log = LoggerFactory
			.getLogger(Dml.class);

	private static Connection conn = null;

	private static boolean habilitaMock;

	private static Dml instance = null;
	
	private static boolean isTransaction = false;
	
	

	public static Dml getInstance() throws InvalidInputException {

		if (instance == null) {
			instance = new Dml();
		}

		FacesContext ctx = FacesContext.getCurrentInstance();
		String myConstantValue = ctx.getExternalContext().getInitParameter(
				"ambiente");

		if (myConstantValue.equals("desenvolvimento")) {
			habilitaMock = true;
		} else {
			habilitaMock = false;

		}
		return instance;
	}

	public boolean altera(String table, String set, String condition,
			boolean isMock) throws InvalidInputException {

		ds = new DataSource();

		boolean ret = false;

		if (isHabilitaMock() && isMock) {
			return true;
		} else {
			
			if (!isTransaction){ // se for transacao é feita a conexao no inicio transaction
				conn = fazConexao();
			}
		}

		try {
			if (!conn.isClosed()) {
				ret = ds.Update(table, set, condition, conn);
			}
		} catch (SQLException e) {
			throw new InvalidInputException(
					" Problema ao fazer a conexao com o banco!  |",
					new FaultBean(), e);

		} finally {
			if (!isTransaction){ // se for transacao é feita a conexao no inicio transaction
				try {
					if (conn != null || !conn.isClosed()) {
						conn.close();
					}
				} catch (Exception e) {
					conn = null;
					throw new InvalidInputException(
							"Problemas ao fechar Conexão..|\n" + e.getMessage(),
							new FaultBean(), e);
				}
			}
		}

		ds = null;
		return ret;
	}

	public <T> List<T> busca(String table, String columns, String orderBy,
			String condition, boolean isMock, Object obj)
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		ds = new DataSource();
		String[][] result = null;
		List<Object> objList = new ArrayList<Object>();

		if (isHabilitaMock() && isMock) {

			result = (String[][]) ReflectionUtils.executeGetMethod(obj
					.getClass().getSimpleName(), new Mock());

		} else {
			conn = fazConexao();
		}

		try {
			if (conn != null && !conn.isClosed()) {
				result = new DataSource().Select(table, columns, condition,
						orderBy, conn);
			}
		} catch (SQLException e) {
			throw new InvalidInputException(
					" Problema ao fazer a conexao com o banco!  |",
					new FaultBean(), e);

		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				conn = null;
				throw new InvalidInputException(
						"Problemas ao fechar Conexão..|\n" + e.getMessage(),
						new FaultBean(), e);
			}
		}

		ds = null;
		return (List<T>) returnData(obj, result);
	}

	public boolean deleta(String table, String conditions, boolean isMock) throws InvalidInputException,
			br.com.ibiraweb.iqualitywebws.InvalidInputException {

		ds = new DataSource();

		boolean ret = false;

		if (isHabilitaMock() && isMock) {
			return true;
		} else {
			if (!isTransaction){ // se for transacao é feita a conexao no inicio transaction
				conn = fazConexao();
			}
		}

		try {
			if (!conn.isClosed()) {
				ret = ds.Delete(table, conditions, conn);
			}
		} catch (SQLException e) {
			throw new InvalidInputException(
					" Problema ao fazer a conexao com o banco!  |",
					new FaultBean(), e);

		} finally {
			if (!isTransaction){ // se for transacao é feita a conexao no inicio transaction
				try {
					if (conn != null || !conn.isClosed()) {
						conn.close();
					}
				} catch (Exception e) {
					conn = null;
					throw new InvalidInputException(
							"Problemas ao fechar Conexão..|\n" + e.getMessage(),
							new FaultBean(), e);
				}
			}
		}

		ds = null;
		return ret;
	}

	public boolean inclui(String table, String columns, String valores,
			String conditions, boolean isMock) throws InvalidInputException,
			br.com.ibiraweb.iqualitywebws.InvalidInputException {

		ds = new DataSource();

		boolean ret = false;

		if (isHabilitaMock() && isMock) {
			return true;
		} else {
			if (!isTransaction){ // se for transacao é feita a conexao no inicio transaction
				conn = fazConexao();
			}
		}

		try {
			if (!conn.isClosed()) {
				ret = ds.Insere(table, columns, valores, conditions, conn, true);
			}
		} catch (SQLException e) {
			throw new InvalidInputException(
					" Problema ao fazer a conexao com o banco!  |",
					new FaultBean(), e);

		} finally {
			if (!isTransaction){ // se for transacao é feita a conexao no inicio transaction
				try {
					if (conn != null || !conn.isClosed()) {
						conn.close();
					}
				} catch (Exception e) {
					conn = null;
					throw new InvalidInputException(
							"Problemas ao fechar Conexão..|\n" + e.getMessage(),
							new FaultBean(), e);
				}
			}
		}

		ds = null;
		return ret;
	}

	public static Connection fazConexao() throws InvalidInputException {
		boolean retorno = false;
		isTransaction = false;
		try {
			Context ctx = new InitialContext();
			if (ctx == null) {
				throw new InvalidInputException(
						"Problemas ao Iniciar o Context\n Favor entrar em contato com Administrador.|",
						new FaultBean());
			} else {
				javax.sql.DataSource ds =
				/* TOMCAT */(javax.sql.DataSource) ctx
						.lookup("java:comp/env/jdbc/ibiraDs");
				/*
				 * jboss (javax.sql.DataSource) ctx
				 * .lookup("java:jboss/datasources/MySqlDSAprendiz");
				 */
				if (ds != null) {
					conn = ds.getConnection();
					if (conn == null) {
						throw new InvalidInputException(
								"Problemas ao Iniciar a Conexão\n Favor entrar em contato com Administrador.|",
								new FaultBean());
					}
				} else {
					throw new InvalidInputException(
							"Problemas ao Fazer Look UP. -> java:comp/env/jdbc/iQualityDBWebWS |Erro: ",
							new FaultBean());
				}
				retorno = true;
			}
		} catch (Exception e) {
			throw new InvalidInputException(
					"Problemas ao Tentar se Conectar ao Banco\n Favor entrar em contato com Administrador.|"
							+ e.getMessage(), new FaultBean(), e);
		}
		return conn;
	}

	public static boolean isHabilitaMock() {
		return habilitaMock;
	}

	public static void setHabilitaMock(boolean habilitaMock) {
		Dml.habilitaMock = habilitaMock;
	}

	private static <T> List<T> returnData(Object obj, String[][] retorno)
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		List<Object> objList = new ArrayList<Object>();

		for (int i = 1; i < retorno.length; i++) {

			Class beanClass = Class.forName(obj.getClass().getName());
			Object beanInstance = beanClass.newInstance();

			for (int x = 0; x < retorno[i].length; x++) {
				for (Field field : getAllFields(beanInstance.getClass())) {
					String fieldTabela = retorno[0][x];// .substring(0,1).toUpperCase()
														// +
														// retorno[0][x].substring(1);;
					if (field.getName().equals(fieldTabela)) {
						ReflectionUtils.executeSet(field, beanInstance,
								retorno[i][x]);
					}
				}
			}
			objList.add(beanInstance);
		}

		return (List<T>) objList;

	}
	
	
	public void iniciaTransacao() throws SQLException, InvalidInputException{
		conn = fazConexao();
		isTransaction = true;
		conn.setAutoCommit(false);
	}
	
	public void finalizaTransacao() throws InvalidInputException {
		
		try {
			
			conn.commit();
			
			if (conn != null || !conn.isClosed()) {
				conn.close();
				isTransaction = false;
			}
		} catch (Exception e) {
			conn = null;
			throw new InvalidInputException(
					"Problemas ao fechar Conexão..No mode Transaction |\n" + e.getMessage(),
					new FaultBean(), e);
		}
		
		
	}

	private static List<Field> getAllFields(Class<?> classRequest) {
		List<Field> fields = new ArrayList<Field>();
		getAllFields(fields, classRequest);

		return fields;
	}

	private static List<Field> getAllFields(List<Field> fields,
			Class<?> classRequest) {
		fields.addAll(Arrays.asList(classRequest.getDeclaredFields()));

		return fields;
	}

}
