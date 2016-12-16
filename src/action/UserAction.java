package action;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;

import service.UserSer;
import tool.Encryption;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDao;

public class UserAction extends ActionSupport implements ServletResponseAware {
	private User user = new User();
	private UserDao userdao =new UserDao();
	private UserSer userser=new UserSer();
	
	public String userExit(){
		session.remove("userName");
		return SUCCESS;
	}
	
	public String userLogin(){	
		//加密后与数据库进行对比				
		user.setUserEmail(email);
		user.setUserPassword(Encryption.hmacSign(password));
		
		if(userser.sUserLogin(user))
		{
			session.put("userName", email);
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
	public String userReg(){
		int outcome;
		user.setUserEmail(email);
		user.setUserPassword(Encryption.hmacSign(password));
		user.setUserPhone(phone);
		user.setUserAddress(address);
		Map<String,Object> map = new HashMap<String,Object>();
		String valRes=validateRegister(user); 
		if(!( valRes == null || valRes.equals(""))){
			map.put("cause",valRes);
			result = JSONObject.fromObject(map);
			return ERROR;
		}
		
		outcome=userser.sUserReg(user);   
        switch(outcome){
        	case -1:map.put("cause","该邮箱已被注册");break;
        	case 0:map.put("cause","由于网络问题，您为能注册成功，请重试");break;
        	case 1:map.put("cause","注册成功");session.put("userName", email);break;
        	default:map.put("cause","由于网络问题，您为能注册成功，请重试");
        }
		result = JSONObject.fromObject(map);
		if(outcome==1){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String validateRegister(User user){
		 System.out.print("user.getUserAddress():"+user.getUserAddress());
		 String regexE = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";
		 if(!user.getUserEmail().matches(regexE)){
			 return "您输入的邮箱格式不正确";
		 }
		 String regexP = "^1(3|4|5|7|8)\\d{9}$";
		 if(!user.getUserPhone().matches(regexP)){
			 return "您输入的手机号码格式不正确";
		 }
		 if(!password.equals(enPassword)){
			 return "两次输入的密码不一致";
		 }
		 if(user.getUserAddress().equals("")||(user.getUserAddress().trim()=="")){
			return "请输入您的地址"; 
		 }
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}
	public javax.servlet.http.HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(javax.servlet.http.HttpServletRequest request) {
		this.request = request;
	}

	private String email;
	private String password;
	private String enPassword;
	private String phone;
	private String address;
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
//    	 Map<String,Object> map = new HashMap<String,Object>();
//         map.put("name", 12);
//         map.put("age",23);
//         JSONObject json = JSONObject.fromObject(map);
//         System.out.print(json.toString());
//	}
}
