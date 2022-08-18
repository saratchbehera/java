package com.sarat.java8.lamdaExpressions;

import java.util.Arrays;
import java.util.List;

public class TimeSlotBooking {

	public static void main(String[] args) {

		List<TimeSlotBooking> timeSlots = Arrays.asList(new TimeSlotBooking(),new TimeSlotBooking(),
				new TimeSlotBooking(),new TimeSlotBooking(),new TimeSlotBooking(),new TimeSlotBooking(),
				new TimeSlotBooking(),new TimeSlotBooking(),new TimeSlotBooking(),new TimeSlotBooking());
	
		
		TimeSlotBooking firstValue = timeSlots.stream()
											  .filter(TimeSlotBooking::isAvailable)
											  .findFirst()
											  .orElse(new TimeSlotBooking());
	}

	public boolean isAvailable() {

		return false;
	}

	public boolean schedule() {

		return false;
	}

}
