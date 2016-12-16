package service;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;

import tool.Encryption;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDao;

public class UserSer extends ActionSupport{
	private UserDao userdao =new UserDao();
	private Map session=(Map)(ActionContext.getContext().get("session"));
	
	public boolean sUserLogin(User user){	
		//加密后与数据库进行对比				
		user.setUserEmail(user.getUserEmail());
		user.setUserPassword(Encryption.hmacSign(user.getUserPassword()));
		if(userdao.qUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	public int sUserReg(User user){
		int result = -1;

		user.setUserEmail(user.getUserEmail());
		user.setUserPassword(Encryption.hmacSign(user.getUserPassword()));
		user.setUserPhone(user.getUserPhone());
		user.setUserAddress(user.getUserAddress());
		
		if(userdao.QueryEmail(user.getUserEmail())){
			result= -1;
		}else{
			result=userdao.addUser(user);
		}
		return result;
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
