public class NextDate {

    public static void main(String[] args) {
        String nextDate = nextDate(10, 30, 2019);
        System.out.println(nextDate);
    }

    public static String nextDate(int month, int day, int year) {
        if (day < 1 || day > daysInMonth(month, year) || month < 1 || month > 12 || year < 1900 || year > 2100) {
            return "Invalid Date Input.";
        }
        if (day < daysInMonth(month, year)) {
            day++;
        } else {
            day = 1;
            if (month < 12) {
                month++;
            } else {
                month = 1;
                year++;
            }
        }
        return displayNextDate(month, day, year);
    }

    public static int daysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return isLeap(year) ? 29 : 28;
        }
        return 0;
    }

    public static boolean isLeap(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static String displayNextDate(int month, int day, int year) {
        String strMonth = Integer.toString(month);
        if (strMonth.length() < 2) {
            strMonth = "0" + strMonth;
        }
        String strDay = Integer.toString(day);
        if (strDay.length() < 2) {
            strDay = "0" + strDay;
        }
        return strMonth + "/" + strDay + "/" + Integer.toString(year);
    }

}