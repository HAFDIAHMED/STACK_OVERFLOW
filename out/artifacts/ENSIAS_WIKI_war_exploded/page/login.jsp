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
        .section {
            box-sizing : content-box;
            text-align: center;
            margin-top: 10% ;
            margin-left : 30%;
            margin-right: 30%;
            padding : 30px ;
            border-radius: 10px ;
            box-shadow: 0px 0px 10px 0px #000 ;
        }
        .section_element button {
            margin : 10px ;
            width : 50% ;
            font-size : 70% ;
        }

        @media screen and (max-width:770px) {
            .section {
                margin-top: 30% ;
                margin-right: 10% ;
                margin-left: 10%;
            }
        }
    </style>


</head>
<body>
<div class="container-fluid">
    <%@include file="navbar.jsp"%>
    <div class="container-fluid">
        <form class="section" method="POST" action="login">
            <div class="form-group">
                <h3 style="text-align: center;color: #0984e3">Log in</h3>
            </div>
            <%
                String etat = (String) request.getAttribute("etat");
                if (etat != null) {
            %>
            <div class="form-group">
                <div class="text-danger"><%=etat.toString()%>></div>
            </div>
            <%}%>
            <div class="form-group">
                <label for="InputUser">Email :</label>
                <input type="email" class="form-control" id="InputUser"  name="email" placeholder="Enter your user"  />
            </div>
            <div class="form-group">
                <label for="InputPassword">Password :</label>
                <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Password" />
            </div>
            <div class="row">
                <div class="col-6">
                    <a href="<%= request.getServletContext().getContextPath()+"/"%>">retour</a>
                </div>
                <div class="col-6">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>

</html>