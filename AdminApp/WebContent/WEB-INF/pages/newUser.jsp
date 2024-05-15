<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.etfbl.webshop.dto.User"%>
<%@page import="net.etfbl.webshop.beans.UserBean"%>
<jsp:useBean id="userBean" type="net.etfbl.webshop.beans.UserBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kreiranje novog korisnika shopa</title>
    <link href="styles/styles.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!--<title>Header</title>-->
</head>
<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-secondary sticky-top">
        <div class="container-fluid">
          <a class="navbar-brand" href="?action=categories">
            
                <img src="styles/images/379432_online_shopping_icon.png" height="70" width="70" class="logo" class="rounded-pill">
               
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="?action=kategorije">Kategorije</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="?action=korisnici">Korisnici</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="?action=statistika">Statistika</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" style="color: rgb(52,188,164)" href="?action=logout"><b>Odjava</b></a>
              </li>
            </ul>
          </div>


        </div>
      </nav>
      <div>&nbsp;</div>
      <div class="container-2">
      <form method="POST" action="?action=saveUser" class="form-new-Cat" style="padding-top:50px">
        <h2 class="form-heading">Kreirajte korisnika web shopa</h2>
        <p></p>
        <p></p>
        <input name="ime" type="text" class="form-control" placeholder="Ime">
        <p></p>
        <input name="prezime" type="text" class="form-control" placeholder="Prezime">
        <p></p>
        <input name="grad" type="text" class="form-control" placeholder="Grad">
        <p></p>
        <input name="kor_ime" type="text" class="form-control" placeholder="Korisnicko ime">
        <p></p>
        <input name="lozinka" type="password" class="form-control" placeholder="Lozinka">
        <p></p>
        <input name="mail" type="text" class="form-control" placeholder="E-mail adresa">
        <p></p>
        <h5><%=session.getAttribute("notificationThree")!=null?session.getAttribute("notificationThree").toString():""%></h5>
      	
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit">Sacuvajte</button>
   </form>
   	
   		<div>
     		</div>
      </div>
	

      
</body>

</html>