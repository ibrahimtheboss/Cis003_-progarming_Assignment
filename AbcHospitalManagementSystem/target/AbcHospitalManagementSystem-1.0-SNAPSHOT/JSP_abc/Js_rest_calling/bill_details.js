/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //Load Data in Table when documents is ready  
$(document).ready(function () {  
    loadData();
    listData();
});  
  
//Load Data function  
function loadData() {  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.bill_id + '</td>';  
                html += '<td>' + item.patient_id +'</td>';  
                html += '<td>' + item.total + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.bill_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.bill_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.bill_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/patient-json/",  
       type: "GET",  
        contentType: "application/json; charset=utf-8",  
      dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                 
               html += '<option value="'+item.patient_id+'">'+" Name: "+  item.patient_fname + " " + item.patient_lname + "  "+ " NIC: "+ item.patient_nic +'</option>';  
                
           });  
            $('.list-1').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
   });  
 }  


  
//Add Data Function for bill  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        patient_id: $('#patient_id').val(),  
        
        medical_charge: $('#medical_charge').val(),  
        appointment_charge: $('#appointment_charge').val(),
        hospital_charge: $('#hospital_charge').val(),  
        discount: $('#discount').val(),  
        total: $('#total').val(),  
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Bill Add!",
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
  
//Function for getting the Data Based upon bill ID  
function getbyID(id) {
    
          
    
    $('#patient_id').css('border-color', 'lightgrey');  
    $('#datetime').css('border-color', 'lightgrey');  
    $('#medical_charge').css('border-color', 'lightgrey');  
    $('#appointment_charge').css('border-color', 'lightgrey');  
    $('#hospital_charge').css('border-color', 'lightgrey');  
    $('#discount').css('border-color', 'lightgrey');  
    $('#total').css('border-color', 'lightgrey');  
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#bill_id').val(result.bill_id);  
            $('#patient_id').val(result.patient_id);  
            $('#datetime').val(result.datetime);  
            $('#medical_charge').val(result.medical_charge);  
            $('#appointment_charge').val(result.appointment_charge);  
            $('#hospital_charge').val(result.hospital_charge);  
            $('#discount').val(result.discount);  
            $('#total').val(result.total);
         
            
            
  
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
//get bill view details 
function getbyview(id) {  
    $('#patient_id1').css('border-color', 'lightgrey');  
    $('#datetime1').css('border-color', 'lightgrey');  
    $('#medical_charge1').css('border-color', 'lightgrey');  
    $('#appointment_charge1').css('border-color', 'lightgrey');  
    $('#hospital_charge1').css('border-color', 'lightgrey');  
    $('#discount1').css('border-color', 'lightgrey');
    $('#total1').css('border-color', 'lightgrey');
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
           $('#bill_id1').val(result.bill_id);  
            $('#patient_id1').val(result.patient_id);  
            $('#datetime1').val(result.datetime);  
            $('#medical_charge1').val(result.medical_charge);  
            $('#appointment_charge1').val(result.appointment_charge);  
            $('#hospital_charge1').val(result.hospital_charge);  
            $('#discount1').val(result.discount);   
            $('#total1').val(result.total); 
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for bill
function view() {  
    
    var empObj = {
        bill_id: $('#bill_id1').val(),
        patient_id: $('#patient_id1').val(),  
        datetime: $('#datetime1').val(),
        medical_charge: $('#medical_charge1').val(),  
        appiontment_charge: $('#appointment_charge1').val(),
        hospital_charge: $('#hospital_charge1').val(),  
        discount: $('#discount1').val(),
        total: $('#total1').val(),
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
            $('#bill_id1').val("");  
            $('#patient_id1').val("");  
            $('#datetime1').val("");  
            $('#medical_charge1').val("");  
            $('#appointment_charge1').val("");  
            $('#hospital_charge1').val("");  
            $('#discount1').val("");
        $('#total1').val("");
        },  
         
    });  
}
  
   
//function for updating bill's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
        bill_id: $('#bill_id').val(),
        patient_id: $('#patient_id').val(),  
        
        medical_charge: $('#medical_charge').val(),  
        appointment_charge: $('#appointment_charge').val(),
        hospital_charge: $('#hospital_charge').val(),  
        discount: $('#discount').val(),  
        total: $('#total').val(),
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
    
            $('#patient_id').val("");  
              
            $('#medical_charge').val("");  
            $('#appointment_charge').val("");  
            $('#hospital_charge').val("");  
            $('#discount').val("");
            $('#total').val("");
            
     swal({title: "updated!",
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



  
//function for deleting bill's record  
function Delele(id) {
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/bill-json/" + id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Bill Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The bill Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#bill_id').val("");  
            $('#patient_id').val("");  
              
            $('#medical_charge').val("");  
            $('#appointment_charge').val("");  
            $('#hospital_charge').val("");  
            $('#discount').val("");
    $('#total').val("");
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#patient_id').css('border-color', 'lightgrey');  
     
    $('#medical_charge').css('border-color', 'lightgrey');  
    $('#appointment_charge').css('border-color', 'lightgrey');  
    $('#hospital_charge').css('border-color', 'lightgrey');  
    $('#discount').css('border-color', 'lightgrey');
    $('#total').css('border-color', 'lightgrey'); 
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
     
    if ($('#medical_charge').val().trim() == "") {  
        $('#medical_charge').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#medical_charge').css('border-color', 'lightgrey');  
    }
    if ($('#appointment_charge').val().trim() == "") {  
        $('#appointment_charge').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#appointment_charge').css('border-color', 'lightgrey');  
    }
    if ($('#hospital_charge').val().trim() == "") {  
        $('#hospital_charge').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#hospital_charge').css('border-color', 'lightgrey');  
    }
    if ($('#discount').val().trim() == "") {  
        $('#discount').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#discount').css('border-color', 'lightgrey');  
    }
    if ($('#patient_id').val().trim() == "") {  
        $('#patient_id').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#patient_id').css('border-color', 'lightgrey');  
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
  
