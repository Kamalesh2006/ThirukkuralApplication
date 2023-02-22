package com.thirukkural.adhigaram;

public class AdhigaramModel implements AdhigaramModelCallBack {
	private AdhigaramModelControllerCallBack adhigaramController;
	public AdhigaramModel(AdhigaramController adhigaramController) {
		this.adhigaramController= adhigaramController;
	}

}
