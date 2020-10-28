package bean;

public class Utilisateur {
    private int id;
    private String pseudo;
    private String email ;
    private String password ;

    public Utilisateur(int id, String pseudo) {
        this.id = id;
        this.pseudo = pseudo;
    }
    public Utilisateur(String pseudo , String email , String password) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
