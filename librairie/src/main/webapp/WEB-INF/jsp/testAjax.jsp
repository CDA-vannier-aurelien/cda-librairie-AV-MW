
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


</head>
<body>
    <div >
        <input id="login" type="text" name="login"
               class="was-validated" onchange="testlogin()" placeholder="login" >

    </div>
    <span class="badge badge-danger" id="result"></span>
    <div>
        <input id="password" type="text" name="password" class="was-validated"
               placeholder="password"  required>
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer</button>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/myScript.js"></script>
</body>
</html>
