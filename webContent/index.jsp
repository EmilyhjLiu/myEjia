<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html><!-- 此标准一定要写，否则会影响窗口高度的获取 -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>我的E佳 | 网上购物商城</title>
	<script type="text/javascript" src="js/public/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/public/jquery.tmpl.js"></script>
	<script type="text/javascript" src="js/data/top10.js"></script>
	<script type="text/javascript" src="js/public/public.js"></script>
		
	<link rel="stylesheet" href="css/public.css" type="text/css">
	<link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
	 <jsp:include page="header.jsp"/>
	 <div class="core">
		<div class="carousel">
			<ul class="carouselList clear">
				<li>
					<a href="#" class="firKv"></a>
				</li>
				<li>
					<a href="#" class="secKv"></a>
				</li>
				<li>  
					<a href="#"  class="thirtKv"></a>
				</li>
			</ul>
		</div>
		<ul class="carouselNav clear">
			<li>
				<a href="javascript:;" class="active"></a>
			</li>
			<li>
				<a href="javascript:;"></a>
			</li>
			<li>
				<a href="javascript:;"></a>
			</li>
		</ul>
		
		<div class="hotShop">
			<h2>当红店铺</h2>
			<p>以下为拉黑率最低的十家店铺，按照被拉黑率从低到高排序</p>
			<ul class="clear">
				<script type="text/template" id='hotShopTmpl'>  
			    	<li>    
			        	<span class="top">{{= rank}}</span>
						<div class="img">
							<a href="#" title="{{= title}}" style="background-image:url({{= imgUrl}})">
							</a>
						</div>
						<div class="detail">
							<h3>{{= title}}</h3>
							<span>拉黑率：{{= blackRate}}</span>
							<a href="{{= url}}">查看详情</a>
						</div>
			   		</li>  
				</script>  
			</ul>
		</div>
	 </div>
	 <jsp:include page="footer.jsp"/>
	 <script type="text/javascript">
		(function(){
			$(".hotShop ul").append($("#hotShopTmpl").tmpl(hotShopData));  
			
			var caroDiv=$('.carousel');
			var caroList=caroDiv.find('.carouselList');
			var index=0;
			var aCarouselNav=$('.carouselNav').find('a');
			
			var car=new carouselFn(index,caroDiv,aCarouselNav);
			
			var timer=setInterval(function(){
				car.aRight();
			},5000);
			
			aCarouselNav.each(function(ind){
				$(this).bind('mousedown',function(){
					clearInterval(timer);
					car.index=ind-1;
					car.aRight();
				});
				
				$(this).bind('mouseup',function(){
					timer=setInterval(function(){
						car.aRight();
					},5000);
				});
			});
		})();
	</script>
</body>
</html>