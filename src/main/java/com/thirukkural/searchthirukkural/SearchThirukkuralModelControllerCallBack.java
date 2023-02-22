package com.thirukkural.searchthirukkural;

import org.json.simple.JSONObject;

public interface SearchThirukkuralModelControllerCallBack {

	void fileNotFound(String msg);

	void parseExceptionRaised(String msg);

	void kuralJSON(JSONObject kuraljsonObject);

}
