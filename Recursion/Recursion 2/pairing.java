public class pairing {
    public static int pair(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int staySingle = pair(n - 1);
        int ifPaired = pair(n - 2);
        int ttlIfPaired = (n - 1) * ifPaired;
        return staySingle + ttlIfPaired;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(pair(n));
    }
}