<%-- 
    Document   : registration
    Created on : Aug 16, 2015, 12:59:45 PM
    Author     : gnonschmidt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
        <p><img src="images/hubbub.png" height="50" width="200"/></p>
        <h1>Register on Hubbub</h1>
	<h2>${flash}</h2>
	<form method="POST" action="main">
		<table border="1"
                    <tr><td>Create User Name</td><td><input type="text" name="userName" /></td></tr>
                    <tr><td>Create Password</td><td><input type="password" name="password" /></td></tr>
                    <tr><td colspan="2"><input type="submit" value="Create" /></td></tr>
		</table>
	</form>
        <br><br>
        <a href="login.jsp">Back!</a>
    </body>
</html>
