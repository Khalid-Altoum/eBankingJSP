

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
            Admin adminWithUsername = Admin.getAdminByUserName(username);
            if (adminWithUsername == null) {
                session.removeAttribute("username");
                session.removeAttribute("password");
                response.sendRedirect("/eBanking/admin/failLogin.jsp");
                return;
            }

            // Check for Blocked username
            if (adminWithUsername.isBlocked()) {
                session.removeAttribute("username");
                session.removeAttribute("password");
                response.sendRedirect("/eBanking/admin/blockedLogin.jsp");
                return;
            }

            Admin currentClient = Admin.login(username, passwordSHA);
            //Check for wrong user name or passowrd
            if (currentClient == null) {
                adminWithUsername = Admin.getAdminByUserName(username);
                adminWithUsername.setNumberOfAttempts(adminWithUsername.getNumberOfAttempts() + 1);
                if (adminWithUsername.getNumberOfAttempts() >= 3) {
                    adminWithUsername.setBlocked(true);
                }
                adminWithUsername.updateUser();
                
                session.invalidate();
                response.sendRedirect("/eBanking/admin/failLogin.jsp");
            } else {  //the client has the right user name and passowrd
                session.setAttribute("currentAdminId", currentClient.getUserId());
                session.setAttribute("currentAdminName", currentClient.getFirstName());
                currentClient.setNumberOfAttempts(0);
                currentClient.updateUser();
                response.sendRedirect("/eBanking/admin/adminConsole.jsp");
            }
        %> 
        
    </body>
</html>
