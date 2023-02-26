package com.thirukkural.adhigaram;

import java.util.Scanner;

import com.thirukkural.dto.Kural;
import com.thirukkural.welcome.WelcomePageView;

public class AdhigaramView implements AdhigaramViewCallBack {
	private AdhigaramControllerCallBack adhigaramController;
	private Scanner scanner = new Scanner(System.in);
	private WelcomePageView welcomeView;

	public AdhigaramView() {
		this.adhigaramController = new AdhigaramController(this);
	}
	//this is the first page the user encounter after application startup
	public void adhigaramSearch(WelcomePageView welcomeView) {
		this.welcomeView = welcomeView;
		System.out.println("அதிகாரம் வாரியான தேடலை தேர்ந்தெடுத்துள்ளீர்கள்");
		System.out.println("அதிகாரம் எண்ணை(1-133) உள்ளிடவும்");
		int adhigaramEnn = scanner.nextInt();
		adhigaramController.adhigaramSearch(adhigaramEnn);
	}

	@Override
	public void printStatus(String msg) {
		System.out.println(msg);
		adhigaramSearch(welcomeView);
	}

	@Override
	public void showAllKural(Kural[] adhigaramKural) {
		//printing 10 kurals of adhigaram
		int start = 0;
		int end = 10;
		while (start < end) {
			System.out.println("குறள் எண் " + adhigaramKural[start].getNumber());
			System.out.println("----------------------------------------------");
			System.out.println(" " + adhigaramKural[start].getLine1());
			System.out.println(" " + adhigaramKural[start].getLine2());
			System.out.println("----------------------------------------------");
			System.out.println("தமிழ் விளக்கம்: " + adhigaramKural[start].getTamilExplanation());
			System.out.println("\nEnglish Translation: " + adhigaramKural[start].getTranslation());
			System.out.println(adhigaramKural[start].getEnglishExplanation() + "\n");
			start++;
		}
		System.out.println("வேறு குறளில் தேட வேண்டுமா? (1=ஆம்/2=இல்லை)");
		int option = scanner.nextInt();
		adhigaramController.decideOption(option);
	}

	@Override
	public void goToWelcomePage() {
		welcomeView.welcome();
	}

	@Override
	public void printAdhigaramName(String adhigaram) {
		//used to display the adhigaram name
		System.out.println(adhigaram);
	}
}
