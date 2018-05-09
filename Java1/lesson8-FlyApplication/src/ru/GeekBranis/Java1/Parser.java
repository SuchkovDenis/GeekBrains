package ru.GeekBranis.Java1;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;


public class Parser {
    private ArrayList<CodeIATA> cities;

    public Parser() {
        cities = new ArrayList<>();
        try {
            InputStream in = Parser.class.getResourceAsStream("IATA_codes.csv");
            Scanner sc = new Scanner(in);
            while (sc.hasNextLine()) {
                String[] s;
                s = sc.nextLine().split(Pattern.quote(";"));
                cities.add(new CodeIATA(s[0], s[1], s[2], s[3]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CodeIATA> getCities() {
        return cities;
    }

    public boolean checkCity(String city) {
        for (CodeIATA c : cities) {
            if ((c.getName_RU().toUpperCase().equals(city.toUpperCase()))||(c.getName_EN().toUpperCase().equals(city.toUpperCase()))) {
                return true;
            }
        }
        return false;
    }

    public String returnIATA(String city) {
        if (checkCity(city)) {
            for (CodeIATA c : cities) {
                if ((c.getName_RU().toUpperCase().equals(city.toUpperCase()))||(c.getName_EN().toUpperCase().equals(city.toUpperCase()))) {
                    return c.getCode_IATA();
                }
            }
        }
        return null;
    }

    public String returnName(String codeIata) {
        for (CodeIATA c : cities) {
            if (c.getCode_IATA().equals(codeIata)) {
                return c.getName_EN();
            }
        }
        return codeIata;
    }

}
