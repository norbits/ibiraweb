package br.com.ibiraweb.util.exception;


public class CustomExceptionHandlerFactory extends javax.faces.context.ExceptionHandlerFactory {    
	private final javax.faces.context.ExceptionHandlerFactory parent;
	
	public CustomExceptionHandlerFactory(final javax.faces.context.ExceptionHandlerFactory parent) 
	{   
		this.parent = parent;  
		}   
	
	@Override 
	public ExceptionHandler getExceptionHandler() {   
		return new ExceptionHandler(this.parent.getExceptionHandler());  
		}  
	}