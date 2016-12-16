package bean;

public class Seller {
	public Seller(int sellerId, String sellerEmail, String sellerPassword,
			String sellerQQ, String sellerLogo, String sellerTitle,
			String sellerEnglishTitle, float blackRate) {
		super();
		this.sellerId = sellerId;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
		this.sellerQQ = sellerQQ;
		this.sellerLogo = sellerLogo;
		this.sellerTitle = sellerTitle;
		this.sellerEnglishTitle = sellerEnglishTitle;
		this.blackRate = blackRate;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerPassword() {
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
	public String getSellerQQ() {
		return sellerQQ;
	}
	public void setSellerQQ(String sellerQQ) {
		this.sellerQQ = sellerQQ;
	}
	public String getSellerLogo() {
		return sellerLogo;
	}
	public void setSellerLogo(String sellerLogo) {
		this.sellerLogo = sellerLogo;
	}
	public String getSellerTitle() {
		return sellerTitle;
	}
	public void setSellerTitle(String sellerTitle) {
		this.sellerTitle = sellerTitle;
	}
	public String getSellerEnglishTitle() {
		return sellerEnglishTitle;
	}
	public void setSellerEnglishTitle(String sellerEnglishTitle) {
		this.sellerEnglishTitle = sellerEnglishTitle;
	}
	public float getBlackRate() {
		return blackRate;
	}
	public void setBlackRate(float blackRate) {
		this.blackRate = blackRate;
	}
	private int sellerId;
	private String sellerEmail;
	private String sellerPassword;	
	private String sellerQQ;
	private String sellerLogo;
	private String sellerTitle;	
	private String sellerEnglishTitle;
	private float blackRate;
}
