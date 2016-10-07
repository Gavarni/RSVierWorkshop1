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
public class BestellingArtikel {
    
    private long idBestelling;
    private long idArtikel;
    private int aantal; //We hebben in de SQL geen aantal om aan te geven hoeveel van elk artikel in de bestelling opgenomen worden
    
    public BestellingArtikel(){
    }

    public long getIdBestelling() {
        return idBestelling;
    }

    public void setIdBestelling(long idBestelling) {
        this.idBestelling = idBestelling;
    }

    public long getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(long idArtikel) {
        this.idArtikel = idArtikel;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
    
}
