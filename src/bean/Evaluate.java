package bean;

public class Evaluate {
	public int getevaluateId() {
		return evaluateId;
	}
	public void setevaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	public int getevaluateUser() {
		return evaluateUser;
	}
	public void setevaluateUser(int evaluateUser) {
		this.evaluateUser = evaluateUser;
	}
	public int getevaluateGoods() {
		return evaluateGoods;
	}
	public void setevaluateGoods(int evaluateGoods) {
		this.evaluateGoods = evaluateGoods;
	}
	public String getevaluateContent() {
		return evaluateContent;
	}
	public void setevaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}
	public String getCommentReply() {
		return commentReply;
	}
	public void setCommentReply(String commentReply) {
		this.commentReply = commentReply;
	}
	private int evaluateId;
	private int evaluateUser;
	private int evaluateGoods;
	private String evaluateContent;
	private String commentReply;
}
