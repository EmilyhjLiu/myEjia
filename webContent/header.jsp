<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="/myEjia/css/forHeader.css" type="text/css">
<script type="text/javascript" src="/myEjia/js/forHeader.js"></script>
<title>Insert title here</title>
</head>
<body style="background:#000;">
	<div id="topNav" class="wrap clear">
		<ul class="status">
		<%
			/* 读取用户登录状态 */ 
			String userName=(String)session.getAttribute("userName");
			
			if(userName==null){
		%>
				<li>
					<a href="javascript:;">买家登录</a>
				</li>
				<li>
					<a href="javascript:;">买家注册</a>
				</li>
		<%
			}else{
		%>
				<li style="width:240px;color:#fff;">
					您好，<%=userName%>
				</li>
				<li>
					<a href="/myEjia/UserExit">登出</a>
				</li>
		<%
			}
		%>
			</ul>
			<ul class="center">
				<li class="centerImg">
					<a href="javascript:;" >买家中心</a>
					<ul class="consumer">
						<li><a href="">我的购物车</a></li>
						<li><a href="">我的收藏夹</a></li>
						<li><a href="">我的黑名单</a></li>
						<li><a href="">已买到的商品</a></li>
					</ul>
				</li>
				<%
					/* 读取商家登录状态 */ 
					String sellerName=(String)session.getAttribute("sellerName");
					
					if(sellerName==null){
				%>
				<li class="centerImg">
					<a href="javascript:;">店铺商家</a>
					<ul class="seller">
						<li><a href="/myEjia/seller/login.jsp">免费开店</a></li>
						<li><a href="/myEjia/seller/login.jsp">进入我的店铺</a></li>
					</ul>
				</li>
				<%		
					}else{
				%>
				<li class="centerImg" style="width:152px;">
					<a href="javascript:;">我的店铺</a>
					<ul class="seller">
						<li><a href="/myEjia/seller/login.jsp">管理我的店铺</a></li>
						<li><a href="/myEjia/SellerExit">退出</a></li>
					</ul>
				</li>					
				<%}%>
			</ul>
		</div>
	<div id="headerWrap" class="wrap clear">
		<h1 id="logo">
			<a href="/myEjia/index.jsp"></a>
		</h1>
		<div class="info">
			为维护各位消费者的权益，各位亲可将不良商家拉入黑名单哦！
		</div>
		<div class="search">
			<input type="button" class="btn">
			<input type="text" class="txt" placeholder="毛衣  女">
		</div>
	</div>
	<div class="navWrap">
		<ul class="navBar wrap clear">
			<li>
				<a href="">服装内衣</a>
			</li>
			<li>
				<a href="">鞋靴箱包</a>
			</li>
			<li>
				<a href="">童装玩具</a>
			</li>
			<li>
				<a href="">家电数码电子</a>
			</li>
			<li>
				<a href="">美妆洗护</a>
			</li>
			<li>
				<a href="">运动户外</a>
			</li>
			<li>
				<a href="">游戏动漫</a>
			</li>
			<li>
				<a href="">美食</a>
			</li>
			<li>
				<a href="">鲜花宠物</a>
			</li>
		</ul>
	</div>
	<div class="loginMask"></div>
	<div id="loginInfo">
		<div class="formWrap" id="lg-form">
			<h3>登录我的E佳</h3>
<!-- 			<form action="UserLogin"  method="post"  name="lg-form" method="post"> -->
				<div>
					<input type="text" class="txt" name="email" id="email" placeholder="email" required=true />
				</div>	
				<div>
					<input type="password" class="txt" name="password" id="password" placeholder="password" required=true />
				</div>
				<div>
					<input type="button" id="login" class="btn" value="Login">
				</div>
<!-- 			</form> -->
			<div id="message">
			</div>
			<a href="javascript:;" class="close"></a>
		</div>
	</div>
	<div id="regInfo">
		<div class="formWrap" id="reg-form" >
			<h3>注册我的E佳</h3>
				<div>
					<input type="text" class="txt" name="email" id="rEmail" placeholder="email"/>
				</div>	
				<div>
					<input type="password" class="txt" name="password" id="rPassword" placeholder="password" />
				</div>
				<div>
					<input type="password" class="txt" name="enPassword" id="enPassword" placeholder="confirm password" />
				</div>
				<div>
					<input type="text" class="txt" name="phone" id="phone" placeholder="phone" />
				</div>
				<div>
					<input type="text" class="txt" name="address" id="address" placeholder="address" />
				</div>	
				<div>
					<input type="submit" id="register" class="btn" value="Register">
				</div>
			<div id="rMessage">
			</div>
			<a href="javascript:;" class="close"></a>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			detailShow();
			
			/* 登陆框处理 */
			initPop();

			/*注册验证*/
			regValidate();
			
			$('#login').click(function(){
				loginStatu($('#email').val(),$('#password').val(),$('#message'));
			});
		});
	</script>
</body>
</html>