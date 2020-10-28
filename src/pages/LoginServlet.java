package pages;

import bean.Utilisateur;
import dao.UtilisateurDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        System.out.println("session id in login servlet"+session.getId());
        Utilisateur utilisateur =  (Utilisateur) session.getAttribute("utilisateur");
        if(utilisateur != null) {

        }
        else {
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            utilisateur = utilisateurDAO.getUtilisateur(request.getParameter("email"),request.getParameter("password"));
            if(utilisateur == null) {
                request.setAttribute("etat","Données Incorrectes");
                request.getRequestDispatcher("/page/login.jsp").forward(request,response);
            }
            else {
                session.setAttribute("utilisateur",utilisateur);
                response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard");
            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur = null ;
        utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        request.setAttribute("utilisateur",utilisateur);
        request.getRequestDispatcher("/page/login.jsp").forward(request,response);

    }
}
