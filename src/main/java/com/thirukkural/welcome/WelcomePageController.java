package com.thirukkural.welcome;

public class WelcomePageController implements WelcomePageControllerCallBack, WelcomePageModelControllerCallBack {
	private WelcomePageViewCallBack welcomePageView;
	private WelcomePageModelCallBack welcomePageModel;
	public WelcomePageController(WelcomePageView welcomePageView) {
		this.welcomePageView = welcomePageView;
		welcomePageModel = new WelcomePageModel(this);
	}
	@Override
	public void decideOptions(int option) {
		switch(option) {
		case 1:
			welcomePageView.getThirukkuralByNumber();
			break;
		case 2:
			welcomePageModel.getThirukkuralCategory();
			break;
		case 3:
			
		}
	}

}
