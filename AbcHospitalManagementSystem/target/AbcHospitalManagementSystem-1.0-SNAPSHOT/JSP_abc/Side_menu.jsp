<%-- 
    Document   : Side_menu
    Created on : Oct 24, 2021, 7:59:06 PM
    Author     : User
--%>





        <!-- Sidebar -->
        <ul class="navbar-nav bg-info sidebar sidebar-dark accordion " id="accordionSidebar" >

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="">
                <div class="sidebar-brand-icon ">
                    <img class="img-fluid " 
                                    src=" img/abc.png">
                </div>
                
                <div class="sidebar-brand-text mx-1">Admin<sup></sup></div>
            </a>
            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="stat.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>
            

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                More
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Manage User & Doctor Details</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Manage Hospital Users</h6>
                        <a class="collapse-item" href="User_Details.jsp">Manage Users</a>
                        
                    </div>
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Manage Doctors</h6>
                        <a class="collapse-item" href="doctor_Details.jsp">Manage Doctors</a>
                        
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-address-book"></i>
                    <span>Patient Management</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Manage Details:</h6>
                        <a class="collapse-item" href="Patient_Details.jsp">Manage Patients</a>
                        <a class="collapse-item" href="Admit_Details.jsp">Manage Patient Admits</a>
                        <a class="collapse-item" href="Discharge_Details.jsp">Manage Patient Discharge</a>
                        <a class="collapse-item" href="Transfer_Details.jsp">Manage Branch Transfers</a>
                    </div>
                </div>
            </li>
             <li class="nav-item active">
                <a class="nav-link" href="Ward_Details.jsp">
                    <i class="fas fa-fw fa-bed"></i>
                    <span>Manage Wards</span></a>
            </li>
             <li class="nav-item active">
                <a class="nav-link" href="Appointment_Details.jsp">
                    <i class="fas fa-fw fa-book-medical"></i>
                    <span>Manage Appointments</span></a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading ">
                Billing & Medical Stock
            </div>

           

            <!-- Nav Item - Charts -->
            <li class="nav-item active">
                <a class="nav-link" href="Bill_Details.jsp">
                    <i class="fas fa-fw fa-money-bill"></i>
                    <span>Manage Billing</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item active">
                <a class="nav-link" href="Medicine_Details.jsp">
                    <i class="fas fa-fw fa-medkit"></i>
                    <span>Manage Medicines</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            

        </ul>
        <!-- End of Sidebar -->
        

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
                    <a class="btn btn-primary" href="handle-logout.jsp">Logout</a>               </div>
            </div>
        </div>
    </div>

    

    