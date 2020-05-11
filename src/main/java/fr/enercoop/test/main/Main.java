package fr.enercoop.test.main;

import java.util.List;
import java.util.Map;

import fr.enercoop.test.util.FileReader;
import fr.enercoop.test.util.IdCounter;

public class Main {

	public static void main(String[] args) {

			List<String> ids = FileReader.getIds("C:\\dev\\logs");
			Map<String, Long> sortedIds = IdCounter.sortDescending(ids);
			System.out.println(sortedIds);
			
	}

}
