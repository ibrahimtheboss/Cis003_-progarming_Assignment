<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.hms.dbConnection.databaseconn"%>
<%@page import="com.hms.objects.User"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>
    <script>
function validLogin(){
if (document.form.username.value == ""){
alert ( "Please enter Login Name." );
document.loginform.userName.focus();
return false;
}
if (document.form.password.value == ""){
alert ( "Please enter password." );
document.userform.password.focus();
return false;
}

return true;
}
</script>

<body class="bg-gradient-success">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block align-content-lg-center" ><img class="img-thumbnail" 
                                                                                   src="img/abc.png"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Login</h1>
                                        <h2 class="h4 text-gray-900 mb-4">Welcome Back!</h2>
                                    </div>
                                    <form class="user" name="form" action="login.jsp" method="post" onsubmit="return validLogin();">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                type="text" id="username" name="username" value="" 
                                                placeholder="Enter Username...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" id="password" name="password" value=""
                                                 placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input type="submit" value="Login" class="btn btn-primary btn-user btn-block">
                                        
                                        <hr>
                                         
                                    </form>
                                    <hr>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
     <%
        User user = new User();
        
    String username = request.getParameter("username");   
    String password = request.getParameter("password");
    databaseconn conn  = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
    ResultSet rs = stmt.executeQuery("select * from users where username='" + username + "' and password='" +password + "'");
    if (rs.next()) {
        
        session.setAttribute( "userid", username);
        
        
        response.sendRedirect("stat.jsp");
    } else {
        
        out.print("<a><br> ABC HOSPITAL LOGIN</a>");
    }
%>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>