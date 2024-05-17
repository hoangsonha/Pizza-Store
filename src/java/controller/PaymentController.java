/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.OrderDAO;
import model.OrderDetailDAO;
import model.Pizza;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {

    private final static String ERROR = "HomeController";
    private final static String SUCCESS = "HomeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String orderID = request.getParameter("orderID");
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LOGIN_USER");

            if (acc != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    ProductDAO dao_pro = new ProductDAO();
                    OrderDetailDAO dao = new OrderDetailDAO();
                    boolean haha = false;
                    for (Pizza pizza : cart.getLists().values()) {
                        Product pro = dao_pro.getProductByProductID(pizza.getProductID());
                        int quanINDB = pro.getQuantityPerUnit();
                        if (quanINDB > pizza.getQuantity()) {
                            double total_price = pizza.getQuantity() * pizza.getPrice();
                            boolean check = dao.add(Integer.parseInt(orderID), pro.getProductID(), total_price, pizza.getQuantity());
                            if (check) {
                                int quan = pro.getQuantityPerUnit() - pizza.getQuantity();
                                boolean check2 = dao_pro.update_quantity(pro.getProductID(), quan);
                                if (check2) {
                                    haha = true;
                                }
                            }
                        } else {
                            request.setAttribute("ERROR", "Khong du san pham de ban do san pham voi productID : " + pro.getProductID() + " con " + pro.getQuantityPerUnit() + " san pham trong kho!!!");
                        }
                    }
                    if (haha) {
                        OrderDAO dao_order = new OrderDAO();
                        boolean ch = dao_order.update_status("Successfully", Integer.parseInt(orderID));
                        if (ch) {
                            url = SUCCESS;
                            session.setAttribute("QUANTITY", 0);
                            session.setAttribute("CART", null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR at PaymentController : " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
