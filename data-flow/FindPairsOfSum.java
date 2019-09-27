public class FindPairsOfSum {

    public static void main(String[] args) {
        /*Assume the array is given, and the only input from the user is K*/
        int[] givenArr = {1, 2, 7, 11, 6, 9, 5};
        String K = "12";
        System.out.println("Example solution: " + findPairs(givenArr, K) + "\n");

        testCases();
    }

    public static void testCases() {
        System.out.format("%s%16s%60s\n", "Test Case", "Expected", "Actual");
        // Blank Array
        String expected = "None of integer pairs that make the sum equal to 12.";
        int[] testArr1 = {};
        String testK = "12";
        System.out.format("%s%58s%62s\n", "Blank Array", expected, findPairs(testArr1, testK));

        // No pairs in the Array
        expected = "None of integer pairs that make the sum equal to 12.";
        int[] testArr2 = {1, 4, 5, 6, 3, 2};
        testK = "12";
        System.out.format("%s%55s%62s\n", "No valid pairs", expected, findPairs(testArr2, testK));

        // Blank K
        expected = "Input must be an Integer.";
        int[] testArr3 = {1, 2, 7, 11, 6, 9, 5};
        testK = "";
        System.out.format("%s%35s%61s\n", "Blank K", expected, findPairs(testArr3, testK));

        // Double K
        expected = "Input must be an Integer.";
        int[] testArr4 = {1, 2, 7, 11, 6, 9, 5};
        testK = "12.0";
        System.out.format("%s%29s%61s\n", "K is a double", expected, findPairs(testArr4, testK));

        // K is a character/string
        expected = "Input must be an Integer.";
        int[] testArr5 = {-1, 2, 7, -11, 6, 9, 5};
        testK = "This is not an integer";
        System.out.format("%s%29s%61s\n", "K is a string", expected, findPairs(testArr5, testK));

        // Negative K
        expected = "(-1, -11).";
        int[] testArr6 = {-1, 2, 7, -11, 6, 9, 5};
        testK = "-12";
        System.out.format("%s%17s%61s\n", "Negative K", expected, findPairs(testArr6, testK));

        // 2 valid Pairs
        expected = "(1, 4),(2, 3).";
        int[] testArr7 = {1, 4, 7, 11, 6, 9, 5, 2, 3};
        testK = "5";
        System.out.format("%s%18s%60s\n", "2 Valid pairs", expected, findPairs(testArr7, testK));
    }

    public static String findPairs(int[] givenArr, String K) {                      //(1)(2)
        String s = "";                                                              //(3)
        try {
            int sum = Integer.parseInt(K);                                          //(4)
            int[] myArr = new int[givenArr.length];
            System.arraycopy(givenArr, 0, myArr, 0, myArr.length);                  //(5)
            int size = myArr.length;                                                //(6)
            for (int i = 0; i < size; i++) {                                        //(7)(8)(19)
                int firstNum = myArr[i];                                            //(9)
                for (int j = i + 1; j < size; j++) {                                //(10)(11)(18)
                    int secondNum = myArr[j];                                       //(12)
                    int result = firstNum + secondNum;                              //(13)
                    if (result == sum) {                                            //(14)
                        s += "(" + firstNum + "," + secondNum + "),";               //(15)
                        myArr[j] = myArr[size - 1];                                 //(16)
                        size--;                                                     //(17)
                    }
                }
            }
            if (s.isEmpty()) {                                                      //(20)
                s = "None of integer pairs that make the sum equal to " + K + ".";  //(21)
            }
        } catch (NumberFormatException ex) {
            return "Input must be an Integer";                                      //(23)
        }
        return s.substring(0, s.length() - 1) + ".";                                //(22)
    }

}
