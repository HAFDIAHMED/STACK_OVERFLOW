package pages;

import bean.Question;
import bean.Utilisateur;
import dao.QuestionDAO;
import dao.UtilisateurDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/addquestion")
@MultipartConfig(maxFileSize = 16177215)
public class AddQuestionServlet extends HttpServlet {
    public AddQuestionServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/");
        } else {
            InputStream inputStream = null; // input stream of the upload file
            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("UploadFile");
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            QuestionDAO questionDAO = new QuestionDAO();
            Question question = new Question(request.getParameter("title"), request.getParameter("description"), inputStream);
            Boolean etat_add = questionDAO.addQuestion(question, utilisateur.getId());
            if (etat_add == false) {
                request.setAttribute("etat", "not inserted");
                request.getRequestDispatcher("/page/addquestion.jsp").forward(request, response);
            } else {
                request.setAttribute("utilisateur", utilisateur);
                request.setAttribute("etat", "inserted");
                request.getRequestDispatcher("/page/addquestion.jsp").forward(request, response);
            }
        }
    }

    //
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("session id in addquestion servlet" + session.getId());
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/");
        } else {

            request.setAttribute("utilisateur", utilisateur);
            request.getRequestDispatcher("/page/addquestion.jsp").forward(request, response);
        }
    }

}