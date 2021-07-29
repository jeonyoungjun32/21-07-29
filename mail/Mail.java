package queue.mail;

public class Mail {

	String toSome; // 사람이름. 누구누구에게~
	String mailTitle; // 메일제목

	public Mail(String toSome, String mailTitle) {
		super();
		this.toSome = toSome;
		this.mailTitle = mailTitle;
	}

	public String getToSome() {
		return toSome;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	@Override
	public String toString() {
		return "사람이름 = " + toSome + "\n메일제목 = " + mailTitle+"\n";
	}

}
