<%@ page import="bean.Question" %>
<%@ page import="java.util.ArrayList" %>
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
    ArrayList<Question> TopQuestions = (ArrayList<Question>) request.getAttribute("TopQuestions") ;
    Question latestQuestion = null ;
%>
<%
    for(int i=0;i<TopQuestions.size();i++) {
        latestQuestion = TopQuestions.get(i);
%>
<div class="card" style="width: 30rem;">
    <div class="card-head">
        <h5><%= latestQuestion.getTitle()%></h5>
    </div>
    <div class="card-body">
        <h5 class="card-title"><%=latestQuestion.getDate()%></h5>
    </div>
    <div class="card-footer">
        <a href="<%="showquestion?IdQuestion="+latestQuestion.getId()%>" class="btn btn-primary">Go to question</a>
    </div>
</div>
<%}%>

