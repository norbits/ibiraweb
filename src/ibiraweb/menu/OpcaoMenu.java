// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 06/08/2012 14:00:00
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   OpcaoMenu.java

package ibiraweb.menu;

import java.util.Comparator;

public class OpcaoMenu
    implements Comparator
{

    private String descricao;
    private String url;
    private String ordem;

    public OpcaoMenu()
    {
    }

    public String getDescricao()
    {
        if(descricao == null)
            descricao = "";
        return descricao;
    }

    public String getUrl()
    {
        if(url == null)
            url = "";
        return url;
    }

    public void setDescricao(String string)
    {
        descricao = string;
    }

    public void setUrl(String string)
    {
        url = string;
    }

    public String toString()
    {
        String s = "00" + getOrdem();
        s = s.substring(s.length() - 2) + " - " + getDescricao() + " - " + getUrl();
        return s;
    }

    public int compare(Object o1, Object o2)
    {
        return o1.toString().compareTo(o2.toString());
    }

    public String getOrdem()
    {
        return ordem;
    }

    public void setOrdem(String i)
    {
        ordem = i;
    }
}