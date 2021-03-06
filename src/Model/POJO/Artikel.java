/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.POJO;

import java.math.BigDecimal;

/**
 *
 * @author Gavarni
 */
public class Artikel {
    
    private long idArtikel;
    private long artikelNummer;
    private String naam;
    private String omschrijving;
    private BigDecimal prijs;
    private int voorraad;
    
    public Artikel(){
    }

    public long getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(long idArtikel) {
        this.idArtikel = idArtikel;
    }

    public long getArtikelNummer() {
        return artikelNummer;
    }

    public void setArtikelNummer(long artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }
    
}
