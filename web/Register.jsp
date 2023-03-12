<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Register</title>
        <link href="./style/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form action="Register" method="POST">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input value="${user.name}" class="form-control" id="inputFirstName" type="text" placeholder="Enter your Name" name="name" required/>
                                                        <label for="inputFirstName">Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    Gender <br/>
                                                    <c:if test="${user.sex}">
                                                        <input class="form-check-input" type="radio" name="sex" value="true" id="flexRadioDefault1" checked/>
                                                        <label class="form-check-label" for="flexRadioDefault1">
                                                            Male
                                                        </label>
                                                        <input class="form-check-input" type="radio" name="sex" value="false" id="flexRadioDefault2" />
                                                        <label class="form-check-label" for="flexRadioDefault2">
                                                            Female
                                                        </label>
                                                    </c:if>
                                                    <c:if test="${!user.sex}">
                                                        <input class="form-check-input" type="radio" name="sex" value="true" id="flexRadioDefault1" />
                                                        <label class="form-check-label" for="flexRadioDefault1">
                                                            Male
                                                        </label>
                                                        <input class="form-check-input" type="radio" name="sex" value="false" id="flexRadioDefault2"checked />
                                                        <label class="form-check-label" for="flexRadioDefault2">
                                                            Female
                                                        </label>
                                                    </c:if>


                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input value="${user.phone}" class="form-control" id="inputPassword" name="phone" type="text" placeholder="Create a password" />
                                                        <label for="inputPassword">Phone</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input value="${user.gmail}" class="form-control" id="inputPasswordConfirm" name="gmail" type="email" placeholder="Confirm password" />
                                                        <label for="inputPasswordConfirm">Email</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input value="${user.username}" class="form-control" id="inputEmail" type="text" name="username" placeholder="name@example.com" required/>
                                                        <label for="inputEmail">Username</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input value="${user.datebirth}" class="form-control" id="inputPasswordConfirm" name="datebirth" type="date" placeholder="datebirth" />
                                                        <label for="inputPasswordConfirm">Date Birth</label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPassword" name="password" type="password" placeholder="Create a password" required/>
                                                        <label for="inputPassword">Password</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPasswordConfirm" name="passwordConfirm" type="password" placeholder="Confirm password"required />
                                                        <label for="inputPasswordConfirm">Confirm Password</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <h5 style="color: red">${message}</h5>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid">
                                                    <input class="btn btn-primary" type="submit" value="Create Account"/></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="Login">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
