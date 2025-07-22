class Solution {
    int cntCoprime(int[] arr) {
        // code here
        int MAX = 10001;
        int[] freq = new int[MAX];
        for (int val : arr) {
            freq[val]++;
        }

        // Count how many numbers are divisible by i
        int[] divisibleCount = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                divisibleCount[i] += freq[j];
            }
        }

        // Compute Mobius function mu
        int[] mu = new int[MAX];
        java.util.Arrays.fill(mu, 1);
        boolean[] prime = new boolean[MAX];
        java.util.Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < MAX; i++) {
            if (prime[i]) {
                for (int j = i; j < MAX; j += i) {
                    prime[j] = false;
                    mu[j] = -mu[j];
                }
                long square = (long) i * i;
                for (long j = square; j < MAX; j += square) {
                    mu[(int) j] = 0;
                }
            }
        }

        long result = 0L;
        for (int d = 1; d < MAX; d++) {
            int c = divisibleCount[d];
            if (c >= 2 && mu[d] != 0) {
                result += (long) mu[d] * (long) c * (c - 1) / 2;
            }
        }

        return (int) result;
        
    }
}
