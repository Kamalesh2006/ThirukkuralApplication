package com.thirukkural.searchthirukkural;

import java.util.Random;

import org.json.simple.JSONObject;

import com.thirukkural.dto.Kural;

public class SearchThirukkuralController
		implements SearchThirukkuralControllerCallBack, SearchThirukkuralModelControllerCallBack {
	private SearchThirukkuralViewCallBack searchThirukkuralView;
	private SearchThirukkuralModelCallBack searchThirukkuralModel;

	public SearchThirukkuralController(SearchThirukkuralView searchThirukkuralView) {
		this.searchThirukkuralView = searchThirukkuralView;
		searchThirukkuralModel = new SearchThirukkuralModel(this);

	}

	@Override
	public void getThirukkuralOf(int number) {
		//kural number less than 1 and greater than 1330 doesn't exist
		if (number < 1 || number > 1330) {
			searchThirukkuralView
					.printStatus("நீங்கள் தவறான எண்ணை உள்ளிட்டுள்ளீர்கள். சரியான எண்ணை மீண்டும் உள்ளிடவும்");
		} else {
			searchThirukkuralModel.getThirukkuralJSon(number - 1);
		}
	}

	@Override
	public void fileNotFound(String msg) {
		searchThirukkuralView.printStatus(msg);
	}

	@Override
	public void parseExceptionRaised(String msg) {
		//if exception got raised in the connection
		searchThirukkuralView.printStatus(msg);
	}

	@Override
	public void decideOption(int option) {
		switch (option) {
		case 1:
			searchThirukkuralView.printStatus("மீண்டும் குறளைத் தேட ");
			break;
		case 2:
			searchThirukkuralView.callBackToWelcomePage();
		}
	}

	@Override
	public void generateRandom() {
		Random r = new Random();
		int rand = r.nextInt(1330);
		//choosing random kural
		//need to store the random generated number and check it
		//because same kural need not be shown for every press
		searchThirukkuralModel.getThirukkuralJSon(rand);
	}

	@Override
	public void showKural(Kural kural) {
		searchThirukkuralView.showKural(kural);
	}

}
