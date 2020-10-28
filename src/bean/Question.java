package bean;

import java.io.InputStream;
import java.util.Date;

public class Question {
    private int id;
    private String 	title;
    private String 	description;
    private int    	userId;
    private Date date;
    private boolean valide;
    private InputStream inputStream ;
    private int nbrQuestion;
    private Utilisateur utilisateur;
    //
    private byte[] image;
    private String base64Image;

    public Question(String title, String description, InputStream inputStream) {
        this.title = title;
        this.description = description;
        this.inputStream = inputStream;
    }

    public Question(int id, String title, String description, int userId, Date date,InputStream inputStream) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.date = date;
        this.inputStream = inputStream;
    }

    public Question(int id, String title, String description, int userId, Date date, int nbrCount,InputStream inputStream) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.date = date;
        this.nbrQuestion = nbrCount;
        this.inputStream = inputStream;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public Date getDate() {
        return date;
    }

    public int getNbrQuestion() {
        return nbrQuestion;
    }

    public void setNbrQuestion(int nbrQuestion) {
        this.nbrQuestion = nbrQuestion;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public String getDesciption() {
        return description;
    }
    public void setDesciption(String desciption) {
        this.description = desciption;
    }

    public boolean isValide() {
        return valide;
    }
    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public InputStream getInputStream() {return this.inputStream;}

    public byte[] getImage() {
        return this.image;
    }
    public String getBase64Image() {
        return base64Image;
    }
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}
