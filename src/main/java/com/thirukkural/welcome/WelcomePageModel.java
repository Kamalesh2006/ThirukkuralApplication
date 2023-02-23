package com.thirukkural.welcome;

public class WelcomePageModel implements WelcomePageModelCallBack {
	private WelcomePageModelControllerCallBack welcomePageModel;
	public WelcomePageModel(WelcomePageController welcomePageController) {
		this.welcomePageModel = welcomePageController;
	}

}
