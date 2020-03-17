package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        String fullName = "Ivanov, Ivan";
//        System.out.println(fullName.substring(fullName.lastIndexOf(" ") + 1));
//        System.out.println(fullName.substring(0, fullName.lastIndexOf(",")));
//        String phoneNumber = "+38(050)123-45-67";
//        System.out.println("callto://+" + phoneNumber.replaceAll("\\D", ""));
//        String country = "Ukraine";
//        for (Map.Entry<String, String> entry: countries.entrySet()){
//            if (country.equals(entry.getValue())) {
//                System.out.println(entry.getKey());
//            }
//        }
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String countryCode = null;
            for (Map.Entry<String, String> entry: countries.entrySet()) {
                if (customer.getCountryName().equals(entry.getValue())) {
                    countryCode = entry.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().lastIndexOf(" ") + 1);
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0, contact.getName().lastIndexOf(","));
        }

        @Override
        public String getDialString() {
            return "callto://+" + contact.getPhoneNumber().replaceAll("\\D", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}