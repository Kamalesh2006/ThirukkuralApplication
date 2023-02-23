package com.thirukkural.adhigaram;

public class AdhigaramController implements AdhigaramControllerCallBack, AdhigaramModelControllerCallBack {
	private AdhigaramViewCallBack adhigaramView;
	private AdhigaramModelCallBack adhigaramModel;
	public AdhigaramController(AdhigaramView adhigaramView) {
		this.adhigaramView = adhigaramView;
		adhigaramModel = new AdhigaramModel(this);
	}
	@Override
	public void adhigaramSearch(int adhigaramEnn) {
		if(adhigaramEnn<1 || adhigaramEnn>133) {
			adhigaramView.printStatus("நீங்கள் தவறான அதிகார எண்ணை உள்ளிட்டுள்ளீர்கள்");
			return;
		}
		else {
			//json object is obtained based on the index
			adhigaramModel.getAdhigaram(adhigaramEnn-1);
		}
	}
	@Override
	public void fileNotFound(String msg) {
		adhigaramView.printStatus(msg);
	}
	@Override
	public void adhigaramReceived(String name, Long start, Long end) {
		adhigaramView.printAdhigaramName("அதிகாரம் பெயர் "+name);
		long s = start-1;
		long e = end;
		adhigaramModel.getAdhigaramKural((int)s,(int)e);
	}
	@Override
	public void parseExceptionRaised(String msg) {
		adhigaramView.printStatus(msg);
	}
	
	@Override
	public void decideOption(int option) {
		switch(option) {
		case 1:
			adhigaramView.printStatus("மீண்டும் குறளைத் தேட");
			break;
		case 2:
			adhigaramView.goToWelcomePage();
			break;
		}
	}
	@Override
	public void showAllKural(Long[] number, String[] line1, String[] line2, String[] tamilExplanation,
			String[] translation, String[] englishExplanation) {
		adhigaramView.showAllKural(number, line1, line2, tamilExplanation, translation, englishExplanation);
		
	}

}
