class MyCircularQueue {
    int[] a;
    int f = 0, r = 0, c = 0, n;

    public MyCircularQueue(int k) {
        n = k;
        a = new int[k];
    }

    public boolean enQueue(int v) {
        if (isFull()) return false;
        a[r] = v;
        r = (r + 1) % n;
        c++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        f = (f + 1) % n;
        c--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : a[f];
    }

    public int Rear() {
        return isEmpty() ? -1 : a[(r - 1 + n) % n];
    }

    public boolean isEmpty() {
        return c == 0;
    }

    public boolean isFull() {
        return c == n;
    }
}

    
   