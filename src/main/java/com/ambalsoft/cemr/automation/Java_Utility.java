package com.ambalsoft.cemr.automation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Java_Utility {

	/**
	 * This method is used to return the current date and time
	 * @return
	 */
	public static String currentLocalDateTime() {
		
		LocalDateTime lcd = LocalDateTime.now();
		LocalDateTime nextSlot = lcd.plusMinutes(15);
		int minute = nextSlot.getMinute();
        int adjustment = 15 - (minute % 15);  // how many minutes to add
        if (adjustment != 15) {
            nextSlot = nextSlot.plusMinutes(adjustment);
        }
        nextSlot = nextSlot.withSecond(0).withNano(0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy h:mm:ss a",Locale.ENGLISH);
		String formattedDateTime = nextSlot.format(formatter);
		System.out.println("Next Appointment Slot: " + formattedDateTime);
		
		return formattedDateTime;
	}
	
	public static void main(String[] args) {
		
		System.out.println(currentLocalDateTime());
		
	}
}
