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

            <div id="layoutSidenav_content">
                <main>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="main-box clearfix ">
                                <div class="table-responsive">
                                    <h1 style="text-align: center; margin: 10px 0 10px 0" class="text-primary">List Book In Process</h1>

                                    <table class="table user-list">

                                        <thead>
                                            <tr>
                                                <th class="text-center"><span>ID</span></th>
                                                <th class="text-center"><span>Book</span></th>
                                                <th class="text-center"><span>Status</span></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.list}" var="i">
                                                <tr>
                                                    <td class="text-center">${i.id}</td>

                                                    <td  style="width: 30%; font-weight: 500">
                                                        ${mapBook.get(i.bookid).name}
                                                    </td>

                                                    <td class="text-center">
                                                        <span class="text-success">${i.status}</span>
                                                    </td>


                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <c:if test="${numberOfPage >1}">
                                <nav class="me-3 ">
                                    <ul class="pagination pagination-sm justify-content-end">
                                        <c:forEach begin="1" end="${numberOfPage}" var="i">
                                            <c:if test="${i== page}">
                                                <li class="page-item active" aria-current="page">
                                                    <a class="page-link" href="ListBorrowAdmin?action=borrowed&page=${i}">${i}</a>
                                                </li>
                                            </c:if>
                                            <c:if test="${i!= page}">
                                                <li class="page-item"><a class="page-link" href="ListBorrowAdmin?action=borrowed&page=${i}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav>
                            </c:if>

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
