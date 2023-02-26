package com.thirukkural.searchthirukkural;

import com.thirukkural.dto.Kural;

public interface SearchThirukkuralViewCallBack {

	void printStatus(String string);

	void showKural(Kural kural);

	void callBackToWelcomePage();

}
