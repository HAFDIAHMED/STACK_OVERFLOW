<%@ page import="bean.Question" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Reponse" %>
<%@ page import="dao.UtilisateurDAO" %>
<%@ page import="jdk.jshell.execution.Util" %>
<%@ page import="dao.VoteDAO" %>
<%@ page import="bean.Vote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <style>
        .container-fluid {
            padding-left:  0px;
            padding-right:  0px;
        }
        .card {
            margin-top: 2% ;
            margin-buttom: 2% ;
            margin-left: 10% ;
            margin-right: 10% ;
            box-sizing : content-box;
            position: center;
            text-align: center;
            border-radius: 10px ;
            box-shadow: 0px 0px 10px 0px #000 ;
        }
        .inputreponse {
            margin-left: 10% ;
            margin-right: 10% ;
            position: center;
            text-align: center;
        }
        .breadcrumb_section_showquestion {
            padding: 20px;
        }
    </style>


</head>
<%
    Question question = (Question) request.getAttribute("question");
    ArrayList<Reponse> reponses = (ArrayList<Reponse>) request.getAttribute("reponses") ;
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO() ;
    Utilisateur utilisateurReponse,utilisateurQuestion ;
    //
    VoteDAO voteDAO = new VoteDAO() ;
    Reponse reponse = null ;
%>
<body>
<div class="container-fluid">
    <%@include file="navbar.jsp"%>
    <div class="breadcrumb_section_showquestion">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <% if (utilisateur!=null) {%>
                <li class="breadcrumb-item">Dashboard</li>
                <% } %>
                <li class="breadcrumb-item active" aria-current="page">Question</li>
            </ol>
        </nav>
    </div>
    <div class="card" style="width: 80%;">
        <div class="card-head">
            <h5><%= question.getTitle()%></h5>
        </div>
        <div class="card-body">
            <div class = "row">
                <div class="col">
                    <img src="data:image/jpg;base64,${question.getBase64Image()}" width="480" height="300"/>
                </div>
                <div class="col">
                    <p class="card-text"><%= question.getDescription()%></p>
                </div>
            </div>

        </div>
        <div class="card-footer">
            <% utilisateurQuestion =  utilisateurDAO.getUtilisateur(question.getUserId()); %>
            <h5 class="card-title"><%= utilisateurQuestion.getPseudo() +" : "+question.getDate()%></h5>
        </div>
    </div>
    <br>
    <%
        for(int i = 0 ; i<reponses.size() ; i++) {
            reponse = reponses.get(i) ;
            ArrayList<Vote> votes = voteDAO.getVotes(reponse.getId()) ;
            reponse.setNbrVote(votes.size());
            utilisateurReponse = utilisateurDAO.getUtilisateur(reponse.getUtilisateurID()) ;
    %>
    <div class="card" style="width: 80%;">
        <div class="card-body">
            <h5 class="card-title"><%= utilisateurReponse.getPseudo()+"   "+reponse.getDate()%></h5>
            <p class="card-text"><%= reponse.getContenu()%></p>
            <h5 class="card-title"><%= reponse.isValide()%></h5>
            <% if(utilisateur != null) {
                if(question.getUserId() == utilisateur.getId()) {
            %>
            <a href="<%= request.getServletContext().getContextPath() + "/questionvalide?reponse=" + reponse.getId() + "&valide="+!reponse.isValide()+"&question=" + question.getId() %>" class="btn btn-link<%= (reponse.isValide()) ? " text-danger" : "text-primary" %>"><%= (reponse.isValide()) ? "annuler validation" : "valider reponse" %></a>
            <%
                } }
            %>
        </div>
        <div class="card-footer">
            <%if(utilisateur != null) {%>
            <a href="<%= request.getServletContext().getContextPath() + "/vote?reponse=" + reponse.getId() + "&vote=true&question=" + question.getId() %>" class="btn btn-link<%= (reponse.isValide()) ? " text-white" : "" %>"><i class="far fa-thumbs-up"></i></a>
            <%}%>
            <%= reponse.getNbrVote() %>
            <%if(utilisateur != null) {%>
            <a href="<%= request.getServletContext().getContextPath() + "/vote?reponse=" + reponse.getId() + "&vote=false&question=" + question.getId() %>" class="btn btn-link<%= (reponse.isValide()) ? " text-white" : "" %>"><i class="far fa-thumbs-down"></i></a>
            <%}%>
        </div>
    </div>
    <%
        }
        if(utilisateur != null) {
    %>
    <form class="inputreponse" method="POST" action="addreponse">
        <div class="form-group">
            <label for="InputReponse">Reponse :</label>
            <textarea  class="form-control" id="InputReponse" name="reponse" placeholder="reponse "></textarea>
            <input type="hidden" value="<%= question.getId()%>" name="IdQuestion" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary" >Submit</button>
        </div>
    </form>
    <%}
        else {%>
    <div class="inputreponse">
        please login to add a reponse
    </div>
    <%}%>
</div>
</body>

</html>