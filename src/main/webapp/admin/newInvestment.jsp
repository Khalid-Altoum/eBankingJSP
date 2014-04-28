<%-- 
    Document   : newInvestment
    Created on : Apr 27, 2014, 11:07:43 AM
    Author     : Hongrui Guan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>New Investment Plan</title>
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
                        <h2 class="largeredtext">New Investment Plan</h2>
                    </legend>
                    
                         <form  name="frmNewInvestment" action="/eBanking/NewInvestmentServlet" method="post">
                        <table>
                            <tr>
                                <td>Return Percentage:</td>
                                <td>
                                    <input name="investmentReturnsPercent" type="text" size="20">
                                </td>
                            </tr>
                            <tr>
                                <td>Duration (in days):</td>
                                <td>
                                    <input name="durationInDays"type="text" size="20">
                                </td>
                            </tr>
                            <tr>
                                <td>Penalty Percentage:</td>
                                <td>
                                    <input name="penaltyPercent" type="text" size="20">
                                </td>
                            </tr>
                            <tr>
                                <td>Investment Type:</td>
                                <td>
                                    <select name="investmentType">
                                        <option value="" disabled="disabled" selected="selected">- Investment Type -</option>
                                        <option value="open">Open Term</option>
                                        <option value="closed">Closed Term</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <button type="submit" name="submit">OK</button>
                                    <button type="reset" name="reset">Clear</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <br/>
                    <br/>
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
