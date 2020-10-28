package pages;

import bean.Notification;
import bean.Question;
import bean.Reponse;
import bean.Utilisateur;
import dao.NotificationDAO;
import dao.QuestionDAO;
import dao.ReponseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addreponse")
public class AddReponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        //
        if(utilisateur == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/");
        }
        else {
            Integer IdQuestion = Integer.parseInt(request.getParameter("IdQuestion"));
            if(request.getParameter("reponse")!=null) {

                String contenu = request.getParameter("reponse") ;
                System.out.println(IdQuestion);
                Reponse reponse = new Reponse(contenu,IdQuestion,utilisateur.getId(),false) ;
                ReponseDAO reponseDAO = new ReponseDAO() ;
                Boolean etat_add =  reponseDAO.addReponse(reponse,utilisateur.getId());
                //
                String message = "user : "+utilisateur.getPseudo()+" add a reponse to your question : "+IdQuestion.toString() ;
                System.out.println(message);
                QuestionDAO questionDAO = new QuestionDAO() ;
                Question question = questionDAO.getQuestion(IdQuestion);
                int IdUser = question.getUserId() ;
                System.out.println(IdUser);
                Notification notification=new Notification(message,IdUser);
                NotificationDAO notificationDAO = new NotificationDAO() ;
                notificationDAO.addNotification(notification);

            }
            response.sendRedirect(request.getServletContext().getContextPath() + "/showquestion?IdQuestion="+IdQuestion);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getServletContext().getContextPath() + "/showquestion");
    }
}
