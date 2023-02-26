package com.thirukkural.welcome;

import java.util.Scanner;

import com.thirukkural.adhigaram.AdhigaramView;
import com.thirukkural.searchthirukkural.SearchThirukkuralView;

public class WelcomePageView implements WelcomePageViewCallBack{
	private WelcomePageControllerCallBack welcomePageController;
	private SearchThirukkuralView searchThirukkural=new SearchThirukkuralView();
	private AdhigaramView adhigaramView;
	private Scanner scanner = new Scanner(System.in);
	public WelcomePageView(){
		this.welcomePageController = new WelcomePageController(this);
	}
	public void welcome(){
		System.out.println("\n1) திருக்குறளைத் எண் வாரியாக தேட 1ஐ அழுத்தவும்");
		System.out.println("2) திருக்குறள் அதிகாரங்கள் வாரியாக பார்க்க 2ஐ அழுத்தவும்");
		System.out.println("3) இன்றைய திருக்குறள் பார்க்க\n");
		int option = scanner.nextInt();
		welcomePageController.decideOptions(option);
	}
	@Override
	public void getThirukkuralByNumber() {
		searchThirukkural.showSearchThirukkural(this);
	}
	@Override
	public void getThirukkuralCategory() {
		adhigaramView = new AdhigaramView();
		adhigaramView.adhigaramSearch(this);
	}
	@Override
	public void getThirukkuralOfTheDay() {
		searchThirukkural.generateThirukkuralOfTheDay(this);
		
	}
}
