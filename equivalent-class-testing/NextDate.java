public class NextDate {
    public static void main(String[] args) {
        //System.out.println("Example:\nInput Date: 10/31/2019\nNext Day: " + nextDate(10, 31, 2019));
        //String expected = "11/01/2019";
        //String actual = nextDate(10, 31, 2019);
        //System.out.println("Example:\nInput Date: 10/31/2019\nNext Day: " + actual);
        //System.out.println(checkEqual(actual, expected));
        String random1 = "10/15/1996";
        String randomActual1 = nextDate(10,14,1996);
        System.out.println("Random 1: " + checkEqual(random1, randomActual1));
        String random2 = "01/01/2000";
        String randomActual2 = nextDate(12,31,1999);
        System.out.println("Random 2: " + checkEqual(random2,randomActual2));
        String random3 = "Invalid Date Input.";
        String randomActual3 = nextDate(12,31,1899);
        System.out.println("Random 3: " + checkEqual(random3,randomActual3));
        String random4 = "05/31/1985";
        String randomActual4 = nextDate(5,30,1985);
        System.out.println("Random 4: " + checkEqual(random4,randomActual4));
        String random5 = "Invalid Date Input.";
        String randomActual5 = nextDate(2,29,1965);
        System.out.println("Random 5: " + checkEqual(random5,randomActual5));
        String random6 = "01/01/2100";
        String randomActual6 = nextDate(12,31,2099);
        System.out.println("Random 6: " + checkEqual(random6,randomActual6));
        String random7 = "09/01/1996";
        String randomActual7 = nextDate(8,31,1996);
        System.out.println("Random 7: " + checkEqual(random7,randomActual7));
        String random8 = "Invalid Date Input.";
        String randomActual8 = nextDate(6,9,6969);
        System.out.println("Random 8: " + checkEqual(random8,randomActual8));
        String random9 = "Invalid Date Input.";
        String randomActual9 = nextDate(4,20,420);
        System.out.println("Random 9: " + checkEqual(random9,randomActual9));
        String random10 = "02/28/2019";
        String randomActual10 = nextDate(2,27,2019);
        System.out.println("Random 10: " + checkEqual(random10,randomActual10));
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

