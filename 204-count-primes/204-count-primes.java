class Solution {
    public int countPrimes(int n) {
        
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == true) { // if i is true, i.e, i is prime 
                // then its multiples are not prime
                for (int j = i * i; j < n; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        
        int count = 0;
        // count the prime numbers from prime[]
        for (int i = 2; i < n; i++) {
            if (prime[i] == true)
                count++;
        }
        return count;
    }
}