import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {
	public static void main(String[] args) throws FileNotFoundException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\jsonfiles\\thirukkural.json");
		Object obj = null;
		try {
			obj = jsonParser.parse(reader);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject thirukuralJson = (JSONObject)obj;
		JSONArray array = (JSONArray)thirukuralJson.get("kural");
		JSONObject jsonObject = (JSONObject)array.get(135);
		String line1 = (String)jsonObject.get("Line1");
		String line2 = (String)jsonObject.get("Line2");
		System.out.println(line1);
		System.out.println(line2);
		
		FileReader reader2 = new FileReader(".\\jsonfiles\\thirukkuralAdhigaramEdited.json");
		Object obj2 = null;
		try {
			obj2 = jsonParser.parse(reader2);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject thirukuralAdhigaram =(JSONObject)obj2;
		JSONArray array2 = (JSONArray)thirukuralAdhigaram.get("detail");
		JSONObject jsonObject2 = (JSONObject)array2.get(1);
		String line3 = (String)jsonObject2.get("name");
		System.out.println(line3);
		
	}
}
