package action;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;

import service.SellerSer;
import tool.Encryption;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Seller;
import dao.SellerDao;

public class SellerAction extends ActionSupport implements ServletResponseAware {
	private Seller seller = new Seller();
	private SellerDao sellerdao =new SellerDao();
	private SellerSer sellerser=new SellerSer();
	
	public String sellerExit(){
		session.remove("sellerName");
		return SUCCESS;
	}
	
	public String sellerLogin(){	
		//加密后与数据库进行对比				
		seller.setSellerEmail(email);
		seller.setSellerPassword(password);
		
		if(sellerser.sSellerLogin(seller))
		{
			session.put("sellerName", email);
			return SUCCESS;
		}
		else
		{
			//将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("cause","用户名或密码错误");
            result = JSONObject.fromObject(map);//将map对象转换成json类型数据
			return ERROR;
		}		
	}
	public String sellerReg(){
		int outcome;
		seller.setSellerEmail(email);
		seller.setSellerPassword(Encryption.hmacSign(password));
		seller.setSellerQQ(qq);
		seller.setSellerTitle(title);
		seller.setSellerEnglishTitle(eTitle);
		Map<String,Object> map = new HashMap<String,Object>();
		String valRes=validateRegister(); 
		if(!( valRes == null || valRes.equals(""))){
			map.put("cause",valRes);
			result = JSONObject.fromObject(map);
			return ERROR;
		}
		
		outcome=sellerser.sSellerReg(seller);   
        switch(outcome){
        	case -1:map.put("cause","该邮箱已被注册");break;
        	case 0:map.put("cause","由于网络问题，您为能注册成功，请重试");break;
        	case 1:map.put("cause","注册成功");session.put("sellerName", email);break;
        	default:map.put("cause","由于网络问题，您为能注册成功，请重试");
        }
		result = JSONObject.fromObject(map);
		if(outcome==1){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String validateRegister(){
		 String regexE = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";
		 if(!email.matches(regexE)){
			 return "您输入的邮箱格式不正确";
		 }
		 String regexQ = "^[1-9][0-9]{4,9}$";
		 if(!seller.getSellerQQ().matches(regexQ)){
			 return "您输入的手机号码格式不正确";
		 }
		 if(!password.equals(enPassword)){
			 return "两次输入的密码不一致";
		 }
//		 String regexType = ".*\\.(?i)(jpg|jpeg|bmp|png)$";
////		 System.out.println(sfLogo);		 
//		 if(!logo.matches(regexType)){
//			 return "请上传jpg/jpeg/gif/png/bmp格式的图片";
//		 }
		 return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnPassword() {
		return enPassword;
	}

	public void setEnPassword(String enPassword) {
		this.enPassword = enPassword;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	private String email;
	private String password;
	private String enPassword;
	private String qq;
	private String title;
	private String eTitle;
	private JSONObject result;

	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest request;
	private Map session=(Map)(ActionContext.getContext().get("session"));
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
    public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }   
//    public static void main(String[] args) {
//		// TODO Auto-generated method stub
//    	String regexType = ".*\\.(?i)(jpg|jpeg|bmp|png)$";
//    	String sfLogo="C:\\fakepath\\ding.jpg";
//		//System.out.println(sfLogo.split(regexType)[0]);	
//    	System.out.println(sfLogo.matches(regexType));
//		if(!sfLogo.matches(regexType)){
//			System.out.print( "请上传jpg/jpeg/gif/png/bmp格式的图片");
//		}
//	}
}
