
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Admin Page</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./style/styles.css" rel="stylesheet" />
        <link href="./style/userStyle.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

    </head>

    <body class="sb-nav-fixed" style="overflow-x: hidden">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="HomePageAdmin">Library Manager</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                    class="fas fa-bars"></i></button>
            <div class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <a href="CreateUser" type="button" class="btn btn-primary">Create Account</a>
            </div>
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="Logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="layoutSidenav">

            <!-- Sidebar  -->
            <%@include file="./SidebarAdmin.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="main-box clearfix ">
                                <div class="table-responsive">
                                    <table class="table user-list">

                                        <thead>
                                            <tr>
                                                <th><span>Username</span></th>
                                                <th><span>User</span></th>
                                                <th><span>Sex</span></th>

                                                <th><span>Date birth</span></th>
                                                <th class="text-center"><span>Phone</span></th>
                                                <th><span>Email</span></th>
                                                <th>&nbsp;</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.listUser}" var="i">
                                                <tr>
                                                    <td>${i.username}</td>
                                                    <td>
                                                        <img src="${i.avt}" alt="${i.name}">
                                                        <p>${i.name}<p>
                                                    </td>
                                                    <c:if test="${i.sex}">
                                                        <td>Male</td>
                                                    </c:if>
                                                    <c:if test="${!i.sex}">
                                                        <td>Female</td>
                                                    </c:if>
                                                    <td>
                                                        ${i.datebirth}
                                                    </td>
                                                    <td class="text-center">
                                                        ${i.phone}
                                                    </td>
                                                    <td>
                                                        ${i.gmail}
                                                    </td>
                                                    <td style="width: 20%;">
                                                        <a href="ResetPassword?id=${i.username}" class="table-link" style="text-decoration: none;" title="Reset Password">
                                                            <span class="fa-stack">
                                                                <i class="fa-solid fa-key"></i>                                                
                                                            </span>
                                                        </a>
                                                        <a href="ViewUser?id=${i.username}" class="table-link" style="text-decoration: none;" title="View Profile">
                                                            <span class="fa-stack">
                                                                <i class="fa-solid fa-eye"></i>
                                                            </span>
                                                        </a>
                                                        <a href="DeleteUser?id=${i.username}" class="table-link danger" style="text-decoration: none;" 
                                                           title="Detele Account" onclick="return confirm('Are you sure Detele Account: ${i.username}?');">
                                                            <span class="fa-stack">
                                                                <i class="fa-solid fa-trash"></i>  </span>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
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
