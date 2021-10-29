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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.transfer_id + '</td>';  
                html += '<td>' + item.admit_id +'</td>';  
                html += '<td>' + item.transfer_date + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.transfer_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.transfer_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.transfer_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/admit-json/",  
      type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                 
               html += '<option value="'+item.admit_id+'">' +"Patient ID: "+ item.patient_id +" Ward ID: "+ item.ward_id +" Date: "+item.admit_date+'</option>';  
                
            });  
            $('.list-2').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
       }  
   });  
 }  


  
//Add Data Function for transfer  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        admit_id: $('#admit_id').val(),  
        transfer_reason: $('#transfer_reason').val(),
        transfer_from: $('#transfer_from').val(),  
        transfer_to: $('#transfer_to').val(),
        transfer_date: $('#transfer_date').val(),  
          
          
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Transfer Add!",
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
  
//Function for getting the Data Based upon transfer ID  
function getbyID(id) {
    
         
    
    $('#admit_id').css('border-color', 'lightgrey');  
    $('#transfer_reason').css('border-color', 'lightgrey');  
    $('#transfer_from').css('border-color', 'lightgrey');  
    $('#transfer_to').css('border-color', 'lightgrey');  
    $('#transfer_date').css('border-color', 'lightgrey');  
      
      
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#transfer_id').val(result.transfer_id);  
            $('#admit_id').val(result.admit_id);  
            $('#transfer_reason').val(result.transfer_reason);  
            $('#transfer_from').val(result.transfer_from);  
            $('#transfer_to').val(result.transfer_to);  
            $('#transfer_date').val(result.transfer_date);  
            
            
            
  
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


  
//get transfer view details 
function getbyview(doc_id) {  
    $('#admit_id1').css('border-color', 'lightgrey');  
    $('#transfer_reason1').css('border-color', 'lightgrey');  
    $('#transfer_from1').css('border-color', 'lightgrey');  
    $('#transfer_to1').css('border-color', 'lightgrey');  
    $('#transfer_date1').css('border-color', 'lightgrey');  
     
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/" + doc_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
           $('#transfer_id1').val(result.transfer_id);  
            $('#admit_id1').val(result.admit_id);  
            $('#transfer_reason1').val(result.transfer_reason);  
            $('#transfer_from1').val(result.transfer_from);  
            $('#transfer_to1').val(result.transfer_to);  
            $('#transfer_date1').val(result.transfer_date);  
               
            
       
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
 
  // get view details for transfer
function view() {  
    
    var empObj = {
        transfer_id: $('#transfer_id1').val(),
        admit_id: $('#admit_id1').val(),  
        transfer_reason: $('#transfer_reason1').val(),
        transfer_from: $('#transfer_from1').val(),  
        transfer_to: $('#transfer_to1').val(),
        transfer_date: $('#transfer_date1').val(),  
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
            $('#transfer_id1').val("");  
            $('#admit_id1').val("");  
            $('#transfer_reason1').val("");  
            $('#transfer_from1').val("");  
            $('#transfer_to1').val("");  
            $('#transfer_date1').val("");  
            
       
        },  
         
    });  
}
  
   
//function for updating transfer's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
     
    
    var empObj = {  
        transfer_id: $('#transfer_id').val(),
        admit_id: $('#admit_id').val(),  
        transfer_reason: $('#transfer_reason').val(),
        transfer_from: $('#transfer_from').val(),  
        transfer_to: $('#transfer_to').val(),
        transfer_date: $('#transfer_date').val(),  
         
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
        
    
            $('#admit_id').val("");  
            $('#transfer_reason').val("");  
            $('#transfer_from').val("");  
            $('#transfer_to').val("");  
            $('#transfer_date').val("");  
            
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



  
//function for deleting transfer's record  
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/transfer-json/" + id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Transfer Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Transfer Infomation is safe!");
  }
});
    
  
}   
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#transfer_id').val("");  
            $('#admit_id').val("");  
            $('#transfer_reason').val("");  
            $('#transfer_from').val("");  
            $('#transfer_to').val("");  
            $('#transfer_date').val("");  
            
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#admit_id').css('border-color', 'lightgrey');  
    $('#transfer_reason').css('border-color', 'lightgrey');  
    $('#transfer_from').css('border-color', 'lightgrey');  
    $('#transfer_to').css('border-color', 'lightgrey');  
    $('#transfer_date').css('border-color', 'lightgrey');  
     
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#admit_id').val().trim() == "") {  
        $('#admit_id').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#admit_id').css('border-color', 'lightgrey');  
    }  
    if ($('#transfer_reason').val().trim() == "") {  
        $('#transfer_reason').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#transfer_reason').css('border-color', 'lightgrey');  
    }
    if ($('#transfer_from').val().trim() == "") {  
        $('#transfer_from').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#transfer_from').css('border-color', 'lightgrey');  
    }
     if ($('#transfer_to').val().trim() == "") {  
        $('#transfer_to').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#transfer_to').css('border-color', 'lightgrey');  
    }
    
     if ($('#transfer_date').val().trim() == "") {  
        $('#transfer_date').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#transfer_date').css('border-color', 'lightgrey');  
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
  
