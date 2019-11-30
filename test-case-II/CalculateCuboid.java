public class CalculateCuboid {

    public static void main(String[] args) {
        // Test cases
        String actual = calculateCuboid("asd", "5", "6");// Control, Data, Domain
        String expected = errorMsg();
        checkEquality(actual, expected);

        actual = calculateCuboid("4", "5", "-123");// Control, Data, Domain
        expected = errorMsg();
        checkEquality(actual, expected);

        actual = calculateCuboid("4", "5", "6");// Control, Data
        expected = output(4, 6, 20, 120);
        checkEquality(actual, expected);

        actual = calculateCuboid("6", "5", "4");// Control
        expected = output(4, 6, 20, 120);
        checkEquality(actual, expected);

        actual = calculateCuboid("5", "4", "6");// Control
        expected = output(4, 6, 20, 120);
        checkEquality(actual, expected);

        actual = calculateCuboid("4", "5", "1");// Domain
        expected = output(1, 5, 4, 20);
        checkEquality(actual, expected);

        actual = calculateCuboid("0", "5", "6");// Domain
        expected = errorMsg();
        checkEquality(actual, expected);

        actual = calculateCuboid("4", "50", "8");// random
        expected = output(4, 50, 32, 1600);
        checkEquality(actual, expected);

        actual = calculateCuboid("123", "45", "90");// random
        expected = output(45, 123, 4050, 498150);
        checkEquality(actual, expected);
    }

    // receive 3 inputs then compute and print out results for:
    // Longest edge, shortest edge, area of two short edges, and volume
    public static String calculateCuboid(String l, String w, String h) {
        int[] arr = inputHandling(l, w, h);
        if (arr == null) {
            return errorMsg(); // error message
        }
        simpleSort(arr); // sort array in increasing order
        int shortestEdge = arr[0]; // shortest edge
        int longestEdge = arr[2]; // longest edge
        int area = arr[0] * arr[1]; // surface area of 2 short edges
        int volume = arr[0] * arr[1] * arr[2]; // find volume

        return output(shortestEdge, longestEdge, area, volume); // return String of output
    }

    public static int[] inputHandling(String l, String w, String h) {
        int[] intArr = new int[3];
        try {
            intArr[0] = Integer.parseInt(l); // convert String input into Integer
            intArr[1] = Integer.parseInt(w); // throw exception when the input is not match
            intArr[2] = Integer.parseInt(h);
            if (intArr[0] <= 0 || intArr[1] <= 0 || intArr[2] <= 0) { // one or more inputs are zero and/or negative
                return null;
            }
            return intArr;
        } catch (NumberFormatException ex) { // one of inputs is non-integer value
            return null;
        }
    }

    // the function will sort 3 values in increasing order
    public static void simpleSort(int[] arr) {
        if (arr[1] < arr[0]) {
            swap(arr, 0, 1);
        }
        if (arr[2] < arr[1]) {
            swap(arr, 1, 2);
        }
        if (arr[1] < arr[0]) {
            swap(arr, 0, 1);
        }
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    // output as an error message
    public static String errorMsg() {
        return "Input must be non-zero and positive integer values.";
    }

    // output with correct result
    public static String output(int shortestEdge, int longestEdge, int area, int volume) {
        return "Shortage Edge: " + shortestEdge + "\nLongest Edge: " + longestEdge + "\nArea from short edges: " + area
                + "\nVolume: " + volume;
    }

    public static void checkEquality(String actual, String expected) {
        System.out.println(actual.compareTo(expected) == 0 ? "Passed" : "Failed");
    }

}