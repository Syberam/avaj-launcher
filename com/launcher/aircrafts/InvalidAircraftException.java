package com.launcher.aircrafts;

public class InvalidAircraftException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidAircraftException(String message) {
		super(message);
	}
}