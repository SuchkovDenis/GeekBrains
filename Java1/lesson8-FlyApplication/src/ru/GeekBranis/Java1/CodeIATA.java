package ru.GeekBranis.Java1;


public class CodeIATA {
    private String name_RU, name_EN, state, code_IATA;

    public String getName_RU() {
        return name_RU;
    }

    public String getName_EN() {
        return name_EN;
    }

    public String getState() {
        return state;
    }

    public String getCode_IATA() {
        return code_IATA;
    }


    public CodeIATA(String name_RU, String name_EN, String state, String code_IATA) {
        this.name_RU = name_RU;
        this.name_EN = name_EN;
        this.state = state;
        this.code_IATA = code_IATA;
    }
}