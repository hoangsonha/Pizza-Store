/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ADMIN
 */
@WebFilter(filterName = "AuthenFilter", urlPatterns = {"/*"})
public class AuthenFilter implements Filter {

    private static final boolean debug = true;

    private static List<String> USER_RESOURCE;
    private static List<String> ADMIN_RESOURCE;
    private static List<String> NON_AUTHEN_RESOURCE;
    private static final int US = 2;
    private static final int AD = 1;
    private static final String LOGIN_PAGE = "bothLoginRegister.jsp";
    private static final String HOME_PAGE = "MainController";

    private FilterConfig filterConfig = null;

    public AuthenFilter() {
        
        USER_RESOURCE = new ArrayList<>();   
        USER_RESOURCE.add("HistoryController");     
        USER_RESOURCE.add("AddCartController");
        USER_RESOURCE.add("CheckoutController");
        USER_RESOURCE.add("LogoutController");
        USER_RESOURCE.add("PaymentController");
        USER_RESOURCE.add("UpdateCartController");
        USER_RESOURCE.add("ViewCartController");
        USER_RESOURCE.add("DeleteCartController");
        USER_RESOURCE.add("homePage.jsp");
        USER_RESOURCE.add("EditUserController");
        
        NON_AUTHEN_RESOURCE = new ArrayList<>();
        NON_AUTHEN_RESOURCE.add("MainController");
        NON_AUTHEN_RESOURCE.add("bothLoginRegister.jsp");
        NON_AUTHEN_RESOURCE.add("homePage.jsp");
        NON_AUTHEN_RESOURCE.add("/css");
        NON_AUTHEN_RESOURCE.add("SearchController");
        NON_AUTHEN_RESOURCE.add("RegisterAccountController");
        NON_AUTHEN_RESOURCE.add("HomeController");
        NON_AUTHEN_RESOURCE.add("LoginController");
        NON_AUTHEN_RESOURCE.add("/image");    
        
        ADMIN_RESOURCE = new ArrayList<>();   
        ADMIN_RESOURCE.add("AccountController");
        ADMIN_RESOURCE.add("AddCartController");
        ADMIN_RESOURCE.add("CheckoutController");
        ADMIN_RESOURCE.add("CreateAccountController");
        ADMIN_RESOURCE.add("CreateAccountViewController");
        ADMIN_RESOURCE.add("CreateProductController");
        ADMIN_RESOURCE.add("CreateProductViewController");
        ADMIN_RESOURCE.add("DeleteAccountController");
        ADMIN_RESOURCE.add("DeleteCartController");
        ADMIN_RESOURCE.add("DeleteProductController");
        ADMIN_RESOURCE.add("EditUserController");
        ADMIN_RESOURCE.add("HistoryController");
        ADMIN_RESOURCE.add("LogoutController");
        ADMIN_RESOURCE.add("PaymentController");
        ADMIN_RESOURCE.add("ProductController");
        ADMIN_RESOURCE.add("ReportController");
        ADMIN_RESOURCE.add("UpdateAccountController");
        ADMIN_RESOURCE.add("UpdateAccountViewController");
        ADMIN_RESOURCE.add("UpdateCartController");
        ADMIN_RESOURCE.add("UpdateProductController");
        ADMIN_RESOURCE.add("ViewCartController");     
        ADMIN_RESOURCE.add("adminPage.jsp");
        ADMIN_RESOURCE.add("homePage.jsp");
        ADMIN_RESOURCE.add("updateAccount.jsp");
        ADMIN_RESOURCE.add("updateProduct.jsp");
        ADMIN_RESOURCE.add("createAccount.jsp");
        ADMIN_RESOURCE.add("createProduct.jsp");
        ADMIN_RESOURCE.add("admin_profile.jsp");
        ADMIN_RESOURCE.add("admin_accountList.jsp");
        ADMIN_RESOURCE.add("admin_productList.jsp");
        ADMIN_RESOURCE.add("account_profile.jsp");
        
        
        
        
        
        
        
        
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        int index = uri.lastIndexOf("/");
        String resource = uri.substring(index + 1);

        boolean checkContain = false;

        for (String str : NON_AUTHEN_RESOURCE) {
            if (uri.contains(str)) {
                checkContain = true;
                break;
            }
        }
        if (checkContain) {
            chain.doFilter(request, response);

        } else {
            HttpSession session = req.getSession();
            if (session == null || session.getAttribute("LOGIN_USER") == null) {
                res.sendRedirect(HOME_PAGE);
            } else {             
                String roleID = String.valueOf(((Account) session.getAttribute("LOGIN_USER")).getType());
                
                if (US == Integer.parseInt(roleID) && USER_RESOURCE.contains(resource)) {
                            chain.doFilter(request, response);
                } else if (AD == Integer.parseInt(roleID) && ADMIN_RESOURCE.contains(resource)) {
                            chain.doFilter(request, response);
                        } else {
                            res.sendRedirect(HOME_PAGE);
                        }  
                    }
                }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AuthenFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthenFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthenFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
