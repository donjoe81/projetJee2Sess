<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="js/login.js"></script>-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>

<title>connexion</title>
</head>
<body>
<div>
	<div id="form">
		<form  method="POST"  action="connexion" id=formLogin>
			<table>
				<tr>
					<td colspan=2>
						client : <input type="radio" name="compte" value="client"  checked="checked">
 						restaurant : <input type="radio" name="compte" value="restaurant">
					</td>
				</tr>
				<tr>
					<td><label>login</label></td>
					<td><input type="text" name="txtlogin"></td>
				</tr>
				<tr>
					<td><label>password</label></td>
					<td><input type="password" name="txtpassword"></td>
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
					<td><input type="button" value="créer un compte" id="btnNewCompte"/></td>
					<td><input type="submit" value="login"></td>
				</tr>
			
				
			</table>
		</form>
	</div>
	<div id="form1">	
		<form action="nouvel-utilisateur" method="get" id="formChoixCompte">
			<p>selectionner le type de compte : </p>
			<table>
				<tr>
					<td>
						<select name="compte">
						    <option value="client">créer un compte client</option>
						    <option value="restaurant">créer un compte restaurant</option>
						</select>
					</td>
					<td><input type="submit" value="ok"/></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>