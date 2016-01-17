/**
 * Nome do pacote: br.gov.caixa.util
 */
package br.com.ibiraweb.util;

/**
 * Nome: StringUtils.java <br />
 * Descrição: Classe utilitaria de Strings	<br />
 * 
 * Equipe Responsável: <b> Arquitetura Caixa Economica Federal <b><br />
 *
 * Data: 29/11/2013 <br/>
 * Hora Manutenção: 10:00:51 <br/>
 *
 * @author <b>Capgemini<b> Copyright (c) 2013
 */
public class StringUtils {

	/**
	 * Nome: isEmpty <br />
	 * Propósito: isEmpty <br />
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return org.apache.commons.lang.StringUtils.isEmpty(str);
	}
	
	/**
	 * Nome: isEmpty <br />
	 * Propósito: isNotEmpty <br />
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !org.apache.commons.lang.StringUtils.isEmpty(str);
	}
	
	/**
	 * Nome: capitalize  <br />
	 * Propósito: capitalize <br />
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalize(String str) {
		return org.apache.commons.lang.StringUtils.capitalize(str);
	}
	
	/**
	 * Nome:  <br />
	 * Propósito:  <br />
	 * 
	 * @param collection
	 * @param separator
	 * @return
	 */
	public static String join(String[] collection, String separator) {
		return org.apache.commons.lang.StringUtils.join(collection, separator);
	}
	
	/**
	 * Nome: isBlank <br />
	 * Propósito: isBlank <br />
	 * 
	 * @param arg0
	 * @return
	 */
	public static boolean isBlank(String arg0) {
		return org.apache.commons.lang.StringUtils.isBlank(arg0);
	}
	
	/**
	 * Nome: isNumeric <br />
	 * Propósito: isNumeric <br />
	 * 
	 * @param arg0
	 * @return
	 */
	public static boolean isNumeric(String arg0) {
		return org.apache.commons.lang.StringUtils.isNumeric(arg0);
	}
	
	/**
	 * Only numbers.
	 *
	 * @param content the content
	 * @return the string
	 */
	public static String onlyNumbers(String content) {
		if (isEmpty(content)) return content;
		return content.replaceAll("[^0-9]+", "");
	}

	/**
	 * Split at position.
	 *
	 * @param content the content
	 * @param position the position
	 * @return the string[]
	 */
	public static String[] splitAtPosition(String content, int position) {
		if (isEmpty(content)) return new String[] {};
		return content.replaceFirst("(?s)(.{" + position + "})(.*)", "$1#@#$2").split("#@#");
	}

	/**
	 * Adiciona o parametro <b>ch</b> ao inicio e ao final do parametro <b>cs</b> e retorna a String resultante.
	 *
	 * @param cs the cs
	 * @param ch the ch
	 * @return the string
	 * @author hugo.kroehn
	 */
	public static String surroundWith(CharSequence cs, Character ch) {
		return surroundWith(cs, ch, ch);
	}

	/**
	 * Adiciona o parametro <b>chInicio</b> ao inicio e o parimetro <b>chFim</b> ao final do parametro <b>cs</b> e
	 * retorna a String resultante.
	 *
	 * @param cs the cs
	 * @param chInicio the ch inicio
	 * @param chFim the ch fim
	 * @return the string
	 * @author hugo.kroehn
	 */
	public static String surroundWith(CharSequence cs, Character chInicio, Character chFim) {
		StringBuilder sb = new StringBuilder();
		if (cs != null) {
			sb.append(cs);
		}
		if (chInicio != null && chFim != null) {
			sb.append(chFim).insert(0, chInicio);
		}
		return sb.toString();
	}

	/**
	 * To camelcase lower.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String toCamelcaseLower(String str) {
		if (isEmpty(str)) return str;
		final String camelcaseUpper = toCamelcaseUpper(str);
		return camelcaseUpper.substring(0, 1).toLowerCase() + camelcaseUpper.substring(1);
	}

	/**
	 * To camelcase upper.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String toCamelcaseUpper(String str) {
		if (isEmpty(str)) return str;
		final String[] tokens = str.trim().replaceAll("(?m)([-_ ])", "|").replaceAll("(?m)([-_ a-z])([A-Z])", "$1|$2").split("\\|");
		final StringBuilder sb = new StringBuilder();

		for (final String tk : tokens) {
			sb.append(capitalize(tk.toLowerCase()));
		}

		return sb.toString();
	}

	/**
	 * To underscore lower.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String toUnderscoreLower(String str) {
		if (str == null || str.trim().length() == 0) return str;
		final String result = str.trim().replace(' ', '_').replace('-', '_').replaceAll("(?m)([a-z0-9])([A-Z])", "$1_$2").toLowerCase();

		return result;
	}

	/**
	 * To underscore upper.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String toUnderscoreUpper(String str) {
		if (str == null || str.trim().length() == 0) return str;
		return toUnderscoreLower(str).toUpperCase();
	}

	/**
	 * Retirar tags html.
	 *
	 * @param stringHtml the string html
	 * @return the string
	 */
	public static String removeHtmlTags(String stringHtml) {
		String stringAuxiliar = "";
		stringAuxiliar = stringHtml.replaceAll("\\<.*?\\>", "");
		return stringAuxiliar.replaceAll("(\\r|\\n)", "");
	}

