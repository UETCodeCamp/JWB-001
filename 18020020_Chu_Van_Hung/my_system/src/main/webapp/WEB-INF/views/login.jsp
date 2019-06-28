
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.css"/>

    <meta name="theme-color" content="#EE6E73">
    <title>Login</title>
</head>

<body>
<div class="container">

    <div id="login-page" class="row">
        <h4 class="center header">Đăng nhập</h4>
        <div class="col s12 z-depth-6 card-panel">
            <form method="post" action="login" class="login-form">
                <div class="row">
                </div>
                <%
                if(request.getAttribute("messLogin") != null)
                {
            %>
                <style>.icon_style{
                    position: absolute;
                    right: 10px;
                    top: 10px;
                    font-size: 20px;
                    color: white;
                    cursor:pointer;
                }</style>
                <div class="row" id="alert_box">
                    <div class="col s12 m12">
                        <div class="card red darken-1">
                            <div class="row">
                                <div class="col s12 m10">
                                    <div class="card-content white-text">
                                        <p>${messLogin}</p>
                                    </div>
                                </div>
                                <div class="col s12 m2">
                                    <i class="material-icons icon_style" id="alert_close" aria-hidden="true">close</i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">mail_outline</i>
                        <input class="validate" name="email" type="email" id="email">
                        <label for="email" data-error="wrong" data-success="right">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock_outline</i>
                        <input id="password" type="password" name="password">
                        <label for="password">Mật khẩu</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <button type="submit" class="btn waves-effect waves-light col s12">Đăng nhập</button>
                    </div>
                </div>




            </form>

        </div>
    </div>

</div>
</body>
<script src="js/jquery.min.js"></script>
<script>$('#alert_close').click(function(){
    $( "#alert_box" ).fadeOut( "slow", function() {
    });
});</script>
<script src="js/materialize.js"></script>
</html>