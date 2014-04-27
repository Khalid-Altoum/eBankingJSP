

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.soen.ebanking.model.*" %>
<%@ page import="com.soen.ebanking.utils.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>

        <% String username = request.getParameter("username");
            String password = request.getParameter("password");
            String passwordSHA = SHA1Util.sha1(password);

            // Check for fake username 
            Client clientWithUsername = Client.getClientByUserName(username);
            if (clientWithUsername == null) {
                session.removeAttribute("username");
                session.removeAttribute("password");
                response.sendRedirect("failLogin.jsp");
                return;
            }

            // Check for Blocked username
            if (clientWithUsername.isBlocked()) {
                session.removeAttribute("username");
                session.removeAttribute("password");
                response.sendRedirect("blockedLogin.jsp");
                return;
            }

            Client currentClient = Client.login(username, passwordSHA);
            //Check for wrong user name or passowrd
            if (currentClient == null) {
                clientWithUsername = Client.getClientByUserName(username);
                clientWithUsername.setNumberOfAttempts(clientWithUsername.getNumberOfAttempts() + 1);
                if (clientWithUsername.getNumberOfAttempts() >= 3) {
                    clientWithUsername.setBlocked(true);
                }
                clientWithUsername.updateUser();
                
                session.invalidate();
                response.sendRedirect("failLogin.jsp");
            } else {  //the client has the right user name and passowrd
                session.setAttribute("currentClientId", currentClient.getUserId());
                session.setAttribute("currentClientName", currentClient.getLastName());
                currentClient.setNumberOfAttempts(0);
                currentClient.updateUser();
                response.sendRedirect("home.jsp");
            }
        %> 
        
    </body>
</html>
