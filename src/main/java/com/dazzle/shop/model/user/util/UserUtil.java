package com.dazzle.shop.model.user.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;

public class UserUtil {

	// 최초로 접속 시 처음 날짜 설정
	public static Date getStartDate() {
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1).plusDays(1);

		return Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	// 최초로 접속 시 마지막 날짜 설정
	public static Date getEndDate() {
		LocalDate currentDate = LocalDate.now();
		LocalDateTime currentDateTime = currentDate.atTime(23, 59, 59);

		return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}
