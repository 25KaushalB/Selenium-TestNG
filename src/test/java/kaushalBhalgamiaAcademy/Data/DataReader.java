package kaushalBhalgamiaAcademy.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

//	public List<HashMap<String, String>> getJsonDatatoMap() throws IOException {
//		// Reading Json to String with Below Line of Code.
//		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.Dir")+"\\src\\test\\java\\kaushalBhalgamiaAcademy\\Data\\PurchaseOrder.json"), StandardCharsets.UTF_8);
//		
//		// Convert String to HashMap - Jackson Databind Dependency to Add
//		ObjectMapper mapper = new ObjectMapper();	
//		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
//		});
//		
//		return data;
//	}
}
