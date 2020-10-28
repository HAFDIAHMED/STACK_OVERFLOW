package pages;

import bean.Reponse;
import bean.Utilisateur;
import dao.ReponseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/questionvalide")
public class QuestionValideServlet extends HttpServlet {
    public QuestionValideServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        //
        if(utilisateur == null) {
            request.getRequestDispatcher("/showquestion").forward(request,response);
        }
        else {
            Integer IdQuestion = Integer.parseInt(request.getParameter("question"));
            if(request.getParameter("reponse")!=null) {

                Integer IdReponse = Integer.parseInt(request.getParameter("reponse")) ;
                Boolean ValideReponse = Boolean.valueOf(request.getParameter("valide"));
                ReponseDAO reponseDAO = new ReponseDAO() ;
                Boolean etat_add =  reponseDAO.changeValideReponse(IdReponse,ValideReponse);
                //

            }
            request.getRequestDispatcher("showquestion?IdQuestion="+IdQuestion).forward(request,response);
        }
    }
}
