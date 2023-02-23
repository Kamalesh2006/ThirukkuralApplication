package com.thirukkural.adhigaram;

import java.util.Scanner;

import com.thirukkural.welcome.WelcomePageView;

public class AdhigaramView implements AdhigaramViewCallBack{
	private AdhigaramControllerCallBack adhigaramController;
	private Scanner scanner = new Scanner(System.in);
	private WelcomePageView welcomeView;
	public AdhigaramView() {
		this.adhigaramController = new AdhigaramController(this);
	}
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
	public void showAllKural(Long[] number, String[] line1, String[] line2, String[] tamilExplanation,
			String[] translation, String[] englishExplanation) {
		int start =0;
		int end =10;
		while(start<end) {
			System.out.println("குறள் எண் "+number[start]);
			System.out.println("----------------------------------------------");
			System.out.println(" "+line1[start]);
			System.out.println(" "+line2[start]);
			System.out.println("----------------------------------------------");
			System.out.println("தமிழ் விளக்கம்: "+tamilExplanation[start]);
			System.out.println("\nEnglish Translation: "+translation[start]);
			System.out.println(englishExplanation[start]+"\n");
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
		System.out.println(adhigaram);
	}
}
