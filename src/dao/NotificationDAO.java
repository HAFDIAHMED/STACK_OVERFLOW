package dao;

import bean.Notification;
import bean.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificationDAO {
    Connection connection ;
    public Boolean addNotification(Notification notification) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_add = false ;
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO notification (message,utilisateurID,date) VALUES (?, ? , NOW())");
            st.setString(1, notification.getMessage());
            st.setInt(2, notification.getUtilisateurId());
            st.execute();
            etat_add = true ;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_add ;
    }
    public ArrayList<Notification> getNotification(int IdUser) {
        connection = ConnectionDB.getConnection() ;
        ArrayList<Notification> notifications = new ArrayList<Notification>() ;
        Notification notification = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT  id,message,utilisateurID,date FROM notification WHERE utilisateurID = ? ORDER BY date LIMIT 3 ");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                notification = new Notification(rs.getInt("id"),rs.getString("message"),rs.getInt("UtilisateurID"),rs.getDate("date"));
                notifications.add(notification);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return notifications ;
    }
}
