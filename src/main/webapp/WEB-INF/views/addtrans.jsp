<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Spending Tracker Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet"
	href="<c:url value="resources/bootstrap/css/bootstrap.min.css"/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<c:url value="resources/dist/css/AdminLTE.min.css"/>">
	<link rel="stylesheet" href="<c:url value="resources/plugins/daterangepicker/daterangepicker-bs3.css"/>">

<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value="resources/dist/css/skins/_all-skins.min.css"/>">
<!-- iCheck -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/iCheck/flat/blue.css"/>">
<!-- Morris chart -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/morris/morris.css"/>">
<!-- jvectormap -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css"/>">
<!-- Date Picker -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/datepicker/datepicker3.css"/>">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/daterangepicker/daterangepicker-bs3.css"/>">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>S</b></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Spending</b> Tracker</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <span
								class="hidden-xs">${lastname}, ${firstname } </span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header">

									<p style="padding: 20%;">${lastname }, ${firstname }</p>
								</li>

								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="signout" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="active"><a href="dashboard"> <i class="fa fa-dashboard"></i>
							<span>Dashboard</span>
					</a></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-university"></i> <span>Bank Accounts</span> <i
							class="fa fa-angle-left pull-right"></i> <span
							class="label label-primary pull-right">3</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="addbaccount"><i
									class="fa fa-circle-o"></i>Add a bank Account</a></li>
							<li><a href="pages/layout/boxed.html"><i
									class="fa fa-circle-o"></i>Update a bank account</a></li>
							<li><a href="pages/layout/fixed.html"><i
									class="fa fa-circle-o"></i>Delete a bank account</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
							<span>Manage Credit Cards</span> <i
							class="fa fa-angle-left pull-right"></i> <span
							class="label label-primary pull-right">6</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="adcc"><i
									class="fa fa-circle-o"></i>Add a credit card</a></li>
							<li><a href="pages/UI/icons.html"><i
									class="fa fa-circle-o"></i>Update a credit card</a></li>
							<li><a href="pages/UI/buttons.html"><i
									class="fa fa-circle-o"></i>Delete a credit card</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-money"></i>
							<span>Expenses</span> <i class="fa fa-angle-left pull-right"></i>
							<span class="label label-primary pull-right">6</span>
					</a>
						<ul class="treeview-menu">
						<li><a href="pages/layout/top-nav.html"><i class="fa fa-circle-o"></i>Summary</a></li>
							<li><a href="pages/layout/top-nav.html"><i
									class="fa fa-circle-o"></i>Add an expense</a></li>
							<li><a href="pages/layout/boxed.html"><i
									class="fa fa-circle-o"></i>Update a previous expense</a></li>
							<li><a href="pages/layout/fixed.html"><i
									class="fa fa-circle-o"></i>Delete an expense</a></li>
							<li><a href="pages/layout/top-nav.html"><i
									class="fa fa-circle-o"></i>Add a recurring expense</a></li>
							<li><a href="pages/layout/boxed.html"><i
									class="fa fa-circle-o"></i>Update a recurring expense</a></li>
							<li><a href="pages/layout/fixed.html"><i
									class="fa fa-circle-o"></i>Delete a recurring expense</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-money"></i>
							<span>Incomes</span> <i class="fa fa-angle-left pull-right"></i>
							<span class="label label-primary pull-right">3</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/layout/top-nav.html"><i
									class="fa fa-circle-o"></i>Add an income</a></li>
							<li><a href="pages/layout/boxed.html"><i
									class="fa fa-circle-o"></i>Update an added income</a></li>
							<li><a href="pages/layout/fixed.html"><i
									class="fa fa-circle-o"></i>Delete an income</a></li>
							<li><a href="pages/layout/top-nav.html"><i
									class="fa fa-circle-o"></i>Add a recurring income</a></li>
							<li><a href="pages/layout/boxed.html"><i
									class="fa fa-circle-o"></i>Update a recurring income</a></li>
							<li><a href="pages/layout/fixed.html"><i
									class="fa fa-circle-o"></i>Delete a recurring income</a></li>
						</ul></li>
					<li><a href="pages/calendar.html"> <i
							class="fa fa-calendar"></i> <span>Calendar</span> <small
							class="label pull-right bg-red">3</small>
					</a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Transaction <small>Add Transaction</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i>Transaction</a></li>
					<li class="active">Add Transaction</li>
				</ol>
			</section>
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">Add a transaction</h3>
					<h5 id="msg" style="color:red;">${message } </h5>
					<div class="box-body">
					<form action="addtrans" method="post">
					<div class="form-group">
								<div class="row">
									<label for="etype" class="col-lg-2 control-label">Transaction Type</label>
									<div class="col-lg-4">
										<label class="radio-inline">
										   <input type="radio" name="etype" value="expense" id="expense" checked="checked">Expense
										</label>
										    <label class="radio-inline">
										      <input type="radio" name="etype" value="income" id="income">Income
										    </label>
									</div>
								</div>
								<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
								<div class="row">
									<label for="ename" class="col-lg-2 control-label">Transaction Nick Name</label>
									<div class="col-lg-4">
										<input type="text" name="ename" class="col-lg-4 form-control"
											id="ename">
									</div>
								</div>
								<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
								<div class="row">
									<label for="ename" class="col-lg-2 control-label">Accounts</label>
									<div class="col-lg-4">
										<label class="radio-inline">
										   <input type="radio" name="atype" value="card" id="credit" checked="checked">Credit Card
										</label>
										    <label class="radio-inline">
										      <input type="radio" name="atype" value="bank" id="bank">Bank Account
										    </label>
									</div>
								</div>
								<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
								<div class="row"  id="bankdiv" class="visibility:hidden;">
									<label for="ename" class="col-lg-2 control-label">Select a bank account</label>
									<div class="col-lg-4">
										<select class="form-control" name="eba">
											<c:forEach var="account" items="${accountlist}">
									            <option value="${account }" >${account }</option>
									        </c:forEach>
										</select>
									</div>
								</div>
								<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
								<div class="row"  id="carddiv">
									<label for="ename" class="col-lg-2 control-label">Select a credit card</label>
									<div class="col-lg-4">
										<select class="form-control" name="ecc">
											<c:forEach var="card" items="${cardlist}">
									            <option value="${card }" >${card }</option>
									        </c:forEach>
										</select>
									</div>
								</div>
								<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
								<div class="row">
									<label for="eamount" class="col-lg-2 control-label">Amount Spent</label>
									<div class="col-lg-4">
										<input type="text" name="eamount" class="col-lg-4 form-control"
											id="eamount">
									</div>
								</div>
								<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
								<div class="row">
								<label for="edate" class="col-lg-2 control-label">Date of transaction</label>
				                  <div class="col-lg-4  form-group">
				                    <div class="input-group">
				                      <div class="input-group-addon">
				                        <i class="fa fa-calendar"></i>
				                      </div>
				                      <input type="text" name="edate" id="edate" class="form-control" placeholder="yyyy/mm/dd">
				                    </div><!-- /.input group -->
				                  </div><!-- /.form group -->
                			</div>
                			<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
                			<div class="row">
									<label for="edesc" class="col-lg-2 control-label">Short Description on the transaction</label>
									<div class="col-lg-4">
										<textarea name="edesc" class="col-lg-4 form-control"
											id="edesc"></textarea>
									</div>
							</div>
							<div class="row">
									<label class="col-lg-2 control-label"></label>
								</div>
					</div>
					<input type="submit" value="Save Transaction" class="btn btn-default"/>
					</form>
					</div>
				</div>
			</div>
		</div>
		</div>

		<!-- Main content -->
		<!-- jQuery 2.1.4 -->
		<script
			src="<c:url value="resources/plugins/jQuery/jQuery-2.1.4.min.js"/>"></script>
		<!-- jQuery UI 1.11.4 -->
		<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
		<script>
			$.widget.bridge('uibutton', $.ui.button);
			$(document).ready(function(){
				$('#edate').datepicker({
	                format: "yyyy/mm/dd"
	            });  
				$("#bankdiv").toggle();
			});
			$("#credit").click(function() {
				$("#carddiv").toggle();
				$("#bankdiv").toggle();
			});
			
			$("#bank").click(function() {
				$("#carddiv").toggle();
				$("#bankdiv").toggle();
			});
			
			$(function () {
		        //Initialize Select2 Elements
		        $(".select2").select2();

		        //Datemask dd/mm/yyyy
		        $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
		        //Datemask2 mm/dd/yyyy
		        $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
		        //Money Euro
		        $("[data-mask]").inputmask();

		        //Date range picker
		        $('#reservation').daterangepicker();
		        //Date range picker with time picker
		        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
		        //Date range as a button
		        $('#daterange-btn').daterangepicker(
		            {
		              ranges: {
		                'Today': [moment(), moment()],
		                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
		                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
		                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
		                'This Month': [moment().startOf('month'), moment().endOf('month')],
		                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
		              },
		              startDate: moment().subtract(29, 'days'),
		              endDate: moment()
		            },
		        function (start, end) {
		          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
		        }
		        );

		        //iCheck for checkbox and radio inputs
		        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
		          checkboxClass: 'icheckbox_minimal-blue',
		          radioClass: 'iradio_minimal-blue'
		        });
		        //Red color scheme for iCheck
		        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
		          checkboxClass: 'icheckbox_minimal-red',
		          radioClass: 'iradio_minimal-red'
		        });
		        //Flat red color scheme for iCheck
		        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
		          checkboxClass: 'icheckbox_flat-green',
		          radioClass: 'iradio_flat-green'
		        });

		        //Colorpicker
		        $(".my-colorpicker1").colorpicker();
		        //color picker with addon
		        $(".my-colorpicker2").colorpicker();

		        //Timepicker
		        $(".timepicker").timepicker({
		          showInputs: false
		        });
		      });
			
		</script>
		<!-- Bootstrap 3.3.5 -->
		<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js"/>"></script>
		<!-- Morris.js charts -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
		<script src="<c:url value="resources/plugins/morris/morris.min.js"/>"></script>
		<!-- Sparkline -->
		<script
			src="<c:url value="resources/plugins/sparkline/jquery.sparkline.min.js"/>"></script>
		<!-- jvectormap -->
		<script
			src="<c:url value="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"></script>
		<script
			src="<c:url value="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"></script>
		<!-- jQuery Knob Chart -->
		<script src="<c:url value="resources/plugins/knob/jquery.knob.js"/>"></script>
		<!-- daterangepicker -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
		<script
			src="<c:url value="resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
		<!-- datepicker -->
		<script
			src="<c:url value="resources/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
		<!-- Bootstrap WYSIHTML5 -->
		<script
			src="<c:url value="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"></script>
		<!-- Slimscroll -->
		<script
			src="<c:url value="resources/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
		<!-- FastClick -->
		<script
			src="<c:url value="resources/plugins/fastclick/fastclick.min.js"/>"></script>
		<!-- AdminLTE App -->
		<script src="<c:url value="resources/dist/js/app.min.js"/>"></script>
		<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
		<script src="<c:url value="resources/dist/js/pages/dashboard.js"/>"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="<c:url value="resources/dist/js/demo.js"/>"></script>
		    <script src="../../plugins/select2/select2.full.min.js"></script>
    <!-- InputMask -->
	    <script src="<c:url value="resources/plugins/input-mask/jquery.inputmask.js"/>"></script>
	    <script src="<c:url value="resources/plugins/input-mask/jquery.inputmask.date.extensions.js"/>"></script>
	    <script src="<c:url value="resources/plugins/input-mask/jquery.inputmask.extensions.js"/>"></script>
	    <!-- date-range-picker -->
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	    <script src="<c:url value="resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
</body>
</html>
