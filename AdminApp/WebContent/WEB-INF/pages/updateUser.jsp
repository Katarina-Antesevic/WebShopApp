<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.etfbl.webshop.dto.User"%>
<%@page import="net.etfbl.webshop.beans.UserBean"%>
<jsp:useBean id="userBean" type="net.etfbl.webshop.beans.UserBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Izmjena korisnika shopa</title>
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
      <form method="POST" action="?action=saveUpdatedUser" class="form-new-Cat" style="padding-top:30px">
        <h2 class="form-heading">Izmjenite postojeceg korisnika web shopa</h2>
        <p></p>
        <p></p>
        <input name="ime" type="text" class="form-control" placeholder="Ime" value="<%=session.getAttribute("imee")!=null?session.getAttribute("imee").toString():""%>">
        <p></p>
        <input name="prezime" type="text" class="form-control" placeholder="Prezime" value="<%=session.getAttribute("prezimee")!=null?session.getAttribute("prezimee").toString():""%>">
        <p></p>
        <input name="grad" type="text" class="form-control" placeholder="Grad" value="<%=session.getAttribute("gradd")!=null?session.getAttribute("gradd").toString():""%>">
        <p></p>
        <input name="kor_ime" type="text" class="form-control" placeholder="Korisnicko ime" value="<%=session.getAttribute("kor_imee")!=null?session.getAttribute("kor_imee").toString():""%>">
        <p></p>
        <input name="lozinka" type="password" class="form-control" placeholder="Lozinka" value="<%=session.getAttribute("lozinkaa")!=null?session.getAttribute("lozinkaa").toString():""%>">
        <p></p>
        <input name="mail" type="text" class="form-control" placeholder="Mail" value="<%=session.getAttribute("maill")!=null?session.getAttribute("maill").toString():""%>">
        <p></p>
         <input type="hidden" name="id" id="id" value=<%=session.getAttribute("idKorisnikaa")!=null?session.getAttribute("idKorisnikaa").toString():""%>>
         <input type="hidden" name="staroIme" id="staroIme" value=<%=session.getAttribute("kor_imee")!=null?session.getAttribute("kor_imee").toString():""%>>
         
        <p></p>
        <h5><%=session.getAttribute("notificationFour")!=null?session.getAttribute("notificationFour").toString():""%></h5>
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit">Sacuvajte</button>
   </form>
      
      
      </div>

      
</body>

</html>