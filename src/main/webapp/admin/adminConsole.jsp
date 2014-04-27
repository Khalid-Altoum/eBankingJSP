<%-- 
    Document   : adminConsole
    Created on : Apr 27, 2014, 10:41:21 AM
    Author     : Hongrui Guan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Admin Console</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <div id="content">
            <div id="header-container">
                <jsp:include page="../site-header.jsp"/>
            </div>
            <div id="contenttext">
                <div class="bodytext">
                    <span class="largeredtext">Admin Console</span>

                    <p></p>
                    <table>
                        <tr height="200px">
                            <td width="200px">
                                <a href="register.jsp"> <img src="../images/user_add.png" style="width: 120px;" /> <br />
                                    <h5>Register New Client</h5>
                                </a> </td><td><a href="addAccount.jsp"> <img src="../images/user_search.png" style="width: 120px;" /><br />
                                    <h5>New Bank Account</h5>
                                </a></td></tr>
                        <tr height="200px">
                            <td width="200px">
                                <a href="newInvestment.jsp"> <img src="../images/new_file.png"
                                                                  style="width: 80px;" /> <br />
                                    <h5>New Investment Plan</h5>
                                </a> </td><td>
                                <a href="addInvestment.jsp"> <img src="../images/search.png"
                                                                  style="width: 80px;" /> <br />
                                    <h5>Investment for Client</h5>
                                </a></td></tr>
                    </table>

                </div>
            </div>
            <div id="leftpannel-container">
                <jsp:include page="admin-leftpanel.jsp"/>
            </div>
            <div id="footer-container">
                <jsp:include page="../site-footer.jsp"/>
            </div>
        </div>
    </body>
</html>
