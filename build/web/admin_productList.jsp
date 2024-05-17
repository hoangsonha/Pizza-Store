<%-- 
    Document   : admin_productList
    Created on : Apr 16, 2024, 12:35:07 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Product Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style_admin.css" rel="stylesheet">  
    </head>
    <body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center" previewlistener="true">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Admin Page</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav nav-mg">
      <ul class="d-flex align-items-center">

        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#">

              <span class="d-md-block ps-2" style="font-size: 20px;">Admin : ${sessionScope.LOGIN_USER.userName}</span>
          </a><!-- End Profile Iamge Icon -->
          
          
          
        </li><!-- End Profile Nav -->
        <li class="logout-log">
            <a href="MainController?action=Logout" class="nav-link nav-profile d-flex align-items-center pe-0"  style="margin-right: 50px">Logout</a>
        </li>

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="adminPage.jsp">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav" href="MainController?action=Product_view">
          <i class="bi bi-menu-button-wide"></i><span>Products</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        
      </li><!-- End Components Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#forms-nav" href="MainController?action=Account_view">
          <i class="bi bi-journal-text"></i><span>Account</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Forms Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#tables-nav" href="HomeController">
          <i class="bi bi-layout-text-window-reverse"></i><span>Orders</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Tables Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#charts-nav" href="#">
          <i class="bi bi-bar-chart"></i><span>Report Static</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Charts Nav -->

      <li class="nav-heading">Pages</li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="account_profile.jsp">
          <i class="bi bi-person"></i>
          <span>Profile</span>
        </a>
      </li><!-- End Profile Page Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#">
          <i class="bi bi-envelope"></i>
          <span>Contact</span>
        </a>
      </li><!-- End Contact Page Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#">
          <i class="bi bi-card-list"></i>
          <span>FeedBack</span>
        </a>
      </li><!-- End Register Page Nav -->
    </ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Products</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#" previewlistener="true">Home</a></li>
          <li class="breadcrumb-item active">Products</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
    <section>
        <div class="text-center gd" style="font-size: 30px; margin-top: 30px">
            <a href="MainController?action=Create_Product_Page">Create Product</a>
        </div>
        <br>
        <br>
        <div style="text-align: center; font-size: 20px; color: greenyellow">${requestScope.MESSAGE}</div>
        <br>
        <br>
        <c:if test="${requestScope.PRODUCT_LIST != null}">
            <c:if test="${not empty requestScope.PRODUCT_LIST}">
                <table class="table table-bordered" style="margin-top: 20px; flex-grow: 1;" border="1">
                    <thead class="demo1 h5">
                        <tr>
                            <th>No</th>
                            <th>ProductID</th>
                            <th>ProductName</th>
                            <th>SupplierID</th>
                            <th>CategoryID</th>
                            <th>Quantity</th>
                            <th>UnitPrice</th>
                            <th>Image</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" varStatus="counter" items="${requestScope.PRODUCT_LIST}">
                    <form action="MainController" method="post">  
                            <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${product.productID}
                            </td>
                            <td>
                               ${product.productName}
                            </td>
                            <td>
                               ${product.supplierID}
                            </td>
                            <td>${product.categoryID}</td>
                            <td>${product.quantityPerUnit}</td>
                            <td>${product.unitPrice}</td>
                            <td>${product.productImg}</td>
                            <td>
                                <a class="separate" href="MainController?action=Update_Product_Page&productID=${product.productID}">Update</a>
                                <a href="MainController?action=Delete&productID=${product.productID}">Delete</a>
                            </td>
                        </tr>
                        </form>
                        </c:forEach>      
                    </tbody>
                </table>
                <br>
                <div class="h4" style="color: red; font-size: 16px">
                    ${requestScope.ERROR} 
                </div>    
            </c:if>
        </c:if>
    </section>
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
    <div class="copyright">
      Pizza Store <strong><span>Admin</span></strong>. All Rights Reserved
    </div>
      Designed by <a href="https://bootstrapmade.com/" previewlistener="true">HSH</a>
    
  </footer><!-- End Footer -->

</body>
</html>
