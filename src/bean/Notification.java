package bean;

import java.util.Date;

public class Notification {
    private int id ;
    private String message ;
    private int utilisateurId ;
    private Date date ;

    public Notification(int id,String message ,int utilisateurId ,Date date ) {
        this.id = id ;
        this.message = message ;
        this.utilisateurId = utilisateurId ;
        this.date = date ;
    }
    public Notification(String message ,int utilisateurId ) {
        this.message = message ;
        this.utilisateurId = utilisateurId ;
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
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
