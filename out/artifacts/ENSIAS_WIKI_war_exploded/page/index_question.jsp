<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Question" %>
<style>
    .card {
        box-sizing : content-box;
        position: center;
        text-align: center;
        margin-top: 4% ;
        margin-left : 37%;
        margin-right: 37%;
        border-radius: 10px ;
        box-shadow: 0px 0px 10px 0px #000 ;
    }
</style>
<%
    ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions") ;
    Question question = null ;
%>
<%
    for(int i=0;i<questions.size();i++) {
        question = questions.get(i);
%>
<div class="card" style="width: 30rem;">
    <div class="card-head">
        <h5><%= question.getTitle()%></h5>
    </div>
    <div class="card-body">
        <h5 class="card-title"><%=question.getDate()%></h5>
    </div>
    <div class="card-footer">
        <a href="<%="showquestion?IdQuestion="+question.getId()%>" class="btn btn-primary">Go to question</a>
    </div>
</div>
<%}%>

