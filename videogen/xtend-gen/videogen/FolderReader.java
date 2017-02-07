package videogen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Test;

public class FolderReader {
	
	private String videoGen = "VideoGen {";
	private int cpt = 1;
	private ArrayList<Path> currentPaths;

	@Test
	public void TestLauncher() {
		Path path = Paths.get("");
		String s = path.toAbsolutePath().toString();
		GenerateVideoGenFile(s + "/resources/GenerationFolder", "generationTest");
	}

	public void GenerateVideoGenFile(String path, String fileName) {
			
		videoGen = "VideoGen {\n";
		cpt = 1;
		currentPaths = new ArrayList<>();

		try (Stream<Path> paths = Files.walk(Paths.get(path))) {
			(paths.sorted()).forEach(filePath -> {
				if (Files.isDirectory(filePath)) {
					if (filePath.endsWith("v"+cpt)) {
						if(cpt!=1) handleFolder();
						cpt++;
					}
				}
				else if (Files.isRegularFile(filePath)) {
					currentPaths.add(filePath);
				}

			});
			handleFolder();
			videoGen+="}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Generating file
		try {
			PrintWriter out = new PrintWriter(fileName+".videogen");
			out.println(videoGen);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void handleFolder(){
		cpt--;
		if(currentPaths.size()==0) return;
		if(currentPaths.size()==1){
			String name = currentPaths.get(0).getName(currentPaths.get(0).getNameCount()-1).toString();
			name = name.split("\\.")[0];
			videoGen+="\tmandatory videoseq "+name+" \""+currentPaths.get(0)+"\"\n";
		}
		else{
			videoGen+="\talternatives v"+cpt+" {\n";
			currentPaths.forEach((a)->{
				String name = a.getName(a.getNameCount()-1).toString();
				name = name.split("\\.")[0];
				videoGen+="\t\tvideoseq "+name+" \""+a+"\"\n";
			});
			videoGen+="\t}\n";
		}
		currentPaths = new ArrayList<>();
		cpt++;
	}

}
