/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //Load Data in Table when appointmentuments is ready  
$(document).ready(function () {  
    loadData();
   
});
$(document).ready(function () {  
    
   listData();
});
  
//Load Data function  
function loadData() {  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/appointment-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.appointment_id + '</td>';  
                html += '<td>' + item.appointment_name+'</td>';  
                html += '<td>' + item.appointment_date +'</td>';
                html += '<td>' + item.appointment_time +'</td>';

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.appointment_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.appointment_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.appointment_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
                html += '</tr>';  
            });  
            $('.tbody').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
} 
function listData() {  
   $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/",  
      type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                 
               html += '<option value="'+item.doc_id+'">' + item.doc_firstname +" "+ item.doc_lastname +" "+item.doc_id+'</option>';  
                
            });  
            $('.list-1').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
       }  
   });  
 }  


  
//Add Data Function for appointment  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        appointment_name: $('#appointment_name').val(),  
        appointment_age: $('#appointment_age').val(),
        appointment_gender: $('#appointment_gender').val(),  
        doctor_id: $('#doctor_id').val(),
        appointment_date: $('#appointment_date').val(),  
        appointment_time: $('#appointment_time').val(),  
        appointment_tel: $('#appointment_tel').val(),
        patient_id: $('#patient_id').val(),
        appointment_charge: $('#appointment_charge').val(),  
        appointment_no: $('#appointment_no').val(),  
        appointment_branch: $('#appointment_branch').val(),
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/appointment-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Appointment Add!",
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

 
  
