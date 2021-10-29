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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.admit_id + '</td>';  
                html += '<td>' + item.patient_id +'</td>';  
                html += '<td>' + item.admit_date + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.admit_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.admit_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.admit_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/ward-json/",  
      type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                 
               html += '<option value="'+item.ward_id+'">' +"No: "+ item.ward_no +" Type: "+ item.ward_type +" ID: "+item.ward_id+'</option>';  
                
            });  
            $('.list-2').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
       }  
   });  
 }  


  
//Add Data Function for admit  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        patient_id: $('#patient_id').val(),  
        admit_reason: $('#admit_reason').val(),
        ward_id: $('#ward_id').val(),  
        admit_date: $('#admit_date').val(),
        admit_time: $('#admit_time').val(),  
        admit_branch: $('#admit_branch').val(),  
          
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Admit Add!",
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
  
//Function for getting the Data Based upon admit ID  
function getbyID(id) {
    
          
    
    $('#patient_id').css('border-color', 'lightgrey');  
    $('#admit_reason').css('border-color', 'lightgrey');  
    $('#ward_id').css('border-color', 'lightgrey');  
    $('#admit_date').css('border-color', 'lightgrey');  
    $('#admit_time').css('border-color', 'lightgrey');  
    $('#admit_branch').css('border-color', 'lightgrey');  
      
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#admit_id').val(result.admit_id);  
            $('#patient_id').val(result.patient_id);  
            $('#admit_reason').val(result.admit_reason);  
            $('#ward_id').val(result.ward_id);  
            $('#admit_date').val(result.admit_date);  
            $('#admit_time').val(result.admit_time);  
            $('#admit_branch').val(result.admit_branch);  
            
         
            
            
  
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
//get admit view details 
function getbyview(doc_id) {  
    $('#patient_id1').css('border-color', 'lightgrey');  
    $('#admit_reason1').css('border-color', 'lightgrey');  
    $('#ward_id1').css('border-color', 'lightgrey');  
    $('#admit_date1').css('border-color', 'lightgrey');  
    $('#admit_time1').css('border-color', 'lightgrey');  
    $('#admit_branch1').css('border-color', 'lightgrey');  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/" + doc_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
           $('#admit_id1').val(result.admit_id);  
            $('#patient_id1').val(result.patient_id);  
            $('#admit_reason1').val(result.admit_reason);  
            $('#ward_id1').val(result.ward_id);  
            $('#admit_date1').val(result.admit_date);  
            $('#admit_time1').val(result.admit_time);  
            $('#admit_branch1').val(result.admit_branch);   
            
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for admit
function view() {  
    
    var empObj = {
        admit_id: $('#admit_id1').val(),
        patient_id: $('#patient_id1').val(),  
        admit_reason: $('#admit_reason1').val(),
        ward_id: $('#ward_id1').val(),  
        admit_date: $('#admit_date1').val(),
        admit_time: $('#admit_time1').val(),  
        admit_branch: $('#admit_branch1').val(),  
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
            $('#admit_id1').val("");  
            $('#patient_id1').val("");  
            $('#admit_reason1').val("");  
            $('#ward_id1').val("");  
            $('#admit_date1').val("");  
            $('#admit_time1').val("");  
            $('#admit_branch1').val("");
        
        },  
         
    });  
}
  
   
//function for updating admit's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
        admit_id: $('#admit_id').val(),
        patient_id: $('#patient_id').val(),  
        admit_reason: $('#admit_reason').val(),
        ward_id: $('#ward_id').val(),  
        admit_date: $('#admit_date').val(),
        admit_time: $('#admit_time').val(),  
        admit_branch: $('#admit_branch').val(),  
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
    
            $('#patient_id').val("");  
            $('#admit_reason').val("");  
            $('#ward_id').val("");  
            $('#admit_date').val("");  
            $('#admit_time').val("");  
            $('#admit_branch').val("");
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



  
//function for deleting admit's record  
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/" + id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Discharge Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Discharge Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#admit_id').val("");  
            $('#patient_id').val("");  
            $('#admit_reason').val("");  
            $('#ward_id').val("");  
            $('#admit_date').val("");  
            $('#admit_time').val("");  
            $('#admit_branch').val("")
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#patient_id').css('border-color', 'lightgrey');  
    $('#admit_reason').css('border-color', 'lightgrey');  
    $('#ward_id').css('border-color', 'lightgrey');  
    $('#admit_date').css('border-color', 'lightgrey');  
    $('#admit_time').css('border-color', 'lightgrey');  
    $('#admit_branch').css('border-color', 'lightgrey'); 
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#patient_id').val().trim() == "") {  
        $('#patient_id').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#patient_id').css('border-color', 'lightgrey');  
    }  
    if ($('#admit_reason').val().trim() == "") {  
        $('#admit_reason').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#admit_reason').css('border-color', 'lightgrey');  
    }
    if ($('#ward_id').val().trim() == "") {  
        $('#ward_id').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#ward_id').css('border-color', 'lightgrey');  
    }
     if ($('#admit_date').val().trim() == "") {  
        $('#admit_date').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#admit_date').css('border-color', 'lightgrey');  
    }
    
     if ($('#admit_time').val().trim() == "") {  
        $('#admit_time').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#admit_time').css('border-color', 'lightgrey');  
    }
     if ($('#admit_branch').val().trim() == "") {  
        $('#admit_branch').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#admit_branch').css('border-color', 'lightgrey');  
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
  
