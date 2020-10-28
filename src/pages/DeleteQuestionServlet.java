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

@WebServlet("/deletequestion")
public class DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        //
        if(utilisateur == null) {
            request.getRequestDispatcher("/showmyquestion").forward(request,response);
        }
        else {
            Integer IdQuestion = Integer.parseInt(request.getParameter("question"));
            if(request.getParameter("delete")!=null) {
                QuestionDAO questionDAO = new QuestionDAO() ;
                Boolean etat_delete =  questionDAO.DeleteQuestion(IdQuestion);
                //

            }
            request.getRequestDispatcher("/dashboard").forward(request,response);
        }
    }
}
