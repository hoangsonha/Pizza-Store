/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.History;
import model.OrderDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "HistoryController", urlPatterns = {"/HistoryController"})
public class HistoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NumberFormat format = NumberFormat.getInstance();
        String mess = "";
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LOGIN_USER");
            if (acc != null) {
                OrderDAO dao = new OrderDAO();
                List<History> lists = dao.getHistory(acc.getAccountID());
                if (lists != null) {
                    mess = "<div style=\"text-align: center;\"><h1>List History of Cart</h1></div>\n"
                            + "\n"
                            + "            <table class=\"table table-bordered\" style=\"margin-top: 20px; flex-grow: 1;\" border=\"1\">\n"
                            + "                <thead class=\"demo h5\">\n"
                            + "                    <tr>\n"
                            + "                        <th style=\"padding: 8px 8px 8px 12px\">ProductID</th>\n"
                            + "                        <th>Quantity</th>\n"
                            + "                        <th>Price</th>\n"
                            + "                        <th>OrderDate</th>\n"
                            + "                        <th>Status</th>\n"
                            + "                        <th>ShipAddress</th>\n"
                            + "                    </tr>\n"
                            + "                </thead>\n"
                            + "                <tbody>    ";
                    if (lists.size() > 0) {
                        for (History li : lists) {
                            mess += "<tr class=\"tran\">\n"
                                    + "                        <td class=\"fw-bold\" style=\"padding: 8px 8px 8px 15px\">" + li.getProductID() +"</td>\n"
                                    + "                        <td>" + li.getQuantity() + "</td>\n"
                                    + "                        <td>" + format.format(li.getPrice()) + " VND</td>\n"
                                    + "                        <td>" + li.getOrderDate() + "</td>\n"
                                    + "                        <td>" + li.getStatus() + "</td>\n"
                                    + "                        <td>" + li.getAddress() + "</td>\n"
                                    + "                    </tr>";
                        }

                    }
                    mess += " </tbody>\n"
                            + "            </table> \n"
                            + "                    \n"
                            + "                    <a style=\"font-size: 20px; color: grey; padding: 40px 60px;\" href=\"HomeController\">Back to Home</a>";
                } else {
                    mess = "<h1>History is Empty!!!</h1>";
                }
            } else {
                mess = "bothLoginRegister.jsp";
            }
        } catch (Exception e) {
            log("ERROR at HistoryController : " + e.toString());
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
