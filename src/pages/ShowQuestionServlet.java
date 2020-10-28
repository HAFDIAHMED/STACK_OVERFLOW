package pages;

import bean.Question;
import bean.Reponse;
import bean.Utilisateur;
import bean.Vote;
import dao.QuestionDAO;
import dao.ReponseDAO;
import dao.UtilisateurDAO;
import dao.VoteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showquestion")
public class ShowQuestionServlet extends HttpServlet {
    public ShowQuestionServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        Integer IdQuestion = Integer.parseInt(request.getParameter("IdQuestion")) ;
        //
        QuestionDAO questionDAO = new QuestionDAO();
        Question question = questionDAO.getQuestion(IdQuestion);
        //
        ReponseDAO reponseDAO = new ReponseDAO() ;
        ArrayList<Reponse> reponses  = reponseDAO.getReponses(IdQuestion) ;
        //
        if(question == null) {
            request.setAttribute("utilisateur",utilisateur);
            request.setAttribute("etat","empty question");
            request.getRequestDispatcher("/page/showquestion.jsp").forward(request,response);
        }
        else {
            request.setAttribute("utilisateur",utilisateur);
            request.setAttribute("question",question);
            request.setAttribute("reponses",reponses);
            request.getRequestDispatcher("/page/showquestion.jsp").forward(request,response);
        }
    }
}
