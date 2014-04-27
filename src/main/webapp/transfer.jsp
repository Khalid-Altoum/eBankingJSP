<%@page import="com.soen.ebanking.model.Account"%>
<%@page import="com.soen.ebanking.model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.soen.ebanking.model.Client"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Make Transfers</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <jsp:useBean id="client1" class="com.soen.ebanking.model.Client" scope="page"></jsp:useBean>
        <%
            Long id = (Long) session.getAttribute("currentClientId");

//            long id = Long.parseLong(idString);
            if (id > 0) {
                client1 = Client.getClientsById(id);
                if (client1 == null) {
                    out.println("Client is null");
                }
            }
        %>
        <div id="content">
            <div id="header-container">
                <jsp:include page="./site-header.jsp"/>
            </div>
            <div id="contenttext">
                <div class="bodytext">
                    <form name="transfer" action="TransferServlet" method="post">
                        <fieldset class="fieldallign">
                            <legend>
                                <h2 class="largeredtext">Make A Transfer</h2>
                            </legend>
                            <table align="center">
                                <tr>
                                    <% ArrayList<Account> personalAccounts1 = (ArrayList) Account.getPersonalAccount(client1.getAccounts()); %>
                                    <th>From:</th>
                                    <td>
                                        <select name="fromAccount">
                                            <%
                                                for (Account acc : personalAccounts1) {
                                            %>
                                            <option value="<%= acc.getAccountId()%>" > <%=  acc.getClass().getSimpleName()%>: <%= acc.getAccountNumber()%></option>
                                            <% }%>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>To:</th>
                                    <td>
                                        <select name="toAccount">
                                            <%
                                                for (Account acc : personalAccounts1) {
                                            %>
                                            <option value="<%= acc.getAccountId()%>" > <%=  acc.getClass().getSimpleName()%>: <%= acc.getAccountNumber()%></option>
                                            <% }%>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Amount:</th>
                                    <td>$
                                        <input name="amount" type="text" size="15"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>&nbsp;&nbsp;&nbsp;
                                        <button type="submit" name="submit">OK</button>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="reset" name="reset">Reset</button></td>
                                </tr>
                            </table>
                            <%
                                String successString = (session.getAttribute("transferSuccessfulMSG") != null) ? (String) session.getAttribute("transferSuccessfulMSG") : " ";
                                String errorString = (session.getAttribute("transferErrorMSG") != null) ? (String) session.getAttribute("transferErrorMSG") : " ";
                            %>      
                            <p style="font-style:italic;"> <b style="color:#00FF00"> <%= successString%>  </b></p>           
                            <p style="font-style:italic;"> <b style="color:#F00"> <%= errorString%> </b></p>
                        </fieldset>
                    </form>
                    <% session.removeAttribute("transferSuccessfulMSG");
                        session.removeAttribute("transferErrorMSG");
                    %>
                </div>
            </div>
            <div id="leftpanel-container">
                <jsp:include page="./site-leftpanel.jsp"/>
            </div>
            <div id="footer-container">
                <jsp:include page="./site-footer.jsp"/>
            </div>
        </div>
    </body>
</html>