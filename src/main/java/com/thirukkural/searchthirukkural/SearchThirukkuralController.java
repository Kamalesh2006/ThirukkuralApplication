package com.thirukkural.searchthirukkural;

import org.json.simple.JSONObject;

public class SearchThirukkuralController implements SearchThirukkuralControllerCallBack, SearchThirukkuralModelControllerCallBack {
	private SearchThirukkuralViewCallBack searchThirukkuralView;
	private SearchThirukkuralModelCallBack searchThirukkuralModel;
	public SearchThirukkuralController(SearchThirukkuralView searchThirukkuralView) {
		this.searchThirukkuralView = searchThirukkuralView;
		searchThirukkuralModel = new SearchThirukkuralModel(this);
		
	}
	@Override
	public void getThirukkuralOf(int number) {
		if(number<1 || number>1330) {
			searchThirukkuralView.printStatus("நீங்கள் தவறான எண்ணை உள்ளிட்டுள்ளீர்கள். சரியான எண்ணை மீண்டும் உள்ளிடவும்");
		}
		else {
			searchThirukkuralModel.getThirukkuralJSon(number-1);
		}
	}
	@Override
	public void fileNotFound(String msg) {
		searchThirukkuralView.printStatus(msg);
	}
	@Override
	public void parseExceptionRaised(String msg) {
		searchThirukkuralView.printStatus(msg);
	}
	@Override
	public void kuralJSON(JSONObject kuraljsonObject) {
		Long number = (Long)kuraljsonObject.get("Number");
		String line1 = (String)kuraljsonObject.get("Line1");
		String line2 = (String)kuraljsonObject.get("Line2");
		String tamilexplanation=(String)kuraljsonObject.get("mv");
		String translation = (String)kuraljsonObject.get("Translation");
		String englishTranslation = (String)kuraljsonObject.get("explanation");
		searchThirukkuralView.showKural(number,line1,line2,tamilexplanation,translation,englishTranslation);
	}
	@Override
	public void decideOption(int option) {
		switch(option) {
		case 1:
			searchThirukkuralView.printStatus("மீண்டும் குறளைத் தேட ");
			break;
		case 2:
			searchThirukkuralView.callBackToWelcomePage();
		}
	}

}
