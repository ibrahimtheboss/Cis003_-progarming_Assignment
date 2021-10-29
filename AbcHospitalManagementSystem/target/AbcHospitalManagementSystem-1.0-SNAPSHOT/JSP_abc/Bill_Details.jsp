<%-- 
    Document   : Bill_Details
    Created on : Oct 24, 2021, 12:37:12 PM
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
    <script src="Js_rest_calling/bill_details.js"></script>
    <script>
         function printDiv(divName)
  {
      var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;

			document.body.innerHTML = printContents;

			window.print();

			document.body.innerHTML = originalContents;
  }
    </script>
    </head>
    <%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
        
      response.sendRedirect("login.jsp");} else { 

%> 
    <body id="page-top">
         <!-- Topbar -->
               
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
                    <h1 class="h3 mb-2 text-gray-800">Manage Bills </h1>
                    
                    
                    
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"  onclick="clearTextBox();"><i class="fas fa-plus" ></i> Create New Bill</button><br /><br /> 
                   
  

<!-- DataTables Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 ">
                            <h6 class="m-0 font-weight-bold text-primary">Billing Details</h6>
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
                                            <th>Total Amount(Rs:) </th>
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
<h4 class="modal-header" id="myModalLabel"> Bill</h4>
                <div class="modal-body">  
                    <form>  
                        <div class="form-group">  
                            <label for="bill_id">ID</label>  
                            <input type="text" class="form-control" name="bill_id" id="bill_id" placeholder="Id" disabled="disabled"/>  
                        </div>  
                        <div class="form-group">  
                           <label for="patient_id">Patient ID </label>  
                           
                             <Select id="patient_id" name="patient_id"  class="list-1">
                            
                            </Select>  
                        </div>  
                          <div class="form-group">  
                            <label for="medical_charge">Medical Charges Rs:</label>  
                            <input type="number" class="form-control" name="medical_charge"  id="medical_charge" placeholder=""   />  
                        </div>
                        
                        <div class="form-group">  
                            <label for="appointment_charge">Appointment Charges Rs:</label>  
                            <input type="number" class="form-control"  name="appointment_charge" id="appointment_charge" placeholder=""  />  
                        </div>
                        <div class="form-group">  
                            <label for="hospital_charge">Hospital Charges Rs :</label>  
                            <input type="number" class="form-control"  name="hospital_charge" id="hospital_charge" placeholder=""   />  
                        </div>
                        <div class="form-group">  
                            <label for="discount">Discount Rs:</label>  
                            <input type="number" class="form-control" name="discount"  id="discount" placeholder=""   />  
                        </div>
                        <input type="button" value="Display Result" onclick="addNumber()">
                        <br>
                        <div class="form-group">  
                            <label for="total" >Total Amount Rs:</label>  
                            <input type="text"  name="total" id="total"  readonly   />  
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
                <h4 class="modal-header" id="myModalLabel1" style="position:center">View Billing Details</h4>
                <div class="modal-body"> 
                    
                   
                    
                    
                     <form>  
                        <div class="form-group">  
                            <label for="bill_id1">ID:</label>  
                            <input type="text" class="tab-pane" id="bill_id1" placeholder="Id" disabled="disabled" style="border:none; background-color: transparent  "/>  
                        </div>  
                        <div class="form-group">  
                            <label for="patient_id1">Patient ID:</label>  
                            <input type="text" class="tab-pane" id="patient_id1" placeholder="Name" disabled="disabled" style="border:none; background-color: transparent  "/>  
                        </div>  
                        <div class="form-group">  
                            <label for="datetime1">Date Time:</label>  
                            <input type="text" class="tab-pane" id="datetime1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                         <div class="form-group">  
                            <label for="medical_charge1">Medical Charge Rs:</label>  
                            <input type="text" class="tab-pane" id="medical_charge1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                         <div class="form-group">  
                            <label for="appointment_charge1">Appointment Charge Rs:</label>  
                            <input type="text" class="tab-pane" id="appointment_charge1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                         <div class="form-group">  
                            <label for="hospital_charge1">Hospital charge Rs:</label>  
                            <input type="text" class="tab-pane" id="hospital_charge1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                          <div class="form-group">  
                            <label for="discount1">Discount Rs:</label>  
                            <input type="text" class="tab-pane" id="discount1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
                        </div>
                          <div class="form-group">  
                            <label for="total1">Total Amount Rs:</label>  
                            <input type="text" class="tab-pane" id="total1" placeholder="" required="" disabled="disabled" style="border:none; background-color: transparent  "  />  
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

    <script>
                      
                     


            function addNumber(){
                var medical = parseInt(document.getElementById("medical_charge").value);
            var appointment = parseInt(document.getElementById("appointment_charge").value);
            var hospital = parseInt(document.getElementById("hospital_charge").value);
            var discount = parseInt(document.getElementById("discount").value);
                var sum = (medical + appointment + hospital) - discount;

                document.getElementById("total").value = sum;  

            }

 
 
                      
                  </script>
                  
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
