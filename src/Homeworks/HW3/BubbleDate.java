package Homeworks.HW3;

public class BubbleDate {

    private String month;
    private int day;
    private int year; // a four digit number
    private int hour;
    private int minute;
    private boolean am;

    // no argument constructor
    public BubbleDate() {
        month = "January";
        day = 1;
        year = 2017;
        hour = 12;
        minute = 0;
        am = true;
    }

    public BubbleDate(String aMonth, int aDay, int aYear, int aHour, int aMinute, boolean aAm) {
        setDate(aMonth, aDay, aYear, aHour, aMinute, aAm); // invoking setDate() method
    }

    public BubbleDate(int aDay, int aHour, boolean aAm) {
        setDate(aDay, aHour, aAm);
    }

    // copy constructor
    public BubbleDate(BubbleDate wDate) {

        // not a real date
        if (wDate == null) {
            System.out.println("Fatal error.");
            System.exit(-1);
        }

        month = wDate.month;
        day = wDate.day;
        year = wDate.year;
        hour = wDate.hour;
        minute = wDate.minute;
        am = wDate.am;
    }

    public void setDate(String aMonth, int aDay, int aYear, int aHour, int aMinute, boolean aAm) {
        month = aMonth;
        day = aDay;
        year = aYear;
        hour = aHour;
        minute = aMinute;
        am = aAm;
    }

    public void setDate(int aDay, int aHour, boolean aAm) {
        setDate("September", aDay, 2017, aHour, 0, aAm);
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isAm() {
        return am;
    }

    @Override
    public String toString() {
        String abbrevMonth = month.substring(0,3);

        String amString = "";

        if (am) {
            amString = "AM";
        } else {
            amString = "PM";
        }

        String result = String.format("%d:%02d %s - %s %d, %d", hour, minute, amString, abbrevMonth, day, year);

        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof BubbleDate) {
            BubbleDate other = (BubbleDate) o;
            return month.equals(other.month) && day == other.day && year == other.year;
        } else {
            return false;
        }
    }
}