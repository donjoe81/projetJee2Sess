<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>formulaire création d'un restaurant</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/formulaire.css"/>
	<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>-->
</head>
<body>
<div>
	<h2>formaulaire création d'un restaurant</h2>
	<form action="nouveau-restaurant" method="post" id="formUser">
		
		<table>
			<tr>
				<td><label>Nom(*) : </label></td>
				<td><input type="text" name="txtnom" id="txtnom" value=""/></td>
			</tr>
			
			<tr>
				<td><label>Adresse : </label></td>
				<td><input type="text" name="txtadress" id="txtadress" value=""/></td>
			</tr>
			
			<tr>
				<td><label>tel(*) : </label></td>
				<td><input type="text" name="txttel" id="txttel" value=""/></td>
			</tr>
			<tr>
				<td><label>email(*) : </label></td>
				<td><input type="text" name="txtemail" id="txtemail" value=""/></td>
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