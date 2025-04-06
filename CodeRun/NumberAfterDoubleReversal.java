import java.util.Scanner;

public class NumberAfterDoubleReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isSameAfterReversals(num));
    }

    public static boolean isSameAfterReversals(int num) {
        String numStr = String.valueOf(num);
        Integer reversed1 = Integer.parseInt(new StringBuilder(numStr).reverse().toString());
        Integer reversed2 = Integer.parseInt(new StringBuilder(reversed1.toString()).reverse().toString());
        return  reversed2==num;
    }

//    Best solution
//    public static boolean isSameAfterReversals(int num) {
//        return num == 0 || num % 10 != 0;
//    }

}
