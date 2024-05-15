<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*, com.sun.mail.smtp.*, javax.net.ssl.*" %>
    
<%@page import="net.etfbl.webshop.beans.AdminCustomerSupportBean"%>
<%@page import="net.etfbl.webshop.beans.MessageBean" %>
<%@page import="net.etfbl.webshop.service.MessageManager"%>
<jsp:useBean id="adminCustomerSupportBean" class="net.etfbl.webshop.beans.AdminCustomerSupportBean" scope="session"></jsp:useBean>
<jsp:useBean id="messageBean" class="net.etfbl.webshop.beans.MessageBean" scope="session"></jsp:useBean>
<jsp:useBean id="messageManager" class="net.etfbl.webshop.service.MessageManager" scope="session"></jsp:useBean>

<jsp:setProperty property="id" name="messageBean" param="id" />
    
<%
	if(!(adminCustomerSupportBean.isLoggedIn())) response.sendRedirect("login.jsp");
	if(request.getParameter("submit") == null) {
		session.setAttribute("notification", "");
	}
%>
<!DOCTYPE html>

<%
	
	if (request.getParameter("submit") != null) {
		session.setAttribute("notification", "");
		
			String host = "smtp.googlemail.com" ;
			String username ="korisnicka.podrska.webshop@gmail.com"; // your username
			String fromname = "korisnicka.podrska.webshop@gmail.com" ;//email id
			String password="bmxnzenevlhxlasr" ;//your password
			String protocol = "smtp";
			String to_addr = request.getParameter("mail");
			try {
			Properties props = System.getProperties();
			  props.put("mail.smtp.host", host);
			  props.put("mail.smtp.auth", "true");
			  props.put("mail.smtp.from", fromname);
			  props.put("mail.smtp.ssl.enable", "false");
			  props.put("mail.smtp.port", "587");
			  props.put("mail.smtp.starttls.enable", "true");
			  props.put("mail.smtp.user", username);
			  props.put("mail.smtp.password", password);
			  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			  
			  
			  Authenticator auth = new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication(){

					return new PasswordAuthentication(username, password);
					}
					};
			  
			 Session s = Session.getInstance(props, auth);
			 s.setDebug(true);
			 
			 
			  MimeMessage message = new MimeMessage(s);
			  InternetAddress from = new InternetAddress(fromname);
			  message.setFrom(from);
			  InternetAddress to = new InternetAddress(to_addr);
			  message.addRecipient(Message.RecipientType.TO, to);
			  message.setSubject(request.getParameter("naslov"));
			  message.setText(request.getParameter("textMaila"));
			  message.saveChanges(); 
			//Transport transport = s.getTransport(protocol);
			//transport.connect(host, username, password);
			//transport.sendMessage(message, message.getAllRecipients());
			  Transport.send(message);
			//transport.close();
			session.setAttribute("notification", "Mail je uspjesno poslat!");
		} catch(Exception  ex) {
			ex.printStackTrace();
			session.setAttribute("notification", "");
		}
	} else {
		session.setAttribute("notification", "");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Odgovor mailom: </title>
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
      
      <form method="POST" action="responseMail.jsp" class="form-new-Cat">
        <p></p>
        <label style="font-size:20px">Posalji poruku na mail:</label>
        <input id="mail" name="mail" type="text" class="form-control"  value=<%=messageBean.getUser().getMail() %>>
        
        <label style="font-size:20px">Naslov:</label>
        <input id="naslov" name="naslov" type="text" class="form-control"  value="Odgvor na poruku kreiranu na WEB Shopu"/>
        <label style="font-size:20px">Tekst maila:</label>
        <textarea class="form-control" id="textMaila" name="textMaila" rows="5"></textarea>
         
        <h4><%=session.getAttribute("notification").toString()%></h4>
        <p></p>
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit" name="submit">Posaljite mail</button>
        
   </form>
      
      
      
      
      
      
      

</body>
</html>