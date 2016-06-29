package com.agilidee.livrejunit.servlet;

public class Requete {
    private Integer ID = -1;
    private String adresseIp = "";
    private Integer duree = 0;
    private Long parama = new Long(0);
    private Long paramb = new Long(0);
    private Long resultat = new Long(0);

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adressIp) {
        this.adresseIp = adressIp;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Long getParama() {
        return parama;
    }

    public void setParama(Long parama) {
        this.parama = parama;
    }

    public Long getParamb() {
        return paramb;
    }

    public void setParamb(Long paramb) {
        this.paramb = paramb;
    }

    public Long getResultat() {
        return resultat;
    }

    public void setResultat(Long resultat) {
        this.resultat = resultat;
    }
}
