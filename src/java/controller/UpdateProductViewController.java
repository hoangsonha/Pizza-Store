/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Product;
import model.ProductDAO;
import model.Supplier;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UpdateProductViewController", urlPatterns = {"/UpdateProductViewController"})
public class UpdateProductViewController extends HttpServlet {

    private final static String LOGIN = "bothLoginRegister.jsp";
    private final static String ERROR = "updateProduct.jsp";
    private final static String SUCCESS = "updateProduct.jsp";

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
                    ProductDAO dao = new ProductDAO();
                    List<Category> list_category = dao.getAllCategory();
                    List<Supplier> list_supplier = dao.getAllSuppliers();
                    Product product = dao.getProductByProductID(productID);
                    if (product != null) {
                        request.setAttribute("PRODUCT", product);
                        request.setAttribute("LIST_CATEGORY", list_category);
                        request.setAttribute("LIST_SUPPLIER", list_supplier);
                        url = SUCCESS;
                    }
                } else {
                    url = LOGIN;
                }
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR at UpdateProductViewController :" + e.toString());
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
