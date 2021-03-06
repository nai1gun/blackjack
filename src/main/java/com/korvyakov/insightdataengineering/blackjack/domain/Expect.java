package com.korvyakov.insightdataengineering.blackjack.domain;

/**
 * Contains the data application expect from user
 *
 * @author nailgun
 * @since 13.07.14
 */
public class Expect {

    private String description;

    private boolean number;

    private int numberMin;

    private int numberMax;

    private String[] options;

    private Expect(){}

    public static Expect expectNumber(String description, int min, int max) {
        Expect expect = new Expect();
        expect.setDescription(description);
        expect.setNumber(true);
        expect.setNumberMin(min);
        expect.setNumberMax(max);
        return expect;
    }

    public static Expect expectOptions(String description, String... options) {
        Expect expect = new Expect();
        expect.setDescription(description);
        expect.setNumber(false);
        expect.setOptions(options);
        return expect;
    }

    public static Expect none() {
        return new Expect();
    }

    public boolean isNone() {
        return description == null;
    }

    public String getRegexp() {
        if (isNone() || options == null) {
            throw new IllegalStateException("Wrong state");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            if (i > 0) {
                sb.append("|");
            }
            sb.append(options[i]);
        }
        return sb.toString();
    }

    public String getPrompt() {
        if (isNone()) {
            throw new IllegalStateException("Wrong state");
        } else if (number) {
            return String.format("from @|bold %s|@ to @|bold %s|@", numberMin, numberMax);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < options.length; i++) {
                if (i > 0) {
                    sb.append(" or ");
                }
                sb.append(String.format("@|bold %s|@", options[i]));
            }
            return sb.toString();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    public int getNumberMin() {
        return numberMin;
    }

    public void setNumberMin(int numberMin) {
        this.numberMin = numberMin;
    }

    public int getNumberMax() {
        return numberMax;
    }

    public void setNumberMax(int numberMax) {
        this.numberMax = numberMax;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
