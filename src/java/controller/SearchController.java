/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private final static String ERROR = "homePage.jsp";
    private final static String SUCCESS = "homePage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        PrintWriter out = response.getWriter();
        List<Product> lists = new ArrayList<>();
        String mess = "";
        String error = "";
        try {
            String search = request.getParameter("search1");
            String type = request.getParameter("type1");
            ProductDAO dao = new ProductDAO();
            boolean check = false;
            if(type == null) {
                type = "";
            }
            if (type.equals("search_name")) {
                lists = dao.getProductByName(search);
                if (lists != null) {
                    if (lists.size() > 0) {
                        check = true;
                        url = SUCCESS;
                        request.setAttribute("ALL_PRODUCT", lists);
                    }
                }
            }
            if (type.equals("search_id")) {
                lists = dao.getProductByID(search);
                if (lists != null) {
                    if (lists.size() > 0) {
                        check = true;
                        url = SUCCESS;
                        request.setAttribute("ALL_PRODUCT", lists);
                    } else if (lists.size() == 0) {
                        lists = dao.getProductByIdRecom(search);
                        if (lists.size() > 0) {
                            check = true;
                            url = SUCCESS;
                            request.setAttribute("ALL_PRODUCT", lists);
                            mess = "No Results, but recommended by the given key '" + search + "'";
                            request.setAttribute("MESSAGE", "No Results, but recommended by the given key '" + search + "'");
                        }
                    }
                }
            }
            if (type.equals("search_price")) {
                double price = Double.parseDouble(search);
                if (price >= 10000) {
                    lists = dao.getProductByPrice(price);
                    if (lists != null) {
                        if (lists.size() > 0) {
                            url = SUCCESS;
                            request.setAttribute("ALL_PRODUCT", lists);
                        } else if (lists.size() == 0) {
                            lists = dao.getProductByPriceRecom(price - 5000, price + 5000);
                            if (lists.size() > 0) {
                                check = true;
                                url = SUCCESS;
                                request.setAttribute("ALL_PRODUCT", lists);
                                mess = "No Results, but recommended by the given key '" + search + "'";
                                request.setAttribute("MESSAGE", "No Results, but recommended by the given key '" + search + "'");
                            }
                        }
                    }
                }
            }
            if(type.equals("")) {
                lists = dao.getProductByCategory(search);
                if(lists != null) {
                    check = true;
                    mess = "All product with Category Name : " + search;
                } else {
                    error = "No product with Category Name : " + search;
                }
                
            }
            if (!check) {
                error = "No found Products with key :  " + search;
                request.setAttribute("ERROR", "No found Products with key :  " + search);
            }
        } catch (Exception e) {
            log("ERROR at SearchController : " + e.toString());
        } finally {
            out.println("<c:if test=\"${requestScope.ALL_PRODUCT ==null}\">\n" +
"                                <h3 style=\"margin-bottom: 50px\">" + error + "</h3>\n" +
"                            </c:if>");
            out.println("<c:if test=\"${requestScope.MESSAGE != null}\">\n"
                    + "                <h3 style=\"margin-bottom: 50px\">" + mess + "</h3>\n"
                    + "                \n"
                    + "            </c:if>");
            for (Product p : lists) {
                out.println("<div class=\"col-md-8 col-lg-6 col-xl-4\">\n" +
"                                            <div class=\"card\" style=\"border-radius: 15px;\">\n" +
"                                                <div class=\"bg-image hover-overlay ripple ripple-surface ripple-surface-light\"\n" +
"                                                     data-mdb-ripple-color=\"light\">\n" +
"                                                    <img src=\"image/"+ p.getProductImg() +"\"\n" +
"                                                         style=\"border-top-left-radius: 15px; border-top-right-radius: 15px; object-fit: cover; height: 300px\" class=\"img-fluid\"\n" +
"                                                         alt=\"Pizza\" />\n" +
"                                                    <a href=\"#!\">\n" +
"                                                        <div class=\"mask\"></div>\n" +
"                                                    </a>\n" +
"                                                </div>\n" +
"                                                <div class=\"card-body pb-0\">\n" +
"                                                    <div class=\"d-flex justify-content-between\">\n" +
"                                                        <div>\n" +
"                                                            <p><a href=\"#!\" class=\"text-dark\">" + p.getProductName() + "</a></p>\n" +
"                                                            <p class=\"small text-muted\">Pizza</p>\n" +
"                                                        </div>\n" +
"                                                        <div>\n" +
"                                                            <div class=\"d-flex flex-row justify-content-end mt-1 mb-4 text-danger\">\n" +
"                                                                <i class=\"fas fa-star\"></i>\n" +
"                                                                <i class=\"fas fa-star\"></i>\n" +
"                                                                <i class=\"fas fa-star\"></i>\n" +
"                                                                <i class=\"fas fa-star\"></i>\n" +
"                                                            </div>\n" +
"                                                            <p class=\"small text-muted\">Rated 4.0/5</p>\n" +
"                                                        </div>\n" +
"                                                    </div>\n" +
"                                                </div>\n" +
"                                                <hr class=\"my-0\" />\n" +
"                                                <div class=\"card-body pb-0\">\n" +
"                                                    <div class=\"d-flex justify-content-between\">\n" +
"                                                        <p><a href=\"#!\" class=\"text-dark\">" + p.getUnitPrice() + " VND</a></p>\n" +
"                                                        <p class=\"text-dark\">#### " + p.getProductID() + "</p>\n" +
"                                                    </div>\n" +
"                                                </div>\n" +
"                                                <hr class=\"my-0\" />\n" +
"                                                <div class=\"card-body\">\n" +
"                                                    <div class=\"d-flex justify-content-between align-items-center pb-2 mb-1\">\n" +
"                                                        <a href=\"#!\" class=\"text-dark fw-bold\">Details</a>\n" +
"                                                        <button type=\"button\" data-mdb-button-init data-mdb-ripple-init class=\"btn btn-primary\" id=\"" + p.getProductID() + "\" value=\""+ p.getProductID() +"\" onclick=\"buyProduct(this)\">Buy now</button>\n" +
"                                                    </div>\n" +
"                                                    <div  style=\"color: greenyellow; font-size: 18px; text-align: center;\"></div> \n" +
"                                                </div>\n" +
"                                            </div> \n" +
"                                                    \n" +
"                                        </div> ");
            }
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
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
