package com.github.SolaneJ.standard;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;

public class DateAndTimeManipulation {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        System.out.println("当前日期: " + currentDate);

        // 获取当前时间
        LocalTime currentTime = LocalTime.now();
        System.out.println("当前时间: " + currentTime);

        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("当前日期和时间: " + currentDateTime);

        // 获取当前时区的日期和时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("当前时区的日期和时间: " + zonedDateTime);

        // 计算两个日期之间的天数
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        Period period = Period.between(date1, date2);
        System.out.println("两个日期之间的天数: " + period.getDays());

        // 计算两个时间之间的小时数
        LocalTime time1 = LocalTime.of(10, 0);
        LocalTime time2 = LocalTime.of(12, 0);
        Duration duration = Duration.between(time1, time2);
        System.out.println("两个时间之间的小时数: " + duration.toHours());

        // 格式化日期和时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("格式化后的日期和时间: " + formattedDateTime);

        // 解析字符串为日期和时间
        String dateTimeString = "2023-10-01 14:30:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);
        System.out.println("解析后的日期和时间: " + parsedDateTime);

        // 使用 OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println("当前 UTC 时间: " + offsetDateTime);

        // 将 LocalDateTime 转换为 OffsetDateTime
        OffsetDateTime offsetDateTimeFromLocal = currentDateTime.atOffset(ZoneOffset.ofHours(8));
        System.out.println("转换后的 OffsetDateTime: " + offsetDateTimeFromLocal);

        // 格式化 OffsetDateTime
        String formattedOffsetDateTime = offsetDateTime.format(formatter);
        System.out.println("格式化后的 OffsetDateTime: " + formattedOffsetDateTime);

        // 解析字符串为 OffsetDateTime
        String offsetDateTimeString = "2023-10-01T14:30:00Z";
        OffsetDateTime parsedOffsetDateTime = OffsetDateTime.parse(offsetDateTimeString);
        System.out.println("解析后的 OffsetDateTime: " + parsedOffsetDateTime);
    }
}
