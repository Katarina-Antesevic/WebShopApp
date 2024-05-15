<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.etfbl.webshop.dto.User"%>
<%@page import="net.etfbl.webshop.beans.UserBean"%>
<jsp:useBean id="userBean" type="net.etfbl.webshop.beans.UserBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Korisnici web shopa</title>
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
      
      
      <a role="button" href="?action=newUser" style="background-color: rgb(52,188,164); font-size:20px" class="btn float-end"  >
      Dodajte novog korisnika
    </a>
    
     <p></p>
      <p></p>
      <p></p>
      <h2 style="padding-top: 20px">Korisnici web shopa:</h2>
      <p></p>
      <p></p>
      <p></p>
      <div class="table-responsive">
      	<table class="table" style="font-size:20px">
		  <thead class="text-center" >
		    <tr>
		    	<th>&nbsp;Ime</th>
		    	<th>&nbsp;Prezime</th>
		    	<th>&nbsp;Grad</th>
		    	<th>&nbsp;Korisnicko ime</th>
		    	<th>&nbsp;Lozinka</th>
		    	<th>&nbsp;Mail</th>
		    	<th>&nbsp;</th>
		    	<th>&nbsp;</th>
		    </tr>
		  </thead>
		  <tbody  class="text-center" >
		    <tr>
		    	<%
		    	for(User k : userBean.getAll()){
		    	%>
		    <td>&nbsp;&nbsp;<%=k.getFist_name() %></td>
		    <td>&nbsp;&nbsp;<%=k.getLast_name() %></td>
		    <td>&nbsp;&nbsp;<%=k.getCity() %></td>
		    <td>&nbsp;&nbsp;<%=k.getUsername() %></td>
		    <td>&nbsp;&nbsp;<%=k.getPassword() %></td>
		    <td>&nbsp;&nbsp;<%=k.getMail() %></td>
		    
		    <td>
	    <form method="post" action="?action=updateUser">
	    <input type="submit" value="&nbsp;Izmjenite&nbsp">
	    <input type="hidden" name="idIzmjenaKorisnika" id="idIzmjenaKorisnika" value=<%=k.getId() %> >
	    
	    </form>
	    
	    </td>
	     
	    <td>
	    <form method="post" action="?action=obrisiKorisnika">
	    <input type="submit" value="&nbsp;Obrisite&nbsp">
	    <input type="hidden" name="idBrisatiKorisnika" id="idBrisatiKorisnika"  value=<%=k.getId() %> >
	    
	    </form>
	    
	    </td>
		     </tr>
		   <%} %>
		  </tbody>
		  
		  
		</table>
		
		<p></p>
      <%=session.getAttribute("notificationEleven")!=null?session.getAttribute("notificationEleven").toString():""%>
       
      </div>
      
      
      </div>


      
</body>

</html>