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
import model.ErrorProduct;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {

    private final static String LOGIN = "bothLoginRegister.jsp";
    private final static String ERROR = "UpdateProductViewController";
    private final static String SUCCESS = "ProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LOGIN_USER");
            if (acc != null) {
                if (acc.getType() == 1) {
                    String productID = request.getParameter("productID");
                    String productName = request.getParameter("productName");
                    String categoryID = request.getParameter("categoryID");
                    String supplierID = request.getParameter("supplierID");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    String productImg = request.getParameter("productImg");
                    ProductDAO dao = new ProductDAO();
                    ErrorProduct error_product = new ErrorProduct();
                    boolean check = true;
                    if (productName.length() < 3) {
                        check = false;
                        error_product.setErrorName("ProductName must be [3-200]");
                    }
                    Product product = dao.getProductByProductID(productID);
                    if (productImg == "") {
                        productImg = product.getProductImg();
                    }
                    if (check) {
                        boolean check_update = dao.update(productID, productName, categoryID, supplierID, quantity, price, productImg);
                        if (check_update) {
                            url = SUCCESS;
                        }
                    } else {
                        request.setAttribute("ERROR", error_product);
                    }
                } else {
                    url = LOGIN;
                }
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR at UpdateProductController : " + e.toString());
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
