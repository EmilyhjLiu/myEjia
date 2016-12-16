package bean;

public class BlackList {
		public BlackList(int id, int userId, int seller) {
			super();
			this.id = id;
			this.userId = userId;
			this.seller = seller;
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
			return seller;
		}
		public void setgoodsId(int seller) {
			this.seller = seller;
		}
		private int id;
		private int userId;
		private int seller;
}