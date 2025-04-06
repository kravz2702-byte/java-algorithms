import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfSquares {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[]{2,7,1,19,18,3}));
    }

    public static int sumOfSquares(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(len % (i+1) == 0) {
                sum += nums[i]*nums[i];
            }
        }
        return sum;
    }

//    Best solution
//    public int sumOfSquares(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//
//        // Check if i is a divisor of the array length n
//        for (int i = 1; i <= nums.length; i++) {
//            if (n % i == 0) {
//                ans += nums[i - 1] * nums[i - 1];
//            }
//        }
//
//        return ans;
//    }

}


