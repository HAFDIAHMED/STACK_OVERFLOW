<%@ page import="bean.Notification" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Notification> TopNotifcations = (ArrayList<Notification>) request.getAttribute("notifications") ;
    Notification notification = null ;
%>
<%
    for(int i=0;i<TopNotifcations.size();i++) {
        notification = TopNotifcations.get(i);
%>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
    <strong><%= notification.getDate() + " : "%>></strong> <%= notification.getMessage()%>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<%}%>


