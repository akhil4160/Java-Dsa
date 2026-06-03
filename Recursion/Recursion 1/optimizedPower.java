public class optimizedPower {
    public static int optimizedHalfPwr(int a, int n) {
        if(n==0){
            return 1;
        }
        int hp = optimizedHalfPwr(a, n/2);
        int halfPwrSqr = hp*hp;

        if(n%2 != 0) {
            return a * halfPwrSqr;
        }
        return halfPwrSqr;
    }
    public static void main(String args[]) {
        System.out.println(optimizedHalfPwr(10, 5));
    }
}
