<%-- 
    Document   : addAccount
    Created on : Apr 27, 2014, 11:19:05 AM
    Author     : Hongrui Guan
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.soen.ebanking.model.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Register New Account</title>
        <link rel="stylesheet" href="../css/style.css" type="text/css" />
    </head>
    <body>
        <div id="content">
            <div id="header-container">
                <jsp:include page="../site-header.jsp"/>
            </div>
            <div id="contenttext">
                                <div class="bodytext">

                <legend>
                    <h2 class="largeredtext">Register New Account</h2>
                </legend>
                <form name = "newClient" method = "post" action="/eBanking/NewAccountServlet">
                    <table>
                        <tr>
                            <td>Client Name:</td>
                            <td></td>
                            <td>
                                <select name="clientID">
                                        <option value="" disabled="disabled" selected="selected">- User Name -</option>
                                        <%
                                            List<Client> allClients = Client.getClients();
                                            for (Client client:allClients){
                                         %>  
                                         <option value = "<%=client.getUserId()%>"> <%=client.getLastName()%> <%=client.getFirstName()%> </option>>
                                        <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Account Type:</td>
                            <td></td>
                            <td>
                                <select name="accountType">
                                        <option value="" disabled="disabled" selected="selected">- Account Type -</option>
                                        <option value="Chequing">Chequing</option>
                                        <option value="Saving">Saving</option>
                                </select>
                            </td>
                        </tr>
                         <tr>
                            <td>Account Number</td>
                            <td>$</td>
                            <td><input name="accountNumber" type="text" size="20" ></td>
                        </tr>
                        <tr>
                            <td>Account Balance:</td>
                            <td>$</td>
                            <td><input name="balance" type="text" size="20" value = "0.00"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td>
                                <button type="submit" name="submit">OK</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="reset" name="reset">Reset</button>
                            </td>
                        </tr>
                    </table>
                </form>
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
