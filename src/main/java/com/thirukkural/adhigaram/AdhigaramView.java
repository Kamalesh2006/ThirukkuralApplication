package com.thirukkural.adhigaram;

public class AdhigaramView implements AdhigaramViewCallBack{
	private AdhigaramControllerCallBack adhigaramController;
	public AdhigaramView() {
		this.adhigaramController = new AdhigaramController(this);
	}
	
}
