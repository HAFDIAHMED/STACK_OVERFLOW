package dao;

import bean.Reponse;
import bean.Vote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoteDAO {
    Connection connection ;
    public Boolean addVote(Vote vote, int idUser) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_add = false ;
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO vote (reponseID,utilisateurID,valeur,date) VALUES (?, ?, ?, NOW())");
            st.setInt(1, vote.getReponseId());
            st.setInt(2, idUser);
            st.setBoolean(3, vote.getValeur());

            st.execute();
            etat_add = true ;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_add ;
    }
    public Vote getVote(int IdVote) {
        connection = ConnectionDB.getConnection() ;
        Vote vote = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM vote WHERE id = ?");
            st.setInt(1, IdVote);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                vote = new Vote(rs.getInt("id"),rs.getInt("reponseID"),rs.getInt("utilisateurID"),rs.getBoolean("valeur"),rs.getDate("date"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return vote;
    }
    public ArrayList<Vote> getVotes(int IdReponse) {
        connection = ConnectionDB.getConnection() ;
        ArrayList<Vote> votes = new ArrayList<Vote>();
        Vote vote = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM vote WHERE reponseID = ?");
            st.setInt(1, IdReponse);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                vote = new Vote(rs.getInt("id"),rs.getInt("reponseID"),rs.getInt("utilisateurID"),rs.getBoolean("valeur"),rs.getDate("date"));
                votes.add(vote);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }
}
