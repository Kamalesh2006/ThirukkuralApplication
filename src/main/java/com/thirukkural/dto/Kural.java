package com.thirukkural.dto;

public class Kural {
	private Long number;
	private String line1;
	private String line2;
	private String tamilExplanation;
	private String translation;
	private String englishExplanation;
	public Kural() {
		super();
		//default initialization
	}
	public Kural(Long number, String line1, String line2, String tamilExplanation, String translation,
			String englishExplanation) {
		super();
		this.number = number;
		this.line1 = line1;
		this.line2 = line2;
		this.tamilExplanation = tamilExplanation;
		this.translation = translation;
		this.englishExplanation = englishExplanation;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getTamilExplanation() {
		return tamilExplanation;
	}
	public void setTamilExplanation(String tamilExplanation) {
		this.tamilExplanation = tamilExplanation;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public String getEnglishExplanation() {
		return englishExplanation;
	}
	public void setEnglishExplanation(String englishExplanation) {
		this.englishExplanation = englishExplanation;
	}
	
}
