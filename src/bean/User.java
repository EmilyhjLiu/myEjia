package bean;

public class User {
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + "]";
	}
	public User(int userId, String userEmail, String userPassword,
			String userPhone, String userAddress) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	public User() {
		super();
	}
	private int userId;
	private String userEmail;
	private String userPassword;
	private String userPhone;	
	private String userAddress;
}
