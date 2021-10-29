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
       url: "http://localhost:8080/AbcHospitalManagementSystem/service/statistics-json/",  
       type: "GET",  
       contentType: "application/json; charset=utf-8",  
       dataType: "json",  
        success: function (result) {  
           var total_user = '', total_doctor = '', total_patientreg = '', total_wards = '', total_wards_av = '', total_wards_tk = '', total_appoint = '', total_admit = '', total_discharge = '', total_curadmit = '', total_transfers = '', total_medicine = '', total_revenue = '';  
            $.each(result, function (key, item) {  
                 
                total_user += '<p id="#total_user">' + item.total_user + '</p>';
                total_doctor += '<p id="#total_doctor">' + item.total_doctor + '</p>';
                total_patientreg += '<p id="#total_patientreg">' + item.total_patientreg + '</p>';
                total_wards += '<p id="#total_wards">' + item.total_wards + '</p>';
                total_wards_av += '<p id="#total_wards_av">' + item.total_wards_av + '</p>';
                total_wards_tk += '<p id="#total_wards_tk">' + item.total_wards_tk + '</p>';
                total_appoint += '<p id="#total_appoint">' + item.total_appoint + '</p>';
                total_admit += '<p id="#total_admit">' + item.total_admit + '</p>';
                total_discharge += '<p id="#total_discharge">' + item.total_discharge + '</p>';
                total_curadmit += '<p id="#total_curadmit">' + item.total_curadmit + '</p>';
                total_transfers += '<p id="#total_user">' + item.total_transfers + '</p>';
                total_medicine += '<p id="#total_medicine">' + item.total_medicine + '</p>';
                total_revenue += '<p id="#total_revenue">'+' Rs: ' + item.total_revenue + '</p>';
            });  
            $('.total_user').html(total_user);
            $('.total_doctor').html(total_doctor);  
            $('.total_patientreg').html(total_patientreg);  
            $('.total_wards').html(total_wards);  
            $('.total_wards_av').html(total_wards_av);  
            $('.total_wards_tk').html(total_wards_tk);  
            $('.total_appoint').html(total_appoint);  
            $('.total_admit').html(total_admit);  
            $('.total_discharge').html(total_discharge);  
            $('.total_curadmit').html(total_curadmit);  
            $('.total_transfers').html(total_transfers); 
            $('.total_medicine').html(total_medicine); 
            $('.total_revenue').html(total_revenue); 
        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    }); }
  /*  function getbyview() {  
    
    $.ajax({  
        url: "http://localhost:8080/AbcHospitalManagementSystem/service/statistics-json/" ,  
        typr: "GET",  
        contentType: "application/json; charset=utf-8",  
         cache: false,
        success: function (result) {  
             $('#total_user').val(result.total_user);  
            $('#total_doctor').val(result.total_doctor);  
            $('#total_patientreg').val(result.total_patientreg);  
            $('#total_wards').val(result.total_wards);  
            $('#total_wards_av').val(result.total_wards_av);  
            $('#total_wards_tk').val(result.total_wards_tk);  
            $('#total_appoint').val(result.total_appoint);  
            $('#total_admit').val(result.total_admit);  
            $('#total_discharge').val(result.total_discharge);  
            $('#total_curadmit').val(result.total_curadmit);  
            $('#total_transfers').val(result.total_transfers); 
            $('#total_medicine').val(result.total_medicine); 
            $('#total_revenue').val(result.total_revenue); 
        
  
            $('#myModal').show();  

        },  
        error: function (errormessage) {  
            alert(errormessage.responseText);  
        }  
    });  
    return false;  
} 

*/