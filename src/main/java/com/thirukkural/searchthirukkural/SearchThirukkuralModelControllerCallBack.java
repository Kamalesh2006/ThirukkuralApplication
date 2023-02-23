package com.thirukkural.searchthirukkural;

import org.json.simple.JSONObject;

public interface SearchThirukkuralModelControllerCallBack {

	void fileNotFound(String msg);

	void parseExceptionRaised(String msg);

	void showKural(Long number, String line1, String line2, String tamilexplanation, String translation,
			String englishTranslation);

}
