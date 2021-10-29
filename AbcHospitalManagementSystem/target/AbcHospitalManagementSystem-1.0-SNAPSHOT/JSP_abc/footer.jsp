<%-- 
    Document   : footer
    Created on : Oct 26, 2021, 3:47:25 PM
    Author     : User
--%>

 <%@page import="java.time.LocalDate"%>
<!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy;  ABC Hospital <% 
                               LocalDate currentdate = LocalDate.now();
                               int currentYear= currentdate.getYear();
                               out.print(currentYear);
                            %></span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
<!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="handle-logout.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>