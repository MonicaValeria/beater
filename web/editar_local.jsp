<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.application.bean.Local"%>
<%@page import="com.application.dao.DAOLocal"%>
<%  int id_local = (Integer) session.getAttribute("id_local");
    int id = (Integer) session.getAttribute("id");
    String nom_local = (String) session.getAttribute("nom_local");
    String direc = (String) session.getAttribute("direc");
    String ref = (String) session.getAttribute("ref");
    String telf = (String) session.getAttribute("telf");
    String hora_ini = (String) session.getAttribute("hora_ini");
    String hora_fin = (String) session.getAttribute("hora_fin");
    int type = (Integer) session.getAttribute("type");
    String nombre = (String) session.getAttribute("nombre");
    String ape = (String) session.getAttribute("ape");
    String user = (String) session.getAttribute("user");
 %>
  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="css/contractor.css" type="text/css">
  <script src="theme/bootstrap/dist/js/bootstrap.min.js"></script>
  <title>BEATER</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="theme/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="theme/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="theme/Ionicons/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="theme/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="theme/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="theme/plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="theme/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="theme/plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="theme/select2/dist/css/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="theme/dist/css/AdminLTE.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="theme/jvectormap/jquery-jvectormap.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="theme/dist/css/skins/_all-skins.min.css">
  
  
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>B</span>
      <!-- logo for regular state and mobile devices -->

      <% if(type==1){
          out.print("<span class='logo-lg'><b>BEATER</b>admnistrador</span>");
      }else if(type==2){
          out.print("<span class='logo-lg'><b>BEATER</b>contratista</span>");
      }else if(type==3){
          out.print("<span class='logo-lg'><b>BEATER</b>banda</span>");
      }else{
          out.print("<span class='logo-lg'><b>BEATER</b>musico</span>");
      }
      
      %>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          
          <!-- Notifications: style can be found in dropdown.less -->

          <!-- Tasks: style can be found in dropdown.less -->

          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="images/pos.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"><%=user%></span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="images/pos.jpg" class="img-circle" alt="User Image">

                <p>
                   
                  <% if(type==1){
                        out.print("<small>ADMINISTRADOR</small>");
                    }else if(type==2){
                        out.print("<small>CONTRATISTA</small>");
                    }else if(type==3){
                        out.print("<small>BANDA</small>");
                    }else{
                        out.print("<small>MÚSICO</small>");
                    }%>                                                                                 
                </p>
              </li>
              <!-- Menu Body -->

              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="index.jsp" class="btn btn-default btn-flat">Perfil</a>
                </div>
                <div class="pull-right">
                  <a href="beater.jsp" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->

        </ul>
      </div>

    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="images/pos.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>user</p>
                  
        </div>
      </div>
             
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Principal navegación</li>
       
       
     
            
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       PANEL DE LOCALES        
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        
      <!-- Info boxes -->
      <div class="row">
        <div class="col-md-12">
          <div class="box box-default">
            

 <!-- Profile Image -->
                    
        <div class="box box-primary">
         
            <div class="box-body box-profile">
            <p class="text-muted text-center">Editar local</p>  
            
            <!-- Editar perfil contratista  -->        
            <form class="form-horizontal" id="reg_form" name="formregistro" action="ServletUpdateLocalById" method="post">                
              <div class="box-body">
                   
          
                <input type="hidden" class="form-control" id="id_local" name="id_local" value="<%=id_local%>">
                <input type="hidden" class="form-control" id="id" name="id" value="<%=id%>">
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Nombre del local:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="nom_local" name="nom_local" value="<%=nom_local%>" >
                  </div>
                </div>                 
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Dirección:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="direc" name="direc" value="<%=direc%>" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Referencia:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="ref" name="ref" value="<%=ref%>" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Teléfono:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="telf" name="telf" value="<%=telf%>" >
                  </div>
                </div>
                  <div class="form-group"> <label>Elija los días de atención:</label>                                    
                  <div class="row">                     
                    <div class="col-md-3">                       
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Lunes">Lunes
                          </label>
                        </div>
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Martes">Martes
                          </label>
                        </div>
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Miercoles">Miércoles
                          </label>
                        </div>
                    </div>
                    <div class="col-md-3">                       
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Jueves">Jueves
                          </label>
                        </div>
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Viernes">Viernes
                          </label>
                        </div>
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Sabado">Sábado
                          </label>
                        </div>                      
                    </div>
                    <div class="col-md-3">
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="dias" value="Domingo">Domingo
                          </label>
                        </div>
                    </div>    
                  </div> 
                 </div>  
                  
                 <div class="bootstrap-timepicker">
                    <div class="bootstrap-timepicker-widget dropdown-menu">
                        <table>
                            <tbody>
                                <tr>
                                    <td><a href="#" data-action="incrementHour">
                                            <i class="glyphicon glyphicon-chevron-up"></i>
                                        </a>
                                    </td>
                                    <td class="separator">&nbsp;</td>
                                    <td><a href="#" data-action="incrementMinute">
                                            <i class="glyphicon glyphicon-chevron-up"></i>
                                        </a>
                                    </td>
                                    <td class="separator">&nbsp;</td>
                                    <td class="meridian-column">
                                        <a href="#" data-action="toggleMeridian">
                                            <i class="glyphicon glyphicon-chevron-up"></i>
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span class="bootstrap-timepicker-hour">11</span></td> 
                                    <td class="separator">:</td>
                                    <td><span class="bootstrap-timepicker-minute">15</span></td> 
                                    <td class="separator">&nbsp;</td>
                                    <td><span class="bootstrap-timepicker-meridian">PM</span></td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#" data-action="decrementHour">
                                            <i class="glyphicon glyphicon-chevron-down"></i>
                                        </a>
                                    </td>
                                    <td class="separator"></td>
                                    <td><a href="#" data-action="decrementMinute">
                                            <i class="glyphicon glyphicon-chevron-down"></i>
                                        </a>
                                    </td>
                                    <td class="separator">&nbsp;</td>
                                    <td>
                                        <a href="#" data-action="toggleMeridian">
                                            <i class="glyphicon glyphicon-chevron-down"></i>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-group">
                      <label>Desde:</label>

                      <div class="input-group">
                        <input type="text" class="form-control timepicker" name="hora_inicio">

                        <div class="input-group-addon">
                          <i class="fa fa-clock-o"></i>
                        </div>
                      </div>
                      <!-- /.input group -->
                    </div>
                    <!-- /.form group -->
                </div>

                 <div class="bootstrap-timepicker">
                    <div class="bootstrap-timepicker-widget dropdown-menu">
                        <table>
                            <tbody>
                                <tr>
                                    <td><a href="#" data-action="incrementHour">
                                            <i class="glyphicon glyphicon-chevron-up"></i>
                                        </a>
                                    </td>
                                    <td class="separator">&nbsp;</td>
                                    <td><a href="#" data-action="incrementMinute">
                                            <i class="glyphicon glyphicon-chevron-up"></i>
                                        </a>
                                    </td>
                                    <td class="separator">&nbsp;</td>
                                    <td class="meridian-column">
                                        <a href="#" data-action="toggleMeridian">
                                            <i class="glyphicon glyphicon-chevron-up"></i>
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span class="bootstrap-timepicker-hour">11</span></td> 
                                    <td class="separator">:</td>
                                    <td><span class="bootstrap-timepicker-minute">15</span></td> 
                                    <td class="separator">&nbsp;</td>
                                    <td><span class="bootstrap-timepicker-meridian">PM</span></td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#" data-action="decrementHour">
                                            <i class="glyphicon glyphicon-chevron-down"></i>
                                        </a>
                                    </td>
                                    <td class="separator"></td>
                                    <td><a href="#" data-action="decrementMinute">
                                            <i class="glyphicon glyphicon-chevron-down"></i>
                                        </a>
                                    </td>
                                    <td class="separator">&nbsp;</td>
                                    <td>
                                        <a href="#" data-action="toggleMeridian">
                                            <i class="glyphicon glyphicon-chevron-down"></i>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-group">
                      <label>Hasta:</label>

                      <div class="input-group">
                        <input type="text" class="form-control timepicker" name ="hora_fin">

                        <div class="input-group-addon">
                          <i class="fa fa-clock-o"></i>
                        </div>
                      </div>
                      <!-- /.input group -->
                    </div>
                    <!-- /.form group -->
                </div>
                
                
               
              </div>
              
              <div>
                <button type="submit" class="btn btn-info pull-right">Actualizar</button>
              </div>
            </form>
                  
                  
                  
            </div>
               
        </div>
                     
     <!--FIN EITAR PERFIL CONTRATISTA -->
            
          </div>
        </div>
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">

   BEATER
  </footer>

  <!-- Control Sidebar -->

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
 

