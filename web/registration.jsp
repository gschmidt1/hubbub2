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
                    <tr><td>User Name</td><td><input type="text" name="userName" /></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" /></td></tr>
                    <tr><td colspan="2"><input type="submit" value="Login" /></td></tr>
		</table>
	</form>
        <p>Yet Not Registered!<a href="registration.jsp"> Register Here</a></p>
        <p>View Timeline Only!<a href="timeline.jsp"> View Here</a></p>
    </body>
</html>
