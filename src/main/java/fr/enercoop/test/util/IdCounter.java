package fr.enercoop.test.util;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdCounter {

	private static Map<String, Long> countIds(List<String> ids) {
		return ids.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static Map<String, Long> sortDescending(List<String> ids) {
		LinkedHashMap<String, Long> reverseSortedIds = new LinkedHashMap<>();
		countIds(ids).entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.forEachOrdered(x -> reverseSortedIds.put(x.getKey(), x.getValue()));
		return reverseSortedIds;
	}

}
