package usingTreeMap;

public class Reviews implements Comparable<Reviews> {

	private String userName;
	private int points;
	private String comment;
	
	public Reviews() {
		super();
	}

	public Reviews(String userName, int points, String comment) {
		super();
		this.userName = userName;
		this.points = points;
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Reviews [userName=" + userName + ", points=" + points + ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		return comment.length()- points*4 + userName.length()/2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Reviews) {
			Reviews r = (Reviews)obj;
			boolean a = r.userName.equals(this.getUserName());
			boolean b = r.comment.equals(this.comment);
			boolean c = r.points ==this.getPoints();
			return a && b && c;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Reviews r) {
		return r.comment.compareTo(this.comment);
	}
	
}