</div>
<!-- ./wrapper -->
<!-- jQuery 3 -->
<script src="theme/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="theme/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="theme/select2/dist/js/select2.full.min.js"></script>
<!-- InputMask -->
<script src="theme/plugins/input-mask/jquery.inputmask.js"></script>
<script src="theme/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="theme/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="theme/moment/min/moment.min.js"></script>
<script src="theme/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="theme/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- bootstrap color picker -->
<script src="theme/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="theme/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll -->
<script src="theme/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="theme/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="theme/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="theme/dist/js/adminlte.min.js"></script>
<!-- Sparkline -->
<script src="theme/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap  -->
<script src="theme/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="theme/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- ChartJS -->
<script src="theme/chart.js/Chart.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="theme/dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="theme/dist/js/demo.js"></script>
<link href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" rel="stylesheet"></link>

 
<script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>


<script> 
    $('#loginForm').bootstrapValidator({
 
	 message: 'Este valor no es valido',
 
	 feedbackIcons: {
 
		 valid: 'glyphicon glyphicon-ok',
 
		 invalid: 'glyphicon glyphicon-remove',
 
		 validating: 'glyphicon glyphicon-refresh'
 
	 },
 
	 fields: {
 
		 nom_lo: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El nombre de usuario es requerido'
 
				 }
 
			 }
 
		 },
                 add: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El nombre de usuario es requerido'
 
				 }
 
			 }
 
		 },
                 ref: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El nombre de usuario es requerido'
 
				 }
 
			 }
 
		 },
                 telf: {
 
			 message: 'El teléfono no es valido',
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El teléfono es requerido y no puede ser vacio'
 
				 },
 
				 regexp: {
 
					 regexp: /^[0-9]+$/,
 
					 message: 'El teléfono solo puede contener números'
 
				 }
 
			 }
 
		 },
                 hora_inicio: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El nombre de usuario es requerido'
 
				 }
 
			 }
 
		 },
                 hora_fin: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El nombre de usuario es requerido'
 
				 }
 
			 }
 
		 },
		 password: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'La contraseña es requerida'
 
				 }
 
			 }
 
		 }
 
	 }
 
});
 </script>
  <script>
      $(function () {
        //Initialize Select2 Elements
        $('.select2').select2()

        //Datemask dd/mm/yyyy
        $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
        //Datemask2 mm/dd/yyyy
        $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
        //Money Euro
        $('[data-mask]').inputmask()

        //Date range picker
        $('#reservation').daterangepicker()
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' })
        //Date range as a button
        $('#daterange-btn').daterangepicker(
          {
            ranges   : {
              'Today'       : [moment(), moment()],
              'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
              'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
              'Last 30 Days': [moment().subtract(29, 'days'), moment()],
              'This Month'  : [moment().startOf('month'), moment().endOf('month')],
              'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            },
            startDate: moment().subtract(29, 'days'),
            endDate  : moment()
          },
          function (start, end) {
            $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
          }
        )

        //Date picker
        $('#datepicker').datepicker({
          autoclose: true
        })

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
          checkboxClass: 'icheckbox_minimal-blue',
          radioClass   : 'iradio_minimal-blue'
        })
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
          checkboxClass: 'icheckbox_minimal-red',
          radioClass   : 'iradio_minimal-red'
        })
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
          checkboxClass: 'icheckbox_flat-green',
          radioClass   : 'iradio_flat-green'
        })

        //Colorpicker
        $('.my-colorpicker1').colorpicker()
        //color picker with addon
        $('.my-colorpicker2').colorpicker()

        //Timepicker
        $('.timepicker').timepicker({
          showInputs: false
        })
      })
    </script>     
   
</body>
</html>
