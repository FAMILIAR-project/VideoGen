package videogen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;

public class FFMPEGHelper {

	public static final String randomGenerationVideo(int duration) {
		try {
			File tmpFile = File.createTempFile("IDM_video-", ".avi", new File("."));
			FileUtils.forceDelete(tmpFile);
			String filePath = tmpFile.getName();
			randomGenerationVideo(filePath, duration);
			return filePath;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static final void randomGenerationVideo(String path, int duration) {
		String[] cmd = new String[] { "ffmpeg", "-y", "-loglevel", "panic", "-f", "rawvideo", "-video_size", "500x400",
				"-pixel_format", "yuv420p", "-framerate", "24", "-i", "/dev/urandom", "-ar", "9600", "-ac", "2", "-f",
				"s16le", "-i", "/dev/urandom", "-codec:a", "copy", "-t", new Integer(duration).toString(), path };
		Utils.commandExec(cmd);
	}

	public static final int computeDuration(String path) {
		String[] cmd = new String[] { "ffprobe", path, "-show_entries", "format=duration" // ,"-v"
																							// ,"quiet"
				, "-of", "default=noprint_wrappers=1:nokey=1" };
		String durationString = Utils.commandExec(cmd);
		double durationDouble = Double.parseDouble(durationString);
		int durationInt = (int) Math.round(durationDouble);
		return durationInt;
	}

	public static final String generateThumbnail(String filePath) {
		int duration = computeDuration(filePath);
		String outputImagePath = getFilePathWithoutExtention(filePath) + "_tb.png";
		int selectedFrame = duration / 2;
		String[] cmd = new String[] { "ffmpeg", "-y", "-i", filePath, "-ss", new Integer(selectedFrame).toString(),
				"-vframes", "1", outputImagePath };
		Utils.commandExec(cmd);
		return outputImagePath;
	}

	private static String getFilePathWithoutExtention(String filePath) {
		File file = new File(filePath);
		String baseName = Files.getNameWithoutExtension(file.getName());
		File parentFile = file.getParentFile();
		String parentPath = ".";
		if (parentFile != null) {
			parentPath = parentFile.getPath();
		}
		String outputImagePath = parentPath + "/" + baseName;
		return outputImagePath;
	}

	public static final String generateGif(String filePath) {
		String palettePath = "palette.png";
		String[] cmd = new String[] { "ffmpeg", "-y",
				"-i", filePath, "-vf", "fps=10,scale=320:-1:flags=lanczos,palettegen", palettePath };
		Utils.commandExec(cmd);

//		System.out.println("palette generated ["+palettePath+"]");
		String outputGifPath = getFilePathWithoutExtention(filePath) + ".gif";
		String[] cmd2 = new String[] { "ffmpeg", "-y", "-i", filePath, "-i", palettePath, "-filter_complex",
				"fps=10,scale=320:-1:flags=lanczos[x];[x][1:v]paletteuse", outputGifPath };
		Utils.commandExec(cmd2);

//		System.out.println("gif generated ["+outputGifPath+"]");

		try {
			FileUtils.forceDelete(new File(palettePath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return outputGifPath;
	}
}
