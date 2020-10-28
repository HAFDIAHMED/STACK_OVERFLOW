package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static ConnectionDB instance = new ConnectionDB();

    private static final String url = "jdbc:mysql://localhost:3306/ENSIAS_WIKI" ;
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private ConnectionDB() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch(Exception e) {
            System.out.println("Erreur de chargement du driver");
        }
    }

    private Connection createConnection() {
        Connection connexion = null ;
        try {
            connexion = DriverManager.getConnection(url,"0xpwn","AbdoHadfi");
        }
        catch (SQLException e) {
            System.out.println("DB not connected");
        }
        return connexion ;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }



}