//Function for getting the Data Based upon appointment ID  
function getbyID(appointment_id) {
    
    
    $('#appointment_name').css('border-color', 'lightgrey');  
    $('#appointment_age').css('border-color', 'lightgrey');  
    $('#appointment_gender').css('border-color', 'lightgrey');  
    $('#doctor_id').css('border-color', 'lightgrey');  
    $('#appointment_date').css('border-color', 'lightgrey');
    $('#appointment_time').css('border-color', 'lightgrey'); 
    $('#appointment_tel').css('border-color', 'lightgrey');  
    $('#patient_id').css('border-color', 'lightgrey');  
    $('#appointment_charge').css('border-color', 'lightgrey');
    $('#appointment_no').css('border-color', 'lightgrey');  
    $('#appointment_branch').css('border-color', 'lightgrey'); 
     
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/appointment-json/" + appointment_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {
            $('#appointment_id').val(result.appointment_id);
            $('#appointment_name').val(result.appointment_name);  
            $('#appointment_age').val(result.appointment_age);  
            $('#appointment_gender').val(result.appointment_gender);  
            $('#doctor_id').val(result.doctor_id);  
            $('#appointment_date').val(result.appointment_date);  
            $('#appointment_time').val(result.appointment_time);  
            $('#appointment_tel').val(result.appointment_tel);  
            $('#patient_id').val(result.patient_id);  
            $('#appointment_charge').val(result.appointment_charge);
            $('#appointment_no').val(result.appointment_no);
            $('#appointment_branch').val(result.appointment_branch); 
         
            
            
  
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
//get appointment view details 
function getbyview(appointment_id) {  
   
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/appointmentview-json/" + appointment_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {
            $('#appointment_id1').val(result.appointmentList_id);
            $('#appointment_name1').val(result.appointmentList_name);  
            $('#appointment_age1').val(result.appointmentList_age);  
            $('#appointment_gender1').val(result.appointmentList_gender);  
            $('#doctor_id1').val(result.doctor_id);
            $('#doctor_fname').val(result.doctor_fname);
            $('#doctor_lname').val(result.doctor_lname);
            $('#appointment_date1').val(result.appointmentList_date);  
            $('#appointment_time1').val(result.appointmentList_time);  
            $('#appointment_tel1').val(result.appointmentList_tel);  
            $('#patient_id1').val(result.patient_id);  
            $('#appointment_charge1').val(result.appointmentList_charge);
            $('#appointment_no1').val(result.appointmentList_no);
            $('#appointment_branch1').val(result.appointmentList_branch);
             
            
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for appointment

  
   
//function for updating appointment's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {
        appointment_id: $('#appointment_id').val(),
        appointment_name: $('#appointment_name').val(),  
        appointment_age: $('#appointment_age').val(),
        appointment_gender: $('#appointment_gender').val(),  
        doctor_id: $('#doctor_id').val(),
        
        appointment_date: $('#appointment_date').val(),  
        appointment_time: $('#appointment_time').val(),  
        appointment_tel: $('#appointment_tel').val(),
        patient_id: $('#patient_id').val(),
        appointment_charge: $('#appointment_charge').val(),  
        appointment_no: $('#appointment_no').val(),  
        appointment_branch: $('#appointment_branch').val(), 
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/appointment-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
       
        $('#appointment_name').val("");  
        $('#appointment_age').val("");
        $('#appointment_gender').val("");  
        $('#doctor_id').val("");
        
        $('#appointment_date').val("");  
        $('#appointment_time').val("");  
        $('#appointment_tel').val("");
        $('#patient_id').val("");
        $('#appointment_charge').val("");  
        $('#appointment_no').val("");  
        $('#appointment_branch').val("");   
     
            swal({title: "Appointment updated!",
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



  
//function for deleting appointment's record  
function Delele(appointment_id) {
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/appointment-json/" + appointment_id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Appointment Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Appointment Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
        $('#appointment_id').val("");  
        $('#appointment_name').val("");  
        $('#appointment_age').val("");
        $('#appointment_gender').val("");  
        $('#doctor_id').val("");
        $('#doctor_fname').val("");
        $('#doctor_lname').val("");
        $('#appointment_date').val("");  
        $('#appointment_time').val("");  
        $('#appointment_tel').val("");
        $('#patient_id').val("");
        $('#appointment_charge').val("");  
        $('#appointment_no').val("");  
        $('#appointment_branch').val("");   
       
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#appointment_name').css('border-color', 'lightgrey');  
    $('#appointment_age').css('border-color', 'lightgrey');  
    $('#appointment_gender').css('border-color', 'lightgrey');  
    $('#doctor_id').css('border-color', 'lightgrey');
    $('#appointment_date').css('border-color', 'lightgrey');
    $('#appointment_time').css('border-color', 'lightgrey'); 
    $('#appointment_tel').css('border-color', 'lightgrey');  
    $('#patient_id').css('border-color', 'lightgrey');  
    $('#appointment_charge').css('border-color', 'lightgrey');
    $('#appointment_no').css('border-color', 'lightgrey');  
    $('#appointment_branch').css('border-color', 'lightgrey');  
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#appointment_name').val().trim() == "") {  
        $('#appointment_name').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#appointment_name').css('border-color', 'lightgrey');  
    }  
   if ($('#appointment_age').val().trim() == "") {  
        $('#appointment_age').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_age').css('border-color', 'lightgrey');  
    }
    if ($('#appointment_tel').val().trim() == "") {  
        $('#appointment_tel').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_tel').css('border-color', 'lightgrey');  
    }
    if ($('#appointment_no').val().trim() == "") {  
        $('#appointment_no').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_no').css('border-color', 'lightgrey');  
    }
     
    
    
     
     if ($('#appointment_date').val().trim() == "") {  
        $('#appointment_date').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_date').css('border-color', 'lightgrey');  
    }
    if ($('#appointment_time').val().trim() == "") {  
        $('#appointment_time').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_time').css('border-color', 'lightgrey');  
    }
     if ($('#doctor_id').val().trim() == "") {  
        $('#doctor_id').css('border-color', 'Red');
        
        isValid = false;  
    }
    
    else {  
        $('#doctor_id').css('border-color', 'lightgrey');  
    }
     
    if ($('#appointment_gender').val().trim() == "") {  
        $('#appointment_gender').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_gender').css('border-color', 'lightgrey');  
    }
    if ($('#appointment_branch').val().trim() == "") {  
        $('#appointment_branch').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#appointment_branch').css('border-color', 'lightgrey');  
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
  
