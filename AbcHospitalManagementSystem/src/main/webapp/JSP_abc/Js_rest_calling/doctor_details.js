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
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/",  
        type: "GET",  
        contentType: "application/json; charset=utf-8",  
        dataType: "json",  
        success: function (result) {  
            var html = '';  
            $.each(result, function (key, item) {  
                html += '<tr>';  
                html += '<td>' + item.doc_id + '</td>';  
                html += '<td>' + item.doc_firstname +" " + item.doc_lastname + '</td>';  
                html += '<td>' + item.specilization + '</td>'; 

                html += '<td style="position:right"><a class="btn btn-success btn-icon-split btn-sm" href="#" onclick="return getbyview(' + item.doc_id + ')"><span class="text"> View</span></a> |<a class="btn btn-primary btn-icon-split btn-sm" href="#" onclick="return getbyID(' + item.doc_id + ')"><span class="text"><i class="fas fa-edit"></i> Edit</span></a> | <a class="btn btn-danger  btn-icon-split btn-sm " href="#" onclick="Delele(' + item.doc_id + ')"><span class="text"><i class="fas fa-trash"></i> Delete</span></a></td>';  
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
   //     url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/",  
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


  
//Add Data Function for doctor  
function Add() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    var empObj = {  
          
        doc_firstname: $('#doc_firstname').val(),  
        doc_lastname: $('#doc_lastname').val(),
        doc_dateofbirth: $('#doc_dateofbirth').val(),  
        doc_nic_no: $('#doc_nic_no').val(),
        doc_sex: $('#doc_sex').val(),  
        doc_phone_no: $('#doc_phone_no').val(),  
        doc_address: $('#doc_address').val(),  
        specilization: $('#specilization').val(),  
        doc_department: $('#doc_department').val(),  
        branch: $('#branch').val(),  
        
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/",  
        data: JSON.stringify(empObj),  
        type: "POST",  
        contentType: "application/json; charset=utf-8",  
        cache: false,
        success: function (result) {  
         swal({title: "Doctor Add!",
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
  
//Function for getting the Data Based upon doctor ID  
function getbyID(doc_id) {
    
    
    $('#doc_firstname').css('border-color', 'lightgrey');  
    $('#doc_lastname').css('border-color', 'lightgrey');  
    $('#doc_dateofbirth').css('border-color', 'lightgrey');  
    $('#doc_nic_no').css('border-color', 'lightgrey');  
    $('#doc_sex').css('border-color', 'lightgrey');  
    $('#doc_phone_no').css('border-color', 'lightgrey');  
    $('#doc_address').css('border-color', 'lightgrey');  
    $('#specilization').css('border-color', 'lightgrey');  
    $('#doc_department').css('border-color', 'lightgrey');  
    $('#branch').css('border-color', 'lightgrey');  
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/" + doc_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
            $('#doc_id').val(result.doc_id);  
            $('#doc_firstname').val(result.doc_firstname);  
            $('#doc_lastname').val(result.doc_lastname);  
            $('#doc_dateofbirth').val(result.doc_dateofbirth);  
            $('#doc_nic_no').val(result.doc_nic_no);  
            $('#doc_sex').val(result.doc_sex);  
            $('#doc_phone_no').val(result.doc_phone_no);  
            $('#doc_address').val(result.doc_address);  
            $('#specilization').val(result.specilization);  
            $('#doc_department').val(result.doc_department);  
            $('#branch').val(result.branch);  
         
            
            
  
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
//get doctor view details 
function getbyview(doc_id) {  
    $('#doc_firstname1').css('border-color', 'lightgrey');  
    $('#doc_lastname1').css('border-color', 'lightgrey');  
    $('#doc_dateofbirth1').css('border-color', 'lightgrey');  
    $('#doc_nic_no1').css('border-color', 'lightgrey');  
    $('#doc_sex1').css('border-color', 'lightgrey');  
    $('#doc_phone_no1').css('border-color', 'lightgrey');  
    $('#doc_address1').css('border-color', 'lightgrey');  
    $('#specilization1').css('border-color', 'lightgrey');  
    $('#doc_department1').css('border-color', 'lightgrey');  
    $('#branch1').css('border-color', 'lightgrey');  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/" + doc_id,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
             $('#doc_id1').val(result.doc_id);  
            $('#doc_firstname1').val(result.doc_firstname);  
            $('#doc_lastname1').val(result.doc_lastname);  
            $('#doc_dateofbirth1').val(result.doc_dateofbirth);  
            $('#doc_nic_no1').val(result.doc_nic_no);  
            $('#doc_sex1').val(result.doc_sex);  
            $('#doc_phone_no1').val(result.doc_phone_no);  
            $('#doc_address1').val(result.doc_address);  
            $('#specilization1').val(result.specilization);  
            $('#doc_department1').val(result.doc_department);  
            $('#branch1').val(result.branch); 
            
        
  
            $('#1myModal').modal('show');  
            $('#btnview').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 
  // get view details for doctor
function view() {  
    
    var empObj = {  
        doc_id: $('#doc_id1').val(),  
        doc_firstname: $('#doc_firstname1').val(),
        doc_lastname: $('#doc_lastname1').val(),
        doc_dateofbirth: $('#doc_dateofbirth1').val(),
        doc_nic_no: $('#doc_nic_no1').val(),  
        doc_sex: $('#doc_sex1').val(),  
        doc_phone_no: $('#doc_phone_no1').val(),  
        doc_address: $('#doc_address1').val(),  
        specilization: $('#specilization1').val(),  
        doc_department: $('#doc_department1').val(),  
        branch: $('#branch1').val(),   
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
           $('#doc_id1').val("");  
    $('#doc_firstname1').val("");  
    $('#doc_lastname1').val("");
    $('#doc_dateofbirth1').val("");  
    $('#doc_nic_no1').val("");  
    $('#doc_sex1').val(""); 
    $('#doc_phone_no1').val("");  
    $('#doc_address1').val("");  
    $('#specilization1').val(""); 
    $('#doc_department1').val("");  
    $('#branch1').val("");  
        
        },  
         
    });  
}
  
   
//function for updating doctor's record  
function Update() {  
    var res = validate();  
    if (res == false) {  
        return false;  
    }  
    
    
    
    
    var empObj = {  
        doc_id: $('#doc_id').val(),  
        doc_firstname: $('#doc_firstname').val(),
        doc_lastname: $('#doc_lastname').val(),
        doc_dateofbirth: $('#doc_dateofbirth').val(),
        doc_nic_no: $('#doc_nic_no').val(),  
        doc_sex: $('#doc_sex').val(),  
        doc_phone_no: $('#doc_phone_no').val(),  
        doc_address: $('#doc_address').val(),  
        specilization: $('#specilization').val(),  
        doc_department: $('#doc_department').val(),  
        branch: $('#branch').val(),  
         
          
    };  
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/",  
        data: JSON.stringify(empObj),  
        type: "PUT",  
        contentType: "application/json; charset=utf-8",  
          
        success: function (result) {  
            loadData();  
            $('#myModal').modal('hide');  
              
             
    $('#doc_firstname').val("");  
    $('#doc_lastname').val("");
    $('#doc_dateofbirth').val("");  
    $('#doc_nic_no').val("");  
    $('#doc_sex').val(""); 
    $('#doc_phone_no').val("");  
    $('#doc_address').val("");  
    $('#specilization').val(""); 
    $('#doc_department').val("");  
    $('#branch').val(""); 
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



  
//function for deleting doctor's record  
function Delele(doc_id) {
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
            url: "http://localhost:8080/AbcHospitalManagementSystem/service/doctor-json/" + doc_id,  
            type: "DELETE",  
            contentType: "application/json; charset=utf-8",  
              
            success: function (result) {  
                loadData();
    swal("Poof! Doctor Infomation has been deleted!", {
      icon: "success",
    });
            },  
            error: function (errormessage) {  
                alert(errormessage.responseText);
                location.reload(true);
            }  
        });
      
    
  } else {
    swal("The Doctor Infomation is safe!");
  }
});
    
  
}  
 
//Function for clearing the textboxes  
function clearTextBox() {  
    $('#doc_id').val("");  
    $('#doc_firstname').val("");  
    $('#doc_lastname').val("");
    $('#doc_dateofbirth').val("");  
    $('#doc_nic_no').val("");  
    $('#doc_sex').val(""); 
    $('#doc_phone_no').val("");  
    $('#doc_address').val("");  
    $('#specilization').val(""); 
    $('#doc_department').val("");  
    $('#branch').val("");  
    
    
    
    
     
    $('#btnUpdate').hide();  
    $('#btnAdd').show();  
    $('#doc_firstname').css('border-color', 'lightgrey');  
    $('#doc_lastname').css('border-color', 'lightgrey');  
    $('#doc_dateofbirth').css('border-color', 'lightgrey');  
    $('#doc_nic_no').css('border-color', 'lightgrey');
    $('#doc_sex').css('border-color', 'lightgrey');  
    $('#doc_phone_no').css('border-color', 'lightgrey'); 
    $('#doc_address').css('border-color', 'lightgrey');  
    $('#specilization').css('border-color', 'lightgrey');
    $('#doc_department').css('border-color', 'lightgrey');  
    $('#branch').css('border-color', 'lightgrey'); 
}  
//Valdidation using jquery  
function validate() {  
   var isValid = true;  
    if ($('#doc_firstname').val().trim() == "") {  
        $('#doc_firstname').css('border-color', 'Red');  
        isValid = false;  
    }  
    else {  
        $('#doc_firstname').css('border-color', 'lightgrey');  
    }  
    if ($('#doc_lastname').val().trim() == "") {  
        $('#doc_lastname').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_lastname').css('border-color', 'lightgrey');  
    }
    if ($('#doc_dateofbirth').val().trim() == "") {  
        $('#doc_dateofbirth').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_dateofbirth').css('border-color', 'lightgrey');  
    }
     if ($('#doc_nic_no').val().trim() == "") {  
        $('#doc_nic_no').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_nic_no').css('border-color', 'lightgrey');  
    }
    
     if ($('#doc_phone_no').val().trim() == "") {  
        $('#doc_phone_no').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_phone_no').css('border-color', 'lightgrey');  
    }
     if ($('#doc_address').val().trim() == "") {  
        $('#doc_address').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_address').css('border-color', 'lightgrey');  
    }
     if ($('#specilization').val().trim() == "") {  
        $('#specilization').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#specilization').css('border-color', 'lightgrey');  
    }
    if ($('#doc_department').val().trim() == "") {  
        $('#doc_department').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_department').css('border-color', 'lightgrey');  
    }
    if ($('#doc_sex').val().trim() == "") {  
        $('#doc_sex').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#doc_sex').css('border-color', 'lightgrey');  
    }
    if ($('#branch').val().trim() == "") {  
        $('#branch').css('border-color', 'Red');  
        isValid = false;  
    }
    
    else {  
        $('#branch').css('border-color', 'lightgrey');  
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
  
