<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.soen.ebanking.model.*" %>
<%@ page import="com.soen.ebanking.utils.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" href="./css/style.css" type="text/css" />
        <title>Login to eBanknig!</title>
    </head>
    <body>
        <div id="content">
            <div id="header-container">
                <jsp:include page="./site-header.jsp"/>
            </div>

            <div id="contenttext">
                <span class="largeredtext">Welcome eBanknig!</span>

                <div class="bodytext">
                    <form method="post" name="frmLogin" action="loginCheck.jsp" method="post">
                        <table>
                            <tr>
                                <th>Account:  </th>                  
                                <td>
                                    <input name="username" type="text" required="required" autocomplete="off"
                                           placeholder="Account">
                                </td>
                                <td>  . </td>
                            </tr>
                            <tr>
                                <th>Password:</th>
                                <td><input name="password" type="password" required="required" autocomplete="off" 
                                           placeholder="Password"></td></tr>
                            <tr>
                                <td></td>
                                <td><button type="submit" name="submit" onclick="return validateLogin()">Login</button>&nbsp;&nbsp;
                                    <button type="reset" name="reset">Reset</button></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            <script language="javascript">
                function validateLogin() {
                    var sUserName = document.frmLogin.username.value;
                    var sPassword = document.frmLogin.password.value;
                    if ((sUserName == "")) {
                        alert("Please enter your account!");
                        return false;
                    }

                    if ((sPassword == "")) {
                        alert("Please enter your password!");
                        return false;
                    }
                }
            </script>
            <div id="footer-container">
                <jsp:include page="./site-footer.jsp"/>
            </div>
        </div>
    </body>
</html>