<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/contractor.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="assets/css/bootstrap-united.css" rel="stylesheet" />
    <title>CONTRATISTA | BEATER </title>
</head>

<body style="background-color:#343a40;">
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#"><b>CONTRATISTA | BEATER</b></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-right justify-content-end" id="navbar2SupportedContent">
            <a href="index.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span>&nbsp;Inicio</a>
            <a href="contactus.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-envelope"></span>&nbsp;Contactanos</a>
            <a class="btn navbar-btn ml-2 text-white btn-secondary"><i class="fa d-inline fa-lg fa-user-circle-o"></i>&nbsp;Login</a>
        </div>
    </div>
</nav>
<div class="py-5" style="background-image: url(images/disco.jpg);">
    <div class="container">
        <div class="row">            
            <div class="col-md-6" id="book">
                <div class="card">
                    <div class="card text-white p-5 bg-dark">
                        <div class="card-body">
                            <h2 class="mb-4" contenteditable="true">Crear evento</h2>
                            <form name="formregistro" action="ServletCreateEvent" method="post">
                                 <div class="form-group">
                                    <label>Nombre del evento</label>
                                    <input type="text" class="form-control" placeholder="Ingrese nombre" id="nom_ev" name="nom_ev">
                                 </div>
                                  <div class="form-group">
                                    <label>Día de inicio del evento</label>
                                    <input type="text" class="form-control" placeholder="DD/MM/AAAA" id="start_ev" name="start_ev">
                                  </div>
                                  <div class="form-group">
                                    <label>Día de fin del evento</label>
                                    <input type="text" class="form-control" placeholder="DD/MM/AAAA" id="end_ev" name="end_ev">                                    
                                  </div>
                                  <div class="form-group">
                                    <label>Lugar del evento</label>
                                    <input type="text" class="form-control" placeholder="Ingrese lugar" id="place" name="place">                                    
                                  </div>
                                <div class="form-group">
                                    <label>Descripción</label>
                                    <input type="text" class="form-control" placeholder="Ingrese una descripción" id="des" name="des">                                    
                                  </div>
           
                                  <div class="form-group align-center">
                                    <input class="btn btn-info" type="reset" value="Borrar Información">
                                    <button type="submit" class="btn btn-secondary">Crear</button>  
                                  </div>
                                  
                            </form>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="py-5 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <form class="form-inline">
                    <div class="form-group"></div>
                </form>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://www.facebook.com" target="_blank"><i class="fa fa-fw fa-facebook fa-3x text-white"></i></a>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://twitter.com" target="_blank"><i class="fa fa-fw fa-twitter fa-3x text-white"></i></a>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://www.instagram.com" target="_blank"><i class="fa fa-fw fa-instagram text-white fa-3x"></i></a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 mt-3 text-center">
                <p>© Copyright 2017 Fuera del Garage - All rights reserved.</p>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
