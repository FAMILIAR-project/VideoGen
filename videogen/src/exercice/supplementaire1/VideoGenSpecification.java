package exercice.supplementaire1;

import java.io.File;
import java.io.IOException;

import videogen.ProcessFFMPEG;

public class VideoGenSpecification {
	
	public static void main(String[] args) throws IOException {
		String videogenText = extractVideoGen(new File("supp1"));
		System.out.println(videogenText);
	}

	private static String extractVideoGen(File file) throws IOException {
		String res = "VideoGen {\n";
		for (File fil : file.listFiles()) {
			if (fil.listFiles().length==1) {
				res = res + "	mandatory videoseq " + fil.getName() + "\" " + 
						fil.listFiles()[0].getName() + "\"";
				String aa = ProcessFFMPEG.getDuration(fil.listFiles()[0].getAbsolutePath());
				if (aa != null && !aa.isEmpty()) {
					res = res + "{\n";
					res = res + "\t\tduration " + aa + "\n\t}";	
				}
				res = res + "\n";
				
			}
			else if (fil.listFiles().length>1) {
				res = res + "	alternatives " + fil.getName() + "{\n";
				for (File sub : fil.listFiles()) {
					res = res + "		videoseq vid41 \"" + sub.getName() + "\"";	
					String aa = ProcessFFMPEG.getDuration(sub.getAbsolutePath());
					if (aa != null && !aa.isEmpty()) {
						res = res + "{\n";
						res = res + "\t\tduration " + aa + "\n\t}";	
					}
					res = res + "\n";
					
				}
				res = res + "	}\n";
			}
		}
		res = res + "}\n";
		return res;
	}

}
