<%-- 
    Document   : adminPage
    Created on : Apr 15, 2024, 12:42:02 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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

                            <span class="d-md-block ps-2" style="font-size: 20px;">Admin : ${sessionScope.LOGIN_USER.userName}</span>
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
                <h1>Dashboard</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">

                    <!-- Left side columns -->
                    <div class="col-lg-8">
                        <div class="row">

                            <!-- Sales Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card sales-card">    
                                    <div class="card-body">
                                        <h5 class="card-title">Sales <span>| Today</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-cart"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>${sessionScope.TOTAL_QUANTITY} Products</h6>
                                                
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Sales Card -->

                            <!-- Revenue Card -->

                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card revenue-card">

                                    <div class="card-body">
                                        <h5 class="card-title">Revenue <span>| This Month</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-currency-dollar"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>${sessionScope.TOTAL_PRICE} VND</h6>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Revenue Card -->

                            <!-- Recent Sales -->
                            <div class="col-12">
                                <div class="card recent-sales overflow-auto">
                                    <div class="card-body">
                                        <h5 class="card-title">Recent Sales</h5>

                                        <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns"><div class="datatable-top">
                                                <div style="display: flex; justify-content: space-around; margin: 20px">
                                                    <div class="datatable-search">
                                                        <label>Start Date</label>
                                                        <input class="datatable-input" type="date" id="startDate" name="startDate">
                                                    </div>
                                                    <div class="datatable-search">
                                                        <label>End Date</label>
                                                        <input class="datatable-input" type="date" id="endDate" name="endDate">
                                                    </div>
                                                    <div>
                                                        <button class="btn btn-primary" onclick="report()">Search</button>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="datatable-container">
                                                <table class="table table-borderless datatable datatable-table">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col" data-sortable="true" style="width: 10.740203193033382%;">
                                                                <button class="datatable-sorter">OrderID</button></th>
                                                            <th scope="col" data-sortable="true" style="width: 23.367198838896954%;">
                                                                <button class="datatable-sorter">AccountID</button></th>
                                                            <th scope="col" data-sortable="true" style="width: 39.33236574746009%;">
                                                                <button class="datatable-sorter">OrderDate</button></th>
                                                            <th scope="col" data-sortable="true" style="width: 11.756168359941945%;">
                                                                <button class="datatable-sorter">Status</button></th>
                                                            <th scope="col" data-sortable="true" class="red" style="width: 14.804063860667634%;">
                                                                <button class="datatable-sorter">ShipAddress</button></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="applyIn">
                                                        
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Recent Sales -->

                        </div>
                    </div><!-- End Left side columns -->

                    <!-- Right side columns -->
                    <div class="col-lg-4">

                    </div><!-- End Right side columns -->

                </div>
            </section>

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="copyright">
                Pizza Store <strong><span>Admin</span></strong>. All Rights Reserved
            </div>
            Designed by <a href="https://bootstrapmade.com/">HSH</a>
        </div>
    </footer><!-- End Footer -->

    
    <div class="" id="test_apply">Hello world</div>
</body>

    <script>
        function report() {
            var start = document.getElementById('startDate').value;
            var end = document.getElementById('endDate').value;

            console.log(start);
            console.log(end);
  
            $.ajax({
                url: 'ReportController',
                type: 'GET',
                data: {
                    startDate: start,
                    endDate: end,         
                },
                success: function (rest) {
                    var me = document.getElementById('applyIn');
                    me.innerHTML = rest;
                   
                }
            });
        }
        
        
        
    </script>

</html>
