<%-- 
    Document   : doctor_Details
    Created on : Oct 20, 2021, 5:11:32 PM
    Author     : User
--%>



<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.time.LocalTime"%>
<%@page import="java.time.Year"%>

<%@page import="java.text.DateFormat"%>
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
        <title>Doctor Details</title>
        
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
    <script src="Js_rest_calling/stat.js"></script>
    
    <script type="text/javascript">
        
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
                    
                    
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <br></br>
                        
                        <a href="#" onclick="printDiv('printThisDiv')" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    <div id="printThisDiv">
                    <div class="d-inline-flex align-items-center justify-content-between mb-4">
                        
                        
                        <h1 class="h3 mb-0 text-gray-800">Statistical Report On ABC Hospitals</h1>
                       
                    </div>
                    
                    
                   <div >
                       
                        
                        <h1 class="h5 mb-2 text-gray-800  "><% 
                               
                               DateFormat k = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
                               String g = k.format(new Date()).toString();
                               
                               
                               out.print("  "+"Date & time: "+g);
                            %></h1>
                       
                    </div>
    <!-- Content Row -->
                    <div class="row" id="myModal" >

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl font-weight-bold text-primary text-uppercase mb-1">
                                               Total Registered Users (No:)</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800" id="myModal"><div class="total_user fa-2x text-center" > </div></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user fa-2x text-primary"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>                   
                        </div>
                          <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl font-weight-bold text-primary text-uppercase mb-1">
                                               Total Doctors in Hospital (No:)</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800" id="myModal"><div class="total_doctor fa-2x text-center" > </div></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user-nurse fa-2x text-primary"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>                   
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-success text-uppercase mb-1">
                                                Total Earnings (Revenue) in Rs:</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_revenue fa-2x text-center"> </div></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-money-bill-wave  fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-info text-uppercase mb-1">Total Number of Registered Patients
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                               
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_patientreg fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                         <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-danger shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-danger text-uppercase mb-1">Total Number of Wards in ABC Hospitals
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_wards fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-bed fa-2x text-gray-500"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                              <!-- Earnings (Monthly) Card Example -->
                        
                                <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl font-weight-bold text-warning text-uppercase mb-1">Total Number of Wards Curenty Avaliable
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_wards_av fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-auto">
                                            
                                            <i class="fas fa-bed fa-2x text-success"></i>
                                        </div>
                                        
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                          <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total Number of Wards TAKEN
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_wards_tk fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-bed fa-2x text-danger"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                          
                            <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total Number of Appoinments Made
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_appoint fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-check fa-2x text-success"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                          
                            
                                <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total  Patients Addmited Over the time
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_admit fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-hospital-user fa-2x text-dark"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                          
                                <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total Number of Patients been Discharged 
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_discharge fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-hospital-user fa-2x text-success"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                                
                                     <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total Number of Patients Currently in medication 
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_curadmit fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-hospital-user fa-2x text-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                                     <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total Number of Patients Transferred to different Branches 
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_transfers fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-ambulance fa-2x text-success"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                                      <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-80 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xl-center font-weight-bold text-warning text-uppercase mb-1">Total Number of Medical Stocks types In ABC hospital 
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"></div>
                                                </div>
                                                <div class="col">
                                                   
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> <div class="total_medicine fa-2x text-center"> </div></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-medkit fa-2x text-danger"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


 
            
            

          
         

        </div>
        <!-- End of Content Wrapper -->

    </div>
                    <div>            
        </div>
        <!-- End of Content Wrapper -->
 </div>
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
