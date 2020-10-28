package bean;

import java.util.Date;

public class Reponse {
    private int id;
    private String contenu;
    private int questionID;
    private int utilisateurID;
    private Date date;

    private boolean valide;
    private int 	nbrVote;

    private Utilisateur utilisateur;


    public Reponse(String contenu, int questionID, int utilisateurID, boolean valide) {
        super();
        this.contenu = contenu;
        this.questionID = questionID;
        this.utilisateurID = utilisateurID;
        this.valide = valide;
    }


    public Reponse(int id, String contenu, int questionID, int utilisateurID, Date date, boolean valide) {
        super();
        this.id = id;
        this.contenu = contenu;
        this.questionID = questionID;
        this.utilisateurID = utilisateurID;
        this.date = date;
        this.valide = valide;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }


    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getContenu() {
        return contenu;
    }


    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    public int getQuestionID() {
        return questionID;
    }


    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }


    public int getUtilisateurID() {
        return utilisateurID;
    }


    public void setUtilisateurID(int utilisateurID) {
        this.utilisateurID = utilisateurID;
    }

    public boolean isValide() {
        return valide;
    }


    public void setValide(boolean valide) {
        this.valide = valide;
    }


    public int getNbrVote() {
        return nbrVote;
    }


    public void setNbrVote(int nbrVote) {
        this.nbrVote = nbrVote;
    }

}
