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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.medicine_id + '</td>';  
                html += '<td>' + item.medicine_name +'</td>';  
                html += '<td>' + item.medicine_price + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.medicine_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.medicine_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.medicine_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
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
   //     url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/",  
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


  
//Add Data Function for medicine  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var medObj = {  
          
        medicine_name: $('#medicine_name').val(),  
        medicine_code: $('#medicine_code').val(),
        medicine_price: $('#medicine_price').val(),
        medicine_qty: $('#medicine_qty').val(),  

    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/",  
        data: JSON.stringify(medObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Medicine Add!",
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
  
//Function for getting the Data Based upon medicine ID  
function getbyID(id) {
  
    $('#medicine_name').css('border-color', 'lightgrey');  
    $('#medicine_code').css('border-color', 'lightgrey');  
   $('#medicine_price').css('border-color', 'lightgrey');  
    $('#medicine_qty').css('border-color', 'lightgrey');  
     
      
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#medicine_id').val(result.medicine_id);  
            $('#medicine_name').val(result.medicine_name);  
            $('#medicine_code').val(result.medicine_code);  
            $('#medicine_price').val(result.medicine_price);  
            $('#medicine_qty').val(result.medicine_qty);  
            
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
//get medicine view details 
function getbyview(id) {  
    
      
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/" + id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
           $('#medicine_id1').val(result.medicine_id);  
            $('#medicine_name1').val(result.medicine_name);  
            $('#medicine_code1').val(result.medicine_code);  
            
            $('#medicine_price1').val(result.medicine_price);  
            $('#medicine_qty1').val(result.medicine_qty);  
               
            
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for medicine
function view() {  
    
    var medObj = {
        medicine_id: $('#medicine_id1').val(),
        medicine_name: $('#medicine_name1').val(),  
        medicine_code: $('#medicine_code1').val(),
         
        medicine_price: $('#medicine_price1').val(),
        medicine_qty: $('#medicine_qty1').val(),  
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/",  
        data: JSON.stringify(medObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
            $('#medicine_id1').val("");  
            $('#medicine_name1').val("");  
            $('#medicine_code1').val("");  
              
            $('#medicine_price1').val("");  
            $('#medicine_qty1').val("");  
            
        
        },  
         
    });  
}
  
   
//function for updating medicine's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var medObj = {  
        medicine_id: $('#medicine_id').val(),
        medicine_name: $('#medicine_name').val(),  
        medicine_code: $('#medicine_code').val(),
        medicine_price: $('#medicine_price').val(),
        medicine_qty: $('#medicine_qty').val(),  
   };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/",  
        data: JSON.stringify(medObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
       success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
          $('#medicine_name').val("");  
            $('#medicine_code').val("");  
              
            $('#medicine_price').val("");  
            $('#medicine_qty').val("");  
            
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



  
//function for deleting medicine's record  
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/medicine-json/" + id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Medicine Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Medicine Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#medicine_id').val("");  
            $('#medicine_name').val("");  
            $('#medicine_code').val("");  
             
            $('#medicine_price').val("");  
            $('#medicine_qty').val("");  
            
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#medicine_name').css('border-color', 'lightgrey');  
    $('#medicine_code').css('border-color', 'lightgrey');  
      
    $('#medicine_price').css('border-color', 'lightgrey');  
    $('#medicine_qty').css('border-color', 'lightgrey');  
     
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#medicine_name').val().trim() == "") {  
        $('#medicine_name').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#medicine_name').css('border-color', 'lightgrey');  
    }  
    if ($('#medicine_code').val().trim() == "") {  
        $('#medicine_code').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#medicine_code').css('border-color', 'lightgrey');  
    }
    
     if ($('#medicine_price').val().trim() == "") {  
        $('#medicine_price').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#medicine_price').css('border-color', 'lightgrey');  
    }
    
     if ($('#medicine_qty').val().trim() == "") {  
        $('#medicine_qty').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#medicine_qty').css('border-color', 'lightgrey');  
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
  
