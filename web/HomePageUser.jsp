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
                    <div class="container py-5">
                        <c:forEach items="${requestScope.listBook}" var="i">
                            <div class="row justify-content-center mb-3">
                                <div class="col-md-12 col-xl-10">
                                    <div class="card shadow-0 border rounded-3">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                                    <!-- img -->
                                                    <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                                        <img src="${i.img}"
                                                             class="w-75" />
                                                        <a href="#!">
                                                            <div class="hover-overlay">
                                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 col-lg-8 col-xl-8">
                                                    <h5 class="text-primary">${i.name}</h5>
                                                    <div class="d-flex flex-column flex-md-row">
                                                        <div class="col-md-6 col-lg-6 ">
                                                            <div class="d-flex flex-row">
                                                                <span>
                                                                    <span style="font-weight: bold">Author:</span> 
                                                                    ${i.author}
                                                                </span> 
                                                            </div>
                                                            <div class="d-flex flex-row">
                                                                <span>
                                                                    <span style="font-weight: bold">Category:</span>  
                                                                    ${mapCategory.get(i.category).category_name}
                                                                </span> 
                                                            </div>
                                                            <div class="d-flex flex-row">
                                                                <span class="${i.current eq 0?"text-danger":""}"  >
                                                                    <span style="font-weight: bold">Current: </span>  
                                                                    ${i.current}
                                                                </span> 
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 col-lg-6 "><div class="d-flex flex-row">
                                                                <span>
                                                                    <span style="font-weight: bold">Language: </span>  
                                                                    ${i.language}
                                                                </span> 
                                                            </div>
                                                            <div class="d-flex flex-row">
                                                                <span>
                                                                    <span style="font-weight: bold">Position </span>  
                                                                    ${i.position}
                                                                </span> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <form action="ActionBorrow" method="get">
                                                        <input type="hidden" name="id" value="${i.bookid}" />
                                                         <input type="hidden" name="url" value="${pageContext.request.contextPath}" />
                                                        <button type="submit" class="btn btn-primary btn-sm mt-2 " ${i.current> 0? "" : "disabled"}>
                                                            Borrow
                                                        </button>
                                                    </form>           
                                                                
<!--                                                    <a href="ActionBorrow?id=${i.bookid}&url=${pageContext.request.contextPath}">
                                                        <button class="btn btn-primary btn-sm mt-2 " ${i.current> 0? "" : "disabled"}>
                                                            Borrow
                                                        </button>
                                                    </a>-->
                                                </div>     
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <c:if test="${numberOfPage >1}">
                            <nav class="me-3">
                                <ul class="pagination pagination-sm justify-content-end">
                                    <c:forEach begin="1" end="${numberOfPage}" var="i">
                                        <c:if test="${i== page}">
                                            <li class="page-item active" aria-current="page">
                                                <a class="page-link" href="HomePageUser?view=${view}&page=${i}">${i}</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${i!= page}">
                                            <li class="page-item"><a class="page-link" href="HomePageUser?view=${view}&page=${i}">${i}</a></li>
                                            </c:if>

                                    </c:forEach>
                                </ul>
                            </nav>
                        </c:if>
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
