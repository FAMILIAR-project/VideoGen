package convoverconf;

//QUESTION BONUS 1
public class MandatoryDesc implements IVideoGenDesc {
	private String id;
	private String url;

	public MandatoryDesc(String id, String url) {
		this.id = id;
		this.url = url;
	}

	@Override
	public String toString() {
		return "\n\tmandatory videoseq " + this.id + " " + this.url;
	}
}
