package exercice.supplementaire2;

import java.util.List;

public class SequenceVideo {
	
	private Integer id;
	
	private String taille;
	
	private List<String> variantes;
	
	private String duree;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public List<String> getVariantes() {
		return variantes;
	}

	public void setVariantes(List<String> variantes) {
		this.variantes = variantes;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	
}
