package com.javarush.task.task19.task1903;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
//        IncomeData d = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "UA";
//            }
//
//            @Override
//            public String getCompany() {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Ivan";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Ivanov";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 38;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 501234567;
//            }
//        };
//        IncomeDataAdapter adapter = new IncomeDataAdapter(d);
//        adapter.getPhoneNumber();
//        System.out.println(System.currentTimeMillis());

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String res, prefix, suffix;
            prefix = String.valueOf(data.getCountryPhoneCode());
            if (String.valueOf(data.getPhoneNumber()).length() < 10){
                suffix = String.format("%010d", data.getPhoneNumber());
            } else suffix = String.valueOf(data.getPhoneNumber());

                res = String.format("+%s", prefix).concat("(").concat(suffix.substring(0, 3)).concat(")").concat(suffix.substring(3, 6))
                        .concat("-").concat(suffix.substring(6,8)).concat("-").concat(suffix.substring(8,10));
                return res;

        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}