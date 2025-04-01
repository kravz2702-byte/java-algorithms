import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    private List<Integer> stack;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayList<Integer>();
    }

    public void push(int value) {
        if(stack.size() < maxSize) {
            stack.add(value);
        }
    }

    public int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.remove(stack.size()-1);
    }

    public void increment(int k, int val){
        int incrementCount = Math.min(k, stack.size());
        for (int i = 0; i < incrementCount; i++) {
            stack.set(i, stack.get(i) + val);
        }
    }
}
