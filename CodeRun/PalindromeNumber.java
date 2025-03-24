import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number < 0 || (number != 0 && number % 10 == 0)){
            System.out.println(false);
            return;
        }

        int originalNum = number;
        int reversedNum = 0;

        while (number > reversedNum) {
            reversedNum = reversedNum * 10 + number % 10;
            System.out.println("reversedNum: " + reversedNum);
            number /= 10;
            System.out.println("Number: " + number);
        }

        System.out.println(number == reversedNum || number == reversedNum / 10);
    }
}