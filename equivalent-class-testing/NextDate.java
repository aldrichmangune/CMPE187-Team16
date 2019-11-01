public class NextDate {

    public static void main(String[] args) {
        System.out.println("Example:\nInput Date: 10/31/2019\nNext Day: " + nextDate(10, 31, 2019));
    }

    // Return the next date based on input date
    public static String nextDate(int month, int day, int year) {
        if (day < 1 || day > daysInMonth(month, year) || month < 1 || month > 12 || year < 1900 || year > 2100) {
            return "Invalid Date Input.";
        }
        if (day < daysInMonth(month, year)) {
            day++; // Increment day by 1 if day is within number of days in month
        } else {
            day = 1; // Re-assign day to 1
            if (month < 12) {
                month++; // Increment month by 1 if month is within 12
            } else {
                month = 1; // Re-assign month to 1
                year++; // Increment year by 1
            }
        }
        return displayNextDate(month, day, year);
    }

    // Return the correct number of days in corresponding month
    public static int daysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31; // Jan, Mar, May, July, Aug, Oct, Dec
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30; // Apr, Jun, Sep, Nov
        }
        if (month == 2) {
            return isLeap(year) ? 29 : 28; // Feb
        }
        return 0; // invalid month
    }

    // Check whether input year is a leap year
    public static boolean isLeap(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    // Display Date Nicely
    public static String displayNextDate(int month, int day, int year) {
        String strMonth = Integer.toString(month);
        if (strMonth.length() < 2) {
            strMonth = "0" + strMonth;
        }
        String strDay = Integer.toString(day);
        if (strDay.length() < 2) {
            strDay = "0" + strDay;
        }
        return strMonth + "/" + strDay + "/" + year;
    }
}