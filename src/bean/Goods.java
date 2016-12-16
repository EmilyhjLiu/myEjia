package bean;

public class Goods {
	public int getgoodsId() {
		return goodsId;
	}
	public void setgoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getgoodsName() {
		return goodsName;
	}
	public void setgoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getgoodsPrice() {
		return goodsPrice;
	}
	public void setgoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getgoodsType() {
		return goodsType;
	}
	public void setgoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getgoodsDescribe() {
		return goodsDescribe;
	}
	public void setgoodsDescribe(String goodsDescribe) {
		this.goodsDescribe = goodsDescribe;
	}
	public String getgoodsPicture() {
		return goodsPicture;
	}
	public void setgoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public int getgoodsSeller() {
		return goodsSeller;
	}
	public void setgoodsSeller(int goodsSeller) {
		this.goodsSeller = goodsSeller;
	}
	public Goods(int goodsId, String goodsName, float goodsPrice,
			String goodsType, String goodsDescribe, String goodsPicture,
			int goodsSeller) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsType = goodsType;
		this.goodsDescribe = goodsDescribe;
		this.goodsPicture = goodsPicture;
		this.goodsSeller = goodsSeller;
	}
	private int goodsId;
	private String goodsName;
	private float goodsPrice;
	private String goodsType;
	private String goodsDescribe;
	private String goodsPicture;
	private int goodsSeller;
}
