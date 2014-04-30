/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.servlet;

import com.soen.ebanking.model.Address;
import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.EWallet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewClientServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String streetNum,streetName,apartmentNum,city,province,postalCode,country;
            streetNum = request.getParameter("streetNum");
            streetName = request.getParameter("streetName");
            apartmentNum = request.getParameter("aptNum");
            city = request.getParameter("city");
            province = request.getParameter("province");
            postalCode = request.getParameter("postCode");
            country = request.getParameter("country");
            
            Address add = new Address();
            add.setStreetNumber(streetNum);
            add.setStreetName(streetName);
            add.setApartmentNumber(apartmentNum);
            add.setCity(city);
            add.setProvince(province);
            add.setCountry(country);
            add.setPostalCode(postalCode);
            add.saveAddress();
            
            String firstName, lastName, email, gender, phoneNum;
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            email = request.getParameter("email");
            gender = request.getParameter("gender");
            phoneNum = request.getParameter("phoneNum");
            
            Integer age = Integer.parseInt(request.getParameter("age"));
            
             if (session != null) {
                session.invalidate();
            }
             
            Client cl = new Client();
            cl.setFirstName(firstName);
            cl.setLastName(lastName);
            cl.setEmail(email);
            cl.setGender(gender);
            cl.setPhoneNumber(phoneNum);
            cl.setAge(age);
            cl.setUserAddress(add);
            cl.saveUser();
            
            EWallet ew = new EWallet();
            ew.setAccountNumber("eWallet");
            ew.setClient(cl);
            ew.saveAccount();
            
            
            response.sendRedirect("./admin/adminFinished.jsp");
            //out.println(firstName);
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
