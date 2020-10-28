package pages;

import bean.Notification;
import bean.Question;
import bean.Utilisateur;
import dao.NotificationDAO;
import dao.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    public DashboardServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        System.out.println("session id in dashboard servlet"+session.getId());
        if(utilisateur == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/");
        }
        else {
            ArrayList<Question> TopQuestions = new QuestionDAO().getMyTopQuestions(utilisateur.getId());
            ArrayList<Question> questions = new QuestionDAO().getLastQuestions();
            ArrayList<Notification> TopNotifications = new NotificationDAO().getNotification(utilisateur.getId());
            session.setAttribute("test","test");
            request.setAttribute("utilisateur",utilisateur);
            request.setAttribute("TopQuestions",TopQuestions);
            request.setAttribute("questions",questions);
            request.setAttribute("notifications",TopNotifications);

            request.getRequestDispatcher("/page/dashboard.jsp").forward(request,response);
        }
    }
}
