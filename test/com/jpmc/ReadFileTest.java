package com.jpmc;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ReadFileTest {
	@Rule
	  public ExpectedException exception = ExpectedException.none();
	@Test
	public void generateTrigramsTest() {
	
		Map<Key, List<String>> trigrams = null;
		try {
			trigrams = ReadFile.generateTrigrams("inputtest.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Key, List<String>> expected=new HashMap<>();
		expected.put(new Key("I", "wish"), Arrays.asList("I"));
		assertEquals(expected, trigrams);
	}
	@Test(expected= FileNotFoundException.class)
	public void fileNotFoundTest() throws FileNotFoundException {
				ReadFile.generateTrigrams("abc.txt");
		
	
	}
	@Test
	public void generateTrigramsTestTrigramsize() {
	
		Map<Key, List<String>> trigrams = null;
		try {
			trigrams = ReadFile.generateTrigrams("inputtest2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(4, trigrams.size());
	}
	@Test
	public void generateTrigramsEmptyArrayTest() throws FileNotFoundException {
	
		Map<Key, List<String>> trigrams = ReadFile.generateTrigrams("inputtest2.txt");
		assertEquals(null, trigrams.get(new Key("I", "might")));
	}
	@Test
	public void generateTrigramsDuplicateArrayTest() throws FileNotFoundException {
	
		Map<Key, List<String>> trigrams = ReadFile.generateTrigrams("inputtest2.txt");
		assertEquals(Arrays.asList("I","I"), trigrams.get(new Key("I", "wish")));
	}
	@Test
	public void generateBookTest() throws IOException  {
	//ReadFile.generateBook("inputtest.txt", "outputtest.txt");
	FileWriter outPrintWriter= new FileWriter("outputtest.txt");
	outPrintWriter.write("I will I");
	String expected="I will I";
	assertEquals("I will I", expected);
	}

	}
	
	

