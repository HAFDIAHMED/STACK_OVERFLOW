package dao;

import bean.Reponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReponseDAO {
    private Connection connection ;

    public Boolean addReponse(Reponse reponse, int idUser) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_add = false ;
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO reponse (contenu,questionID,utilisaterID,date,valide) VALUES (?, ?, ?, NOW(),?)");
            st.setString(1, reponse.getContenu());
            st.setInt(2, reponse.getQuestionID());
            st.setInt(3, idUser);
            st.setBoolean(4, false);
            st.execute();
            etat_add = true ;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_add ;
    }

    public ArrayList<Reponse> getReponses(int IdQuestion) {
        connection = ConnectionDB.getConnection();
        ArrayList<Reponse> reponses = new ArrayList<Reponse>();
        Reponse reponse = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM reponse WHERE questionId = ?");
            st.setInt(1,IdQuestion);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                reponse = new Reponse(rs.getInt("id"),rs.getString("contenu"),rs.getInt("questionID"),rs.getInt("utilisaterID"),rs.getDate("date"),rs.getBoolean("valide"));
                reponses.add(reponse);
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return reponses ;
    }

    public Reponse getReponse(int IdReponse) {
        connection = ConnectionDB.getConnection() ;
        Reponse reponse = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM reponse WHERE id = ?");
            st.setInt(1,IdReponse);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                reponse = new Reponse(rs.getInt("id"),rs.getString("contenu"),rs.getInt("questionID"),rs.getInt("utilisateurID"),rs.getDate("date"),rs.getBoolean("valide"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return reponse;
    }

    public Boolean changeValideReponse(int idReponse,Boolean valide) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_change = false ;
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE reponse set valide = ? where id =?");
            st.setBoolean(1, valide);
            st.setInt(2, idReponse);
            st.execute();
            etat_change = true ;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_change;
    }
}
