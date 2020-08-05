package com.testing.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Random;

public class RandomModelGenerator {

    static String[] countries = {"Mexico","Ukraine","Mexico",
            "USA","Germany", "Canada" };

    private static String[] cities = {"Lviv","Kyiv","Kharkiv","Odesa","Dnipro",
            "Donetsk","Zaporizhia", "Mykolaiv", "Poltava" };

    public static String getRandomString() {
        String randomChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder rand = new StringBuilder();
        Random rnd = new Random();
        while (rand.length() < 10) {
            int index = (int) (rnd.nextFloat() * randomChars.length());
            rand.append(randomChars.charAt(index));
        }
        return rand.toString();
    }

    public static String getRandomString(int length) {
        String randomChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder rand = new StringBuilder();
        Random rnd = new Random();
        while (rand.length() < length) {
            int index = (int) (rnd.nextFloat() * randomChars.length());
            rand.append(randomChars.charAt(index));
        }
        return rand.toString();
    }

    public static Integer getRandomInteger() {
        Random rand = new Random();
        return rand.nextInt((Integer.MAX_VALUE - 1) + 1) + 1;
    }

    public static String getRandomMail() {
        return getRandomString() + "@gmail.com";
    }

    public static Boolean getRandomBoolean() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public static String getRandomFromArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    public static Date getRandomDate(){
        return new Date();
    }

    public static InfoRequestModel generateRandomInfo() {
        return new InfoRequestModelBuilder().
                lastName(getRandomString()).
                firstName(getRandomString()).
                city(getRandomFromArray(cities)).
                country("Ukraine").
                build();
    }
}
