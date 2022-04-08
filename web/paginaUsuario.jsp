<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true"%>
<%
    HttpSession sesionOK = request.getSession();
    if(sesionOK.getAttribute("usuario")!=null){
%>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>SISTEMA DE GESTIÓN</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="RESOURCES/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <!-- BARRA SUPERIOR -->
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3">BIENVENIDO</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"><font color="white">Area: ${area}</font>
                <div class="input-group">
                    <font color="white">Usuario: ${usuario}</font>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="ajustesUsuario.jsp">Cambiar clave</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/USUARIOcontroller.do?txtProceso=logout">Salir</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- FIN DE BARRA SUPERIOR -->
        <div id="layoutSidenav">
            <!-- BARRA LATERAL -->
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">OPCIONES</div>
                            <form action="ANUNCIOcontroller.do" method="post">
                                <a class="nav-link" href="paginaUsuario.jsp">
                                    <div class="sb-nav-link-icon"><i class="fas fa-exclamation-triangle"></i></div>
                                    <input type="hidden" class="form-control" placeholder="anuncio" name="txtAnuncio1" value="">
                                    <button class="btn btn-dark btn-sm" type="submit" name="accionAnuncio" value="jalarAnuncio">Comunicados</button>
                                </a>
                            </form>
                            <div class="sb-sidenav-menu-heading">RECURSOS TI</div>
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    <div class="sb-nav-link-icon"><i class="fas fa-tasks"></i></div>
                                    Gestión
                                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="recursosTI.jsp">
                                        <i class="fas fa-desktop"></i>&nbsp;Recursos TI
                                    </a>
                                    <a class="nav-link" href="incidencias.jsp">
                                        <i class="fas fa-exclamation-circle"></i>&nbsp;Incidencias
                                    </a>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Administración</div>
                 <!--           <a class="nav-link" href="reportes.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-clipboard"></i></i></div>
                                Reportes
                            </a>    -->
                            <form action="USUARIOcontroller2.do" method="post">
                                <a class="nav-link" href="usuarios.jsp">
                                    <div class="sb-nav-link-icon"><i class="fas fa-users-cog"></i></div>
                                    <input type="hidden" class="form-control" name="txtBuscarUsuario" value="">
                                    <button class="btn btn-dark btn-sm" type="submit" name="txtProceso" value="buscarUsuario">Usuarios</button>
                                </a>
                            </form>
                            <a class="nav-link" href="anuncios.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-bullhorn"></i></div>
                                Crear anuncio
                            </a>
                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="medium">LOGUEADO COMO:</div>
                        <ul>
                            <li>Usuario ${perfil}</li>
                            <li>${nombres}<br>${apellidos}</li>
                            <li>${correo}</li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- FIN BARRA LATERAL -->            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">COMUNICADOS</h1> 
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="alert alert-success" role="alert">
                                    <c:forEach var="noticia" items="${anuncio1}">
                                        <h4 class="alert-heading">${noticia.getTitulo()}</h4>
                                        <p>${noticia.getNoticia()}</p>
                                        <hr>
                                        <p class="mb-0">${noticia.getFecha()}</p>
                                    </c:forEach>
                                </div>
                            </div>
             <!--               <div class="col-sm-4">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                            Area Chart Example
                                    </div>
                                <div class="card-body"><canvas id="myAreaChart" width="100%" height="30"></canvas></div>
                                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                 </div>
                            </div>
                        </div>    
                    <div class="row">
                            <div class="col-sm-8">
                                <div class="alert alert-success" role="alert">
                                    <h4 class="alert-heading">Titulo de Comunicado 2</h4>
                                    <p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p>
                                    <hr>
                                    <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="card sm-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Bar Chart Example
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>
                        </div> -->
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="RESOURCES/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="RESOURCES/assets/demo/chart-area-demo.js"></script>
        <script src="RESOURCES/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="RESOURCES/js/datatables-simple-demo.js"></script>
    </body>
</html>
  
<%}else{%>
<html>
    <head>
        <link href="RESOURCES/css/error401.css" rel="stylesheet" type="text/css"/>
        <title>
            UNAUTHORIZED
        </title>
    </head>
    <body>
        <div class="noise"></div>
        <div class="overlay"></div>
        <div class="terminal">
            <h1>Error <span class="errorcode">401</span></h1>
            <p class="output">El servidor no pudo verificar que estás autorizado para acceder al sitio solicitado.
                              Puede que hayas escrito la dirección url en el navegador sin haberte identificado.
            </p>
            <p class="output">Puedes iniciar sesión <a href="login.jsp">aqui</a> o <a href="index.jsp">volver</a>.</p>
            <p class="output">Buena suerte.</p>
        </div> 
    </body>
</html> 
<%}%>