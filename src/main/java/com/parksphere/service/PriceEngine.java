package com.parksphere.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

public class PriceEngine {

	public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {

		long minutes = Duration.between(entryTime, exitTime).toMinutes();

		if (minutes <= 10)
			return 20;

		double hours = minutes / 60.0;

		if (hours <= 1)
			return 30;

		if (hours <= 4) {

			int additionalHours = (int) Math.ceil(hours - 1);

			return 30 + (additionalHours * 10);
		}

		if (hours <= 6)
			return 120;

		if (hours <= 8)
			return 200;

		if (hours <= 12)
			return 250;

		if (hours <= 24)
			return 300;

		long extraDays = (long) Math.ceil((hours - 24) / 24.0);

		return 300 + (extraDays * 100);
	}

	public double calculateAmount(Timestamp entryTime, LocalDateTime exitTime, int ignored) {

		if (entryTime == null)
			return 0;

		LocalDateTime entry = entryTime.toLocalDateTime();

		return calculateAmount(entry, exitTime);
	}
}