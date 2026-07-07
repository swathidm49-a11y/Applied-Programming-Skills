class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }
        long x = 0;
        long sum = 0;
        long place = 1;
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                sum += digit;
                x = digit * place + x;
                place *= 10;
            }
            n /= 10;
        }
        return x * sum;
    }
}