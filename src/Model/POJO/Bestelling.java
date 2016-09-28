/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.POJO;

import java.util.Date;

/**
 *
 * @author Gavarni
 */
public class Bestelling {
    
    private long idBestelling;
    private String bestelNummer;
    private Date bestelDatum;
    private int idKlant;
    
    public Bestelling(){
    }

    public long getIdBestelling() {
        return idBestelling;
    }

    public void setIdBestelling(long idBestelling) {
        this.idBestelling = idBestelling;
    }

    public String getBestelNummer() {
        return bestelNummer;
    }

    public void setBestelNummer(String bestelNummer) {
        this.bestelNummer = bestelNummer;
    }

    public Date getBestelDatum() {
        return bestelDatum;
    }

    public void setBestelDatum(Date bestelDatum) {
        this.bestelDatum = bestelDatum;
    }

    public int getIdKlant() {
        return idKlant;
    }

    public void setIdKlant(int idKlant) {
        this.idKlant = idKlant;
    }
    
}
