package br.com.ibiraweb.iqualitywebws;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "iqualityws.FaultBean")
public class InvalidInputException extends Exception {

    private static final long serialVersionUID = 1L;

    private FaultBean faultBean;

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message, FaultBean faultBean, Throwable cause) {
        super(message, cause);
        this.faultBean = faultBean;
    }

    public InvalidInputException(String message, FaultBean faultBean) {
        super(message);
        this.faultBean = faultBean;
    }

    public FaultBean getFaultInfo() {
        return faultBean;
    }
    
    
    
    
    
}