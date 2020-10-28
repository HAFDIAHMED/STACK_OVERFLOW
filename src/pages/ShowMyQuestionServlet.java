package pages;

import bean.Question;
import bean.Reponse;
import bean.Utilisateur;
import dao.QuestionDAO;
import dao.ReponseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showmyquestion")
public class ShowMyQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        if(utilisateur == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/");
        }
        ArrayList<Question> questions = new QuestionDAO().getMyQuestions(utilisateur.getId());
        request.setAttribute("utilisateur",utilisateur);
        request.setAttribute("questions",questions);
        request.getRequestDispatcher("/page/showmyquestion.jsp").forward(request,response);

    }
}
