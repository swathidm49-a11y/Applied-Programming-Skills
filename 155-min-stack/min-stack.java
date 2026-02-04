import java.util.*;

class MinStack {
    Stack<int[]> s = new Stack<>();

    public void push(int x) {
        if (s.isEmpty()) s.push(new int[]{x, x});
        else s.push(new int[]{x, Math.min(x, s.peek()[1])});
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
    }
}

 