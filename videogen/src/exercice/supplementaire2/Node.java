package exercice.supplementaire2;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name;
	
	private List<Node> listSub;
	
	private Node parentNode;

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getListSub() {
		if (listSub == null) {
			listSub = new ArrayList<>();
		}
		return listSub;
	}

	public void setListSub(List<Node> listSub) {
		this.listSub = listSub;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
