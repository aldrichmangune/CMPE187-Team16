public class CalculateCuboid {

    public static void main(String[] args) {
        int expected;
        int actual;

        //test for correct input
        System.out.println("Test 1: test for correct input");
        expected = 0;
        actual = calculateCuboid("4", "50", "8");
        checkEquality(expected, actual);

        //test for negative input
        System.out.println("\nTest 2: test for negative input");
        expected = -1;
        actual = calculateCuboid("-4", "50", "8");
        checkEquality(expected, actual);

        //test for zero input
        System.out.println("\nTest 3: test for zero input");
        expected = -1;
        actual = calculateCuboid("90", "0", "8");
        checkEquality(expected, actual);

        //test for String input
        System.out.println("\nTest 4: test for String input");
        expected = -1;
        actual = calculateCuboid("90", "50", "asd");
        checkEquality(expected, actual);

        /* From this point all error inputs are already handled */
        //test arranging values
        System.out.println("\nTest 5: test arranging values:");
        int[] arr = arrangeValue(20, 70, 68);
        expected = 20;
        actual = arr[0];
        checkEquality(expected, actual);
        expected = 68;
        actual = arr[1];
        checkEquality(expected, actual);
        expected = 70;
        actual = arr[2];
        checkEquality(expected, actual);

        //test return value of getArea function
        System.out.println("\nTest 6: test getArea():");
        expected = 1360;
        actual = getArea(arr[0], arr[1]);
        checkEquality(expected, actual);

        //test return value of getVolume function
        System.out.println("\nTest 7: test getVolume():");
        expected = 70;
        actual = getVolume(5, 2, 7);
        checkEquality(expected, actual);

    }
    //receive 3 inputs then compute and print out results for:
    //Longest edge, shortest edge, area of two short edges, and volume of the cuboid
    public static int calculateCuboid(String l, String w, String h) {
        try {
            int length = Integer.parseInt(l);   //convert String input into Integer
            int width = Integer.parseInt(w);    //throw exception when the input is not match
            int height = Integer.parseInt(h);   //then return -1

            if (length <= 0 || width <= 0 || height <= 0) { //check whether one of the inputs is zero or negative
                System.out.println("Input must be non zero and positive value.");//print out error message
                return -1;                                                       //then return -1
            }
            int[] arr = arrangeValue(length, width, height);    //sort 3 inputs
            int longestEdge = arr[2];                           //find longest edge
            int shortestEdge = arr[0];                          //find shortest edge
            int area = getArea(arr[0], arr[1]);                 //find surface area of 2 short edges
            int volume = getVolume(length, width, height);      //find volume

            System.out.println("Length: " + length + ", Width: " + width + ", Height: " + height);
            System.out.println("Longest Edge: " + longestEdge);
            System.out.println("Shortage Edge: " + shortestEdge);
            System.out.println("Area from short edges: " + area);
            System.out.println("Volume: " + volume);

        } catch (NumberFormatException ex) {
            System.out.println("Input must be integer value.");
            return -1;
        }
        return 0;   //return 0 when the function executes successfully
    }

    //the function will sort 3 values in descending order
    public static int[] arrangeValue(int l, int w, int h){
        int[] arr = {l, w, h};
        int temp;
        if(arr[1] < arr[0]){
            temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        if(arr[2] < arr[1]){
            temp = arr[1];
            arr[1] = arr[2];
            arr[2] = temp;
        }
        if(arr[1] < arr[0]){
            temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        return arr;
    }

    //compute and return the surface area
    public static int getArea(int e1, int e2) {
        return e1 * e2;
    }

    //compute and return the volume
    public static int getVolume(int l, int w, int h) {
        return l * w * h;
    }

    public static void checkEquality(int actual, int expected){
        System.out.println(actual == expected ? "Passed" : "Failed");
    }

}
