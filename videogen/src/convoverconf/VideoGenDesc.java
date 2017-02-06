package convoverconf;

import java.util.ArrayList;
import java.util.List;

//QUESTION BONUS 1
public class VideoGenDesc {

	private List<IVideoGenDesc> listDesc= new ArrayList<>();

	void add(IVideoGenDesc desc) {
		this.listDesc.add(desc);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("VideoGen {\n");

		for (IVideoGenDesc desc : this.listDesc) {
			sb.append(desc.toString() + "\n");
		}
		
		sb.append("}");

		return sb.toString();
	}
}
