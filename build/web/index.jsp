<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int id = (Integer) session.getAttribute("id"); 
    String user = (String) session.getAttribute("user");
    String pass = (String) session.getAttribute("pass");
    String nombre = (String) session.getAttribute("nombre");
    String ape = (String) session.getAttribute("ape");
    String des = (String) session.getAttribute("des");
    String correo = (String) session.getAttribute("correo");
   int type = (Integer) session.getAttribute("type");
   System.out.println(user+" "+pass);
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
                  <a href="index.jsp" class="btn btn-default btn-flat">Perfil</a>
                </div>
                <div class="pull-right">
                  <a href="ServletLogout" class="btn btn-default btn-flat">Sign out</a>
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
          <p><%=user%></p>
          <p></p>          
        </div>
      </div>
             
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Principal navegación</li>
  
        <% if(type==2){%>
        <li><a href="panel_locales.jsp"><i class="fa fa-th"></i> <span>LOCALES</span></a></li>
        <%}else{ } %>  
        <% if(type==2){%>
        <li><a href="panel_musicgenre.jsp"><i class="fa fa-book"></i> <span>GÉNERO MUSICAL</span></a></li>
        <%}else{ } %>
        <% if(type==2 || type==3 || type==4){%>
        <li><a href="panel_eventos.jsp"><i class="fa fa-book"></i> <span>EVENTOS</span></a></li>
        <%}else{ } %>        
        <% if(type==2 || type==3 || type ==4){%>
        <li><a href="panel_ofertas.jsp"><i class="fa fa-book"></i> <span>OFERTAS</span></a></li>
        <%}else{ } %>        
        <% if(type==3 || type ==4){%>
        <li><a href="panel_postulaciones.jsp"><i class="fa fa-book"></i> <span>MIS POSTULACIONES</span></a></li>
        <%}else{ } %>
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>PERFIL </h1>
      <ol class="breadcrumb"></ol>
    </section>
  
    
    <!-- Main content -->
    <section class="content">
        <div class="col-md-12">
          <!-- Widget: user widget style 1 -->
          <div class="box box-widget widget-user">
            <!-- Add the bg color to the header using any of the bg-* classes -->
            <div class="widget-user-header bg-black" style="background: url('../web/imges/ba2.jsp') center center;">
              <h3 class="profile-username text-center"><%=nombre%> <%=ape%></h3>
            </div>
            <div class="widget-user-image">
              <img class="img-circle" src="images/disco.jpg" alt="User Avatar">
            </div>
            <div class="box-footer">
              <div class="row">
                <div class="col-sm-4 border-right">
                </div>
                <div class="col-sm-4 border-right">
                  <div class="description-block">
                      <span class="description-text"><%=des%></span>
                  </div>
                </div>
                <div class="col-sm-4">
                </div>
              </div>
            </div>
          </div>
        </div>
      
      
      <div class="row">
        <div class="col-md-12">
          <div class="box box-default">
            

 <!-- Profile Image -->
          <div class="box box-primary">
             <div class="box-body box-profile">
              <p class="text-muted text-center">Perfil</p>
              
     <!-- Editar perfil contratista -->  
    
            <form class="form-horizontal" name="formregistro" action="ServletUpdatePerson" method="post">
              <div class="box-body">
                  
                <input type="hidden" class="form-control" id="id" name="id" value="<%=id%>" >  
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Usuario:</label>
                  <div class="col-sm-10">
                      <label  class="col-sm-2 control-label"><%=user%></label>
                      <input type="hidden" class="form-control" id="user" name="user" value="<%=user%>">
                  </div>
                </div>                 
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Contraseña</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="pass" name="pass" value="<%=pass%>" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Nombres:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%=nombre%>" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Apellidos:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="ape" name="ape" value="<%=ape%>" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">Correo electrónico:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="ape" name="correo" value="<%=correo%>" >
                  </div>
                </div>
                <div class="form-group">
                    <p><label  class="col-sm-2 control-label">Agrega una breve descripción acerca de ti:</label></p>                 
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="des" name="des" value="<%=des%>" >
                  </div>
                </div>
                 <input type="hidden" class="form-control" id="type" name="type" value="<%=type%>" >       
              </div>
              <div>
                <button type="submit" class="btn btn-info pull-right">Actualizar</button>
              </div>
            </form>
             </div>
          </div>
     <!-- /FIN EITAR PERFIL CONTRATISTA -->
            
          </div>
        </div>
      </div>
    </section>
  </div>


  <footer class="main-footer">BEATER</footer> 
</div>


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
