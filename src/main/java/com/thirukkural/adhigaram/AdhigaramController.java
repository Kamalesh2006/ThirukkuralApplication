package com.thirukkural.adhigaram;

import com.thirukkural.dto.Adhigaram;
import com.thirukkural.dto.Kural;

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
	public void adhigaramReceived(Adhigaram adhigaram) {
		adhigaramView.printAdhigaramName("அதிகாரம் பெயர் "+adhigaram.getName());
		long s = adhigaram.getStart()-1;
		long e = adhigaram.getEnd();
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
	public void showAllKural(Kural[] adhigaramKural) {
		adhigaramView.showAllKural(adhigaramKural);
		
	}

}
