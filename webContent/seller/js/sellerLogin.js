/**
 * for seller login
 */
function initSL(){
	var links=$('.core').find('p.clear a');
	var oPanel=$('.wrapL').find('div.panel');
	
	links.each(function(){
		$(this).click(function(){
			links.removeClass('active');
			$(this).addClass('active');
			
			oPanel.css('display','none');
			oPanel.eq($(this).index()).css('display','block');
		});
	});
}

function sRegValidate(){
	var register=$('#sRegister');
	register.click(function(){
		var srEmail=$.trim($('#srEmail').val());
		var srPassword=$.trim($('#srPassword').val());
		var senPassword=$.trim($('#senPassword').val());
		var sQq=$.trim($('#sQq').val());
		var srMessage=$('#srMessage');
		
		if(CheckMail(srEmail)){
			if(CheckQQ(sQq)){
				if(srPassword==""||srPassword==null){
					srMessage.html("请输入您的密码");
				}else{
					srMessage.html("");
					if(srPassword==senPassword){
						sRegResult(srEmail,srPassword,senPassword,sQq,srMessage);
						srMessage.html("");
					}else{
						srMessage.html("两次输入的密码不一致");
					}							
				}		
			}else{
				srMessage.html("您输入的qq号码格式不正确");
			}
		}else{
			srMessage.html("您输入的邮箱格式不正确");
		}
	});
}
function sLoginStatu(email,password,obj){
	if(CheckMail(email)){
		if(password==""||password==null){
			obj.html("请输入您的密码");
			return;
		}
		$.ajax({
			  type: "post",
			  url: "/myEjia/SellerLogin",
			  data:{
				  "email":email,
				  "password":password,
			  },
			  success:function(data){
				  console.log(data+"123");
				  console.log("456");
				  if(data.cause){
					  obj.html(data.cause);
				  }else{
					  window.location.href="myShop.jsp";
				  }
			  }
		});
	}else{
		obj.html("您输入的邮箱格式不正确");
		return;
	}	
}
function sRegResult(email,password,enPassword,qq,obj){
	$.ajax({
		  type: "get",
		  url: "/myEjia/SellerReg",
		  data:{
			  "email":email,
			  "password":password,
			  "enPassword":enPassword,
			  "qq":qq,
		  },
		  success:function(data){
			  if(data.cause){
				  obj.html(data.cause);
			  }else{
				  window.location.reload();
			  }
		  }
	});	
}
