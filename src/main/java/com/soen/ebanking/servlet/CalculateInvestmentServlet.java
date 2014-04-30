package com.soen.ebanking.servlet;

import com.soen.ebanking.model.InvestmentAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculateInvestmentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date = new Date();
            try {
                date = sdf.parse(request.getParameter("date"));
            } catch (ParseException ex) {
                session.setAttribute("errorMSG", "Error: Password & Confirm password mismatch! ");
                response.sendRedirect("/eBanking/admin/calculateInvestment.jsp");
            }
            if (session != null) {
                session.invalidate();
            }
            List<InvestmentAccount> ias = InvestmentAccount.getInvestmentAccounts();
            for (InvestmentAccount ia : ias) {
                double profit = ia.calculateReturnOfInvestment(date);
                double newBalance = ia.getBalance()+ ( (double) Math.round(profit * 100.0) / 100.0);
                ia.setBalance( newBalance);
                ia.updateAccount();
            }

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
