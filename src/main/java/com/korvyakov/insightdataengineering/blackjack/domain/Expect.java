package com.korvyakov.insightdataengineering.blackjack.domain;

/**
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

    public String getRegexp() {
        if (options == null) {
            throw new IllegalStateException("No options for regexp");
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
        if (number) {
            return "from " + numberMin + " to " + numberMax;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < options.length; i++) {
                if (i > 0) {
                    sb.append(" or ");
                }
                sb.append(options[i]);
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
