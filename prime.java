public class prime {
    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Specific 20-bit and 40-bit numbers
        int prime20Bit = 524287;   // 2^19 - 1
        int nonPrime20Bit = 524288; // 2^19
        long prime40Bit = 549755813887L;   // 2^39 - 1
        long nonPrime40Bit = 549755813888L; // 2^39

        // Test for 20-bit numbers
        long start20 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            isPrime(prime20Bit);
            isPrime(nonPrime20Bit);
        }
        long end20 = System.nanoTime();
        System.out.println("Time for 10000 tests of 20-bit numbers: " + (end20 - start20) / 1_000_000.0 + " ms");

        // Test for 40-bit numbers
        long start40 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            isPrime(prime40Bit);
            isPrime(nonPrime40Bit);
        }
        long end40 = System.nanoTime();
        System.out.println("Time for 10000 tests of 40-bit numbers: " + (end40 - start40) / 1_000_000.0 + " ms");
    }
}