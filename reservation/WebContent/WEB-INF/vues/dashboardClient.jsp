<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Model.ModelClient" import="Class.Reservation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accieul</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/update.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>	
	<div  class="container">
		<table class="table">
			<tr>
				<td><a href="prendre-rendez-vous">prendre un rendez-vous</a></td>
				<!-- <td><a href="" id="a_rdv">mes rendez-vous</a></td> -->
			</tr>
		</table>
	</div> 
	
	<div class="container">

		<!-- 	<table>
		<%
			ModelClient m_client= (ModelClient)request.getAttribute("model");
			out.println(m_client.getNom()+" "+m_client.getPrenom());
			if(m_client.getReservations().size()==0)
				out.println("pas de reservation");
		%>
		</table> -->
		
		<c:forEach items="${m_client.reservations}" var="reser">
			<div style="margin:20px">
				<label>nom restaurant : </label> ${reser.restaurant.nom_restaurant}<br/>
				<label>adresse restaurant : </label> ${reser.restaurant.adresse_restaurant}<br/>
				<label>tel restaurant : </label> ${reser.restaurant.tel_restaurant}<br/>
				<label>adresse restaurant : </label> ${reser.date_reservation}<br/>
			</div>
		</c:forEach>
	</div>
	<div id="d_rdv">
		
	</div>
</body>
</html>