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
        .breadcrumb_section_addquestion {
            padding: 20px;
        }
        .center_alert {
            text-align: center;
        }
    </style>


</head>
<body>
<div class="container-fluid">
    <%@include file="navbar.jsp"%>
    <div class="container">
        <div class="breadcrumb_section_addquestion">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">Dashboard</li>
                    <li class="breadcrumb-item active" aria-current="page">ADD QUESTION</li>
                </ol>
            </nav>
        </div>
        <form  method="POST" action="addquestion" enctype="multipart/form-data">
            <%
                String etat = (String) request.getAttribute("etat");
                if (etat != null) {
            %>
            <div class="form-group">
                <div class="text-danger"><%=etat.toString()%>></div>
            </div>
            <%}%>
            <div class="form-group">
                <label for="InputTitle">Title :</label>
                <input type="text" class="form-control" id="InputTitle"  name="title" placeholder="Enter title"  />
            </div>
            <div class="form-group">
                <label for="InputDescription">Description :</label>
                <textarea  class="form-control" id="InputDescription"  name="description" placeholder="Enter description"  ></textarea>
            </div>
            <div class="form-group">
                <label for="InputFile">Select file to upload: </label>
                <input type="file" name="UploadFile" id="InputFile"/>
            </div>

            <div class="center_alert">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</div>
</body>

</html>