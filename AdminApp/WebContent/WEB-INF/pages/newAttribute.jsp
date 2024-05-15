<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.etfbl.webshop.dto.Category"%>
<%@page import="net.etfbl.webshop.beans.CategoryBean"%>
<jsp:useBean id="categoryBean" type="net.etfbl.webshop.beans.CategoryBean" scope="session"/>
<jsp:useBean id="attributeBean" type="net.etfbl.webshop.beans.AttributeBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kreiranje novog atributa</title>
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
                <a class="nav-link" href="?action=categories">Kategorije</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="?action=users">Korisnici</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="?action=statistics">Statistika</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" style="color: rgb(52,188,164)" href="?action=logout"><b>Odjava</b></a>
              </li>
            </ul>
          </div>


        </div>
      </nav>
      
      <div class="container-1">
      <form method="POST" action="?action=saveAttribute" class="form-new-Cat">
        <h2 class="form-heading">Kreiranje novog atributa</h2>
        <p></p>
        <p></p>
        <input  name="naziv" type="text" class="form-control" placeholder="Naziv atributa">
        
        <label style="font-size:20px;">Odaberite kojoj specificnoj kategoriji pripada</label>
        <select style="font-size:20px;" name="combobox">
        	<% 
	    		for(Category k : categoryBean.getAllSubcategories()){ 
	    	%>
		  <option  id="<%=k.getId() %>" value=<%=k.getId() %>><%=k.getName() %></option>
		  <%} 
	   %>
		</select>
		<p></p>
       <h5> <%=session.getAttribute("notificationSeven").toString()%></h5>
        
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit">Sacuvajte</button>
   </form>
      
    
      </div>


      
</body>

</html>