package com.example.testsieve;

public class Answer {

    String numbers;
    String summ;

    public Answer(String numbers, String summ) {
        this.numbers = numbers;
        this.summ = summ;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }
}
