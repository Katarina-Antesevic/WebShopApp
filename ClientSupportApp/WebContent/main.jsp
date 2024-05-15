<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.etfbl.webshop.beans.AdminCustomerSupportBean"%>
<%@page import="net.etfbl.webshop.beans.MessageBean" %>
<%@page import="net.etfbl.webshop.service.MessageManager"%>
<jsp:useBean id="adminCustomerSupportBean" class="net.etfbl.webshop.beans.AdminCustomerSupportBean" scope="session"></jsp:useBean>
<jsp:useBean id="messageBean" class="net.etfbl.webshop.beans.MessageBean" scope="session"></jsp:useBean>
<jsp:useBean id="messageManager" class="net.etfbl.webshop.service.MessageManager" scope="session"></jsp:useBean>

<jsp:setProperty property="id" name="messageBean" param="id" />

<%
if(!(adminCustomerSupportBean.isLoggedIn())) response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<%
if(request.getParameter("search")!=null){
		String content = request.getParameter("content");
		messageManager.setIntVrij(1);
		messageManager.setContent(content);
		
		if(content.equals("")){
			messageManager.setIntVrij(0);
			messageManager.setContent("");
		}
		
	}

	if (request.getParameter("submit") != null) {
		
		messageManager.setIntVrij(0);
		messageManager.setContent("");
		
		session.setAttribute("idPitanja", messageBean.getId());
		
		MessageBean message = messageManager.getMessageById(messageBean.getId());
		
		if (message != null) {
		messageBean.setUser(message.getUser());
		messageBean.setIsRead(1);
		messageBean.setId(message.getId());
		messageBean.setText(message.getText());
		messageBean.setDateTime(message.getDateTime());
	
		messageManager.update(messageBean);
		
		session.setAttribute("notification", "");
		response.sendRedirect("message.jsp");
		} else {
	session.setAttribute("notification", "");
		}
	} else {
		session.setAttribute("notification", "");
	}
%>



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
          <a class="navbar-brand" href="main.jsp">
            
                <img src="styles/images/379432_online_shopping_icon.png" height="70" width="70" class="logo" class="rounded-pill">
               
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
            <ul class="navbar-nav">
              <!--<li class="nav-item">
                <a class="nav-link" href="main.jsp">Sve poruke</a>
              </li>
               <li class="nav-item">
                <a class="nav-link" href="neprocitanePoruke.jsp">Neprocitane poruke</a>
              </li> -->
              <li class="nav-item">
                <a class="nav-link" style="color: rgb(52,188,164)" href="logout.jsp"><b>Odjava</b></a>
              </li>
            </ul>
          </div>


        </div>
      </nav>
      
      <p></p>
      
      <div class="content-div">
				
    	<form style="padding-right:7px" method="post" action="main.jsp">
			<input type="text" style="width:30%; 
				box-sizing: border-box;
		    	border: 2px solid rgb(52,188,164);
		    	border-radius: 10px;
		    	font-size: 16px;
		    	background-color: white;
		    	background-image: url('styles/images/icon.png');
		    	background-position: 10px 10px; 
		    	background-repeat: no-repeat;
		    	padding: 9px 20px 12px 40px;" 
		    	class="float-end" 
		    	name="content"
		    	id="contect" 
		    	placeholder="Pretraga poruka po sadrzaju">
			<input type="submit" id="search" name="search" style="display: none;" >
		
		</form>
		<h3><%=session.getAttribute("notification").toString()%></h3>
		
	</div>
      <p></p>
      <h2 style="padding-top: 50px">&nbsp;Primjene neprocitane poruke:</h2>
      <p></p>
      
      
      <!-- tabela -->
      <div style="padding-top: 20px" class="table-responsive">
      	<table class="table" style="font-size:20px">
		  <thead class="text-center" >
		    <tr>
		    	<th style="min-width:280px">&nbsp;Korisnicko ime posiljaoca</th>
		    	<th >&nbsp;Tekst poruke</th>
		    	<th>&nbsp;</th>
		    </tr>
		  </thead>
		  <tbody  class="text-center" >
		    <tr>
		    	<%
		    	for(MessageBean p : messageManager.odgovarajucaFunkcija(messageManager.getIntVrij(), messageManager.getContent())){
		    	%>
		    <td>&nbsp;&nbsp;<%=p.getUser().getUsername() %></td>
		    <td style="word-wrap:break-word">&nbsp;&nbsp;<%=p.getText() %></td>
		    
		    <td>
	    <form method="post" action="main.jsp">
	    <input type="submit" id="submit" name="submit" value="&nbsp;Otvorite poruku&nbsp;">
	    <input type="hidden" name="id" id="id" value=<%=p.getId() %> >
	    
	    </form>
	    
	    </td>
	     
	    
		     </tr>
		   <%} %>
		  </tbody>
		  
		  
		</table>
      </div>
      
      <!-- tabela -->
      </body>

</html>