public class NextDate {
    public static void main(String[] args) {
        equivalentClassTesting();
        boundaryTesting();
        randomTesting();
    }

    // Equivalent Class Testing
    public static void equivalentClassTesting() {
        // M1 / D3 / Y3
        String actual = nextDate(3, 30, 2017);
        String expected = "03/31/2017";
        System.out.println("Equivalent 1: " + checkEqual(actual, expected));

        // M1 / D4 / Y3
        actual = nextDate(3, 31, 2017);
        expected = "04/01/2017";
        System.out.println("Equivalent 2: " + checkEqual(actual, expected));

        // M2 / D3 / Y3
        actual = nextDate(4, 30, 2017);
        expected = "05/01/2017";
        System.out.println("Equivalent 3: " + checkEqual(actual, expected));

        // M2 / D4 / Y3
        actual = nextDate(4, 31, 2017);
        expected = "Invalid Date Input.";
        System.out.println("Equivalent 4: " + checkEqual(actual, expected));

        // M3 / D1 / Y1
        actual = nextDate(2, 28, 2016);
        expected = "02/29/2016";
        System.out.println("Equivalent 5: " + checkEqual(actual, expected));

        // M3 / D2 / Y1
        actual = nextDate(2, 29, 2016);
        expected = "03/01/2016";
        System.out.println("Equivalent 6: " + checkEqual(actual, expected));

        // M3 / D1 / Y3
        actual = nextDate(2, 28, 2017);
        expected = "03/01/2017";
        System.out.println("Equivalent 7: " + checkEqual(actual, expected));

        // M3 / D2 / Y3
        actual = nextDate(2, 29, 2017);
        expected = "Invalid Date Input.";
        System.out.println("Equivalent 8: " + checkEqual(actual, expected));

        // M3 / D2 / Y2
        actual = nextDate(2, 29, 2000);
        expected = "03/01/2000";
        System.out.println("Equivalent 9: " + checkEqual(actual, expected));

        // M3 / D3 / Y2
        actual = nextDate(2, 30, 2000);
        expected = "Invalid Date Input.";
        System.out.println("Equivalent 10: " + checkEqual(actual, expected));
    }

    // Boundary testing
    public static void boundaryTesting() {
        // M1
        System.out.println("M1 test: " + checkEqual(nextDate(6, 29, 2016), "06/30/2016"));
        // M2
        System.out.println("M2 test: " + checkEqual(nextDate(7, 31, 2016), "08/01/2016"));
        // M3 has 28 days
        System.out.println("M3(28 days) test: " + checkEqual(nextDate(2, 28, 2001), "03/01/2001"));
        // M3 has 29 days
        System.out.println("M3(29 days) test: " + checkEqual(nextDate(2, 28, 2016), "02/29/2016"));
        // M3 invalid date
        System.out.println("M3(invalid date) test: " + checkEqual(nextDate(2, 30, 2005), "Invalid Date Input."));
        // D1 left bound
        System.out.println("D1(left bound) test: " + checkEqual(nextDate(2, 1, 2011), "02/02/2011"));
        // D1 right bound
        System.out.println("D1(right bound) test: " + checkEqual(nextDate(2, 28, 2013), "03/01/2013"));
        // D1 just above left bound
        System.out.println("D1(jsut above left bound) test: " + checkEqual(nextDate(2, 2, 2014), "02/03/2014"));
        // D1 just below right bound
        System.out.println("D1(just below right bound) test: " + checkEqual(nextDate(2, 27, 2015), "02/28/2015"));
        // D1 out of left bound
        System.out.println("D1(out of left bound) test: " + checkEqual(nextDate(2, 0, 2002), "Invalid Date Input."));
        // D1 out of right bound
        System.out.println("D1(out of right bound) test: " + checkEqual(nextDate(2, 29, 2013), "Invalid Date Input."));
        // D2
        System.out.println("D2 test: " + checkEqual(nextDate(2, 29, 2012), "03/01/2012"));
        // D3
        System.out.println("D3 test: " + checkEqual(nextDate(9, 30, 2019), "10/01/2019"));
        // D4
        System.out.println("D4 test: " + checkEqual(nextDate(1, 31, 2020), "02/01/2020"));
        // Y1
        System.out.println("Y1 test: " + checkEqual(nextDate(02, 28, 2000), "02/29/2000"));
        // Y2: Divisible by 400 and 4
        System.out.println("Y2(divisible by 400 and 4) test: " + checkEqual(nextDate(2, 28, 2000), "02/29/2000"));
        // Y2: Divisible by only 4
        System.out.println("Y2(divisible by only 4) test: " + checkEqual(nextDate(2, 28, 2012), "02/29/2012"));
        // Y3
        System.out.println("Y3 test: " + checkEqual(nextDate(2, 28, 2021), "03/01/2021"));
    }

    // Random Testing
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
