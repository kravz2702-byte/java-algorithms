public class FindPairs {
    public static void main(String[] args) {
        String[] str = {"ac", "ca"};
        System.out.println(maximumNumberOfPairs(str));
    }

    static int maximumNumberOfPairs(String[] words){
        int count = 0;
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if(new StringBuilder(word1).reverse().toString().equals(word2)){
                    count++;
                }
            }
        }
        return count;
    }
}
