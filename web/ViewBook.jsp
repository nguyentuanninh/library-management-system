<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <section>
                        <div class="container py-5">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="card mb-4">
                                        <div class="card-body text-center">
                                            <img src="${book.img}"
                                                 alt="avatar" style="width: 90%; height: auto; object-fit: cover;">
                                            <h5 class="my-3">${book.bookid}</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-8 ">
                                    <form action="UpdateBook" method="get" class="card mb-4">
                                        <input type="hidden" name="bookid" value="${book.bookid}"/>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Book Name</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input style="width:70%" type="text" name="name" value="${book.name}" required/>

                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Author</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input  name="author" type="text" value="${book.author}" required/>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">category</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <select name="category" required>
                                                        <c:forEach items="${category}" var="i">
                                                            <c:if test="${i.category_id== book.category}" >
                                                                <option selected="" value="${i.category_id}">${i.category_name}</option>
                                                            </c:if>
                                                            <c:if test="${i.category_id!= book.category}" >
                                                                <option value="${i.category_id}">${i.category_name}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Publisher</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input  name="publisher" type="text" value="${book.publisher}"required />

                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Language</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input  name="language" type="text" value="${book.language}"required />

                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Total quantity</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input  name="total" type="number" value="${book.total}"required />

                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Current quantity</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input  name="current" type="number" value="${book.current}"required />

                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Position</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input  name="position" type="text" value="${book.position}" required/>

                                                </div>
                                            </div>
                                            <!--                                                    <hr>
                                                                                        <div class="row">
                                                                                            <div class="col-sm-3">
                                                                                                <p class="mb-0">Change Image Profile</p>
                                                                                            </div>
                                                                                            <div class="col-sm-9">
                                                                                                <input  name="avt" type="file" value="${user.avt}"/>
                                            
                                                                                            </div>
                                                                                        </div>-->
                                            <input  name="avt" type="hidden" value="${book.img}"/>
                                        </div>
                                        <input style="width: 20%" href="UpdateUser?id=${user.username}" type="submit" class="btn btn-primary" value="Update Book"></input>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </section>
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
