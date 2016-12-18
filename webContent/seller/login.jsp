<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/myEjia/js/public/jquery-3.1.1.min.js"></script>

<link rel="stylesheet" href="/myEjia/css/public.css" type="text/css">
<link rel="stylesheet" href="/myEjia/seller/css/sellerLogin.css" type="text/css">
<title>我的E佳-开店</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<div class="core wrap clear">
		<p class="clear">
			<a href="javascript:;" class="link oldLink active">进入我的店铺</a>
			<a href="javascript:;" class="link newLink">新店开张</a>
		</p>
		<div class="wrapL">
			<div class="panel old">
				<div>
					<input type="text" class="txt" name="email" id="sEmail" placeholder="email" required="true">
				</div>	
				<div>
					<input type="password" class="txt" name="password" id="sPassword" placeholder="password" required="true">
				</div>
				<div>
					<input type="button" id="sLogin" class="btn" value="Login">
				</div>
				<div id="slMessage">
				</div>
			</div>
			<div class="panel new">
					<div>
						<input type="text" class="txt" name="email" id="srEmail" placeholder="email"/>
					</div>	
					<div>
						<input type="password" class="txt" name="password" id="srPassword" placeholder="password" />
					</div>
					<div>
						<input type="password" class="txt" name="enPassword" id="senPassword" placeholder="confirm password" />
					</div>
					<div>
						<input type="text" class="txt" name="qq" id="sQq" placeholder="输入qq，方便买家与您交谈" />
					</div>
					<div>
						<input type="text" class="txt" name="title" id="sTitle" placeholder="shop title" />
					</div>
					<div>
						<input type="text" class="txt" name="eTitle" id="seTitle" placeholder="English Shop Title" />
					</div>	
					<div>
						<input type="submit" id="sRegister" class="btn" value="Register">
					</div>
					<div id="srMessage"></div>
			</div>
			<div class="logo">
				<img alt="我的E佳" src="/myEjia/img/logo.png">
			</div>
		</div>
		<div class="wrapR">
			<h3>这边放一些对商家的新闻公告</h3>
			<ul>
				<li>
					<h6>新闻公告1</h6>
					各位商家们，这是我的E佳第一重要的新闻公告，一定要注意哦！
				</li>
				<li>
					<h6>新闻公告2</h6>
					各位商家们，这是我的E佳第一重要的新闻公告，一定要注意哦！
				</li>
				<li>
					<h6>新闻公告3</h6>
					各位商家们，这是我的E佳第一重要的新闻公告，一定要注意哦！
				</li>
				<li>
					<h6>新闻公告4</h6>
					各位商家们，这是我的E佳第一重要的新闻公告，一定要注意哦！
				</li>
				<li>
					<h6>新闻公告5</h6>
					各位商家们，这是我的E佳第一重要的新闻公告，一定要注意哦！
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="/footer.jsp"/>
	<script type="text/javascript" src="./js/sellerLogin.js"></script>
	<script type="text/javascript">
		initSL();
		sRegValidate();
		
		$('#sLogin').click(function(){
			sLoginStatu($('#sEmail').val(),$('#sPassword').val(),$('#slMessage'));
		});
	</script>
</body>
</html>