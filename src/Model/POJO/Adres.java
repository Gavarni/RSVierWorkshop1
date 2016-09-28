/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.POJO;

/**
 *
 * @author Gavarni
 */
public class Adres {
    
    private long idAdres;
    private String straatnaam;
    private String postcode;
    private String toevoeging;
    private int huisnummer;
    private String woonplaats;
    private String typeAdres; // Waarom adrestype en ook nog eens idAdresType?
    private int idAdresType;
    
    public Adres(){
    }    
    
    public long getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(long idAdres) {
        this.idAdres = idAdres;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getTypeAdres() {
        return typeAdres;
    }

    public void setTypeAdres(String typeAdres) {
        this.typeAdres = typeAdres;
    }

    public int getIdAdresType() {
        return idAdresType;
    }

    public void setIdAdresType(int idAdresType) {
        this.idAdresType = idAdresType;
    }
    
    
    
}
