<div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Core</div>
                        
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fa-solid fa-book"></i></div>
                            View Book
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse show" id="collapseLayouts" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="HomePageUser?view=0">All Book</a>
                                <c:forEach items="${listca}" var="i">
                                    <a class="nav-link" href="HomePageUser?view=${i.category_id}">${i.category_name}</a>
                                </c:forEach>
                            </nav>
                        </div>
                        

                        <div class="sb-sidenav-menu-heading">Action</div>
                        
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapseLayoutss" aria-expanded="false" aria-controls="collapseLayoutss">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            List Borrowed
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse show" id="collapseLayoutss" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="ListBorrowUser?action=processing">Processing</a>
                                <a class="nav-link" href="ListBorrowUser?action=borrowed">Borrow</a>
                                <a class="nav-link" href="ListBorrowUser?action=returned">Returned</a>
                            </nav>
                        </div>
                        <a class="nav-link" href="Feedback">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            Send Feedback
                        </a>
                       
                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</div>
                    ${sessionScope.username}
                </div>
            </nav>
</div>
