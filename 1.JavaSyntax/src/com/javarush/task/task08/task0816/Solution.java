package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Гир", dateFormat.parse("JUN 2 2012"));
        map.put("Уиллис", dateFormat.parse("JUL 3 2012"));
        map.put("Смит", dateFormat.parse("AUG 4 2012"));
        map.put("Духовны", dateFormat.parse("OCT 5 2012"));
        map.put("Андерсон", dateFormat.parse("NOV 6 2012"));
        map.put("Челентано", dateFormat.parse("JAN 6 2012"));
        map.put("Ришар", dateFormat.parse("FEB 7 2012"));
        map.put("Машков", dateFormat.parse("MAR 8 2012"));
        map.put("Хабенский", dateFormat.parse("APR 9 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            if ((pair.getValue().getMonth() >=5) && (pair.getValue().getMonth()<=7)) iterator.remove();
        }

    }

    public static void main(String[] args) throws ParseException {
        removeAllSummerPeople(createMap());

    }
}
