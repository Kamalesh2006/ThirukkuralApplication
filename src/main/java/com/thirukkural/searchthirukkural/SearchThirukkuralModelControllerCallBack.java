package com.thirukkural.searchthirukkural;

import com.thirukkural.dto.Kural;

public interface SearchThirukkuralModelControllerCallBack {

	void fileNotFound(String msg);

	void parseExceptionRaised(String msg);

	void showKural(Kural kural);

}
