/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.servlet;

import com.soen.ebanking.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransferServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double amount = 0;
        String errorMSG1 = "Error : You don't have sufficient funds.";
        String successMSG = "Trasfer" + amount + " done successfully";
        boolean isDone = false;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        try {

            long selectedFromAccountId = 0;
            if (request.getParameter("fromAccount") != null) {
                selectedFromAccountId = Long.parseLong(request.getParameter("fromAccount"));
            }
            long selectedToAccountId = 0;
            if (request.getParameter("toAccount") != null) {
                selectedToAccountId = Long.parseLong(request.getParameter("toAccount"));
            }
            if (request.getParameter("amount") != null) {
                amount = Double.parseDouble(request.getParameter("amount"));
                successMSG = "Trasfer $" + amount + " done successfully";

            }

            if (amount != 0 && selectedFromAccountId != 0 && selectedToAccountId != 0) {
                if (selectedFromAccountId == selectedToAccountId) {
                    errorMSG1 = "Error: the source and target accounts should be different. ";
                } else {
                    Account fromAccount = Account.getAccountById(selectedFromAccountId);
                    Account toAccount = Account.getAccountById(selectedToAccountId);
                    isDone = Account.transfer(fromAccount, toAccount, amount, "$" + amount + " from " + fromAccount.getAccountNumber() + " to " + toAccount.getAccountNumber());
                }

            }
            if (!isDone) {
                session.setAttribute("transferSuccessfulMSG", "");
                session.setAttribute("transferErrorMSG", errorMSG1);
            } else {
                session.setAttribute("transferSuccessfulMSG", successMSG);
                session.setAttribute("transferErrorMSG", "");
            }

            response.sendRedirect("transfer.jsp");
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
