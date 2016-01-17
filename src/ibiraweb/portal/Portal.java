// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 06/08/2012 14:04:55
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Portal.java

package ibiraweb.portal;

import java.io.Serializable;
import java.util.Comparator;

public class Portal
    implements Comparator,Serializable 
{

    private String ordem;
    private String textoDesenvolvedor;
    private String textoGestor;
    private String textoTitulo;

    public Portal()
    {
    }

    public void setOrdem(String i)
    {
        ordem = i;
    }

    public String getOrdem()
    {
        return ordem;
    }

    public String getTextoDesenvolvedor()
    {
        return textoDesenvolvedor;
    }

    public void setTextoDesenvolvedor(String textoDesenvolvedor)
    {
        this.textoDesenvolvedor = textoDesenvolvedor;
    }

    public String getTextoGestor()
    {
        return textoGestor;
    }

    public void setTextoGestor(String textoGestor)
    {
        this.textoGestor = textoGestor;
    }

    public int compare(Object o1, Object o2)
    {
        return o1.toString().compareTo(o2.toString());
    }

    public String toString()
    {
        String s = "00" + getOrdem();
        s = s.substring(s.length() - 2);
        return s;
    }

    public String getTextoTitulo()
    {
        return textoTitulo;
    }

    public void setTextoTitulo(String textoTitulo)
    {
        this.textoTitulo = textoTitulo;
    }
}