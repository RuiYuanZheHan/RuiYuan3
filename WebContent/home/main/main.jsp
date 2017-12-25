<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<title>酒店点菜管理系统</title>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="row-fluid">
		<%@ include file="../../AssemblingJSP/mainJSP/left.jsp"%>
		<!--/span-->
		<div class="span9" id="content">
			<div class="row-fluid">
				<div class="alert alert-success">
					<div class="navbar">
						<div class="navbar-inner">
							<ul class="breadcrumb">
								<li><a href="#">伸缩</a> <span class="divider">/</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">统计</div>

						</div>
						<div class="block-content collapse in">
							<div class="span3">
								<div class="chart" data-percent="${onlinenum}">${onlinenum}</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">当前登录人数</span>

								</div>
							</div>
							<div class="span3">
								<div class="chart" data-percent="${webclicknum}">${webclicknum}</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">网页点击次数</span>

								</div>
							</div>
							<div class="span3">
								<div class="chart" data-percent="83">83%</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">服务器启动次数</span>

								</div>
							</div>

						</div>
					</div>
					<!-- /block -->
				</div>
				<div class="row-fluid">
					<div class="span6">
						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">用户</div>
								<div class="pull-right">
									<span class="badge badge-info">1,234</span>

								</div>
							</div>
							<div class="block-content collapse in">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>姓</th>
											<th>名</th>
											<th>查看</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /block -->
					</div>
					<div class="span6">
						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">订单信息</div>
								<div class="pull-right">
									<span class="badge badge-info">752</span>

								</div>
							</div>
							<div class="block-content collapse in">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>订单号</th>
											<th>日期</th>
											<th>消费额</th>
											<th>查看</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>

											<td>02/02/2013</td>
											<td>$25.12</td>
											<td>Coat</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /block -->
					</div>
				</div>
			</div>
			<hr>
		</div>
	</div>
	<!--/.fluid-container-->
</body>

</html>