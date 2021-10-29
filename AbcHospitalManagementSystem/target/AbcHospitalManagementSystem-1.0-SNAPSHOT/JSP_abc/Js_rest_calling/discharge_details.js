/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //Load Data in Table when documents is ready  
$(document).ready(function () {  
    loadData();
    //listData();
});  
  
//Load Data function  
function loadData() {  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.discharge_id + '</td>';  
                html += '<td>' + item.admit_id +'</td>';  
                html += '<td>' + item.discharge_date + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.discharge_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.discharge_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.discharge_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
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
   //     url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/",  
   //     type: "GET",  
    //    contentType: "application/json; charset=utf-8",  
    //    dataType: "json",  
     //   success: function (result) {  
      //      var html = '';  
     //       $.each(result, function (key, item) {  
                 
       //         html += '<option>' + item.doc_firstname +'</option>';  
                
        //    });  
        //    $('.list-1').html(html);  
       // },  
  //      error: function (errormessage) {  
  //          alert(errormessage.responseText);  
  //      }  
 //   });  
// }  


  
//Add Data Function for discharge  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        admit_id: $('#admit_id').val(),  
        discharge_reason: $('#discharge_reason').val(),
        ward_id: $('#ward_id').val(),  
        discharge_date: $('#discharge_date').val(),
        discharge_time: $('#discharge_time').val(),  
        discharge_branch: $('#discharge_branch').val(),  
          
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Discharge Add!",
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
  
//Function for getting the Data Based upon discharge ID  
function getbyID(id) {
    
          
    
    $('#admit_id').css('border-color', 'lightgrey');  
    $('#discharge_reason').css('border-color', 'lightgrey');  
    $('#ward_id').css('border-color', 'lightgrey');  
    $('#discharge_date').css('border-color', 'lightgrey');  
    $('#discharge_time').css('border-color', 'lightgrey');  
    $('#discharge_branch').css('border-color', 'lightgrey');  
      
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#discharge_id').val(result.discharge_id);  
            $('#admit_id').val(result.admit_id);  
            $('#discharge_reason').val(result.discharge_reason);  
            $('#ward_id').val(result.ward_id);  
            $('#discharge_date').val(result.discharge_date);  
            $('#discharge_time').val(result.discharge_time);  
            $('#discharge_branch').val(result.discharge_branch);  
            
         
            
            
  
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
//get discharge view details 
function getbyview(id) {  
    $('#admit_id1').css('border-color', 'lightgrey');  
    $('#discharge_reason1').css('border-color', 'lightgrey');  
    $('#ward_id1').css('border-color', 'lightgrey');  
    $('#discharge_date1').css('border-color', 'lightgrey');  
    $('#discharge_time1').css('border-color', 'lightgrey');  
    $('#discharge_branch1').css('border-color', 'lightgrey');  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
           $('#discharge_id1').val(result.discharge_id);  
            $('#admit_id1').val(result.admit_id);  
            $('#discharge_reason1').val(result.discharge_reason);  
            $('#ward_id1').val(result.ward_id);  
            $('#discharge_date1').val(result.discharge_date);  
            $('#discharge_time1').val(result.discharge_time);  
            $('#discharge_branch1').val(result.discharge_branch);   
            
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for discharge
function view() {  
    
    var empObj = {
        discharge_id: $('#discharge_id1').val(),
        admit_id: $('#admit_id1').val(),  
        discharge_reason: $('#discharge_reason1').val(),
        ward_id: $('#ward_id1').val(),  
        discharge_date: $('#discharge_date1').val(),
        discharge_time: $('#discharge_time1').val(),  
        discharge_branch: $('#discharge_branch1').val(),  
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
            $('#discharge_id1').val("");  
            $('#admit_id1').val("");  
            $('#discharge_reason1').val("");  
            $('#ward_id1').val("");  
            $('#discharge_date1').val("");  
            $('#discharge_time1').val("");  
            $('#discharge_branch1').val("");
        
        },  
         
    });  
}
  
   
//function for updating discharge's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
        discharge_id: $('#discharge_id').val(),
        admit_id: $('#admit_id').val(),  
        discharge_reason: $('#discharge_reason').val(),
        ward_id: $('#ward_id').val(),  
        discharge_date: $('#discharge_date').val(),
        discharge_time: $('#discharge_time').val(),  
        discharge_branch: $('#discharge_branch').val(),  
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
    
            $('#admit_id').val("");  
            $('#discharge_reason').val("");  
            $('#ward_id').val("");  
            $('#discharge_date').val("");  
            $('#discharge_time').val("");  
            $('#discharge_branch').val("");
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



  
//function for deleting discharge's record  
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/discharge-json/" + id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Admit Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Admit Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#discharge_id').val("");  
            $('#admit_id').val("");  
            $('#discharge_reason').val("");  
            $('#ward_id').val("");  
            $('#discharge_date').val("");  
            $('#discharge_time').val("");  
            $('#discharge_branch').val("")
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#admit_id').css('border-color', 'lightgrey');  
    $('#discharge_reason').css('border-color', 'lightgrey');  
    $('#ward_id').css('border-color', 'lightgrey');  
    $('#discharge_date').css('border-color', 'lightgrey');  
    $('#discharge_time').css('border-color', 'lightgrey');  
    $('#discharge_branch').css('border-color', 'lightgrey'); 
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
    if ($('#discharge_reason').val().trim() == "") {  
        $('#discharge_reason').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#discharge_reason').css('border-color', 'lightgrey');  
    }
    if ($('#ward_id').val().trim() == "") {  
        $('#ward_id').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#ward_id').css('border-color', 'lightgrey');  
    }
     if ($('#discharge_date').val().trim() == "") {  
        $('#discharge_date').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#discharge_date').css('border-color', 'lightgrey');  
    }
    
     if ($('#discharge_time').val().trim() == "") {  
        $('#discharge_time').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#discharge_time').css('border-color', 'lightgrey');  
    }
     if ($('#discharge_branch').val().trim() == "") {  
        $('#discharge_branch').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#discharge_branch').css('border-color', 'lightgrey');  
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
  
