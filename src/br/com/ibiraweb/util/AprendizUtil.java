package br.com.ibiraweb.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;

import br.com.ibiraweb.iqualitywebws.FaultBean;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;


public class AprendizUtil {

	
	private static Properties prop = new Properties();
	
	private static AprendizUtil instance;
	private static String atualDir; 
	
	static {
		try {
			instance = new AprendizUtil();
			atualDir = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext ()).getRealPath("/")
		            +Constants.DIRETORIO_WEB_INF_E_CLASSES+"/iqualityweb.properties";
		} catch (Exception se) {
			se.printStackTrace();
		}
	}
	
	
	private AprendizUtil()  {
	}
	
	public static AprendizUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new AprendizUtil();
			atualDir = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext ()).getRealPath("/")
		            +Constants.DIRETORIO_WEB_INF_E_CLASSES+"/iqualityweb.properties";
		}
		return instance;
	}
	
	   public static Properties propertiesLoader() throws IOException{
	            System.out.println(atualDir);
	            File file = new File(atualDir);  
	            FileInputStream fileInputStream = new FileInputStream(file);
	            prop.load(fileInputStream);
	            fileInputStream.close();           
	            return prop;
	   }
	   
	   
	
		
	   public XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date)
				throws DatatypeConfigurationException {
			if (date != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				XMLGregorianCalendar gregCreationDate = DatatypeFactory
						.newInstance().newXMLGregorianCalendar();
				gregCreationDate.setYear(cal.get(Calendar.YEAR));
				gregCreationDate.setDay(cal.get(Calendar.DAY_OF_MONTH));
				gregCreationDate.setMonth(cal.get(Calendar.MONTH) + 1);
				gregCreationDate.setHour(cal.get(Calendar.HOUR_OF_DAY));
				gregCreationDate.setMinute(cal.get(Calendar.MINUTE));
				gregCreationDate.setSecond(cal.get(Calendar.SECOND));
				gregCreationDate.setMillisecond(cal.get(Calendar.MILLISECOND));
				// Calendar ZONE_OFFSET and DST_OFFSET fields are in milliseconds.
				int offsetInMinutes = (cal.get(Calendar.ZONE_OFFSET) + cal
						.get(Calendar.DST_OFFSET)) / (60 * 1000);
				gregCreationDate.setTimezone(offsetInMinutes);
				return gregCreationDate;
			}
			return null;
		}
		

		// Converts an XMLGregorianCalendar to an instance of java.util.Date
		public java.util.Date convertXMLGregorianCalendarToDate(XMLGregorianCalendar xmlGC) {
			if (xmlGC == null) {
				return null;
			} else {
				return xmlGC.toGregorianCalendar().getTime();
			}
		}

		public DateTime convertStringToDateTime(String date) throws InvalidInputException {
			DateTime datetime = new DateTime();
			
			int ano = 0;
			int mes = 0;
			int dia = 0 ;
			int hora = 0;
			int minuto = 0;

			try{

				ano = new Integer((date).substring(0,4));
				mes = new Integer((date).substring(5,7));
				dia = new Integer((date).substring(8,10));
				hora = new Integer((date).substring(11, 13));
				minuto = new Integer((date).substring(14, 16));

				
				
			}catch(Exception x){
				throw new InvalidInputException("Problemas ao Converter String Para DateTime em iQualityUtils.java..| ", new FaultBean(), x);
			}
			
			return  new DateTime(ano,mes,dia,hora,minuto);
			
		}
		
		
	
		
		
	    public String getContextParameter(String parameter) {
	        FacesContext ctx = FacesContext.getCurrentInstance();
	        String myConstantValue =
	                ctx.getExternalContext().getInitParameter(parameter);
	        return myConstantValue;
	    }
		

public static byte[] readFileToByte(String service) throws IOException  {

    //if ( file.length() > MAX_FILE_SIZE ) {
     //   throw new FileTooBigException(file);
   // }
	
	
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	String path = externalContext.getRequestContextPath();
	path += path.endsWith("/") ? "resources/services/"+service : "/resources/services/"+service;
	String url = externalContext.encodeResourceURL(path);
	
	File fis = new File(url);
    
    ByteArrayOutputStream ous = null;
    InputStream ios = null;
    try {
        byte[] buffer = new byte[4096];
        ous = new ByteArrayOutputStream();
        ios =	externalContext.getResourceAsStream("/resources/services/"+service);// new FileInputStream(service);
        int read = 0;
        while ( (read = ios.read(buffer)) != -1 ) {
            ous.write(buffer, 0, read);
        }
    } finally { 
        try {
             if ( ous != null ) 
                 ous.close();
        } catch ( IOException e) {
        }

        try {
             if ( ios != null ) 
                  ios.close();
        } catch ( IOException e) {
        }
    }
    return ous.toByteArray();
}
	
}
