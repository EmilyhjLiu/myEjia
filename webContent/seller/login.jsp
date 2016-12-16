<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<div class="core">
		<p>
			<a href="javascript:;">老司机上车</a>
			<a href="javascript:;">新司机注册</a>
		</p>
		<div class="old"></div>
		<div class="new">
			<ul>
			    <li class="active"><i>1</i><span class="tsl">设置用户名</span></li>
				<li><i>2</i><span class="tsl">填写账号信息</span></li>
			 	<li><i>3</i><span class="tsl">设置支付方式</span></li>		
			 	<li><i class="iconfont">㑇</i><span class="tsl">注册成功</span></li>
			</ul>
			<div>
				<div><span>邮箱地址*</span></div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>