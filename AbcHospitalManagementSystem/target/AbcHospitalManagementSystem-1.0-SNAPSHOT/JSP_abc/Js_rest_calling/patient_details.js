/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //Load Data in Table when patientuments is ready  
$(document).ready(function () {  
    loadData();
    //listData();
});  
  
//Load Data function  
function loadData() {  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.patient_id + '</td>';  
                html += '<td>' + item.patient_fname +" " + item.patient_lname + '</td>';  
                html += '<td>' + item.patient_nic + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.patient_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.patient_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.patient_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
                html += '</tr>';  
            });  
            $('.tbody').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
} 

//function listData() {  
   // $.ajax({  
   //     url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/",  
   //     type: "GET",  
    //    contentType: "application/json; charset=utf-8",  
    //    dataType: "json",  
     //   success: function (result) {  
      //      var html = '';  
     //       $.each(result, function (key, item) {  
                 
       //         html += '<option>' + item.patient_firstname +'</option>';  
                
        //    });  
        //    $('.list-1').html(html);  
       // },  
  //      error: function (errormessage) {  
  //          alert(errormessage.responseText);  
  //      }  
 //   });  
// }  


  
//Add Data Function for patient  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        patient_fname: $('#patient_fname').val(),  
        patient_lname: $('#patient_lname').val(),
        patient_dob: $('#patient_dob').val(),  
        patient_nic: $('#patient_nic').val(),
        patient_phone_no: $('#patient_phone_no').val(),  
        patient_email: $('#patient_email').val(),  
        patient_address: $('#patient_address').val(),  
        patient_gender: $('#patient_gender').val(),  
          
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Patient Add!",
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
  
//Function for getting the Data Based upon patient ID  
function getbyID(patient_id) {
    
    
    $('#patient_fname').css('border-color', 'lightgrey');  
    $('#patient_lname').css('border-color', 'lightgrey');  
    $('#patient_dob').css('border-color', 'lightgrey');  
    $('#patient_nic').css('border-color', 'lightgrey');  
    $('#patient_phone_no').css('border-color', 'lightgrey');  
    $('#patient_email').css('border-color', 'lightgrey');  
    $('#patient_address').css('border-color', 'lightgrey');  
    $('#patient_gender').css('border-color', 'lightgrey');  
     
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/" + patient_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#patient_id').val(result.patient_id);  
            $('#patient_fname').val(result.patient_fname);  
            $('#patient_lname').val(result.patient_lname);  
            $('#patient_dob').val(result.patient_dob);  
            $('#patient_nic').val(result.patient_nic);  
            $('#patient_phone_no').val(result.patient_phone_no);  
            $('#patient_email').val(result.patient_email);  
            $('#patient_address').val(result.patient_address);  
            $('#patient_gender').val(result.patient_gender);  
             
         
            
            
  
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
//get patient view details 
function getbyview(patient_id) {  
    $('#patient_fname1').css('border-color', 'lightgrey');  
    $('#patient_lname1').css('border-color', 'lightgrey');  
    $('#patient_dob1').css('border-color', 'lightgrey');  
    $('#patient_nic1').css('border-color', 'lightgrey');  
    $('#patient_phone_no1').css('border-color', 'lightgrey');  
    $('#patient_email1').css('border-color', 'lightgrey');  
    $('#patient_address1').css('border-color', 'lightgrey');  
    $('#patient_gender1').css('border-color', 'lightgrey');  
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/" + patient_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
             $('#patient_id1').val(result.patient_id);  
            $('#patient_fname1').val(result.patient_fname);  
            $('#patient_lname1').val(result.patient_lname);  
            $('#patient_dob1').val(result.patient_dob);  
            $('#patient_nic1').val(result.patient_nic);  
            $('#patient_phone_no1').val(result.patient_phone_no);  
            $('#patient_email1').val(result.patient_email);  
            $('#patient_address1').val(result.patient_address);  
            $('#patient_gender1').val(result.patient_gender);  
             
            
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for patient
function view() {  
    
    var empObj = {  
        patient_fname: $('#patient_fname1').val(),  
        patient_lname: $('#patient_lname1').val(),
        patient_dob: $('#patient_dob1').val(),  
        patient_nic: $('#patient_nic1').val(),
        patient_phone_no: $('#patient_phone_no1').val(),  
        patient_email: $('#patient_email1').val(),  
        patient_address: $('#patient_address1').val(),  
        patient_gender: $('#patient_gender1').val(),    
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
            $('#patient_id1').val("");  
            $('#patient_fname1').val("");  
            $('#patient_lname1').val("");  
            $('#patient_dob1').val("");  
            $('#patient_nic1').val("");  
            $('#patient_phone_no1').val("");  
            $('#patient_email1').val("");  
            $('#patient_address1').val("");  
            $('#patient_gender1').val("");  
        
        
        
        
        },  
         
    });  
}
  
   
//function for updating patient's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
       patient_fname: $('#patient_fname').val(),  
        patient_lname: $('#patient_lname').val(),
        patient_dob: $('#patient_dob').val(),  
        patient_nic: $('#patient_nic').val(),
        patient_phone_no: $('#patient_phone_no').val(),  
        patient_email: $('#patient_email').val(),  
        patient_address: $('#patient_address').val(),  
        patient_gender: $('#patient_gender').val(), 
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
     
            $('#patient_fname').val("");  
            $('#patient_lname').val("");  
            $('#patient_dob').val("");  
            $('#patient_nic').val("");  
            $('#patient_phone_no').val("");  
            $('#patient_email').val("");  
            $('#patient_address').val("");  
            $('#patient_gender').val("");
     
            swal({title: "Patient updated!",
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



  
//function for deleting patient's record  
function Delele(patient_id) {
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/" + patient_id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Patient Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Patient Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#patient_id').val("");  
     $('#patient_fname').val("");  
            $('#patient_lname').val("");  
            $('#patient_dob').val("");  
            $('#patient_nic').val("");  
            $('#patient_phone_no').val("");  
            $('#patient_email').val("");  
            $('#patient_address').val("");  
            $('#patient_gender').val("");
       
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#patient_fname').css('border-color', 'lightgrey');  
    $('#patient_lname').css('border-color', 'lightgrey');  
    $('#patient_dob').css('border-color', 'lightgrey');  
    $('#patient_nic').css('border-color', 'lightgrey');  
    $('#patient_phone_no').css('border-color', 'lightgrey');  
    $('#patient_email').css('border-color', 'lightgrey');  
    $('#patient_address').css('border-color', 'lightgrey');  
    $('#patient_gender').css('border-color', 'lightgrey'); 
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#patient_fname').val().trim() == "") {  
        $('#patient_fname').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#patient_fname').css('border-color', 'lightgrey');  
    }  
    if ($('#patient_lname').val().trim() == "") {  
        $('#patient_lname').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#patient_lname').css('border-color', 'lightgrey');  
    }
    if ($('#patient_dob').val().trim() == "") {  
        $('#patient_dob').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#patient_dob').css('border-color', 'lightgrey');  
    }
     
    
     if ($('#patient_phone_no').val().trim() == "") {  
        $('#patient_phone_no').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#patient_phone_no').css('border-color', 'lightgrey');  
    }
     
     if ($('#patient_address').val().trim() == "") {  
        $('#patient_address').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#patient_address').css('border-color', 'lightgrey');  
    }
    if ($('#patient_gender').val().trim() == "") {  
        $('#patient_gender').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#patient_gender').css('border-color', 'lightgrey');  
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
  
