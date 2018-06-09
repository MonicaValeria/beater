
<%@page import="com.application.bean.MusicGenre"%>
<%@page import="com.application.dao.DAOMusicGenre"%>
<%@page import="com.application.bean.Local"%>
<%@page import="com.application.dao.DAOLocal"%>
<%@page import="com.application.bean.Event"%>
<%@page import="com.application.dao.DAOEvent"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int id = (Integer) session.getAttribute("id"); 
    String user = (String) session.getAttribute("user");
    String nombre = (String) session.getAttribute("nombre");
    String ape = (String) session.getAttribute("ape");
    int type = (Integer) session.getAttribute("type");
   %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
              <img src="theme/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"><%=user%></span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="theme/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  <%=nombre%> <%=ape%>
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
                  <a href="index.jsp" class="btn btn-default btn-flat">Profile</a>
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
          <img src="theme/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%=user%></p>
        </div>
      </div>
             
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Principal navegación</li>       
        <%if(type==2){%>
          <li> <a href="panel_locales.jsp"><i class="fa fa-th"></i> <span>LOCALES</span></a></li>
        <%}else{}%>
        <% if(type==2){%>
          <li><a href="panel_musicgenre.jsp"><i class="fa fa-book"></i> <span>GÉNERO MUSICAL</span></a></li>
        <%}else{} %> 
        <% if(type==2){%>
          <li><a href="panel_eventos.jsp"><i class="fa fa-book"></i> <span>EVENTOS</span></a></li>
        <%}else{}%>
        <% if(type==3 || type==4){%>
          <li><a href="panel_eventos.jsp"><i class="fa fa-book"></i> <span>MIS POSTULACIONES</span></a></li>
        <%}else{}%>
        <% if(type==2){%>
          <li><a href="panel_ofertas.jsp"><i class="fa fa-book"></i> <span>OFERTAS</span></a></li>
        <%}else{}%>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        PANEL DE EVENTO 
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
            <div class="box-header with-border">
                <% if(type==2){%>
                    <button type="button" class="col-md-3 btn btn-primary btn-responsive" data-toggle="modal" data-target="#miModalCreate">
                       Nuevo evento
                    </button>              
            </div>
            <!-- Inicio del modal -->              
            <div class="modal fade" id="miModalCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                        <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">Registrar evento</h4>
                                        </div>
                                        <div class="modal-body">                                             
                                            <form name="formregistro" action="ServletCreateEvent" method="post">                                                    
                                                 <input type="hidden" class="form-control" id="id" name="id" value="<%=id%>">
                                                 <div class="form-group">
                                                    <label>Nombre del evento</label>
                                                    <input type="text" class="form-control" placeholder="Ingrese nombre del evento" id="nom_ev" name="nom_ev">
                                                 </div>
                                                 <div class="form-group">
                                                    <label>Escoger local:</label>                                                    
                                                    <select class="form-control" name="id_local">
                                                        <% DAOLocal lodao = new DAOLocal();
                                                        for(Local lo:lodao.DAOLocalListById(id)){%>
                                                            <% if (lodao.DAOLocalListById(id).size()==0){ out.println("<option>No hay locales registrados</option>"); }else{%>
                                                            <%out.println("<option value='"+String.valueOf(lo.getId_local())+"'>"+String.valueOf(lo.getName_local())+"</option>");%>
                                                        <%}}%>
                                                    </select>                             
                                                  </div> 
                                                  <div class="form-group">
                                                    <label>Escoger género musical:</label>                                                    
                                                    <select class="form-control" name="id_gm">
                                                        <% DAOMusicGenre mgdao = new DAOMusicGenre();
                                                        for(MusicGenre mg:mgdao.DAOMusicGenreListById(id)){%> 
                                                        <% if (mgdao.DAOMusicGenreListById(id).size()==0){ out.println("<option>No hay géneros musicales registrados</option>"); }else{%>%>
                                                        <%out.println("<option value='"+String.valueOf(mg.getId_mg())+"'>"+String.valueOf(mg.getName_mg())+"</option>");%>                                                                                  
                                                        <%}}%>
                                                    </select>                             
                                                  </div>  
                                                   <!-- Date -->
                                                    <div class="form-group">
                                                      <label>Día de inicio de evento</label>
                                                      <div class="input-group date">
                                                        <div class="input-group-addon"> <i class="fa fa-calendar"></i> </div>
                                                        <input type="text" class="form-control pull-right" name="dia_ini_ev" id="datepicker">
                                                      </div>
                                                    </div>
                                                    <!-- /.form group -->
                                                  <!-- Date -->
                                                    <div class="form-group">
                                                      <label>Día de fin de evento</label>
                                                      <div class="input-group date">
                                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                                        <input type="text" class="form-control pull-right" name="dia_fin_ev" id="datepicker">
                                                      </div>
                                                    </div>
                                                    <!-- /.form group -->
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
                                                           <input type="text" class="form-control timepicker" name="hora_ini_ev">
                                                           <div class="input-group-addon">
                                                             <i class="fa fa-clock-o"></i>
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
                                                         <label>Hasta:</label>
                                                         <div class="input-group">
                                                           <input type="text" class="form-control timepicker" name="hora_fin_ev">

                                                           <div class="input-group-addon">
                                                             <i class="fa fa-clock-o"></i>
                                                           </div>
                                                         </div>
                                                       </div>
                                                   </div>                                                  
                                                 <!-- Fin del modal  <div class="form-group">-->

                                                  <div class="form-group align-center">                                                   
                                                    <button type="submit" class="btn btn-primary btn-responsive">Crear</button>  
                                                    <button type="reset" class="btn btn-primary btn-responsive">Limpiar</button>  
                                                  </div>
                                            </form>                                                
                                        </div>
                                </div>
                        </div>
            </div>
           <%} else{} %> 
            <!-- Fin del modal -->
            
            
            <div class="box-body">
                <% DAOEvent evdao = new DAOEvent();
                if (type==2){
                    for(Event ev:evdao.DAOEventListById(id)){ 
                        if (evdao.DAOEventListById(id).size()<=0){
                        out.println("No hay eventos registrados");}
                        else {%>  
                  
                    <div class="col-md-12 callout callout-warning">
                      <div class="col-md-9">
                        <h4>Nombre del evento: <%out.println(ev.getName_ev());%></h4>
                        <table id="example2" class="table">
                        <%out.println("<tbody><tr>");%>                    
                        <%out.println("<td>Día inicio: "+ev.getDia_inicio()+"</td>");%>
                        <%out.println("<td>Día fin: "+ev.getDia_inicio()+"</td>");%>
                        <%out.println("<td>Hora inicio: "+ev.getHora_inicio_ev()+"</td>");%>
                        <%out.println("<td>Hora fin: "+ev.getHora_fin_ev()+"</td>");%>
                        <%out.println("</tr></tbody>");%>
                        </table>
                      </div>
                      <div class="col-md-3">
                          <div class="column mt-2">  
                                <%out.println("<a style='text-decoration:none' class='btn btn-primary btn-block btn-responsive' "
                                + "href='ServletRedirecEvent?id_ev="+String.valueOf(ev.getId_ev())+"'>Editar</a>");%>
                          </div>
                          <br>
                          <div class="column mt-2">  
                                <%out.println("<a style='text-decoration:none' class='btn btn-primary btn-block btn-responsive' "
                                + "href='ServletDeleteEventById?id_ev="+String.valueOf(ev.getId_ev())+"'>Eliminar</a>");%>
                          </div>
                      </div>
                  </div>              
                  <%}}}else {
                        for(Event ev:evdao.DAOEventList()){%>
                    <div class="col-md-12 callout callout-warning">
                      <div class="col-md-9">
                        <h4>Nombre del evento: <%out.println(ev.getName_ev());%></h4>
                        <table id="example2" class="table">
                        <%out.println("<tbody><tr>");%>                    
                        <%out.println("<td>Día inicio: "+ev.getDia_inicio()+"</td>");%>
                        <%out.println("<td>Día fin: "+ev.getDia_inicio()+"</td>");%>
                        <%out.println("<td>Hora inicio: "+ev.getHora_inicio_ev()+"</td>");%>
                        <%out.println("<td>Hora fin: "+ev.getHora_fin_ev()+"</td>");%>
                        <%out.println("</tr></tbody>");%>
                        </table>
                      </div>
                      <div class="col-md-3">
                          <% if (type==3 | type==4){ %>
                          <div class="column mt-2">  
                              <%out.println("<a style='text-decoration:none' class='btn btn-primary btn-block btn-responsive' href='ServletPostular?id_evento="+String.valueOf(ev.getId_ev())+"&id_pos="+String.valueOf(id)+"'>Postular</a>");%>
                          </div>                          
                          <%} else{}%>                          
                      </div>
                    </div>  
                  <%}}%>
            </div>
            <!-- /.box-header -->

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
                 
                 nom_ev: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'El nombre del evento es requerido'
 
				 }
 
			 }
 
		 },
		 dia_ini_ev: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'La fecha es requerida'
 
				 }
 
			 }
 
		 },
                 dia_fin_ev: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'La fecha es requerida'
 
				 }
 
			 }
 
		 },
                 hora_ini_ev: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'La hora es requerida'
 
				 }
 
			 }
 
		 },
                 hora_fin_ev: {
 
			 validators: {
 
				 notEmpty: {
 
					 message: 'La hora es requerida'
 
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
        $('#datemask2').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
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
