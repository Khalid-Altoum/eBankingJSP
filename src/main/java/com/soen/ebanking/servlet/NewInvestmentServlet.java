/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.servlet;

import com.soen.ebanking.model.ChequingAccount;
import com.soen.ebanking.model.ClosedTermInvestment;
import com.soen.ebanking.model.InvestmentPlan;
import com.soen.ebanking.model.OpenTermInvestment;
import com.soen.ebanking.model.SavingAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewInvestmentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String investmentType = request.getParameter("investmentType");

            double investmentReturnsPercent = 0;
            if (request.getParameter("investmentReturnsPercent") != null) {
                investmentReturnsPercent = Double.parseDouble(request.getParameter("investmentReturnsPercent"));
            }

            int durationInDays = 0;
            if (request.getParameter("durationInDays") != null) {
                durationInDays = Integer.parseInt(request.getParameter("durationInDays"));
            }

            double penaltyPercent = 0;
            if (request.getParameter("penaltyPercent") != null) {
                penaltyPercent = Double.parseDouble(request.getParameter("penaltyPercent"));
            }
            if (session != null) {
                session.invalidate();
            }
            InvestmentPlan newInvestmentPlan;
            if (investmentType.equals("closed")) {
                newInvestmentPlan = new ClosedTermInvestment(penaltyPercent, durationInDays, investmentReturnsPercent);
            } else {
                newInvestmentPlan = new OpenTermInvestment(penaltyPercent, durationInDays, investmentReturnsPercent);
            }

            newInvestmentPlan.saveInvestmentPlan();
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
