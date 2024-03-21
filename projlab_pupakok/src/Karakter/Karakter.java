package com.example.Karakter;

public class Karakter 
{
    protected boolean eszmeletvesztett;
    protected Szoba szoba;

    public boolean getEszmeletvesztett() 
    {

        return eszmeletvesztett;
    }

    public void setEszmeletvesztett(boolean eszmeletvesztett) 
    {
        this.eszmeletvesztett = eszmeletvesztett;
    }

    public Szoba getSzoba() 
    {
        return szoba;
    }

    public void setSzoba(Szoba szoba) 
    {
        this.szoba = szoba;
    }

    public void mozog(Szoba sz) 
    {
        System.out.println("mozog fv lefutott");
    }
   
    public void felvesz(Tárgy t)
    {
        System.out.println("felvesz fv lefutott");
    }

    public void eszmeletvesztes()
    {
        System.out.println("eszmeletvesztes fv lefutott");
    }

    public boolean vedette(Védettség v)
    {
        System.out.println("vedette fv lefutott");
    }

}

