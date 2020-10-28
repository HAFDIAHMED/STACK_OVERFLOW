<%@ page import="bean.Utilisateur" %>
<style>
    <!-- -->
    * { padding: 0 ;
        margin: 0 ;
        font-family: sans-serif;
        box-sizing: border-box;
    }
    .navbar {
        display : flex ;
        flex-wrap: wrap ;
        background-color: #0984e3 ;
        border-bottom: 1px solid #0984e3;
        padding:  10px 10px;
        height : 43px ;
        font-size: 20px;
        color : #fff ;
    }
    .navbar .navbar_user {
        display : flex ;
        flex-wrap: wrap ;
        margin-right: 10px ;
        margin-left: 10px ;
    }
    .navbar .navbar_user .navbar_image img{
        width: 25px ;
        height: 25px ;
        border-radius: 50%;
        padding-bottom:  2px;
    }
    .navbar .navbar_user .navbar_nom{
        color: #fff ;
        margin-left: 8px ;
    }
    .navbar .navbar_user .navbar_nom h1{
        margin-top : 7px ;
        font-size: 12px ;

        font-style: italic;
    }
    .navbar .navbar_list {
        display : flex ;
        flex-wrap: wrap ;
        font-size: 20px;

    }
    .navbar .navbar_element {
        margin-right: 10px ;
        margin-left: 10px ;
    }
    .navbar .navbar_element  h1{
        text-decoration: none;
        color: #fff ;
        margin-top : 6px ;
        font-size: 12px ;
    }
    .navbar-link {
        text-decoration: none;
        color: #fff ;
        font-style: italic;
        margin-top : 7px ;
    }
    .navbar-link :hover {
        text-decoration: none;
    }
    .navbar .navbar_border {
        border-right: 1px solid rgba(0, 0, 0, .1) ;
        height: 18px;
        margin-top: 5px;
    }
    @media screen and (max-width:960px) {
        .navbar .navbar_list {
            margin-right: 40% ;
        }
    }

    @media screen and (max-width:760px) {
        .navbar .navbar .navbar_list {
            margin-right: 35% ;
        }

    }

    @media screen and (max-width:560px) {
        .navbar .navbar_list {
            margin-right: 0px ;
        }

    }
</style>
<%
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>
<div class="navbar">
    <% if (utilisateur == null) {
    %>
    <div class="navbar_user">
        <div class="navbar_nom">
            <h1>ENSIAS WIKI</h1>
        </div>
    </div>
    <div class="navbar_list " style="margin-right: 48% ;">
        <div class="navbar_element">
            <a class="navbar-link"  href="login" >Sign in</a>
        </div>

        <div class="navbar_element">
            <a  class="navbar-link" href="signup" >Sign up</a>
        </div>
    </div>
    <%}
    else {
    %>
    <div class="navbar_user">
        <div class="navbar_nom">
            <h1><%= utilisateur.getPseudo()%></h1>
        </div>
    </div>
    <div class="navbar_list " style="margin-right: 35% ;">
        <div class="navbar_element">
            <a class="navbar-link" href="dashboard" >dashboard</a>
        </div>
        <div class="navbar_element">
            <a class="navbar-link"  href="addquestion" >add question</a>
        </div>
        <div class="navbar_element">
            <a class="navbar-link"  href="showmyquestion" >show my question</a>
        </div>
        <div class="navbar_element">
            <a  class="navbar-link" href="logout" >logout</a>
        </div>
    </div>

    <%}%>
</div>