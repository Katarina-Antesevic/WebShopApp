<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.etfbl.webshop.dto.Attribute"%>
<%@page import="net.etfbl.webshop.beans.AttributeBean"%>
<jsp:useBean id="categoryBean" type="net.etfbl.webshop.beans.CategoryBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Izmjena atributa</title>
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
      
      <div class="container-1">
      <form method="POST" action="?action=saveUpdatedAttribute" class="form-new-Cat">
        <h2 class="form-heading">Promijenite trenutno ime atributa</h2>
        <p></p>
        <p></p>
        <input name="naziv" type="text" class="form-control" value="<%=session.getAttribute("nazivAtributa")!=null?session.getAttribute("nazivAtributa").toString():""%>">
         <input type="hidden" name="idAtributa" id="idAtributa" value=<%=session.getAttribute("idAtributa")!=null?session.getAttribute("idAtributa").toString():""%>>
         <input type="hidden" name="nazivSpecKategorije" id="nazivSpecKategorije" value=<%=session.getAttribute("nazivSpecKategorije")!=null?session.getAttribute("nazivSpecKategorije").toString():""%>>
         <input type="hidden" name="idSpecKategorije" id="idSpecKategorije" value=<%=session.getAttribute("idSpecKategorije")!=null?session.getAttribute("idSpecKategorije").toString():""%>>
       	 <input type="hidden" name="idParentKategorije" id="idParentKategorije" value=<%=session.getAttribute("idParentKategorije")!=null?session.getAttribute("idParentKategorije").toString():""%>>
        <p></p>
        
        <h5> <%=session.getAttribute("notificationEight").toString()%></h5>
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit">Sacuvaj</button>
   </form>
      
    
      </div>


      
</body>

</html>