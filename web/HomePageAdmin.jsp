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
        <%@include file="./Navbar.jsp"  %>

        <div id="layoutSidenav">

            <!-- Sidebar  -->
            <%@include file="./SidebarAdmin.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">
                                        Total Book: <span style="font-size: 1.5rem" class="mx-2">${numberBook}</span>
                                    </div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="ListBook">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Total User: <span style="font-size: 1.5rem" class="mx-2">${numberUser}</span></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="ListUser">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">List Book Borrowed: <span style="font-size: 1.5rem">${numberBorrow}</span></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="ListBorrowAdmin?action=borrowed">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">List Book Order: <span style="font-size: 1.5rem" class="mx-2">${numberProcessing}</span></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="ListBorrowAdmin?action=processing">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                        Top User Borrowed
                                    </div>
                                    <div class="card-body">
                                        <table class="table user-list">

                                            <thead>
                                                <tr>
                                                    <th class="text-center"><span>Username</span></th>
                                                    <th class="text-center"><span>Total</span></th>

                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach begin="0" end="${requestScope.listTopUser.size()-1}" var="i" >
                                                    <tr class=" bg-success ${i eq 0?"bg-danger":""} 
                                                            ${i eq 1?"bg-warning":""}
                                                            ${i eq 2?"bg-success":""}">
                                                        <td class="text-center">
                                                            ${listTopUser.get(i).name}
                                                        </td>

                                                        <td class="text-center">
                                                            ${listTopUser.get(i).total}
                                                        </td>

                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table></div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Top borrowed books
                                    </div>
                                    <div class="card-body">
                                        <table class="table user-list">

                                            <thead>
                                                <tr>
                                                    <th class="text-center"><span>Book</span></th>
                                                    <th class="text-center"><span>Total</span></th>

                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach begin="0" end="${requestScope.listTopBook.size()-1}" var="i" >
                                                    <tr class=" bg-success ${i eq 0?"bg-danger":""} 
                                                            ${i eq 1?"bg-warning":""}
                                                            ${i eq 2?"bg-success":""}">
                                                        <td class="text-center">
                                                            ${listTopBook.get(i).name}
                                                        </td>

                                                        <td class="text-center">
                                                            ${listTopBook.get(i).total}
                                                        </td>

                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
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
