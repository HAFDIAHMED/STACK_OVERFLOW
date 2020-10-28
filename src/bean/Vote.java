package bean;

import java.util.Date;

public class Vote {
    private int id;
    private int reponseId;
    private int utilisateurId;
    private Boolean valeur;
    private Date date;



    public Vote(int reponseId, int utilisateurId, Boolean valeur) {
        super();
        this.reponseId = reponseId;
        this.utilisateurId = utilisateurId;
        this.valeur = valeur;
    }


    public Vote(int id, int reponseId, int utilisateurId, Boolean valeur, Date date) {
        super();
        this.id = id;
        this.reponseId = reponseId;
        this.utilisateurId = utilisateurId;
        this.valeur = valeur;
        this.date = date;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getReponseId() {
        return reponseId;
    }
    public void setReponseId(int reponseId) {
        this.reponseId = reponseId;
    }
    public int getUtilisateurId() {
        return utilisateurId;
    }
    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
    public Boolean getValeur() {
        return valeur;
    }
    public void setValeur(Boolean valeur) {
        this.valeur = valeur;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
