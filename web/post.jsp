<%-- 
    Document   : post
    Created on : Aug 16, 2015, 1:00:41 PM
    Author     : gnonschmidt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Hubbub2 - Post</title>
    </head>
    <body>
         <p><img src="hubbub.png" height="50" width="200"/></p>
        <h1>Post to Hubbub</h1>
        <h2><font color="blue">${postMessage}</font></h2>
        <fieldset>
        <legend>Please enter your text:</legend>
        <form action="formAction.jsp" method="POST
            <br>
            <textarea name="postTextArea" rows="7" maxlength="140"></textarea>
            <br><br>
            <input type="SUBMIT" value="Submit">
        </form>
        </fieldset>
        <br>
       
        <a href="login.jsp">Logout!t</a>
        
    </body>
</html>


