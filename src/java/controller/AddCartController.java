/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Pizza;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddCartController", urlPatterns = {"/AddCartController"})
public class AddCartController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String productID = request.getParameter("productID");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("CART");
        try {
            Account acc = (Account) session.getAttribute("LOGIN_USER");
            if(acc != null) {
                if(cart == null) {
                    cart = new Cart();
                } 
                ProductDAO dao = new ProductDAO();
                Product product = dao.getProductByProductID(productID);
                Pizza pizza = new Pizza(product.getProductID(), product.getProductName(), product.getSupplierID(), product.getCategoryID(), 1, product.getUnitPrice(), product.getProductImg());
                boolean check = cart.add(pizza);
                if(check) {
                    int quantity =  cart.getTotalQuantity();
                    session.setAttribute("QUANTITY", quantity);
                    session.setAttribute("CART", cart);
                    String mess = "Add Cart Successfully";
                    out.println(mess);
                }    
            } else {
                out.println("bothLoginRegister.jsp");
            }
        } catch(Exception e) {
            log("ERROR at AddCartController : " + e.toString());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
