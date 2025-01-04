package ru.otus.java.basic.homeworks.homework_10;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    static HashMap<String, ArrayList<String>> phoneNumbersList = new HashMap<>();

    public void add(String name, String phoneNumber) {
        phoneNumbersList.putIfAbsent(name, new ArrayList<>());
        ArrayList<String> numbers = phoneNumbersList.get(name);
        if (!phoneNumbersList.get(name).contains(phoneNumber)) {
            phoneNumbersList.get(name).add(phoneNumber);
        }
    }

    public ArrayList<String> find(String name) {
        return phoneNumbersList.getOrDefault(name, new ArrayList<>());
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (ArrayList<String> numbers : phoneNumbersList.values()) {
            if (numbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
