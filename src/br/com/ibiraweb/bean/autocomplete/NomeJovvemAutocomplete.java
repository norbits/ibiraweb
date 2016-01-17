package br.com.ibiraweb.bean.autocomplete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NomeJovvemAutocomplete {
	private String value;
    
    private List<String> nomeJovemList ;

    public NomeJovvemAutocomplete() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
    	nomeJovemList = new ArrayList<String>();

    	nomeJovemList.add("Abcd dos Sandos");
    	nomeJovemList.add("Abcd dos Sandos");
    	nomeJovemList.add("Abcd dos Sandos");
    	nomeJovemList.add("Bcde dos Sandos");
    	nomeJovemList.add("Bcde dos Sandos");
    	nomeJovemList.add("Cdef dos Sandos");
    	nomeJovemList.add("Cdef dos Sandos");
    	nomeJovemList.add("Cdef dos Sandos");
    	nomeJovemList.add("Defg dos Sandos");
    	nomeJovemList.add("Aaaa dos Sandos");
        
        
        
    }

    public List<String> autocomplete(String prefix) {
        ArrayList<String> result = new ArrayList<String>();
        if ((prefix == null) || (prefix.length() == 0)) {
            for (int i = 0; i < 10; i++) {
                result.add(nomeJovemList.get(i));
            }
        } else {
            Iterator<String> iterator = nomeJovemList.iterator();
            while (iterator.hasNext()) {
                String elem = ((String) iterator.next());
                if ((elem != null && elem.toLowerCase().indexOf(prefix.toLowerCase()) == 0)
                    || "".equals(prefix)) {
                    result.add(elem);
                }
            }
        }

        return result;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


	public List<String> getNomeJovemList() {
		return nomeJovemList;
	}

	public void setNomeJovemList(List<String> nomeJovemList) {
		this.nomeJovemList = nomeJovemList;
	}



}
