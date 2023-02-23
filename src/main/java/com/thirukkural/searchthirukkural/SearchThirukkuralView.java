package com.thirukkural.searchthirukkural;

import java.util.Scanner;

import com.thirukkural.welcome.WelcomePageView;

public class SearchThirukkuralView implements SearchThirukkuralViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private WelcomePageView welcomePage;
	private SearchThirukkuralControllerCallBack searchThirukkuralController;
	public SearchThirukkuralView() {
		this.searchThirukkuralController = new SearchThirukkuralController(this);
	}
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
	public void showKural(Long number,String line1, String line2, String tamilexplanation, String translation,
			String englishTranslation) {
		System.out.println("குறள் எண் "+number);
		System.out.println("----------------------------------------------");
		System.out.println(" "+line1);
		System.out.println(" "+line2);
		System.out.println("----------------------------------------------");
		System.out.println("தமிழ் விளக்கம்: "+tamilexplanation);
		System.out.println("\nEnglish Translation: "+translation);
		System.out.println(englishTranslation);
		System.out.println("வேறு குறளில் தேட வேண்டுமா? (1=ஆம்/2=இல்லை)");
		int option = scanner.nextInt();
		searchThirukkuralController.decideOption(option);
		
		
	}
	@Override
	public void callBackToWelcomePage() {
		welcomePage.welcome();
	}
	public void generateThirukkuralOfTheDay(WelcomePageView welcomePageView) {
		this.welcomePage=welcomePageView;
		System.out.println("அன்றைய திருக்குறள்");
		searchThirukkuralController.generateRandom();
	}
}
