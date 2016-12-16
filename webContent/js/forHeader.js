function detailShow(){
	var oTopNav=$('#topNav');
	var consumerLi=oTopNav.find('.centerImg').eq(0);
	var sellerLi=oTopNav.find('.centerImg').eq(1);
	
	var consumerUl=consumerLi.find('ul');
	var sellerUl=sellerLi.find('ul');
	/*console.log(consumerA.html()+sellerA.html());*/

	consumerLi.mouseover(function(ev){
		consumerUl.css('height','160px');
	});

	consumerLi.mouseout(function(){
		consumerUl.css('height','0px');
	});
	
	sellerLi.mouseover(function(){
		sellerUl.css('height','80px');
	});
	sellerLi.mouseout(function(){
		sellerUl.css('height','0px');
	});
}
function initPop(){
	var statusA=$('.status').find('a');
	
	var oLoginInfo = $('#loginInfo');
	var oRegInfo = $('#regInfo');
	var formWrap = $('.formWrap');
	var loginMask = $('.loginMask');
	var closeL = oLoginInfo.find('.close');
	var closeR = oRegInfo.find('.close');

	var windW=$(window).width();
	var windH=$(window).height();
//	console.log(windH);

	var fWrapW=formWrap.width();
	var fWrapH=formWrap.height();

	formWrap.css({
		"left": Math.floor((windW - fWrapW)/2),
		"top":  Math.floor((windH - fWrapH)/2)
	});
	loginMask.css('width' , windW);
	oLoginInfo.css('width' , windW);
	oRegInfo.css('width' , windW);
	
	statusA.eq(0).click(function(){
		pops(oLoginInfo,true);
	});
	statusA.eq(1).click(function(){
		pops(oRegInfo,true);
	});
	closeL.click(function(){
		pops(oLoginInfo,false);
		$('#message').html('');
	});
	closeR.click(function(){
		pops(oRegInfo,false);
		$('#rMessage').html('');
	});
	
	function pops(ele,onoff){
		if(onoff){
			ele.stop(true,true).animate({
				'height' : windH
			},300); 
			loginMask.css({
				'height' : windH
			});	
		}else{
			ele.css('height' , 0); 
			loginMask.css({
				'height' : 0
			});	
		}
	}
}
//注册验证
function regValidate(){
	var rEmail=$('#rEmail');
	var rPassword=$('#rPassword');
	var enPassword=$('#enPassword');
	var phone=$('#phone')
	var register=$('#register');
	var rMessage=$('#rMessage');
	
	register.click(function(){
		regResult(rEmail.val(),rPassword.val(),enPassword.val(),phone.val(),$('#address').val(),$('#rMessage'));
	});
}

/*ajax判断登录状态*/
function loginStatu(email,password,obj){
	if(CheckMail(email)){
		if(password==""||password==null){
			obj.html("请输入您的密码");
			return;
		}
		$.ajax({
			  type: "post",
			  url: "/myEjia/UserLogin",
			  data:{
				  "email":email,
				  "password":password,
			  },
			  success:function(data){
//				  console.log(data);
//				  console.log(data.cause);
				  if(data.cause){
					  obj.html(data.cause);
				  }else{
					  window.location.reload();
				  }
			  }
		});
	}else{
		obj.html("您输入的邮箱格式不正确");
		return;
	}	
}
function regResult(email,password,enPassword,phone,address,obj){
//	console.log(email);
	if(CheckMail(email)){
		if(CheckPhone(phone)){
			if(password==""||password==null){
				obj.html("请输入您的密码");
			}else{
				obj.html("");
				if(password==enPassword){
					$.ajax({
						  type: "POST",
						  url: "/myEjia/UserReg",
						  data:{
							  "email":email,
							  "password":password,
							  "enPassword":enPassword,
							  "phone":phone,
							  "address":address
						  },
						  success:function(data){
//							  console.log(data);
							  if(data.cause){
								  obj.html(data.cause);
							  }else{
								  window.location.reload();
							  }
						  }
					});	
					obj.html("");
				}else{
					obj.html("两次输入的密码不一致");
				}							
			}		
		}else{
			obj.html("您输入的手机号码格式不正确");
		}
	}else{
		obj.html("您输入的邮箱格式不正确");
	}
}
function CheckMail(mail) {
	 var filter  = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	 if (filter.test(mail)){
		 return true;
	 }else {
		 return false;
	 }
}
function CheckPhone(phone) {
	 var filter  = /^1(3|4|5|7|8)\d{9}$/;
	 if (filter.test(phone)){
		 return true;
	 }else {
		 return false;
	 }
}