package com.thirukkural.searchthirukkural;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchThirukkuralModel implements SearchThirukkuralModelCallBack {
	private SearchThirukkuralModelControllerCallBack searchThirukkuralController;
	public SearchThirukkuralModel(SearchThirukkuralController searchThirukkuralController) {
		this.searchThirukkuralController = searchThirukkuralController;
	}
	@Override
	public void getThirukkuralJSon(int kuralEnn) {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader(".\\jsonfiles\\thirukkural.json");
			Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (IOException | ParseException e) {
				searchThirukkuralController.parseExceptionRaised("Parse Exception raised");
				return;
			}
			JSONObject thirukuralJson = (JSONObject)obj;
			JSONArray array = (JSONArray)thirukuralJson.get("kural");
			JSONObject kuraljsonObject = (JSONObject)array.get(kuralEnn);
			Long number = (Long)kuraljsonObject.get("Number");
			String line1 = (String)kuraljsonObject.get("Line1");
			String line2 = (String)kuraljsonObject.get("Line2");
			String tamilexplanation=(String)kuraljsonObject.get("mv");
			String translation = (String)kuraljsonObject.get("Translation");
			String englishTranslation = (String)kuraljsonObject.get("explanation");
			searchThirukkuralController.showKural(number,line1,line2,tamilexplanation,translation,englishTranslation);
			
		}catch(FileNotFoundException e) {
			searchThirukkuralController.fileNotFound("File not found");
		}
	}

}
