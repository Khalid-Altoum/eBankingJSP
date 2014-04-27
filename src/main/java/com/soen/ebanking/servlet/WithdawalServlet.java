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

public class WithdawalServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double amount = 0;
        String errorMSG1="Error : You don't have sufficient funds.";
        String successMSG = "Withdrawal"+ amount +" done successfully";
        boolean isDone = false;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        try {

            long selectedAccountId = 0;
            if (request.getParameter("accounts") != null) {
                selectedAccountId = Long.parseLong(request.getParameter("accounts"));
            }
            
            if (request.getParameter("amount") != null) {
                amount = Double.parseDouble(request.getParameter("amount"));
                successMSG = "Withdrawal $"+ amount +" done successfully";

            }

            if (amount != 0 && selectedAccountId != 0) {
                Account acc = Account.getAccountById(selectedAccountId);
                isDone =acc.withdraw(amount,"$"+ amount + " from " + acc.getAccountNumber());
            } 
              if (! isDone){
              session.setAttribute("withdrawalSuccessfulMSG", "");
               session.setAttribute("withdrawalErrorMSG", errorMSG1); 
              }else{
              session.setAttribute("withdrawalSuccessfulMSG",successMSG );
               session.setAttribute("withdrawalErrorMSG", ""); 
              }
              
            response.sendRedirect("withdraw.jsp");
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
