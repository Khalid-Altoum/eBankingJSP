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
                        <form  name="frmAddInvestment" action="/eBanking/admin/addInvestmentAccount.jsp" method="post">
                            <table>
                                <tr>
                                    <td>Client Name:</td>
                                    <td>
                                        <select name="clientID"  >
                                            <option value="" disabled="disabled" selected="selected">- Account  -</option>
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
                                            <option value="" disabled="disabled" selected="selected">- Investment Plan -</option>
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
                                    <td>
                                        <button type="submit" name="submit">Next</button>
                                    </td>
                                </tr>
                            </table>
                            <%
                                String successString = (session.getAttribute("successfulMSG22") != null) ? (String) session.getAttribute("successfulMSG22") : " ";
                                String errorString = (session.getAttribute("errorMSG22") != null) ? (String) session.getAttribute("errorMSG22") : " ";
                            %>      
                            <p style="font-style:italic;"> <b style="color:#00FF00"> <%= successString%>  </b></p>           
                            <p style="font-style:italic;"> <b style="color:#F00"> <%= errorString%> </b></p>


                        </form>
                        <%
                            session.removeAttribute("successfulMSG22");
                            session.removeAttribute("errorMSG22");
                        %>
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
