package ru.GeekBranis.Java1;



public class MyDate {
    private int day;
    private int month;
    private int year;

    @Override
    public String toString() {
        String day, month, year;
        if (this.day/10>0) {
            day = Integer.toString(this.day);
        } else {
            day = "0" + Integer.toString(this.day);
        }

        if (this.month/10>0) {
            month = Integer.toString(this.month);
        } else {
            month = "0" + Integer.toString(this.month);
        }

        year = Integer.toString(this.year);
        return day + "." + month + "." + year;
    }



    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static void main(String[] args) {
        MyDate date = new MyDate(14,23,2018);
        System.out.println(date);
    }
}
