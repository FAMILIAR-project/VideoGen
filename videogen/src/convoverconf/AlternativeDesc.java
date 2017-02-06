package convoverconf;

import java.util.ArrayList;
import java.util.List;

//QUESTION BONUS 1 
public class AlternativeDesc implements IVideoGenDesc {
	private String id;
	private List<String> paths = new ArrayList<String>();

	public AlternativeDesc(String id) {
		this.id = id;
	}

	void addPath(String url) {
		paths.add(url);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\talternatives " + this.id + " {");
		sb.append(System.lineSeparator());

		for (String path : paths) {
			sb.append("\t\tvideoseq "+ path + "\n");
		}
		
		sb.append("\t}");
		return sb.toString();
	}
}
