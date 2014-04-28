/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.servlet;

import com.soen.ebanking.model.Account;
import com.soen.ebanking.model.ChequingAccount;
import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.SavingAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String clientID, accountType, accountNumber;
            Double balance;
            clientID = request.getParameter("clientID");
            accountType = request.getParameter("accountType");
            balance = Double.parseDouble(request.getParameter("balance"));
            accountNumber = request.getParameter("accountNumber");
            
            Client theClient = Client.getClientsById(Long.parseLong(clientID));
            
            Account newAccount; 
            if (accountType.equals("Saving")) {
                newAccount= new SavingAccount(balance,theClient);
                newAccount.setAccountNumber(accountNumber);
            } else {
                newAccount= new ChequingAccount(balance,theClient);
                newAccount.setAccountNumber(accountNumber);
            }
            newAccount.saveAccount();
            response.sendRedirect("./admin/adminFinished.jsp");

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
