<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/cmeta.jspf" %>
        <meta http-equiv="refresh" content="5; URL=login.jsp">
        <title>INVENTARIO-TIC</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <style type="text/css">
            body {
                font-family: "Lato", sans-serif;
            }
                .main-head{
                    height: 150px;
                    background: #FFF;

                }
                .sidenav {
                    height: 100%;
                    background-color: #000;
                    overflow-x: hidden;
                    padding-top: 20px;
                }
                .main {
                    padding: 0px 10px;
                }

            @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
            }

            @media screen and (max-width: 450px) {
                .login-form{
                    margin-top: 5%;
                }
                .register-form{
                    margin-top: 10%;
                }
            }

            @media screen and (min-width: 768px){
                .main{
                    margin-left: 40%; 
                }
                .sidenav{
                    width: 40%;
                    position: fixed;
                    z-index: 1;
                    top: 0;
                    left: 0;
                }
                .login-form{
                    margin-top: 40%;
                }
                .register-form{
                    margin-top: 20%;
                }
            }
            .login-main-text{
                margin-top: 10%;
                padding: 30px;
                color: #fff;
            }
            .login-main-text h1{
                font-weight: 300;
            }
            .btn-black{
                background-color: #000 !important;
                color: #fff;
            }
    </style>
    </head>
    <body> 
        <div class="container">
        <div class="sidenav">
            <div class="login-main-text">
                <h2><b>GESTIÓN DE<br>RECURSOS TI</b></h2>
            </div>
        </div>
        <div class="main">
           <div class="col-md-6 col-sm-12">
                <div class="login-form">
                   <div class="alert alert-dark" role="alert">
                        <h4 class="alert-heading">Ha salido del sistema</h4>
                        <p>Si desea puede volver a ingresar</p>
                        <hr>
                        <p class="mb-0">Si no eres redirigido automáticamente en 5 segundos haga click <a href="login.jsp">aqui</a>  </p>
                    </div> 
                 </div>
           </div>
        </div>
        <%@include file="WEB-INF/jspf/cjs.jspf" %>
        </div>
    </body>
</html>
