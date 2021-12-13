package com.hackerrank.algorrithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeConversion {
    public static String timeConversion (String s) {
        // Write your code here
        Map<String, String> hours = new HashMap<>();
        hours.put("12", "00");
        hours.put("01", "13");
        hours.put("02", "14");
        hours.put("03", "15");
        hours.put("04", "16");
        hours.put("05", "17");
        hours.put("06", "18");
        hours.put("07", "19");
        hours.put("08", "20");
        hours.put("09", "21");
        hours.put("10", "22");
        hours.put("11", "23");

        String input = s;
        String AM = "AM";
        String PM = "PM";
        String hour = s.substring(0, s.indexOf(":"));
        s = s.substring(s.indexOf(hour) + 3);
        String min = s.substring(0, s.indexOf(":"));
        s = s.substring(s.indexOf(min) + 3);
        String sec = s.substring(0, s.length() - 2);

        boolean afterNoonPM = Integer.parseInt(hour) < 12 && input.contains(PM) || input.equals("12:00:00AM")
                    || (Integer.parseInt(hour) == 12 && input.contains(AM));

        if (afterNoonPM) {
            StringBuilder sb = new StringBuilder();
            String s1 = hours.get(hour);
            sb.append(s1).append(":").append(min).append(":").append(sec);
            return sb.toString();
        }
        return input.substring(0, input.length() - 2);
    }

    public static void main (String[] args) {
        List<String> strings = Arrays.asList("07:05:45PM", "12:00:00AM", "12:00:00PM", "12:45:54PM", "12:00:01AM", "12:40:22AM");
        strings.forEach(input -> {
            System.out.println("input: " + input);
            String s = TimeConversion.timeConversion(input);
            System.out.println("output:" + s);
        });

    }
}
