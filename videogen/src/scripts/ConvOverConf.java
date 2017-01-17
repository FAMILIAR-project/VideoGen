package scripts;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvOverConf {

	public static void main(String[] args) {
		generateVideogen(new File("/home/guillaume/Bureau/IDM/CoC"));
	}

	public static void generateVideogen(File directory) {
		if (!directory.isDirectory()) {
			System.err.println(directory.getName() + " is not a directory.");
			return;
		}
		File[] files = directory.listFiles((dir, name) -> name.matches("v\\d+") && (new File(dir, name)).isDirectory());

		if (files == null) {
			System.err.println("An error occurred when accessing the contents of " + directory.getName());
			return;
		}

		Arrays.sort(files, (o1, o2) -> {
			String name1 = o1.getName();
			String name2 = o2.getName();
			int v1 = Integer.parseInt(name1.substring(1));
			int v2 = Integer.parseInt(name2.substring(1));
			return v1 - v2;
		});

		SimplifiedVideoGen svg = new SimplifiedVideoGen();

		// Remplissage de la structure
		for (File file : files) {
			String id = file.getName();

			File[] videos = file.listFiles((dir, name) -> !(new File(dir, name)).isDirectory());

			if (videos == null || videos.length == 0) {
				System.err.println("Directory " + file.getName() + " is empty.");
				break;
			} else if (videos.length == 1) {
				svg.add(new SimplifiedMandatory(id, videos[0].getAbsolutePath()));
			} else {
				SimplifiedAlternative alt = new SimplifiedAlternative(id);
				for (File v : videos) {
					alt.addUrl(v.getAbsolutePath());
				}
				svg.add(alt);
			}
		}

		// Sauvegarde de la structure vers un .videogen
		String outputname = directory.getName() + ".videogen";
		File output = new File(directory, outputname);
		try {
			PrintWriter pw = new PrintWriter(output);
			pw.write(svg.toString());
			pw.flush();
			pw.close();
			System.out.println("File saved in : " + output.getCanonicalPath());
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private interface SimplifiedVideoDesc {

	}

	private static class SimplifiedMandatory implements SimplifiedVideoDesc {
		private String id;
		private String url;

		SimplifiedMandatory(String id, String url) {
			this.id = id;
			this.url = url;
		}

		@Override
		public String toString() {
			return String.format("\n\tmandatory videoseq %s \"%s\"", id, url);
		}
	}

	private static class SimplifiedAlternative implements SimplifiedVideoDesc {
		private String id;
		private List<String> urls = new ArrayList<>();

		SimplifiedAlternative(String id) {
			this.id = id;
		}

		void addUrl(String url) {
			urls.add(url);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append(String.format("\n\talternatives %s {", id));
			sb.append(System.lineSeparator());

			for (String url : urls) {
				sb.append(String.format("\t\tvideoseq \"%s\"", url));
				sb.append(System.lineSeparator());
			}

			sb.append("\t}");

			return sb.toString();
		}
	}

	private static class SimplifiedVideoGen {

		private List<SimplifiedVideoDesc> descriptions = new ArrayList<>();

		void add(SimplifiedVideoDesc desc) {
			descriptions.add(desc);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append("VideoGen {");
			sb.append(System.lineSeparator());

			for (SimplifiedVideoDesc desc : descriptions) {
				sb.append(desc.toString());
				sb.append(System.lineSeparator());
			}

			sb.append("}");

			return sb.toString();
		}
	}
}
