package pages;

import bean.Utilisateur;
import bean.Vote;
import dao.VoteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        Integer IdQuestion = Integer.parseInt(request.getParameter("question")) ;
        Integer IdReponse = Integer.parseInt(request.getParameter("reponse")) ;
        if(utilisateur == null) {

        }
        String SBoolVote = (String) request.getParameter("vote") ;
        Boolean BoolVote = false ;
        if(SBoolVote.equals("true")) {
            BoolVote = true ;
        }
        Vote vote = new Vote(IdReponse,utilisateur.getId(),BoolVote) ;
        VoteDAO voteDAO  = new VoteDAO();
        Boolean etatAddVote =  voteDAO.addVote(vote,utilisateur.getId()) ;
        if(etatAddVote == false) {
            request.setAttribute("utilisateur",utilisateur);
            request.setAttribute("etat","not inserted");
            request.getRequestDispatcher("showquestion?IdQuestion="+IdQuestion.toString()).forward(request,response);
        }
        else {
            request.setAttribute("utilisateur",utilisateur);

            request.getRequestDispatcher("showquestion?IdQuestion="+IdQuestion.toString()).forward(request,response);
        }

    }
}
