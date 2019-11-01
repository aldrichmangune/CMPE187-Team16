public class NextDate {

    public static void main(String[] args) {
        equivalentClassTesting();
    }

    public static void equivalentClassTesting() {
        // Month: has 31 days, day: 30, year: common
        String actual = nextDate(3, 30, 2017);
        String expected = "03/31/2017";
        System.out.println("Equivalent 1: " + checkEqual(actual, expected));

        // Month: has 31 days, day: 31, year: common
        actual = nextDate(3, 31, 2017);
        expected = "04/01/2017";
        System.out.println("Equivalent 2: " + checkEqual(actual, expected));

        // Month: has 30 days, day: 30, year common
        actual = nextDate(4, 30, 2017);
        expected = "05/01/2017";
        System.out.println("Equivalent 3: " + checkEqual(actual, expected));

        // Month: has 30 days, day: 31, year: common
        actual = nextDate(4, 31, 2017);
        expected = "Invalid Date Input.";
        System.out.println("Equivalent 4: " + checkEqual(actual, expected));

        // Month: has 29 days, day: 28, year: leap-every 4 years
        actual = nextDate(2, 28, 2016);
        expected = "02/29/2016";
        System.out.println("Equivalent 5: " + checkEqual(actual, expected));

        // Month: has 29 days, day: 29, year: leap-every 4 years
        actual = nextDate(2, 29, 2016);
        expected = "03/01/2016";
        System.out.println("Equivalent 6: " + checkEqual(actual, expected));

        // Month: has 28 days, day: 28, year: common
        actual = nextDate(2, 28, 2017);
        expected = "03/01/2017";
        System.out.println("Equivalent 7: " + checkEqual(actual, expected));

        // Month: has 28 days, day: 29, year: common
        actual = nextDate(2, 29, 2017);
        expected = "Invalid Date Input.";
        System.out.println("Equivalent 8: " + checkEqual(actual, expected));

        // Month: has 29 days, day: 29, year: leap-divisible by 4
        actual = nextDate(2, 29, 2000);
        expected = "03/01/2000";
        System.out.println("Equivalent 9: " + checkEqual(actual, expected));

        // Month: has 29 days, day: 30, year: leap-divisible by 4
        actual = nextDate(2, 30, 2000);
        expected = "Invalid Date Input.";
        System.out.println("Equivalent 10: " + checkEqual(actual, expected));
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