/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String productID = request.getParameter("productID");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String mess = "";
        SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        NumberFormat format = NumberFormat.getInstance();
        double total = 0;
        String date = spd.format(d);
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LOGIN_USER");
            if (acc != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart == null) {
                    cart = new Cart();
                }
                ProductDAO dao = new ProductDAO();
                Product product = dao.getProductByProductID(productID);
                if (product != null) {
                    Pizza pizza = new Pizza(product.getProductID(), product.getProductName(), product.getSupplierID(), product.getCategoryID(), 1, product.getUnitPrice(), product.getProductImg());
                    cart.edit(pizza.getProductID(), quantity);
                    session.setAttribute("CART", cart);
                    total = cart.getTotalPrice();
                    mess = "<div class=\"container\">\n"
                            + "    <div class=\"row\">\n"
                            + "        <h1 style=\"text-align: center; margin: 20px 0 50px 0\">Cart's " + acc.getFullName() + "</h1>\n"
                            + "        <div class=\"col-xl-8\">"
                            + "        ";

                    for (Pizza p : cart.getLists().values()) {
                        mess += "<div class=\"card border shadow-none\">\n"
                                + "                <div class=\"card-body\">\n"
                                + "\n"
                                + "                    <div class=\"d-flex align-items-start border-bottom pb-3\">\n"
                                + "                        <div class=\"me-4\">\n"
                                + "                            <img src=\"image/" + p.getImg() + "\" alt=\"\" style=\"height: 100px; width: 100px\" class=\"avatar-lg rounded\">\n"
                                + "                        </div>\n"
                                + "                        <div class=\"flex-grow-1 align-self-center overflow-hidden\">\n"
                                + "                            <div>\n"
                                + "                                <h5 class=\"text-truncate font-size-18\"><a href=\"#\" class=\"text-dark\">" + p.getProductName() + "</a></h5>\n"
                                + "                                <p class=\"text-muted mb-0\">\n"
                                + "                                    <i class=\"bx bxs-star text-warning\"></i>\n"
                                + "                                    <i class=\"bx bxs-star text-warning\"></i>\n"
                                + "                                    <i class=\"bx bxs-star text-warning\"></i>\n"
                                + "                                    <i class=\"bx bxs-star text-warning\"></i>\n"
                                + "                                    <i class=\"bx bxs-star-half text-warning\"></i>\n"
                                + "                                </p>\n"
                                + "                                <p class=\"mb-0 mt-1\">#### <span class=\"fw-medium\">" + p.getProductID() + "</span></p>\n"
                                + "                            </div>\n"
                                + "                        </div>\n"
                                + "                        <div class=\"flex-shrink-0 ms-2\">\n"
                                + "                            <ul class=\"list-inline mb-0 font-size-16\">\n"
                                + "                                <li class=\"list-inline-item\">\n"
                                + "                                     <button onclick=\"deleteProduct(this)\" value=\"" + p.getProductID() + "\" href=\"#\" class=\"text-muted px-1\" style=\"border: none\">\n"
                                + "                                        <i class=\"fa-solid fa-trash\"></i>\n"
                                + "                                    </button>"
                                + "                                </li>\n"
                                + "                            </ul>\n"
                                + "                        </div>\n"
                                + "                    </div>\n"
                                + "\n"
                                + "                    <div>\n"
                                + "                        <div class=\"row\">\n"
                                + "                            <div class=\"col-md-4\">\n"
                                + "                                <div class=\"mt-3\">\n"
                                + "                                    <p class=\"text-muted mb-2\">Price</p>\n"
                                + "                                    <h5 class=\"mb-0 mt-2\">" + format.format(p.getPrice()) + " VND</h5>\n"
                                + "                                </div>\n"
                                + "                            </div>\n"
                                + "                            <div class=\"col-md-5\">\n"
                                + "                                <div class=\"mt-3\">\n"
                                + "                                    <p class=\"text-muted mb-2\">Quantity</p>\n"
                                + "                                    <div class=\"d-inline-flex\" style=\"width: 100px;\">\n"
                                + "                         <input type=\"number\" value=\"" + p.getQuantity() + "\" name=\"quantity_cart\" id=\"quantity_cart_" + p.getProductID() + "\" min=\"1\">\n"
                                + "                                                           <button type=\"button\" class=\"btn btn-primary\" style=\"width: 60px; height: 30px\" id=\"update_cart\" name=\"update_cart\" onclick=\"updateCart(this)\" value=\"" + p.getProductID() + "\">Save</button>"
                                + "                                    </div>\n"
                                + "                                </div>\n"
                                + "                            </div>\n"
                                + "                            <div class=\"col-md-3\">\n"
                                + "                                <div class=\"mt-3\">\n"
                                + "                                    <p class=\"text-muted mb-2\">Total</p>\n"
                                + "                                    <h5>" + format.format((p.getPrice() * p.getQuantity())) + "</h5>\n"
                                + "                                </div>\n"
                                + "                            </div>\n"
                                + "                        </div>\n"
                                + "                    </div>\n"
                                + "\n"
                                + "                </div>\n"
                                + "            </div>";
                    };
                    mess += "<div class=\"row my-4\">\n"
                            + "                <div class=\"col-sm-6\">\n"
                            + "                    <a href=\"HomeController\" class=\"btn btn-link text-muted\">\n"
                            + "                        <i class=\"mdi mdi-arrow-left me-1\"></i> Continue Shopping </a>\n"
                            + "                </div> <!-- end col -->\n"
                            + "                <div class=\"col-sm-6\">\n"
                            + "                    <div class=\"text-sm-end mt-2 mt-sm-0\">\n"
                             + "                    <button onclick=\"checkout(this)\" value=\"" + acc.getAccountID() +"\" class=\"btn btn-success\">\n"
                                + "                            <i class=\"mdi mdi-cart-outline me-1\"></i> Checkout </button>\n"
                            + "                    </div>\n"
                            + "                </div> <!-- end col -->\n"
                            + "            </div> <!-- end row-->\n"
                            + "        </div>";
                    mess += "<div class=\"col-xl-4\">\n"
                            + "            <div class=\"mt-5 mt-lg-0\">\n"
                            + "                <div class=\"card border shadow-none\">\n"
                            + "                    <div class=\"card-header bg-transparent border-bottom py-3 px-4\">\n"
                            + "                        <h5 class=\"font-size-16 mb-0\">Order Summary</h5>\n"
                            + "                    </div>\n"
                            + "                    <div class=\"card-body p-4 pt-2\">\n"
                            + "\n"
                            + "                        <div class=\"table-responsive\">\n"
                            + "                            <table class=\"table mb-0\">\n"
                            + "                                <tbody>\n"
                            + "                                    <tr>\n"
                            + "                                        <td>AccountID :</td>\n"
                            + "                                        <td class=\"text-end\">" + acc.getAccountID() + "</td>\n"
                            + "                                    </tr>\n"
                            + "                                    <tr>\n"
                            + "                                        <c:set var = \"date\" scope = \"request\" value = \"<%= new Date()%>\"/>\n"
                            + "                                        <td>Order Date : </td>\n"
                            + "                                        <td id=\"date\" class=\"text-end\">\n"
                            + "                                            <p>" + date + "</p>     \n"
                            + "                                        </td>\n"
                            + "                                    </tr>\n"
                            + "                                    <tr>\n"
                            + "                                        <td>Ship Address:</td>\n"
                            + "                                        <td class=\"text-end\">\n"
                            + "                                            <textarea id=\"address\"></textarea>\n"
                            + "                                        </td>\n"
                            + "                                    </tr>\n"
                            + "                                    <tr class=\"bg-light\">\n"
                            + "                                        <th>Total :</th>\n"
                            + "                                        <td class=\"text-end\">\n"
                            + "                                            <span class=\"fw-bold\">\n"
                            + "                                                " + format.format(total) + " VND\n"
                            + "                                            </span>\n"
                            + "                                        </td>\n"
                            + "                                    </tr>\n"
                            + "                                </tbody>\n"
                            + "                            </table>\n"
                            + "                        </div>\n"
                            + "                        <!-- end table-responsive -->\n"
                            + "                    </div>\n"
                            + "                </div>\n"
                            + "            </div>\n"
                            + "        </div>";
                    mess += "    </div>\n"
                            + "</div>";

                }
            } else {
                mess = "bothLoginRegister.jsp";

            }
        } catch (Exception e) {
            log("ERROR at UpdateCartController : " + e.toString());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCartController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCartController.class.getName()).log(Level.SEVERE, null, ex);
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
