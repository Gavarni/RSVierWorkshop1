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
public class AdresType {
    
    private long idAdresType;
    private String postAdres;
    private String factuurAdres;
    private String bezoekAdres;
    
    public AdresType(){
    }

    public long getIdAdresType() {
        return idAdresType;
    }

    public void setIdAdresType(long idAdresType) {
        this.idAdresType = idAdresType;
    }

    public String getPostAdres() {
        return postAdres;
    }

    public void setPostAdres(String postAdres) {
        this.postAdres = postAdres;
    }

    public String getFactuurAdres() {
        return factuurAdres;
    }

    public void setFactuurAdres(String factuurAdres) {
        this.factuurAdres = factuurAdres;
    }

    public String getBezoekAdres() {
        return bezoekAdres;
    }

    public void setBezoekAdres(String bezoekAdres) {
        this.bezoekAdres = bezoekAdres;
    }
    
}
