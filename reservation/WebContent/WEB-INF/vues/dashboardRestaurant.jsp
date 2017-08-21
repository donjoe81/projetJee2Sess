<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Model.ModelRestaurant" import="Class.Reservation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accieul restaurant</title>
<!--  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/update.js"></script>-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
	<h2>restaurant : 
		<%
		ModelRestaurant m_client= (ModelRestaurant)request.getAttribute("model");
			out.println(m_client.getNom());
		%>
	</h2>
	<h3>vos reserrvation(s)</h3>
	
	<div>
		  <c:forEach items="${model.reservations}" var="reser">
			<div style="margin:20px">
				<label>nom du client : </label> ${reser.client.nom_client}<br/>
				<label>prenom du client : </label> ${reser.client.prenom_client}<br/>
				<label>tel du client : </label> ${reser.client.tel_client}<br/>
				<label>date de reservation : </label> ${reser.date_reservation}<br/>
				<label>nombre de place : </label> ${reser.nombrePlace}<br/>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>