/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.ErrorLogin;
import model.OrderDetailDAO;
import model.UserDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    private final static String ERROR = "bothLoginRegister.jsp";
    private final static String SUCCESS_ADMIN = "adminPage.jsp";
    private final static String SUCCESS_USER = "HomeController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("accountID");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            ErrorLogin errorLogin = new ErrorLogin();
            boolean check = true;
            if(userID.length() < 2) {
                check = false;
                errorLogin.setErrorID("AccountID must be [2-200] characters");
            }
            if(password.length() <= 5) {
                check = false;
                errorLogin.setErrorName("Password must be [6-200] characters");
            }
            
            if(check) {
                Account user = dao.checkLogin(userID, password);
                if(user!=null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", user);
                    if(user.getType() == 1) {
                        OrderDetailDAO dao1 = new OrderDetailDAO();
                        Date date = new Date();
                        SimpleDateFormat spdfm = new SimpleDateFormat("yyyy-MM-dd");
                        String da = spdfm.format(date);
                        int total_quantity = dao1.getSaleQuantity(da);
                        session.setAttribute("TOTAL_QUANTITY", total_quantity);
                        NumberFormat format = NumberFormat.getInstance();
                        double price = dao1.getTotalPrice();
                        session.setAttribute("TOTAL_PRICE", format.format(price));
                        url = SUCCESS_ADMIN;
                    } else {
                        if(user.getType() == 2) {
                            url = SUCCESS_USER;
                        } else {
                            request.setAttribute("ERROR", "Your role is not suppoted");
                        }
                    }
                } else {
                    request.setAttribute("ERROR", "Your AccountID or Password is not correct!!!");
                }
            } else {
                request.setAttribute("ERROR_LOGIN", errorLogin);
            }
        } catch (Exception e) {
            log("ERROR at LoginController : " + e.toString());
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
