<%-- 
    Document   : addInvestment
    Created on : Apr 27, 2014, 11:11:44 AM
    Author     : Hongrui Guan
--%>

<%@page import="com.soen.ebanking.model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.soen.ebanking.model.InvestmentPlan"%>
<%@page import="com.soen.ebanking.model.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Investment Plan</title>
        <link rel="stylesheet" href="../css/style.css" type="text/css" />
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

            <div id="content">

                <div id="header-container">
                    <jsp:include page="../site-header.jsp"/>
                </div>
                <div id="contenttext">
                    <div class="bodytext">

                        <legend>
                            <h2 class="largeredtext">Add an Investment Plan</h2>
                        </legend>
                        <form  name="frmAddInvestment" action="/eBanking/AddInvestmentServlet" method="post">
                            <table>
                                <tr>
                                    <td>Client Name:</td>
                                    <td>
                                        <select name="clientID">
                                            <option value="" disabled="disabled" selected="selected">- User Name -</option>
                                            <%
                                                List<Client> allClients = Client.getClients();
                                                for (Client theClient : allClients) {
                                            %>  
                                            <option value = "<%=theClient.getUserId()%>"> <%=theClient.getLastName()%> <%=theClient.getFirstName()%> </option>>
                                            <%}%>
                                        </select>
                                    </td>
                                </tr> 
                                <tr>
                                    <td>Investment Plan:</td>
                                    <td>
                                        <select name="investmentID">
                                            <option value="" disabled="disabled" selected="selected">- User Name -</option>
                                            <%
                                                List<InvestmentPlan> allInvestmentPlans = InvestmentPlan.getInvestmentPlans();
                                                for (InvestmentPlan investmentPlan : allInvestmentPlans) {
                                            %>  
                                            <option value = "<%=investmentPlan.getInvestmentPlanId()%>"> <%= investmentPlan.getClass().getSimpleName()%>: <%= investmentPlan.getDurationInDays()%> Days</option>>
                                            <%}%>
                                          </select>   
                                    </td>
                                </tr>
                                 <tr>
                                    <td>New Investment Account Number:</td>
                                     
                                    <td><input name="investmentAccountNumber" type="text" size="20" value = ""></td>
                                </tr>
                                <tr>
                                     <% List<Account> personalAccounts = (ArrayList)Account.getPersonalAccount(client.getAccounts()); %>
                                    <td>Initial Account Balance:</td>
                                    <select name="accountID">
                                            <option value="" disabled="disabled" selected="selected">- User Name -</option>
                                            <%
                                               
                                                for (Account anAccount : personalAccounts) {
                                            %>  
                                            <option value = "<%=anAccount.getAccountId() %>"> <%= anAccount.getClass().getSimpleName()%>: <%= anAccount.getAccountNumber()%> - $<%= anAccount.getBalance()%>  </option>>
                                            <%}%>
                                          </select>  
                                    <td><input name="balance" type="text" size="20" value = "0.00"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <button type="submit" name="submit">OK</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                        <br/>
                        <br/>
                    </div>
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
