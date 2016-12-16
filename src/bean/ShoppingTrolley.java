package bean;

public class ShoppingTrolley {
	public ShoppingTrolley(int id, int userId, int goodsId) {
		super();
		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public int getgoodsId() {
		return goodsId;
	}
	public void setgoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	private int id;
	private int userId;
	private int goodsId;
}
