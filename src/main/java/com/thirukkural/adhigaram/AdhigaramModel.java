package com.thirukkural.adhigaram;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AdhigaramModel implements AdhigaramModelCallBack {
	private AdhigaramModelControllerCallBack adhigaramController;
	public AdhigaramModel(AdhigaramController adhigaramController) {
		this.adhigaramController= adhigaramController;
	}
	@Override
	public void getAdhigaram(int adhigaramEnn) {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader(".\\jsonfiles\\thirukkuralAdhigaramEdited.json");
			Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject thirukuralAdhigaram =(JSONObject)obj;
			JSONArray array = (JSONArray)thirukuralAdhigaram.get("detail");
			JSONObject jsonObject = (JSONObject)array.get(adhigaramEnn);
			String name = (String)jsonObject.get("name");
			Long start = (Long)jsonObject.get("start");
			Long end = (Long)jsonObject.get("end");
			adhigaramController.adhigaramReceived(name,start,end);
		}
		catch(FileNotFoundException e) {
			adhigaramController.fileNotFound("File not found");
		}
	}
	@Override
	public void getAdhigaramKural(int start, int end) {
		JSONParser jsonParser = new JSONParser();
		Long[] number = new Long[10];
		String[] line1 = new String[10];
		String[] line2 = new String[10];
		String[] tamilExplanation= new String[10];
		String[] translation = new String[10];
		String[] englishExplanation = new String[10];
		int startIndex =0;
		try {
			FileReader reader = new FileReader(".\\jsonfiles\\thirukkural.json");
			Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (IOException | ParseException e) {
				adhigaramController.parseExceptionRaised("Parse Exception raised");
				return;
			}
			JSONObject thirukuralJson = (JSONObject)obj;
			while(startIndex<10) {
				JSONArray array = (JSONArray)thirukuralJson.get("kural");
				JSONObject kuraljsonObject = (JSONObject)array.get(start);
				number[startIndex] = (Long)kuraljsonObject.get("Number");
				line1[startIndex] = (String)kuraljsonObject.get("Line1");
				line2[startIndex] = (String)kuraljsonObject.get("Line2");
				tamilExplanation[startIndex]=(String)kuraljsonObject.get("mv");
				translation[startIndex] = (String)kuraljsonObject.get("Translation");
				englishExplanation[startIndex] = (String)kuraljsonObject.get("explanation");
				start++;
				startIndex++;
			}
			adhigaramController.showAllKural(number,line1,line2,tamilExplanation,translation,englishExplanation);
			
			
		}catch(FileNotFoundException e) {
			adhigaramController.fileNotFound("File not found");
		}
	}

}
