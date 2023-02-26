package com.thirukkural.adhigaram;

import org.json.simple.JSONObject;

import com.thirukkural.dto.Adhigaram;
import com.thirukkural.dto.Kural;

public interface AdhigaramModelControllerCallBack {

	void fileNotFound(String string);

	void adhigaramReceived(Adhigaram adhigaram);

	void parseExceptionRaised(String msg);

	void showAllKural(Kural[] kural);

}
