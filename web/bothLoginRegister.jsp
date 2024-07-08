<%-- 
    Document   : bothLoginRegister
    Created on : Apr 11, 2024, 1:29:39 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login and Register Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>     
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" crossorigin="anonymous" />
        <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
        <link href="css/style_login.css" rel="stylesheet">
    </head>
    <body>
        
        <div>
            <div class="">
                <div class="brand-logo">
                    Pizza Store
                </div>
                <div class="brand-phone">
                    <div class="register"><a href="HomeController"><span class="register-title">Back</span></a></div>
                </div>
                <div class="text-center">
                    <nav class="top-bar-wrap">
                        <ul class="top-bar">
                            <li class="nav-item">
                                <a href="HomeController" class="nav-link"><span class="inner-link">Pizzas</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link"><span class="inner-link">Reviews</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link"><span class="inner-link">Contact</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link"><span class="inner-link">Support</span></a>
                            </li>  
                        </ul>
                    </nav>
                    <nav class="main-nav-wrap">
                        <div class="main-nav">
                            <div class="nav-item-scroll" style="width: 1033px">
                                <div id="scrollContent">
                                    <div>Đây là mẫu bài viết về món ăn thông dụng thường thấy trong quá trình hoạt động ở nhà hàng. Việc chia sẻ thêm nhiều món ăn mới sẽ giúp khách hàng cũ thích thú và quay lại, kèm theo đó thu hút thêm khách hàng mới trải nghiệm những món ăn lạ của riêng nhà hàng. </div>
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div> 


        <div class="login-reg-panel">
            <div class="login-info-box">
                <h2>Have an account?</h2>
                <p>Login Now</p>
                <label id="label-register" for="log-reg-show">Login</label>
                <input type="radio" name="active-log-panel" id="log-reg-show"  checked="checked">
            </div>

            <div class="register-info-box">
                <h2>Don't have an account?</h2>
                <p>Regíter Now</p>
                <label id="label-login" for="log-login-show">Register</label>
                <input type="radio" name="active-log-panel" id="log-login-show">
            </div>

            <div class="white-panel">
                <div class="login-show" id="formlogin">
                    <h2>LOGIN</h2>
                    <div class="messs">${requestScope.ERROR}</div>
                    <form action="MainController" method="POST">
                        <div class="form-group">
                            <input type="text" placeholder="AccountID" id="accountID" name="accountID">
                            <div class="messs">${requestScope.ERROR_LOGIN.errorID}</div>
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" id="password" name="password">
                            <div class="messs">${requestScope.ERROR_LOGIN.errorName}</div>
                        </div>
                        <input type="submit" class="btn btn-base" style="padding: 10px 20px; background-color: darkgray" value="Login" name="action">
                    </form>
                    <a href="">Forgot password?</a>
                </div>
                <div class="register-show">
                    <h2>REGISTER</h2>
                    <div id="mess" style="color: greenyellow; font-size: 18px; text-align: center"></div>
                    <form>
                        <div class="form-group">
                            <input type="text" placeholder="AccountID" id="accountID1" name="accountID">
                            <div class="messs">${requestScope.ERROR_LOGIN.errorID}</div>
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="UserName" id="userName" name="userName">
                            <div class="messs">${requestScope.ERROR_LOGIN.errorID}</div>
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="FullName" id="fullName" name="fullName">
                            <div class="messs">${requestScope.ERROR_LOGIN.errorID}</div>
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" id="password1" name="password">
                            <div class="messs">${requestScope.ERROR_LOGIN.errorName}</div>
                        </div>
                        <input type="button" class="btn btn-base" style="padding: 10px 20px" value="Register" onclick="RegisterAccount()" name="action">
                    </form>
                </div>
            </div>
        </div>

    </body>
    <script>

        $(document).ready(function () {
            $('.login-info-box').fadeOut();
            $('.login-show').addClass('show-log-panel');
        });

        $('.login-reg-panel input[type="radio"]').on('change', function () {
            if ($('#log-login-show').is(':checked')) {
                $('.register-info-box').fadeOut();
                $('.login-info-box').fadeIn();

                $('.white-panel').addClass('right-log');
                $('.register-show').addClass('show-log-panel');
                $('.login-show').removeClass('show-log-panel');

            } else if ($('#log-reg-show').is(':checked')) {
                $('.register-info-box').fadeIn();
                $('.login-info-box').fadeOut();

                $('.white-panel').removeClass('right-log');

                $('.login-show').addClass('show-log-panel');
                $('.register-show').removeClass('show-log-panel');
            }
        });
        
        function RegisterAccount() {
            var aID = document.getElementById('accountID1').value;
            var uName = document.getElementById('userName').value;
            var pass = document.getElementById('password1').value;
            var fName = document.getElementById('fullName').value;
            var me = document.getElementById('mess');
            var check = true;        
            if(aID.length < 3) {
                check = false;
                me.innerText = 'AccountID must be [3-200]';
            } if(uName.length < 2) {
                check = false;
                me.innerText = 'UserName must be [2-200]';
            } if(pass.length < 6) {
                check = false;
                me.innerText = 'Password must be [6-200]';
            } if(fName.length < 5) {
                check = false;
                me.innerText = 'FullName must be [5-200]';
            }
            if(check == true) {
                $.ajax({
                url: 'RegisterAccountController',
                type: 'POST',
                data: {
                    accountID: aID,
                    userName: uName,
                    password: pass,
                    fullName: fName,
                },
                success: function (rest) {
                    var me = document.getElementById('mess');
                    me.innerText = rest;
                    document.getElementById('accountID1').value = '';
                    document.getElementById('userName').value = '';
                    document.getElementById('password1').value = '';
                    document.getElementById('fullName').value = '';
                },
            });
            }
        }
    </script>
</html>


