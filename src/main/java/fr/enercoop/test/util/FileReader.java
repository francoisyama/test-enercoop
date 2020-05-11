package fr.enercoop.test.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

public class FileReader {

	private static List<String> readFile(Path filePath) {
		List<String> fileLines = new ArrayList<>();
		try (Stream<String> file = Files.lines(Paths.get(filePath.toString()))) {
			fileLines = file.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileLines;
	}

	private static List<String> scanFolder(String folderPath) {
		List<String> filesLines = new ArrayList<>();
		try (Stream<Path> paths = Files.walk(Paths.get(folderPath)).filter(Files::isRegularFile)) {
			List<Path> filesPaths = paths.collect(Collectors.toList());
			for (Path p : filesPaths) {
				filesLines.addAll(readFile(p));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filesLines;
	}

	private static String getId(String url) {
		List<NameValuePair> params = new ArrayList<>();
		try {
			params = new URIBuilder(url).getQueryParams();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		for (NameValuePair pair : params) {
			if (pair.getName().equals("id")) {
				return pair.getValue();
			}
		}
		return "";
	}

	public static List<String> getIds(String folderPath) {
		List<String> lines = scanFolder(folderPath);
		List<String> ids = new ArrayList<>();
		for (String line : lines) {
			if (!getId(line).isBlank()) {
				ids.add(getId(line));
			}
		}
		return ids;
	}

}
