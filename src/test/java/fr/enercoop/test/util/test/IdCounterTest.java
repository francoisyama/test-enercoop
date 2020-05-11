package fr.enercoop.test.util.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.enercoop.test.util.IdCounter;

public class IdCounterTest {
	
	
	private static final List<String> TESTED_LIST = Arrays.asList("123", "23", "78", "42", "51", "78", "23", "78");
	private static HashMap<String, Long> expectedMap = new LinkedHashMap<String, Long>();
	
	
	
	public IdCounterTest() {
		expectedMap.put("78", 3L);
		expectedMap.put("23", 2L);
		expectedMap.put("123", 1L);
		expectedMap.put("51", 1L);
		expectedMap.put("42", 1L);
	}

	
	@Test
	public void testSortDescending() {
		Assertions.assertEquals(expectedMap, IdCounter.sortDescending(TESTED_LIST));
		
	}

}
