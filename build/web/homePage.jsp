<%-- 
    Document   : homePage
    Created on : Apr 10, 2024, 4:33:12 PM
    Author     : ADMIN
--%>

<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%! public String getString() {
        return "Hello";
}
%>
    <head>
        <title>Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>     
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" crossorigin="anonymous" />
        <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
        <link href="css/style.css" rel="stylesheet">
         
    </head>
    <body>

        <div class="app" style="z-index: 3">
            <div class="header">
                <div role="navigation">
                    <div class="">
                        <div class="brand-logo">
                            Pizza Store
                        </div>
                        <div class="brand-phone" style="width: 335px">
                            <c:if test="${sessionScope.LOGIN_USER != null}">
                                <div class="register-title" id="title_name" style="font-size: 17px; margin-top: -35px">Hello : ${sessionScope.LOGIN_USER.userName}</div>
                                <div style="font-size: 25px; margin-top: -17px; display: flex; align-items: center; justify-content: space-between">
                                    <div style="position: relative;"><a href="#">
                                            <a onclick="showCart()"><i class="register-title fa-solid fa-cart-shopping"></i></a>
                                        </a>
                                        <span id="quantity" style="position: absolute; top: 32px; right: -11px; color: black; font-size: 12px; border-radius: 50%; background: white; padding: 4px 8px; border: 1px solid greenyellow">
                                            <c:if test="${sessionScope.QUANTITY == null}">0</c:if>
                                            <c:if test="${sessionScope.QUANTITY == 0}">0</c:if>
                                            <c:if test="${sessionScope.QUANTITY != 0}">${sessionScope.QUANTITY}</c:if>
                                            </span>
                                        </div>

                                        <div class="register-title" style="margin-top: 25px"><a href="MainController?action=Logout">Logout</a></div>
                                    </div>
                            </c:if>
                            <c:if test="${sessionScope.LOGIN_USER == null}">
                                <div class="register"><a href="MainController?action=RegisterView"><span style="font-size: 20px;" class="register-title">Register or Login</span></a></div>
                                <div class="login"><span class="login-title">Phone : 0334386995</span></div>
                            </c:if>
                        </div>
                        <div class="text-center">
                            <nav class="top-bar-wrap">
                                <ul class="top-bar">
                                    <li class="nav-item">
                                        <a href="HomeController" class="nav-link"><span class="inner-link">Pizzas</span></a>
                                    </li>
                                    <li class="nav-item dropdown hasSubMenu">
                                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            <span class="inner-link">Categories</span>
                                        </a>
                                        <ul class="customSubMenu">
                                            <c:if test="${requestScope.LIST_CATEGORY != null}">
                                                <c:if test="${not empty requestScope.LIST_CATEGORY}">
                                                    <c:forEach var="category" varStatus="counter" items="${requestScope.LIST_CATEGORY}">
                                                        <li style="border: 2px solid greenyellow;" onclick="changeCategory(this)" class="dropdown-item subLink"><a><span class="sub-menu-title" style="position: absolute; top: -35px; left: -32px;">${category.categoryName}</span></a></li>
                                                                </c:forEach>
                                                            </c:if>
                                                        </c:if>
                                        </ul>      
                                    </li>
                                    <li class="nav-item">
                                        <a onclick="showEditPage()" class="nav-link"><span class="inner-link">Profile</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a onclick="showHistory()" class="nav-link"><span class="inner-link">History</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link"><span class="inner-link">Support</span></a>
                                    </li>  
                                </ul>
                            </nav>
                            <nav class="main-nav-wrap">
                                <div class="main-nav">
                                    <div class="nav-item-scroll">
                                        <div id="scrollContent">
                                            <div>Đây là mẫu bài viết về món ăn thông dụng thường thấy trong quá trình hoạt động ở nhà hàng. Việc chia sẻ thêm nhiều món ăn mới sẽ giúp khách hàng cũ thích thú và quay lại, kèm theo đó thu hút thêm khách hàng mới trải nghiệm những món ăn lạ của riêng nhà hàng. </div>
                                        </div>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div> 
            </div>
            
            <div style="font-size: 20px; text-align: center; color: red">${requestScope.ERROR}</div>
            
            <div class="body" id="body">
                <form action="MainController">
                    <div class="row">
                        <div class="col-lg-12 card-margin">
                            <div class="card search-form">
                                <div class="card-body p-0">
                                    <form id="search-form">
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="row no-gutters">
                                                    <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                                        <select name="type" class="sel" id="sel">
                                                            <option value="search_name">Product Name</option>
                                                            <option value="search_id">Product ID</option>
                                                            <option value="search_price">Price</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                                        <input type="text" placeholder="Search..." class="form-control" id="search" name="search" value="${param.search}" oninput="searchByName(this)">
                                                    </div>
                                                    <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                                        <button type="button" class="btn btn-base" name="action" value="Search" id="dangki">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <section style="background-color: #eee;">               
                    <div class="container py-5">
                        <div class="row" id="contentSearch">
                            <c:if test="${requestScope.ALL_PRODUCT ==null}">
                                <h3 style="margin-bottom: 50px">${requestScope.ERROR}</h3>
                            </c:if>
                            <c:if test="${requestScope.ALL_PRODUCT !=null}">
                                <c:if test="${requestScope.MESSAGE != null}">
                                    <h3 style="margin-bottom: 50px">${requestScope.MESSAGE}</h3>
                                </c:if>
                                <c:if test="${not empty requestScope.ALL_PRODUCT}">
                                    <c:forEach var="product" items="${requestScope.ALL_PRODUCT}">      
                                        <div class="col-md-8 col-lg-6 col-xl-4">
                                            <div class="card" style="border-radius: 15px;">
                                                <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light"
                                                     data-mdb-ripple-color="light">
                                                    <img src="image/${product.productImg}"
                                                         style="border-top-left-radius: 15px; border-top-right-radius: 15px; object-fit: cover; height: 300px" class="img-fluid"
                                                         alt="Pizza" />
                                                    <a href="#!">
                                                        <div class="mask"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body pb-0">
                                                    <div class="d-flex justify-content-between">
                                                        <div>
                                                            <p><a href="#!" class="text-dark">${product.getProductName()}</a></p>
                                                            <p class="small text-muted">Pizza</p>
                                                        </div>
                                                        <div>
                                                            <div class="d-flex flex-row justify-content-end mt-1 mb-4 text-danger">
                                                                <i class="fas fa-star"></i>
                                                                <i class="fas fa-star"></i>
                                                                <i class="fas fa-star"></i>
                                                                <i class="fas fa-star"></i>
                                                            </div>
                                                            <p class="small text-muted">Rated 4.0/5</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr class="my-0" />
                                                <div class="card-body pb-0">
                                                    <div class="d-flex justify-content-between">
                                                        <p><a href="#!" class="text-dark">${product.unitPrice} VND</a></p>
                                                        <p class="text-dark">#### ${product.productID}</p>
                                                    </div>
                                                </div>
                                                <hr class="my-0" />
                                                <div class="card-body">
                                                    <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
                                                        <a href="#!" class="text-dark fw-bold">Details</a>
                                                        <button type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary" id="${product.productID}" value="${product.productID}" onclick="buyProduct(this)">Buy now</button>
                                                    </div>
                                                    <div  style="color: greenyellow; font-size: 18px; text-align: center;"></div> 
                                                </div>
                                            </div>         
                                        </div>            
                                    </c:forEach>
                                </c:if>
                            </c:if> 
                        </div>
                    </div>
                </section>                    
            </div>
        </div>    
                                                  
    </body>   




    <script type="text/javascript">

    //                $(document).ready(function() {
    //                var text = param.textContent; // get text cua button
    //                        $('#dangki').oninput(function() {
    //                                $.ajax({
    //                                        url : 'HomeController',
    //                                        data : {
    //                                                search1 : $('#search').val()
    //                                        },
    //                                        success : function(rest) {
    //                                            var conten = document.getElementById('content');
    //                                            conten.innerHTML = rest;
    //                                        }
    //                                });
    //                        });
    //                });

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
                    
                    document.getElementById('userName').value = uName;
                    document.getElementById('password').value = pass;
                    document.getElementById('fullName').value = fName;
                    document.getElementById('userName2').innerText = uName;
                    document.getElementById('password2').innerText = pass;
                    document.getElementById('fullName2').innerText = fName;
                    document.getElementById('la').innerText = fName;
                    document.getElementById('title_name').innerText = 'Hello : ' + uName;
                }
            });
        }
        
        function showEditPage() {
            $.ajax({
                url: 'EditUserController',
                type: 'GET',
                success: function (rest) {
                    console.log(rest)
                    if (rest.includes('.jsp')) {
                        window.location = rest;
                    } else {    
                        var conten = document.getElementById('body');
                        conten.innerHTML = rest;
                    }
                }
            });
        }


        function searchByName(param) {
            var txtSearch = param.value;
            var type = document.getElementById('sel').value;
            $.ajax({
                url: 'SearchController',
                type: 'GET',
                data: {
                    search1: txtSearch,
                    type1: type
                },
                success: function (rest) {
                    var conten = document.getElementById('contentSearch');
                    conten.innerHTML = rest;
                }
            });
        }
        ;
        function changeCategory(param) {
            var text = param.textContent; // get text cua button
            $.ajax({
                url: 'SearchController',
                type: 'GET',
                data: {
                    search1: text
                },
                success: function (rest) {
                    var conten = document.getElementById('contentSearch');
                    console.log(conten);
                    console.log(rest);
                    conten.innerHTML = rest;
                }
            });
        }
        ;
        function buyProduct(para) {
            var s = para.value;
            $.ajax({
                url: 'AddCartController',
                type: 'GET',
                data: {
                    productID: para.value
                },
                success: function (rest) {
                    if (para.value == s) {
                        var str = JSON.stringify(rest);

                        if (str.includes('jsp')) {
                            window.location = rest;
                        } else {
                            var quantity = document.getElementById("quantity").innerText;
                            if (quantity == null) {
                                quantity = '';
                            }
                            var quanti = new Number(quantity);
                            var quant = quanti + 1;
                            var conten = document.getElementById(para.value);
                            conten.innerText = rest;
                            conten.style.background = "grey";
                            var quan = document.getElementById("quantity");
                            quan.innerText = quant;
                        }
                    }
                }
            });
        }
        ;
        function showCart() {
            $.ajax({
                url: 'ViewCartController',
                type: 'GET',
                success: function (rest) {
                    var conten = document.getElementById('body');
                    conten.innerHTML = rest;

                }
            });
        }
        
        

        function showHistory() {
            $.ajax({
                url: 'HistoryController',
                type: 'GET',
                success: function (rest) {
                    console.log(rest);
                    console.log(typeof rest);
                    
                        var conten = document.getElementById('body');
                        conten.innerHTML = rest;
                    
                }
            });
        }


        function deleteProduct(param) {

            var text = param.value;
            console.log(text);
            $.ajax({
                url: 'DeleteCartController',
                type: 'GET',
                data: {
                    productID: text
                },
                success: function (rest) {
                    var conten = document.getElementById('body');
                    conten.innerHTML = rest;
                    var quantity = document.getElementById("quantityWhenRemove").value;
                    var quant = new Number(quantity);

                    var quan = document.getElementById("quantity");
                    quan.innerText = quant;
                }
            });
        }


        function updateCart(param) {
            var text = param.value;
            var getID = "quantity_cart_" + text;
            var clas = document.getElementById(getID).value;
            $.ajax({
                url: 'UpdateCartController',
                type: 'GET',
                data: {
                    productID: text,
                    quantity: clas
                },
                success: function (rest) {
                    var str = JSON.stringify(rest);

                    if (str.includes('jsp')) {
                        window.location = rest;
                    } else {

                        var conten = document.getElementById('body');
                        conten.innerHTML = rest;
                    }
                }
            });
        }

        function checkout(param) {
            var accID = param.value;
            var dat = document.getElementById("date").innerText;
            var add = document.getElementById("address").value;
            console.log(accID);
            console.log(dat);
            console.log(add);
            $.ajax({
                url: 'CheckoutController',
                type: 'GET',
                data: {
                    accountID: accID,
                    date: dat,
                    address: add
                },
                success: function (rest) {
                    var str = JSON.stringify(rest);

                    if (str.includes('jsp')) {
                        window.location = rest;
                    } else {

                        var conten = document.getElementById('body');
                        conten.innerHTML = rest;
                    }
                }
            });
        }

    </script>

</html>
