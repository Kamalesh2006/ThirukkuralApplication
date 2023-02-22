package com.thirukkural.searchthirukkural;

import org.json.simple.JSONObject;

public interface SearchThirukkuralViewCallBack {

	void printStatus(String string);

	void showKural(Long number,String line1, String line2, String tamilexplanation, String translation, String englishTranslation);

	void callBackToWelcomePage();

}
