class MyCircularDeque {
    int[] a;
    int f = 0, r = 0, c = 0, n;

    public MyCircularDeque(int k) {
        n = k;
        a = new int[k];
    }

    public boolean insertFront(int v) {
        if (isFull()) return false;
        f = (f - 1 + n) % n;
        a[f] = v;
        c++;
        return true;
    }

    public boolean insertLast(int v) {
        if (isFull()) return false;
        a[r] = v;
        r = (r + 1) % n;
        c++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        f = (f + 1) % n;
        c--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        r = (r - 1 + n) % n;
        c--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : a[f];
    }

    public int getRear() {
        return isEmpty() ? -1 : a[(r - 1 + n) % n];
    }

    public boolean isEmpty() {
        return c == 0;
    }

    public boolean isFull() {
        return c == n;
    }
}
