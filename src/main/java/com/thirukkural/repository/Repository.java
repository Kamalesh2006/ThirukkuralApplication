package com.thirukkural.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.thirukkural.dto.Adhigaram;
import com.thirukkural.dto.Kural;

public class Repository {
	private static Repository repository;
	private Object obj1;// for number vise search
	private Object obj2;//for adhigaram vise search
	private Repository() {
		init();
	}
	public static Repository getInstance() {
		if(repository==null) {
			repository = new Repository();
		}
		return repository;
	}
	private void init() {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader1 = new FileReader(".\\jsonfiles\\thirukkural.json");
			FileReader reader2 = new FileReader(".\\jsonfiles\\thirukkuralAdhigaramEdited.json");
			obj1 = null;
			try {
				obj1 = jsonParser.parse(reader1);
				obj2 = jsonParser.parse(reader2);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			//to be handled
			e.printStackTrace();
		}
	}
	public Kural getThirukural(int kuralEnn) {
		JSONObject thirukuralJson = (JSONObject)obj1;
		JSONArray array = (JSONArray)thirukuralJson.get("kural");
		JSONObject kuraljsonObject = (JSONObject)array.get(kuralEnn);
		Long number = (Long)kuraljsonObject.get("Number");
		String line1 = (String)kuraljsonObject.get("Line1");
		String line2 = (String)kuraljsonObject.get("Line2");
		String tamilexplanation=(String)kuraljsonObject.get("mv");
		String translation = (String)kuraljsonObject.get("Translation");
		String englishExplanation = (String)kuraljsonObject.get("explanation");
		return new Kural(number,line1,line2,tamilexplanation,translation,englishExplanation);
	}
	
	public Adhigaram getAdhigaram(int adhigaramEnn) {
		JSONObject thirukuralAdhigaram = (JSONObject) obj2;
		JSONArray array = (JSONArray) thirukuralAdhigaram.get("detail");
		JSONObject jsonObject = (JSONObject) array.get(adhigaramEnn);
		String name = (String) jsonObject.get("name");
		Long start = (Long) jsonObject.get("start");
		Long end = (Long) jsonObject.get("end");
		Adhigaram adhigaram = new Adhigaram(name,start,end);
		return adhigaram;
	}
	public Kural[] getAdhigaramKural(int start,int end) {
		Kural[] adhigaramKural = new Kural[10];
		JSONObject thirukuralJson = (JSONObject) obj1;
		JSONArray array = (JSONArray) thirukuralJson.get("kural");
		int index = 0;
		while (index < 10) {
			JSONObject kuraljsonObject = (JSONObject) array.get(start);
			adhigaramKural[index] = new Kural();
			adhigaramKural[index].setNumber((Long) kuraljsonObject.get("Number"));
			adhigaramKural[index].setLine1((String) kuraljsonObject.get("Line1"));
			adhigaramKural[index].setLine2((String) kuraljsonObject.get("Line2"));
			adhigaramKural[index].setTamilExplanation((String) kuraljsonObject.get("mv"));
			adhigaramKural[index].setTranslation((String) kuraljsonObject.get("Translation"));
			adhigaramKural[index].setEnglishExplanation((String) kuraljsonObject.get("explanation"));
			start++;
			index++;
		}
		return adhigaramKural;
	}
}
