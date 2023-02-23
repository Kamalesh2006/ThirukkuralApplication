package com.thirukkural.adhigaram;

public interface AdhigaramViewCallBack {

	void printStatus(String msgstring);

	void showAllKural(Long[] number, String[] line1, String[] line2, String[] tamilExplanation, String[] translation,
			String[] englishExplanation);

	void goToWelcomePage();

	void printAdhigaramName(String msg);

}
