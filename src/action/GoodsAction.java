package action;

import bean.Goods;

import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Goods goods;
	private String key;
	private String type;
}