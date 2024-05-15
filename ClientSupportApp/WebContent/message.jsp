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
if (request.getParameter("submit") != null) {
	
	session.setAttribute("idPitanja", messageBean.getId());
	
	MessageBean message = messageManager.getMessageById(messageBean.getId());
	
	if (message != null) {
		messageBean.setUser(message.getUser());
		messageBean.setIsRead(1);
		messageBean.setId(message.getId());
		messageBean.setText(message.getText());
		messageBean.setDateTime(message.getDateTime());

		
		session.setAttribute("notification", "");
		response.sendRedirect("responseMail.jsp");
	} else {
		session.setAttribute("notification", "");
	}
} else {
	session.setAttribute("notification", "");
}
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Poruka</title>
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
              <li class="nav-item">
                <a class="nav-link" style="color: rgb(52,188,164)" href="logout.jsp"><b>Odjava</b></a>
              </li>
            </ul>
          </div>


        </div>
      </nav>
      
      <p></p>
      
      <div class="container-1">
	      <h2>&nbsp;Podaci o posiljaocu poruke:</h2>
	      <p style="padding-left:20px; font-size:20px">
	      Ime posiljaoca:<b> <%=messageBean.getUser().getFist_name() %> </b><br>
	      Prezime posiljaoca: <b><%=messageBean.getUser().getLast_name() %> </b><br>
	      Korisnicko ime posiljaova <b><%=messageBean.getUser().getUsername() %> </b><br>
	      Vrijeme slanja poruke:  <b><%=messageBean.getDateTime() %></b><br>
	      Grad posiljaoca: <b><%=messageBean.getUser().getCity() %></b><br>
	      Mail posiljaoca: <b><%=messageBean.getUser().getMail()%></b> <br>
	      </p>
	      <p></p>
	      <hr>
	      
	      <h2 >&nbsp;Tekst poruke:</h2>
	      <p style="padding-left:20px; font-size:20px">
	      <%=messageBean.getText() %>
	      </p>
	      <div style="height:30px"></div>
	      <p></p>
	      <form style=" padding-left:10px;" method="post" action="responseMail.jsp">
		    <input style="font-size:20px;" type="submit" id="submit" name="submit" value="&nbsp;Odgovorite na poruku&nbsp;">
		    <input type="hidden" name="id" id="id" value=<%=messageBean.getId() %> >
		    
		   </form>
      
      </div>
      
      
      
      
      
      
      
      

</body>
</html>