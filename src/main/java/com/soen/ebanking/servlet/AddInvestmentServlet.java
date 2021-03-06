package com.soen.ebanking.servlet;

import com.soen.ebanking.model.Account;
import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.InvestmentAccount;
import com.soen.ebanking.model.InvestmentPlan;
import com.soen.ebanking.utils.DateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddInvestmentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {

            String investmentAccountNumber, accountID;
            long clientID, investmentID;
            double balance = 0;
            clientID = (Long) session.getAttribute("clientID");
            investmentID = (Long) session.getAttribute("investmentID");
            accountID = request.getParameter("accountID");
            investmentAccountNumber = request.getParameter("investmentAccountNumber");
            balance = Double.parseDouble(request.getParameter("balance"));

            if (session != null) {
                session.invalidate();
            }

            Client theClient = Client.getClientsById(clientID);
            InvestmentPlan thePlan = InvestmentPlan.getInvestmentPlanById(investmentID);
            Account fundsSource = Account.getAccountById(Long.parseLong(accountID));

            if (fundsSource.getBalance() < balance) {
                session.setAttribute("successfulMSG22", "");
                session.setAttribute("errorMSG22", "Error: Password & Confirm password mismatch! ");
                response.sendRedirect("/eBanknig/admin/addInvestment.jsp");

            } else {

                Date endDate = DateUtil.addDays(new Date(), thePlan.getDurationInDays());
                InvestmentAccount iAcc = new InvestmentAccount(new Date(), endDate, thePlan);
                iAcc.setAccountNumber(investmentAccountNumber);
                iAcc.setClient(theClient);
                iAcc.saveAccount();

                Account.transfer(fundsSource, iAcc, balance, "$" + balance + " from " + fundsSource.getAccountNumber() + " to Inverstment Account: " + iAcc.getAccountNumber());
                response.sendRedirect("./admin/adminFinished.jsp");
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
