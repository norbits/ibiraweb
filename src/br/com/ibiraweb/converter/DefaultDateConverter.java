package br.com.ibiraweb.converter;

import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("defaultDateConverter")
public class DefaultDateConverter extends DateTimeConverter {

    public DefaultDateConverter() {
        setPattern("MM/dd/yyyy h:mm a");
    }

}