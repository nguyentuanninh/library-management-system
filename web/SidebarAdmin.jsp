<div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Core</div>
                        <a class="nav-link" href="HomePageAdmin">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Dashboard
                        </a>

                        <div class="sb-sidenav-menu-heading">Action</div>
                        <a class="nav-link" href="ListBorrow">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            List Borrow
                        </a>
                        <a class="nav-link" href="ListBook">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            List Book
                        </a>
                        <a class="nav-link" href="ListUser">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            List User
                        </a>
                        <a class="nav-link" href="Feedback">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            Feedback
                        </a>
                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</div>
                    ${sessionScope.username}
                </div>
            </nav>
</div>
