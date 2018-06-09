<%-- 
    Document   : editar_musicgenre
    Created on : 25-may-2018, 23:37:05
    Author     : Monica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.application.bean.Local"%>
<%@page import="com.application.dao.DAOLocal"%>
<% 
    int id_mg = (Integer) session.getAttribute("id_mg");
    int id = (Integer) session.getAttribute("id");
    String nom_mg = (String) session.getAttribute("nom_mg");
    String art_ref = (String) session.getAttribute("art_ref");
    String det = (String) session.getAttribute("det");
 %>
  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Integrador 2 | Panel de Administracion</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="theme/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="theme/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="theme/Ionicons/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="theme/jvectormap/jquery-jvectormap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="theme/dist/css/AdminLTE.min.css">
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

      

      <span class="logo-lg"><b>BEATER</b>banda</span>
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
              <span class="hidden-xs">user</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="images/pos.jpg" class="img-circle" alt="User Image">

                <p>
                                                                                                  
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
       PANEL DE GÉNERO MUSICAL        
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
            <p class="text-muted text-center">Editar género musical</p>  
            
            <!-- Editar perfil contratista  -->        
            <form class="form-horizontal" name="formregistro" action="ServletUpdateGMById" method="post">                
              <div class="box-body">
                <input type="hidden" class="form-control" id="id_mg" name="id_mg" value="<%=id_mg%>" >
                <input type="hidden" class="form-control" id="id" name="id" value="<%=id%>" >
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Nombre del género musical:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="nom_mg" name="nom_mg" value="<%=nom_mg%>" >
                  </div>
                </div>                 
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Artista de referencia:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="art_ref" name="art_ref" value="<%=art_ref%>" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Detalles: </label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="det" name="det" value="<%=det%>" >
                  </div>
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
<!-- FastClick -->
<script src="theme/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="theme/dist/js/adminlte.min.js"></script>
<!-- Sparkline -->
<script src="theme/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap  -->
<script src="theme/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="theme/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll -->
<script src="theme/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS -->
<script src="theme/chart.js/Chart.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="theme/dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="theme/dist/js/demo.js"></script>
</body>
</html>

