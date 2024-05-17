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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "EditUserController", urlPatterns = {"/EditUserController"})
public class EditUserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mess = "";

        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        if (acc != null) {

                mess =                      "    <section class=\"section profile\">\n"
                    + "      <div class=\"row\">\n"
                    + "        <div class=\"col-xl-4\">\n"
                    + "\n"
                    + "          <div class=\"card\">\n"
                    + "              <div class=\"card-body profile-card pt-4 d-flex flex-column align-items-center\">\n"
                    + "                <h1 id=\"la\">" + acc.getFullName() + "</h1>\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"col-xl-8\">\n"
                    + "\n"
                    + "          <div class=\"card\">\n"
                    + "            <div class=\"card-body pt-3\">\n"
                    + "              <!-- Bordered Tabs -->\n"
                    + "              <ul class=\"nav nav-tabs nav-tabs-bordered\" role=\"tablist\">\n"
                    + "\n"
                    + "                <li class=\"nav-item\" role=\"presentation\">\n"
                    + "                  <button class=\"nav-link active\" data-bs-toggle=\"tab\" data-bs-target=\"#profile-overview\" aria-selected=\"true\" role=\"tab\">Overview</button>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item\" role=\"presentation\">\n"
                    + "                  <button class=\"nav-link\" data-bs-toggle=\"tab\" data-bs-target=\"#profile-edit\" aria-selected=\"false\" tabindex=\"-1\" role=\"tab\">Edit Profile</button>\n"
                    + "                </li>\n"
                    + "              </ul>\n"
                    + "              <div class=\"tab-content pt-2\">\n"
                    + "\n"
                    + "                <div class=\"tab-pane fade show active profile-overview\" id=\"profile-overview\" role=\"tabpanel\">\n"
                    + "                   <h5 class=\"card-title\">Profile Details</h5>\n"
                    + "\n"
                    + "                  <div class=\"row\">\n"
                    + "                    <div class=\"col-lg-3 col-md-4 label \">AccountID</div>\n"
                    + "                    <div class=\"col-lg-9 col-md-8\">" + acc.getAccountID() + "</div>\n"
                    + "                  </div>\n"
                    + "\n"
                    + "                  <div class=\"row\">\n"
                    + "                    <div class=\"col-lg-3 col-md-4 label\">UserName</div>\n"
                    + "                    <div class=\"col-lg-9 col-md-8\" id=\"userName2\">" + acc.getUserName() + "</div>\n"
                    + "                  </div>\n"
                    + "\n"
                    + "                  <div class=\"row\">\n"
                    + "                    <div class=\"col-lg-3 col-md-4 label\">Password</div>\n"
                    + "                    <div class=\"col-lg-9 col-md-8\" id=\"password2\">" + acc.getPassword() + "</div>\n"
                    + "                  </div>\n"
                    + "\n"
                    + "                  <div class=\"row\">\n"
                    + "                    <div class=\"col-lg-3 col-md-4 label\">FullName</div>\n"
                    + "                    <div class=\"col-lg-9 col-md-8\" id=\"fullName2\">" + acc.getFullName() + "</div>\n"
                    + "                  </div>\n"
                    + "\n"
                    + "                  <div class=\"row\">\n"
                    + "                    <div class=\"col-lg-3 col-md-4 label\">Type</div>\n"
                    + "                    <div class=\"col-lg-9 col-md-8\">" + acc.getType() + "\n"
                    + "                    </div>\n"
                    + "                  </div>\n"
                    + "                </div>\n"
                    + "\n"
                    + "                    \n"
                    + "                <div class=\"tab-pane fade profile-edit pt-3\" id=\"profile-edit\" role=\"tabpanel\">\n"
                    + "\n"
                    + "                  <!-- Profile Edit Form -->\n"
                    + "                  <form>\n"
                    + "                    \n"
                    + "                     <h3>Update Today</h3>\n"
                    + "                     <p>Fill in the data below.</p>\n"
                    + "                     <div id=\"mess\" style=\"color: greenyellow; font-size: 18px; text-align: center; margin-bottom: 10px\"></div>\n"
                    + "                    <div class=\"row mb-3\">\n"
                    + "                      <label for=\"fullName\" class=\"col-md-4 col-lg-3 col-form-label\">AccountID</label>\n"
                    + "                      <div class=\"col-md-8 col-lg-9\">\n"
                    + "                          <input class=\"form-control\" type=\"text\" id=\"accountID\" name=\"accountID\" value=\"" + acc.getAccountID() + "\" readonly=\"\">\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "                      <div class=\"row mb-3\">\n"
                    + "                      <label for=\"fullName\" class=\"col-md-4 col-lg-3 col-form-label\">UserName</label>\n"
                    + "                      <div class=\"col-md-8 col-lg-9\">\n"
                    + "                          <input class=\"form-control\" type=\"text\" id=\"userName\" name=\"userName\" value=\"" + acc.getUserName() + "\" required=\"\">\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                      <div class=\"row mb-3\">\n"
                    + "                      <label for=\"fullName\" class=\"col-md-4 col-lg-3 col-form-label\">Password</label>\n"
                    + "                      <div class=\"col-md-8 col-lg-9\">\n"
                    + "                          <input class=\"form-control\" type=\"text\" id=\"password\" name=\"password\" value=\"" + acc.getPassword() + "\" required=\"\">\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                      <div class=\"row mb-3\">\n"
                    + "                      <label for=\"fullName\" class=\"col-md-4 col-lg-3 col-form-label\">FullName</label>\n"
                    + "                      <div class=\"col-md-8 col-lg-9\">\n"
                    + "                          <input class=\"form-control\" type=\"text\" id=\"fullName\" name=\"fullName\" value=\"" + acc.getFullName() + "\" required=\"\">\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                      <div class=\"row mb-3\">\n"
                    + "                      <label for=\"fullName\" class=\"col-md-4 col-lg-3 col-form-label\">Type</label>\n"
                    + "                      <div class=\"col-md-8 col-lg-9\">\n"
                    + "                          <input class=\"form-control\" type=\"text\" id=\"type\" name=\"type\" \n"
                    + "                                     value=\"" + acc.getType() + "\" readonly=\"\">\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"row mb-3\">\n"
                    + "                      <label for=\"about\" class=\"col-md-4 col-lg-3 col-form-label\">Sign with your name</label>\n"
                    + "                      <div class=\"col-md-8 col-lg-9\">\n"
                    + "                        <textarea name=\"about\" class=\"form-control\" id=\"about\" style=\"height: 100px\"></textarea>\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"text-center\">\n"
                    + "                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"saveAccount()\">Save Changes</button>\n"
                    + "                    </div>\n"
                    + "                  </form><!-- End Profile Edit Form -->\n"
                    + "\n"
                    + "                </div>\n"
                    + "\n"
                    + "              </div><!-- End Bordered Tabs -->\n"
                    + "\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "    </section>\n";
            out.println(mess);
        } else {
            out.println("bothLoginRegister.jsp");
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
