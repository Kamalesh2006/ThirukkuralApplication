package com.thirukkural.adhigaram;

import org.json.simple.JSONObject;

public interface AdhigaramModelControllerCallBack {

	void fileNotFound(String string);

	void adhigaramReceived(String name, Long start, Long end);

	void parseExceptionRaised(String msg);

	void showAllKural(Long[] number, String[] line1, String[] line2, String[] tamilExplanation, String[] translation,
			String[] englishExplanation);

}
