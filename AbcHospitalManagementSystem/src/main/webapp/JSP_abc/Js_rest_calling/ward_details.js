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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/ward-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.ward_id + '</td>';  
                html += '<td>' + item.ward_no +'</td>';
                html += '<td>'+  item.ward_type + '</td>';
                html += '<td>'+  item.ward_status + '</td>';

                html += '<td style="position:right"><a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.ward_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.ward_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
                html += '</tr>';  
            });  
            $('.tbody').html(html);  
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
}  



  
//Add Data Function for ward  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        ward_no: $('#ward_no').val(),  
        ward_type: $('#ward_type').val(),
        ward_status: $('#ward_status').val(),  
          
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/ward-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Ward Add!",
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
  
//Function for getting the Data Based upon ward ID  
function getbyID(ward_id) {
    
    
    $('#ward_no').css('border-color', 'lightgrey');  
    $('#ward_type').css('border-color', 'lightgrey');  
    $('#ward_status').css('border-color', 'lightgrey');  
    
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/ward-json/" + ward_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#ward_id').val(result.ward_id);  
            $('#ward_no').val(result.ward_no);  
            $('#ward_type').val(result.ward_type);  
            $('#ward_status').val(result.ward_status);  
             
         
            
            
  
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

  
   
//function for updating ward's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
        ward_id: $('#ward_id').val(),  
        ward_no: $('#ward_no').val(),
        ward_type: $('#ward_type').val(),
        ward_status: $('#ward_status').val(),
         
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/ward-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
    $('#ward_no').val("");  
    $('#ward_type').val("");
    $('#ward_status').val(""); 
     
     swal({title: "Ward updated!",
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



  
//function for deleting ward's record  
function Delele(ward_id) {
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/ward-json/" + ward_id,  
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
    swal("The Ward Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#ward_id').val("");  
    $('#ward_no').val("");  
    $('#ward_type').val("");
    $('#ward_status').val("");  
      
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#ward_no').css('border-color', 'lightgrey');  
    $('#ward_type').css('border-color', 'lightgrey');  
     ('#ward_status').css('border-color', 'lightgrey'); 
     
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#ward_no').val().trim() == "") {  
        $('#ward_no').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#ward_no').css('border-color', 'lightgrey');  
    }  
    if ($('#ward_type').val().trim() == "") {  
        $('#ward_type').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#ward_type').css('border-color', 'lightgrey');  
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
  


