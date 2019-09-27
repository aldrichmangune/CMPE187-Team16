public class FindPairsOfSum {

    public static void main(String[] args) {
        /*Assume the array is given, and the only input from the user is K*/
        int[] givenArr = {1, 2, 7, 11, 6, 9, 5};
        String K = "12";
        System.out.println(findPairs(givenArr, K));
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
                s = "Non of integer pairs that make the sum equal to " + K + ".";   //(21)
            }
        } catch (NumberFormatException ex) {
            return "Input must be an Integer";                                      //(23)
        }
        return s.substring(0, s.length() - 1) + ".";                                //(22)
    }

}
