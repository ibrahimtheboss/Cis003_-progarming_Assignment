/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //Load Data in Table when documents is ready  
$(document).ready(function () {  
    loadData();  
});  
  
//Load Data function  
function loadData() {  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/user-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.user_id + '</td>';  
                html += '<td>' + item.username +'</td>';
                html += '<td>' + item.password +'</td>';
                html += '<td>' + item.role + '</td>'; 
                html += '<td style="position:right"><a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.user_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.user_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
                html += '</tr>';  
            });  
            $('.tbody').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
}  



  
//Add Data Function for user  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        username: $('#username').val(),  
        password: $('#password').val(),
        role: $('#role').val(),  
          
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/user-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "User Add!",
         text: "You Added successfully!",
         type: "success",
         icon: "success"}).then(function(){ 
   location.reload();
   });
        },  
        error: function () {  
            alert("There was an error");
            location.reload(true);
        }  
    });  
}  
  
//Function for getting the Data Based upon user ID  
function getbyID(user_id) {
    
    
    $('#username').css('border-color', 'lightgrey');  
    $('#password').css('border-color', 'lightgrey');  
    $('#role').css('border-color', 'lightgrey');  
    
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/user-json/" + user_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#user_id').val(result.user_id);  
            $('#username').val(result.username);  
            $('#password').val(result.password);  
            $('#role').val(result.role);  
             
         
            
            
  
            $('#myModal').modal('show');  
            $('#btnUpdate').show();  
            $('#btnAdd').hide();

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
}

  
   
//function for updating user's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
        user_id: $('#user_id').val(),  
        username: $('#username').val(),
        password: $('#password').val(),
        role: $('#role').val(),
         
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/user-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
    $('#username').val("");  
    $('#password').val("");
    $('#role').val("");  
     
     swal({title: "User updated!",
         text: "You updated successfully!",
         type: "success",
         icon: "success",});
        
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);
            location.reload(true);
        }  
    });  
}



  
//function for deleting user's record  
function Delele(user_id) {
    swal({
  title: "Are you sure?",
  text: "Once deleted, you will not be able to recover this data!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
      $.ajax({  
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/user-json/" + user_id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! User Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The User Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#user_id').val("");  
    $('#username').val("");  
    $('#password').val("");
    $('#role').val("");  
      
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#username').css('border-color', 'lightgrey');  
    $('#password').css('border-color', 'lightgrey');  
    $('#role').css('border-color', 'lightgrey');  
     
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#username').val().trim() == "") {  
        $('#username').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#username').css('border-color', 'lightgrey');  
    }  
    if ($('#password').val().trim() == "") {  
        $('#password').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#password').css('border-color', 'lightgrey');  
    }
    if ($('#role').val().trim() == "") {  
        $('#role').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#role').css('border-color', 'lightgrey');  
    }
     
    return isValid;  
}
    

$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
  
