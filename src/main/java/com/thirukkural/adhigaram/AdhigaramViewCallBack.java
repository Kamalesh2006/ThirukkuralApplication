package com.thirukkural.adhigaram;

import com.thirukkural.dto.Kural;

public interface AdhigaramViewCallBack {

	void printStatus(String msgstring);

	void showAllKural(Kural[] adhigaramKural);

	void goToWelcomePage();

	void printAdhigaramName(String msg);

}
