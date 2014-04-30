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
                        <h2 class="largeredtext">Add New Client Card</h2>
                    </legend>
                    <form name = "newClient" method = "post" action="/eBanking/NewClientCardServlet">
                         <script>
                            $(function() {
                                $("#datepicker").datepicker();
                            });

                        </script>
                        <table>
                            <tr>
                                <td>Client Name:</td>
                                <td>
                                    <select name="clientID">
                                        <option value="" disabled="disabled" selected="selected">- User Name -</option>
                                        <%
                                            List<Client> allClients = Client.getClients();
                                            for (Client client : allClients) {
                                        %>  
                                        <option value = "<%=client.getUserId()%>"> <%=client.getLastName()%> <%=client.getFirstName()%> </option>>
                                        <%}%>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Card Number:</td>
                                <td><input name="cardNumber" type="text" size="20" ></td>
                            </tr>
                            <tr>
                            <td>Expiry Date:</td>
                            <td><input name="expiryDate" type="text" size="20" id="datepicker"></td>
                            <td>    </td>
                            </tr>
                            <tr>
                            <td>Client Password:</td>
                            <td><input name="clientPassword" type="password" size="20" ></td>
                            <td> Password length between 6 to 20  </td>
                            </tr>
                            <td>Confirm Client Password:</td>
                            <td><input name="confirmClientPassword" type="password" size="20" ></td>
                            </tr>
                            
                            <tr>
                                <td>
                                    <button type="submit" name="submit">OK</button> </td><td>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="reset" name="reset">Reset</button>
                                </td>
                            </tr>
                        </table>
                        <%
                            String successString = (session.getAttribute("successfulMSG") != null) ? (String) session.getAttribute("successfulMSG") : " ";
                            String errorString = (session.getAttribute("errorMSG") != null) ? (String) session.getAttribute("errorMSG") : " ";
                        %>      
                        <p style="font-style:italic;"> <b style="color:#00FF00"> <%= successString%>  </b></p>           
                        <p style="font-style:italic;"> <b style="color:#F00"> <%= errorString%> </b></p>
                    </form>
                    <% 
                    session.removeAttribute("successfulMSG");
                    session.removeAttribute("errorMSG");
                    %>
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
