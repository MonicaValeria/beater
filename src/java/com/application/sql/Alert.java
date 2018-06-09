package com.application.sql;

/**
 *
 * @author Monica
 */
public class Alert {
    
    public String AlertError(String titulo, String msg, String tipo){
        String alert = "";
        alert += "<script src='js/sweet-alert.min.js'></script> \n";
        alert += "<script src='theme/jquery/dist/jquery.min.js'></script> \n";
        alert += "<link rel='stylesheet' href='css/sweet-alert.css'> \n";        
        alert += "<script type='text/javascript'> \n";
        alert += "$(document).ready(function(){ \n";
        alert += "swal({ \n";
        alert += "title:'"+ titulo +"', \n";
        alert += "text:'"+ msg +"', \n";
        alert += "type: '"+ tipo +"', \n";
        alert += "confirmButtonText: 'Aceptar'}); \n";
        alert += "}); \n";
        alert += "</script>";   
    return alert; 
    }
    
}
