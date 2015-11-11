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
<link rel="stylesheet"
	href="<c:url value="resources/dist/css/AdminLTE.min.css"/>">

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
					Bank Accounts <small>Modify a bank account</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Modify a bank account</li>
				</ol>
			</section>
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">Modify a bank account</h3>
					<h5 id="msg" style="color:red;">${message } </h5>
					<div class="box-body">
					<form action="updatebankaccount" method="post">
					<table class="table">
					<tbody>
							<tr>
								<th hidden="true">Account ID(System generated)</th>
								<th>Account Nick Name</th>
								
								<th hidden="true">AccountHolderID(System Generated)</th>
								<th>Account Balance</th>
								<th>AccountType</th>
								<th>Bank Name</th>
								
							</tr>
						<c:forEach var="bankaccount" items="${accountlist }">
							<tr>
								<td hidden="true"><input name="accntid" type="text" value="${bankaccount.accountID }"style="width:100%; border:none;"/></td>
								<td ><input name="accntname" type="text" value="${bankaccount.accountName }" style="width:100%; border:none;"/></td>
								<td hidden="true"><input   name="accntuid" type="text" value="${bankaccount.accountHolderID }" style="width:100%; border:none;"/></td>
								<td ><input name="accntbal" type="text" value="${bankaccount.accountBalance }" style="border:none;"/></td>
								<td >
									<input name="accnttype" type="text" value="${bankaccount.accountType } " style="border:none;"/>
									
								</td>
								<td  ><input name="accntbname" type="text" value="${bankaccount.accountBank }" style="width:100%;border:none;"/></td>
							</tr>
							
						</c:forEach>
						<tr>
						<td colspan="6">
						<center>
						<input class="btn btn-default text-center" type="submit" value="Save Changes"/></center></td>
						<tr>
						</tbody>
					</table>
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
			
			function setDefault(val) {
				document.getElementById("msg").innerHTML=val;
				if(val.equals("Checkings")){
					document.getElementsByName("acctype")[0].options[0].selected='selected';
				} else {
					document.getElementsByName("acctype")[0].options[1].selected='selected';
				}
			}
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
</body>
</html>
