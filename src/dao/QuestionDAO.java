package dao;

import bean.Question;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class QuestionDAO {
    private static Connection connection;

    public Boolean addQuestion(Question question, int idUser) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_add = false ;
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO question (title,description,utilisateurID,date,image) VALUES (?, ?, ?, NOW(),?)");
            st.setString(1, question.getTitle());
            st.setString(2, question.getDesciption());
            st.setInt(3, idUser);
            if(question.getInputStream()!=null) {
                st.setBlob(4, question.getInputStream());
            }
            int row = st.executeUpdate();
            if(row>0) {
                etat_add = true ;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_add ;
    }
    public ArrayList<Question> getMyTopQuestions(int idUser) {
        connection = ConnectionDB.getConnection() ;
        Question question = null ;
        ArrayList<Question> questions = new ArrayList<Question>() ;
        try {
            PreparedStatement st = connection.prepareStatement(" SELECT  question.id,question.title,question.description,question.utilisateurID,question.date,count(reponse.id),question.image  FROM question,reponse WHERE question.id = reponse.questionId and question.utilisateurID = ? GROUP BY question.id ORDER BY count(reponse.id) DESC LIMIT 5 ");
            st.setInt(1, idUser);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                question = new Question(rs.getInt("question.id"),rs.getString("question.title"),rs.getString("question.description"),rs.getInt("question.utilisateurID"),rs.getDate("question.date"),rs.getInt("count(reponse.id)"), rs.getBlob("question.image").getBinaryStream());
                //
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                InputStream inputStream = question.getInputStream() ;
                if(inputStream != null) {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    outputStream.close();
                    question.setBase64Image(base64Image);
                }
                questions.add(question);
            }
        }
        catch(SQLException | IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
    public ArrayList<Question> getLastQuestions() {
        connection = ConnectionDB.getConnection() ;
        Question question = null ;
        ArrayList<Question> questions = new ArrayList<Question>() ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM question ORDER BY date LIMIT 6");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                question = new Question(rs.getInt("id"),rs.getString("title"),rs.getString("description"),rs.getInt("utilisateurID"),rs.getDate("date"),0, rs.getBlob("question.image").getBinaryStream());
                //
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                InputStream inputStream = question.getInputStream() ;
                if(inputStream != null) {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    outputStream.close();
                    question.setBase64Image(base64Image);
                }
                questions.add(question);
            }
        }
        catch(SQLException | IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
    public ArrayList<Question> getMyQuestions(int IdUtilisateur) {
        connection = ConnectionDB.getConnection() ;
        Question question = null ;
        ArrayList<Question> questions = new ArrayList<Question>() ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM question WHERE utilisateurID = ? ");
            st.setInt(1,IdUtilisateur);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                question = new Question(rs.getInt("id"),rs.getString("title"),rs.getString("description"),rs.getInt("utilisateurID"),rs.getDate("date"),0, rs.getBlob("question.image").getBinaryStream());
                //
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                InputStream inputStream = question.getInputStream() ;
                if(inputStream != null) {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    outputStream.close();
                    question.setBase64Image(base64Image);

                }
                questions.add(question);
            }
        }
        catch(SQLException | IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
    public static Question getQuestion(int IdQuestion) {
        connection = ConnectionDB.getConnection() ;
        Question question = null ;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM question WHERE id = ?");
            st.setInt(1,IdQuestion);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                question = new Question(rs.getInt("id"),rs.getString("title"),rs.getString("description"),rs.getInt("utilisateurID"),rs.getDate("date"), rs.getBlob("question.image").getBinaryStream());
                //
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                InputStream inputStream = question.getInputStream() ;
                if(inputStream != null) {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    outputStream.close();
                    question.setBase64Image(base64Image);
                }
            }
        }
        catch(SQLException | IOException e) {
            e.printStackTrace();
        }
        return question;
    }
    public Boolean DeleteQuestion(int IdQuestion) {
        connection = ConnectionDB.getConnection() ;
        Boolean etat_delete = false ;
        try {
            PreparedStatement st = connection.prepareStatement("delete from vote where reponseId in (select id from reponse where questionID=?) ");
            st.setInt(1, IdQuestion);
            st.execute();
            PreparedStatement st2 = connection.prepareStatement("delete from reponse where questionID=? ");
            st2.setInt(1, IdQuestion);
            st2.execute();
            PreparedStatement st3 = connection.prepareStatement("DELETE FROM question WHERE id = ?");
            st3.setInt(1, IdQuestion);
            st3.execute();
            etat_delete = true ;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return etat_delete ;
    }
}

