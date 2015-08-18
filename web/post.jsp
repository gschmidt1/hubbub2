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
        <p><img src="images/hubbub.png" height="50" width="200"/></p>
        <h1>Post to Hubbub</h1>
        <h2 style="color:red">${flash}</h2>
        <fieldset>
            <legend>Please enter your text:</legend>
            <form method="POST" action="main">
                <br>
                <textarea name="postText" rows="7" maxlength="140"></textarea>
                <br><br>
                <input type="SUBMIT" value="Submit">
                <input type="RESET" value="Reset">
            </form>
        </fieldset>
        <br>
        <p>View Posts!<a href="main?loginLinks=timeline">View Here!</a></p>
        <p>Want to logout?<a href="main?loginLinks=logout">Logout Here!</a></p>
    </body>
</html>


