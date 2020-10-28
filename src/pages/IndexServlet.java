package pages;

import bean.Question;
import bean.Utilisateur;
import dao.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    public IndexServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Question> questions = new QuestionDAO().getLastQuestions();
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        if(utilisateur != null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard");
        }
        request.setAttribute("utilisateur",utilisateur);
        request.setAttribute("questions",questions);
        request.getRequestDispatcher("/page/index.jsp").forward(request,response);
    }

}
