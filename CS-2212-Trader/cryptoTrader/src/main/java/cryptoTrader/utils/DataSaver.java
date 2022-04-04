// package cryptoTrader.utils;

import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataSaver {
	
	public static void putData(String fileName, String key, String data) {
		JSONObject newData = new JSONObject();
		newData.put(key, data);
        try (FileWriter newFile = new FileWriter(fileName)) {
        	// writing to the newly made file
            newFile.write(newData.toJSONString()); 
            newFile.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getData(String fileName, String key) {
		// creating the JSON parser object
		JSONParser parser = new JSONParser();
		
		// attempting to read the file
		try (FileReader storedFile = new FileReader(fileName)) {
			// reading the file
			Object fileObj = parser.parse(storedFile);
			return (JSONObject) fileObj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ParseException e) {
            e.printStackTrace();
        } catch (Error e) {
			e.printStackTrace();
		}
		
		return new JSONObject();
	}

	public static void main(String[] args) {
		DataSaver.putData("yur", "hello", "its ross");
		JSONObject storedObj = DataSaver.getData("yur", "hello");
		System.out.println();
	}
}
