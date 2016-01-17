package br.com.ibiraweb.bean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.model.Filter;
 
@ManagedBean
@ViewScoped
public class CarsFilteringBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5680001353441022183L;
    private String secaoFilter;
    
    
	public String getSecaoFilter() {
		return secaoFilter;
	}
	public void setSecaoFilter(String secaoFilter) {
		this.secaoFilter = secaoFilter.trim();
	}
 


 
}
