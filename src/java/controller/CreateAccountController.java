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
import model.AccountDAO;
import model.errorAccount;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CreateAccountController", urlPatterns = {"/CreateAccountController"})
public class CreateAccountController extends HttpServlet {
    private final static String LOGIN = "bothLoginRegister.jsp";
    private final static String ERROR = "createAccount.jsp";
    private final static String SUCCESS = "AccountController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LOGIN_USER");
            if(acc!=null) {
                if(acc.getType() == 1) {
                    String accountID = request.getParameter("accountID");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            int type = Integer.parseInt(request.getParameter("type"));
            AccountDAO dao = new AccountDAO();
            errorAccount error_account = new errorAccount();
            boolean check = true;
            if(accountID.length() < 3) {
                check = false;
                error_account.setErrorID("AccountID must be [3-200]");
            }
            if(userName.length() < 3) {
                check = false;
                error_account.setErrorUserName("UserName must be [3-200]");
            }
            if(password.length() < 6) {
                check = false;
                error_account.setErrorPassword("Password must be [6-200]");
            }
            if(fullName.length() < 3) {
                check = false;
                error_account.setErrorFullName("FullName must be [3-200]");
            }
            
            if(check) {
                boolean check_insert = dao.insert(accountID, userName, password, fullName, type);
                if(check_insert) {
                    url = SUCCESS;
                } 
            } else {
                request.setAttribute("ERROR", error_account);
            }
                } else {
                    url = LOGIN;
                }
            } else {
                url = LOGIN;
            }
        } catch(Exception e) {
            log("ERROR at CreateAccountController : " + e.toString());
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
