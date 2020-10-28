package dao;

import bean.Question;
import bean.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {
    private Connection connection ;

    public Utilisateur getUtilisateur(String email, String password) {
        connection = ConnectionDB.getConnection() ;
        Utilisateur utilisateur = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND motdepasse = ? ");
            st.setString(1,email);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                utilisateur = new Utilisateur(rs.getInt("id"),rs.getString("pseudo"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }
    public Utilisateur getUtilisateur(int IdUtilisateur) {
        connection = ConnectionDB.getConnection() ;
        Utilisateur utilisateur = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM utilisateur WHERE id= ? ");
            st.setInt(1,IdUtilisateur);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                utilisateur = new Utilisateur(rs.getInt("id"),rs.getString("pseudo"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }
    public Boolean addUtilisateur(Utilisateur utilisateur) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_add = false ;
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO  utilisateur(pseudo,email,motdepasse) values(?,?,?) ");
            st.setString(1,utilisateur.getPseudo());
            st.setString(2,utilisateur.getEmail());
            st.setString(3,utilisateur.getPassword());
            st.execute();
            etat_add = true ;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_add;
    }
}

