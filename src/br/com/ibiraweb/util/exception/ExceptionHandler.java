package br.com.ibiraweb.util.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;

import org.apache.taglibs.standard.lang.jstl.ELException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ibiraweb.iqualitywebws.InvalidInputException;




public class ExceptionHandler extends ExceptionHandlerWrapper { 

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class); 

	private final javax.faces.context.ExceptionHandler wrapped; 

	public ExceptionHandler(final javax.faces.context.ExceptionHandler wrapped) { 
		this.wrapped = wrapped; 
	} 

	@Override
	public javax.faces.context.ExceptionHandler getWrapped() { 
		return this.wrapped; 
	} 

	@Override
	public void handle() throws FacesException { 
		for (final Iterator<ExceptionQueuedEvent> it = getUnhandledExceptionQueuedEvents().iterator(); it.hasNext();) {
			System.out.println("aqui");
			Throwable t = it.next().getContext().getException(); 
			while ((t instanceof FacesException || t instanceof ELException) 
					&& t.getCause() != null) { 
				t = t.getCause(); 
			}  
			if (t instanceof FileNotFoundException 
					|| t instanceof HandledException 
					|| t instanceof ViewExpiredException
					|| t instanceof ELException
					|| t instanceof ArithmeticException
					|| t instanceof javax.xml.ws.WebServiceException
					|| t instanceof InvalidInputException
					// || t instanceof  javax.el.ELException
					 || t instanceof java.util.MissingResourceException
					)  { 
				final FacesContext facesContext = FacesContext.getCurrentInstance(); 
				final ExternalContext externalContext = facesContext.getExternalContext(); 
				final Map<String, Object> requestMap = externalContext.getRequestMap(); 
				try { 
					LOG.info("{}: {}", t.getClass().getSimpleName(), t.getMessage()); 
					String message; 
					if (t instanceof ViewExpiredException) { 
						final String viewId = ((ViewExpiredException) t).getViewId(); 
						message = "View is expired. <a href='/ifos"  + viewId  + "'>Back</a>"; 
					} else { 
						message = t.getMessage(); // beware, don't leak internal info! 
					} 
					requestMap.put("errorMsg", message); 
					try { 
						externalContext.dispatch("/error.jsp"); 
					} catch (final IOException e) { 
						LOG.error("Error view '/error.jsp' unknown!", e); 
					} 
					facesContext.responseComplete(); 
				} finally { 
					it.remove(); 
				} 
			} 
		} 
		getWrapped().handle(); 
	} 

}