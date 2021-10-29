<%-- 
    Document   : admit_Details
    Created on : Oct 20, 2021, 5:11:32 PM
    Author     : User
--%>



<%@page import="java.time.Year"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
     
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admit Details</title>
        
   <script src="js/jquery-3.6.0.js" integrity="" crossorigin="anonymous"></script>
    <!-- Custom fonts for this System -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet"> -->

    <!-- Custom styles for this System -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for interaction of Datatables this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    <!-- Js for JQuery -->
    <script src="js/jquery-3.6.0.js" integrity="" crossorigin="anonymous"></script>
   
    <!-- Js for Validation -->
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>

    <!-- Latest Js for sweet Alerts and minified JavaScript -->
    <script src="js/sweetalert/docs/assets/sweetalert/sweetalert.min.js"></script> 
    
    <!-- Rest api calling using  Ajax <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> -->
    <script src="Js_rest_calling/admit.js"></script>
    
    </head>
  
    <body id="page-top" class="sidebar-toggled">
         <!-- Topbar -->
   <%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
        
      response.sendRedirect("login.jsp");} else { 

%>             
    <!-- Page Wrapper -->
    <div id="wrapper">
        <jsp:include page="Side_menu.jsp" />
<!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
    
                <jsp:include page="header.jsp" />
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Manage Admitted Patients</h1>
                    
                    
                    
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"  onclick="clearTextBox();"><i class="fas fa-plus" ></i> Admit New Patient</button><br /><br /> 
                   
  

<!-- DataTables Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 ">
                            <h6 class="m-0 font-weight-bold text-primary">Admit Details</h6>
                                <!-- Topbar Search -->
                     <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        
                                         <form
                        class="navbar-search" >
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" id="myInput"  placeholder="Search for a here..."
                                   aria-label="Search" aria-describedby="basic-addon2" >
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button" >
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form> 
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                        </div>
                       
                     
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered"  id="Datatable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Patient ID</th>
                                            <th>Admit Date</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody class="tbody" id="myTable">
                                        
                                      
                                        
                                        
                                    </tbody>
                                </table>
                            </div>

 


                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
        <div class="modal-dialog">  
            <div class="modal-content">  
                <div class="modal-header">  
                    <button type="button" class="close" data-dismiss="modal">×</button>  
                     
                </div>  
<h4 class="modal-header" id="myModalLabel"> Admit</h4>
                <div class="modal-body">  
                    <form>  
                        <div class="form-group">  
                            <label for="admit_id">ID</label>  
                            <input type="text" class="form-control" id="admit_id" placeholder="Id" disabled="disabled"/>  
                        </div>  
                        <div class="form-group">  
                            <label for="patient_id">Patient ID</label>  
                            <input type="text" class="form-control" id="patient_id" placeholder=""/>  
                        </div>  
                        <div class="form-group">  
                            <label for="admit_reason">Admit Reason</label>  
                            <input type="text" class="form-control" id="admit_reason" placeholder="Reason" required=""  />  
                        </div>  
                        <div class="form-group">  
                            <label for="ward_id">Ward ID </label>  
                            <input type="text" list="ward_id" name="ward_id" class="form-control" placeholder=""/>
                            <datalist id="ward_id" class="list-2">
                            
                            </datalist>  
                            
                        </div>  
                        <div class="form-group">  
                            <label for="admit_date">Admit Date</label>  
                            <input type="date" class="form-control" id="admit_date" placeholder="YYYY-MM-DD" required=""  />  
                        </div>
                        <div class="form-group">  
                            <label for="admit_time">Admit Time</label>  
                            <input type="time" class="form-control" id="admit_time" placeholder="03:11 AM" required=""  />  
                        </div>
                        
                       
                        <div class="form-group">  
                            <label for="admit_branch">Branch</label>  
                            
                            <select name="admit_branch" id="admit_branch">
                            <option value="Colombo">Colombo</option>
                            <option value="Galle">Galle</option>
                            <option value="Jaffna">Jaffna</option>
                            <option value="Kandy">Kandy</option>
                            <option value="Batticaloa">Batticaloa</option>
                            </select>  
                        </div> 
                    </form>  
                </div>  
                <div class="modal-footer">  
                    <button type="button" class="btn btn-primary" id="btnAdd" onclick="return Add();">Add</button>  
                    <button type="button" class="btn btn-primary" id="btnUpdate" style="display:none;" onclick="Update();">Update</button>  
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
                </div>  
            </div>  
        </div>          
    </div>
            
            
                  <!-- start view of Main Content -->
<div class="modal fade" id="1myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">  
        <div class="modal-dialog">  
            <div class="modal-content">  
                <div class="modal-header">  
                    <button type="button" class="close" data-dismiss="modal">×</button>  
                      
                </div>  
                <h4 class="modal-header" id="myModalLabel1" style="position:center">View Admit Details</h4>
                <div class="modal-body"> 
                    
                   
                    
                    
                     <form>  
                        <div class="form-group">  
                            <label for="admit_id1">ID:</label>  
                            <input type="text" class="tab-pane" id="admit_id1" placeholder="Id" disabled="disabled" style="border:none; background-color: transparent  "/>  
                        </div>  
                        <div class="form-group">  
                            <label for="patient_id1">Patient Name:</label>  
                            <input type="text" class="tab-pane" id="patient_id1" placeholder="Name" disabled="disabled" style="border:none; background-color: transparent  "/>  
                        </div>  
                        <div class="form-group">  
                            <label for="admit_reason1">Admit Reason:</label>  
                            <input type="text" class="tab-pane" id="admit_reason1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                         <div class="form-group">  
                            <label for="ward_id1">Ward ID:</label>  
                            <input type="text" class="tab-pane" id="ward_id1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                         <div class="form-group">  
                            <label for="admit_date1">Admit Date:</label>  
                            <input type="date" class="tab-pane" id="admit_date1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                         <div class="form-group">  
                            <label for="admit_time1">Admit Time:</label>  
                            <input type="time" class="tab-pane" id="admit_time1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                          <div class="form-group">  
                            <label for="admit_branch1">Admit Branch:</label>  
                            <input type="text" class="tab-pane" id="admit_branch1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                          
                    
                    </form> 
                    
                </div>  
                <div class="modal-footer">  
                      <button type="button" class="btn btn-primary" id="btnUpdate1" style="display:none;" onclick="view();">Update</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
                </div>  
            </div>  
        </div>          
    </div>      
            
            
            
            

           

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
<%
    }
%> 
 
    

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    </body>
    <jsp:include page="footer.jsp" />
</html>
