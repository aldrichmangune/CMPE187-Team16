public class Fibonacci {
    public static int fibonacciSeries(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacciSeries(n-2) + fibonacciSeries(n-1);
    }
    public static void main(String args[]) {
        int maxNumber = 5;
        System.out.print("Fibonacci Series of "+maxNumber+" numbers: ");
        for(int i = 0; i < maxNumber; i++){
            System.out.print(fibonacciSeries(i) +" ");
        }
    }
}
