<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prijava na sistem</title>
    <link href="styles/styles.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!--<title>Header</title>-->
</head>
<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-secondary sticky-top">
        <div class="container-fluid">
          <!--  <a class="navbar-brand" href="#">-->
            
                <img src="styles/images/379432_online_shopping_icon.png" height="70" width="70" class="logo" class="rounded-pill">
               
       <!--  </a>-->
    </div>
</nav>

<div class="container">

    <form method="POST" action="?action=login" class="form-signin">
        <h2 class="form-heading">Prijava na adminski nalog</h2>
        <p></p>
        <input name="username" type="text" class="form-control" placeholder="Korisnicko ime">
        <p></p>
        <input name="password" type="password" class="form-control" placeholder="Lozinka"/>
        <p></p>
        <h3><%=session.getAttribute("notification")!=null?session.getAttribute("notification").toString():""%></h3>
        <p></p>
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit">Prijava</button>
   </form>

</div>

</body>

</html>