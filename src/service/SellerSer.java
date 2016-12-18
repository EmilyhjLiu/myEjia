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

import bean.Seller;
import dao.SellerDao;

public class SellerSer extends ActionSupport{
	private SellerDao sellerdao =new SellerDao();
	private Map session=(Map)(ActionContext.getContext().get("session"));
	
	public boolean sSellerLogin(Seller seller){	
		//加密后与数据库进行对比				
//		seller.setSellerPassword(Encryption.hmacSign(seller.getSellerPassword()));
		if(sellerdao.qSeller(seller))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	public int sSellerReg(Seller seller){
		int result = -1;
		
		seller.setSellerPassword(Encryption.hmacSign(seller.getSellerPassword()));
		
		if(sellerdao.QueryEmail(seller.getSellerEmail())){
			result= -1;
		}else{
			result=sellerdao.addSeller(seller);
		}
		return result;
	}
	
    public static void main(String[] args) {
    	
	}
}
