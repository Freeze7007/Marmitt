package com.hsma.uebung2;

import java.util.Arrays;

public class Rezept {
    private int id;
    private String name;
    private String zutaten[];
    private String zubereitung;
    private String datum;
    private String autor;

    public Rezept(int id, String name, String[] zutaten, String zubereitung, String datum, String autor) {
        super();
        this.id = id;
        this.name = name;
        this.zutaten = zutaten;
        this.zubereitung = zubereitung;
        this.datum = datum;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getZutaten() {
        return zutaten;
    }
    public void setZutaten(String[] zutaten) {
        this.zutaten = zutaten;
    }
    public String getZubereitung() {
        return zubereitung;
    }
    public void setZubereitung(String zubereitung) {
        this.zubereitung = zubereitung;
    }
    public String getDatum() { 
    	return datum; 
    }
    public void setDatum(String datum) { 
    	this.datum = datum;
    }
    public String getAutor() { 
    	return autor; 
    }
    public void setAutor(String autor) {
    	this.autor = autor; 
    }


    @Override
    public String toString() {
        return "Rezept [id=" + id + ", name=" + name + ", zutaten=" + Arrays.toString(zutaten) + ", zubereitung="
                + zubereitung + ", date=" + datum + ", author=" + autor + "]";
    }
    
}
