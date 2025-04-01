import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class sumOfValuesAtIndicesWithKSetBits {
    public static void main(String[] args) {
        Integer[] arr = {5,10,1,5,2};
        int k = 1;
        List<Integer> integerList = Arrays.asList(arr);
        List<String> binaryList = new ArrayList<>();
        List<Integer> listOfIndecies = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < integerList.size(); i++) {
            binaryList.add(Integer.toBinaryString(i));
        }
        for (int i = 0; i < binaryList.size(); i++) {
            if (countCharOccurenceStream(binaryList.get(i), k)) {
                listOfIndecies.add(i);
            }
        }
        for (int i = 0; i < listOfIndecies.size(); i++) {
            sum+=integerList.get(listOfIndecies.get(i));
        }
        System.out.println(sum);
    }

    static boolean countCharOccurenceStream(String str, int k) {
        long count = str.chars().filter(ch -> ch=='1').count();
        return count == k;
    }
}
