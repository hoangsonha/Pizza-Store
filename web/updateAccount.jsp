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
        <title>Update Account Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>     
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" crossorigin="anonymous" />
        <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
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

              <span id="title" class="d-md-block ps-2" style="font-size: 20px;">Admin : ${sessionScope.LOGIN_USER.userName}</span>
              <input type="hidden" id="name_title" value="${sessionScope.LOGIN_USER.accountID}">
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
          <li class="breadcrumb-item">Account</li>
          <li class="breadcrumb-item active">Update</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
    <section>
        <div class="text-center gd" style="font-size: 30px; margin-top: 30px">
           <div>Input Account's information</div>
        </div>
        <br>
        
        <!-- Session input information -->
        
            
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Update Today</h3>
                        <p>Fill in the data below.</p>
                        <div id="mess" style="font-size: 18px; text-align: center; color: greenyellow; margin: 10px"></div>
                        <form class="requires-validation">

                            <div class="col-md-12">
                                <input class="form-control" type="text" id="accountID" name="accountID" value="${requestScope.ACCOUNT.accountID}" readonly="">
                            </div>

                            <div class="col-md-12">
                                <input class="form-control" type="text" id="userName" name="userName" value="${requestScope.ACCOUNT.userName}" required>
                            </div>
                            <div style="color: white; margin: 5px 15px 0 15px; font-size: 16px">${requestScope.ERROR.getErrorName()}</div>
                            
                            <div class="col-md-12" style="margin-top: 15px;">
                                <input class="form-control" type="password" id="password" name="password" value="${requestScope.ACCOUNT.password}" required>
                           </div>
                            <div class="col-md-12" style="margin-top: 15px;">
                                <input class="form-control" type="text" id="fullName" name="fullName" value="${requestScope.ACCOUNT.fullName}" required>
                           </div>
                            <div class="col-md-12">
                                <select class="form-select mt-3" id="type" name="type" required>
                                   <option value="1">1</option> 
                                   <option value="2">2</option>    
                                </select>
                            </div>
                            <div class="form-button mt-3">
                                <button style="margin-top: 10px; padding: 10px" id="submit" type="button" class="btn btn-primary" name="action" value="Update_account" onclick="saveAccount()">Update Account</button>
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

<script>
      function saveAccount() {
            var aID = document.getElementById('accountID').value;
            var uName = document.getElementById('userName').value;
            var pass = document.getElementById('password').value;
            var fName = document.getElementById('fullName').value;
            var ty = document.getElementById('type').value;
            console.log(aID);
             
            document.getElementById('userName').value = uName;
            document.getElementById('password').value = pass;
            document.getElementById('fullName').value = fName;
            
            var accID = document.getElementById('name_title').value;
            
            if(aID == accID) {
                document.getElementById('title').innerText = 'Admin : ' + uName;
            }
            document.getElementById('type').value = ty;
            $.ajax({
                url: 'UpdateAccountController',
                type: 'POST',
                data: {
                    accountID: aID,
                    userName: uName,
                    password: pass,
                    fullName: fName,
                    type: ty
                },
                success: function (rest) {
                    var me = document.getElementById('mess');
                    me.innerText = rest;
                }
            });
        }
  </script>
</body>
</html>
