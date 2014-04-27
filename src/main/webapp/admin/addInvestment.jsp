<%-- 
    Document   : addInvestment
    Created on : Apr 27, 2014, 11:11:44 AM
    Author     : Hongrui Guan
--%>

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
                    <form>
                        <table>
                            <tr>
                                <td>Client Account ID:</td>
                                <td>
                                    <input type="text" size="20">
                                </td>
                            </tr> 
                            <tr>
                                <td>Investment Plan ID:</td>
                                <td>
                                    <input type="text" size="20">
                                </td>
                            </tr>
                            <tr>
                                <td>Investment Type:</td>
                                <td>
                                    <select>
                                        <option value="" disabled="disabled" selected="selected">- Investment Type -</option>
                                        <option value="Chequing">Open Term</option>
                                        <option value="Savings">Closed Term</option>
                                    </select>
                                </td>
                            </tr>                       
                            <tr>
                                <td>Return Percentage:</td>
                                <td>
                                    <input type="text" size="20">
                                </td>
                            </tr>
                            <tr>
                                <td>Duration (in days):</td>
                                <td>
                                    <input type="text" size="20">
                                </td>
                            </tr>
                            <tr>
                                <td>Penalty Percentage:</td>
                                <td>
                                    <input type="text" size="20">
                                </td>
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
