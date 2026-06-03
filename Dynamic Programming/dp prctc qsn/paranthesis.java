public class paranthesis {
    static int count = 0;

    public static void pp(int n, int open, int close, String str) {
        if (str.length() == 2 * n) {
            System.out.println(str);
            count++;
            return;
        }
        if (open < n) {
            pp(n, open + 1, close, str + "{");
        }
        if (close < open) {
            pp(n, open, close + 1, str + "}");
        }
    }

    public static void main(String args[]) {
        int n = 6;
        pp(n, 0, 0, "");
        System.out.println(count);
    }
}
