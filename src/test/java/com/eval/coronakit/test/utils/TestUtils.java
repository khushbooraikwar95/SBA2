package com.eval.coronakit.test.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// boiler-plate code
public class TestUtils 
{
	public static File businessTestFile;
	public static File boundaryTestFile;
	public static File exceptionTestFile;

	static 
	{
		businessTestFile = new File("./output_revised.txt");
		businessTestFile.delete();
		
		boundaryTestFile = new File("./output_boundary_revised.txt");
		boundaryTestFile.delete();
		
		exceptionTestFile = new File("./output_exception_revised.txt");
		exceptionTestFile.delete();
	}

	public static void yakshaAssert(String testName, Object result, File file) throws IOException 
	{
		FileWriter writer = new FileWriter(file, true);
		writer.append("\n" + testName + "=" + result);
		writer.flush();
		writer.close();
	}

	public static String currentTest(){
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
	// convert object into JSON
	public static String asJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString =  mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
		
	}
}