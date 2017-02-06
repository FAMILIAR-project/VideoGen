package convoverconf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//QUESTION BONUS 1
public class ConvOverConf {

	private static VideoGenDesc videogen =  new VideoGenDesc();

	public static void main(String[] args) {
		ConvOverConf convOverConf = new ConvOverConf();
		convOverConf.videogen = generateVideogen(new File("./input"));
		
		if(videogen != null){
			convOverConf.writeVideoGenFile(videogen, new File("vdg.videogen"));
		}
	}
    
	/** 
	 * Génère un object VideoGenDesc 
	 * Qui contient la description VideoGen du répertoire passé en paramètre
	 * **/
	public static VideoGenDesc generateVideogen(File directoryInputVideo) {
		
		boolean error = false;
		
		if (!directoryInputVideo.isDirectory()) {
			System.out.println("[DIRECTORY ERREUR]" + directoryInputVideo.getName() + " n'est pas un répertoire");
			error = true;
		}

		File[] files = directoryInputVideo.listFiles((dir, name) 
					 -> name.matches("v\\d+") 
					 && (new File(dir, name)).isDirectory());

		if (files == null) {
			System.out.println("[DIRECTORY ERREUR]" + directoryInputVideo.getName() + " ne contient aucun fichier ou repertoire");
			error = true;
		}
		
		if (!error) {

			for (File file : files) {
				String id = file.getName();

				File[] listVideos = file.listFiles((dir, name) -> !(new File(dir, name)).isDirectory() && new File(dir, name).getName().endsWith("mp4")) ;

				if (listVideos == null || listVideos.length == 0) {
					System.out.println("Le Répertoire est vide");
					break;
				} else if (listVideos.length == 1) {
					MandatoryDesc mandatoryDesc = new MandatoryDesc(id, listVideos[0].getAbsolutePath());
					videogen.add(mandatoryDesc);
				} else {
					AlternativeDesc alternativeDesc = new AlternativeDesc(id);
					for (File v : listVideos) {
						alternativeDesc.addPath(v.getAbsolutePath());
					}
					videogen.add(alternativeDesc);
				}
			}
		}
		return videogen;
	}

	/** 
	 * Ecrit la specification VideoGen dans un fichier
	 * **/
	public void writeVideoGenFile(VideoGenDesc videogen, File output) {
		FileWriter outputVidegen;
		try {
			outputVidegen = new FileWriter(output);
			outputVidegen.write(videogen.toString());
			outputVidegen.flush();
			outputVidegen.close();
			System.out.println("[SUCCES] Spécification VideoGen : " + output.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("[ERROR] Spécification VideoGen");
			e.printStackTrace();
		}
	}

}