	/**
	 * Retorna a quantidade de um determinado caractere em uma determinada String.
	 * 
	 * @param c char que sera contado.
	 * @param str String que sera analisada.
	 * @return Quantidade de c em str.
	 */
	public static int countChar(char c, String str) {
		int cont = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) cont++;
		}
		return cont;
	}

	/**
	 * Completa a direita de uma determinada String com o caractere 'c', truncando para o tamanho 'length'
	 * 
	 * @param str String que sera completada.
	 * @param c Caractere que sera usado para completar.
	 * @param length Quantidade de repeticoes do caractere.
	 * @return String formatada.
	 */
	public static String rightPadTrunc(String str, char c, int length) {
		return complete(str, c, length, true);
	}

	/**
	 * Completa a esquerda de uma determinada String com o caractere 'c', truncando para o tamanho 'length'
	 * 
	 * @param str String que sera completada.
	 * @param c Caractere que sera usado para completar.
	 * @param length Quantidade de repeticoes do caractere.
	 * @return String formatada.
	 */
	public static String leftPadTrunc(String str, char c, int length) {
		return complete(str, c, length, false);
	}

	/**
	 * Completa a direita ou esquerda de uma determinada String com o caractere e o tamanho informado 
	 * 
	 * @param str String que sera completada.
	 * @param c Caractere que sera usado para completar.
	 * @param length Tamanho final da string.
	 * @param after Se true, define que os caracteres serao colocados a direita da str. Se false, colocara a esquerda.
	 * @return String formatada.
	 */
	private static String complete(String str, char c, int length, boolean after) {

		StringBuilder retorno;
		str = returnBlank(str);

		if (length < 1) length = 0;
		int difference = length - str.length();
		if (difference < 1) return str.substring(0, length);

		if (after) {
			retorno = new StringBuilder(str);
		} else {
			retorno = new StringBuilder();
		}

		for (int i = 0; i < difference; i++) {
			retorno.append(c);
		}

		if (!after) {
			retorno.append(str);
		}

		return retorno.toString();

	}

	/**
	 * Retorna string em branco, caso object seja nulo
	 * 
	 * @param str
	 * @return
	 */
	public static String returnBlank(Object str) {
		if (str == null) {
			return "";
		} else {
			return str.toString();
		}
	}

	/**
	 * Retorna TRUE se for S ou FALSE se for N ou espaco em branco 
	 * @param str
	 * @return TRUE se S, FALSE se N ou nulo
	 */
	public static Boolean tratarSNBoolean(String str) {
		if ("S".equals(str)) {
			return Boolean.TRUE;
		} else if ("N".equals(str) || " ".equals(str)) {
			return Boolean.FALSE;
		}
		return null;
	}

	/**
	 * Retorna a String como os os caracteres especiais html normalizados 
	 * @param str
	 * @return String com os caracteres especiais html normalizados
	 */
	public static String normalLizaCaracteresEspciaisHtml(String str) {

		str = str.replaceAll("á", "&aacute;");
		str = str.replaceAll("é", "&eacute;");
		str = str.replaceAll("í", "&iacute;");
		str = str.replaceAll("ó", "&oacute;");
		str = str.replaceAll("ú", "&uacute;");
		str = str.replaceAll("ã", "&atilde;");
		str = str.replaceAll("õ", "&otilde;");
		str = str.replaceAll("ç", "&ccedil;");
		str = str.replaceAll("à", "&agrave;");
		str = str.replaceAll("â", "&acirc;");
		str = str.replaceAll("ê", "&ecirc;");
		str = str.replaceAll("ô", "&ocirc;");

		str = str.replaceAll("�?", "&Aacute;");
		str = str.replaceAll("É", "&Eacute;");
		str = str.replaceAll("�?", "&Iacute;");
		str = str.replaceAll("Ó", "&Oacute;");
		str = str.replaceAll("Ú", "&Uacute;");
		str = str.replaceAll("Ã", "&Atilde;");
		str = str.replaceAll("Õ", "&Otilde;");
		str = str.replaceAll("Ç", "&Ccedil;");
		str = str.replaceAll("À", "&Agrave;");
		str = str.replaceAll("Â", "&Acirc;");
		str = str.replaceAll("Ê", "&Ecirc;");
		str = str.replaceAll("Ô", "&Ocirc;");

		str = str.replaceAll("ª", "&ordf;");
		str = str.replaceAll("º", "&ordm;");

		return str;
	}

}
