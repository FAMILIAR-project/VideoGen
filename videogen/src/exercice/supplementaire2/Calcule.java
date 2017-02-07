package exercice.supplementaire2;

import java.util.ArrayList;
import java.util.List;

import videogen.ProcessFFMPEG;

public class Calcule {
	
	public static int minSequence(ArrayList<SequenceVideo> videos) {
		int res = 1000;
		for(SequenceVideo seq : videos) {
			if (seq.getVariantes().size()<res) {
				res = seq.getVariantes().size();
			}
		}
		return res;
	}
	public static void generateDuration(List<SequenceVideo> seqs) {
		
		for (SequenceVideo seq : seqs) {
			int duration = 0;
			for (String variante : seq.getVariantes()) {
				 try {
						duration = duration + Integer.valueOf(ProcessFFMPEG.getDuration(variante));
					}
					catch(Exception e) {}
			}
			seq.setDuree(String.valueOf(duration));
		}
	}
	public static int maxSequence(ArrayList<SequenceVideo> videos) {
		int res = 0;
		for(SequenceVideo seq : videos) {
			if (seq.getVariantes().size()>res) {
				res = seq.getVariantes().size();
			}
		}
		return res;
	}
	
	public static double moySequence(ArrayList<SequenceVideo> videos) {
		double res = 0;
		for(SequenceVideo seq : videos) {
			res = Double.valueOf(seq.getVariantes().size())/videos.size() + res;
		}
		return res;
	}

}
