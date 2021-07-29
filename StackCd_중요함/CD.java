package StackCd_중요함;

public class CD {

	private String cdTitle;

	public CD(String cdTitle) {
		super();
		this.cdTitle = cdTitle;
	}

	public String getCdTitle() {
		return cdTitle;
	}


	@Override
	public String toString() {
		return "CD [cdTitle=" + cdTitle + "]";
	}

}
