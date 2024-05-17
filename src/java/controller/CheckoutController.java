/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Order;
import model.OrderDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       String mess = "";
       try {
           String accountID = request.getParameter("accountID");
           String date = request.getParameter("date");
           String address = request.getParameter("address");
           HttpSession session = request.getSession();
           Account acc = (Account) session.getAttribute("LOGIN_USER");
           if(acc!=null) {
               OrderDAO dao = new OrderDAO();
               Order order = new Order(accountID, date, "Processing", address);
               order.setId(dao.maxID() + 1);
               boolean check = dao.add(accountID, date, "Processing" , address);
               if(check) {
                   mess = "<form action=\"MainController\">\n" +
"                                               <select name=\"sele\">\n" +
"                                                <option value=\"Momo\">Mono</option>\n" +
"                                                <option value=\"ZaloPay\">ZaloPay</option>\n" +
"                                                <option value=\"NH\">NH</option>\n" +
"                                                </select> \n" +
                           "                     <input type=\"hidden\" name=\"orderID\" value=\"" + order.getId() +"\">\n" +
"                                                <input type=\"submit\" name=\"action\" value=\"Payment\">\n" +
"                                            </form>";
               }
           } else {
               mess = "bothLoginRegister.jsp";
           }
       } catch (Exception e) {
           mess = "Cannot checkout!!!";
       } finally {
           out.println(mess);
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
