<%-- 
    Document   : account_profile
    Created on : Apr 16, 2024, 1:18:32 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>     
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" crossorigin="anonymous" />
        <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
        <link href="css/style_admin.css" rel="stylesheet">  
    </head>
    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="index.html" class="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="">
                    <span class="d-none d-lg-block">Admin Page</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->

            <nav class="header-nav nav-mg">
                <ul class="d-flex align-items-center">

                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">

                            <span id="name_title" class="d-md-block ps-2" style="font-size: 20px;">Admin : ${sessionScope.LOGIN_USER.userName}</span>
                        </a><!-- End Profile Iamge Icon -->



                    </li><!-- End Profile Nav -->
                    <li class="logout-log">
                        <a href="MainController?action=Logout" class="nav-link nav-profile d-flex align-items-center pe-0" style="margin-right: 50px">Logout</a>
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
                <h1>Profile</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="homePage.jsp">Home</a></li>
                        <li class="breadcrumb-item active">Profile</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section profile">
                <div class="row">
                    <div class="col-xl-4">

                        <div class="card">
                            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                                <h1 id="la">${sessionScope.LOGIN_USER.fullName}</h1>
                            </div>
                        </div>

                    </div>

                    <div class="col-xl-8">

                        <div class="card">
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered" role="tablist">

                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview" aria-selected="true" role="tab">Overview</button>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit" aria-selected="false" tabindex="-1" role="tab">Edit Profile</button>
                                    </li>
                                </ul>
                                <div class="tab-content pt-2">

                                    <div class="tab-pane fade show active profile-overview" id="profile-overview" role="tabpanel">
                                        <h5 class="card-title">Profile Details</h5>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">AccountID</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.LOGIN_USER.accountID}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">UserName</div>
                                            <div class="col-lg-9 col-md-8" id="userName2">${sessionScope.LOGIN_USER.userName}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Password</div>
                                            <div class="col-lg-9 col-md-8" id="password2">${sessionScope.LOGIN_USER.password}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">FullName</div>
                                            <div class="col-lg-9 col-md-8" id="fullName2">${sessionScope.LOGIN_USER.fullName}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Type</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.LOGIN_USER.type}
                                                <c:if test="${sessionScope.LOGIN_USER.type == 1}">(Admin)</c:if>
                                                <c:if test="${sessionScope.LOGIN_USER.type == 2}">(User)</c:if>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="tab-pane fade profile-edit pt-3" id="profile-edit" role="tabpanel">

                                            <!-- Profile Edit Form -->
                                            <form>

                                                <h3>Update Today</h3>
                                                <p>Fill in the data below.</p>
                                                <div id="mess" style="color: greenyellow; font-size: 18px; text-align: center; margin-bottom: 10px"></div>
                                                <div class="row mb-3">
                                                    <label for="fullName" class="col-md-4 col-lg-3 col-form-label">AccountID</label>
                                                    <div class="col-md-8 col-lg-9">
                                                        <input class="form-control" type="text" id="accountID" name="accountID" value="${sessionScope.LOGIN_USER.accountID}" readonly="">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="fullName" class="col-md-4 col-lg-3 col-form-label">UserName</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input class="form-control" type="text" id="userName" name="userName" value="${sessionScope.LOGIN_USER.userName}" required="">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input class="form-control" type="text" id="password" name="password" value="${sessionScope.LOGIN_USER.password}" required="">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="fullName" class="col-md-4 col-lg-3 col-form-label">FullName</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input class="form-control" type="text" id="fullName" name="fullName" value="${sessionScope.LOGIN_USER.fullName}" required="">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Type</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input class="form-control" type="text" id="type" name="type" 
                                                           value="${sessionScope.LOGIN_USER.type}" readonly="">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="about" class="col-md-4 col-lg-3 col-form-label">Sign with your name</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <textarea name="about" class="form-control" id="about" style="height: 100px"></textarea>
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="button" class="btn btn-primary" onclick="saveAccount()">Save Changes</button>
                                            </div>
                                        </form><!-- End Profile Edit Form -->

                                    </div>

                                </div><!-- End Bordered Tabs -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main><!-- End #main -->

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
                        console.log(rest);
                        document.getElementById('userName').value = uName;
                        document.getElementById('password').value = pass;
                        document.getElementById('fullName').value = fName;
                        document.getElementById('userName2').innerText = uName;
                        document.getElementById('password2').innerText = pass;
                        document.getElementById('fullName2').innerText = fName;
                        document.getElementById('name_title').innerText = 'Admin : ' + uName;
                        document.getElementById('la').innerText = fName;
                        var me = document.getElementById('mess');
                        me.innerText = rest;
                    }
                });
            }
        </script>

    </body>
</html>
