package com.thirukkural.searchthirukkural;

import java.util.Scanner;

import com.thirukkural.dto.Kural;
import com.thirukkural.welcome.WelcomePageView;

public class SearchThirukkuralView implements SearchThirukkuralViewCallBack {
	private Scanner scanner = new Scanner(System.in);
	private WelcomePageView welcomePage;
	private SearchThirukkuralControllerCallBack searchThirukkuralController;

	public SearchThirukkuralView() {
		this.searchThirukkuralController = new SearchThirukkuralController(this);
	}
	//this is the first function user encounter when he/she chooses to see kural by number
	public void showSearchThirukkural(WelcomePageView welcomePage) {
		this.welcomePage = welcomePage;
		System.out.println("திருக்குறள் எண்ணை (1/1330) உள்ளிடவும்");
		int number = scanner.nextInt();
		searchThirukkuralController.getThirukkuralOf(number);
	}

	@Override
	public void printStatus(String msg) {
		System.out.println(msg);
		showSearchThirukkural(welcomePage);
	}

	@Override
	//printing only kural number, kural and tamil and english explanation
	public void showKural(Kural kural) {
		System.out.println("குறள் எண் " + kural.getNumber());
		System.out.println("----------------------------------------------");
		System.out.println(" " + kural.getLine1());
		System.out.println(" " + kural.getLine2());
		System.out.println("----------------------------------------------");
		System.out.println("தமிழ் விளக்கம்: " + kural.getTamilExplanation());
		System.out.println("\nEnglish Translation: " + kural.getTranslation());
		System.out.println(kural.getEnglishExplanation());
		System.out.println("வேறு குறளில் தேட வேண்டுமா? (1=ஆம்/2=இல்லை)");
		int option = scanner.nextInt();
		searchThirukkuralController.decideOption(option);

	}

	@Override
	public void callBackToWelcomePage() {
		welcomePage.welcome();
	}

	public void generateThirukkuralOfTheDay(WelcomePageView welcomePageView) {
		this.welcomePage = welcomePageView;
		System.out.println("இன்றைய திருக்குறள்");
		//generating different kurals for every press
		searchThirukkuralController.generateRandom();
	}
}
