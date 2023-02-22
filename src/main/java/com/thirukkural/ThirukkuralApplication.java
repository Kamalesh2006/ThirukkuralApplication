package com.thirukkural;

import com.thirukkural.welcome.WelcomePageView;

public class ThirukkuralApplication {
	public static void main(String[] args) {
		System.out.println("\tதிருக்குறள் செயலிக்கு வரவேற்கிறோம்");
		//System.out.println("Welcome to Thirukkural application");
		WelcomePageView welcomepage = new WelcomePageView();
		welcomepage.welcome();
	}
}
