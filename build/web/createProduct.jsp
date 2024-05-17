<%-- 
    Document   : CreateProduct
    Created on : Apr 16, 2024, 1:53:49 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style_createProduct.css" rel="stylesheet">  
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

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">

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
          <li class="breadcrumb-item">Products</li>
          <li class="breadcrumb-item active">Create</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
    <section>
        <div class="text-center gd" style="font-size: 30px; margin-top: 30px">
           <div>Input product's information</div>
        </div>
        <br>
        
        <!-- Session input information -->
        
            
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Register Today</h3>
                        <p>Fill in the data below.</p>
                        <form action="MainController" enctype="multipart/form-data" method="post">

                            <div class="col-md-12">
                               <input class="form-control" type="text" name="productID" placeholder="ProductID" required>
                            </div>
                            <div style="color: white; margin: 10px 15px 0 15px; font-size: 16px">${requestScope.ERROR.getErrorID()}</div>
                            <div class="col-md-12">
                               <input class="form-control" type="text" name="productName" placeholder="ProductName" required>
                            </div>
                            <div style="color: white; margin: 0px 15px 0 15px; font-size: 16px">${requestScope.ERROR.getErrorName()}</div>
                            <div class="col-md-12">
                                <select class="form-select mt-3" name="categoryID" required>
                                    <c:if test="${requestScope.LIST_CATEGORY != null}">
                                        <c:if test="${not empty requestScope.LIST_CATEGORY}">
                                            <c:forEach var="category" varStatus="counter" items="${requestScope.LIST_CATEGORY}">
                                                <option value="${category.categoryID}">${category.categoryName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-select mt-3" name="supplierID" required>
                                <c:if test="${requestScope.LIST_SUPPLIER != null}">
                                    <c:if test="${not empty requestScope.LIST_SUPPLIER}">
                                        <c:forEach var="supplier" varStatus="counter" items="${requestScope.LIST_SUPPLIER}">
                                            <option value="${supplier.supplierID}">${supplier.companyName}</option>                                       
                                        </c:forEach>
                                    </c:if>
                                </c:if>
                                </select>
                            </div>

                            <div class="col-md-12" style="margin-top: 15px;">
                               <input class="form-control" type="number" name="quantity" placeholder="QuantityPerUnit" required min="1">
                           </div>
                            <div class="col-md-12" style="margin-top: 15px;">
                               <input class="form-control" type="number" name="price" placeholder="Price" required min="1">
                           </div>
                           <div class="col-md-12" style="margin-top: 15px;">
                               <input class="form-control" type="file" id="productImg" name="productImg" placeholder="ProductImage" accept="image/jpeg,image/png,image/jpg">
                           </div>
                            <div class="form-button mt-3">
                                <button style="margin-top: 10px; padding: 10px" id="submit" type="submit" class="btn btn-primary" name="action" value="Create">Create</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        

        
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

<script type="text/javascript">



</script>
</html>
