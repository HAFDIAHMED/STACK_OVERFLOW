<%@ page import="bean.Question" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <style>
        .container-fluid {
            padding-left:  0px;
            padding-right:  0px;
        }
        .card {
            box-sizing : content-box;
            position: center;
            text-align: center;
            margin-top: 2% ;
            margin-left : 37%;
            margin-right: 37%;
            border-radius: 10px ;
            box-shadow: 0px 0px 10px 0px #000 ;
        }
        .breadcrumb_section_showmyquestion {
            padding: 20px;
        }
    </style>


</head>
<body>
<div class="container-fluid">
    <%@include file="navbar.jsp"%>
    <div class="breadcrumb_section_showmyquestion">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">Dashboard</li>
                <li class="breadcrumb-item active" aria-current="page">My Question</li>
            </ol>
        </nav>
    </div>
    <%
        ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions") ;
        Question question = null ;
    %>
    <%
        for(int i=0;i<questions.size();i++) {
            question = questions.get(i);
    %>
    <div class="card" style="width: 18rem;">
        <div class="card-head">
            <h5><%= question.getTitle()%></h5>
        </div>
        <div class="card-body">
            <h5 class="card-title"><%=question.getDate()%></h5>
        </div>
        <div class="card-footer">
            <div class="row">
                <div class="col">
                    <a href="<%="showquestion?IdQuestion="+question.getId()%>" class="btn btn-primary">Go to question</a>
                </div>
                <div class="col">
                    <a href="<%="deletequestion?delete=yes&question="+question.getId()%>" class="btn btn-danger">Delete question</a>
                </div>
            </div>


        </div>
    </div>
    <%}%>

</div>
</body>

</html>