/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class MainController extends HttpServlet {
    private final static String WEL = "";
    private final static String WELCOME = "HomeController";
    
    private final static String SEARCH = "Search";
    private final static String SEARCH_PAGE = "SearchController";
    private final static String LOGIN_VIEW = "LoginView";
    private final static String LOGIN_VIEW_PAGE = "bothLoginRegister.jsp";
    private final static String LOGIN = "Login";
    private final static String LOGIN_PAGE = "LoginController";
    private final static String REGISTER_VIEW = "RegisterView";
    private final static String REGISTER_VIEW_PAGE = "bothLoginRegister.jsp";
    private final static String REGISTER = "Register";
    private final static String REGISTER_PAGE = "RegisterController";
    private final static String LOGOUT = "Logout";
    private final static String LOGOUT_PAGE = "LogoutController";
    
    private final static String PRODUCT_VIEW = "Product_view";
    private final static String PRODUCT_VIEW_PAGE = "ProductController";   
    private final static String CREATE_VIEW = "Create_Product_Page";
    private final static String CREATE_VIEW_PAGE = "CreateProductViewController";  
    private final static String CREATE = "Create";
    private final static String CREATE_PAGE = "CreateProductController"; 
    private final static String UPDATE_VIEW = "Update_Product_Page";
    private final static String UPDATE_VIEW_PAGE = "UpdateProductViewController";  
    private final static String UPDATE = "Update";
    private final static String UPDATE_PAGE = "UpdateProductController";
    private final static String DELETE = "Delete";
    private final static String DELETE_PAGE = "DeleteProductController";
    
    private final static String ACCOUNT_VIEW = "Account_view";
    private final static String ACCOUNT_VIEW_PAGE = "AccountController";
    private final static String CREATE_ACCOUNT_VIEW = "Create_Account_Page";
    private final static String CREATE_ACCOUNT_VIEW_PAGE = "CreateAccountViewController";  
    private final static String CREATE_ACCOUNT = "Create_account";
    private final static String CREATE_ACCOUNT_PAGE = "CreateAccountController"; 
    private final static String UPDATE_ACCOUNT_VIEW = "Update_Account_Page";
    private final static String UPDATE_ACCOUNT_VIEW_PAGE = "UpdateAccountViewController";  
    private final static String UPDATE_ACCOUNT = "Update_account";
    private final static String UPDATE_ACCOUNT_PAGE = "UpdateAccountController";
    private final static String DELETE_ACCOUNT = "Delete_account";
    private final static String DELETE_ACCOUNT_PAGE = "DeleteAccountController";
    
    private final static String CART_VIEW = "View_cart";
    private final static String CART_VIEW_PAGE = "ViewCartController";
    private final static String CHECKOUT = "checkout";
    private final static String CHECKOUT_PAGE = "CheckoutController";
    private final static String PAYMENT = "Payment";
    private final static String PAYMENT_PAGE = "PaymentController";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            if(SEARCH.equals(action)) {
                url = SEARCH_PAGE;
            } else if(LOGIN_VIEW.equals(action)) {
                url = LOGIN_VIEW_PAGE;
            } else if(LOGIN.equals(action)) {
                url = LOGIN_PAGE;
            } else if(REGISTER_VIEW.equals(action)) {
                url = REGISTER_VIEW_PAGE;
            } else if(REGISTER.equals(action)) {
                url = REGISTER_PAGE;
            } else if(LOGOUT.equals(action)) {
                url = LOGOUT_PAGE;
            } else if(PRODUCT_VIEW.equals(action)) {
                url = PRODUCT_VIEW_PAGE;
            } else if(CREATE_VIEW.equals(action)) {
                url = CREATE_VIEW_PAGE;
            } else if(CREATE.equals(action)) {
                url = CREATE_PAGE;
            } else if(UPDATE_VIEW.equals(action)) {
                url = UPDATE_VIEW_PAGE;
            } else if(UPDATE.equals(action)) {
                url = UPDATE_PAGE;
            } else if(DELETE.equals(action)) {
                url = DELETE_PAGE;
            } else if(ACCOUNT_VIEW.equals(action)) {
                url = ACCOUNT_VIEW_PAGE;
            } else if(CREATE_ACCOUNT_VIEW.equals(action)) {
                url = CREATE_ACCOUNT_VIEW_PAGE;
            } else if(CREATE_ACCOUNT.equals(action)) {
                url = CREATE_ACCOUNT_PAGE;
            } else if(UPDATE_ACCOUNT.equals(action)) {
                url = UPDATE_ACCOUNT_PAGE;
            } else if(UPDATE_ACCOUNT_VIEW.equals(action)) {
                url = UPDATE_ACCOUNT_VIEW_PAGE;
            } else if(DELETE_ACCOUNT.equals(action)) {
                url = DELETE_ACCOUNT_PAGE;
            } else if(CART_VIEW.equals(action)) {
                url = CART_VIEW_PAGE;
            } else if(WEL.equals(action)) {
                url = WELCOME;
            } else if(CHECKOUT.equals(action)) {
                url = CHECKOUT_PAGE;
            } else if(PAYMENT.equals(action)) {
                url = PAYMENT_PAGE;
            }  
        } catch(Exception e) {
            log("ERROR at MainCOntroller : " + e.toString());
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
