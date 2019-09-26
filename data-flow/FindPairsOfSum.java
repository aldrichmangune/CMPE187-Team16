public class FindPairsOfSum {

    public static void main(String[] args) {
        int[] givenArr = {1, 2, 7, 11, 6, 9, 5};
        String K = "12";
        System.out.println(findPairs(givenArr, K));
    }

    public static String findPairs(int[] givenArr, String K) {
        String s = "";
        try {
            int sum = Integer.parseInt(K);
            int[] myArr = new int[givenArr.length];
            System.arraycopy(givenArr, 0, myArr, 0, myArr.length);
            int arrSize = myArr.length;
            for (int i = 0; i < arrSize; i++) {
                int firstNumb = myArr[i];
                for (int j = i + 1; j < arrSize; j++) {
                    int secondNumb = myArr[j];
                    if ((firstNumb + secondNumb) == sum) {
                        s += "(" + firstNumb + "," + secondNumb + "),";
                        myArr[j] = myArr[arrSize-1];
                        arrSize--;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            return "Input must be an Integer";
        }
        if(s.isEmpty()){
            s = "Non of integer pairs that make the sum equal to "+K+".";
        }
        return s.substring(0, s.length()-1) + ".";
    }

}
