<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>formulaire création d'un client</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/formulaire.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script> -->
</head>
<body>
<div class="container col-md-7">
	<form action="nouveau-client" method="post" id="formUser">
		<h2>formulaire création d'un client</h2>
		<table>
			<tr>
				<td><label>Nom(*) : </label></td>
				<td><input type="text" name="txtnom" id="txtnom" value=""/></td>
			</tr>
			
			<tr>
				<td><label>Prenom(*) : </label></td>
				<td><input type="text" name="txtprenom" id="txtprenom" value=""/></td>
			</tr>
			<tr>
				<td><label>Adresse(*) : </label></td>
				<td><input type="text" name="txtadress" id="txtadress" value=""/></td>
			</tr>
			
			<tr>
				<td><label>tel(*) : </label></td>
				<td><input type="text" name="txttel" id="txttel" value=""/></td>
			</tr>
			<tr>
				<td><label>login(*) : </label></td>
				<td><input type="text" name="txtlogin" id="txtlogin" value=""/></td>
			</tr>
			<tr>
				<td><label>Password(*) : </label></td>
				<td><input type="password" name="txtpass" id="txtpass" value=""/></td>
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
				<td><input type="submit" id="btnvalider" value="enregistrer"/></tr>
		</table>
	</form>
</div>
</body>
</html>