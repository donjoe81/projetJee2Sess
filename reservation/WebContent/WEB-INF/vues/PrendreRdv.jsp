<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script>
  $( function() {
    $( "#datepicker" ).datepicker({minDate: 0, dateFormat: "dd/mm/yy"});
   	 
  } );
  </script>
<title>Prendre-un-Rdv</title>
</head>
<body>
	<p>prendre un rendez-vous</p>
	<div class="container col-md-10">
	<form  action="envoi-demande" method="GET">
		<table class="table table-striped" >
			<th> NOM </th> <th>ADRESSE</th> <th>TEL</th> <th>EMAIL</th> <th>CHOIX</th>
			<c:forEach items="${restaurants}" var="resto">
				<tr>
					<td>${resto.nom_restaurant}</td>
					<td>${resto.adresse_restaurant}</td>
					<td>${resto.tel_restaurant}</td>
					<td>${resto.email_restaurant}</td>
					<td><input type="radio" name="idresto" value="${resto.id_restaurant}" /></td>
				</tr>
			</c:forEach>
		</table>
		<table>
						<tr>
				<td>nombre de place :</td>
				<td><input type="text" name="nbrPlace" value=""/></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="text" id="datepicker" name="date" value=""/></td>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<%
						String log=(String)request.getAttribute("rsp");
						if(log!=null)
							out.println(log);
					%>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="envoyer"/></td>
			</tr>
		</table>
		
		</form>
	</div>
</body>
</html>