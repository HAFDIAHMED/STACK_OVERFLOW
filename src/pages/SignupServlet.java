package pages;

import bean.Utilisateur;
import dao.UtilisateurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    public SignupServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        if(utilisateur != null) {

        }
        else {
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            Utilisateur utilisateur2 = new Utilisateur(request.getParameter("pseudo"),request.getParameter("email"),request.getParameter("password"));
            Boolean etat_add = utilisateurDAO.addUtilisateur(utilisateur2);
            if(etat_add==false) {
                request.setAttribute("etat","Données Incorrectes");
                request.getRequestDispatcher("/page/signup.jsp").forward(request,response);
            }
            else {
                request.setAttribute("etat","Added");
                request.getRequestDispatcher("/page/signup.jsp").forward(request,response);
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur = null ;
        utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        request.setAttribute("utilisateur",utilisateur);
        request.getRequestDispatcher("/page/signup.jsp").forward(request,response);
    }
}
