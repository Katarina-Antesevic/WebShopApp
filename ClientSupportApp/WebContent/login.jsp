<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="net.etfbl.webshop.beans.AdminCustomerSupportBean"%>
<%@page import="net.etfbl.webshop.service.AdminCustomerSupportManager"%>
<jsp:useBean id="adminCustomerSupportBean" class="net.etfbl.webshop.beans.AdminCustomerSupportBean" scope="session"></jsp:useBean>
<jsp:useBean id="adminCustomerSupportManager" class="net.etfbl.webshop.service.AdminCustomerSupportManager" scope="session"></jsp:useBean>
<jsp:setProperty property="username" name="adminCustomerSupportBean" param="username" />
<jsp:setProperty property="password" name="adminCustomerSupportBean" param="password" />
<!DOCTYPE html>
<%
if (request.getParameter("submit") != null) {
		AdminCustomerSupportBean k = adminCustomerSupportManager.loginUser(adminCustomerSupportBean.getUsername(), adminCustomerSupportBean.getPassword());
		if (k != null) {
	adminCustomerSupportBean.setFirst_name(k.getFirst_name());
	adminCustomerSupportBean.setLast_name(k.getLast_name());
	adminCustomerSupportBean.setUsername(k.getUsername());
	adminCustomerSupportBean.setPassword(k.getPassword());
	adminCustomerSupportBean.setLoggedIn(true);
	
	session.setAttribute("notification", "");
	response.sendRedirect("main.jsp");
		} else {
	session.setAttribute("notification", "Niste unijeli odgovarajuce parametre!");
	adminCustomerSupportBean.setLoggedIn(false);
		}
	} else {
		session.setAttribute("notification", "");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
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

    <form method="POST" action="login.jsp" class="form-signin">
        <h2 class="form-heading">Prijava na nalog korisnicke podrske</h2>
        <p></p>
        <input id="username" name="username" type="text" class="form-control" placeholder="Korisnicko ime">
        <p></p>
        <input id="password" name="password" type="password" class="form-control" placeholder="Lozinka"/>
        <p></p>
        <h3><%=session.getAttribute("notification").toString()%></h3>
        <p></p>
        <button class="btn btn-lg btn-block" style="background-color: rgb(52,188,164)" type="submit" name="submit">Prijava</button>
   </form>

</div>

</body>

</html>