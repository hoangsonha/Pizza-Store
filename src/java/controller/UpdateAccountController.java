/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "UpdateAccountController", urlPatterns = {"/UpdateAccountController"})
public class UpdateAccountController extends HttpServlet {

//    private final static String ERROR = "updateAccount.jsp";
//    private final static String SUCCESS = "AccountController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

//        try {
//            String accountID = request.getParameter("accountID");
//            String userName = request.getParameter("userName");
//            String password = request.getParameter("password");
//            String fullName = request.getParameter("fullName");
//            int type = Integer.parseInt(request.getParameter("type"));
//            AccountDAO dao = new AccountDAO();
//            errorAccount error_account = new errorAccount();
//            boolean check = true;
//            if(accountID.length() < 3) {
//                check = false;
//                error_account.setErrorID("AccountID must be [3-200]");
//            }
//            if(userName.length() < 3) {
//                check = false;
//                error_account.setErrorUserName("UserName must be [3-200]");
//            }
//            if(password.length() < 6) {
//                check = false;
//                error_account.setErrorPassword("Password must be [6-200]");
//            }
//            if(fullName.length() < 3) {
//                check = false;
//                error_account.setErrorFullName("FullName must be [3-200]");
//            }
//            if(check) {
//                boolean check_update = dao.update(accountID, userName, password, fullName, type);
//                if(check_update) {
//                    url = SUCCESS;
//                } 
//            } else {
//                request.setAttribute("ERROR", error_account);
//            }
//        } catch(Exception e) {
//            log("ERROR at UpdateProductController : " + e.toString());
//        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
//        }
            PrintWriter out = response.getWriter();
            String accountID = request.getParameter("accountID");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            int type = Integer.parseInt(request.getParameter("type"));
            AccountDAO dao = new AccountDAO();
            String mess = "";
            errorAccount error_account = new errorAccount();
            boolean check = true;
            if(accountID.length() < 3) {
                check = false;
                error_account.setErrorID("AccountID must be [3-200]");
            }
            if(userName.length() < 2) {
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
                boolean check_update = dao.update(accountID, userName, password, fullName, type);
                if(check_update) {
                    mess = "Update Account successfully!!!";
                    out.println(mess);
                    HttpSession session = request.getSession();
                    Account account = (Account) session.getAttribute("LOGIN_USER");
                    if(account!=null) {
                        if(account.getAccountID().equals(accountID)) {
                            account.setType(type);
                            account.setFullName(fullName);
                            account.setPassword(password);
                            account.setUserName(userName);
                            session.setAttribute("LOGIN_USER", account);
                        }    
                    }
                } 
            } else {
                request.setAttribute("ERROR", error_account);
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
            Logger.getLogger(UpdateAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
