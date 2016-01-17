package br.com.ibiraweb.sorter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.component.SortOrder;

import br.com.ibiraweb.bean.DadosJovem;

@ManagedBean
@ViewScoped
public class SortingBean implements Serializable {
   private static final long serialVersionUID = 1L;
   private Map<String, SortOrder> sortsOrders;
   private List<String> sortPriorities;
   
   private boolean multipleSorting = false;

   private static final String SORT_PROPERTY_PARAMETER = "sortProperty";
   
   private SortOrder timeZonesOrder = SortOrder.unsorted;
   private SortOrder capitalsOrder = SortOrder.unsorted;
   private SortOrder nomeJovemOrder = SortOrder.unsorted;

   public SortingBean() {
       sortsOrders = new HashMap<String, SortOrder>();
       sortPriorities = new ArrayList<String>();
   }

   public void sort() {
       String property = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
           .get(SORT_PROPERTY_PARAMETER);
       if (property != null) {
           SortOrder currentPropertySortOrder = sortsOrders.get(property);
           if (multipleSorting) {
               if (!sortPriorities.contains(property)) {
                   sortPriorities.add(property);
               }
           } else {
               sortsOrders.clear();
           }
           if (currentPropertySortOrder == null || currentPropertySortOrder.equals(SortOrder.descending)) {
               sortsOrders.put(property, SortOrder.ascending);
           } else {
               sortsOrders.put(property, SortOrder.descending);
           }
       }
   }
   
   public void sortByNomeJovem() {
       capitalsOrder = SortOrder.unsorted;
       timeZonesOrder = SortOrder.unsorted;
       if (nomeJovemOrder.equals(SortOrder.ascending)) {
           setNomeJovemOrder(SortOrder.descending);
       } else {
    	   setNomeJovemOrder(SortOrder.ascending);
       }
   }

   
   
   public Comparator<DadosJovem> getTimeZoneComparator() {
       return new Comparator<DadosJovem>() {
           public int compare(DadosJovem o1, DadosJovem o2) {
               int tz1Int = Integer.valueOf(o1.getNroFamilia());
               int tz2Int = Integer.valueOf(o2.getNroFamilia());
               if (tz1Int == tz2Int) {
                   return 0;
               }
               if (tz1Int > tz2Int) {
                   return -1;
               } else {
                   return 1;
               }
           }
       };
   }
   
   
   public Comparator<DadosJovem> getNomeJovemComparator() {
	   
	   timeZonesOrder = SortOrder.unsorted;
	   
	   
       return new Comparator<DadosJovem>() {
           public int compare(DadosJovem o1, DadosJovem o2) {
        	   if (o1.getNomeJoven().equals(o2.getNomeJoven())) {
        	        return 0;
        	    }
        	    if (o1 == null) {
        	        return -1;
        	    }
        	    if (o2 == null) {
        	        return 1;
        	    }
        	    return o1.getNomeJoven().compareTo(o2.getNomeJoven());
           }
       };
   }
   

   public void sortByTimeZones() {
	   nomeJovemOrder = SortOrder.unsorted;
       if (timeZonesOrder.equals(SortOrder.ascending)) {
           setTimeZonesOrder(SortOrder.descending);
       } else {
           setTimeZonesOrder(SortOrder.ascending);
       }
       
//       String property = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
//               .get(SORT_PROPERTY_PARAMETER);
//           if (property != null) {
//               SortOrder currentPropertySortOrder = sortsOrders.get(property);
//               if (!sortPriorities.contains(property)) {
//                   sortPriorities.add(property);
//               }
//               if (currentPropertySortOrder == null || getTimeZonesOrder().equals(SortOrder.descending)) {
//                   sortsOrders.put(property, SortOrder.ascending);
//               } else {
//                   sortsOrders.put(property, SortOrder.descending);
//               }
//           }
   }
   

   public void modeChanged(ValueChangeEvent event) {
       reset();
   }

   public void reset() {
       sortPriorities.clear();
       sortsOrders.clear();
   }

   public boolean isMultipleSorting() {
       return multipleSorting;
   }

   public void setMultipleSorting(boolean multipleSorting) {
       this.multipleSorting = multipleSorting;
   }

   public List<String> getSortPriorities() {
       return sortPriorities;
   }

   public Map<String, SortOrder> getSortsOrders() {
       return sortsOrders;
   }
   
   public void setTimeZonesOrder(SortOrder timeZonesOrder) {
       this.timeZonesOrder = timeZonesOrder;
   }

public SortOrder getTimeZonesOrder() {
	return timeZonesOrder;
}

public SortOrder getNomeJovemOrder() {
	return nomeJovemOrder;
}

public void setNomeJovemOrder(SortOrder nomeJovemOrder) {
	this.nomeJovemOrder = nomeJovemOrder;
}







}