<%-- 
    Document   : calendario
    Created on : 26-may-2018, 20:03:52
    Author     : Monica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
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
        <link rel="stylesheet" href="theme/bower_components/select2/dist/css/select2.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="theme/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="theme/dist/css/skins/_all-skins.min.css">

        
        <!-- Google Font -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
   
       <form  action="SPRUEBA" method="post"> 
       <!-- /.FECHA -->
         <div class="form-group">
                        <label>Date and time range:</label>

                        <div class="input-group">
                          <div class="input-group-addon">
                            <i class="fa fa-clock-o"></i>
                          </div>
                            <input type="text" class="form-control pull-right" name ="reservacion" id="reservationtime">
                        </div>
          </div>
        
         <!-- /.HORA -->
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
                  <label>Time picker:</label>

                  <div class="input-group">
                    <input type="text" class="form-control timepicker" name ="hora">

                    <div class="input-group-addon">
                      <i class="fa fa-clock-o"></i>
                    </div>
                  </div>
                </div>
            </div>
       
       
            <!-- /.USUARIO -->
              <div class="form-group">
                    <label>Crear usuario:</label>
                    <input type="text" class="form-control" placeholder="Ingrese usuario" id="user" name="user">
              </div>
            
            <!-- /.CHECKBOX -->
           
                        <div>                   
                             <div>
                        
                                  <input type="checkbox" name="dia" value="Lunes">Checkbox 1

                                  <input type="checkbox" name="dia" value ="Martes"> Checkbox 2

                                   <input type="checkbox" name="dia" value ="Miercoles"> Checkbox disabled
                                  <button type="submit" class="btn btn-secondary">Registrar</button> 
                       
                            </div>  
                       </div>
            
            <!-- /.DATE RANGE -->
            
            <div class="form-group">
                <label>Date range:</label>

                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="reservation">
                </div>
                <!-- /.input group -->
              </div>
            
             <!-- Date -->
              <div class="form-group">
                <label>Date:</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="datepicker">
                </div>
                <!-- /.input group -->
              </div>
              <!-- /.form group -->
            
            
         </form>      
       
             
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
    <!-- AdminLTE for demo purposes -->
    <script src="theme/dist/js/demo.js"></script>
    <!-- Page script -->
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
