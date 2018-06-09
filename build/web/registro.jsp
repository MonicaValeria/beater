<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/contractor.css" type="text/css">
    <script src="theme/bootstrap/dist/js/bootstrap.min.js"></script>
    
    <title>BEATER</title>
</head>

<body style="background-color:#343a40;">
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#"><b>BEATER</b></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-right justify-content-end" id="navbar2SupportedContent">           
            <a href="login.jsp"class="btn navbar-btn ml-2 text-white btn-secondary"><i class="fa d-inline fa-lg fa-user-circle-o"></i>&nbsp;Login</a>
        </div>
    </div>
</nav>
<div class="py-5" style="background-image: url(images/background-slide-inv.jpg);">
    <div class="container">
        <div class="row">
            <div class="align-self-center col-md-6 text-white">
                <h2 class="text-center" contenteditable="true">Conecta con músicos, managers y empresas!</h2>
                <h4 class="text-center" contenteditable="true"><p>Podras crear una convocatoria abierta para artistas nacionales, invitándolos a participar del proceso de evaluación. La plataforma te permitira hacer una selección responsable de forma agil, rapida, sencilla y amable, y conectar con los perfiles de cada una de las bandas. </p></h4>
            </div>
            <div class="col-md-6" id="book">
                <div class="card">
                    <div class="card text-white p-5 bg-dark">
                        <div class="card-body">
                            <h2 class="mb-4" contenteditable="true">Registro</h2>
                            <form id="reg_form" name="formregistro" action="ServletRegistro" method="post">
                                 <div class="form-group">
                                    <label>Crear usuario:</label>
                                    <input type="text" class="form-control" placeholder="Ingrese usuario" id="user" name="user">
                                 </div>
                                  <div class="form-group">
                                    <label>Contraseña:</label>
                                    <input type="password" class="form-control" placeholder="Ingrese una contraseña" id="pass" name="pass">
                                  </div>
                                  <div class="form-group">
                                    <label>Confirmar contraseña:</label>
                                    <input type="password" class="form-control" placeholder="Confirmar" id="pass2" name="pass2">                                    
                                  </div>
                                
                                    <div class="form-group">
                                        <label>Registrarse como:</label>
                                        <select class="form-control" name="type">
                                          <option value="2">Contratista</option>
                                          <option value="3">Banda</option>
                                          <option value="4">Musico</option>
                                        </select>
                                      </div>
                                
                                  <div class="form-group">
                                    <label>Nombre:</label>
                                    <input type="text" class="form-control" placeholder="Ingrese su nombre" id="name" name="name">                                    
                                  </div>
                                  <div class="form-group">
                                      <label> Correo de contacto:</label>
                                    <input type="text" class="form-control" placeholder="Ingrese su nombre" id="correo" name="correo">                                    
                                  </div>                              
                                    <input type="hidden" class="form-control" placeholder="Ingrese un apellido" id="ape" name="ape">
                                  <div class="form-group align-center">
                                    <input class="btn btn-info" type="reset" value="Borrar Información">
                                    <button type="submit" class="btn btn-secondary">Registrar</button>  
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
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
<script type="text/javascript"> 
   $(document).ready(function() {
    $('#reg_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            user: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Por favor, ingresar un usuario'
                    }
                }
            },
             name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Por favor, ingresar un nombre'
                    }
                }
            },
           
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    },
                    phone: {
                        country: 'US',
                        message: 'Please supply a vaild phone number with area code'
                    }
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
                validators: {
                     stringLength: {
                        min: 4,
                    },
                    notEmpty: {
                        message: 'Please supply your city'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Please select your state'
                    }
                }
            },
            zip: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your zip code'
                    },
                    zipCode: {
                        country: 'US',
                        message: 'Please supply a vaild zip code'
                    }
                }
            },
		comment: {
                validators: {
                      stringLength: {
                        min: 10,
                        max: 200,
                        message:'Please enter at least 10 characters and no more than 200'
                    },
                    notEmpty: {
                        message: 'Please supply a description about yourself'
                    }
                    }
                 },	
	 correo: {
                validators: {
                    notEmpty: {
                        message: 'Ingrese correo de contacto'
                    },
                    emailAddress: {
                        message: 'Es importante que el correo sea válido    '
                    }
                }
            },
					
	pass: {
            validators: {
                identical: {
                    field: 'pass2',
                    message: 'Confirme la contraseña en el siguiente campo'
                }
            }
        },
        pass2: {
            validators: {
                identical: {
                    field: 'pass',
                    message: 'Las contraseñas no coinciden'
                }
            }
         },
			
            
            }
        })
		
 	
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#reg_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
}); 
 </script>        
</body>
</html>
