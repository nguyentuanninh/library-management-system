<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Admin Page</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./style/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

    </head>

    <body class="sb-nav-fixed" style="overflow-x: hidden">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="HomePageAdmin">Library Manager</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                    class="fas fa-bars"></i></button>
            <form method="post" action="SearchBook" class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="hidden" name="action" value="${action}"/>
                    <input name="name" class="form-control" type="text" placeholder="Search book..." aria-label="Search for..."
                           aria-describedby="btnNavbarSearch" />

                    <button class="btn btn-primary" id="btnNavbarSearch" type="submit"><i
                            class="fas fa-search"></i></button> 
                </div>
            </form>
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="ViewUser">View Profile</a></li>
                        <li><a class="dropdown-item" href="Logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="layoutSidenav">

            <!-- Sidebar  -->
            <%@include file="./SidebarUser.jsp" %>

            <div id="layoutSidenav_content"style="background-color: #eee;">
                <main >
                    <div class="container py-5 px-2 px-md-5">
                        <h1 style="text-align: center; margin: 10px 0 10px 0" class="text-primary">Send Feedback</h1>

                        <form method="post" action="Feedback">
                            <div class="form-group">
                                <label for="exampleFormControlInput1"><h3>Title</h3></label>
                                <input name="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Title">
                            </div>

                            <div class="form-group mt-2">
                                <label for="exampleFormControlTextarea1"><h3>Content</h3></label>
                                <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="3" 
                                          placeholder="Do you have nay suggestion to improve our product and service?">
                                </textarea>
                            </div>
                            <div class="col text-center">
                                <button type="submit" class="btn btn-primary mt-3">Send</button>
                            </div>

                        </form>
                    </div>
                </main>

                <!-- Footer -->
                <%@include file="./Footer.jsp"%>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
        <script>
            window.addEventListener('DOMContentLoaded', event => {
                const sidebarToggle = document.body.querySelector('#sidebarToggle');
                if (sidebarToggle) {
                    sidebarToggle.addEventListener('click', event => {
                        event.preventDefault();
                        document.body.classList.toggle('sb-sidenav-toggled');
                        localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
                    });
                }

            });
        </script>

    </body>

</html>
