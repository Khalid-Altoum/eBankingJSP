package com.soen.ebanking.servlet;

import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.ClientCard;
import com.soen.ebanking.utils.SHA1Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewClientCardServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {

            String cardNumber, clientPassword, confirmClientPassword;
            cardNumber = request.getParameter("cardNumber");
            // Date expiryDate = Date.valueOf( );
            clientPassword = request.getParameter("clientPassword");
            confirmClientPassword = request.getParameter("confirmClientPassword");

            if (clientPassword.length() < 6 || clientPassword.length() > 20) {
                session.setAttribute("successfulMSG", "");
                session.setAttribute("errorMSG", "Error: Password length should be between 6 and 20. ");
                response.sendRedirect("./admin/addClientCard.jsp");
                return;
            }
            if (!clientPassword.equals(confirmClientPassword)) {
                session.setAttribute("successfulMSG", "");
                session.setAttribute("errorMSG", "Error: Password & Confirm password mismatch! ");
                response.sendRedirect("./admin/addClientCard.jsp");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date expiryDate = null;
            try {
                expiryDate = sdf.parse(request.getParameter("expiryDate"));
            } catch (ParseException ex) {
                session.setAttribute("errorMSG", "Error: Date is not in the write format! ");
                response.sendRedirect("./admin/addClientCard.jsp");
            }
            
            if (session != null) {
                session.invalidate();
            }
            long clientID = Long.parseLong(request.getParameter("clientID"));
            Client cl = Client.getClientsById(clientID);
            ClientCard cc = new ClientCard(cardNumber, expiryDate, cl);
            cc.saveClientCard();
            String passwordSHA = SHA1Util.sha1(clientPassword);
            cl.setPassword(passwordSHA);
            cl.setUserName(cardNumber);
            cl.updateUser();

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
