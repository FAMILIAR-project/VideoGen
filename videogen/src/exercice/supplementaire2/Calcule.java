package exercice.supplementaire2;

import java.util.ArrayList;

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
