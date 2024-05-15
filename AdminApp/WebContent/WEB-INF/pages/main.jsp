<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="net.etfbl.webshop.dto.Category"%>
<%@page import="net.etfbl.webshop.beans.CategoryBean"%>
<%@page import="net.etfbl.webshop.dto.Attribute"%>
<%@page import="net.etfbl.webshop.beans.AttributeBean"%>
<jsp:useBean id="categoryBean" type="net.etfbl.webshop.beans.CategoryBean" scope="session"/>
<jsp:useBean id="attributeBean" type="net.etfbl.webshop.beans.AttributeBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Glavna stranica</title>
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
      
      
	    <a role="button" href="?action=newCategory" style="background-color: rgb(52,188,164); font-size:20px" class="btn float-end"  >
	      Dodajte novu kategoriju
	    </a>
	
	      <p></p>
	      <p></p>
	      <p></p>
	      <h2 style="padding-top: 20px">Kategorije proizvoda:</h2>
	      <p></p>
	      <p></p>
	      <p></p>
	      
	      
	      <table class="table-responsive " style="font-size:20px">
		  <thead style="font-size:22px">
		    <tr>
		    	<!--  <th>
		    	&nbsp;Naziv kategorije
		    	</th>
		    	<th>&nbsp;</th>
		    	<th>&nbsp;</th>
		    	-->
		    </tr>
		  </thead>
		  <tbody class="text-center">
		    <tr>
		    	<%
		    	for(Category k : categoryBean.getAll()){
		    	%>
		    <td>&nbsp;&nbsp;&nbsp;&nbsp; <%= k.getName() %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		    <td>
		    <form method="post" action="?action=update">
		    <input type="submit" value="&nbsp;Izmjenite&nbsp">
		    <input type="hidden" name="idIzmjena" id="idIzmjena" value=<%=k.getId()%> >
		    
		    </form>
		    
		    </td>
		     
		    <td>
		    <form method="post" action="?action=delete">
		    <input type="submit" value="&nbsp;Obrisite&nbsp"/>
		    <input type="hidden" name="idBrisati" id="idBrisati"  value=<%=k.getId()%> />
		    
		    </form>
		    
		    </td>
		     </tr>
		   	<%
		   	}
		   	%>
		  </tbody>
		</table>
		<p></p>
	      <%=session.getAttribute("notification")!=null?session.getAttribute("notification").toString():""%>
	      
	      <hr>
	     
	      <p></p>
	      <a  role="button" href="?action=newSpecific" style="background-color: rgb(52,188,164); font-size:20px; " class="btn float-end"  >
	      Dodajte novu specificnu kategoriju
	    </a>
	    <p></p>
	      <!--  <p></p>
	      <h2 style="padding-top: 50px">Specificne kategorije proizvoda:</h2>
	      <p></p>-->
	      
	      <!-- Pojedinacne specificne kategorije -->
	      
	      <%
	      	      for(Category k : categoryBean.getAll()){
	      	      %>
		    	<h2 style="padding-top: 50px">Specificne kategorije za <%=k.getName() %></h2> 
		    	
		    	
		 <table class="table-responsive " style="font-size:20px">
		  <thead style="font-size:22px">
		    <!-- <tr>
		    	<th>
		    	&nbsp;Naziv kategorije
		    	</th>
		    	<th>&nbsp;</th>
		    	<th>&nbsp;</th>
		    </tr> -->
		  </thead>
		  <tbody class="text-center">
		    <tr>
		    	<%
		    	ArrayList<Category> list = new ArrayList<>();
		    	list = categoryBean.getSubcategoriesByCategoryId(k.getId());
		    	
		    	for(Category sk : list){
		    	%>
		    
		    
		    <td>&nbsp;&nbsp;&nbsp;&nbsp;<%=sk.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		    <td>
		    <form method="post" action="?action=updateSpec">
		    <input type="submit" value="&nbsp;Izmjenite&nbsp">
		    <input type="hidden" name="idIzmjenaSpec" id="idIzmjenaSpec" value=<%=sk.getId()%> >
		    
		    </form>
		    
		    </td>
		     
		    <td>
		    <form method="post" action="?action=deleteSpecific">
		    <input type="submit" value="&nbsp;Obrisite&nbsp"/>
		    <input type="hidden" name="idBrisatiSpec" id="idBrisatiSpec"  value=<%=sk.getId()%> />
		    
		    </form>
		    
		    </td>
		     </tr>
		   	<%
		   	}
		   	%>
		  </tbody>
		    </table>	
	      <%
		      }
		      %>
		   
		   <p></p>
	      <%=session.getAttribute("notificationOne")!=null?session.getAttribute("notificationOne").toString():""%>
	      <hr>
	      <p></p>
	      <a  role="button" href="?action=newAttribute" style="background-color: rgb(52,188,164); font-size:20px; " class="btn float-end"  >
	      Dodajte novi atribut
		    </a>
	      <p></p>
	      
	      <!-- svi atributiii -->
	      
	      <%
	      	      for(Category sk : categoryBean.getAllSubcategories()){
	      	      %>
		    	<h2 style="padding-top: 50px">Atributi specificne kategorije <%=sk.getName()%>:</h2>
		    	
		    	
		 <table class="table-responsive " style="font-size:20px">
		  <thead style="font-size:22px">
		    <!-- <tr>
		    	<th>
		    	&nbsp;Naziv kategorije
		    	</th>
		    	<th>&nbsp;</th>
		    	<th>&nbsp;</th>
		    </tr> -->
		  </thead>
		  <tbody class="text-center">
		    <tr>
		    	<%
		    	for(Attribute a : attributeBean.getAtributesBySpecificCategoryId(sk.getId())){
		    	%>
		    
		    
		    
		    <td>&nbsp;&nbsp;&nbsp;&nbsp;<%=a.getName() %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		    <td>
		    <form method="post" action="?action=updateAttribute">
		    <input type="submit" value="&nbsp;Izmjenite&nbsp">
		    <input type="hidden" name="idIzmjenaAtributa" id="idIzmjenaAtributa" value=<%=a.getId() %> >
		  
		  </form>
		    
		    </td>
		     
		    <td>
		    <form method="post" action="?action=deleteAttribute">
		    <input type="submit" value="&nbsp;Obrisite&nbsp"/>
		    <input type="hidden" name="idBrisatiAtribut" id="idBrisatiAtribut"  value=<%=a.getId() %> />
		    
		    
		    </form>
		    
		    </td>
		     </tr>
		   	<%} 
		   %>
		  </tbody>
		    </table>	
	      <%} 
		   %>
		   
		   <p></p>
	      <%=session.getAttribute("notificationTwo")!=null?session.getAttribute("notificationTwo").toString():""%>
	      <hr>
      </div>

</body>

</html>