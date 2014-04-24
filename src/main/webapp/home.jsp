<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.soen.ebanking.model.*" %>
<%@ page import="com.soen.ebanking.utils.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Welcome to eBanking!</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:useBean id="client" class="com.soen.ebanking.model.Client"></jsp:useBean>
        <%
            Long id = (Long) session.getAttribute("currentClientId");

//            long id = Long.parseLong(idString);
            if (id > 0) {
                client = Client.getClientsById(id);
                if (client == null){
                out.println("Client is null");}
            }
        %>
        <div id="content">
            <div id="header-container">
                <jsp:include page="./site-header.jsp"/>
            </div>
            <% ArrayList<Account> personalAccounts = (ArrayList)Account.getPersonalAccount(client.getAccounts()); %>
            <strong>Hello!</strong>&nbsp; <strong style="color: #CC0000"> ${currentClientName}   </strong>
            <div id="contenttext">
                <div class="bodytext">
                    <strong class="largeredtext">My Account Summary</strong>
                    <ul>
                        <li>Bank Accounts</li>
                        <br/>
                        <table rules="rows" class="historystyle">
                            <tr>
                                <th>Account#</th>
                                <th width="250px">Account Type</th>
                                <th width="250px">Balance</th>
                            </tr>
                            <%  for (Account account: personalAccounts) { %>
                            <tr>
                                <td><span><a href="accountDetail.jsp?account=<%= account.getAccountNumber()%>"><%= account.getAccountNumber()%></a></span></td>
                                <td align="center"><%=  account.getClass().getSimpleName() %></td>
                                <td align="center"><%= account.getBalance() %></td>
                            </tr>
                            <% } %>
                        </table><br/>
                        <% ArrayList<InvestmentAccount> investmentAccounts = (ArrayList)Account.getInvestmentAccounts(client.getAccounts()); %>
                        <li>Investments</li>
                        <br/>
                        <table rules="rows" class="historystyle">
                            <tr>
                                
                                <th>Account#</th>
                                 <th width="250px">Investment Type</th>
                                <th width="250px">Balance</th>
                            </tr>
                             <%  for (InvestmentAccount iAccount: investmentAccounts) { %>
                             <tr>
                                <td><span><a href="accountDetail.jsp?account=<%= iAccount.getAccountNumber()%>"><%= iAccount.getAccountNumber()%></a></span></td>
                                <td align="center"><%=  iAccount.getInvestmentPlan().getClass().getSimpleName() %></td>
                                <td align="center"><%= iAccount.getBalance() %></td>
                            </tr>
                            <% } %>
                        </table>
                    </ul>
                </div>
            </div>
            <div id="leftpannel-container">
                <jsp:include page="site-leftpanel.jsp"/>
            </div>
            <div id="footer-container">
                <jsp:include page="./site-footer.jsp"/>
            </div>
        </div>
    </body>
</html>