import java.util.*;

class StockSpanner {
    Stack<int[]> s = new Stack<>();

    public int next(int p) {
        int c = 1;
        while (!s.isEmpty() && s.peek()[0] <= p)
            c += s.pop()[1];
        s.push(new int[]{p, c});
        return c;
    }
}
