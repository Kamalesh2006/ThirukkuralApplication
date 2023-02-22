package com.thirukkural.adhigaram;

public class AdhigaramController implements AdhigaramControllerCallBack, AdhigaramModelControllerCallBack {
	private AdhigaramViewCallBack adhigaramView;
	private AdhigaramModelCallBack adhigaramModel;
	public AdhigaramController(AdhigaramView adhigaramView) {
		this.adhigaramView = adhigaramView;
		adhigaramModel = new AdhigaramModel(this);
	}

}
