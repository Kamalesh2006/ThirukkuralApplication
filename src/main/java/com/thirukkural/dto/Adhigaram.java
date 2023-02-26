package com.thirukkural.dto;

public class Adhigaram {
	private String name;
	private Long start;
	private Long end;
	public Adhigaram(String name, Long start, Long end) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.end = end;
	}
	
}	
