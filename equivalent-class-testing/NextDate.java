public class NextDate {
    public static void main(String[] args) {
        randomTesting();

    }

    public static void randomTesting() {
        String expected = "10/15/1996";
        String actual = nextDate(10, 14, 1996);
        System.out.println("Random 1: " + checkEqual(expected, actual));
        expected = "01/01/2000";
        actual = nextDate(12, 31, 1999);
        System.out.println("Random 2: " + checkEqual(expected, actual));
        expected = "Invalid Date Input.";
        actual = nextDate(12, 31, 1899);
        System.out.println("Random 3: " + checkEqual(expected, actual));
        expected = "05/31/1985";
        actual = nextDate(5, 30, 1985);
        System.out.println("Random 4: " + checkEqual(expected, actual));
        expected = "Invalid Date Input.";
        actual = nextDate(2, 29, 1965);
        System.out.println("Random 5: " + checkEqual(expected, actual));
        expected = "01/01/2100";
        actual = nextDate(12, 31, 2099);
        System.out.println("Random 6: " + checkEqual(expected, actual));
        expected = "09/01/1996";
        actual = nextDate(8, 31, 1996);
        System.out.println("Random 7: " + checkEqual(expected, actual));
        expected = "Invalid Date Input.";
        actual = nextDate(6, 9, 6969);
        System.out.println("Random 8: " + checkEqual(expected, actual));
        expected = "Invalid Date Input.";
        actual = nextDate(4, 20, 420);
        System.out.println("Random 9: " + checkEqual(expected, actual));
        expected = "02/28/2019";
        actual = nextDate(2, 27, 2019);
        System.out.println("Random 10: " + checkEqual(expected, actual));
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

    public static String checkEqual(String actual, String expected) {
        return actual.compareTo(expected) == 0 ? "Test Pass" : "Test Failed";
    }
}
